def call(Map stageParams = [:]){
  withAWS(region: "${AWS_REGION}", credentials:"${AWS_CRED}") {
        awsIdentity()
        cfnCreateChangeSet(
          stack: "${stageParams.stack}", 
          changeSet:'my-change-set', 
          url: "${stageParams.url}"
        )
        cfnExecuteChangeSet(
          stack:"${stageParams.stack}", 
          changeSet:'my-change-set'
        )
  }
}
//awsRegion: "us-east-1" , 'EC2Jenkins-geraldine', 'https://testbucket-geraldine.s3.amazonaws.com/deployEC2.yml'
