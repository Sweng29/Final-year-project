package com.oam.daoimpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Restrictions;

import com.oam.dao.FarmerTraderDAO;
import com.oam.dbconnection.HibernateUtil;
import com.oam.models.FarmerTraderModel;

public class FarmerTraderDAOImpl implements FarmerTraderDAO{

	Integer result;
	Transaction tx = null;

	@Override
	public Integer validateEmail(String emailAddress) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try{
			result = 0;
			tx = session.beginTransaction();
			@SuppressWarnings("deprecation")
			Criteria criteria = session.createCriteria(FarmerTraderModel.class);
			criteria.add(Restrictions.eq("email", emailAddress));
			List<FarmerTraderModel> farmerTraderModel = criteria.list();
			if(farmerTraderModel.size()>0)
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

	@Override
	public Integer addFarmerTrader(FarmerTraderModel farmerTraderModel) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try{
			result = 0;
			tx = session.beginTransaction();
			result = (Integer) session.save(farmerTraderModel);
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
	public Integer updateFarmerTrader(FarmerTraderModel farmerTraderModel) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try{
			result = 1;
			tx = session.beginTransaction();
			session.update(farmerTraderModel);
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
	public Integer deleteFarmerTrader(FarmerTraderModel farmerTraderModel) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try{
			result = 0;
			tx = session.beginTransaction();
			session.delete(farmerTraderModel);
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
	public FarmerTraderModel getFarmerTraderById(Integer farmerTraderId) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		FarmerTraderModel farmerTraderModel = null;
		try{
			result = 0;
			tx = session.beginTransaction();
			@SuppressWarnings("deprecation")
			Criteria criteria = session.createCriteria(FarmerTraderModel.class);
			criteria.add(Restrictions.eq("farmerTraderId", farmerTraderId));
			farmerTraderModel =(FarmerTraderModel) criteria.list().get(0);
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
		return farmerTraderModel;
	}

	@Override
	public FarmerTraderModel getLoggedIn(FarmerTraderModel farmerTraderModel) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		FarmerTraderModel resultModel = null;
		try{
			result = 0;
			tx = session.beginTransaction();
			@SuppressWarnings("deprecation")
			Criteria criteria = session.createCriteria(FarmerTraderModel.class);
			Criterion email = Restrictions.eq("email", farmerTraderModel.getEmail());
			Criterion password = Restrictions.eq("password",farmerTraderModel.getPassword());
			LogicalExpression checkUser = Restrictions.and(email,password);
			criteria.add(checkUser);
			List<FarmerTraderModel> farmerTraderList = criteria.list();
			for(FarmerTraderModel u : farmerTraderList)
			{
				resultModel = new FarmerTraderModel();
				resultModel.setEmail(u.getEmail());
				resultModel.setPassword(u.getPassword());
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
		return resultModel;
	}

}
