package com.register.repository;



import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.register.bean.UserDetails;
@Repository

public interface UserRepository extends JpaRepository<UserDetails, Integer> {

	 List<UserDetails> findAll();
	 
	 UserDetails save(UserDetails user);
		
	 List<UserDetails> findByFirstName(String firstName);
	
	 List<UserDetails> findByUserStatus(String userStatus);
	
	
	List<UserDetails> findAllByEnteredDate(Date enteredDate);
	
	@Transactional
	@Modifying
	@Query("update UserDetails u set u.userStatus = :userStatus WHERE u.userId = :userId")
	void setUserStatus(@Param("userId") Integer userId, @Param("userStatus") String userStatus);
	
	
}
