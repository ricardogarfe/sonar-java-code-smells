node {
    // Mark the code checkout 'stage'....
    stage 'Checkout'
    checkout scm

    stage 'Configure'
    # env.PATH = "${tool 'Maven 3'}/bin:${env.PATH}"
    def mvnHome = tool 'Maven 3'

    // Mark the code build 'stage'....
    stage('Build') {
      // Run the maven build
      sh "${mvnHome} clean verify"
    }

    stage('SonarQube analysis') {
      withSonarQubeEnv('SonarQube') {
        sh "${mvnHome} sonar:sonar -Dsonar.branch=${env.BRANCH_NAME}"
      }
    }
}
