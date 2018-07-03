package com.oam.daoimpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.oam.dao.EmployeeDAO;
import com.oam.dbconnection.HibernateUtil;
import com.oam.models.EmployeeModel;

public class EmployeeDAOImpl implements EmployeeDAO{

	SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	Session session = null;
	Transaction transaction = null;
	Integer result = 0;
	
	@Override
	public Integer addEmployee(EmployeeModel employeeModel) {
		result = 0;
		try{
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			result = (Integer) session.save(employeeModel);
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
	public Integer updateEmployee(EmployeeModel employeeModel) {
		result = 0;
		try{
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			session.saveOrUpdate(employeeModel);
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
	public Integer deleteEmployee(EmployeeModel employeeModel) {
		result = 0;
		try{
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			session.delete(employeeModel);
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
	public EmployeeModel getEmployeeById(Integer employeeId) {
		EmployeeModel employeeModel=null;
		try{
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			employeeModel = session.get(EmployeeModel.class, employeeId);
			transaction.commit();
		}catch(Exception e)
		{
			if(transaction!=null)
			{
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return employeeModel;
	}

	@Override
	public List<EmployeeModel> getAllEmployees() {
		List<EmployeeModel> employeesList = null;
		try{
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			employeesList = (List<EmployeeModel>)session.createQuery("FROM EmployeeModel").list();
			transaction.commit();
		}catch(Exception e)
		{
			if(transaction!=null)
			{
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return employeesList;
	}

}
