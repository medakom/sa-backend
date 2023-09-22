package tech.adichar.sa.controller;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.adichar.sa.dto.ErrorEntity;
import tech.adichar.sa.entities.Client;
import tech.adichar.sa.service.ClientService;

import java.util.List;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.NO_CONTENT;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;


@RestController

@RequestMapping(path = "client")

@RequiredArgsConstructor

public class ClientController {
 private final ClientService clientService;



    @ResponseStatus(value = HttpStatus.CREATED)
    @PostMapping(consumes = APPLICATION_JSON_VALUE)
  public void created(@RequestBody Client client){
        clientService.createdClient(client);


    }

    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public List<Client> listClients(){
        return clientService.clientList();
    }

    @GetMapping(path = "{id}", produces = APPLICATION_JSON_VALUE)
    public Client getClientByID(@PathVariable(name = "id") int id) {
        return clientService.getClientByID(id);
//        try {
//
//            Client client = clientService.getClientByID(id);
//            return ResponseEntity.ok(client);
//        }
//        catch (EntityNotFoundException exception) {
//            return ResponseEntity.status(BAD_REQUEST).body(new ErrorEntity(null, exception.getMessage()));
//        }

    }
    @ResponseStatus(NO_CONTENT)
    @PutMapping(path = "{id}",consumes = APPLICATION_JSON_VALUE)
    public void updateClient( @PathVariable int id ,@RequestBody Client client){
        clientService.updateClient(id,client);

    }


}
