package com.example.springdatajpa.repository;

import com.example.springdatajpa.domain.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board, Integer> {

    // JPQL 을 사용할 수 있다.
    // JPQL 은 SQL과 모양이 비슷하지만, SQL이 아니다.
    // JPQL 은 객체지향 언어이다.
    // JPQL에서 from 뒤에 있는 것은 엔티티 이름.
    // Board 엔티티들을 조회하라. 엔티티는 결국 table과 관계.
    @Query(value = "select b from Board b join fetch b.user")
    List<Board> getBoards();

    @Query(value = "select count(b) from Board b")
    Long getBoardCount();

    // 관리자가 쓴 글만 목록을 구하는 JPQL을 작성하시오. 이게 가능할까요?

}
