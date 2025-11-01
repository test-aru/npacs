pipeline {
  agent any

    stage('Checkout_code'){
        checkout scm
    }

    stage('Verify Tooling'){
     sh '''
         docker version
         docker info
         docker compose version
         '''
   }


}