package com.spring.movie.component;

import java.io.FileReader;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import com.spring.movie.dao.RatingRepository;
import com.spring.movie.model.RatingEntity;
@Component
public class RatingComponent implements ApplicationListener<ApplicationReadyEvent> {
 private final RatingRepository rRepo;
	@Autowired
	public RatingComponent(RatingRepository rRepo) {
	super();
	this.rRepo = rRepo;
}

	@Override
	public void onApplicationEvent(ApplicationReadyEvent event) {
		String csv = "C:\\Users\\ganta\\projects\\ratings.csv";
		try {
			  CSVReader reader=new CSVReader(new FileReader(csv));
			  String [] nextline;
			  while((nextline = reader.readNext())!= null) {
				  String s1= nextline[0];
				  double s2=Double.parseDouble(nextline[1]);
				  int s3=Integer.parseInt(nextline[2]);
				  RatingEntity rating=new RatingEntity();
				  rating.setTconst(s1);
				  rating.setAveragerateing(s2);
				  rating.setNumofvotes(s3);
				  rRepo.save(rating);
				
				  
			  }
		  }catch(IOException | CsvValidationException e) {
			  e.printStackTrace();	  
			  }
		
		System.out.println("rating data sucsefully uploaded");
	  }
		
		
	}


