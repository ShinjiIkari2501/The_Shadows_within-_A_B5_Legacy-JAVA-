# 1. Stufe: Wir holen uns das fertige Terminal-Binary aus dem ttyd-Image
FROM tsl0922/ttyd:latest AS ttyd

# 2. Stufe: Wir nutzen das stabile Ubuntu-basierte Java 25 Image
FROM eclipse-temurin:25-jdk

# Installiert die notwendigen Web-System-Bibliotheken für ttyd unter Ubuntu
RUN apt-get update && apt-get install -y --no-install-recommends \
    libuv1 \
    tini \
    && rm -rf /var/lib/apt/lists/*

# Kopiere das ttyd Terminal-Binary aus der ersten Stufe rüber
COPY --from=ttyd /usr/bin/ttyd /usr/bin/ttyd

# Arbeitsverzeichnis im Container festlegen
WORKDIR /app

# Kopiert deine originale Spieldatei aus dem artifacts-Ordner
COPY out/artifacts/B5_Project_jar/B5_Project.jar /app/game.jar

# Port-Freigabe für Render
EXPOSE 8080

# Tini sorgt für ein stabiles Starten im Web mit iFrame-Freigabe (-I)
ENTRYPOINT ["/usr/bin/tini", "--"]
CMD ["ttyd", "-p", "8080", "-I", "java", "-jar", "/app/game.jar"]
