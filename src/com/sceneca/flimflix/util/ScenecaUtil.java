package com.sceneca.flimflix.util;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.stereotype.Component;

import com.sceneca.flimflix.model.MovieInfo;
import com.sceneca.flimflix.model.UserPersonalizationhistory;

/**
 * Utility component
 * @author Mahesh Rachuri
 *
 */
@Component
public class ScenecaUtil {

	/**
	 * Comparator based on like count
	 * 
	 * @return
	 */
	public Comparator<MovieInfo> getComparatorByCount() {
		return Comparator.comparingInt(MovieInfo::getLikeCount);
	}

	/**
	 * Retrieve based on Genre and country excluding overlapped movie taking
	 * genre as preference
	 * 
	 * @param listMovieInfo
	 *            List
	 * @param userPersonalizationHistory
	 *            UserPersonalizationhistory
	 * @return List
	 */
	public List<MovieInfo> getMoviesBasedOnGenreOverCountry(List<MovieInfo> listMovieInfo,
			UserPersonalizationhistory userPersonalizationHistory) {
		System.out.println("Entering getMoviesBasedOnGenreOverCountry:::");

		List<MovieInfo> movies = new ArrayList<>();

		List<MovieInfo> basedOnGenre = getMoviesBasedOnGenreNonWatched(listMovieInfo, userPersonalizationHistory);
		List<MovieInfo> basedOnCountry = getMoviesBasedOnCountryNonWatched(listMovieInfo, userPersonalizationHistory);

		basedOnGenre.forEach(x -> {
			if (basedOnCountry.contains(x)) {
				basedOnCountry.remove(x);
			}
		});

		System.out.println("Total Genre \n" + basedOnGenre.size());
		System.out.println("Total Country \n" + basedOnCountry.size());

		movies.addAll(basedOnGenre);
		movies.addAll(basedOnCountry);

		System.out.println("Exiting getMoviesBasedOnGenreOverCountry:::");
		return movies;

	}

	/**
	 * Retrieve movies based on Genre excluding watched ones
	 * 
	 * @param listMovieInfo
	 *            List
	 * @param userPersonalizationHistory
	 *            UserPersonalizationhistory
	 * @return List
	 */
	public List<MovieInfo> getMoviesBasedOnGenreNonWatched(List<MovieInfo> listMovieInfo,
			UserPersonalizationhistory userPersonalizationHistory) {

		System.out.println("Entering getMoviesBasedOnGenreNonWatched:::");

		List<MovieInfo> moviesBasedOnGenreNonWatched = new ArrayList<>();

		List<String> moviesWatched = userPersonalizationHistory.getHistoryOfMovieswatched();
		Stream<MovieInfo> streamOfMoviesBasedOnGenre = listMovieInfo.stream()
				.filter(x -> userPersonalizationHistory.getGenres().contains(x.getGenre()));

		Stream<MovieInfo> streamOfMoviesBasedOnGenreNonWatched = streamOfMoviesBasedOnGenre
				.filter(x -> !moviesWatched.contains(x.getName()));

		streamOfMoviesBasedOnGenreNonWatched.forEach(x -> {
			System.out.println(x.getGenre() + "  " + x.getName());
			moviesBasedOnGenreNonWatched.add(x);

		});
		System.out.println("Exiting getMoviesBasedOnGenreNonWatched:::");

		return moviesBasedOnGenreNonWatched;

	}

	/**
	 * Retrieve movies based on country excluding watched ones
	 * 
	 * @param list
	 *            listMovieInfo
	 * @param userPersonalizationHistory
	 *            UserPersonalizationhistory
	 * @return List
	 */
	public List<MovieInfo> getMoviesBasedOnCountryNonWatched(List<MovieInfo> listMovieInfo,
			UserPersonalizationhistory userPersonalizationHistory) {

		System.out.println("Entering getMoviesBasedOnCountryNonWatched:::");

		List<MovieInfo> moviesBasedOnCountryNonWatched = new ArrayList<>();
		listMovieInfo.stream().filter(x -> userPersonalizationHistory.getCountries().contains(x.getCountry()))
				.filter(x -> !userPersonalizationHistory.getHistoryOfMovieswatched().contains(x.getName()))
				.forEach(x -> {
					System.out.println(x.getGenre() + "-" + x.getName());
					moviesBasedOnCountryNonWatched.add(x);
				});
		System.out.println("Exiting getMoviesBasedOnCountryNonWatched:::");
		return moviesBasedOnCountryNonWatched;
	}

	/**
	 * Retrieve watched all watched movies
	 * 
	 * @param listMovieInfo
	 *            List
	 * @param userPersonalizationHistory
	 *            UserPersonalizationhistory
	 * @return List
	 */
	public List<MovieInfo> getTopWatchedMoviesWithPreference(List<MovieInfo> listMovieInfo,
			UserPersonalizationhistory userPersonalizationHistory) {
		System.out.println("Entering getTopWatchedMoviesWithPreference:::");
		List<MovieInfo> watchedMovies = new ArrayList<>();
		listMovieInfo.stream().filter(x -> userPersonalizationHistory.getHistoryOfMovieswatched().contains(x.getName()))
				.forEach(x -> {
					System.out.println(x.getGenre() + "-" + x.getName());
					watchedMovies.add(x);
				});
		System.out.println("Exiting getTopWatchedMoviesWithPreference:::");
		return watchedMovies;

	}

	/**
	 * Top rated movies based on Limit
	 * 
	 * @param listMovieInfo
	 *            List
	 * @param limit
	 *            int
	 * @return List
	 */
	public List<MovieInfo> getTopRatedMovies(List<MovieInfo> listMovieInfo, int limit) {
		System.out.println("Entering getTopRatedMovies:::");
		List<MovieInfo> topRatedMovies = new ArrayList<>();
		listMovieInfo.stream().sorted(getComparatorByCount()).limit(limit).forEach(x -> {
			System.out.println(x.getGenre() + "-" + x.getName());
			topRatedMovies.add(x);
		});
		System.out.println("Exiting getTopWatchedMoviesWithOutPreference:::");
		return topRatedMovies;

	}
}
