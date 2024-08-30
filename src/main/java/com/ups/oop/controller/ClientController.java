package com.ups.oop.controller;

import com.ups.oop.dto.ClientDTO;
import com.ups.oop.services.ClientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class ClientController {
    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping("/client")
    public ResponseEntity createClient(@RequestBody ClientDTO clientDTO){
        return this.clientService.createClient(clientDTO);
    }

    @GetMapping("/get-all-clients")
    public ResponseEntity getAllClients(){
        return this.clientService.getAllClients();
    }

    @GetMapping("/get-client")
    public ResponseEntity getClientById(@RequestParam String id){
        return this.clientService.getClientById(id);
    }

    @PutMapping("/update-client")
    public ResponseEntity updateClient(@RequestBody ClientDTO clientDTO){
        return this.clientService.updateClient(clientDTO);
    }

    @DeleteMapping("/remove-client")
    public ResponseEntity deleteClient(@RequestBody String id){
        return this.clientService.deleteClient(id);
    }
}
