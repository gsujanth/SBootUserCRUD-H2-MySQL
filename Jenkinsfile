def nodeLabel = ''
timeout(time: 15, unit: 'MINUTES') {
    options {
        skipDefaultCheckout()
    }
    node(nodeLabel) {
        stage('Clean Workspace') {
            cleanWs()
        }
        stage('Checkout SCM') {
            checkout scm
        }
        stage('PWD') {
            echo 'Current working directory'
            sh 'pwd'
        }
        stage('Build') {
            echo 'Starting gradle build'
            sh './gradle clean build'
        }
    }
}