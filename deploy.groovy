pipeline {
    agent any
    stages {
        stage('SetCloudName') {
          steps {
            script {
              env.CLOUD_NAME = sh(script:'echo alpha', returnStdout: true).trim()
            }
          }
        }
        stage('checkout') {
            steps {
                echo "${env.GIT_REMOTE}"
                sh "printenv"
                /*
                checkout changelog: false, poll: false, scm: [$class: 'GitSCM', branches: [[name: "${env.GIT_BRANCH}"]], extensions: [[$class: 'CloneOption', noTags: true, reference: '', shallow: true], [$class: 'LocalBranch', localBranch: "${env.GIT_BRANCH}"]], userRemoteConfigs: [[url: 'https://github.com/PeteE/jenkins-poc']]]
                sh 'git remote -v'
                sh 'git branch -a'
                */
            }
        }
    }
}
