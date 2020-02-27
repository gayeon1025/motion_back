package com.cnu.motion.board;

import com.cnu.motion.domain.Board;
import com.cnu.motion.respone.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("/boards")
public class BoardController {

    @Autowired
    BoardService boardService;

    @GetMapping
    public Response<Board> getBoards(@RequestParam("page")int page) {
        Page<Board> results = boardService.getBoards(page);

        return Response.<Board>builder()
                .numberOfTotalPages(results.getTotalPages())
                .hasPreviousPage(results.hasPrevious())
                .hasNextPage(results.hasNext())
                .results(results.getContent())
                .build();
    }
}
