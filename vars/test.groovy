def call(Map stageParams = [awsRegion: "us-east-1"]) {
  echo "Hello, ${stageParams.name}."
}
