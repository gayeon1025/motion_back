package com.cnu.motion.respone;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class Response<T> {

    private int status;

    private int currentPage;

    private int numberOfTotalPages;

    private List<T> items;

    private boolean hasPreviousPage;

    private boolean hasNextPage;
}
