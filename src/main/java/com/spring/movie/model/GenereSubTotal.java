package com.spring.movie.model;

public class GenereSubTotal {
	private String genre;
    private String primaryTitle;
    private int numVotes;
    private boolean isSubtotal;
	public GenereSubTotal() {
		
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getPrimaryTitle() {
		return primaryTitle;
	}
	public void setPrimaryTitle(String primaryTitle) {
		this.primaryTitle = primaryTitle;
	}
	public int getNumVotes() {
		return numVotes;
	}
	public void setNumVotes(int numVotes) {
		this.numVotes = numVotes;
	}
	public boolean isSubtotal() {
		return isSubtotal;
	}
	public void setSubtotal(boolean isSubtotal) {
		this.isSubtotal = isSubtotal;
	}

    
}

