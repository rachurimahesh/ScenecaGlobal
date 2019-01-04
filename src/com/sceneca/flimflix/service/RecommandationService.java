package com.sceneca.flimflix.service;

import java.util.List;

import com.sceneca.flimflix.model.MovieInfo;

/**
 * Service to provide the recommended movies for registered and unregistered
 * users
 * 
 * @author Mahesh Rachuri
 *
 */
public interface RecommandationService {

	public List<MovieInfo> getMoviesForRegisteredUser(String userName);

	public List<MovieInfo> getMoviesForUnregistered();

}
