@echo off
DEL .\bin\Build.exe
cd go
go build -o ../bin/Build.exe
cd ../
.\bin\Build.exe