package org.sofka.application.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.sofka.application.model.QuestionModel;

import java.util.ArrayList;
import java.util.List;

public class QuestionManager {
    public static final ObjectMapper objectMapper = new ObjectMapper();
    static List<QuestionModel> questions = new ArrayList<>();

    public QuestionManager() throws JsonProcessingException {
        connection();
    }

    private void connection() throws JsonProcessingException {
        var client = MongoClients.create("mongodb+srv://pilox97:pilox2760517@cluster0.sbeoa.mongodb.net/?retryWrites=true&w=majority");
        MongoDatabase db = client.getDatabase("myFirstDatabase");
        MongoCollection<Document> col = db.getCollection("asks");

        System.out.println("connection good");


        var element = col.find().iterator();

        while (element.hasNext()){
            var elementJson = element.next().toJson();
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            QuestionModel question = objectMapper.readValue(elementJson, QuestionModel.class);
            questions.add(question);
            System.out.println(question);
        }
    }
}
