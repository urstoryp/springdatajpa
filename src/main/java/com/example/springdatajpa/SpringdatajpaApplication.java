package com.example.springdatajpa;

import com.example.springdatajpa.domain.Board;
import com.example.springdatajpa.dto.BoardIf;
import com.example.springdatajpa.repository.BoardRepository;
import com.example.springdatajpa.repository.RoleRepository;
import com.example.springdatajpa.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@SpringBootApplication
public class SpringdatajpaApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(SpringdatajpaApplication.class, args);
    }

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    BoardRepository boardRepository;

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        List<BoardIf> list = boardRepository.getBoardsWithNativeQuery();
        for(BoardIf board : list){
            System.out.println(board.getClass().getName()); // BoardIf 를 구현하는 객체
            System.out.println(board.getName()); // 글 작성자
            System.out.println(board.getTitle());
        }
    }
}

