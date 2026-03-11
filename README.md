# Microserviço de Notificação (ms-notificacao)

![Build Status](https://img.shields.io/badge/build-passing-brightgreen)
![Java 17](https://img.shields.io/badge/java-17-brightgreen)
![Spring Boot 3.3.5](https://img.shields.io/badge/spring_boot-3.3.5-brightgreen)
![Gradle 8.3](https://img.shields.io/badge/gradle-8.3-blue)
![Dependências Seguras](https://img.shields.io/badge/dependencies-secure-brightgreen)
![GitHub Actions](https://github.com/geisivanvitena/notificacao/actions/workflows/gradle.yml/badge.svg)

[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=geisivanvitena_notificacao&metric=alert_status)](https://sonarcloud.io/summary/new_code?id=geisivanvitena_notificacao)
[![Bugs](https://sonarcloud.io/api/project_badges/measure?project=geisivanvitena_notificacao&metric=bugs)](https://sonarcloud.io/summary/new_code?id=geisivanvitena_notificacao)
[![Vulnerabilities](https://sonarcloud.io/api/project_badges/measure?project=geisivanvitena_notificacao&metric=vulnerabilities)](https://sonarcloud.io/summary/new_code?id=geisivanvitena_notificacao)
[![Code Smells](https://sonarcloud.io/api/project_badges/measure?project=geisivanvitena_notificacao&metric=code_smells)](https://sonarcloud.io/summary/new_code?id=geisivanvitena_notificacao)
[![Duplications](https://sonarcloud.io/api/project_badges/measure?project=geisivanvitena_notificacao&metric=duplicated_lines_density)](https://sonarcloud.io/summary/new_code?id=geisivanvitena_notificacao)

---

### Contexto do Projeto

O **ms-notificacao** é uma API REST desenvolvida em **Java com Spring Boot** e faz parte do projeto **Agendador de Tarefas**, construído com base em arquitetura de microserviços.

Este microserviço é responsável pelo processamento e envio de notificações por e-mail dentro do ecossistema da aplicação.

Ele atua de forma independente e desacoplada, sendo acionado por outros serviços principalmente pelo **BFF** e pelo microserviço de **agendamento** sempre que uma notificação precisa ser enviada.

O microserviço está **dockerizado**, permitindo execução isolada, portabilidade e integração rápida com o ecossistema de microserviços.

---

### Papel na Arquitetura de Microserviços

Na arquitetura do Agendador de Tarefas, cada serviço possui responsabilidade única e bem definida.

O **ms-notificacao** é responsável por:

- Receber solicitações de envio de notificação

- Processar requisições vindas de outros microserviços

- Realizar envio de e-mails

- Gerenciar o status das notificações

- Expor métricas e monitoramento da aplicação

A comunicação ocorre via **HTTP** utilizando padrão REST, com troca de dados em formato **JSON**.

**Fluxo arquitetural:**

    Cliente → BFF → ms-notificacao → Serviço de envio de e-mail

**Essa abordagem garante:**

- Separação clara de responsabilidades

- Desacoplamento entre domínio de tarefas e envio de notificações

- Escalabilidade independente do serviço de e-mail

- Facilidade de manutenção

---

### API REST

O **ms-notificacao** expõe endpoints REST **stateless** utilizando:

- Método HTTP (POST para envio de notificações)

- Representação de recursos em JSON

- Comunicação síncrona via HTTP dentro da arquitetura

O serviço segue os princípios REST e não mantém estado entre requisições.

---

#### Integração com OpenFeign

O **ms-notificacao** utiliza **OpenFeign** para comunicação declarativa entre microserviços, permitindo:

- Redução de código boilerplate
- Padronização de chamadas HTTP
- Facilidade na manutenção de endpoints remotos

---

### Segurança

A API pode ser integrada ao mecanismo de autenticação centralizado do sistema, utilizando JWT emitido pelo **ms-usuarios**.

Dessa forma, apenas serviços autorizados conseguem solicitar o envio de notificações.

---

### Observabilidade

O microserviço utiliza **Spring Boot Actuator** para monitoramento e exposição de métricas operacionais.

**Os endpoints de gerenciamento permitem:**

- Healthcheck da aplicação

- Monitoramento de disponibilidade

- Exposição de métricas

- Informações do ambiente

**Exemplo de endpoint:**

    http://localhost:8082/actuator/health

A utilização do Actuator permite monitorar a disponibilidade do serviço de notificação dentro do ecossistema distribuído.

---

### Documentação da API

A documentação da API está disponível via **Swagger:**

    http://localhost:8082/swagger-ui.html

---

### Tecnologias Utilizadas

- Java 17

- Spring Boot

- Spring Web

- Spring Actuator

- Gradle

- Docker

---

### Endpoints Expostos

| Serviço         |	Porta |
|-----------------|-------| 
| Notificação API	| 8082  |

---

### Execução do Projeto

**Gradle**

    ./gradlew bootRun

**Docker**

    docker build -t notificacao-api .

    docker run -p 8082:8082 notificacao-api

O uso de Docker permite rodar o serviço de forma isolada, consistente em qualquer ambiente e facilita o deploy em produção ou integração com outros microserviços.

---

### Benefícios Arquiteturais

- Desacoplamento entre serviços

- Escalabilidade independente

- Organização modular

- Containerização via Docker, garantindo portabilidade, isolamento e facilidade de deploy

- Observabilidade integrada via Actuator

---

### Melhorias Futuras

- Implementar mensageria (RabbitMQ ou Kafka)

- Retry automático para falhas de envio

- Estratégias de resiliência

- Implementação de testes automatizados (unitários e de integração)

- Deploy em ambiente Cloud

---

### Autor

**Geisivan Vitena**

LinkedIn:  
https://www.linkedin.com/in/geisivan-vitena-a46168246/
