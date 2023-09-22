package tech.adichar.sa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.adichar.sa.entities.Sentiment;
import tech.adichar.sa.enums.TypeSentiment;

import java.util.List;

public interface SentimentRepository extends JpaRepository<Sentiment,Integer> {
    List<Sentiment> findByType(TypeSentiment type);
}
