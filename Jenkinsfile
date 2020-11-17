pipeline {
    agent any
    parameters {
        choice(name: 'TAG', choices:['', 'junit', 'param', 'wordpress'])
        choice(name: 'EXTAG', choices:['', 'junit', 'param', 'wordpress'])
    }
    stages {
        stage ('checkout') {
            steps {
                git 'https://github.com/kargolek/test-automation.git'
            }
        }

        stage ('run') {
            steps {
               sh "mvn clean test -Dgroups=${params.TAG} -DexcludedGroups=${params.EXTAG}"
            }
        }
    }

   post {
               always {
                   allure([
                            includeProperties: false,
                            jdk: '',
                            properties: [[key: 'allure.issues.tracker.pattern', value: 'http://tracker.company.com/%s'],
                            [key: 'allure.tests.management.pattern', value: 'http://tms.company.com/%s'],
                            ],
                            reportBuildPolicy: 'ALWAYS',
                            results: [[path: 'qajunit/target/allure-results']]
                            ])
               }
           }
}