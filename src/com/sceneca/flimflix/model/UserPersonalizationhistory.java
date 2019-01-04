package com.sceneca.flimflix.model;

import java.util.List;

public class UserPersonalizationhistory {

	private String userName;
	private List<String> countries;
	private List<String> genres;
	private List<String> HistoryOfMovieswatched;

	

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public List<String> getCountries() {
		return countries;
	}

	public void setCountries(List<String> countries) {
		this.countries = countries;
	}

	public List<String> getGenres() {
		return genres;
	}

	public void setGenres(List<String> genres) {
		this.genres = genres;
	}

	public List<String> getHistoryOfMovieswatched() {
		return HistoryOfMovieswatched;
	}

	public void setHistoryOfMovieswatched(List<String> historyOfMovieswatched) {
		HistoryOfMovieswatched = historyOfMovieswatched;
	}

}
