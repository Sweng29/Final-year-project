package com.oam.daoimpl;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.oam.dao.CityDAO;
import com.oam.dbconnection.HibernateUtil;
import com.oam.models.CityModel;
import com.oam.models.ProvinceModel;

public class CityDAOImpl implements CityDAO{

	SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	Session session = null;
	Transaction transaction = null;
	Integer result = 0;
	
	@Override
	public Integer addCity(CityModel cityModel) {
		result = 0;
		try{
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			result = (Integer) session.save(cityModel);
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
	public Integer updateCity(CityModel cityModel) {
		result = 0;
		try{
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			session.saveOrUpdate(cityModel);
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
	public Integer deleteCity(CityModel cityModel) {
		result = 0;
		try{
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			session.delete(cityModel);
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
	public CityModel getCityById(Integer cityId) {
		CityModel cityModel=null;
		try{
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			cityModel = session.get(CityModel.class, cityId);
			transaction.commit();
		}catch(Exception e)
		{
			if(transaction!=null)
			{
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return cityModel;
	}

	@Override
	public CityModel getCityByName(String cityName) {
		CityModel cityModel=null;
		try{
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			cityModel = (CityModel)session.createQuery("FROM CityModel c where c.cityName='"+cityName+"'").getSingleResult();
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
		return cityModel;
	}

	@Override
	public List<CityModel> getAllCities() {
		List<CityModel> citiesList = null;
		try{
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			citiesList = (List<CityModel>)session.createQuery("FROM CityModel").list();
			transaction.commit();
		}catch(Exception e)
		{
			if(transaction!=null)
			{
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return citiesList;
	}

	@Override
	public List<CityModel> getAllCitiesByProvinceId(Integer provinceId) {
		List<CityModel> citiesList = null;
		try{
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			session.get(ProvinceModel.class, provinceId);
			System.out.println(provinceId);
			citiesList = (List<CityModel>)session.createQuery("FROM CityModel c where c.provinceId='"+provinceId+"'").list();
			transaction.commit();
		}catch(Exception e)
		{
			if(transaction!=null)
			{
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return citiesList;
	}


}
