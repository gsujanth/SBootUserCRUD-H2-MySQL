def nodeLabel = ''
timeout(time: 15, unit: 'MINUTES') {
    node(nodeLabel) {
        stage('Build') {
            sh './gradlew clean build'
        }
    }
}