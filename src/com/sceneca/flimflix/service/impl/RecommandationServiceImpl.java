package com.sceneca.flimflix.service.impl;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sceneca.flimflix.model.MovieInfo;
import com.sceneca.flimflix.model.UserPersonalizationhistory;
import com.sceneca.flimflix.repo.MovieRepo;
import com.sceneca.flimflix.repo.UserPersonalizationDetailsRepo;
import com.sceneca.flimflix.service.RecommandationService;
import com.sceneca.flimflix.util.ScenecaUtil;


@Service
public class RecommandationServiceImpl implements RecommandationService{

	@Autowired
	UserPersonalizationDetailsRepo userRepo;

	@Autowired
	MovieRepo movieRepo;

	@Autowired
	ScenecaUtil util;
	
	private static final int LIMIT = 20;

	public List<MovieInfo> getTop20MoviesForRegisteredUser(String userName) {
		List<MovieInfo> top20Movies = null;
		UserPersonalizationhistory userPersonalizationHistory = userRepo.getUserPeronalizationDetails(userName);
		List<MovieInfo> listMovieInfo = movieRepo.getListOfMovies();

		// * Making the Genres LIFO
		Collections.reverse(userPersonalizationHistory.getGenres());

		// * Making the Countries LIFO
		Collections.reverse(userPersonalizationHistory.getCountries());

		// non - watched movies with preferred Genres
		List<MovieInfo> moviesBasedOnGenreNonWatched = util.getMoviesBasedOnGenreNonWatched(listMovieInfo,
				userPersonalizationHistory);

		// watched movies
		List<MovieInfo> watchedMovies = util.getTopWatchedMoviesWithPreference(listMovieInfo,
				userPersonalizationHistory);
		top20Movies = moviesBasedOnGenreNonWatched.stream().limit(20).collect(Collectors.toList());
		if (top20Movies.size() == 20) {
			return top20Movies;
		} else {
			List<MovieInfo> moviesBasedOnGenreOverCountry = util.getMoviesBasedOnGenreOverCountry(listMovieInfo,
					userPersonalizationHistory);
			top20Movies = moviesBasedOnGenreOverCountry.stream().limit(LIMIT).collect(Collectors.toList());
			if (top20Movies.size() == LIMIT) {
				return top20Movies;
			} else {// After adding preference movies if the list is less than
					// 20
					// add user watched movies at the end.
				top20Movies.addAll(watchedMovies);
				top20Movies = top20Movies.stream().limit(LIMIT).collect(Collectors.toList());
				if (top20Movies.size() == LIMIT) {
					return top20Movies;
				} else {// After adding preference & watched list if the list is
						// less than 20 then get top 20 movies based on
						// Mostly liked Count
					top20Movies = util.getTopRatedMovies(listMovieInfo, LIMIT);
					Collections.reverse(top20Movies); // Most liked movies first
				}
			}

		}
		return top20Movies;

	}

	public List<MovieInfo> getTop20MoviesForUnregistered() {
		List<MovieInfo> listMovieInfo = movieRepo.getListOfMovies();
		return util.getTopRatedMovies(listMovieInfo, LIMIT);

	}

}
