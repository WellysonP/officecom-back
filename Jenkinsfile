pipeline {
    agent any

    stages {
        stage ('Build Image'){
            steps {
                script {
                    dockerapp = docker.build("quarkus", '-f Dockerfile .')
                }
                echo 'Iniciando a pipeline'
            }
        }
    }
}