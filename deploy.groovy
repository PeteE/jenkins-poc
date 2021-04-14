pipeline {
    agent any
    stages {
        stage('JobProperties') {
          steps {
            properties(
              [
                parameters([
                  string(
                    defaultValue: "${params.GIT_SHA}",
                    description: 'Git SHA',
                    name: 'GIT_SHA',
                    trim: true)
                ])
              ],
              [
                $class: 'EnvInjectJobProperty',
                info: [
                  loadFilesFromMaster: false,
                  secureGroovyScript: [
                    classpath: [], sandbox: false, script: ''
                  ]
                ],
                keepBuildVariables: true,
                keepJenkinsSystemVariables: true,
                on: true
              ]
            )
          }
        }
        stage('checkout') {
            steps {
                echo "${env.GIT_REMOTE}"
                sh "env"
                checkout changelog: false, poll: false, scm: [$class: 'GitSCM', branches: [[name: "${env.GIT_BRANCH}"]], extensions: [[$class: 'CloneOption', noTags: true, reference: '', shallow: true], [$class: 'LocalBranch', localBranch: "${env.GIT_BRANCH}"]], userRemoteConfigs: [[url: 'https://github.com/PeteE/jenkins-poc']]]
                sh 'git remote -v'
                sh 'git branch -a'
            }
        }
        stage('DetermineCloudName') {
            steps {
                echo 'alpha'
                // set env var
            }
        }
    }
}
