pipeline {
    agent any
    environment {
        REPOSITORY_DOCKER = 'dvvdoficial/projeto-base-spring'
        CREDENTIAL_DOCKER = 'dockerhub'
        IMAGE_DOCKER = ''
        EMAIL_TO = 'com1.com3@gmail.com'
        NUMBER_BUILD = ''
        NAME_PROJECT = ''
        STATUS_BUILD = ''
        URL_BUILD = ''
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
	            	    NUMBER_BUILD = $BUILD_NUMBER
                        NAME_PROJECT = $PROJECT_NAME
                        STATUS_BUILD = $BUILD_STATUS
                        URL_BUILD = $BUILD_URL
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
            body: '${NAME_PROJECT} - Build # ${NUMBER_BUILD} - ${STATUS_BUILD}: \n Check console output at ${URL_BUILD} to view the results.',
            cc: '',
            from: '',
            replyTo: '',
            subject: '${NAME_PROJECT} - Build # ${NUMBER_BUILD} - ${STATUS_BUILD}!',
            to: "${EMAIL_TO}"
        }
    }
}