package com.cnu.motion.domain;

import com.cnu.motion.common.type.PostType;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "attachment")
@EntityListeners(AuditingEntityListener.class)
public class Attachment {

    public Attachment(PostType type, int postId, String path) {
        this.type = type;
        this.postId = postId;
        this.path = path;
    }

    @Id
    int id;

    PostType type;

    int postId;

    String path;

    @CreatedDate
    @Column(name = "created_at")
    LocalDateTime createdAt;

    @LastModifiedDate
    @Column(name = "updated_at")
    LocalDateTime updatedAt;
}
