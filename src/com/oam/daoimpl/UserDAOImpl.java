package com.oam.daoimpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Restrictions;

import com.oam.dao.UserDAO;
import com.oam.dbconnection.HibernateUtil;
import com.oam.models.UserModel;

public class UserDAOImpl implements UserDAO{

	Integer result;
	Transaction tx = null;
	@Override
	public Integer addUser(UserModel userModel) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try{
			result = 0;
			tx = session.beginTransaction();
			result = (Integer) session.save(userModel);
			tx.commit();
		}catch(Exception e)
		{
			if(tx!=null)
			{
				tx.rollback();
			}
			e.printStackTrace();
		}finally{
			session.close();
		}
		return result;
	}

	@Override
	public Integer updateUser(UserModel userModel) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try{
			result = 1;
			tx = session.beginTransaction();
			session.update(userModel);
			tx.commit();
		}catch(Exception e)
		{
			if(tx!=null)
			{
				tx.rollback();
			}
			e.printStackTrace();
		}finally{
			session.close();
		}
		return result;
	}

	@Override
	public Integer deleteUser(UserModel userModel) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try{
			result = 0;
			tx = session.beginTransaction();
			session.delete(userModel);
			tx.commit();
		}catch(Exception e)
		{
			if(tx!=null)
			{
				tx.rollback();
			}
			e.printStackTrace();
		}finally{
			session.close();
		}
		return result;
	}

	@Override
	public UserModel getUserById(Integer userId) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		UserModel userModel = null;
		try{
			result = 0;
			tx = session.beginTransaction();
			@SuppressWarnings("deprecation")
			Criteria criteria = session.createCriteria(UserModel.class);
			criteria.add(Restrictions.eq("userId", userId));
			userModel =(UserModel) criteria.list().get(0);
			tx.commit();
		}catch(Exception e)
		{
			if(tx!=null)
			{
				tx.rollback();
			}
			e.printStackTrace();
		}finally{
			session.close();
		}
		return userModel;
	}

	@Override
	public UserModel getLoggedIn(UserModel userModel) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		UserModel resultModel = new UserModel();
		try{
			result = 0;
			tx = session.beginTransaction();
			@SuppressWarnings("deprecation")
			Criteria criteria = session.createCriteria(UserModel.class);
			Criterion email = Restrictions.eq("email", userModel.getEmail());
			Criterion password = Restrictions.eq("password",userModel.getPassword());
			LogicalExpression checkUser = Restrictions.and(email,password);
			criteria.add(checkUser);
			resultModel =(UserModel) criteria.list().get(0);
			System.out.println(resultModel.getEmail());
			System.out.println(resultModel.getPassword());
			tx.commit();
		}catch(Exception e)
		{
			if(tx!=null)
			{
				tx.rollback();
			}
			e.printStackTrace();
		}finally{
			session.close();
		}
		return resultModel;
	}

	@Override
	public Integer validateEmail(String emailAddress) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try{
			result = 0;
			tx = session.beginTransaction();
			@SuppressWarnings("deprecation")
			Criteria criteria = session.createCriteria(UserModel.class);
			criteria.add(Restrictions.eq("email", emailAddress));
			List<UserModel> userModel = criteria.list();
			if(userModel.size()>0)
			{
				result = 1;
			}
			tx.commit();
		}catch(Exception e)
		{
			if(tx!=null)
			{
				tx.rollback();
			}
			e.printStackTrace();
		}finally{
			session.close();
		}
		return result;
	}

}
