# Personal Trainer Management System

Este é um sistema de gerenciamento para personal trainers, desenvolvido para ajudar a gerenciar alunos, matrículas, pagamentos, avaliações físicas e fichas de treino. Este sistema está em constante melhoria com novas implantações.

## Tecnologias Utilizadas

- **Backend**:
    - Java 22
    - Spring Boot 3.3.1
    - Maven
    - PostgreSQL
    - Docker

- **Frontend**:
    - React
    - TypeScript
    - Vite

## Configuração do Projeto

### Pré-requisitos

- JDK 22
- IntelliJ IDEA Ultimate
- Docker

### Passos para Configuração

1. **Clone o repositório:**

    ```sh
    git clone https://github.com/seu-usuario/personal-trainer-system.git
    cd personal-trainer-system
    ```

2. **Configuração do Docker:**

   Certifique-se de que o Docker está em execução no seu sistema. No diretório raiz do projeto, crie um arquivo `docker-compose.yml` com o seguinte conteúdo:

    ```yaml
    services:
      postgres:
        image: postgres:latest
        environment:
          POSTGRES_USER: postgres
          POSTGRES_PASSWORD: yourpassword
          POSTGRES_DB: personal_trainer
        ports:
          - "5432:5432"
        volumes:
          - pgdata:/var/lib/postgresql/data
    volumes:
      pgdata:
    ```

   Inicie o contêiner PostgreSQL:

    ```sh
    docker-compose up -d
    ```

3. **Configuração do Spring Boot:**

   No arquivo `src/main/resources/application.properties`, configure as propriedades de conexão com o banco de dados PostgreSQL:

    ```properties
    spring.datasource.url=jdbc:postgresql://localhost:5432/personal_trainer
    spring.datasource.username=postgres
    spring.datasource.password=yourpassword
    spring.jpa.hibernate.ddl-auto=update
    spring.jpa.show-sql=true
    spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
    ```

4. **Iniciar a Aplicação:**

   Execute o comando para iniciar a aplicação Spring Boot:

    ```sh
    ./mvnw spring-boot:run
    ```

### Endpoints da API

Abaixo estão os principais endpoints da API:

#### Alunos

- **Listar todos os alunos**: `GET /api/alunos`
- **Criar um novo aluno**: `POST /api/alunos`
- **Consultar aluno por CPF**: `GET /api/alunos/{cpf}`
- **Atualizar aluno por CPF**: `PUT /api/alunos/{cpf}`
- **Excluir aluno por CPF**: `DELETE /api/alunos/{cpf}`

#### Matrículas

- **Listar todas as matrículas**: `GET /api/matriculas`
- **Criar uma nova matrícula**: `POST /api/matriculas`
- **Consultar matrícula por ID**: `GET /api/matriculas/{id}`
- **Atualizar matrícula por ID**: `PUT /api/matriculas/{id}`
- **Excluir matrícula por ID**: `DELETE /api/matriculas/{id}`

#### Pagamentos

- **Listar todos os pagamentos**: `GET /api/pagamentos`
- **Criar um novo pagamento**: `POST /api/pagamentos`
- **Consultar pagamento por ID**: `GET /api/pagamentos/{id}`
- **Atualizar pagamento por ID**: `PUT /api/pagamentos/{id}`
- **Excluir pagamento por ID**: `DELETE /api/pagamentos/{id}`

#### Avaliações Físicas

- **Listar todas as avaliações físicas**: `GET /api/avaliacoes-fisicas`
- **Criar uma nova avaliação física**: `POST /api/avaliacoes-fisicas`
- **Consultar avaliação física por ID**: `GET /api/avaliacoes-fisicas/{id}`
- **Consultar avaliações físicas por CPF**: `GET /api/avaliacoes-fisicas/cpf/{cpf}`
- **Atualizar avaliação física por ID**: `PUT /api/avaliacoes-fisicas/{id}`
- **Excluir avaliação física por ID**: `DELETE /api/avaliacoes-fisicas/{id}`

#### Fichas de Treino

- **Listar todas as fichas de treino**: `GET /api/fichas-de-treino`
- **Criar uma nova ficha de treino**: `POST /api/fichas-de-treino`
- **Consultar ficha de treino por ID**: `GET /api/fichas-de-treino/{id}`
- **Consultar fichas de treino por CPF**: `GET /api/fichas-de-treino/cpf/{cpf}`
- **Atualizar ficha de treino por ID**: `PUT /api/fichas-de-treino/{id}`
- **Excluir ficha de treino por ID**: `DELETE /api/fichas-de-treino/{id}`

### Testando com Postman

Para testar os endpoints da API, utilize o Postman e configure as requisições conforme necessário, incluindo a autenticação básica, se configurada.

### Contribuições

Sinta-se à vontade para contribuir com o projeto. Abra issues e pull requests conforme necessário.



