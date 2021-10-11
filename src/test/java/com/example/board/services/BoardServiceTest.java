package com.example.board.services;

import com.example.board.beans.vo.BoardVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class BoardServiceTest {
    @Autowired
    private BoardService boardService;

    @Test
    public void testRegister(){
        BoardVO board = new BoardVO();
        board.setTitle("새로 작성한 글 제목");
        board.setContent("새로 작성한 글 내용");
        board.setWriter("user05");

        boardService.register(board);
        log.info("--------------------------");
        log.info(board.getBno() + "");
        log.info("--------------------------");
    }

    @Test
    public void testGet(){
        log.info(boardService.get(8L).toString());
    }

    @Test
    public void testModify(){
        BoardVO board = new BoardVO();
        board.setBno(8L);
        board.setTitle("8번 수정된 글 제목");
        board.setContent("8번 수정된 글 내용");
        log.info("UPDATE : " + boardService.modify(board));
    }

    @Test
    public void testRemove(){
        log.info("REMOVE : " + boardService.remove(8L));
    }

    @Test
    public void testGetList(){
        boardService.getList().forEach(board -> log.info(board.toString()));
    }
}
