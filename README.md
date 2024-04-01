# Projeto backend-fourcard

Base do projeto
```
https://code.quarkus.io/?g=br.com.backend&a=app&b=GRADLE&e=resteasy&e=resteasy-jackson&e=smallrye-fault-tolerance&e=smallrye-metrics&e=smallrye-health&e=smallrye-openapi&e=smallrye-opentracing&e=rest-client&e=smallrye-jwt&e=rest-client-jackson&e=hibernate-validator&e=hibernate-orm-panache&e=jdbc-postgresql&e=jacoco
```

## Executando o aplicativo no modo dev

Pode executar o seu aplicativo no modo dev que permite a codificação ao vivo usando:
```shell script
./gradlew quarkusDev
```

> **_NOTE:_** O Quarkus agora vem com uma Dev UI, que está disponível no modo dev apenas em http://localhost:8080/dev/.

## Empacotando e executando o aplicativo

O aplicativo pode ser empacotado usando:
```shell script
./gradlew build
```

Ela produz o `quarkus-run.jar` arquivo no `build/quarkus-app/`diretório.
Esteja ciente que não é um _über-jar_ à medida que as dependências são copiadas para o `build/quarkus-app/lib/` diretório.

O aplicativo agora é executável usando `java -jar build/quarkus-app/quarkus-run.jar`.

Se você deseja construir um _über-jar_, execute o seguinte comando:
```shell script
./gradlew build -Dquarkus.package.type=uber-jar
```

O aplicativo, empacotado como umn _über-jar_, agora é executável usando `java -jar build/*-runner.jar`.

## Guias relacionados

- REST Client ([guide](https://quarkus.io/guides/rest-client)): Call REST services
- RESTEasy JAX-RS ([guide](https://quarkus.io/guides/rest-json)): REST endpoint framework implementing JAX-RS and more
- SmallRye Health ([guide](https://quarkus.io/guides/microprofile-health)): Monitor service health

## Código fornecido

### REST Client

Invoque diferentes serviços por meio de REST com JSON

[Related guide section...](https://quarkus.io/guides/rest-client)

### RESTEasy JAX-RS

Inicie facilmente seus serviços Web RESTful

[Related guide section...](https://quarkus.io/guides/getting-started#the-jax-rs-resources)

### SmallRye Health

Monitore a integridade do seu aplicativo usando o SmallRye Health

[Related guide section...](https://quarkus.io/guides/smallrye-health)

### Roadmap

- [x] Configurar conexão com banco de dados
- [x] Configurar Swagger
- [x] Criar módulo de usuário
- [x] Configurar autenticação jwt
- [ ] Criar módulo de permissão
