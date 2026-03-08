package com.example.perfumaria_swagger.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class ClienteController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @PostMapping("/clientes")
    public ResponseEntity<Cliente> cadastro(@RequestBody Cliente cliente) {
        try {
            LocalDate dataCadastro = LocalDate.parse(cliente.getDataCadastro());

            jdbcTemplate.update(
                    "INSERT INTO cliente(nome, email, telefone, idade, endereco, data_cadastro, genero, interesse, tipo_cliente_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)",
                    cliente.getNome(),
                    cliente.getEmail(),
                    cliente.getTelefone(),
                    cliente.getIdade(),
                    cliente.getEndereco(),
                    java.sql.Date.valueOf(dataCadastro),
                    cliente.getGenero(),
                    String.join(",", cliente.getInteresses()),
                    cliente.getTipoClienteId()
            );

            cliente.setDataCadastro(dataCadastro.toString());

            return ResponseEntity.status(201).body(cliente);

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(400).body(null);
        }
    }

    @GetMapping("/tipos")
    public ResponseEntity<List<TipoCliente>> listarTipos(){

        List<TipoCliente> tipos = jdbcTemplate.query(
                "SELECT * FROM tipo_cliente",
                new BeanPropertyRowMapper<>(TipoCliente.class)
        );

        return ResponseEntity.ok(tipos);
    }
}
