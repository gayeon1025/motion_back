package com.cnu.motion.common.serializer;

import com.cnu.motion.domain.Schedule;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.time.format.DateTimeFormatter;

public class ScheduleSerializer extends StdSerializer<Schedule> {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public ScheduleSerializer() { super(Schedule.class); }

    @Override
    public void serialize(Schedule schedule, JsonGenerator jsonGenerator, SerializerProvider provider) throws IOException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeStringField("id", String.valueOf(schedule.getId()));
        jsonGenerator.writeStringField("calendarId", String.valueOf(schedule.getType().getValue()));
        jsonGenerator.writeStringField("title", schedule.getTitle());
        jsonGenerator.writeStringField("location", schedule.getLocation());
        jsonGenerator.writeStringField("state", schedule.getState().name());

        if (schedule.isAllDay()) {
            jsonGenerator.writeStringField("category", "allday");
        }
        else {
            jsonGenerator.writeStringField("category", "time");
        }

        jsonGenerator.writeObjectFieldStart("raw");
        jsonGenerator.writeStringField("class", schedule.getRaw().name().toLowerCase());
        jsonGenerator.writeEndObject(); // for field raw

        jsonGenerator.writeStringField("start", schedule.getStartAt().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
        jsonGenerator.writeStringField("end", schedule.getEndAt().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));

//        jsonGenerator.writeObjectFieldStart("start");
//        jsonGenerator.writeObjectField("_date", schedule.getStartAt());
//        jsonGenerator.writeEndObject(); // for field start
//
//        jsonGenerator.writeObjectFieldStart("end");
//        jsonGenerator.writeObjectField("_date", schedule.getEndAt());
//        jsonGenerator.writeEndObject(); // for field end

        jsonGenerator.writeEndObject();
    }
}
