pipeline {
    agent any
    tools {
        maven 'Maven 3.3.9'
        jdk 'jdk8'
    }
    stages {
        stage ('Initialize') {
            steps {
                sh '''
                    echo "PATH = ${PATH}"
                    echo "M2_HOME = ${M2_HOME}"
                '''
            }
        }

        stage ('Build') {
            steps {
                sh 'mvn -Dmaven.test.failure.ignore=true install'
            }
            post {
                success {
                    junit 'target/surefire-reports/**/*.xml'
                }
            }
        }

        stage('Test') {
            steps {
                /* `makecheck` returnsnon-zeroon test failures,
                * using`true` to allowthe Pipeline to continue nonetheless
                */
                sh 'makecheck || true' junit'**/target/*.xml'
            }
        }
    }
}
