node {
    // Mark the code checkout 'stage'....
    stage 'Checkout'
    checkout scm

    stage 'Configure'
    env.PATH = "${tool 'Maven 3'}/bin:${env.PATH}"

    // Mark the code build 'stage'....
    stage 'Build'
    // Run the maven build
    sh 'mvn clean package'
}