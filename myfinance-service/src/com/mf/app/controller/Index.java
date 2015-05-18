package com.mf.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mf.model.UserModel;
import com.mf.service.UserService;

/**
 * 
 * @author ����ϧ�͡�
 *
 */
@Controller
@RequestMapping("/app")
public class Index {

	@Autowired
	private UserService userService;

	@RequestMapping("/")
	public ModelAndView index() {

		ModelAndView view = new ModelAndView("/index");
		List<UserModel> users = this.userService.get();
		view.addObject("users", users);
		return view;
	}

}
