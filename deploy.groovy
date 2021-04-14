pipeline {
    agent any
    stages {
        stage('DetermineCloudName') {
          environment {
            CLOUD_NAME = sh(
              script: 'echo alpha',
              ,
              retrunStdOut: true).trim()
          }
          steps {
            sh 'env |grep CLOUD_NAME'
          }
        }
        stage('checkout') {
            steps {
                echo 'CLOUD_NAME=${CLOUD_NAME}'
                /*
                echo "${env.GIT_REMOTE}"
                sh "env"
                checkout changelog: false, poll: false, scm: [$class: 'GitSCM', branches: [[name: "${env.GIT_BRANCH}"]], extensions: [[$class: 'CloneOption', noTags: true, reference: '', shallow: true], [$class: 'LocalBranch', localBranch: "${env.GIT_BRANCH}"]], userRemoteConfigs: [[url: 'https://github.com/PeteE/jenkins-poc']]]
                sh 'git remote -v'
                sh 'git branch -a'
                */
            }
        }
    }
}
