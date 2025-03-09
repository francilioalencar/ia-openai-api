# API para Integração com OpenAI

Este projeto implementa uma API que realiza a integração com a OpenAI, utilizando as APIs indicadas no DOC da OpenAi e Spring AI com Chat Client API. 
A API oferece endpoints para enviar requisições à OpenAI e obter respostas baseadas em prompts fornecidos pelo usuário. Não foi implementado segurança, o objetivo aqui é simplismente realizar as requisições a OpenAi seguindo a documentação em: https://platform.openai.com/docs/overview e https://spring.io/projects/spring-ai

## Tecnologias Utilizadas

- **Java 17**: Ambiente de desenvolvimento.
- **Spring AI**: API Spring para requisições aos modelos de IAs, (aqui foi utilizado spring-ai-openai).
- **OpenFeign**: Para realizar requisições HTTP à API da OpenAI.
- **simple-openai**: Biblioteca por Sashir Estela para interagir com a OpenAI.
- **JTokkit**: Java Tokenizer Kit para contagem de tokens.
- **springdoc-openapi**: Para documentar e realizar testes nos endpoints da API.
- **Spring Web**: Para disponibilizar e expor os endpoints da API.

## Endpoints

### `/requestOpenFeign`

- **Método**: `POST`
- **Descrição**: Realiza uma requisição POST à API da OpenAI (endpoint: `https://api.openai.com/v1/chat/completions`) utilizando o **OpenFeign**.
  
### `/sashirestelaApi`

- **Método**: `POST`
- **Descrição**: Utiliza a biblioteca **simple-openai** para realizar as requisições à OpenAI.
  
### `/chatClientOpenAi`

- **Método**: `POST`
- **Descrição**: Utiliza a biblioteca **Spring AI (spring-ai-openai)** para realizar as requisições à OpenAI.

### `DTO: Prompt`

   ```bash
   {
    "user": "string",
    "system": "string"
  }
   
  ```  


### Contagem de Tokens

- Utiliza a biblioteca **JTokkit** para contar o número de tokens no prompt.
- Caso o número de tokens ultrapasse 128K, será lançado um erro `IllegalArgumentException`, informando que a quantidade de tokens excedeu o limite permitido.

## Como Rodar o Projeto Localmente

### Pré-requisitos

- **Java 17**: Ambiente de desenvolvimento.
- **Maven**: Para gerenciar as dependências e rodar o projeto.
- **Docker**: Usado para construir e rodar os containers.
- **Docker Compose**: Para orquestrar os containers.



## Deployment  
**Clone o repositório**:
   ```bash
   git clone https://github.com/francilioalencar/ia-openai-api.git
   
  ```  
**Variaveis de ambiente**:
  No diretório raiz do projeto crie um diretório chamdo env e dentro do diretorio env crie o arquivo api.env com as seguintes variáveis:
   ```bash
    OPEN_AI_KEY= KEY-OPENAI
    OPEN_AI_MODEL=MODELO
   
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