node {
    agent any
    parameters {
        string(name: 'GIT_REMOTE', defaultValue: 'MindTouch', description: 'Name of git repo')
        string(name: 'GIT_BRANCH', defaultValue: 'master', description: 'Branch to build')
    }
    stages {
        stage('Stage 1') {
            steps {
                echo "${params.GIT_BRANCH}"
            }
        }
    }
}
