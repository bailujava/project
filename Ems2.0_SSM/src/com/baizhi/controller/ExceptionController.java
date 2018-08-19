package com.baizhi.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;

import com.baizhi.entity.SystemException;


@ControllerAdvice
public class ExceptionController  {
@ExceptionHandler(SystemException.class)
@ResponseBody
	 public Object customHandler(SystemException e){
	e.printStackTrace();
	return e.getMessage();
}

@ExceptionHandler(Exception.class)
@ResponseBody
	 public Object exceptionHandler(Exception e){
	e.printStackTrace();
	return "系统异常";
}
}
