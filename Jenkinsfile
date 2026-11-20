pipeline {
  agent {
    docker { image 'maven:3.9-eclipse-temurin-17' }
  }
  environment {
    APP_NAME = 'java-app-audit'
    IMAGE_REPO = 'hackathon-coders-org/java-app-audit'
    MAVEN_OPTS = '-Xmx512m'
    NEXUS_CREDS = credentials('nexus-creds')
  }
  triggers {
    cron('H 2 * * *')
    pollSCM('H/15 * * * *')
  }
  stages {
    stage('Build') {
      steps { sh 'mvn -B -ntp -DskipTests compile' }
    }
    stage('Test') {
      steps { sh 'mvn -B -ntp test' }
      post { always { junit 'target/surefire-reports/*.xml' } }
    }
    stage('Package') {
      when { branch 'main' }
      steps { sh 'mvn -B -ntp package -DskipTests' }
    }
    stage('Publish') {
      when { branch 'main' }
      steps { sh 'mvn -B -ntp deploy -DskipTests -Dnexus.user=$NEXUS_CREDS_USR -Dnexus.password=$NEXUS_CREDS_PSW' }
    }
  }
}
