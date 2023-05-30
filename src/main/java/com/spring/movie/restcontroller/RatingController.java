package com.spring.movie.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.movie.model.GenereSubTotal;
import com.spring.movie.model.GetMovieResponseTwo;
import com.spring.movie.service.RatingsService;

@RestController
@RequestMapping("/api/v1")
public class RatingController {
	private RatingsService rservice;

	@Autowired
	public RatingController(RatingsService rservice) {
		super();
		this.rservice = rservice;
	}

	@GetMapping("/top-rated-movies")
	public ResponseEntity<List<GetMovieResponseTwo>> getTopRatedMovies() {
		List<GetMovieResponseTwo> list = rservice.getTopRatedMovies();
		return ResponseEntity.ok(list);
	}
	 @GetMapping("/genre-movies-with-subtotals")
	 public ResponseEntity<GenereSubTotal>getGenreMoviesWithSubtotals() {
		 GenereSubTotal total=rservice.GenreSubtotal();
		return ResponseEntity.status(HttpStatus.OK).body(total);
	 }
}
