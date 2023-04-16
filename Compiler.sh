# Copyright (c) 2023 Geo-Studios - All Rights Reserved.

JarName="JarName"
MainClass="jarclass"
KeepSrcOut=false

javaDir=""

clear
mkdir bin
rm "bin/$JarName.jar"
rm -r srcOut
cp -r src srcOut
cd srcOut
"$javaDir/javac" *.java
"$javaDir/jar" cf "$JarName.jar" *.class *
"$javaDir/jar" --update --verbose --file "$JarName.jar" --main-class "%MainClass%"

cp "$JarName.jar" "../bin/"
rm "$JarName.jar"
cd ../
if [$KeepSrcOut == false]
then
    rm -r srcOut
fi
clear
echo Compilation is done and your "$JarName.jar" is ready sir.

"$javaDir/java" -jar "bin/$JarName.jar"