#!/usr/bin/env bash

set -e

EXTENSION_PUBLISHER='com-adobe-coldfusion'
EXTENSION_NAME='adobe-cfml-lsp'
EXTENSION_VERSION='1.0.701'
EXTENSION_URL="https://marketplace.visualstudio.com/_apis/public/gallery/publishers/$EXTENSION_PUBLISHER/vsextensions/$EXTENSION_NAME/$EXTENSION_VERSION/vspackage"
JAR_FILENAME='acf-ls-jar-with-dependencies.jar'
EXTENSION_DIR='extension'
JAR_PATHNAME="$EXTENSION_DIR/lsp/$JAR_FILENAME"

JSON_JAR_VERSION='20250517'
JSON_JAR_URL="https://repo1.maven.org/maven2/org/json/json/$JSON_JAR_VERSION/json-$JSON_JAR_VERSION.jar"

wget --unlink "$JSON_JAR_URL"

wget --unlink "$EXTENSION_URL"
7z x -y vspackage
rm -rf vspackage

7z e -y vspackage\~ $JAR_PATHNAME
7z e -y vspackage\~ extension/default-profiles/default.xml

rm -rf vspackage\~

zip -d $JAR_FILENAME 'META-INF/*.SF' 'META-INF/*.RSA'
