package com.baizhi.action;

import com.baizhi.util.SecurityImage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;

@Controller
@RequestMapping("/anquan")
public class SecurityCode {
    @RequestMapping("/yanzhengma.do")
    public void creatCaptcha(HttpServletResponse response, HttpSession session) {
        /* 1.获取验证码随机数 */
        String code = com.baizhi.util.SecurityCode.getSecurityCode();
        //存到session中,验证用
        session.setAttribute("captche", code);
        /* 2.生成验证码图片 */
        BufferedImage image = SecurityImage.createImage(code);
        /* 3.输出字节流 */
        OutputStream out;
        try {
            out = response.getOutputStream();
            ImageIO.write(image, "png", out);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
