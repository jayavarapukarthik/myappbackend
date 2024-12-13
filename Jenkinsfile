pipeline {
    agent any

    environment {
        REPO_URL = 'https://github.com/jayavarapukarthik/myappbackend.git'
        BRANCH = 'main'
        DOCKER_IMAGE = 'online-ticket-booking'
        TARGET_PORT = '8999'
        LOCAL_PORT = '8015'
        WORKDIR = '/var/lib/jenkins/workspace/online-ticket-booking'
    }

    stages {
        stage('Clone Repository') {
            steps {
                echo 'Cloning repository from Github...'
                sh """
                rm -rf ${WORKDIR}
                git clone -b ${BRANCH} ${REPO_URL} ${WORKDIR}
                """
            }
        }

        stage('Build Application') {
            steps {
                echo 'Building the application with Maven...'
                dir("${WORKDIR}") {
                    sh 'mvn clean package'
                }
            }
        }

        stage('Build Docker Image') {
            steps {
                echo 'Building Docker image...'
                dir("${WORKDIR}") {
                    sh "docker build -t ${DOCKER_IMAGE} ."
                }
            }
        }

        stage('Run Docker Container') {
            steps {
                echo 'Running Docker container...'
                sh """
                docker stop ${DOCKER_IMAGE} || true
                docker rm ${DOCKER_IMAGE} || true
                docker run -d -p ${LOCAL_PORT}:${TARGET_PORT} --name ${DOCKER_IMAGE} ${DOCKER_IMAGE}
                """
            }
        }
    }

    post {
        success {
            echo 'Application deployed successfully!'
        }
        failure {
            echo 'Deployment failed. Check logs for details.'
        }
    }
}	