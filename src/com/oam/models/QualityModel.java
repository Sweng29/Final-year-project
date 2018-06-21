package com.oam.models;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="product_quality")
public class QualityModel implements Serializable{

	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	
	public QualityModel(){}
	@Id
	@GeneratedValue
	@Column(name="quality_id")
	private Integer qualityId;
	@Column(name="quality")
	private String quality;
    /*@OneToMany(targetEntity=SellingProductModel.class,mappedBy="qualityModel",cascade=CascadeType.ALL)
    Set<SellingProductModel> sellingProducts = new HashSet<>();
	*/
	public Integer getQualityId() {
		return qualityId;
	}
	public void setQualityId(Integer qualityId) {
		this.qualityId = qualityId;
	}
	public String getQuality() {
		return quality;
	}
	public void setQuality(String quality) {
		this.quality = quality;
	}

}
