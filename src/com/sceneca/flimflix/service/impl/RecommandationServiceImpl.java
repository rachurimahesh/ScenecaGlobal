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
public class RecommandationServiceImpl implements RecommandationService {

	@Autowired
	UserPersonalizationDetailsRepo userRepo;

	@Autowired
	MovieRepo movieRepo;

	@Autowired
	ScenecaUtil util;

	private static final int LIMIT = 20;

	public List<MovieInfo> getMoviesForRegisteredUser(String userName) {

		List<MovieInfo> topMovies = null;

		UserPersonalizationhistory userPersonalizationHistory = userRepo.getUserPeronalizationDetails(userName);

		List<MovieInfo> listMovieInfo = movieRepo.getListOfMovies();

		// * Making the Genres LIFO
		Collections.reverse(userPersonalizationHistory.getGenres());

		// * Making the Countries LIFO
		Collections.reverse(userPersonalizationHistory.getCountries());

		// non - watched movies with preferred Genres
		List<MovieInfo> moviesBasedOnGenreNonWatched = util.getMoviesBasedOnGenreNonWatched(listMovieInfo,
				userPersonalizationHistory);

		topMovies = moviesBasedOnGenreNonWatched.stream().limit(LIMIT).collect(Collectors.toList());
		if (topMovies.size() == LIMIT) {
			return topMovies;
		} else {
			List<MovieInfo> moviesBasedOnGenreOverCountry = util.getMoviesBasedOnGenreOverCountry(listMovieInfo,
					userPersonalizationHistory);
			topMovies = moviesBasedOnGenreOverCountry.stream().limit(LIMIT).collect(Collectors.toList());
			if (topMovies.size() == LIMIT) {
				return topMovies;
			} else {// if the list is less than add watched movies at the end.
				// watched movies
				List<MovieInfo> watchedMovies = util.getTopWatchedMoviesWithPreference(listMovieInfo,
						userPersonalizationHistory);

				topMovies.addAll(watchedMovies);
				
				topMovies = topMovies.stream().limit(LIMIT).collect(Collectors.toList());
				if (topMovies.size() == LIMIT) {
					return topMovies;
				} else {// After adding preference & watched list if the list is
						// less than 20 then get top 20 movies based on
						// Mostly liked Count
					topMovies = util.getTopRatedMovies(listMovieInfo, LIMIT);
					Collections.reverse(topMovies); // Most liked movies first
				}
			}

		}
		return topMovies;

	}

	/**
	 * Retrieved top rated movie for unregistered users
	 * 
	 * @return List
	 */
	public List<MovieInfo> getMoviesForUnregistered() {
		List<MovieInfo> listMovieInfo = movieRepo.getListOfMovies();
		return util.getTopRatedMovies(listMovieInfo, LIMIT);

	}

}
