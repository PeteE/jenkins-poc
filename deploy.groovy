pipeline {
    agent any
    stages {
        stage('checkout') {
            steps {
                echo "${params.GIT_REMOTE}"
                echo "${params.GIT_BRANCH}"
                checkout poll: false, scm: [$class: 'GitSCM', branches: [[name: "${params.GIT_BRANCH}"]], extensions: [], userRemoteConfigs: [[url: 'https://github.com/PeteE/jenkins-poc']]]
            }
        }
    }
}
