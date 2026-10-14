# Wir nutzen ein fertiges Image, das Java 21 und das Web-Terminal ttyd bereits an Bord hat!
FROM tsl0922/ttyd:latest AS ttyd
FROM eclipse-temurin:21-jre-alpine

# Kopiere das fertige Terminal-Binary aus dem ttyd-Image rüber
COPY --from=ttyd /usr/bin/ttyd /usr/bin/ttyd

# Notwendige System-Bibliotheken für das Terminal installieren
RUN apk add --no-cache libuv tini

WORKDIR /app

# Kopiert deine Spieldatei aus dem artifacts-Ordner
COPY out/artifacts/B5_Project_jar/B5_Project.jar /app/game.jar

# Port-Freigabe für Render
EXPOSE 8080

# Tini sorgt für ein sauberes Starten. ttyd lauscht auf Port 8080 und startet dein Java-Spiel
ENTRYPOINT ["/sbin/tini", "--"]
CMD ["ttyd", "-p", "8080", "java", "-jar", "/app/game.jar"]
