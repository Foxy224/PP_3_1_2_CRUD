package com.crud.controller;

import com.crud.entity.User;
import com.crud.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;




@Controller
@RequestMapping(value = "/users")
public class UsersPageController {

	private final UserService userService;

	public UsersPageController(UserService userService) {
		this.userService = userService;
	}


	@GetMapping()
	public String printUsers(ModelMap model) {

		model.addAttribute("users", userService.listUsers());

		return "/users";
	}

	@GetMapping("/new")
	public String addUser(@ModelAttribute("user") User user) {
		return "/new";
	}

	@PostMapping()
	public String create(@ModelAttribute("user") User user) {
		userService.add(user);
		return "redirect:/users";
	}

	@GetMapping("/edit")
	public String edit(Model model, @RequestParam long id) {
		model.addAttribute("user", userService.getById(id));
		return "/edit";
	}


	@PostMapping("/edit")
	public String update(@ModelAttribute("users") User user, @RequestParam("id") long id) {
		user.setId(id);
		userService.update(user);
		return "redirect:/users";
	}

	@GetMapping("/delete")
	public String delete(@RequestParam long id) {
		userService.delete(id);
		return "redirect:/users";
	}

}