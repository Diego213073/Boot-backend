package com.spring.app.bootbackend.service.controller;

import com.spring.app.bootbackend.model.Client;
import com.spring.app.bootbackend.service.ClientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/client")
public class ClientController {

    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping
    public List<Client> findAllClient() {
        return clientService.findAll();
    }

    @PostMapping
    public ResponseEntity<String> saveClient(@RequestBody Client client) {
        clientService.createClient(client);
        return new ResponseEntity<String>("¡Cliente guardado con éxito!", HttpStatus.OK);
    }

    @GetMapping("{id}")
    public Client findByIdClient(@PathVariable String id) {
        return clientService.findById(id);
    }

    @DeleteMapping("{id}")
    public void deleteByIdClient(@PathVariable String id) {
        clientService.deleteClient(id);
    }
}
