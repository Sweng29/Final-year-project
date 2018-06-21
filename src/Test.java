import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.oam.daoimpl.PostProductDaoImpl;
import com.oam.dbconnection.HibernateUtil;
import com.oam.models.CityModel;
import com.oam.models.FarmerTraderModel;
import com.oam.models.ProductCategoryModel;
import com.oam.models.SellingProductModel;

public class Test {

	public static void main(String[] args) {
	
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		List<SellingProductModel> list = new PostProductDaoImpl().getAllSellingProducts();
		System.out.println(list);
		for(SellingProductModel s : list)
		{
			System.out.println(s.getProductName()+" "+s.getEndDate()+" "+s.getStartDate()+" "+s.getMinPrice()+" "+s.getQuantity()+" "+s.getCategoryModel().getCategory()+" "+s.getQualityModel().getQuality());
		}
		tx.commit();
		session.close();
	}

}
