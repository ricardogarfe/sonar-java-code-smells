from sonarqube:7.1

# Http port
EXPOSE 9000

COPY target/*.jar $SONARQUBE_HOME/extensions/plugins/
