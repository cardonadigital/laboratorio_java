package org.sofka.application.connection;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.jboss.logging.Logger;
import org.sofka.application.model.QuestionModel;

import java.util.ArrayList;
import java.util.List;


/**
 * This class contains the connection to database
 *
 * @author Andres Camilo Díaz - Daniel David Cardona Moreno
 * @version 1.0.0 17/07/2022
 * @since 1.0.0
 */
public class Connection {
    public static final ObjectMapper objectMapper = new ObjectMapper();
    static List<QuestionModel> questions = new ArrayList<>();
    static final String URL = "mongodb+srv://pilox97:pilox2760517@cluster0.sbeoa.mongodb.net/?retryWrites=true&w=majority";
    private static final Logger logger = Logger.getLogger(Connection.class);

    public void connection() throws JsonProcessingException {
        MongoDatabase db;
        try (var client = MongoClients.create(URL)) {
            db = client.getDatabase("myFirstDatabase");
            MongoCollection<Document> col = db.getCollection("asks");

            logger.info("connection good");

            for (Document document : col.find()) {
                var elementJson = document.toJson();
                objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
                QuestionModel question = objectMapper.readValue(elementJson, QuestionModel.class);
                questions.add(question);
            }
            logger.info("info added");
        } catch (Exception e) {
            logger.info("something happened " + e);
        }
    }

    /**
     * This method get the question from database
     *
     * @author Andres Camilo Díaz - Daniel David Cardona Moreno
     * @version 1.0.0 17/07/2022
     * @since 1.0.0
     */
    public static List<QuestionModel> getQuestions() {
        return questions;
    }

    /**
     * This insert the given info to database
     *
     * @author Andres Camilo Díaz - Daniel David Cardona Moreno
     * @version 1.0.0 17/07/2022
     * @since 1.0.0
     */
    public void insertDocument(String name, Integer age, Integer score) {
        try (var client = MongoClients.create(URL)) {
            MongoDatabase db = client.getDatabase("myFirstDatabase");
            MongoCollection<Document> col = db.getCollection("participants");
            Document document = new Document("name", name).
                    append("age", age).
                    append("score", score);
            col.insertOne(document);
            logger.info("info added");
        } catch (Exception e) {
            logger.info("something happened " + e);
        }
    }
}
