def call(Map stageParams = [:]) {
    withAWS(region: "${AWS_REGION}", credentials:"${AWS_CRED}") {
        awsIdentity()
        s3Upload( 
            bucket: "${stageParams.s3Bucket}",
            includePathPattern: "${stageParams.folder-file}"
        )
    }
}
