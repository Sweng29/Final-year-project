package com.oam.daoimpl;

import java.util.List;



import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.oam.dao.CategoryDAO;
import com.oam.dbconnection.HibernateUtil;
import com.oam.models.ProductCategoryModel;

public class CategoryDAOImpl implements CategoryDAO {

	@Override
	public List<ProductCategoryModel> getAllCategories() {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Criteria criteria = session.createCriteria(ProductCategoryModel.class);
		List<ProductCategoryModel> categories = criteria.list();
	    transaction.commit();
	    session.close();
		return categories;
	}

}
