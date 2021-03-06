package com.sceneca.flimflix.controller;

import java.util.List;

import javax.ws.rs.QueryParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sceneca.flimflix.model.MovieInfo;
import com.sceneca.flimflix.service.RecommandationService;

/**
 * Dispatch the request based on registered or unregistered user
 * 
 * @author Mahesh Rachuri
 *
 */
@RestController
public class MoviesPreferenceController {

	@Autowired
	RecommandationService service;

	@RequestMapping(value = "/preferredMovies", method = { RequestMethod.GET })
	public List<MovieInfo> getPreferedMovies(@QueryParam(value = "userName") String userName) {
		if (!StringUtils.isEmpty(userName)) {
			return service.getMoviesForRegisteredUser(userName);
		} else {
			return service.getMoviesForUnregistered();
		}

	}

}
