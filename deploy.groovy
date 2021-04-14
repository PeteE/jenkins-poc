pipeline {
    agent any
    stages {
        stage('checkout') {
            steps {
                echo "${params.GIT_REMOTE}"
                echo "${params.GIT_BRANCH}"
            }
        }
    }
}
