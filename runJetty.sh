base="`dirname $0`"
cd $base/bench-jetty
../gradlew installApp
cd build/install/bench-jetty
./bin/bench-jetty
