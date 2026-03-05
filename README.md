# Perfumaria Swagger API

Uma API REST documentada com Swagger/OpenAPI 3.0 para gerenciamento de uma perfumaria, construída com Spring Boot 4.0.

## 📋 Documentação da API

A documentação interativa da API está disponível em: **`http://localhost:8080/swagger-ui.html`**

---

## 🚀 Guia para Colaboradores: Adicionando Novos Endpoints

Este guia mostra como adicionar novos endpoints mantendo a coerência e documentação do projeto.

### **Estrutura do Projeto**

```
src/main/java/com/example/perfumaria_swagger/
├── controller/      # REST Controllers com endpoints
├── model/           # Entidades JPA/Bean
├── DTO/             # Data Transfer Objects (Records)
└── service/         # (Opcional) Lógica de negócio
```

---

## 📝 Passo 1: Criar o Controller

### 1.1 Crie o arquivo do controller

Crie um novo arquivo em `src/main/java/com/example/perfumaria_swagger/controller/`

**Nomenclatura:** `NomeController.java`

### 1.2 Estrutura básica do Controller

```java
package com.example.perfumaria_swagger.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/sua-rota")
@Tag(name = "Nome da Feature", description = "Descrição breve da sua feature")
public class SuaNovaController {

    // ========== GET ==========
    @GetMapping
    @Operation(summary = "Listar todos", description = "Retorna uma lista de todos os registros")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Lista retornada com sucesso"),
        @ApiResponse(responseCode = "500", description = "Erro no servidor")
    })
    public ResponseEntity<?> findAll() {
        return ResponseEntity.status(501).build(); // Not Implemented
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar por ID", description = "Retorna um registro específico pelo ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Registro encontrado"),
        @ApiResponse(responseCode = "404", description = "Registro não encontrado"),
        @ApiResponse(responseCode = "500", description = "Erro no servidor")
    })
    public ResponseEntity<?> findById(@PathVariable Integer id) {
        return ResponseEntity.status(501).build(); // Not Implemented
    }

    @PostMapping
    @Operation(summary = "Criar novo", description = "Cria um novo registro")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Registro criado com sucesso"),
        @ApiResponse(responseCode = "400", description = "Dados inválidos"),
        @ApiResponse(responseCode = "500", description = "Erro no servidor")
    })
    public ResponseEntity<?> save(@RequestBody SuaRequest request) {
        return ResponseEntity.status(501).build(); // Not Implemented
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar", description = "Atualiza um registro existente")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Registro atualizado com sucesso"),
        @ApiResponse(responseCode = "404", description = "Registro não encontrado"),
        @ApiResponse(responseCode = "400", description = "Dados inválidos"),
        @ApiResponse(responseCode = "500", description = "Erro no servidor")
    })
    public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody SuaRequest request) {
        return ResponseEntity.status(501).build(); // Not Implemented
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deletar", description = "Remove um registro pela ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "204", description = "Registro deletado com sucesso"),
        @ApiResponse(responseCode = "404", description = "Registro não encontrado"),
        @ApiResponse(responseCode = "500", description = "Erro no servidor")
    })
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        return ResponseEntity.status(501).build(); // Not Implemented
    }
}
```

---

## 🏛️ Passo 2: Criar Models e DTOs

### 2.1 Criar o Model (Entidade)

Crie em `src/main/java/com/example/perfumaria_swagger/model/`

```java
package com.example.perfumaria_swagger.model;

public class MinhaEntidade {
    
    private Integer id;
    private String nome;
    private String descricao;
    private Boolean ativo;
    
    // Construtores
    public MinhaEntidade() {}
    
    public MinhaEntidade(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
    }
    
    // Getters e Setters
    public Integer getId() {
        return id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    
    public String getNome() {
        return nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }
}
```

### 2.2 Criar o DTO Request

Crie em `src/main/java/com/example/perfumaria_swagger/DTO/`

```java
package com.example.perfumaria_swagger.DTO;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Dados de entrada para criar/atualizar")
public record MinhaEntidadeRequest(
    @Schema(description = "Nome da entidade", example = "Perfume Floral")
    String nome,
    
    @Schema(description = "Descrição", example = "Uma descrição detalhada")
    String descricao,
    
    @Schema(description = "Status ativo", example = "true")
    Boolean ativo
) {
}
```

### 2.3 Criar o DTO Response

```java
package com.example.perfumaria_swagger.DTO;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Dados de resposta")
public record MinhaEntidadeResponse(
    @Schema(description = "ID único", example = "1")
    Integer id,
    
    @Schema(description = "Nome da entidade", example = "Perfume Floral")
    String nome,
    
    @Schema(description = "Descrição", example = "Uma descrição detalhada")
    String descricao,
    
    @Schema(description = "Status", example = "true")
    Boolean ativo
) {
}
```

---

## 🔐 Passo 3: Adicionar Anotações Swagger/OpenAPI

As anotações já estão no Controller, mas aqui está a referência completa:

### 3.1 Anotações Principais

| Anotação | Onde Usar | Função |
|----------|-----------|--------|
| `@Tag` | Na classe Controller | Define o grupo de endpoints na documentação |
| `@Operation` | Em cada método | Descreve o que o endpoint faz |
| `@ApiResponse` | Em cada método | Documenta cada possível resposta HTTP |
| `@ApiResponses` | Em cada método | Container para múltiplas respostas |
| `@Schema` | Em DTOs e parâmetros | Documenta estrutura e exemplos de dados |
| `@RequestBody` | Em parâmetros | Documenta o corpo da requisição |
| `@PathVariable` | Em parâmetros | Documenta variáveis da URL |
| `@RequestParam` | Em parâmetros | Documenta parâmetros de query |

### 3.2 Exemplo Completo com Anotações

```java
@RestController
@RequestMapping("/produtos")
@Tag(name = "Produtos", description = "Gerenciamento de produtos")
public class ProdutoController {

    @PostMapping
    @Operation(
        summary = "Criar produto",
        description = "Cria um novo produto na loja com validação completa"
    )
    @ApiResponses(value = {
        @ApiResponse(
            responseCode = "201",
            description = "Produto criado com sucesso",
            content = @Content(
                mediaType = "application/json",
                schema = @Schema(implementation = ProdutoResponse.class)
            )
        ),
        @ApiResponse(
            responseCode = "400",
            description = "Dados inválidos - validação falhou"
        ),
        @ApiResponse(
            responseCode = "500",
            description = "Erro interno do servidor"
        )
    })
    public ResponseEntity<ProdutoResponse> criar(
        @io.swagger.v3.oas.annotations.parameters.RequestBody(
            description = "Dados do novo produto",
            required = true,
            content = @Content(schema = @Schema(implementation = ProdutoRequest.class))
        )
        @RequestBody ProdutoRequest request
    ) {
        // Implementação aqui
        return ResponseEntity.status(201).build();
    }
}
```

---

## 💡 Dica: Use GitHub Copilot para Acelerar

### Usando o Copilot para gerar código automático:

1. **Abra um novo arquivo Controller**
2. **Digite o comentário:**
   ```java
   // Controller para gerenciamento de [seu recurso]
   // Implemente CRUD com endpoints GET, POST, PUT, DELETE
   // Use anotações Swagger/OpenAPI
   // Retorne 501 Not Implemented para todos os endpoints
   ```
3. **Pressione `Ctrl + Enter`** (ou use o Copilot Chat)
4. **O Copilot gerará** o controller completo com:
   - Anotações corretas
   - Estrutura CRUD padrão
   - Documentação Swagger automática
   - Status 501 Not Implemented

### Exemplo de Chat no Copilot:

> "Crie um Controller chamado MarcaController para gerenciar marcas de perfumes. Use Record para DTOs, anotações OpenAPI/Swagger, e retorne 501 Not Implemented para todos os endpoints."

---

## ✅ Checklist para Colaboradores

Antes de fazer um Pull Request:

- [ ] Criei o Controller em `controller/`
- [ ] Criei o Model em `model/`
- [ ] Criei os DTOs Request e Response em `DTO/`
- [ ] Todos os endpoints retornam `ResponseEntity.status(501).build()` (Not Implemented)
- [ ] Adicionei `@Tag` na classe Controller
- [ ] Adicionei `@Operation` em cada método
- [ ] Adicionei `@ApiResponses` em cada método
- [ ] Adicionei `@Schema` em todos os campos dos DTOs
- [ ] Testei acessando `http://localhost:8080/swagger-ui.html` para verificar a documentação
- [ ] Nenhum erro de compilação
- [ ] Seguindo as conventions do projeto (nomes, pacotes, estrutura)

---

## 📚 Referência de Dependências

As dependências do Swagger já estão configuradas no `pom.xml`:

```xml
<dependency>
    <groupId>org.springdoc</groupId>
    <artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>
    <version>3.0.2</version>
</dependency>
```

---

## 🔗 Exemplos Existentes

Confira os controllers já implementados para referência:

- [`ItemController.java`](src/main/java/com/example/perfumaria_swagger/controller/ItemController.java)
- [`CategoriaController.java`](src/main/java/com/example/perfumaria_swagger/controller/CategoriaController.java)
- [`FamiliaAromaController.java`](src/main/java/com/example/perfumaria_swagger/controller/FamiliaAromaController.java)

---

## 🎯 Próximas Etapas (Após os 3 Passos)

Depois que o Controller com 501 Not Implemented está pronto:

1. **Implementar a lógica** gradualmente
2. **Criar a Service** se necessário
3. **Integrar com banco de dados** (JPA/Repository)
4. **Adicionar validações** (@Valid, @NotBlank, etc)
5. **Implementar testes unitários**
6. **Submeter Pull Request** para code review

---

## 📞 Dúvidas?

Consulte a [documentação oficial do SpringDoc OpenAPI](https://springdoc.org/)

Boa sorte! 🚀