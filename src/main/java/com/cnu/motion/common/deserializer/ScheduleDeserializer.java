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

        JsonNode type = input.get("calendarId");
        if (type != null) {
            schedule.setType(ScheduleType.getType(type.asInt()));
        }

        JsonNode title = input.get("title");
        if (title != null) {
            schedule.setTitle(title.asText());
        }

        JsonNode locationNode = input.get("location");
        if (locationNode != null) {
            schedule.setLocation(locationNode.asText());
        }
        else {
            schedule.setLocation(null);
        }

        JsonNode start = input.get("start");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.KOREA);
        if (start != null) {
            LocalDateTime startAt = LocalDateTime.parse(start.get("_date").asText(), formatter).plusHours(9); // convert utc to kst
            schedule.setStartAt(startAt);
        }

        JsonNode end = input.get("end");
        if (end != null) {
            LocalDateTime endAt = LocalDateTime.parse(end.get("_date").asText(), formatter).plusHours(9); // convert utc to kst
            schedule.setEndAt(endAt);
        }

        JsonNode state = input.get("state");
        if (state != null) {
            schedule.setState(ScheduleState.valueOf(state.asText().toUpperCase()));
        }

        JsonNode raw = input.get("raw");
        if (raw != null) {
            schedule.setRaw(ScheduleRaw.valueOf(raw.get("class").asText().toUpperCase()));
        }

        JsonNode isAllDay = input.get("isAllDay");
        if (isAllDay != null) {
            schedule.setAllDay(isAllDay.asBoolean());
        }

        return schedule;
    }
}
