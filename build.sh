#!/usr/bin/env bash

set -e

find . -name "*.class" -type f -delete

javac -cp "./acf-ls-jar-with-dependencies.jar:./json-20250517.jar" src/com/adobe/editor/cfml/parser/generated/CFParse.java src/Main.java

jar cfe cfml_parser.jar Main -C src Main.class -C src com/adobe/editor/cfml/parser/generated/CFParse.class

find . -name "*.class" -type f -delete
