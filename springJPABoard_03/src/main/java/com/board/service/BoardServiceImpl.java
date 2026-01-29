package com.board.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.board.domain.Board;
import com.board.repository.BoardRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service

public class BoardServiceImpl implements BoardService{
	
	@Autowired
	private BoardRepository boardRepository;

	@Override
	public int register(Board b) throws Exception {
		Board board = boardRepository.save(b);
        return (board != null) ? 1 : 0;
	}

	 @Override
	    @Transactional(readOnly = true)
	    public Board read(Board board) throws Exception {
	        return boardRepository.getReferenceById(board.getNo());
	}

}
