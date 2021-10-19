def call(Map stageParams = [Region: "us-east-1",  bucketName: "test-bucket-2221", s3Path: ""]) {
    withAWS(region: stageParams.Region, credentials:'cloud_user') {
        awsIdentity()
        s3Upload( 
            workingDir: stageParams.workingDir,
            includePathPattern: stageParams.stackFileName,
            bucket: stageParams.bucketName,
            path: stageParams.s3Path
        )
    }
}
