package com.oam.daoimpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.oam.dbconnection.HibernateUtil;
import com.oam.dto.QualityDAO;
import com.oam.models.QualityModel;

public class QualityDAOImpl implements QualityDAO{

	@Override
	public List<QualityModel> getAllQualities() {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(QualityModel.class);
		List<QualityModel> qualities = criteria.list();
		session.close();
		return qualities;
	}

}
