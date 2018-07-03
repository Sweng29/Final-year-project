package com.oam.daoimpl;



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

	@Override
	public int postProduct(SellingProductModel sellingProductModel) {
		
		
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
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

	
	
	
}
