# Microserviço - Notificação (ms-notificacao)
## Sobre o Projeto

O ms-notificacao é um microserviço responsável pelo processamento e envio de notificações do sistema por email.

Ele atua de forma independente e desacoplada, integrando-se aos demais microserviços por meio de APIs REST, garantindo escalabilidade e separação de responsabilidades na arquitetura.

##

## Arquitetura do Sistema

### O microserviço é responsável por:

● Envio de notificações por e-mail

● Processamento de solicitações vindas de outros microserviços

● Gerenciamento do status das notificações

● Integração com a arquitetura de microserviços

### Fluxo do sistema:

● Cliente → BFF → Microserviço de Notificação → Serviço de envio de e-mail

## Segurança

A API pode ser protegida e integrada com mecanismos de autenticação do ecossistema, garantindo que apenas serviços autorizados possam solicitar envio de notificações.

A comunicação ocorre via APIs REST dentro da arquitetura de microserviços.

##

## Documentação da API (Swagger)

### A documentação da API pode ser acessada em:

●  http://localhost:8082/swagger-ui.html

## Tecnologias Utilizadas

● Java 17

● Spring Boot

● Spring Web (REST)

● Gradle

● Docker

## Pré-requisitos

### Antes de executar o projeto você precisa ter instalado:

● Java 17

●Gradle

ou

● Docker

##

## Como Executar o Projeto

### Executando via Gradle

●  ./gradlew bootRun

### Executando via Docker

●  Build da imagem:

●  docker build -t ms-notificacao .

### Executar o container:

●  docker run -p 8082:8082 ms-notificacao

### Endpoints Expostos

●  Serviço	Porta

●  Notificação API	8082

##

## Benefícios da Arquitetura

● Desacoplamento entre serviços

● Escalabilidade

● Organização modular

● Containerização com Docker

● Pipeline de CI/CD com GitHub Actions

##

## Melhorias Futuras

● Implementar mensageria (RabbitMQ ou Kafka)

● Adicionar monitoramento com Actuator

● Retry automático para falhas de envio

● Deploy em ambiente Cloud

##

Desenvolvido por **Geisivan Vitena**

LinkedIn:  
https://www.linkedin.com/in/geisivan-vitena-a46168246/