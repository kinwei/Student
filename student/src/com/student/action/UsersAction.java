package com.student.action;import com.opensymphony.xwork2.ModelDriven;import com.student.entity.Users;import com.student.service.UsersDao;import com.student.service.impl.UsersDaoImpl;public class UsersAction extends SuperAction implements ModelDriven<Users>{	/**	 * 	 */	private static final long serialVersionUID = 1L;	private Users user = new Users();			public String login(){		UsersDao usersDao = new UsersDaoImpl();		if(usersDao.userLogin(user)){			return "login_success";		}else{			return "login_fail";		}	}		@Override	public Users getModel() {		// TODO Auto-generated method stub		return this.user;	}}