base="`dirname $0`"
cd $base/bench-tomcat
../gradlew installApp
cd build/install/bench-tomcat
./bin/bench-tomcat
