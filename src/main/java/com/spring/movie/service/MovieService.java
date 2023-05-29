package com.spring.movie.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.movie.dao.MovieRepository;
import com.spring.movie.model.GenereSubTotal;
import com.spring.movie.model.MovieEntity;
import com.spring.movie.model.MovieResponse;

@Service
public class MovieService {

	private MovieRepository repo;

	@Autowired
	public MovieService(MovieRepository repo) {
		super();
		this.repo = repo;
	}

	public List<MovieResponse> findTopOrderByRuntimeMinutesDesc() {
		List<MovieEntity> movies = repo.findTop10ByOrderByRuntimeMinutesDesc();
		List<MovieResponse> movieResponses = movies.stream().map(movie -> new MovieResponse(movie.getTconst(),
				movie.getPrimaryTitle(), movie.getRuntimeMinutes(), movie.getGenres())).collect(Collectors.toList());

		return movieResponses;
	}

	public MovieEntity saveMovieEntity(MovieEntity movieEntity) {

		MovieEntity mv = movieEntity;
		return repo.save(mv);
	}
	 @Transactional
	    public void updateRuntimeMinutes() {
	        // Update runtimeMinutes based on genre using JPA repository method
	        repo.updateRuntimeMinutesByGenre("Documentary", 15);
	        repo.updateRuntimeMinutesByGenre("Animation", 30);
	        repo.updateRuntimeMinutesByOtherGenres(45);

	        System.out.println("Runtime minutes updated successfully.");
	    }
//	 public List<GenereSubTotal> getGenreMoviesWithSubtotals() {
//	        return repo.getGenreMoviesWithSubtotals();
//	    }
}
