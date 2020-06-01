package com.cnu.motion.board;

import com.cnu.motion.domain.Board;
import com.cnu.motion.respone.ListResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/boards")
public class BoardController {

    @Autowired
    BoardService boardService;

    @GetMapping
    public ListResponse<Board> getBoards(@RequestParam(value = "page", defaultValue = "1")int page) {
        Page<Board> results = boardService.getBoards(page-1);

        return ListResponse.<Board>builder()
                .status(200)
                .currentPage(page)
                .numberOfTotalPages(results.getTotalPages())
                .hasPreviousPage(results.hasPrevious())
                .hasNextPage(results.hasNext())
                .items(results.getContent())
                .build();
    }

    @GetMapping("{boardId}")
    public Board getBoard(@PathVariable(value = "boardId")int boardId) {
        return boardService.getBoard(boardId);
    }

//    @PostMapping
//    public void addBoard(@Valid @RequestBody Request request) {
//        boardService.addBoard(request);
//    }
//
//    @PutMapping("/{id}")
//    public void putBoard(@PathVariable("id")int boardId, @Valid @RequestBody Request request) {
//        boardService.updateBoard(boardId, request);
//    }

    @DeleteMapping("/{id}")
    public void deleteBoard(@PathVariable("id")int boardId) {
        boardService.deleteBoard(boardId);
    }
}