package com.oam.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.oam.dao.ProvinceDAO;
import com.oam.dbconnection.HibernateUtil;
import com.oam.models.ProvinceModel;

public class ProvinceDAOImpl implements ProvinceDAO{

	SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	Session session = null;
	Transaction transaction = null;
	Integer result = 0;
	
	@Override
	public Integer addProvince(ProvinceModel provinceModel) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer updateProvince(ProvinceModel provinceModel) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer deleteProvinceById(Integer provinceId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProvinceModel getProvinceById(Integer provinceId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProvinceModel getProvinceByName(String provinceName) {
		ProvinceModel provinceModel = null;
		try{
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			provinceModel = (ProvinceModel) session.createQuery("FROM ProvinceModel p where p.provinceName = '"+provinceName+"'").getSingleResult();
			transaction.commit();
		}catch(Exception e)
		{
			if(transaction!=null)
			{
				transaction.rollback();
			}
		}
		return provinceModel;
	}

	@Override
	public List<ProvinceModel> getAllProvinces() {
		List<ProvinceModel> provinceList = new ArrayList<ProvinceModel>();
		try{
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			provinceList = (List<ProvinceModel>) session.createQuery("FROM ProvinceModel").list();
			System.out.println(provinceList.size());
			transaction.commit();
			
		}catch(Exception e)
		{
			if(transaction!=null)
			{
				transaction.rollback();
			}
		}
		return provinceList;
	}
}
