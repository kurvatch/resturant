package com.aws.mongodb.domain;

import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@Document(collection = "menuItems")
@JsonSerialize
public class MenuItem {
	
	private Long id;
	private String short_name;
	private String name;
	private String description;
	private Long price_small;
	private Long price_large;
	private String small_portion_name;
	private String large_portion_name;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getShort_name() {
		return short_name;
	}
	public void setShort_name(String short_name) {
		this.short_name = short_name;
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
	public Long getPrice_small() {
		return price_small;
	}
	public void setPrice_small(Long price_small) {
		this.price_small = price_small;
	}
	public Long getPrice_large() {
		return price_large;
	}
	public void setPrice_large(Long price_large) {
		this.price_large = price_large;
	}
	public String getSmall_portion_name() {
		return small_portion_name;
	}
	public void setSmall_portion_name(String small_portion_name) {
		this.small_portion_name = small_portion_name;
	}
	public String getLarge_portion_name() {
		return large_portion_name;
	}
	public void setLarge_portion_name(String large_portion_name) {
		this.large_portion_name = large_portion_name;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("MenuItem [id=");
		builder.append(id);
		builder.append(", short_name=");
		builder.append(short_name);
		builder.append(", name=");
		builder.append(name);
		builder.append(", description=");
		builder.append(description);
		builder.append(", price_small=");
		builder.append(price_small);
		builder.append(", price_large=");
		builder.append(price_large);
		builder.append(", small_portion_name=");
		builder.append(small_portion_name);
		builder.append(", large_portion_name=");
		builder.append(large_portion_name);
		builder.append("]");
		return builder.toString();
	}
}
