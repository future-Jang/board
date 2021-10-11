package com.example.board.beans.dao;


import com.example.board.beans.vo.BoardVO;
import com.example.board.mappers.BoardMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

//원격에서 수정함
@Repository
@RequiredArgsConstructor
public class BoardDAO {
    private final BoardMapper mapper;

    public void register(BoardVO board){
        mapper.insertSelectKey_bno(board);
    }

    public BoardVO get(Long bno){
        return mapper.read(bno);
    }

    public boolean modify(BoardVO board){
        return mapper.update(board) ==1;
    }

    public boolean remove(long bno){
        return mapper.remove(bno) ==1;
    }

    public List<BoardVO> getList(){
        return mapper.getList();
    }
}
