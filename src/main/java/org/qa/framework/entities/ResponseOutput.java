package org.qa.framework.entities;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ResponseOutput {

	@JsonProperty("tagList")
	private List<TagListItem> tagList;

	@JsonProperty("hiddenTagList")
	private List<Object> hiddenTagList;

	@JsonProperty("data")
	private List<DataItem> data;

	@JsonProperty("numberOfPages")
	private int numberOfPages;

	@JsonProperty("hidden")
	private boolean hidden;

	@JsonProperty("hideFilter")
	private boolean hideFilter;

	@JsonProperty("originalSize")
	private int originalSize;

	@JsonProperty("currentSize")
	private int currentSize;
}