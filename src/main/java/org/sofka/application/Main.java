package org.sofka.application;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.sofka.application.controller.QuestionManager;
import org.sofka.application.model.QuestionModel;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static final ObjectMapper objectMapper = new ObjectMapper();
    static List<QuestionModel> questions = new ArrayList<>();
    public static void main(String[] args) throws JsonProcessingException {
        /*var client = MongoClients.create("mongodb+srv://pilox97:pilox2760517@cluster0.sbeoa.mongodb.net/?retryWrites=true&w=majority");
        MongoDatabase db = client.getDatabase("myFirstDatabase");
        MongoCollection<Document> col = db.getCollection("asks");

        System.out.println("connection good");*/

        new QuestionManager();

    }
}
