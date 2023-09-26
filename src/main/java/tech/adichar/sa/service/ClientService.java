package tech.adichar.sa.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import tech.adichar.sa.dto.ClientDTO;
import tech.adichar.sa.entities.Client;
import tech.adichar.sa.mapper.ClientDTOMapper;
import tech.adichar.sa.repository.ClientRepository;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.Callable;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class ClientService {
    private final ClientRepository clientRepository;
    private final ClientDTOMapper clientDTOMapper;

    public void createdClient(Client client) {
        Client clientDB = clientRepository.findByEmail(client.getEmail());
        if (clientDB == null) {
            clientRepository.save(client);
        }
    }

    public Stream<ClientDTO> clientList() {
       return clientRepository.findAll()
                .stream().map(clientDTOMapper::apply);

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

