def call(Map stageParams = [:]) {
    withAWS(region: "${AWS_REGION}", credentials:"${AWS_CRED}") {
        awsIdentity()
        s3Upload( 
            bucket: "${stageParams.s3Bucket}",
            file: "${stageParams.file}"
        )
    }
}
// awsRegion: "us-east-1", s3Bucket: "testbucket-geraldine" , file: "helloworld.txt"
