package com.vti.mock.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.vti.mock.entity.User;
import com.vti.mock.repository.IUserRepository;
import com.vti.mock.specification.UserSpecification;

@Service
@Transactional
public class UserService implements IUserService{

	@Autowired
	private IUserRepository userRepository;
	
	@Override
	public User getUserByName(String name) {
		return userRepository.findByName(name);
	}
	
	
	/**
	 * get all and filter, search by character
	 */
	@SuppressWarnings("unused")
	@Override
	public Page<User> getAllUsers(Pageable pageable, String search) {

		UserSpecification searchSpecification = new UserSpecification("name", "Like", search);

		Specification<User> where = null;

		if (!StringUtils.isEmpty(search)) {
			if (where == null) {
				where = searchSpecification;
			} else {
				where = where.and(searchSpecification);
			}
		}

		return userRepository.findAll(where, pageable);
	}

    /**
     * get info by id
     */
    @Override
    public User getUserById(int id) {
        return userRepository.findById(id).get();
    }
	
    /**
     * get info by fbid
     */
    @Override
	public User getUserByFbId(String fbId) {
		return userRepository.findByFacebookId(fbId);
	}
    
	/**
	 * create user
	 */
	@Override
	public void createUser(User user) {
		userRepository.save(user);
	}

    /**
     * update info city
     */
    @Override
    public void updateUser(User user) {
        userRepository.save(user);
    }
    
	/**
	 * delete 1 city
	 */
	@Override
	public void deleteUser(int id) {
		userRepository.deleteById(id);
	}

}
