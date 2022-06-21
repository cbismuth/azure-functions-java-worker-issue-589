set -e
set -u

printf "\033c"

export JAVA_HOME="/Users/cbismuth/Library/Java/JavaVirtualMachines/azul-11.0.15/Contents/Home"
export PATH=$JAVA_HOME/bin:$PATH

java -version
mvn --version

mvn clean install

(cd function && pwd && mvn azure-functions:run)
