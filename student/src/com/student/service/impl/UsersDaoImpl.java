package com.student.service.impl;import java.util.List;import org.hibernate.Query;import org.hibernate.Session;import org.hibernate.Transaction;import com.student.entity.Users;import com.student.service.UsersDao;import com.student.util.MyHibernateSessionFactory;public class UsersDaoImpl implements UsersDao {	@Override	public boolean userLogin(Users users) {				//事务对象		Transaction tx = null;		String hql = "";				try{			Session session = MyHibernateSessionFactory.getSessionFactory().getCurrentSession();			tx = session.beginTransaction();			hql = "From Users where username=? and password=?";			Query query = session.createQuery(hql);			query.setParameter(0, users.getUsername());			query.setParameter(1, users.getPassword());			List list = query.list();			tx.commit();			if(list.size() >0){				return true;			}else{				return false;			}					}catch (Exception e) {			// TODO: handle exception			e.printStackTrace();			return false;		}finally{			if(tx != null){														tx = null;			}		}			}}