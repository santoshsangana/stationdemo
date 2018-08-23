pipeline {
	agent any
	tools {
		maven 'localMaven'
	}
	stages {
		stage('Build') {
			steps {
				sh 'mvn clean package'
			}
		}

	stage('build Docker /image'){
            def dockerHome = tool name: 'myDocker', type: 'org.jenkinsci.plugins.docker.commons.tools.DockerTool'
//            def dockerCMD = "{dockerHome}/bin/docker"
            sh "${dockerHome}/bin/docker build . -t tomcatwebapp:${env.BUILD_ID} "
    }
  }
}
