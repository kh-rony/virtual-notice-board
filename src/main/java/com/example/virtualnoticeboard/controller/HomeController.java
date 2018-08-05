package com.example.virtualnoticeboard.controller;

import com.example.virtualnoticeboard.repository.BoardRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController
{
	private static final Logger LOGGER = LoggerFactory.getLogger(HomeController.class);

	@Autowired
	private BoardRepository boardRepository;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String showHome(Model model)
	{
		LOGGER.debug("Rendering home page");

//		Model model = new Model();
//
//		//Board board = boardRepository.findByName(boardName);
//		List<Board> boardList = boardRepository.findAll();
//
//		if( boardList == null || boardList.isEmpty() )
//		{
//			LOGGER.debug("No Board found");
//
//			model.addAttribute("boardName", boardName);
//
//			return "newboard";
//		}

		return "home";
	}
}