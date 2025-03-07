# API para Integração com OpenAI

Este projeto implementa uma API que realiza a integração com a OpenAI, utilizando o modelo GPT-4 Turbo. A API oferece endpoints para enviar requisições à OpenAI e obter respostas baseadas em prompts fornecidos pelo usuário.

## Tecnologias Utilizadas

- **Java 17**: Ambiente de desenvolvimento.
- **OpenFeign**: Para realizar requisições HTTP à API da OpenAI.
- **simple-openai**: Biblioteca por Sashir Estela para interagir com a OpenAI.
- **JTokkit**: Java Tokenizer Kit para contagem de tokens.
- **springdoc-openapi**: Para documentar e realizar testes nos endpoints da API.
- **Spring Web**: Para disponibilizar e expor os endpoints da API.

## Endpoints

### `/completion`

- **Método**: `GET`
- **Descrição**: Realiza uma requisição à API da OpenAI (endpoint: `https://api.openai.com/v1/chat/completions`) utilizando o **OpenFeign**.
- **Parâmetros**: O corpo da requisição deve conter o prompt para interação com o modelo GPT-4 Turbo.
  
### `/openai-chat`

- **Método**: `POST`
- **Descrição**: Utiliza a biblioteca **simple-openai** para realizar as requisições à OpenAI.
- **Parâmetros**: O corpo da requisição deve incluir o prompt para interagir com o modelo GPT-4 Turbo.

### Contagem de Tokens

- Utiliza a biblioteca **JTokkit** para contar o número de tokens no prompt.
- Caso o número de tokens ultrapasse 128K, será lançado um erro `IllegalArgumentException`, informando que a quantidade de tokens excedeu o limite permitido.

## Como Rodar o Projeto Localmente

### Pré-requisitos

- **Java 17**: Ambiente de desenvolvimento.
- **Maven** ou **Gradle**: Para gerenciar as dependências e rodar o projeto.
- **Docker**: Usado para construir e rodar os containers.
- **Docker Compose**: Para orquestrar os containers.



## Deployment  
**Clone o repositório**:
   ```bash
   git clone https://github.com/francilioalencar/ia-openai-api.git
   
  ```  
  
**Executar projeto em containers Docker**:
  1. Certifique-se ter ter instalado o Docker;
  2. Navegue até o diretorio raiz do projeto;
  3. execute o seguinte comando:
   ```bash
   # O comando --build garante que a imagem do projeto seja reconstruída antes de rodar os containers.
   docker-compose up --build

   # Parar execução dos containers
   docker-compose stop

   #Parar execução dos containers, Removendo tudo, incluindo containers, redes e volumes  
   docker-compose down
  ```  

**Executar localmente sem  Docker**:
  1. Certifique-se de ter instalado o JDK-17;
  2. Navegue até o diretorio raiz do projeto;
  3. execute o seguinte comando:
   ```bash
   mvn spring-boot:run
  ```  

## Documentação da API
A documentação e testes dos endpoints podem ser acessados por meio do springdoc-openapi, disponíveis em:
http://localhost:8080/swagger-ui/index.html