#!/bin/bash

# Ejecuta las pruebas con TestNG
mvn test -Dsurefire.suiteXmlFiles=testng.xml || (echo "Tests failed. Exiting..." && exit 1)
