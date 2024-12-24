# Spring with Keycloak and OAuth2

Este repo mostra como configurar o Keycloak como servidor de Authorization, na qual uma aplicação Spring Boot
com suporte a OAuth2 controla o acesso a certos endpoints via Roles encapsulados no access_token enviado 
pelo Keycloak.

A implementação tem como referência o tutorial:

https://levelup.gitconnected.com/integrating-keycloak-with-spring-boot-3-authentication-and-authorization-using-oauth2-0-6d3a2376f672

## Instructions

Clonar este repositório

Executar comando: 
docker compose up -d

### Acessar Keycloak: 
http://localhost:8181/admin

Login: admin

Password: admin

Obs: ao executar o container do Keycloak as configurações do realm usado nesta implementação 
são importadas automaticamente (ver tutorial). No entanto, é necessário criar o usuário usado
para acesar endpoints protegidos da aplicação Spring.

### No Keycloak, acessar opção Users
Adicionar um usuário

Configurar senha do usuário

Associar Roles ADMIN ou USER para o usuário (é possível adicionar novas Roles)

### Executar aplicação Spring

Recuperar token (ver tutorial, necessário configurar headers com campos de login e password do usuário criado)

http://localhost:8181/realms/spring-keycloak-realm/protocol/openid-connect/token

### Testar endpoints

http://localhost:9090/api/v1/admin/hello

http://localhost:9090/api/v1/public/hello

http://localhost:9090/api/v1/user/hello