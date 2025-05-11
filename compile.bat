@echo off
setlocal enabledelayedexpansion

REM Set directories
set "CURRENT_DIR=%~dp0"
set "LIB_DIR=%CURRENT_DIR%src\lib"
set "SRC_DIR=%CURRENT_DIR%src"
set "OUT_DIR=%CURRENT_DIR%out"

REM Check if ANTLR JAR exists
if not exist "%LIB_DIR%\antlr-4.13.2-complete.jar" (
    echo ERROR: ANTLR JAR not found at %LIB_DIR%\antlr-4.13.2-complete.jar
    pause
    exit /b 1
)

REM Create output directory if it does not exist
if not exist "%OUT_DIR%" mkdir "%OUT_DIR%"

echo Compiling project...
echo Classpath: %LIB_DIR%\antlr-4.13.2-complete.jar;%OUT_DIR%

REM Clean output folder
if exist "%OUT_DIR%" (
    del /Q "%OUT_DIR%\*.*"
)

REM Compile ANTLR generated files first
echo Compiling ANTLR files...
javac -Xlint:unchecked -cp "%LIB_DIR%\antlr-4.13.2-complete.jar" -d "%OUT_DIR%" "%SRC_DIR%\MOCLexer.java" "%SRC_DIR%\MOCParser.java" "%SRC_DIR%\MOCBaseListener.java" "%SRC_DIR%\MOCListener.java" "%SRC_DIR%\MOCBaseVisitor.java" "%SRC_DIR%\MOCVisitor.java"

if %errorlevel% neq 0 (
    echo ERROR compiling ANTLR files.
    pause
    exit /b %errorlevel%
)

REM Compile remaining source files
echo Compiling remaining files...
javac -Xlint:unchecked -cp "%LIB_DIR%\antlr-4.13.2-complete.jar;%OUT_DIR%" -d "%OUT_DIR%" "%SRC_DIR%\Main.java" "%SRC_DIR%\SemanticAnalyzer.java" "%SRC_DIR%\MOCTACVisitor.java" "%SRC_DIR%\TACGenerator.java" "%SRC_DIR%\TACInstruction.java"

if %errorlevel% neq 0 (
    echo ERROR compiling remaining files.
    pause
    exit /b %errorlevel%
)

echo Compilation finished successfully.

echo.
echo Running program
echo.

REM Run the program with teste1.moc
java -cp "%OUT_DIR%;%LIB_DIR%\antlr-4.13.2-complete.jar" Main testes\exemplo0.moc


echo.
pause

endlocal 