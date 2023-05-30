package com.spring.movie.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.movie.dao.MovieRepository;
import com.spring.movie.dao.RatingRepository;
import com.spring.movie.model.GenereSubTotal;
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

	public GenereSubTotal GenreSubtotal() {
		List<MovieEntity> results = rep.getAllMovies();
		List<RatingEntity> list = repo.getAllRatings();
		GenereSubTotal genreMovieSubtotals = new GenereSubTotal();
		int docTotal = 0;
		int shortTotal = 0;
		int sportTotal = 0;
		int newsTotal = 0;
		int animationTotal = 0;
		int romanceTotal = 0;
		int comedyTotal = 0;
		for (MovieEntity e : results) {
			for (RatingEntity r : list) {
				if (e.getTconst().equals(r.getTconst()) && e.getGenres().equals("Documentary")) {
					docTotal += r.getNumofvotes();

				} else if (e.getTconst().equals(r.getTconst()) && e.getGenres().equals("Short")) {

					shortTotal += r.getNumofvotes();

				} else if (e.getTconst().equals(r.getTconst()) && e.getGenres().equals("Sport")) {

					sportTotal += r.getNumofvotes();

				} else if (e.getTconst().equals(r.getTconst()) && e.getGenres().equals("News")) {

					newsTotal += r.getNumofvotes();

				} else if (e.getTconst().equals(r.getTconst()) && e.getGenres().equals("Animation")) {

					animationTotal += r.getNumofvotes();

				} else if (e.getTconst().equals(r.getTconst()) && e.getGenres().equals("Romance")) {

					romanceTotal += r.getNumofvotes();

				} else if (e.getTconst().equals(r.getTconst()) && e.getGenres().endsWith("Comedy")) {

					comedyTotal += r.getNumofvotes();

				}
			}

		}
		genreMovieSubtotals.setComedyTotal(comedyTotal);
		genreMovieSubtotals.setRomanceTotal(romanceTotal);
		genreMovieSubtotals.setAnimationTotal(animationTotal);
		genreMovieSubtotals.setNewsTotal(newsTotal);
		genreMovieSubtotals.setSportTotal(sportTotal);
		genreMovieSubtotals.setShortTotal(shortTotal);
		genreMovieSubtotals.setDocTotal(docTotal);
		return genreMovieSubtotals;
	}
}
