# 🍔 BN Burguer - Backend

Backend do sistema **BN Burguer**, desenvolvido para gerenciar pedidos, produtos e o painel administrativo de uma hamburgueria.

## 🚀 Tecnologias

- Java 21
- Spring Boot
- Spring Data JPA
- Hibernate
- MySQL
- Maven
- REST API

---

## 📋 Funcionalidades

### Cliente
- Visualização do cardápio
- Realização de pedidos
- Escolha da forma de pagamento
- Escolha entre entrega ou retirada
- Acompanhamento do status do pedido
- Envio do pedido para WhatsApp

### Administrador
- Login administrativo
- Painel de pedidos
- Atualização do status dos pedidos
- Cadastro de produtos
- Edição de produtos
- Ativar/Desativar produtos
- Dashboard com pedidos em tempo real

---

## 📁 Estrutura do Projeto

```
src
 ├── controller
 ├── model
 ├── repository
 ├── service
 ├── dto
 └── config
```

---

## ⚙️ Como executar

### Clone o projeto

```bash
git clone https://github.com/SEU-USUARIO/delivery-backend.git
```

### Configure o banco de dados

Edite o arquivo:

```
application.properties
```

Configure:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/delivery
spring.datasource.username=SEU_USUARIO
spring.datasource.password=SUA_SENHA
```

### Execute

```bash
mvn spring-boot:run
```

A aplicação ficará disponível em:

```
http://localhost:8080
```

---

## 📡 Principais Endpoints

### Produtos

```
GET /produtos
POST /produtos
PUT /produtos/{id}
```

### Pedidos

```
GET /pedidos
POST /pedidos
PUT /pedidos/{id}/status
```

### Login Admin

```
POST /admin/login
```

---

## 🔮 Melhorias Futuras

- Upload de imagens dos produtos
- Histórico de pedidos
- Relatórios de vendas
- Impressão automática de pedidos
- Autenticação com JWT
- Deploy em nuvem

---

## 👨‍💻 Desenvolvedor

**Túlio Reis**

LinkedIn:
www.linkedin.com/in/tulio-reis


GitHub:
https://github.com/txlio
