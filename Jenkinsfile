pipeline {
    agent any
    
    stages {
        stage('Fetch Latest Code') {
            steps {
                bat 'git fetch --all'
                bat 'git reset --hard origin/main'
            }
        }
        stage('Build') {
            steps {
                bat 'mvn clean install'
            }
        }
        stage('Test') {
            steps {
                bat 'mvn test'
            }
        }
        stage('Code Analysis') {
            steps {
                bat 'sonar-scanner'
            }
        }
        stage('Deploy') {
            steps {
                // Comment this out if you don’t have a deploy script yet
                // bat './deploy.sh'
            }
        }
    }
}
