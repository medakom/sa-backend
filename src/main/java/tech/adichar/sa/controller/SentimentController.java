package tech.adichar.sa.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import tech.adichar.sa.entities.Sentiment;
import tech.adichar.sa.enums.TypeSentiment;
import tech.adichar.sa.service.SentimentService;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "sentiment", produces = APPLICATION_JSON_VALUE)
public class SentimentController {
    private final SentimentService sentimentService;
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public void createdSentiment(@RequestBody Sentiment sentiment){
        sentimentService.createdSentiment(sentiment);

    }
    @GetMapping
    public @ResponseBody List<Sentiment> getListSentiments(@RequestParam(required = false) TypeSentiment type){
return  sentimentService.getSentiments(type);
    }
@ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(path = "{id}")
    public void deleteSentiment(@PathVariable int id) {
        sentimentService.deleteSentimentId(id);
    }
}
