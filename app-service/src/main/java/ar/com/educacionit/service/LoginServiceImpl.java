package ar.com.educacionit.service;

import ar.com.educacionit.dao.UserDao;
import ar.com.educacionit.dao.UserDaoImpl;
import ar.com.educacionit.dao.exceptions.GenericException;
import ar.com.educacionit.domain.User;
import ar.com.educacionit.service.exceptions.ServiceException;

public class LoginServiceImpl implements LoginService{

	private UserDao userDao;
	
	public LoginServiceImpl() {
		this.userDao = new UserDaoImpl();
	}
	
	@Override
	public User getUserByUserName(String user) throws ServiceException {
		try {
			return this.userDao.getByUserName(user);
		} catch (GenericException e) {
			throw new ServiceException("No se pudo obtener el usuario", e);
		}
	}

}
