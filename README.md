# Spring with Keycloak and OAuth2

Este repo mostra como configurar o Keycloak como servidor de Authorization, na qual um aplicação Spring Boot
com suporte a OAuth2 controla o acesso a certo endpoints via Grants encapsulados no access_token enviado 
pelo Keycloak.

A implementação tem como referência o tutorial:
https://levelup.gitconnected.com/integrating-keycloak-with-spring-boot-3-authentication-and-authorization-using-oauth2-0-6d3a2376f672

## Instructions

-- Clonar este repositório

-- Executar comando
--- docker compose up -d

### Acessar Keycloak: http://localhost:8181/admin
-- Login: admin
-- Password: admin

### Acessar opção Users
-- Adicionar um cliente
-- Configurar senha do cliente
-- Associar Roles ADMIN ou USER para o cliente (é possível adicionar novas Roles)

### Executar aplicação Spring

-- Recuperar token (ver tutorial, necessario configurar headers com campos de login e password do usuário criado)
--- http://localhost:8181/realms/spring-keycloak-realm/protocol/openid-connect/token

-- Testar endpoints
--- http://localhost:9090/api/v1/admin/hello
--- http://localhost:9090/api/v1/public/hello
--- http://localhost:9090/api/v1/user/hello