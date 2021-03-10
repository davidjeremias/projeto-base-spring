pipeline {
    agent any
    environment {
        IMAGEM_DOCKER = 'https://hub.docker.com/repository/docker/dvvdoficial'
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
    }
}