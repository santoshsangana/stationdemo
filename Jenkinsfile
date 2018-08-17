pipeline {
	agent any
	stages {
		stage('Build') {
			steps {
				sh '/bin/mvn clean package'
			}
		}
	}
}
