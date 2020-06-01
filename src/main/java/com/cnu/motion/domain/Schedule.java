package com.cnu.motion.domain;

import com.cnu.motion.common.deserializer.ScheduleDeserializer;
import com.cnu.motion.common.type.ScheduleRaw;
import com.cnu.motion.common.type.ScheduleState;
import com.cnu.motion.common.type.ScheduleType;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "schedule")
@EntityListeners(AuditingEntityListener.class)
@JsonDeserialize(using = ScheduleDeserializer.class)
public class Schedule {

    @Id
    int id;

    ScheduleType type;

    String title;

    @Column(name = "start_at")
    LocalDateTime startAt;

    @Column(name = "end_at")
    LocalDateTime endAt;

    String location;

    @Column(name = "is_all_day")
    boolean isAllDay;

    ScheduleState state;

    ScheduleRaw raw;

    @CreatedDate
    @Column(name = "created_at")
    LocalDateTime createdAt;

    @LastModifiedDate
    @Column(name = "updated_at")
    LocalDateTime updatedAt;

    @Override
    public String toString() {
        return "Saved schedule : " + this.id;
    }
}
