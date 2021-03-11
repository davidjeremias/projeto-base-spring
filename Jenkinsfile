pipeline {
    agent any
    environment {
        IMAGEM_DOCKER = 'dvvdoficial/projeto-base-spring'
        CREDENTIAL_DOCKER = 'dockerhub'
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
                   docker.build IMAGEM_DOCKER + ":$BUILD_NUMBER"
               }
           }
        }
    }
}