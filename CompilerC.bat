@echo off

set "JarName=SuperCalc" 
set "MainClass=main"
set "KeepSrcOut=true"

set "javaDir=E:\Program Files\Java\jdk-13\bin\"
set "experiments=true"

@REM Only works if experiments are enabled
set "javaBaseDir=E:\Program Files\Java"
set "javaJdkVer=jdk-20"



@Rem IMPORTANT DO NOT CHANGE
set "java=%javaBaseDir%\%javaJdkVer%\bin\"

CLS
MKDIR "bin"
DEL "bin\%JarName%.jar" /Q /S
RMDIR srcOut /Q /S
Xcopy src srcOut /e/h/c/i
cd srcOut
if "%experiments%" == "false" "%javaDir%javac" *.java
if "%experiments%" == "false" "%javaDir%jar" cf "%JarName%.jar" *.class *
if "%experiments%" == "false" "%javaDir%jar" --update --verbose --file "%JarName%.jar" --main-class "%MainClass%"

if "%experiments%" == "true" "%java%javac" *.java
if "%experiments%" == "true" "%java%jar" cf "%JarName%.jar" *.class *
if "%experiments%" == "true" "%java%jar" --update --verbose --file "%JarName%.jar" --main-class "%MainClass%"
copy "%JarName%.jar" "../bin/"
DEL "%JarName%.jar"
cd ../
if "%KeepSrcOut%" == "false" RMDIR srcOut /Q /S
CLS
echo Compilation is done and your "%JarName%.jar" file is ready sir.
if "%experiments%" == "false" "%java%java" -jar "bin/%JarName%.jar"

if "%experiments%" == "true" "%java%java" -jar "bin/%JarName%.jar"