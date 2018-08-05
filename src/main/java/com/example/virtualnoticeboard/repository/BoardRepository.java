package com.example.virtualnoticeboard.repository;

import com.example.virtualnoticeboard.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Long>
{
	public Board findByName(String name);
}