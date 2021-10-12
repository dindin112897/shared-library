def call() {
    pipeline {
        agent any
        environment {
            AWS_CRED = 'cloud_user'
        }
        stages {
            stage('Upload template to S3') {                  
                steps {
                    uploadTemplateToS3()
                }
            }
            
             stage('Upload Hello text to S3') {                  
                steps {
                    uploadHellotxt()
                }
            }
            stage('Deploy EC2') {                  
                steps {
                    deployEC2()
                }
            }
        }
    }
}
