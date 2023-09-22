package tech.adichar.sa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.adichar.sa.entities.Client;

public interface ClientRepository extends JpaRepository<Client,Integer> {
    Client findByEmail(String email);
}
