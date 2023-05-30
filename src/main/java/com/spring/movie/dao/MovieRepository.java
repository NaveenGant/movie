package com.spring.movie.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.spring.movie.model.MovieEntity;

public interface MovieRepository extends JpaRepository<MovieEntity, String> {

	List<MovieEntity> findTop10ByOrderByRuntimeMinutesDesc();

	@Modifying
	@Query("UPDATE MovieEntity m SET m.runtimeMinutes = m.runtimeMinutes + :minutes WHERE m.genres = :genre")
	void updateRuntimeMinutesByGenre(String genre, int minutes);

	@Modifying
	@Query("UPDATE MovieEntity m SET m.runtimeMinutes = m.runtimeMinutes + :minutes WHERE m.genres NOT IN (:genres)")
	void updateRuntimeMinutesByOtherGenres(int minutes, String... genres);

	List<MovieEntity> findAll();
   
	 @Query("SELECT m FROM MovieEntity m")
	    List<MovieEntity> getAllMovies();
	

}
