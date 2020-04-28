pipeline {
    agent any
       stages{
        stage('Git'){
            steps {
               git 'https://github.com/DariaRyabinina/Lesson25.git'
            }
        }
        stage('Test'){
            steps{
                bat label: '', script: 'mvn clean test'
            }
        }
    }
    post {
        always {
            script {
                allure([includeProperties: false,
                        jdk: '',
                        results: [[path: 'target/allure-results']]
                ])
            }
        }
    }
}