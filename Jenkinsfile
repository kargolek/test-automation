pipeline {
    agent any
    stages {
        stage ('checkout') {
            steps {
                git 'https://github.com/kargolek/test-automation.git'
            }
        }

        stage ('run') {
            steps {
               sh "mvn clean test"
            }
        }
    }

    post {
        always {
            allure([])
        }
    }
}