def call(Map stageParams = [awsRegion: "us-east-1", s3Bucket: "testbucket-geraldine"]) {
    withAWS(region: stageParams.awsRegion, credentials:"${AWS_CRED}") {
        awsIdentity()
        s3Delete( 
            bucket: stageParams.s3Bucket,
            path: "delete.txt"
        )
    }
}
