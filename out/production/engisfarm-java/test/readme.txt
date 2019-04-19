=======================
Using Junit4 in ubuntu
=======================

- Install 
sudo apt-get install junit4

- Compile
javac -cp /usr/share/java/junit4.jar <include all class needed for test>

- Run
java -cp /usr/share/java/junit4.jar:. org.junit.runner.JUnitCore <classes using package name>

**pastikan nama package benar**
