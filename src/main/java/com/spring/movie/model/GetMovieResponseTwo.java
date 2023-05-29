package com.spring.movie.model;

public class GetMovieResponseTwo {
	private String tconst;
	private String primarytitle;
	private String genre;
	private double averagerating;
	
	public void setTconst(String tconst) {
		this.tconst = tconst;
	}
	public void setPrimarytitle(String primarytitle) {
		this.primarytitle = primarytitle;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public void setAveragerating(double averagerating) {
		this.averagerating = averagerating;
	}
	public GetMovieResponseTwo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getTconst() {
		return tconst;
	}
	public String getPrimarytitle() {
		return primarytitle;
	}
	public String getGenre() {
		return genre;
	}
	public double getAveragerating() {
		return averagerating;
	}

}
