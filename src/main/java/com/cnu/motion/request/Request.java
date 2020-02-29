package com.cnu.motion.request;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
public class Request {
    @NotNull
    String title;

    String contents;

    @Length(min = 9, max = 9)
    String studentId;

    List<String> attachments;
}
