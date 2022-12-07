package com.example.springdatajpa;

import com.example.springdatajpa.domain.Board;
import com.example.springdatajpa.domain.Role;
import com.example.springdatajpa.domain.User;
import com.example.springdatajpa.repository.BoardRepository;
import com.example.springdatajpa.repository.RoleRepository;
import com.example.springdatajpa.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.Set;

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
//        List<User> all = userRepository.findAll(); // select * from user; 4건   1+N 문제
//        for(User user : all){
//            System.out.println(user);
////            for (Role role : user.getRoles()) { // select from user_role, role where user_id = ?
////                System.out.println(role);
////            }
////            System.out.println("-------------------------------");
//        }

        // 게시물이 100건일 경우.
        // 게시물 100건 가지고 오는 Query 1개
        // 100 * 2번의 사용자 + 권한 정보가지고 오는 Query가 실행.
        // 1 + N 문제.
//        Board board = boardRepository.findById(16).get();
//        System.out.println(board);

//        List<Board> boards = boardRepository.getBoards();
//        for(Board board : boards){
//            System.out.println(board);
//            System.out.println(board.getUser());
//        }

//        Board board = boardRepository.findById(16).get();
//        System.out.println(board);
//        System.out.println(board.getUser()); // lazy로 새로운 SQL이 실행.

//        Long boardCount = boardRepository.getBoardCount();
//        System.out.println(boardCount);

//        Role role = roleRepository.findById(2).get();
//        System.out.println(role);
//
//        User user = new User();
//        user.setName("관리자");
//        user.setPassword("1234");
//        user.setEmail("admin@example.com");
//        user.setRegdate(LocalDateTime.now());
//        user.setRoles(Set.of(role));
//
//        userRepository.save(user);

//        User user = userRepository.findById(10).get();
//        Board board = new Board();
//        board.setUser(user);
//        board.setRegdate(LocalDateTime.now());
//        board.setTitle("관리자님\n" +
//                "Deprecated Gradle features were used in this build, making it incompatible with Gradle 8.0.\n" +
//                "\n" +
//                "You can use '--warning-mode all' to show the individual deprecation warnings and determine if they come from your own scripts or plugins.\n의 글");
//        board.setContent("내용입니다.");
//        boardRepository.save(board);
    }
}

