package com.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.forms.LoginForm;
import com.models.IUser;
import com.services.LoginService;
import com.services.UserService;

@Controller
public class AccountController {

	@Autowired
	private UserService userService;

	@Autowired
	private LoginService loginService;

	@RequestMapping("/users/login")
	public String showLoginForm(LoginForm loginForm) {
		return "users/login";
	}

	@RequestMapping(value = "/users/login", method = RequestMethod.POST)
	public String showLoginForm(@Valid LoginForm loginForm, BindingResult bindingResult) {

		IUser user = userService.findbyNameAndPassword(loginForm.getUsername(), loginForm.getPassword());
		user = userService.findByName(loginForm.getUsername());
		if (user == null)
			return "redirect:/users/login";
		loginService.setCurrentUserID(user.getUsername());
		if (user.isTeacher())
			return "redirect:/teacher";
		else
			return "redirect:/student";
	}

	@RequestMapping("/users/register")
	public String showRegisterForm(Model model, HttpServletRequest request) {
		IUser user = new IUser();
		model.addAttribute("user", user);
		return "users/register";
	}

	@RequestMapping(value = "/users/register", method = RequestMethod.POST)
	public String showRegisterForm(HttpServletRequest request, @ModelAttribute IUser user) {

		String radio = request.getParameter("radio");
		user.setTeacher(radio.equals("0") ? false : true);
		IUser tmp = userService.register(user);
		if (tmp == null)
			return "redirect:/users/register";

		loginService.setCurrentUserID(user.getUsername());
		if (user.isTeacher())
			return "redirect:/teacher";
		else
			return "redirect:/student";
	}
}
