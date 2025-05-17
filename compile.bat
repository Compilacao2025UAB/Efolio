@echo off
setlocal enabledelayedexpansion

REM Set directories
set "CURRENT_DIR=%~dp0"
set "LIB_DIR=%CURRENT_DIR%src\lib"
set "SRC_DIR=%CURRENT_DIR%src"
set "OUT_DIR=%CURRENT_DIR%out"

REM Check if ANTLR JAR exists
if not exist "%LIB_DIR%\antlr-4.13.2-complete.jar" (
    echo ERRO: ANTLR JAR nao encontrado em %LIB_DIR%\antlr-4.13.2-complete.jar
    pause
    exit /b 1
)

REM Create output directory if it does not exist
if not exist "%OUT_DIR%" mkdir "%OUT_DIR%"

echo Limpando diretorio de saida...
if exist "%OUT_DIR%" (
    del /Q "%OUT_DIR%\*.*"
)

echo Removendo pasta .antlr se existir...
if exist "%SRC_DIR%\.antlr" (
    rmdir /s /q "%SRC_DIR%\.antlr"
)

echo Gerando ficheiros ANTLR...
java -cp "%LIB_DIR%\antlr-4.13.2-complete.jar" org.antlr.v4.Tool -visitor -listener -package parser -o "%SRC_DIR%\parser" "%SRC_DIR%\MOC.g4"

if %errorlevel% neq 0 (
    echo ERRO ao gerar ficheiros ANTLR.
    pause
    exit /b %errorlevel%
)

echo Compilando ficheiros ANTLR...
javac -Xlint:unchecked -cp "%LIB_DIR%\antlr-4.13.2-complete.jar" -d "%OUT_DIR%" "%SRC_DIR%\parser\MOCLexer.java" "%SRC_DIR%\parser\MOCParser.java" "%SRC_DIR%\parser\MOCBaseListener.java" "%SRC_DIR%\parser\MOCListener.java" "%SRC_DIR%\parser\MOCBaseVisitor.java" "%SRC_DIR%\parser\MOCVisitor.java"

if %errorlevel% neq 0 (
    echo ERRO ao compilar ficheiros ANTLR.
    pause
    exit /b %errorlevel%
)

echo Compilando ficheiros restantes...
javac -Xlint:unchecked -cp "%LIB_DIR%\antlr-4.13.2-complete.jar;%OUT_DIR%" -d "%OUT_DIR%" "%SRC_DIR%\Main.java" "%SRC_DIR%\SemanticAnalyzer.java" "%SRC_DIR%\MOCTACVisitor.java" "%SRC_DIR%\TACGenerator.java" "%SRC_DIR%\TACInstruction.java"

if %errorlevel% neq 0 (
    echo ERRO ao compilar ficheiros restantes.
    pause
    exit /b %errorlevel%
)

echo Compilacao concluida com sucesso.

echo.
echo Executando programa...
echo.

REM Run the program with teste1.moc
java -cp "%OUT_DIR%;%LIB_DIR%\antlr-4.13.2-complete.jar" Main testes\casting.moc

echo.
pause

endlocal 