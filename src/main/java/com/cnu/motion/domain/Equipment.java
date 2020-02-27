package com.cnu.motion.domain;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "equipment")
@EntityListeners(AuditingEntityListener.class)
public class Equipment {

    @Id
    int id;

    int quantity;

    String name;

    @Column(name = "start_at")
    LocalDate startAt;

    @Column(name = "end_at")
    LocalDate endAt;

    @CreatedDate
    @Column(name = "created_at")
    LocalDateTime createdAt;

    @LastModifiedDate
    @Column(name = "updated_at")
    LocalDateTime updatedAt;
}
