# Microserviço de Notificação

Microserviço responsável pelo processamento e envio de notificações do sistema, operando de forma independente e desacoplada, integrando aos demais microserviços por meio de APIs REST.

## Responsabilidades
- Enviar notificações aos usuários do sistema por e-mail
- Consumir eventos gerados por outros microserviços
- Gerenciar o status das notificações
- Garantir escalabilidade, confiabilidade e desacoplamento

## Tecnologias Utilizadas

- Java 17
- Spring Boot
- Gradle
- GitHub Actions (CI/CD)
