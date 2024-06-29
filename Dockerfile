# Utiliza una imagen base de Selenium con Chrome
FROM --platform=linux/amd64 selenium/standalone-chrome:4.21.0

# Instala Maven y JDK 21
USER root
RUN apt-get update && \
    apt-get install -y maven openjdk-21-jdk && \
    rm -rf /var/lib/apt/lists/*

# Establece el directorio de trabajo en el contenedor
WORKDIR /app

# Copia el archivo pom.xml y el archivo de configuración de TestNG al contenedor
COPY pom.xml testng.xml ./

# Copia el resto del código fuente del proyecto al contenedor
COPY src src

# Compila el proyecto
RUN mvn clean install || (tail -n 100 /root/.m2/repository/logs/* || true && exit 1)

# Copia el script de inicio al contenedor
COPY entrypoint.sh /entrypoint.sh
RUN chmod +x /entrypoint.sh

# Comando de inicio del contenedor
ENTRYPOINT ["/bin/bash", "/entrypoint.sh"]
