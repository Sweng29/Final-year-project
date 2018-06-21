package com.oam.daoimpl;



import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.oam.dao.PostProductDao;
import com.oam.dbconnection.HibernateUtil;
import com.oam.models.FarmerTraderModel;
import com.oam.models.ProductCategoryModel;
import com.oam.models.QualityModel;
import com.oam.models.SellingProductModel;

public class PostProductDaoImpl implements PostProductDao{

	SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	Session session = null;
	Transaction transaction = null;
	
	@Override
	public int postProduct(SellingProductModel sellingProductModel) {	
		session = sessionFactory.openSession();
		transaction = session.beginTransaction();
		SellingProductModel sellingProduct = new SellingProductModel();
		ProductCategoryModel productCategoryModel = session.get(ProductCategoryModel.class, sellingProductModel.getCategoryModel().getProductCategoryId());
		sellingProduct.setCategoryModel(productCategoryModel);
		QualityModel qualityModel = session.get(QualityModel.class, sellingProductModel.getQualityModel().getQualityId());
	    sellingProduct.setQualityModel(qualityModel);
	    sellingProduct.setProductName(sellingProductModel.getProductName());
	    sellingProduct.setEndDate(sellingProductModel.getEndDate());
	    sellingProduct.setQuantity(sellingProductModel.getQuantity());
	    sellingProduct.setMinPrice(sellingProductModel.getMinPrice());
	    sellingProduct.setStartDate(String.valueOf(System.currentTimeMillis()));
	    FarmerTraderModel farmerTraderModel = session.get(FarmerTraderModel.class, 1);
	    sellingProduct.setFarmerTraderModel(farmerTraderModel);
	    sellingProduct.setImages(sellingProductModel.getImages());
	    int i = (int) session.save(sellingProduct);
	    transaction.commit();
	    session.close();
	    return i;
	}

	@Override
	public List<SellingProductModel> getAllSellingProducts() {
		List<SellingProductModel> listOfSellingProducts = null;
		try{
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			listOfSellingProducts = (List<SellingProductModel>) session.createQuery("From SellingProductModel").list();
			transaction.commit();
		}catch(Exception e)
		{
			if(transaction!=null)
			{
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return listOfSellingProducts;
	}

	@Override
	public SellingProductModel getSellingProductById(Integer sellingProductId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer updateSellingProduct(SellingProductModel sellingProductModel) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer deleteSellingProductById(Integer sellingProductId) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
