package com.cnu.motion.domain;

import com.cnu.motion.common.type.ExamType;
import com.cnu.motion.common.type.Grade;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "exam")
@EntityListeners(AuditingEntityListener.class)
public class Exam {
    @Id
    int id;

    Grade grade;

    @Column(name = "subject_id")
    int subjectId;

    ExamType type;

    @Column(name = "exam_year")
    int examYear;

    int registrant;

    @CreatedDate
    @Column(name = "created_at")
    LocalDateTime createdAt;

    @LastModifiedDate
    @Column(name = "updated_at")
    LocalDateTime updatedAt;
}
