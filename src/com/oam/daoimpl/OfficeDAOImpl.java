package com.oam.daoimpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.oam.dao.OfficeDAO;
import com.oam.dbconnection.HibernateUtil;
import com.oam.models.OfficeModel;

public class OfficeDAOImpl implements OfficeDAO{

	SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	Session session = null;
	Transaction transaction = null;
	Integer result = 0;
	
	@Override
	public Integer addOffice(OfficeModel officeModel) {
		result = 0;
		try{
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			result = (Integer) session.save(officeModel);
			transaction.commit();
			session.close();
		}catch(Exception e)
		{
			if(transaction!=null)
			{
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return result;

	}

	@Override
	public Integer updateOffice(OfficeModel officeModel) {
		result = 0;
		try{
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			session.saveOrUpdate(officeModel);
			result = 1;
			transaction.commit();
			session.close();
		}catch(Exception e)
		{
			if(transaction!=null)
			{
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public Integer deleteOffice(OfficeModel officeModel) {
		result = 0;
		try{
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			session.delete(officeModel);
			result = 1;
			transaction.commit();
			session.close();
		}catch(Exception e)
		{
			if(transaction!=null)
			{
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public OfficeModel getOfficeById(Integer officeId) {
		OfficeModel officeModel=null;
		try{
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			officeModel = session.get(OfficeModel.class, officeId);
			transaction.commit();
		}catch(Exception e)
		{
			if(transaction!=null)
			{
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return officeModel;
	}

	@Override
	public OfficeModel getOfficeByName(String officeName) {
		OfficeModel officeModel=null;
		try{
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			officeModel = (OfficeModel)session.createQuery("FROM OfficeModel o where o.officeName='"+officeName+"'").getSingleResult();
			transaction.commit();
		}catch(Exception e)
		{
			if(transaction!=null)
			{
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return officeModel;
	}

	@Override
	public List<OfficeModel> getAllOfficies() {
		List<OfficeModel> officeList = null;
		try{
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			officeList = (List<OfficeModel>)session.createQuery("FROM OfficeModel").list();
			transaction.commit();
		}catch(Exception e)
		{
			if(transaction!=null)
			{
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return officeList;
	}

}
