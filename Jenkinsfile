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

	stage('build Dockerimage'){
      steps{
        dir('dockerbuild'){
            fileExists 'Dockerfile'
            def dockerHome = tool name: 'myDocker', type: 'org.jenkinsci.plugins.docker.commons.tools.DockerTool'
            def dockerCMD = "{dockerHome}/bin/docker"
            sh "${dockerCMD} build . -t tomcatwebapp:${env.BUILD_ID} "
        }
      }
    }
  }
}
