package tech.adichar.sa.mapper;

import org.springframework.cglib.core.internal.Function;
import org.springframework.stereotype.Component;
import tech.adichar.sa.dto.ClientDTO;
import tech.adichar.sa.entities.Client;

@Component
public class ClientDTOMapper implements Function<Client, ClientDTO> {
    @Override
    public ClientDTO apply(Client client) {
        return new ClientDTO(client.getId(),client.getEmail(),client.getPhone());
    }
}
