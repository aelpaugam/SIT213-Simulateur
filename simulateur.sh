#!/usr/bin/env bash

BIN='bin/'
DOC='doc/'
SIMTEST="$(find src -name *.java)"

# Compilation du Simulateur
	#Vérif du dossier bin/ - Creation si inexistant
if [-e "$BIN"] 
then
	mkdir -p "$BIN"
fi
	#Compilation des .java dans src/ si on ne trouve pas les .class dans bin/
if [-z "$(find ${BIN} -name '*.class')"]
then
    echo "Compilation des classes"
    javac -encoding UTF-8 -d "$BIN" $SIMTEST
fi

# Generation de la Javadoc
	#Vérif du dossier doc/ - Creation si inexistant
if [-e "$DOC"] 
then
	mkdir -p "$DOC"
fi
	#Creation de Javadoc dans doc/ si les .html ne sont pas déjà présents
if [-z "$(find ${DOC} -name '*.html')"]
then
	echo "Generation de la Javadoc"
	javadoc -encoding UTF-8 -quiet -private -d "$DOC" $SIMTEST
fi

# Lancement de la JVM pour Simulateur, avec les arguments
java Simulateur $@