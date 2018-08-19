package action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.annotations.ResultType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.support.XmlWebApplicationContext;

import service.LoginService;
import service.QueryService;
import service.RegisterService;
import service.UserService;

import com.opensymphony.xwork2.ActionSupport;

import entity.User;

@Controller
@RequestMapping("/user")
public class UserAction {
	@Autowired
	private LoginService loginService;
	@Autowired
	private RegisterService registerService;
	@Autowired
	private UserService userService;
	@Autowired
	private QueryService queryService;


	// 登陆
	@RequestMapping("/login.do")
	public String login(String account,String password) {
		System.out.println(account + password);
		boolean login2 = loginService.login(account, password);
		if (login2) {
			return "redirect:/user/show2.do";
		} else {
			return "login";
		}

	}

	// 注册
	@RequestMapping("/register.do")
	public String register(User user) {
		System.out.println(user);
		registerService.modifyRegister(user);
		return "redirect:/user/show2.do";
	}

	// 展示页面
	@RequestMapping("/show2.do")
	public String show2(HttpServletRequest request,HttpServletResponse response) {
	 List<User> qa = queryService.queryAll();
		System.out.println(qa);
		request.setAttribute("qa", qa);
		return "forward:/show.jsp";
	}

	// 删除用户
	@RequestMapping(value="/delete.do",method={RequestMethod.POST})
	public String delete(@RequestParam("list") List<Integer> list) {
			System.out.println(list);
		userService.modifyDeleteSelected(list);

		return "redirect:/user/show2.do";
	}

	//
}
