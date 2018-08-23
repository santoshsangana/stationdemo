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
	    steps {
            def dockerHome = tool name: 'myDocker', type: 'org.jenkinsci.plugins.docker.commons.tools.DockerTool'
            }
            {
            sh "${dockerHome}/bin/docker build . -t tomcatwebapp:${env.BUILD_ID} "
            }
    }
  }
}
