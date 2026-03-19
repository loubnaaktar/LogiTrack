package org.example.logitrack.controller;

import org.example.logitrack.model.Client;
import org.example.logitrack.service.ClientService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clients")
public class ClientController {

    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping
    public List<Client> ListClients(){
        return clientService.allClients();
    }

@GetMapping("/{id}")
public Client getClientById(@PathVariable long id){
        return clientService.chercherClientById(id);
}

@PostMapping
    public Client ajouterClient(@RequestBody Client client){
        return clientService.ajouterClient(client);
}

@DeleteMapping("/{id}")
    public void supprimerClient(long id){
        clientService.supprimerClient(id);
}
}
