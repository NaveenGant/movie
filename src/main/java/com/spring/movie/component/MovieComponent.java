package com.spring.movie.component;

import java.io.FileReader;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import com.spring.movie.dao.MovieRepository;
import com.spring.movie.model.MovieEntity;
import com.spring.movie.service.MovieService;
import com.spring.movie.service.RatingsService;

@Component
public class MovieComponent implements ApplicationListener<ApplicationReadyEvent> {

	private final MovieRepository mrepo;

	@Autowired

	public MovieComponent(MovieRepository mrepo) {
		super();
		this.mrepo = mrepo;
	}

	
	@Override
	public void onApplicationEvent(ApplicationReadyEvent event) {
		// TODO Auto-generated method stub
		String csv = "C:\\Users\\ganta\\projects\\movies.csv";
		// String csrpath="C:\\Users\\ganta\\projects\\ratings.csv";

		try (CSVReader reader = new CSVReader(new FileReader(csv))) {
			String[] nextLine;
			while ((nextLine = reader.readNext()) != null) {
				String tconst = nextLine[0];
				String titletype = nextLine[1];
				String primarytitle = nextLine[2];
				int runtime = Integer.parseInt(nextLine[3]);

				String geners = nextLine[4];

				MovieEntity entity = new MovieEntity();
				entity.setTconst(tconst);
				
				entity.setTitleType(titletype);
				entity.setPrimaryTitle(primarytitle);
				entity.setRuntimeMinutes(runtime);
				entity.setGenres(geners);
				mrepo.save(entity);
			}

			System.out.println("CSV data successfully imported into SQL table.");
		} catch (IOException | CsvValidationException e) {
			e.printStackTrace();
		}
	}

}
