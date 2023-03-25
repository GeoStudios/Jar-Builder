@echo off

echo Removing Previous Build
DEL .\bin\Build.exe

echo Downloading Source
git clone https://github.com/GeoStudios/Primal-Craft
echo Src Downloaded

echo Downloading Resources
cd ./Primal-Craft/src/
git clone https://github.com/GeoStudios/resources.git

echo Compiling Project
cd ../../go
go build -o ../bin/Build.exe

echo Running Build.exe
cd ../
.\bin\Build.exe