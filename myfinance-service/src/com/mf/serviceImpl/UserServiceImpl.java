package com.mf.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mf.dao.UserDao;
import com.mf.entity.User;
import com.mf.model.UserModel;
import com.mf.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Override
	public List<UserModel> get() {

		List<User> users = this.userDao.find("from User where 1=1");
		List<UserModel> models = new ArrayList<UserModel>();
		UserModel model = null;
		for (User user : users) {

			model = ConventToModel(user);
			models.add(model);
		}

		return models;
	}

	private UserModel ConventToModel(User user) {

		UserModel model = new UserModel();

		model.setId(user.getId());
		model.setName(user.getName());
		model.setPassword(user.getPassword());
		model.setUserName(user.getUserName());
		return model;
	}

}
