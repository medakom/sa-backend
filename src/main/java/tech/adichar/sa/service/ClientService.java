package tech.adichar.sa.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import tech.adichar.sa.entities.Client;
import tech.adichar.sa.repository.ClientRepository;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.Callable;

@Service
@RequiredArgsConstructor
public class ClientService {
    private final ClientRepository clientRepository;

    public void createdClient(Client client) {
        Client clientDB = clientRepository.findByEmail(client.getEmail());
        if (clientDB == null) {
            clientRepository.save(client);
        }
    }

    public List<Client> clientList() {
        return clientRepository.findAll();
    }


    public Client getClientByID(int id) {
        Optional<Client> optionalClient = clientRepository.findById(id);
       optionalClient.orElseThrow(
               ()-> new EntityNotFoundException("Aucun client n'existe avec cet identifiant")
       );
        return null;
    }

    public Client readOrCreated(Client clientCreated) {
        Client clientDB = clientRepository.findByEmail(clientCreated.getEmail());
        if (clientDB == null) {
            clientDB = clientRepository.save(clientCreated);
        }
        return clientDB;
    }

    public void updateClient(int id, Client client) {
        Client clientOfDB = getClientByID(id);
        System.out.println(clientOfDB);
        if (clientOfDB.getId() == client.getId()) {
            clientOfDB.setEmail(client.getEmail());
            clientOfDB.setPhone(client.getPhone());
        }
    }

}

