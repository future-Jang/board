package com.example.board.mappers;

import com.example.board.beans.vo.BoardVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class BoardMapperTest {

    @Autowired
    private BoardMapper mapper;

    @Test
    public void testGetList(){
        mapper.getList().forEach(board->log.info(board.toString()));
    }

    @Test
    public void testInsert(){
        BoardVO board = new BoardVO();
        board.setTitle("새로 작성한 글 제목");
        board.setContent("새로 작성한 글내용");
        board.setWriter("user01");
        mapper.insert(board);
    }

    @Test
    public void testInsertSelectKey_bno(){
        BoardVO board = new BoardVO();
        board.setTitle("새로 작성한 글 제목");
        board.setContent("새로 작성한 글내용");
        board.setWriter("user02");
        mapper.insertSelectKey_bno(board);
    }

    @Test
    public void testRead(){
        /*mapper.read("2").forEach(board->log.info(board.));*/
        log.info(mapper.read(2L).toString());
    }

    @Test
    public void testUpdate(){

        if(mapper.read(2L) == null){
            log.info("****************NO SUCH BOARD******************");
        }else {
            BoardVO board = new BoardVO();
            board.setBno(2L);
            board.setTitle("수정 된 글 제목");
            board.setContent("수정 된 글 내용");
            log.info("UPDATE COUNT : " + mapper.update(board));
        }
    }

    @Test
    public void testDelete(){
        if(mapper.read(3L) == null){
            log.info("****************NO SUCH BOARD******************");
        }else {log.info("DELETE COUNT : " + mapper.remove(3L));
        }
    }
}
