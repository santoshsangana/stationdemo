pipeline {
	agent any
	tools {
		maven 'localMaven'
	}
	stages {
		stage('Build') {
			steps {
				sh '/bin/mvn clean package'
			}
		}
	}
}
