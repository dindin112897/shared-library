def call(Map stageParams = [:]) {
    withAWS(region: "${AWS_REGION}", credentials:"${AWS_CRED}") {
        awsIdentity()
        s3Upload( 
            includePathPattern: "${stageParams.path}",
            bucket: "${s3Bucket}"
        )
    }
}
// awsRegion: "us-east-1", s3Bucket: "testbucket-geraldine" , *.yml, sample/sampleThree.txt
