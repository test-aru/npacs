pipeline {
    agent any

    stages {
        stage('Checkout_code') {
            steps {
                checkout scm
            }
        }

        stage('Verify Tooling') {
            steps {
                sh '''
                    docker version
                    docker info
                    docker compose version
                '''
            }
        }
    }
}
