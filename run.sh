#!/bin/bash

echo "*******************  BUILDING MODULE  *****************************************"
mvn clean install

echo "*******************  COLLECTING DEPENDENCIES  *********************************"
mvn dependency:copy-dependencies
export CLASPATH=""
for file in `ls target/dependency`; do export CLASSPATH=$CLASSPATH:target/dependency/$file; done
export CLASSPATH=$CLASSPATH:target/classes

echo "*******************  EXECUTING PROGRAM******************************************"
<<<<<<< HEAD
java -cp $CLASSPATH -Dactivejdbc.log com.unrc.app.Inmo
=======
java -cp $CLASSPATH -Dactivejdbc.log com.unrc.app.Inmo
>>>>>>> 3de6e6c676dc26eae3614942c4b37f98442f9108
