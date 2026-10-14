# Nutzen der offiziellen Java-Umgebung
FROM eclipse-temurin:21-jre-alpine

# Installiert curl und lädt das fertige Web-Terminal Gotty über die korrekte Direkt-URL
RUN apk add --no-cache curl \
    && curl -sLk -o /tmp/gotty.tar.gz https://github.com \
    && tar -xzf /tmp/gotty.tar.gz -C /usr/local/bin/ \
    && rm /tmp/gotty.tar.gz

# Arbeitsverzeichnis im Container festlegen
WORKDIR /app

# Kopiert deine JAR-Datei aus dem artifacts-Ordner
COPY out/artifacts/B5_Project_jar/B5_Project.jar /app/game.jar

# Port-Freigabe für Render
EXPOSE 8080
CMD ["gotty", "-w", "-p", "8080", "java", "-jar", "/app/game.jar"]
