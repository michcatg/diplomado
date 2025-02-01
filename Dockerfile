# Usa una imagen base de OpenJDK con JRE optimizado
FROM openjdk:17-jdk-slim

# Crea un directorio de trabajo en el contenedor
WORKDIR /app

# Copia el archivo JAR de la aplicación al contenedor

COPY target/coordlib-service-0.0.1-SNAPSHOT.jar app.jar

RUN apt-get update && apt-get install -y --no-install-recommends curl && rm -rf /var/lib/apt/lists/*

# Establece variables de entorno predeterminadas (puedes sobrescribirlas al iniciar el contenedor)
#ENV SPRING_PROFILES_ACTIVE=prod
#ENV SPRING_DATA_MONGODB_URI=mongodb://usuario:contraseña@host:puerto/nombre_base_datos

# Expone el puerto en el que se ejecuta la aplicación
EXPOSE 8083

# Define el comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "app.jar"]

