package org.sofka.application.connection;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.jboss.logging.Logger;
import org.sofka.application.Main;
import org.sofka.application.model.QuestionModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Connection {
    private static final Logger logger = Logger.getLogger(Main.class);
    static Scanner scanner = new Scanner(System.in);
    public static final ObjectMapper objectMapper = new ObjectMapper();
    static List<QuestionModel> questions = new ArrayList<>();

    /*public Connection() throws JsonProcessingException {
        connection();
    }*/

    public void connection() throws JsonProcessingException {
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
        }
    }

    public static List<QuestionModel> getQuestions() {
        return questions;
    }

    public void insertDocument(String name, Integer age, Integer score){
        var client = MongoClients.create("mongodb+srv://pilox97:pilox2760517@cluster0.sbeoa.mongodb.net/?retryWrites=true&w=majority");
        MongoDatabase db = client.getDatabase("myFirstDatabase");
        MongoCollection<Document> col = db.getCollection("participants");
        Document document = new Document("name", name).
                append("age", age).
                append("score", score);
        col.insertOne(document);
        System.out.println("se ha insertado info");
    }
}
