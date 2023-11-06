package com.board.board.repository;

import com.board.board.entity.BoardEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardRepository extends JpaRepository<BoardEntity, Integer> { // 타입, pk의 wrapper 클래스
    BoardEntity findByAuthor(String author); // WHERE author =
}