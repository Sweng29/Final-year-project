package com.oam.business;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.google.gson.Gson;
import com.mysql.fabric.xmlrpc.base.Data;
import com.oam.daoimpl.CategoryDAOImpl;
import com.oam.daoimpl.PostProductDaoImpl;
import com.oam.daoimpl.QualityDAOImpl;
import com.oam.models.ProductCategoryModel;
import com.oam.models.ProductImagesModel;
import com.oam.models.QualityModel;
import com.oam.models.SellingProductModel;
import com.sun.jmx.snmp.Timestamp;
import com.sun.org.glassfish.external.probe.provider.annotations.Probe;



/**
 * Servlet implementation class SellingProductServlet
 */
@WebServlet("/SellingProductServlet")
public class SellingProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SellingProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		if(request.getParameter("method")!=null){
			PrintWriter pw = response.getWriter();
			if(request.getParameter("method").equals("getAllCategories")){
					
				response.setContentType("application/json");
				CategoryDAOImpl categoryDAOImpl = new CategoryDAOImpl();
				List<ProductCategoryModel> categories =  categoryDAOImpl.getAllCategories();
				Gson gson = new Gson();
				System.out.println(gson.toJson(categories));
				pw.print(gson.toJson(categories));
			
			}else if(request.getParameter("method").equals("getAllQualites")){
				response.setContentType("application/json");
				QualityDAOImpl qualityDAOImpl = new QualityDAOImpl();
				List<QualityModel> qualities = qualityDAOImpl.getAllQualities();
				Gson gson = new Gson();
		     	System.out.println(gson.toJson(qualities));
				pw.print(gson.toJson(qualities));
			}
				
			
		}else if (ServletFileUpload.isMultipartContent(request)) {
				
			try {
				List<FileItem> multiparts = new ServletFileUpload(

						new DiskFileItemFactory()).parseRequest((request));
				SellingProductModel sellingProductModel = new SellingProductModel();
				Set<ProductImagesModel> images = new HashSet<>();
				for (FileItem item : multiparts) {
					if (!item.isFormField()) {

						String name = new File(item.getName()).getName();

						item.write(new File("C:\\uploadimages" + File.separator + name));

						ProductImagesModel imagesModel = new ProductImagesModel();
						imagesModel.setImagePath("files" + File.separator + name);
						images.add(imagesModel);
						sellingProductModel.setImages(images);
					} else if (item.isFormField()) {

						if (item.getFieldName().equals("productName")) {
							String productName = item.getString();
							sellingProductModel.setProductName(productName);
						} else if (item.getFieldName().equals("category")) {
							String category = item.getString();
							ProductCategoryModel productCategoryModel = new ProductCategoryModel();
							productCategoryModel.setProductCategoryId(Integer.parseInt(category));
						    sellingProductModel.setCategoryModel(productCategoryModel);
						} else if (item.getFieldName().equals("quantity")) {
							String quantity = item.getString();
							sellingProductModel.setQuantity(Integer.parseInt(quantity));
						} else if (item.getFieldName().equals("minprice")) {
							Long minPrice = Long.parseLong(item.getString());
							sellingProductModel.setMinPrice(minPrice);
						}else if(item.getFieldName().equals("quality")){
							String quality = item.getString();
							QualityModel qualityModel = new QualityModel();
							qualityModel.setQualityId(Integer.parseInt(quality));
						    sellingProductModel.setQualityModel(qualityModel);
						} 
						else if (item.getFieldName().equals("endingdate")) {
							String endingDate = item.getString();
							sellingProductModel.setEndDate(endingDate);
						} 

					}

				}

				// File uploaded successfully
                PostProductDaoImpl postProductDaoImpl = new PostProductDaoImpl(); 
				int i = postProductDaoImpl.postProduct(sellingProductModel);
				PrintWriter printWriter = response.getWriter();
				printWriter.print("success");
	
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			
		}
	}

}
