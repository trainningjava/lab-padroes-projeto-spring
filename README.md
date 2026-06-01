# Explorando Padrões de Projeto com Spring Boot

Projeto desenvolvido para praticar a implementação de **Padrões de Projeto (Design Patterns)** utilizando **Java + Spring Boot**, baseado no laboratório da DIO.

## Objetivo

Este projeto demonstra, na prática, como aplicar padrões de projeto em uma API REST utilizando o ecossistema Spring.

Os padrões implementados são:

* **Singleton**
* **Strategy**
* **Facade**

Além disso, o sistema realiza integração com a API do ViaCEP para consulta automática de endereço a partir do CEP informado.

---

## Tecnologias Utilizadas

* Java 11
* Spring Boot
* Spring Web
* Spring Data JPA
* OpenFeign
* H2 Database
* Swagger / OpenAPI
* Maven

---

## Estrutura do Projeto

```txt
src/main/java
└── one.digitalinnovation.gof
    ├── controller
    │   └── ClienteRestController.java
    ├── model
    │   ├── Cliente.java
    │   ├── Endereco.java
    │   ├── ClienteRepository.java
    │   └── EnderecoRepository.java
    ├── service
    │   ├── ClienteService.java
    │   ├── ViaCepService.java
    │   └── impl
    │       └── ClienteServiceImpl.java
    └── Application.java
```

---

## Padrões de Projeto Aplicados

### Singleton

O Spring gerencia automaticamente os componentes anotados com `@Service`, `@Repository` e `@Component` como instâncias únicas (**Singleton**).

Exemplo:

```java
@Service
public class ClienteServiceImpl {
}
```

No projeto, isso acontece principalmente na camada de serviços e repositórios.

---

### Strategy

O padrão **Strategy** é utilizado através da interface `ClienteService`, permitindo desacoplar a implementação da regra de negócio.

Interface:

```java
public interface ClienteService {
    Iterable<Cliente> buscarTodos();
    Cliente buscarPorId(Long id);
    void inserir(Cliente cliente);
    void atualizar(Long id, Cliente cliente);
    void deletar(Long id);
}
```

Implementação:

```java
@Service
public class ClienteServiceImpl implements ClienteService {
}
```

Esse padrão facilita manutenção, testes e evolução da aplicação.

---

### Facade

O `ClienteRestController` funciona como uma **Facade**, abstraindo a complexidade do sistema.

Ele centraliza:

* acesso ao banco H2;
* comunicação com a API ViaCEP;
* regras de negócio da aplicação.

Assim, o consumidor da API interage apenas com endpoints REST simples.

---

## Como Executar o Projeto

### Pré-requisitos

* Java 11+
* Maven

### Clonar o repositório

```bash
git clone <URL_DO_REPOSITORIO>
```

### Entrar na pasta do projeto

```bash
cd lab-padroes-projeto-spring
```

### Executar aplicação

Linux/macOS:

```bash
./mvnw spring-boot:run
```

Windows:

```bash
mvnw.cmd spring-boot:run
```

Ou:

```bash
mvn spring-boot:run
```

---

## Banco H2

A aplicação utiliza banco em memória H2.

Console H2:

```txt
http://localhost:8080/h2-console
```

---

## Swagger / OpenAPI

Documentação interativa da API:

```txt
http://localhost:8080/swagger-ui.html
```

---

## Endpoints da API

### Buscar todos os clientes

```http
GET /clientes
```

### Buscar cliente por ID

```http
GET /clientes/{id}
```

### Inserir cliente

```http
POST /clientes
```

Exemplo de body:

```json
{
  "nome": "João Silva",
  "endereco": {
    "cep": "01001000"
  }
}
```

### Atualizar cliente

```http
PUT /clientes/{id}
```

### Remover cliente

```http
DELETE /clientes/{id}
```

---

## Fluxo da Aplicação

1. O usuário envia um cliente com CEP.
2. O sistema verifica se o endereço já existe no banco.
3. Caso não exista, consulta a API ViaCEP.
4. O endereço é salvo.
5. O cliente é persistido com o endereço vinculado.

---

## Melhorias Futuras

* Adicionar validações com Bean Validation
* Melhorar tratamento de exceções
* Criar testes unitários
* Implementar DTOs
* Adicionar paginação
* Dockerizar a aplicação

---

## Aprendizados

Este projeto demonstra como aplicar Design Patterns usando recursos do Spring Boot, tornando a aplicação mais organizada, desacoplada e escalável.
