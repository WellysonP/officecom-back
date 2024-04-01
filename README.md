# Documentação do Backend em Quarkus

Este é um guia para iniciar e acessar o backend em Quarkus, que está rodando em um ambiente Docker.

## Inicialização do Backend

Certifique-se de ter o Docker instalado em seu sistema antes de prosseguir.

1. Abra o terminal.

2. Navegue até o diretório do projeto onde está localizado o backend Quarkus.

3. Execute o seguinte comando para iniciar o servidor e o banco de dados PostgreSQL:

    ```bash
   docker-compose up
    ```

Este comando iniciará o servidor Quarkus e o banco de dados PostgreSQL em contêineres Docker. O servidor estará acessível na porta 8080 e o banco de dados PostgreSQL na porta 5432.

## Acesso à Documentação

Após iniciar o servidor, pela url "http://localhost/8080", você pode direcionado a uma página home, onde poderá acessar a documentação do Swagger. Ou pode acessar diretamente "http://localhost/8080/docs"

Isso abrirá a página inicial da documentação, onde você poderá explorar os endpoints da API usando o Swagger UI.

## Credenciais de Acesso ao Banco de Dados

O banco de dados PostgreSQL está rodando em um contêiner Docker com as seguintes credenciais padrão:

- Usuário: postgres 
- Senha: postgres 
- Porta: 5432

## Usuário Padrão

Uma migração do banco de dados adiciona um usuário padrão com as seguintes credenciais:

- Email: admin@officom 
- Senha: admin

Certifique-se de usar essas credenciais para acessar a aplicação.
