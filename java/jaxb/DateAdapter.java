package jaxb;

import jakarta.xml.bind.annotation.adapters.XmlAdapter;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DateAdapter extends XmlAdapter<String, Date> {

    SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");

    @Override
    public Date unmarshal(String dateString) throws Exception {
        return sdf.parse(dateString);
    }

    @Override
    public String marshal(Date timestamp) throws Exception {
        return sdf.format(timestamp);
    }
}


