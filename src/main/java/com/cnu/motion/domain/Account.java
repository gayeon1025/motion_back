package com.cnu.motion.domain;

import com.cnu.motion.common.type.Roll;
import org.hibernate.validator.constraints.Length;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.time.LocalDateTime;

@Entity
@Table(name = "account")
@EntityListeners(AuditingEntityListener.class)
public class Account {

    @Id
    int id;

    @Length(min = 9, max = 9)
    @Column(name = "student_id")
    String studentId;

    Roll roll;

    @Pattern(regexp = "[0-9]{3}-[0-9]{3,4}-[0-9]{4}")
    String phone;

    String email;

    String name;

    String birth;

    @CreatedDate
    @Column(name = "created_at")
    LocalDateTime createdAt;

    @LastModifiedDate
    @Column(name = "updated_at")
    LocalDateTime updatedAt;
}
