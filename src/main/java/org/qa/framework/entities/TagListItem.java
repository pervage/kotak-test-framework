package org.qa.framework.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class TagListItem{

	@JsonProperty("image")
	private String image;

	@JsonProperty("tagId")
	private String tagId;

	@JsonProperty("title")
	private String title;

	@JsonProperty("urlTagId")
	private String urlTagId;
}