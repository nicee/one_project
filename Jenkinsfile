// Jenkinsfile (Declarative Pipeline)
pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                sh '/usr/local/maven/bin/mvn -e -X clean install'
            }
        }
        stage('Test') {
            steps {
                sh 'java -version'
            }
        }
    }
}