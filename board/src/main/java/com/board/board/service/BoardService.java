package com.board.board.service;

import com.board.board.entity.BoardEntity;
import com.board.board.dto.BoardDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.board.board.repository.BoardRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BoardService {
    @Autowired
    private BoardRepository boardRepository;

    // 게시판 글 작성
    public boolean createPost(BoardDTO boardDTO) {
        BoardEntity board = new BoardEntity(); // BoardEntity 객체 생성

        // 받아온 boardDTO의 값을 get해서 board의 값으로 set 해줌
        board.setTitle(boardDTO.getTitle());
        board.setContent(boardDTO.getContent());
        board.setAuthor(boardDTO.getAuthor());

        boardRepository.save(board); // 저장

        return true;
    }

    public List<BoardDTO> findAllBoard() {
        List<BoardEntity> allBoard = boardRepository.findAll();
        List<BoardDTO> boards = new ArrayList<>();

        for (BoardEntity entity : allBoard) {
            BoardDTO boardDTO = new BoardDTO();

            boardDTO.setId(entity.getId());
            boardDTO.setTitle(entity.getTitle());
            boardDTO.setContent(entity.getContent());
            boardDTO.setAuthor(entity.getAuthor());

            boards.add(boardDTO);
        }

        return boards;
    }

    public boolean updateBoard(BoardDTO boardDTO) {
        Optional<BoardEntity> board = boardRepository.findById(boardDTO.getId());

        if (board.isPresent()) {
            BoardEntity data = board.get(); // 모든 정보를 가져옴
            // 새로 입력한 값을 get해서 기존 정보에 set
            data.setTitle(boardDTO.getTitle());
            data.setContent(boardDTO.getContent());
            data.setAuthor(boardDTO.getAuthor());
            boardRepository.save(data); // 저장
            return true;
        }

        return false;
    }

    public boolean boardDelete(BoardDTO boardDTO) {
        boardRepository.deleteById(boardDTO.getId());
        return true;
    }
}
