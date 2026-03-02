# Microserviço de Notificação (ms-notificacao)

### Contexto do Projeto

O ms-notificacao é uma API REST desenvolvida em Java com Spring Boot e faz parte do projeto Agendador de Tarefas, construído com base em arquitetura de microserviços.

Este microserviço é responsável pelo processamento e envio de notificações por e-mail dentro do ecossistema da aplicação.

Ele atua de forma independente e desacoplada, sendo acionado por outros serviços — principalmente pelo BFF e pelo microserviço de agendamento — sempre que uma notificação precisa ser enviada.

##

### Papel na Arquitetura de Microserviços

Na arquitetura do Agendador de Tarefas, cada serviço possui responsabilidade única e bem definida.

O ms-notificacao é responsável por:

● Receber solicitações de envio de notificação

● Processar requisições vindas de outros microserviços

● Realizar envio de e-mails

● Gerenciar o status das notificações

● Expor métricas e monitoramento da aplicação

A comunicação ocorre via HTTP utilizando padrão REST, com troca de dados em formato JSON.

Fluxo arquitetural:

Cliente → BFF → ms-notificacao → Serviço de envio de e-mail

Essa abordagem garante:

● Separação clara de responsabilidades

● Desacoplamento entre domínio de tarefas e envio de notificações

● Escalabilidade independente do serviço de e-mail

● Facilidade de manutenção

##

### API REST

O ms-notificacao expõe endpoints REST stateless utilizando:

● Métodos HTTP (POST para envio de notificações, entre outros)

● Representação de recursos em JSON

● Comunicação síncrona via HTTP dentro da arquitetura

O serviço segue os princípios REST e não mantém estado entre requisições.

##

### Segurança

A API pode ser integrada ao mecanismo de autenticação centralizado do sistema, utilizando JWT emitido pelo ms-usuarios.

Dessa forma, apenas serviços autorizados conseguem solicitar o envio de notificações.

##

### Observabilidade

O microserviço utiliza Spring Boot Actuator para monitoramento e exposição de métricas operacionais.

Os endpoints de gerenciamento permitem:

● Healthcheck da aplicação

● Monitoramento de disponibilidade

● Exposição de métricas

●Informações do ambiente

Exemplo de endpoint:

http://localhost:8082/actuator/health

A utilização do Actuator permite monitorar a disponibilidade do serviço de notificação dentro do ecossistema distribuído.

##

### Tecnologias Utilizadas

● Java 17

● Spring Boot

● Spring Web

● Spring Actuator

● Gradle

● Docker

##

### Documentação da API

A documentação da API está disponível via Swagger:

http://localhost:8082/swagger-ui.html

##

### Execução do Projeto

1. Execução via Gradle

./gradlew bootRun

2. Execução via Docker

Build da imagem:

docker build -t ms-notificacao .

3. Executar o container:

docker run -p 8082:8082 ms-notificacao

##

### Endpoints Expostos

| Serviço         |	Porta |
|-----------------|-------| 
| Notificação API	| 8082  |

##

## Benefícios Arquiteturais

● Desacoplamento entre serviços

● Escalabilidade independente

● Organização modular

● Containerização com Docker

● Observabilidade integrada via Actuator

##

## Melhorias Futuras

● Implementar mensageria (RabbitMQ ou Kafka)

● Retry automático para falhas de envio

● Estratégias de resiliência

● Deploy em ambiente Cloud

##

### Autor

**Geisivan Vitena**

LinkedIn:  
https://www.linkedin.com/in/geisivan-vitena-a46168246/
