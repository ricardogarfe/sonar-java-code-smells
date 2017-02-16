from sonarqube:6.2

# Http port
EXPOSE 9000

COPY target/*.jar $SONARQUBE_HOME/extensions/plugins/
