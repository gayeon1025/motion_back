package com.cnu.motion.domain;

import com.cnu.motion.common.type.Roll;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "account")
@EntityListeners(AuditingEntityListener.class)
public class Account {

    @Id
    @Length(min = 9, max = 9)
    @Column(name = "id")
    String id;

    Roll roll;

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
