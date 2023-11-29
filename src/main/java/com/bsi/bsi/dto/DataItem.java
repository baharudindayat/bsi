package com.bsi.bsi.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DataItem{

	@JsonProperty("idTipe")
	private int idTipe;

	@JsonProperty("namaTipe")
	private String namaTipe;

	@JsonProperty("limitTransfer")
	private String limitTransfer;
}