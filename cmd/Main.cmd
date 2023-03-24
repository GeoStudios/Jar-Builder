@echo off

@REM set JAVA_COMP = ../binaries/Java/bin/javac.exe
@REM set JAVA_VM = ../binaries/Java/bin/java.exe
@REM set PYTHON = ../binaries/Python/python.exe

echo "[1]: Get Required Libs"
echo "[2]: Build Java"

set /p "id=[?]: "

if %id%==1 "Get Required Libs.cmd"
if %id%==2 "Build.cmd" %PYTHON% %JAVA_COMP% %JAVA_VM%
@REM if %id%==1 "Get Required Libs.cmd"