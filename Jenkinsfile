pipeline {
    agent any
    stages {
        stage('Prepare') {
            steps {
                sh 'export MAVEN_HOME=/usr/local/maven/'
                sh 'export PATH=$PATH:$MAVEN_HOME/bin'
            }
        }
        stage('Build') {
            steps {
                sh 'mvn -B -DskipTests clean package'
            }
        }
        stage('Test') {
            steps {
                sh 'java -version'
            }
        }
    }
}