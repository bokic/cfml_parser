#!/usr/bin/env bash

set -e

find src -name "*.class" -type f -delete

javac -cp "./acf-ls-jar-with-dependencies.jar:./json-20250517.jar" src/com/adobe/editor/cfml/parser/generated/CFParse.java src/com/adobe/editor/cfml/parser/generated/CFFormat.java src/Main.java

jar cfe cfml_parser.jar Main -C src Main.class -C src com/adobe/editor/cfml/parser/generated/CFParse.class -C src com/adobe/editor/cfml/parser/generated/CFFormat.class

find src -name "*.class" -type f -delete
