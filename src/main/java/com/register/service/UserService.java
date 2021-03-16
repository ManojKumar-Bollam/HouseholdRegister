package com.register.service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.register.Exception.UserNotFoundException;
import com.register.bean.UserDetails;
import com.register.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;

	public List<UserDetails> findAll() {
		return userRepository.findAll();

	}

	public UserDetails save(UserDetails user) {
		return userRepository.save(user);
	}

	public List<UserDetails> findByFirstName(String firstName) {
		return userRepository.findByFirstName(firstName);

	}

	public List<UserDetails> findByUserStatus(String userStatus) {
		return userRepository.findByUserStatus(userStatus);
	}

	public List<UserDetails> findAllByEnteredDate(Date enteredDate) {
		return userRepository.findAllByEnteredDate(enteredDate);
	}

	public void setUserStatus(Integer userId, String userStatus) {
		userRepository.setUserStatus(userId, userStatus);

	}

	public void setUserStatusUpdate(Integer userId, String userStatus) throws UserNotFoundException {
		// userRepository.setUserStatus(userId, userStatus);
		Optional<UserDetails> details = userRepository.findById(userId);
		if (!(details.isEmpty())) {
			UserDetails details2 = details.get();
			details2.setUserStatus(userStatus);
			UserDetails modified = userRepository.save(details2);
			System.out.println("modifiedmodifiedmodified  =" + modified.toString());
		} else {
			throw new UserNotFoundException("User value not Found");
		}

	}
}
