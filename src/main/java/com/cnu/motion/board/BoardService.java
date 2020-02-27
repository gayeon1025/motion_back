package com.cnu.motion.board;

import com.cnu.motion.domain.Board;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class BoardService {

    @Autowired
    BoardRepository boardRepository;

    public Page<Board> getBoards(int page) {
        PageRequest pageRequest = PageRequest.of(page, 10, Sort.Direction.DESC, "createdAt");

        return boardRepository.findAll(pageRequest);
    }
}
