#!/usr/bin/env bash

#Uniquement la compilation
echo 'Compilation'
./simulateur 2&> /dev/null #Only Compilation

java org.junit.runner.JUnitCore SimulateurTest