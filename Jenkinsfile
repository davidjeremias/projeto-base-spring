pipeline {
    agent any
    environment {
        REPOSITORY_DOCKER = 'dvvdoficial/projeto-base-spring'
        CREDENTIAL_DOCKER = 'dockerhub'
        IMAGE_DOCKER = ''
        EMAIL_TO = 'com1.com3@gmail.com'
        NUMBER_BUILD = '$BUILD_NUMBER'
    }

    tools {
            maven '3.6.3'
            jdk 'OpenJDK-11'
    }
    
    stages {
        stage('Git checkout') {
        	steps {
	            checkout scm
	            	script {
	            	    VERSAO_POM = readMavenPom().getVersion()
	            	}
	        }
        }
        stage('Maven Build') {
           steps {
               sh "mvn -version"
               sh "mvn clean install"
           }
        }
        stage('Arquivar JAR') {
           steps {
               archive 'target/projeto.jar'
           }
        }
        stage('Building image Docker') {
           steps {
               script {
                   IMAGE_DOCKER = docker.build REPOSITORY_DOCKER + ":$BUILD_NUMBER"
               }
           }
        }
        stage('Deployment image DockerHub') {
           steps {
               script {
                   docker.withRegistry('', CREDENTIAL_DOCKER) {
                    IMAGE_DOCKER.push()
                   }
               }
           }
        }
        stage('Remove Unused docker image') {
           steps {
               sh "docker rmi $REPOSITORY_DOCKER:$BUILD_NUMBER"
           }
        }
    }
    post {
        failure {
            mail bcc: '',
            body: '${PROJECT_NAME} - Build # ${NUMBER_BUILD} - ${BUILD_STATUS}: \n Check console output at ${BUILD_URL} to view the results.',
            cc: '',
            from: '',
            replyTo: '',
            subject: '${PROJECT_NAME} - Build # ${BUILD_NUMBER} - ${BUILD_STATUS}!',
            to: "${EMAIL_TO}"
        }
    }
}