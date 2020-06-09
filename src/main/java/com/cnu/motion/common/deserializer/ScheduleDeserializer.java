package com.cnu.motion.common.deserializer;

import com.cnu.motion.common.type.ScheduleRaw;
import com.cnu.motion.common.type.ScheduleState;
import com.cnu.motion.common.type.ScheduleType;
import com.cnu.motion.domain.Schedule;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class ScheduleDeserializer extends StdDeserializer<Schedule> {

    public ScheduleDeserializer() {
        super(Schedule.class);
    }

    @Override
    public Schedule deserialize(JsonParser parser, DeserializationContext context) throws IOException, JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode input = mapper.readTree(parser);
        Schedule schedule = new Schedule();

        int type = input.get("calendarId").asInt();
        schedule.setType(ScheduleType.getType(type));

        String title = input.get("title").asText();
        schedule.setTitle(title);

        JsonNode locationNode = input.get("location");
        if (locationNode != null) {
            schedule.setLocation(locationNode.asText());
        }
        else {
            schedule.setLocation("");
        }

        JsonNode start = input.get("start").get("_date");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.KOREA);
        LocalDateTime startAt = LocalDateTime.parse(start.asText(), formatter).plusHours(9); // convert utc to kst
        schedule.setStartAt(startAt);

        JsonNode end = input.get("end").get("_date");
        LocalDateTime endAt = LocalDateTime.parse(end.asText(), formatter).plusHours(9); // convert utc to kst
        schedule.setEndAt(endAt);

        JsonNode state = input.get("state");
        schedule.setState(ScheduleState.valueOf(state.asText().toUpperCase()));

        JsonNode raw = input.get("raw").get("class");
        schedule.setRaw(ScheduleRaw.valueOf(raw.asText().toUpperCase()));

        Boolean isAllDay = input.get("isAllDay").asBoolean();
        schedule.setAllDay(isAllDay);
        return schedule;
    }
}
