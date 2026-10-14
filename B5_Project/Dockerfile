# Wir nutzen das ttyd-Image für das Terminal und das stabile Java 21 Standard-Image
FROM tsl0922/ttyd:latest AS ttyd
FROM eclipse-temurin:21-jre-alpine

# Kopiere das fertige Terminal-Binary rüber
COPY --from=ttyd /usr/bin/ttyd /usr/bin/ttyd

# Notwendige System-Bibliotheken installieren
RUN apk add --no-cache libuv tini

WORKDIR /app

# Kopiert deine originale Spieldatei aus dem artifacts-Ordner
COPY out/artifacts/B5_Project_jar/B5_Project.jar /app/game.jar

# Port-Freigabe für Render
EXPOSE 8080

ENTRYPOINT ["/sbin/tini", "--"]

# JETZT ABSOLUT RICHTIG: Das "-I" schaltet die iFrame-Eingabe auf Java 21 scharf!
CMD ["ttyd", "-p", "8080", "-I", "java", "-jar", "/app/game.jar"]
