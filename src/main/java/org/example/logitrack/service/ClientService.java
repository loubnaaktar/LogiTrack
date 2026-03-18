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

    public void ajouterClient(Client client){
        clientRepository.save(client);
    }

    public List<Client> allClients(){
       return clientRepository.findAll();
    }

    public Client chercherClientById(int id){
        return clientRepository.findById(id).orElse(null);
    }

    public void supprimerClient(int id){
        clientRepository.deleteById(id);
    }
}
