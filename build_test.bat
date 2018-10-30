cls
set JAVA_HOME=E:\Tools\Java\jdk-11
set JRE_HOME=E:\Tools\Java\jdk-11
set MAVEN_HOME=E:\Tools\apache-maven-3.5.4
set PATH=%JAVA_HOME%\bin;%JRE_HOME%\bin;%MAVEN_HOME%\bin;%PATH%

echo %JAVA_HOME%
echo %JRE_HOME%
echo %MAVEN_HOME%
echo %PATH%

java -version
javac -version

rem mvn clean install -Dmaven.test.skip=true
call mvn clean install
rem call mvn test