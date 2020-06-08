package com.cnu.motion.common.serializer;

import com.cnu.motion.domain.Schedule;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;

public class ScheduleSerializer extends StdSerializer<Schedule> {

    public ScheduleSerializer() { super(Schedule.class); }

    @Override
    public void serialize(Schedule schedule, JsonGenerator jsonGenerator, SerializerProvider provider) throws IOException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeNumberField("id", schedule.getId());
        jsonGenerator.writeNumberField("calendarId", schedule.getType().getValue());
        jsonGenerator.writeStringField("title", schedule.getTitle());
        jsonGenerator.writeStringField("location", schedule.getLocation());
        jsonGenerator.writeStringField("state", schedule.getState().name());
        jsonGenerator.writeBooleanField("isAllDay", schedule.isAllDay());

        jsonGenerator.writeObjectFieldStart("raw");
        jsonGenerator.writeStringField("class", schedule.getRaw().name().toLowerCase());
        jsonGenerator.writeEndObject(); // for field raw

        jsonGenerator.writeObjectFieldStart("start");
        jsonGenerator.writeObjectField("_date", schedule.getStartAt());
        jsonGenerator.writeEndObject(); // for field start

        jsonGenerator.writeObjectFieldStart("end");
        jsonGenerator.writeObjectField("_date", schedule.getEndAt());
        jsonGenerator.writeEndObject(); // for field end

        jsonGenerator.writeEndObject();
    }
}
