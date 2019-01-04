package com.sceneca.flimflix.repo;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.springframework.stereotype.Repository;

import com.sceneca.flimflix.model.UserPersonalizationhistory;

@Repository
public class UserPersonalizationDetailsRepo {

	public UserPersonalizationhistory getUserPeronalizationDetails(String userName) {

		List<UserPersonalizationhistory> histories = getAllUserPeronalizationDetails();

		return histories.stream().filter(x -> x.getUserName().equalsIgnoreCase(userName)).findFirst()
				.orElse(getDefaultUserPersonalization());

	}

	public List<UserPersonalizationhistory> getAllUserPeronalizationDetails() {
		List<String> countries = null;
		List<String> genres = null;
		List<String> historyOfMovieswatched=null;
		UserPersonalizationhistory userPerHistoy1 = new UserPersonalizationhistory();
		countries = new ArrayList<String>();
		countries.add("India");
		countries.add("UK");
		userPerHistoy1.setCountries(countries);
		userPerHistoy1.setUserName("user1");
		historyOfMovieswatched= new ArrayList<String>();
		historyOfMovieswatched.add("DilSe");
		userPerHistoy1.setHistoryOfMovieswatched(historyOfMovieswatched);
		genres = new ArrayList<String>();
		genres.add("Love");
		genres.add("Action");
		userPerHistoy1.setGenres(genres);

		UserPersonalizationhistory userPerHistoy2 = new UserPersonalizationhistory();
		countries = new ArrayList<String>();
		countries.add("India");
		userPerHistoy2.setCountries(countries);
		userPerHistoy2.setUserName("User2");
		historyOfMovieswatched= new ArrayList<String>();
		historyOfMovieswatched.add("DilSe");
		historyOfMovieswatched.add("Shaun of the Dead 2");
		userPerHistoy2.setHistoryOfMovieswatched(historyOfMovieswatched);
		genres = new ArrayList<String>();
		genres.add("Action");
		userPerHistoy1.setGenres(genres);

		List<UserPersonalizationhistory> histories = new ArrayList<UserPersonalizationhistory>();
		histories.add(userPerHistoy1);
		histories.add(userPerHistoy2);

		return histories;
	}

	public UserPersonalizationhistory getDefaultUserPersonalization() {
		List<String> countries = null;
		List<String> genres = null;
		UserPersonalizationhistory defaultPersonalization = new UserPersonalizationhistory();
		countries = new ArrayList<String>();
		countries.add(Locale.getDefault().getCountry());
		defaultPersonalization.setCountries(countries);		
		genres = new ArrayList<String>();
		genres.add("Action");
		defaultPersonalization.setGenres(genres);

		return defaultPersonalization;

	}

}
