from sonarqube:6.2

COPY target/*.jar $SONARQUBE_HOME/extensions/plugins/
