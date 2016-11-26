# FEUP-MESW-TVVS-MBT
##Lesson on model base testing
Hi guys!Today we are going to lern how to test your project using a model.
This exercise was made in java and the testing is using GraphWalker

##To do this exercise you will need:
1. Eclipse [How to install it](#how-to-install-eclipse-ide)
2. GraphWalker [How to install it](#how-to-install-graphwalker)
3. Maven [How to install it](#how-to-install-maven)
4. Getting Set up [How to setup](#getting-set-up)


### How to install Eclipse IDE
- Download from [here](https://eclipse.org/downloads/)
- Install it
- What? Is just that

### How to install GraphWalker
- Download jar file from [here](http://graphwalker.github.io/content/archive/graphwalker-cli-3.4.2.jar)
- Rest it there

### How to install Maven
- Download zip~(Windows)~ or tar~(Others)~ from [here](http://maven.apache.org/download.cgi)

    ##### Windows Tips
    Extract distribution archive in any directory
    ```
    unzip apache-maven-3.3.9-bin.zip
    ```
    Check environment variable value e.g.
    ```
    echo %JAVA_HOME%
    ```
    Add Maven's bin path to Path on enviorenment Variables
    e.g.``` ...\apache-maven-3.3.9\bin```
    Check correct installation
    ```
    mvn -v
    ```
    ##### Unix-based Operating System (Linux, Solaris and Mac OS X) Tips
    Extract distribution archive in any directory
    ```
    tar xzvf apache-maven-3.3.9-bin.tar.gz
    ```
    Check environment variable value e.g.
    ```
    echo $JAVA_HOME
    ```
    Adding to PATH
    ```
    export PATH=/opt/apache-maven-3.3.9/bin:$PATH
    ```
    Check correct installation
    ```
    mvn -v
    ```
    
### Getting Set up
- In Eclipse select File>>New>>Java Project
- Name it 'Civil Status' and click Next
- Select the tab Libraries>> Add External JARs>> select GraphWalker Jar downloaded [before](#how-to-install-graphwalker).
- Select the Add Libraries>> select JUnit
- Click finish.
- Copy  [Src folder](https://github.com/JGEsteves89/FEUP-MESW-TVVS-MBT/tree/cb108d562b80e1417f1e3c21aabf7b4ff249be0c/src) and [pom.xml](https://github.com/JGEsteves89/FEUP-MESW-TVVS-MBT/blob/cb108d562b80e1417f1e3c21aabf7b4ff249be0c/pom.xml) to your project
- Now, look at me
- Look back to your computer
- Now, back to me
- Just kidding
