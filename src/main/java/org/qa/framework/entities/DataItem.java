package org.qa.framework.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class DataItem{

	@JsonProperty("redirect")
	private String redirect;

	@JsonProperty("newTabExplore")
	private String newTabExplore;

	@JsonProperty("enableCompare")
	private boolean enableCompare;

	@JsonProperty("explore")
	private String explore;

	@JsonProperty("productId")
	private String productId;

	@JsonProperty("accountName")
	private String accountName;

	@JsonProperty("desktopAltTitle")
	private String desktopAltTitle;

	@JsonProperty("description")
	private String description;

	@JsonProperty("newTabRedirect")
	private String newTabRedirect;

	@JsonProperty("pagePath")
	private String pagePath;

	@JsonProperty("mobAltTitle")
	private String mobAltTitle;

	@JsonProperty("desktopImage")
	private String desktopImage;

	@JsonProperty("mobImage")
	private String mobImage;
}