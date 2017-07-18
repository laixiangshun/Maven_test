package com.lai.storm.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lai.storm.entity.Book;
import com.lai.storm.service.BookService;
import com.lai.storm.util.AppointExecution;
import com.lai.storm.util.Result;

@RequestMapping("/book")
@Controller
public class BookController {

	private Logger logger=LoggerFactory.getLogger(this.getClass());
	@Autowired
	private BookService bookService;
	
	@RequestMapping(value="/booklist.html",method=RequestMethod.GET)
	public String list(Model model){
		List<Book> booklist=bookService.getList();
		model.addAttribute("booklist",booklist);
		return "list";
	}
	@RequestMapping(value="/bookdetail.html",method=RequestMethod.GET)
	public String detail(HttpServletRequest request,HttpServletResponse response,Model model){
		String bookid=request.getParameter("bookid");
		if(bookid==null){
			return "redirect:/list";
		}
		Book book=bookService.getById(Long.parseLong(bookid));
		if(book==null){
			return "forward:/list";
		}
		model.addAttribute("book",book);
		return "detail";
	}
	@RequestMapping(value="/appointbook.action",method=RequestMethod.POST,produces={"application/json;charset=utf-8"})
	@ResponseBody
	public Result<?> appoint(HttpServletRequest request,HttpServletResponse response,Model model){
		try {
			String bookid=request.getParameter("bookid");
			String studentid=request.getParameter("studentid");
			if(studentid==null || studentid.equals("")){
				return new Result<>(false,"学号不能为空");
			}
			AppointExecution execution=bookService.appoint(Long.parseLong(bookid), Long.parseLong(studentid));
			return new Result<>(true,execution);
		} catch (Exception e) {
			// TODO: handle exception
			logger.error(e.getMessage(),e);
			return new Result<>(false,"发生异常");
		}
	}
}
