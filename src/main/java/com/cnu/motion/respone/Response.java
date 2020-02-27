package com.cnu.motion.respone;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class Response<T> {
    int numberOfTotalPages;
    List<T> results;
    boolean hasPreviousPage;
    boolean hasNextPage;
}
