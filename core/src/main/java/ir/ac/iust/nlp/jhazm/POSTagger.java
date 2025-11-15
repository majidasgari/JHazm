package ir.ac.iust.nlp.jhazm;

import edu.stanford.nlp.ling.TaggedWord;
import edu.stanford.nlp.tagger.maxent.MaxentTagger;
import ir.ac.iust.nlp.jhazm.utils.FileHandler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Mojtaba Khallash
 */
public class POSTagger {
    private static POSTagger instance;
    private MaxentTagger tagger;

    public POSTagger() throws IOException {
        this("resources/persian.tagger");
    }

    public POSTagger(String pathToModel) throws IOException {
        FileHandler.prepareFile(pathToModel);
        this.tagger = new MaxentTagger(FileHandler.getPath(pathToModel).toFile().getAbsolutePath());
    }

    public static POSTagger i() throws IOException {
        if (instance != null)
            return instance;
        instance = new POSTagger();
        return instance;
    }

    public List<List<TaggedWord>> batchTags(List<List<String>> sentences) {
        List<List<TaggedWord>> result = new ArrayList<>();

        for (List<String> sentence : sentences) {
            result.add(batchTag(sentence));
        }

        return result;
    }

    public List<TaggedWord> batchTag(List<String> sentence) {
        List<edu.stanford.nlp.ling.HasWord> newSent = new ArrayList<>();
        for (int i = 0; i < sentence.size(); i++) {
            String word = sentence.get(i).replace(" ", "_");
            newSent.add(new edu.stanford.nlp.ling.Word(word));
        }
        List taggedSentence = this.tagger.tagSentence(newSent);

        List<TaggedWord> taggedSen = new ArrayList<>();
        for (int i = 0; i < taggedSentence.size(); i++) {
            TaggedWord tw = (TaggedWord) taggedSentence.get(i);
            tw.setWord(sentence.get(i));
            taggedSen.add(tw);
        }
        return taggedSen;
    }
}