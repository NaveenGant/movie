package com.spring.movie.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.spring.movie.model.GenereSubTotal;
import com.spring.movie.model.MovieEntity;

public interface MovieRepository extends JpaRepository<MovieEntity, String> {

	List<MovieEntity> findTop10ByOrderByRuntimeMinutesDesc();
	
	 @Modifying
	    @Query("UPDATE MovieEntity m SET m.runtimeMinutes = m.runtimeMinutes + :minutes WHERE m.genres = :genre")
	    void updateRuntimeMinutesByGenre(String genre, int minutes);

	    @Modifying
	    @Query("UPDATE MovieEntity m SET m.runtimeMinutes = m.runtimeMinutes + :minutes WHERE m.genres NOT IN (:genres)")
	    void updateRuntimeMinutesByOtherGenres(int minutes, String... genres);
	    
		/*
		 * @Query("SELECT m.genres AS genre, m.primaryTitle AS primaryTitle, r.numofvotes AS numVotes, false AS isSubtotal "
		 * + "FROM MovieEntity m JOIN RatingEntity r ON m.tconst = r.tconst " +
		 * "GROUP BY m.genres, m.primaryTitle " + "WITH ROLLUP") List<GenereSubTotal>
		 * getGenreMoviesWithSubtotals();
		 */
}
