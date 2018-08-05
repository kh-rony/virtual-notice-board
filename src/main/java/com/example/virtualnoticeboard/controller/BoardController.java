package com.example.virtualnoticeboard.controller;

import com.example.virtualnoticeboard.dto.RegistrationForm;
import com.example.virtualnoticeboard.entity.Board;
import com.example.virtualnoticeboard.repository.BoardRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class BoardController
{
	private static final Logger LOGGER = LoggerFactory.getLogger(BoardController.class);

	@Autowired
	private BoardRepository boardRepository;


	@RequestMapping(value = "/{boardName}", method = RequestMethod.GET)
	public String showBoard(@PathVariable("boardName") String boardName, Model model)
	{
		LOGGER.debug("Rendering board page: " + boardName);

		Board board = boardRepository.findByName(boardName);

		if( board == null )
		{
			LOGGER.debug("Board not found: " + boardName);

			model.addAttribute("boardName", boardName);

			return "newboard";
		}

		model.addAttribute("boardName", boardName);
		model.addAttribute("boardContent", board.getContent());

		return "board";
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String registerBoard(@Valid RegistrationForm registrationForm, BindingResult bindingResult, WebRequest webRequest, RedirectAttributes redirectAttributes)
	{
		System.out.println(webRequest.getParameter("boardName"));
		System.out.println(webRequest.getParameter("password"));

		if( bindingResult.hasErrors() )
		{
			System.out.println(bindingResult.getAllErrors());

			redirectAttributes.addAttribute("error", "Password must be more than 3 characters & upto 100 characters");

			return "redirect:/" + webRequest.getParameter("boardName");
		}

		Board board = new Board();

		board.setName(webRequest.getParameter("boardName"));
		board.setPassword(webRequest.getParameter("password"));

		boardRepository.save(board);

		return "redirect:/" + webRequest.getParameter("boardName");
	}

	@RequestMapping(value = "/{boardName}/edit", method = RequestMethod.GET)
	public String editBoard(@PathVariable("boardName") String boardName, Model model)
	{
		LOGGER.debug("Rendering board edit page: " + boardName);

		Board board = boardRepository.findByName(boardName);

		if( board == null )
		{
			LOGGER.debug("Board not found: " + boardName);

			return "redirect:/";
		}

		model.addAttribute("boardContent", board.getContent());

		System.out.println(board.getContent());
		System.out.println("from edit page");

		return "editboard";
	}

	@RequestMapping(value = "/{boardName}/edit", method = RequestMethod.POST)
	public String doEditBoard(@PathVariable("boardName") String boardName, WebRequest webRequest, RedirectAttributes redirectAttributes, Model model)
	{
		Board board = boardRepository.findByName(boardName);

		if( board == null )
		{
			LOGGER.debug("Board not found: " + boardName);

			return "redirect:/";
		}

		if( board.getPassword().equals(webRequest.getParameter("password")) )
		{
			board.setContent(webRequest.getParameter("boardContent"));

			boardRepository.save(board);

			return "redirect:/" + webRequest.getParameter("boardName");
		}

		redirectAttributes.addAttribute("error", "Password mismatch");

		return "redirect:/" + webRequest.getParameter("boardName") + "/edit";
	}
}