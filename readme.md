


# Projeto Spring Boot com Oracle - Controle Financeiro

## Visão Geral
Este projeto tem como objetivo desenvolver uma aplicação Spring Boot que gerencia informações de clientes, contas e endereços, utilizando um banco de dados Oracle. A aplicação oferece funcionalidades como:

* **Cadastro e atualização:** de clientes, contas e endereços.
* **Consulta:** de informações sobre clientes e contas.
* **Relatórios:** geração de relatórios personalizados.
* **Integração com Oracle:** utilizando Spring Data JPA para interagir com o banco de dados.

## Pré-requisitos
* Java 11+
* Maven ou Gradle
* Oracle Database
* IDE (Eclipse, IntelliJ, etc.)

## Instalação
1. **Clone o repositório:**
   ```bash
   git clone https://github.com/mBraga28/java-desafio-sistema-controle-financeiro.git
   ```
2. **Importe o projeto:** Importe o projeto para sua IDE preferida.
3. **Configure o banco de dados:**
   * **Criar o banco de dados:** Crie um banco de dados Oracle.
   * **Criar as tabelas:** Execute os scripts SQL presentes no diretório `db/scripts/`.
   * **Configurar as propriedades:** Configure as propriedades de conexão com o banco de dados no arquivo `application.properties` ou `application.yml`.

## Estrutura do Projeto
* **src/main/java:** Contém o código fonte Java, incluindo as entidades, enums, repositórios, serviços, controladores e dtos.
* **db:** Contém os scripts SQL para criação das tabelas e outros objetos do banco de dados.
* **resources:** Contém os arquivos de configuração, como `application.properties`.

## Como Executar
1. **Construir o projeto:** Execute o comando `mvn clean package` ou o comando equivalente no Gradle.
2. **Iniciar a aplicação:** Execute a classe principal da aplicação (geralmente a que contém o método `main`).

## Endpoints da API
* **[Listar todos os endpoints da sua API, com exemplos de requisições e respostas]**

## Contribuições
Contribuições são bem-vindas! Para contribuir, por favor, siga estes passos:
1. Fork este repositório.
2. Crie um novo branch para sua feature.
3. Faça suas alterações e commit.
4. Envie um pull request.

## Autores
* Marco Braga -  <a href = "marco__braga@outlook.com">marco__braga@outlook.com<a>

## Agradecimentos
* **[Listagem de ferramentas, bibliotecas ou pessoas que contribuíram]**
