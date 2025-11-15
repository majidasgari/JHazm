JHazm
=====

[![Build and Test](https://github.com/majidasgari/JHazm/actions/workflows/build.yml/badge.svg)](https://github.com/majidasgari/JHazm/actions/workflows/build.yml)
[![Java](https://img.shields.io/badge/Java-21-blue.svg)](https://www.oracle.com/java/)
[![Maven Central](https://img.shields.io/badge/Maven-v1.0.0-orange.svg)](https://maven.apache.org/)
[![License](https://img.shields.io/badge/License-Apache%202.0-green.svg)](LICENSE)

A Java version of [Hazm](https://github.com/sobhe/hazm) (Python library for digesting Persian text)

+ Text cleaning
+ Sentence and word tokenizer
+ Word lemmatizer
+ POS tagger
+ Dependency parser
+ Corpus readers for [Hamshahri](http://ece.ut.ac.ir/dbrg/hamshahri/) and [Bijankhan](http://ece.ut.ac.ir/dbrg/bijankhan/)

* You can download [pre-trained tagger and parser models](http://dl.dropboxusercontent.com/u/90405495/resources.zip) for persian and put these models in the `core/src/main/resources` folder of your project.

# Dependencies
You must install [this module](https://github.com/majidasgari/text_utils) with maven.

# Installation

## Using as Maven Dependency

Add this dependency to your `pom.xml`:

```xml
<dependency>
    <groupId>ir.ac.iust.nlp</groupId>
    <artifactId>jhazm</artifactId>
    <version>1.0.0</version>
</dependency>
```

**Note:** If the artifact is not available in Maven Central, you can use JitPack:

1. Add JitPack repository to your `pom.xml`:
```xml
<repositories>
    <repository>
        <id>jitpack.io</id>
        <url>https://jitpack.io</url>
    </repository>
</repositories>
```

2. Add the dependency:
```xml
<dependency>
    <groupId>com.github.majidasgari</groupId>
    <artifactId>JHazm</artifactId>
    <version>master-SNAPSHOT</version>
</dependency>
```

## Building from Source

For using this project as library in maven just use:
```bash
mvn clean install
```

## Running the JAR

To make a single jar file run this command:

```bash
mvn clean compile assembly:single
```

To run and see the help:
```bash
java -jar target/jhazm-jar-with-dependencies.jar
```

For example to do POS Tag on bundled sample file use:
```bash
java -jar target/jhazm-jar-with-dependencies.jar -a partOfSpeechTagging -o test.txt
```

Or to run on any other file:
```bash
java -jar target/jhazm-jar-with-dependencies.jar -a partOfSpeechTagging -o test.txt -i input.txt
```

Or on some piece of text:
```bash
java -jar target/jhazm-jar-with-dependencies.jar -a partOfSpeechTagging -o test.txt -t "سلام من خوب هستم!"
```

# Requirements

- Java 21 or higher
- Maven 3.6+

Good Luck!
