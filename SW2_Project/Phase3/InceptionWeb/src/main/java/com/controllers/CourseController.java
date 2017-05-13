package com.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.models.Course;
import com.models.Game;
import com.services.CourseService;
import com.services.GameService;
import com.services.LoginService;

@Controller
public class CourseController {
	@Autowired
	private CourseService courseService;

	@Autowired
	private GameService gameService;

	@Autowired
	private LoginService loginService;

	@RequestMapping("/course/createCourse")
	public String CreateCourse(Model model) {
		Course course = new Course();
		model.addAttribute("course", course);
		return "course/createCourse";
	}

	@RequestMapping(value = "/course/createCourse", method = RequestMethod.POST)
	public String CreateCourse(@ModelAttribute Course course) {
		Course tmp = courseService.findByName(course.getCourseName());
		if (tmp != null)
			return "redirect:/course/createCourse";
		course.setCourseOwner(loginService.getCurrentUserID());
		courseService.add(course);
		return "redirect:/teacher";
	}

	@RequestMapping("/course/show")
	public String ShowCourses(Model model) {
		List<Course> courses = courseService.findAll();
		model.addAttribute("courses", courses);
		return "showCourses";
	}

	@RequestMapping("/course/show/{name}")
	public String view(@PathVariable("name") String name, Model model) {
		Course course = courseService.findByName(name);
		if (course == null)
			return "redirect:/";

		List<Game> games = gameService.findAll(course.getCourseName());
		model.addAttribute("games", games);
		return "course/showGames";
	}

	@RequestMapping("/course/showGame/{name}")
	public String ShowGame(@PathVariable("name") String name, Model model, RedirectAttributes attributes) {
		attributes.addAttribute("gamename", name);
		return "redirect:/game/findGame";
	}
}
