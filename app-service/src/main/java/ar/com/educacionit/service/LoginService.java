package ar.com.educacionit.service;

import ar.com.educacionit.domain.User;
import ar.com.educacionit.service.exceptions.ServiceException;

public interface LoginService {

	public User getUserByUserName(String user) throws ServiceException;

}
