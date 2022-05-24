package com.fis.theatre.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fis.theatre.model.Genre;
import com.fis.theatre.model.GenreShow;
import com.fis.theatre.model.ShowTheatre;
import com.fis.theatre.repository.ShowTheatreRepository;
import com.fis.theatre.web.dto.ShowDTO;

@Service
public class ShowTheatreService {

	@Autowired
	ShowTheatreRepository showRepo;

	public ShowDTO save(ShowDTO showDTO) {
		ShowTheatre show = new ShowTheatre();
		
		show.setDescription(showDTO.getDescription());
		show.setLength(showDTO.getLength());
		show.setName(showDTO.getName());

		showRepo.save(show);
		
		return showDTO;
	}
	
	
	public List<ShowDTO> getAll() {
		List<ShowTheatre> shows = showRepo.findAll();
		List<ShowDTO> returnValue = new ArrayList<ShowDTO>();

		for (ShowTheatre show : shows) {
			ShowDTO temp = new ShowDTO();

			temp.setName(show.getName());
			temp.setLength(show.getLength());
			temp.setDescription(show.getDescription());
			temp.setId(show.getIdShow());
			List<String> genersString = new ArrayList<String>();
			for (GenreShow gs : show.getGenreShows()) {
				String genre = gs.getGenre().getName();
				genersString.add(genre);
			}
			temp.setGenres(genersString);

			returnValue.add(temp);
		}

		return returnValue;
	}

	public List<ShowDTO> getAllShowsForAnActor(String firsname, String lastname) {
		List<ShowTheatre> shows = showRepo
				.findDistinctByPerformances_ActsInPerformances_Acts_Actor_FirstNameOrPerformances_ActsInPerformances_Acts_Actor_LastName(
						firsname, lastname);
		List<ShowDTO> returnList = new ArrayList<ShowDTO>();
		System.out.println(shows.size());
		for (ShowTheatre st : shows) {
			ShowDTO temp = new ShowDTO();
			temp.setDescription(st.getDescription());
			temp.setLength(st.getLength());
			temp.setName(st.getName());

			List<String> genersString = new ArrayList<String>();
			for (GenreShow gs : st.getGenreShows()) {
				String genre = gs.getGenre().getName();
				genersString.add(genre);
			}

			temp.setGenres(genersString);

			returnList.add(temp);
		}

		return returnList;
	}
	
	
	public List<ShowDTO> getAllShowsForGenre(int genreId){
		List<ShowDTO> returnList = new ArrayList<ShowDTO>();
		List<ShowTheatre> shows = showRepo.findByGenreShows_Genre_IdGenre(genreId);
		
		for (ShowTheatre st : shows) {
			ShowDTO temp = new ShowDTO();
			temp.setDescription(st.getDescription());
			temp.setLength(st.getLength());
			temp.setName(st.getName());

			List<String> genersString = new ArrayList<String>();
			for (GenreShow gs : st.getGenreShows()) {
				String genre = gs.getGenre().getName();
				genersString.add(genre);
			}

			temp.setGenres(genersString);

			returnList.add(temp);
		}
		
		
		return returnList;
	}
	
	
	
	
	public List<ShowDTO> getAllShowsForDirector(int directorId){
		List<ShowDTO> returnList = new ArrayList<ShowDTO>();
		List<ShowTheatre> shows = showRepo.findByDirector_IdDirector(directorId);
		
		for (ShowTheatre st : shows) {
			ShowDTO temp = new ShowDTO();
			temp.setDescription(st.getDescription());
			temp.setLength(st.getLength());
			temp.setName(st.getName());

			List<String> genersString = new ArrayList<String>();
			for (GenreShow gs : st.getGenreShows()) {
				String genre = gs.getGenre().getName();
				genersString.add(genre);
			}

			temp.setGenres(genersString);

			returnList.add(temp);
		}
		
		
		return returnList;
	}
	
	
}
