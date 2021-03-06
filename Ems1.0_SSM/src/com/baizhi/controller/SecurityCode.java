package com.baizhi.controller;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.baizhi.util.SecurityImage;

@Controller
@RequestMapping("/SecurityCode")
public class SecurityCode {
	@RequestMapping("/creatCaptcha.do")
	public void creatCaptcha(HttpServletResponse response,HttpSession session) throws Exception {
		/* 1.获取验证码随机数 */
		String code = com.baizhi.util.SecurityCode.getSecurityCode();
		//存到session中,验证用
		session.setAttribute("captche", "code");
		/* 2.生成验证码图片 */
		BufferedImage image = SecurityImage.createImage(code);
		/* 3.输出字节流 */
		OutputStream out = response.getOutputStream();
		ImageIO.write(image, "png", out);
	}
}
