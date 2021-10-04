def buildNum(){
  echo "Build image with tag: ${env.BUILD_ID}"
}

def myAppDocker(){
  myapp = docker.build("geraldine28/ledger-service:${env.BUILD_ID}", "--build-arg VERSION=${env.BUILD_ID} .")
}

def myAppNpm(){
  myapp = docker.build("geraldine28/nodejs-test:${env.BUILD_ID}")
}

def pushDocker(){
  docker.withRegistry('https://registry.hub.docker.com', 'dockerhub') {
    myapp.push("latest")
    myapp.push("${env.BUILD_ID}")
  }
}
