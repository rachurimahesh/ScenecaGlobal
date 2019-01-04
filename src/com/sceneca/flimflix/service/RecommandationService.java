package com.sceneca.flimflix.service;

import java.util.List;

import com.sceneca.flimflix.model.MovieInfo;

public interface RecommandationService {

	public List<MovieInfo> getTop20MoviesForRegisteredUser(String userName);

	public List<MovieInfo> getTop20MoviesForUnregistered();

}
