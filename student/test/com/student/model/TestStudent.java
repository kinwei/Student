package com.student.model;import java.util.Date;import java.util.List;import org.hibernate.Session;import org.hibernate.SessionFactory;import org.hibernate.Transaction;import org.hibernate.cfg.Configuration;import org.hibernate.service.ServiceRegistry;import org.hibernate.service.ServiceRegistryBuilder;import org.hibernate.tool.hbm2ddl.SchemaExport;import org.junit.Test;import com.student.entity.Students;import com.student.service.StudentsDao;import com.student.service.impl.StudentsDaoImpl;public class TestStudent {	@Test	public void testSchemaExport(){		//创建配置对象		Configuration config = new Configuration().configure();		//创建服务对象	    ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();	    //创建sessionFactory	    SessionFactory sessionFactory = config.buildSessionFactory(serviceRegistry);	    Session session = sessionFactory.getCurrentSession();	    SchemaExport export = new SchemaExport(config);	    export.create(true, true);	}		@Test	public void saveStudent(){		//创建配置对象		Configuration config = new Configuration().configure();		//创建服务对象	    ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();	    //创建sessionFactory	    SessionFactory sessionFactory = config.buildSessionFactory(serviceRegistry);	    Session session = sessionFactory.getCurrentSession();	    Transaction transaction = session.beginTransaction();	    	    Students student = new Students("s001","kinwei", "男", new Date(), "山东省");	    Students student2 = new Students("s002","凤儿", "女", new Date(), "湖北省");	    session.save(student2);	    	    transaction.commit();	    sessionFactory.close();	}		@Test	public void queryAllStudents(){		StudentsDao studentsDao = new StudentsDaoImpl();		List<Students> list = studentsDao.queryAllStudents();		for(Students student:list){			System.out.println(student.getSname());		}	}		@Test	public void testGetNewSid(){		StudentsDaoImpl studentsDao = new StudentsDaoImpl();		//System.out.println(studentsDao.getNewSid());	}		@Test	public void testAddStudent(){		StudentsDao sdao = new StudentsDaoImpl();		Students student = new Students("kinwei", "男", new Date(), "山东省");		sdao.addStudents(student);	}		}