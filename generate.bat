@echo off
echo Gerando classes do ANTLR...
java -cp antlr-4.13.2-complete.jar org.antlr.v4.Tool -visitor -listener src/MOC.g4

echo Compilando classes...
javac -cp antlr-4.13.2-complete.jar src/*.java

echo Processo concluido! 