// Jenkinsfile (Declarative Pipeline)
pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                sh 'cd parent'
                sh '/usr/local/maven/bin/mvn -B -e -DskipTests clean install'
            }
        }
        stage('Test') {
            steps {
                sh 'java -version'
            }
        }
    }
}