node {
    agent any
    stages {
        stage('Stage 1') {
            steps {
                echo "${params.GIT_BRANCH}"
            }
        }
    }
}
