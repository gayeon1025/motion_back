package com.cnu.motion.board;

import com.cnu.motion.domain.Board;
import com.cnu.motion.request.Request;
import com.cnu.motion.respone.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController("/boards")
public class BoardController {

    @Autowired
    BoardService boardService;

    @GetMapping
    public Response<Board> getBoards(@RequestParam("page")int page) {
        Page<Board> results = boardService.getBoards(page-1);

        return Response.<Board>builder()
                .status(200)
                .numberOfTotalPages(results.getTotalPages())
                .hasPreviousPage(results.hasPrevious())
                .hasNextPage(results.hasNext())
                .results(results.getContent())
                .build();
    }

    @PostMapping
    public void addBoard(@Valid @RequestBody Request request) {
        boardService.addBoard(request);
    }

    @PutMapping("/{id}")
    public void putBoard(@PathVariable("id")int boardId, @Valid @RequestBody Request request) {
        boardService.updateBoard(boardId, request);
    }

    @DeleteMapping("/{id}")
    public void deleteBoard(@PathVariable("id")int boardId) {
        boardService.deleteBoard(boardId);
    }
}
