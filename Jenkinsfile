pipeline {
	agent any
	tools {
		maven 'localMaven'
	}
	stages {
		stage('Build') {
			steps {
				sh 'mvn clean package'
//				sh "docker build . -t tomcatwebapp:${env.BUILD_ID}"
//                docker.build("-t tomcatwebapp:${env.BUILD_ID}")
			}
		}
	}
	stage('build Dockerimage'){
      steps{
        dir('dockerbuild'){
            fileExists 'Dockerfile'
            sh "docker build . -t tomcatwebapp:${env.BUILD_ID}"
        }
      }
    }
}
