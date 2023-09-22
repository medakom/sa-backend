package tech.adichar.sa.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tech.adichar.sa.entities.Client;
import tech.adichar.sa.entities.Sentiment;
import tech.adichar.sa.enums.TypeSentiment;
import tech.adichar.sa.repository.SentimentRepository;

import java.util.List;

import static tech.adichar.sa.enums.TypeSentiment.NEGATIF;
import static tech.adichar.sa.enums.TypeSentiment.POSITIF;

@Service
@RequiredArgsConstructor
public class SentimentService {
    private final ClientService clientService;
    private final SentimentRepository sentimentRepository;
    public void createdSentiment(Sentiment sentiment){
        Client client=clientService.readOrCreated(sentiment.getClient());
        sentiment.setClient(client);
        if(sentiment.getTexte().contains("pas")){
            sentiment.setType(NEGATIF);
        }
        else {
            sentiment.setType(POSITIF);
        }
        sentimentRepository.save(sentiment);
    }

    public List<Sentiment> getSentiments(TypeSentiment type) {
        if(type==null){
            return sentimentRepository.findAll();
        }else {
            return sentimentRepository.findByType(type);
        }

    }

    public void deleteSentimentId(int id) {
        sentimentRepository.deleteById(id);
    }
}
