def nodeLabel = ''
timeout(time: 15, unit: 'MINUTES') {
    node(nodeLabel) {
        stage('Clean Workspace') {
            cleanWs()
        }
        stage('PWD') {
            echo 'Current working directory'
            sh 'pwd'
        }
        stage('Build') {
            echo 'Starting gradle build'
            sh 'gradle clean build'
        }
    }
}