pipeline {
    agent {
            docker { image 'maven:3.8.1-jdk-11' }
        }

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

        stage('Install Dependencies'){
          steps{
                    // Install dependencies
                          sh 'mvn clean install'
          }
        }

        stage('Run Testcases'){
          steps{
            sh 'mvn test -Dtest=com.npacs.testCases.LoginTC.*'
          }
        }

        stage('Publish Test Results') {
                    steps {
                        // Publish test results (JUnit XML format)
                        junit '**/target/test-*.xml'  // Adjust this path if your Maven build outputs results elsewhere
                    }
                }
    }

     post {
            always {
                // Clean up workspace after the build
                cleanWs()
            }
        }
}
