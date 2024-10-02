package com.app.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.app.model.BoardEntity;

public interface BoardEntityRepository extends JpaRepository<BoardEntity, Integer> {

	@Query(value = "SELECT board2.board_no, board2.board_title, user2.user_nm, role2.role_nm "
			+ "  FROM board2, user2, urmapping, role2 "
			+ " WHERE board2.user_id = user2. user_id "
			+ "   AND user2.user_id = urmapping.user_id "
			+ "   AND urmapping.role_no = role2.role_no "
			+ " ORDER BY 1",
			nativeQuery = true)
	public List<Boards> getBorads();
	
	@Query(value = "select b from board b join b.user")
	public List<BoardEntity> getBoardAll();
	
	Page<BoardEntity> findByTitleContainingOrderByBoardNoDesc(String title, Pageable pageable);
	
}
