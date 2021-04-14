pipeline {
    agent any
    stages {
        stage('checkout') {
            steps {
                echo "${params.GIT_REMOTE}"
                echo "${params.GIT_BRANCH}"
                checkout changelog: false, poll: false, scm: [$class: 'GitSCM', branches: [[name: "${params.GIT_BRANCH}"]], extensions: [[$class: 'CloneOption', noTags: true, reference: '', shallow: true], [$class: 'LocalBranch', localBranch: "${params.GIT_BRANCH}"]]], userRemoteConfigs: [[url: 'https://github.com/PeteE/jenkins-poc']]]
                sh "git remote -v"
                sh "git branch -a"
            }
        }
    }
}
