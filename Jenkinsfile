node {
    // Mark the code checkout 'stage'....
    stage 'Checkout'
    checkout scm

    stage 'Configure'
    env.PATH = "${tool 'Maven 3'}/bin:${env.PATH}"

    // Mark the code build 'stage'....
    stage('Build') {
      // Run the maven build
      sh 'mvn clean package'
    }

    stage('SonarQube analysis') {
      withSonarQubeEnv('SonarQube') {
        sh 'mvn org.sonarsource.scanner.maven:sonar-maven-plugin:3.2:sonar'
      }
    }
}
