def nodeLabel = ''

timeout(time: 15, unit: 'MINUTES') {
    node(nodeLabel) {
        stage('Clean Workspace') {
            echo 'Cleaning Workspace'
            cleanWs()
        }
        stage('Checkout SCM') {
            echo 'Checking out from Github'
            checkout scm
        }
        stage('PWD') {
            echo 'Current working directory'
            sh 'pwd'
        }
        stage('Build') {
            echo 'Starting gradle build'
            sh './gradlew clean build'
        }
        stage('Notify') {
            echo 'Notifying Build Report'
            emailext body: 'Test Message',
                subject: 'Test Subject',
                to: 'flyhighbaby21@gmail.com',
                attachLog: true
        }
        stage('Email Notification'){
            mail bcc: '', body: '''Build successful!!!!
            Thanks,
            STONKS''',
            cc: '', from: '', replyTo: '', subject: 'Build successfull', to: 'flyhighbaby21@gmail.com'
        }
    }
}