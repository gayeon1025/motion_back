package com.cnu.motion.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {
    @Id
    Long id;

    int studentId;
}
