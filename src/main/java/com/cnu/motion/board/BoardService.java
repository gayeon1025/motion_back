package com.cnu.motion.board;

import com.cnu.motion.account.AccountService;
import com.cnu.motion.common.exception.InvalidRequestException;
import com.cnu.motion.common.exception.ResourceNotFoundException;
import com.cnu.motion.common.file.AttachmentRepository;
import com.cnu.motion.common.file.AttachmentService;
import com.cnu.motion.common.type.Exception;
import com.cnu.motion.common.type.PostType;
import com.cnu.motion.domain.Account;
import com.cnu.motion.domain.Board;
import com.cnu.motion.request.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {

    @Autowired
    BoardRepository boardRepository;

    @Autowired
    AttachmentService attachmentService;

    @Autowired
    AccountService accountService;

    public Page<Board> getBoards(int page) {
        PageRequest pageRequest = PageRequest.of(page, 10, Sort.Direction.DESC, "createdAt");

        return boardRepository.findAll(pageRequest);
    }

    public Board getBoard(int boardId) {
        return boardRepository.findById(boardId).orElseThrow(() -> new ResourceNotFoundException(Exception.BOARD_NOT_FOUND));
    }

//    public Board addBoard(Request request) {
//       Board newBoard = boardRepository.save(convertRequestIntoBoard(request));
//
//       // Register attachments
//        attachmentService.registerAttachments(PostType.BOARD, newBoard.getId(), request.getAttachments());
//
//        return newBoard;
//    }

//    public Board updateBoard(int boardId, Request request) {
//        Board previousBoard = boardRepository.findById(boardId)
//                .orElseThrow(() -> new ResourceNotFoundException(Exception.BOARD_NOT_FOUND));
//
//        // Remove previous attachments
//        attachmentService.deleteAttachmentsByPostId(previousBoard.getId());
//
//        // Save new attachments
//        attachmentService.registerAttachments(PostType.BOARD, previousBoard.getId(), request.getAttachments());
//
//        Board newBoard = convertRequestIntoBoard(request);
//
//        previousBoard.setTitle(newBoard.getTitle());
//        previousBoard.setContents(newBoard.getContents());
//
//        return boardRepository.save(previousBoard);
//    }

    public void deleteBoard(int boardId) {
        Board board = boardRepository.findById(boardId)
                .orElseThrow(() -> new ResourceNotFoundException(Exception.BOARD_NOT_FOUND));

        // TODO : spring security로 변경
//        if (canNotDelete(board, user)) {
//            throw new InvalidRequestException(Exception.NOT_AUTHENTICATED_USER_FOR_DELETION);
//        }

        boardRepository.deleteById(boardId);
    }

//    private boolean canNotDelete(Board board, String user) {
//        return !hasAuthorizationToDelete(board, user);
//    }

//    private boolean hasAuthorizationToDelete(Board board, String user) {
//        return (board.getRegistrantId().equals(user));
//    }

//    public Board convertRequestIntoBoard(Request request) {
//        Account account = accountService.getAccountWithId(request.getStudentId());
//
//        return Board.builder()
//                .registrantId(account.getId())
//                .registrantName(account.getName())
//                .title(request.getTitle())
//                .contents(request.getContents())
//                .build();
//    }
}