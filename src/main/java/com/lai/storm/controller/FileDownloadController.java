package com.lai.storm.controller;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class FileDownloadController {

	@Autowired
	private ResourceLoader resourceLoader;
	@RequestMapping(value="/getFile.html",method=RequestMethod.GET)
	@ResponseBody
	public String TestProperties() throws IOException{
		  String content = IOUtils.toString(resourceLoader.getResource("/WEB-INF/target_file.txt").getInputStream());
	        return "the content of resources:" + content;
	}
	
	@RequestMapping(value="/download.html",method=RequestMethod.GET)
	public void GetFile(HttpServletRequest request,HttpServletResponse response) throws IOException{
		try {
			DefaultResourceLoader loader=new DefaultResourceLoader();
			InputStream in=loader.getResource("classpath:file.txt").getInputStream();
			IOUtils.copy(in, response.getOutputStream());
			response.setHeader("Content-Disposition", "attachment;filename=\""+new String(("file.txt").getBytes(),"iso-8899-1")+"\"");
			response.flushBuffer();
		} catch (Exception e) {
			throw new RuntimeException();
		}
	}
}
