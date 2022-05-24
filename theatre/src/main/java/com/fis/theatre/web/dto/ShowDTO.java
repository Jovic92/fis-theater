package com.fis.theatre.web.dto;

import java.util.List;

public class ShowDTO {

	private Integer id;
	private String name;
	private String description;
	private int length;
	private List<String> genres;

	public ShowDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ShowDTO(String name, String description, int length, List<String> genres) {
		super();
		this.name = name;
		this.description = description;
		this.length = length;
		this.genres = genres;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public List<String> getGenres() {
		return genres;
	}

	public void setGenres(List<String> genres) {
		this.genres = genres;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}
