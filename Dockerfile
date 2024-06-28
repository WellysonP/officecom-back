# Use uma imagem base com o JDK completo (por exemplo, OpenJDK 11 no Alpine)
FROM adoptopenjdk/openjdk11:alpine

# Configure a variável de ambiente JAVA_HOME
ENV JAVA_HOME /opt/java/openjdk

# Diretório de trabalho
WORKDIR /app

# Copie o código-fonte da sua aplicação para o contêiner
COPY ./ ./

# Construa a aplicação Quarkus (substitua pelo comando real de construção)
RUN ./gradlew build

# Exponha a porta em que a aplicação Quarkus está ouvindo (substitua pela porta correta)
EXPOSE 8080

# Comando para iniciar a aplicação quando o contêiner for iniciado
CMD ["java", "-jar", "./build/quarkus-app/quarkus-run.jar"]
