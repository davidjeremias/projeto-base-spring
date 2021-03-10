pipeline {
    agent any
    environment {
        IMAGEM_DOCKER = 'https://hub.docker.com/repository/docker/dvvdoficial'
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
        stage('Maven Compile stage') {
           steps {
               sh "mvn clean compile"
           }
        }
        stage('Maven testing stage') {
           steps {
               sh "mvn test"
           }
        }
        stage('Maven deployment stage') {
           steps {
               sh "mvn deploy"
           }
        }
        stage('Arquivar JAR') {
           steps {
               archive 'target/projeto.jar'
           }
        }
    }
}