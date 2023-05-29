package com.spring.movie.model;
public class MovieResponse {
	private String tconst;
	
 private String genres;

 private String primaryTitle;
	
 private int runtimeMinutes;

public MovieResponse(String tconst, String primaryTitle, int runtimeMinutes,String genres) {
	super();
	this.tconst = tconst;
	this.genres = genres;
	this.primaryTitle = primaryTitle;
	this.runtimeMinutes = runtimeMinutes;
}

public MovieResponse() {
	super();
	// TODO Auto-generated constructor stub
}

public String getTconst() {
	return tconst;
}

public String getTitleType() {
	return genres;
}

public String getPrimaryTitle() {
	return primaryTitle;
}

public int getRuntimeMinutes() {
	return runtimeMinutes;
}
 

}
