//package com.example.virtualnoticeboard.repository;
//
//import com.example.virtualnoticeboard.VirtualNoticeBoardApplication;
//import com.example.virtualnoticeboard.entity.Board;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import org.springframework.test.context.web.WebAppConfiguration;
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes = VirtualNoticeBoardApplication.class)
//@WebAppConfiguration
//public class BoardRepositoryTest
//{
//	@Autowired
//	BoardRepository boardRepository;
//
//	@Test
//	public void findByNameTest()
//	{
//		Board board1 = new Board(1L, "tinytots", "1234", "Sample board text1");
//		Board board2 = new Board(2L, "stjoseph", "1234", "Sample board text2");
//		Board board3 = new Board(3L, "rifelspublic", "1234", "Sample board text3");
//		Board board4 = new Board(4L, "govtboys", "1234", "Sample board text4");
//		Board board5 = new Board(5L, "shaheen", "1234", "Sample board text5");
//
//		boardRepository.save(board1);
//		boardRepository.save(board2);
//		boardRepository.save(board3);
//		boardRepository.save(board4);
//		boardRepository.save(board5);
//
//		System.out.println(boardRepository.findByName("tinytots"));
//	}
//}