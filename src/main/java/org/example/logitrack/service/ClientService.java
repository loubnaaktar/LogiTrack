package org.example.logitrack.service;

import org.example.logitrack.model.Client;
import org.example.logitrack.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public Client ajouterClient(Client client){
       return clientRepository.save(client);
    }

    public List<Client> allClients(){
       return clientRepository.findAll();
    }

    public Client chercherClientById(long id){
        return clientRepository.findById(id).orElse(null);
    }

    public void supprimerClient(long id){
        clientRepository.deleteById(id);
    }
}
