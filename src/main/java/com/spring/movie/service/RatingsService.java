package com.spring.movie.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.movie.dao.MovieRepository;
import com.spring.movie.dao.RatingRepository;
import com.spring.movie.model.GetMovieResponseTwo;
import com.spring.movie.model.MovieEntity;
import com.spring.movie.model.RatingEntity;

@Service
public class RatingsService {
	private RatingRepository repo;
	@Autowired
	private MovieRepository rep;

	@Autowired
	public RatingsService(RatingRepository repo) {
		super();
		this.repo = repo;
	}

	public List<GetMovieResponseTwo> getTopRatedMovies() {
		List<String> tconstList = new ArrayList<>();
		List<RatingEntity> ratingList = repo.findByAveragerateingGreaterThan(6.0);
		for (RatingEntity rating : ratingList) {
			String tconst = rating.getTconst();
			tconstList.add(tconst);
		}

		List<GetMovieResponseTwo> response = new ArrayList<>();
		List<MovieEntity> movieList = rep.findAllById(tconstList);
		for (MovieEntity movie : movieList) {
			GetMovieResponseTwo r = new GetMovieResponseTwo();
			r.setTconst(movie.getTconst());
			r.setPrimarytitle(movie.getPrimaryTitle());
			r.setGenre(movie.getGenres());

			for (RatingEntity rating : ratingList) {
				if (rating.getTconst().equals(movie.getTconst())) {
					r.setAveragerating(rating.getAveragerateing());
					break;
				}
			}

			response.add(r);
		}

		return response;
	}

//	public  List<MovieGenreResponse> getGenreMoviesWithSubtotals() {
//		List<MovieGenreResponse> respons = new ArrayList<>();
//
//		String sqlQuery = "SELECT genres AS Genre, primary_title AS primaryTitle, num_votes AS numVotes "
//				+ "FROM movies " + "GROUP BY genres, primary_title WITH ROLLUP";
//		DriverManagerDataSource dataSource = new DriverManagerDataSource();
//		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
//		dataSource.setUrl("jdbc:mysql://localhost:3306/jdbctwo");
//		dataSource.setUsername("root");
//		dataSource.setPassword("root");
//		try (Connection connection = dataSource.getConnection();
//				Statement statement = connection.createStatement();
//				ResultSet resultSet = statement.executeQuery(sqlQuery)) {
//
//			String currentGenre = null;
//			int subtotal = 0;
//
//			while (resultSet.next()) {
//				String genre = resultSet.getString("Genre");
//				String primaryTitle = resultSet.getString("primaryTitle");
//				int numVotes = resultSet.getInt("numVotes");
//
//				if (genre != null) {
//
//					if (currentGenre != null) {
//						respons.add(new MovieGenreResponse("TOTAL", "", subtotal));
//					}
//
//					currentGenre = genre;
//					subtotal = 0;
//				}
//
//				respons.add(new MovieGenreResponse(genre, primaryTitle, numVotes));
//				subtotal += numVotes;
//			}
//
//			if (currentGenre != null) {
//				respons.add(new MovieGenreResponse("TOTAL", "", subtotal));
//			}
//
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//
//		return respons;
//	}
	 
}
