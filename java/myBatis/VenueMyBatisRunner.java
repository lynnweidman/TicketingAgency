package myBatis;

import mapper.EventMapperJava;
import mapper.VenueMapperJava;
import model.Event;
import model.Venue;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class VenueMyBatisRunner {

    public static void main(String[] args) throws IOException {

        //Open Session- Use when mapping with XML file
       /* try (InputStream inputStream = Resources.getResourceAsStream("myBatisConfig.xml");
             SqlSession session = new SqlSessionFactoryBuilder().build(inputStream).openSession(true)) {
*/

            //Open Session- Use for mapping VenueMapperJava interface with annotations
        try (InputStream inputStream = Resources.getResourceAsStream("myBatisConfig.xml");
             SqlSession session = new SqlSessionFactoryBuilder().build(inputStream).openSession(true)) {
            VenueMapperJava venueMapperJava = session.getMapper(VenueMapperJava.class);


            //SelectVenueById uses XML
           // Venue venue = session.selectOne("mapper.VenueMapper.selectVenueById", 1);
           // System.out.println("Venue from DB:\n" + venue);

            //getAllVenues using Interface and annotations
            List<Venue> venuList =  venueMapperJava.getAllVenues();
            System.out.println(venuList);

            //Get venue by id using Interface and annotations
             //Venue venue = venueMapperJava.getById(4);
            //System.out.println("venue with Interface:\n" + venue);


            //Update venue using Interface and annotations
            /*Venue venue1 = venueMapperJava.getById(1);
            System.out.println("Current Venue Name:  "+ venue1);

            //Update eventName
            venue1.setVenueMaxCapacity(300000);

            //Update the event record using Interface and annotations
            venueMapperJava.update(venue1);
            System.out.println("Record updated successfully" );
            session.commit();

            //Show the updated record
            Venue venue3 = venueMapperJava.getById(1);
            System.out.println(venue3);*/



            //Insert using Interface and annotations
            Venue venue1 = new Venue();
            venue1.setVenueName("Los Angeles");
            venue1.setVenueAddress("Los Angeles, CA");
            venue1.setVenueMaxCapacity(200000);


            venueMapperJava.insert(venue1);
            System.out.println("Inserted Venue:\n" + venue1);
            session.commit();


        }
    }
}
