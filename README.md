# Jar Compiler

### Config
```batch

set "JarName=jarname" 
set "MainClass=jarclass"
set "KeepSrcOut=false"
```

Replace "jarname" with the program name and leave out extentions
and replace "jarclass" with the class that open the program and leave the program to do the rest.

The required objects to make this work are Compiler.bat and the src folder. The program will create and "srcOut" folder with all the compiled files and pack them into a jar while making a bin folder for the jar to stay in. The Jar file will autorun so you can mess with the finished product and check for errors that may occur in the console/terminal.

After the jar is created it will delete the srcOut unless you change the KeepSrcOut to true.