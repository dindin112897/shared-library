def call() {
    pipeline {
        agent any
        environment {
            AWS_CRED = 'cloud_user'
            AWS_REGION = 'us-east-1'
            s3Bucket = 'testbucket-geraldine'
        }
        stages {
            stage('Upload template to S3') {                  
                steps {
                    uploadTemplateToS3(s3Bucket: "${s3Bucket}", path: "*.yml, sample/sampleThree.txt")
                }
            }
            
             stage('Upload Hello text to S3') {                  
                steps {
                    uploadHellotxt(s3Bucket: "testbucket-geraldine", file: "helloworld.txt")
                }
            }
//             stage('Upload folder with specific file to S3') {                  
//                 steps {
//                     uploadFolderWithspecificFile(s3Bucket: "testbucket-geraldine", folderwfile: "sample/sampleThree.txt")
//                 }
//             }
//             stage('Upload All to S3') {                  
//                 steps {
//                     uploadAllS3(s3Bucket: "testbucket-geraldine", uploadAll: "**/*")
//                 }
//             }
            
            stage('Delete text to S3') {                  
                steps {
                    deletetxt(s3Bucket: "testbucket-geraldine", path: "delete.txt")
                }
            }
            stage('Deploy EC2') {                  
                steps {
                    deployEC2(stack: "EC2Jenkins-geraldine", url: "https://testbucket-geraldine.s3.amazonaws.com/deployEC2.yml")
                }
            }
        }
    }
}
