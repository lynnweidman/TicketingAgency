package json;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class PerformerMain {

    public static void main(String[] args) {

        File performerFile = new File("C:\\Users\\lcwtr\\IdeaProjects\\TicketingEvents\\target\\performer.json");

        PerformerJson performer = new PerformerJson();
        performer.setPerformerId(1);
        performer.setPerformerName("Taylor Swift");
        performer.setPerformerPhone("111-111-1111");
        performer.setPerformerEmail("taylorSwift@gmail.com");

        PerformerJson performer2 = new PerformerJson();
        performer2.setPerformerId(2);
        performer2.setPerformerName("Phantom Director");
        performer2.setPerformerPhone("111-111-5555");
        performer2.setPerformerEmail("phantomDirector@gmail.com");


        List<PerformerJson> listPerformers = new ArrayList<>();
        listPerformers.add(performer);
        listPerformers.add(performer2);
        System.out.println("Performer list: " + listPerformers);

        try {
            ObjectMapper objectMapper = new ObjectMapper();

            //Serialize performer Object to String
            String serializePerformer = objectMapper.writeValueAsString(performer);
            System.out.println("Serialized performer  " + serializePerformer);
            String getEmail = objectMapper.writeValueAsString(performer.getPerformerEmail());

            System.out.println("Print email- " + getEmail);

            //Deserialize String performer to Object
            PerformerJson deserializePerformer = objectMapper.readValue(serializePerformer, PerformerJson.class);
            System.out.println("DeserializedPerformer " + deserializePerformer);

            //Serialize listPerformer Object to String
            String stringList = objectMapper.writeValueAsString(listPerformers);
            System.out.println("Serialized list- " + stringList);


            //Write to the file
            objectMapper.writeValue(performerFile, serializePerformer);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
