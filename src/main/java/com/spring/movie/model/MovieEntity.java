package com.spring.movie.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "movies")
public class MovieEntity {
	@Id
	@Column(name = "tconst")
	private String tconst;
	@Column(name = "title_type")
	private String titleType;
	@Column(name = "primary_title")
	private String primaryTitle;
	@Column(name = "runtime_minutes")
	private int runtimeMinutes;
	@Column(name = "genres")
	private String genres;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "tconst")
	private RatingEntity ratingEntity;
	
	public MovieEntity() {
	
	}
	

	public MovieEntity(String tconst, String titleType, String primaryTitle, int runtimeMinutes, String genres,
			RatingEntity ratingEntity) {
		super();
		this.tconst = tconst;
		this.titleType = titleType;
		this.primaryTitle = primaryTitle;
		this.runtimeMinutes = runtimeMinutes;
		this.genres = genres;
		this.ratingEntity = ratingEntity;
	}


	public RatingEntity getRatingEntity() {
		return ratingEntity;
	}


	public void setRatingEntity(RatingEntity ratingEntity) {
		this.ratingEntity = ratingEntity;
	}


	public String getTconst() {
		return tconst;
	}

	public void setTconst(String tconst) {
		this.tconst = tconst;
	}

	public String getTitleType() {
		return titleType;
	}

	public void setTitleType(String titleType) {
		this.titleType = titleType;
	}

	public String getPrimaryTitle() {
		return primaryTitle;
	}

	public void setPrimaryTitle(String primaryTitle) {
		this.primaryTitle = primaryTitle;
	}

	public int getRuntimeMinutes() {
		return runtimeMinutes;
	}

	public void setRuntimeMinutes(int runtimeMinutes) {
		this.runtimeMinutes = runtimeMinutes;
	}

	public String getGenres() {
		return genres;
	}

	public void setGenres(String genres) {
		this.genres = genres;
	}
	
	
}
