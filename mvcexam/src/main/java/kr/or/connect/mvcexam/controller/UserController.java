package kr.or.connect.mvcexam.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import kr.or.connect.mvcexam.dto.User;

@Controller
public class UserController {

	@GetMapping("/userform")
	public String userForm() {
		return "userForm";
	}

	@PostMapping("regist")
	public String regist(@ModelAttribute User user) {
		System.out.println("사용자가 입력한 user정보입니다. 해당 정보를 이용하는 코드가 와야 합니다.");
		System.out.println(user);

		return "regist";
	}
}
