package com.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.models.Course;
import com.models.Game;
import com.models.Progress;
import com.models.Teacher;
import com.services.LoginService;
import com.services.ProgressService;
import com.services.UserService;

@Controller
public class HomeController {

	@Autowired
	private LoginService loginService;

	@Autowired
	private UserService userService;

	@Autowired
	private ProgressService progressService;

	@RequestMapping("/")
	public String Entry() {
		loginService.setCurrentUserID(null);
		return "entry";
	}

	@RequestMapping("/student")
	public String Studenthome(Model model) {
		List<Progress> PlayedGames = progressService.showProgress(loginService.getCurrentUserID());
		model.addAttribute("games", PlayedGames);
		return "studentHome";
	}

	@RequestMapping("/teacher")
	public String Teacherhome(Model model) {
		Teacher teacher = (Teacher) userService.findByName(loginService.getCurrentUserID());
		List<Game> CreatedGames = teacher.getGames();
		model.addAttribute("games", CreatedGames);

		List<Course> CreatedCourses = teacher.getCourses();
		model.addAttribute("courses", CreatedCourses);

		return "teacherHome";
	}

}