# Imagen base con Java 21
FROM eclipse-temurin:21-jdk

# Carpeta interna de la app
WORKDIR /app

# Copia todo el proyecto al contenedor
COPY . .

# Da permisos al Maven Wrapper
RUN chmod +x mvnw

# Compila el proyecto sin tests
RUN ./mvnw clean package -DskipTests

# Expone el puerto usado por Spring Boot
EXPOSE 8080

# Ejecuta la aplicación
CMD ["java", "-jar", "target/inventoryapi-0.0.1-SNAPSHOT.jar"]