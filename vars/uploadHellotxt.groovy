def call(Map stageParams = [awsRegion: "us-east-1", s3Bucket: "testbucket-geraldine"]) {
    withAWS(region: stageParams.awsRegion, credentials:"${AWS_CRED}") {
        awsIdentity()
        s3Upload( 
            bucket: stageParams.s3Bucket,
            file: "helloworld.txt"
        )
    }
}
