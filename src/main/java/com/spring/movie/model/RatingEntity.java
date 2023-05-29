package com.spring.movie.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="ratings")
public class RatingEntity {
	@Id
	@Column(name = "Tconst")
	private String tconst;
	@Column(name = "average_rating")
	private double averagerateing;
	@Column(name = "num_votes") 
	private int numofvotes;
	public RatingEntity(String tconst,double averagerateing, int numofvotes) {
		super();
		this.tconst = tconst;
		this.averagerateing = averagerateing;
		this.numofvotes = numofvotes;
	}

	public RatingEntity() {
		
	}

	public String getTconst() {
		return tconst;
	}
	public void setTconst(String tconst) {
		this.tconst = tconst;
	}
	public double getAveragerateing() {
		return averagerateing;
	}
	public void setAveragerateing(double averagerateing) {
		this.averagerateing = averagerateing;
	}
	public int getNumofvotes() {
		return numofvotes;
	}
	public void setNumofvotes(int numofvotes) {
		this.numofvotes = numofvotes;
	}


}
