@echo off

set "JarName=jarname" 
set "MainClass=jarclass"
set "KeepSrcOut=false"

CLS
MKDIR "bin"
DEL "bin\%JarName%.jar" /Q /S
RMDIR srcOut /Q /S
Xcopy src srcOut /e/h/c/i
cd srcOut
javac *.java
jar cf "%JarName%.jar" *.class *
jar --update --verbose --file "%JarName%.jar" --main-class "%MainClass%"
copy "%JarName%.jar" "../bin/"
DEL "%JarName%.jar"
cd ../
if "%KeepSrcOut%" == "false" RMDIR srcOut /Q /S
CLS
echo Compilation is done and your "%JarName%.jar" file is ready sir.
java -jar "bin/%JarName%.jar"