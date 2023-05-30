package com.spring.movie.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.movie.model.MovieEntity;
import com.spring.movie.model.MovieResponse;
import com.spring.movie.service.MovieService;

@RestController
@RequestMapping("/api/v1")
public class MovieController {
	private MovieService service;

	@Autowired
	public MovieController(MovieService service) {
		super();
		this.service = service;
	}

	@GetMapping("/longest-duration-movies")
	public ResponseEntity<List<MovieResponse>> getLongestDurationMovies() {
		List<MovieResponse> movies = service.findTopOrderByRuntimeMinutesDesc();
		return ResponseEntity.ok(movies);
	}

	@PostMapping("/new-movie")
	public ResponseEntity<MovieEntity> savemovieRow(@RequestBody MovieEntity movieEntity) {
		MovieEntity mov = service.saveMovieEntity(movieEntity);
		return ResponseEntity.ok(mov);
	}

	@PostMapping("/update-runtime-minutes")
	public ResponseEntity<String> updateRuntimeMinutes() {
		service.updateRuntimeMinutes();

		return ResponseEntity.status(HttpStatus.OK).body("Runtime minutes updated successfully.");
	}

	
}
