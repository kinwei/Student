package com.student.action;import org.apache.struts2.interceptor.validation.SkipValidation;import com.opensymphony.xwork2.ModelDriven;import com.student.entity.Users;import com.student.service.UsersDao;import com.student.service.impl.UsersDaoImpl;public class UsersAction extends SuperAction implements ModelDriven<Users>{	/**	 * 	 */	private static final long serialVersionUID = 1L;	private Users user = new Users();			public String login(){		UsersDao usersDao = new UsersDaoImpl();		if(usersDao.userLogin(user)){			session.setAttribute("loginUserName", user.getUsername());			return "login_success";		}else{			return "login_fail";		}	}		@SkipValidation	public String logout(){		if(session.getAttribute("loginUserName") != null){			session.removeAttribute("loginUserName");					}		return "logout_success";	}				@Override	public void validate() {				if(user.getUsername().trim().equals("")){			this.addFieldError("usernameError", "用户名不能为空");		}				if(user.getPassword().trim().length() < 6){			this.addFieldError("passwordError", "密码不能少于6位");		}			}	@Override	public Users getModel() {		// TODO Auto-generated method stub		return this.user;	}}