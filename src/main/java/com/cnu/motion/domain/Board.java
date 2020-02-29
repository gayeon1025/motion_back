package com.cnu.motion.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
@Entity
@Builder
@AllArgsConstructor
@Table(name = "board")
@EntityListeners(AuditingEntityListener.class)
public class Board{

    private Board() {}

    @Id
    int id;

    @NotNull
    String title;

    String contents;

    @Column(name = "registrant_id")
    String registrantId;

    @Column(name = "registrant_name")
    String registrantName;

    @CreatedDate
    @Column(name = "created_at")
    LocalDateTime createdAt;

    @LastModifiedDate
    @Column(name = "updated_at")
    LocalDateTime updatedAt;
}
