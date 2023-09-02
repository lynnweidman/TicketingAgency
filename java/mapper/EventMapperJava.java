package mapper;

import model.Event;
import org.apache.ibatis.annotations.*;
import java.util.List;

@Mapper
public interface EventMapperJava {
    final String getAll = "SELECT * FROM events";
    final String getById = "SELECT * FROM events WHERE event_id = #{eventId}";
    final String deleteById = "DELETE from events WHERE event_id = #{eventId}";
    final String insert = "INSERT INTO events (event_name, event_date, event_type_id, venue_id ) VALUES (#{eventName}, #{eventDate}, #{eventTypeId}, #{venueId})";
    final String update = "UPDATE events SET event_name = #{eventName}, event_date = #{eventDate}, event_type_id = #{eventTypeId}, venue_id = #{venueId} WHERE event_id = #{eventId}";

    @Select(getAll)
    @Results(value = {
            @Result(property = "eventId", column = "event_id"),
            @Result(property = "eventName", column = "event_name"),
            @Result(property = "eventDate", column = "event_Date"),
            @Result(property = "eventTypeId", column = "event_type_id"),
            @Result(property = "venueId", column = "venue_id")
    })
    public List<Event> getAllEvents();

    @Select(getById)
    @Results(value = {
            @Result(property = "eventId", column = "event_id"),
            @Result(property = "eventName", column = "event_name"),
            @Result(property = "eventDate", column = "event_Date"),
            @Result(property = "eventTypeId", column = "event_type_id"),
            @Result(property = "venueId", column = "venue_id")
    })
    Event getById(int eventId);

    @Update(update)
    void update(Event event);

    @Delete(deleteById)
    void delete(int eventId);

    @Insert(insert)
    @Options(useGeneratedKeys = true, keyProperty = "eventId")
    void insert(Event event);

}
