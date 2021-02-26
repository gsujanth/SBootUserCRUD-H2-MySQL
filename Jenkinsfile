def nodeLabel = ''
timeout(time: 15, unit: 'MINUTES') {
    node(nodeLabel) {
        stage('Build') {
            withGradle() {
                sh './gradlew clean build'
            }
        }
    }
}