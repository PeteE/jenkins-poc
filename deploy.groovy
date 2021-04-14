pipeline {
    agent any
    stages {
        stage('SetCloudName') {
          steps {
            withCredentials([aws(accessKeyVariable: 'AWS_ACCESS_KEY_ID', credentialsId: 'alpha-aws', secretKeyVariable: 'AWS_SECRET_ACCESS_KEY')]) {
    // some block
              sh 'aws sts get-caller-identity'
              /*
              script {
                env.CLOUD_NAME = sh(script:'echo alpha', returnStdout: true).trim()
              }
              */
            }
          }
        }
        /*
        stage('checkout') {
            steps {
                checkout changelog: false, poll: false, scm: [$class: 'GitSCM', branches: [[name: "${env.GIT_BRANCH}"]], extensions: [[$class: 'CloneOption', noTags: true, reference: '', shallow: true], [$class: 'LocalBranch', localBranch: "${env.GIT_BRANCH}"]], userRemoteConfigs: [[url: 'https://github.com/PeteE/jenkins-poc']]]
                sh 'git remote -v'
                sh 'git branch -a'
            }
        }
        */
    }
}
