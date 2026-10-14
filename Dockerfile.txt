# Nutzen aus der offiziellen Java-Umgebung
FROM eclipse-temurin:21-jre-alpine

# Installiert das fertige Web-Terminal Gotty
RUN apk add --no-cache curl \
    && curl -sLk https://github.com | tar xz -C /usr/local/bin

# Arbeitsverzeichnis im Container festlegen
WORKDIR /app

# Kopiere deine exportierte JAR-Datei in den Container
COPY out/artifacts/*/*.jar /app/game.jar

# Render nutzt dynamische Ports. Gotty lauscht auf dem Port und startet dein Java-Spiel
EXPOSE 8080
CMD ["gotty", "-w", "-p", "8080", "java", "-jar", "/app/game.jar"]
