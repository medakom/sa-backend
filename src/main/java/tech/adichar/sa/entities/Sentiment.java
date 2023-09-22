package tech.adichar.sa.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import tech.adichar.sa.enums.TypeSentiment;
@Entity
@Table(name = "SENTIMENT")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Sentiment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id ;
    private String texte;
    private TypeSentiment type;
    @ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    @JoinColumn(name = "CLIENT_ID")
    private Client client;

}
