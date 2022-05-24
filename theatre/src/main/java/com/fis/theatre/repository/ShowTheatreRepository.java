package com.fis.theatre.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.fis.theatre.model.ShowTheatre;

public interface ShowTheatreRepository extends JpaRepository<ShowTheatre, Integer> {
//same methods
	List<ShowTheatre> findDistinctByPerformances_ActsInPerformances_Acts_Actor_FirstNameAndPerformances_ActsInPerformances_Acts_Actor_LastName(
			String firstname, String lastname);
	List<ShowTheatre> findDistinctByPerformances_ActsInPerformances_Acts_Actor_FirstNameOrPerformances_ActsInPerformances_Acts_Actor_LastName(
			String firstname, String lastname);
	@Query("SELECT st FROM ShowTheatre st where st in "
			+ "(select acts.role.showt from Acts acts where acts.actor.firstName like :fn "
			+ "and acts.actor.lastName like :ln)")
	List<ShowTheatre> getAllShowsForAnActor(@Param("fn") String firstname, @Param("ln") String lastname);

	// HQL select a from Actor a
	
	List<ShowTheatre> findByGenreShows_Genre_IdGenre(int idGenre);
	List<ShowTheatre> findByDirector_IdDirector(int idDirector);
}
