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
        stage('Imagem Docker') {
            steps {
                echo "Versão do pom.xml: ${VERSAO_POM}"
                withDockerRegistry([credentialsId: 'c34117dc-5fa1-46f8-8ebb-f1cf0b2254c4', url: 'https://dockerhub.camara.gov.br/']) {
                    script {
                        imagem = docker.build("${env.IMAGEM_DOCKER}:${VERSAO_POM}")
                        imagem.push()
                    }
                }
            }
        }
    }
}