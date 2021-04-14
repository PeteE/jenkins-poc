pipeline {
    agent any
    stages {
        stage('checkout') {
            steps {
                echo "${params.branch}"
            }
        }
    }
}
