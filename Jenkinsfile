pipeline {
	agent any
	tools {
		maven 'localmaven'
	}
	stages {
		stage('Build') {
			steps {
				sh '/bin/mvn clean package'
			}
		}
	}
}
