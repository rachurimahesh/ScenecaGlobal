package com.sceneca.flimflix.repo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.sceneca.flimflix.model.MovieInfo;

@Repository
public class MovieRepo {

	public List<MovieInfo> getListOfMovies() {

		MovieInfo info = new MovieInfo();
		info.setCountry("India");
		info.setGenre("Love");
		info.setYear(LocalDate.of(2018, 12, 1).toString());
		info.setName("DilSe");

		MovieInfo info1 = new MovieInfo();
		info1.setCountry("India");
		info1.setGenre("Action");
		info1.setYear(LocalDate.of(2018, 11, 1).toString());
		info1.setName("Dabbung");
		info1.setLikeCount(10);

		MovieInfo info2 = new MovieInfo();
		info2.setCountry("India");
		info2.setGenre("Action");
		info2.setYear(LocalDate.of(2018, 10, 1).toString());
		info2.setName("Dabbung2");
		info2.setLikeCount(9);

		MovieInfo info3 = new MovieInfo();
		info3.setCountry("India");
		info3.setGenre("Action");
		info3.setYear(LocalDate.of(2018, 10, 1).toString());
		info3.setName("Run");
		info3.setLikeCount(10);

		MovieInfo info4 = new MovieInfo();
		info4.setCountry("India");
		info4.setGenre("Historical");
		info4.setYear(LocalDate.of(1988, 10, 1).toString());
		info4.setName("India Independence before 1947");
		info4.setLikeCount(1);

		MovieInfo info5 = new MovieInfo();
		info5.setCountry("India");
		info5.setGenre("Historical");
		info5.setYear(LocalDate.of(2000, 7, 1).toString());
		info5.setName("Bagath Singh");
		info5.setLikeCount(2);

		MovieInfo info6 = new MovieInfo();
		info6.setCountry("India");
		info6.setGenre("Love");
		info6.setYear(LocalDate.of(1978, 6, 1).toString());
		info6.setName("Roja");
		info6.setLikeCount(4);

		MovieInfo info7 = new MovieInfo();
		info7.setCountry("UK");
		info7.setGenre("Drama");
		info7.setYear(LocalDate.of(1966, 6, 1).toString());
		info7.setName("Four Weddings and a Funeral");
		info7.setLikeCount(8);

		MovieInfo info8 = new MovieInfo();
		info8.setCountry("UK");
		info8.setGenre("Thriller");
		info8.setYear(LocalDate.of(1966, 5, 1).toString());
		info8.setName("Annihilation");
		info8.setLikeCount(9);

		MovieInfo info9 = new MovieInfo();
		info9.setCountry("UK");
		info9.setGenre("Drama");
		info9.setYear(LocalDate.of(1900, 5, 1).toString());
		info9.setName("Shaun of the Dead");
		info9.setLikeCount(9);

		MovieInfo info10 = new MovieInfo();
		info10.setCountry("India");
		info10.setGenre("Love");
		info10.setYear(LocalDate.of(2018, 12, 1).toString());
		info10.setName("DilSe2");
		info10.setLikeCount(7);

		MovieInfo info11 = new MovieInfo();
		info11.setCountry("India");
		info11.setGenre("Action");
		info11.setYear(LocalDate.of(2018, 11, 1).toString());
		info11.setName("Dabbung3");
		info11.setLikeCount(2);
		
		MovieInfo info12 = new MovieInfo();
		info12.setCountry("India");
		info12.setGenre("Action");
		info12.setYear(LocalDate.of(2018, 10, 1).toString());
		info12.setName("Dabbung4");
		info12.setLikeCount(3);

		MovieInfo info13 = new MovieInfo();
		info13.setCountry("India");
		info13.setGenre("Action");
		info13.setYear(LocalDate.of(2018, 10, 1).toString());
		info13.setName("Run2");
		info13.setLikeCount(4);

		MovieInfo info14 = new MovieInfo();
		info14.setCountry("India");
		info14.setGenre("Historical");
		info14.setYear(LocalDate.of(1988, 10, 1).toString());
		info14.setName("India Independence after 1947");
		info14.setLikeCount(5);

		MovieInfo info15 = new MovieInfo();
		info15.setCountry("India");
		info15.setGenre("Historical");
		info15.setYear(LocalDate.of(2001, 7, 1).toString());
		info15.setName("Bagath Singh 2");
		info15.setLikeCount(5);

		MovieInfo info16 = new MovieInfo();
		info16.setCountry("India");
		info16.setGenre("Love");
		info16.setYear(LocalDate.of(1979, 6, 1).toString());
		info16.setName("Lotus");
		info16.setLikeCount(1);

		MovieInfo info17 = new MovieInfo();
		info17.setCountry("UK");
		info17.setGenre("Drama");
		info17.setYear(LocalDate.of(1966, 6, 1).toString());
		info17.setName("Four Weddings and a Funeral part 2");
		info17.setLikeCount(3);

		MovieInfo info18 = new MovieInfo();
		info18.setCountry("UK");
		info18.setGenre("Thriller");
		info18.setYear(LocalDate.of(1967, 5, 1).toString());
		info18.setName("Annihilation  2");
		info18.setLikeCount(9);

		MovieInfo info19 = new MovieInfo();
		info19.setCountry("UK");
		info19.setGenre("Drama");
		info19.setYear(LocalDate.of(1901, 5, 1).toString());
		info19.setName("Shaun of the Dead 2");
		info19.setLikeCount(10);

		List<MovieInfo> lisOfMovies = new ArrayList<MovieInfo>();

		lisOfMovies.add(info);
		lisOfMovies.add(info1);
		lisOfMovies.add(info2);
		lisOfMovies.add(info3);
		lisOfMovies.add(info4);
		lisOfMovies.add(info5);
		lisOfMovies.add(info6);
		lisOfMovies.add(info7);
		lisOfMovies.add(info8);
		lisOfMovies.add(info9);
		lisOfMovies.add(info10);
		lisOfMovies.add(info11);
		lisOfMovies.add(info12);
		lisOfMovies.add(info13);
		lisOfMovies.add(info14);
		lisOfMovies.add(info15);
		lisOfMovies.add(info16);
		lisOfMovies.add(info17);
		lisOfMovies.add(info18);
		lisOfMovies.add(info19);

		return lisOfMovies;

	}

}
