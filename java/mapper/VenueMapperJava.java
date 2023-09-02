package mapper;

import model.Venue;
import org.apache.ibatis.annotations.*;
import java.util.List;

@Mapper
public interface VenueMapperJava {
    final String getAll = "SELECT * FROM venues";
    final String getById = "SELECT * FROM venues WHERE venue_id = #{venueId}";
    final String deleteById = "DELETE from venues WHERE venue_id = #{venueId}";
    final String insert = "INSERT INTO venues (venue_name, venue_address, venue_max_capacity ) VALUES (#{venueName}, #{venueAddress}, #{venueMaxCapacity})";
    final String update = "UPDATE venues SET venue_name = #{venueName}, venue_address = #{venueAddress}, venue_max_capacity = #{venueMaxCapacity} WHERE venue_id = #{venueId}";


    @Select(getAll)
    @Results(value = {
            @Result(property = "venueId", column = "venue_id"),
            @Result(property = "venueName", column = "venue_name"),
            @Result(property = "venueAddress", column = "venue_address"),
            @Result(property = "venueMaxCapacity", column = "venue_max_capacity")

    })
    public List<Venue> getAllVenues();

    @Select(getById)
    @Results(value = {
            @Result(property = "venueId", column = "venue_id"),
            @Result(property = "venueName", column = "venue_name"),
            @Result(property = "venueAddress", column = "venue_address"),
            @Result(property = "venueMaxCapacity", column = "venue_max_capacity")
    })

    Venue getById(int venueId);

    @Update(update)
    void update(Venue venue);

    @Delete(deleteById)
    void delete(int venueId);

    @Insert(insert)
    @Options(useGeneratedKeys = true, keyProperty = "venueId")
    void insert(Venue venue);

}
