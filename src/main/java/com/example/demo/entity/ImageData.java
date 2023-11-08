package com.example.demo.entity;

import java.sql.Date;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity

public class ImageData {

@Id
private String id;
private String title ;
private String description;
private LocalDateTime date;
private boolean animated;

private String type;
private int width;
private int height;
private int size;
private int views;
private int bandWidth;
private String vote;
private boolean favorite;
private String nsfw;
private String section;
private String accountUrl;
private String accountId;
private boolean is_ad;
private boolean in_most_viral;
private boolean has_sound;
public LocalDateTime getDate() {
	return date;
}
public void setDate(LocalDateTime date) {
	this.date = date;
}
public boolean isAnimated() {
	return animated;
}
public void setAnimated(boolean animated) {
	this.animated = animated;
}
public int getViews() {
	return views;
}
public void setViews(int views) {
	this.views = views;
}
public int getBandWidth() {
	return bandWidth;
}
public void setBandWidth(int bandWidth) {
	this.bandWidth = bandWidth;
}
public String getVote() {
	return vote;
}
public void setVote(String vote) {
	this.vote = vote;
}
public boolean isFavorite() {
	return favorite;
}
public void setFavorite(boolean favorite) {
	this.favorite = favorite;
}
public String getNsfw() {
	return nsfw;
}
public void setNsfw(String nsfw) {
	this.nsfw = nsfw;
}
public String getSection() {
	return section;
}
public void setSection(String section) {
	this.section = section;
}
public boolean isIs_ad() {
	return is_ad;
}
public void setIs_ad(boolean is_ad) {
	this.is_ad = is_ad;
}
public boolean isIn_most_viral() {
	return in_most_viral;
}
public void setIn_most_viral(boolean in_most_viral) {
	this.in_most_viral = in_most_viral;
}
public boolean isHas_sound() {
	return has_sound;
}
public void setHas_sound(boolean has_sound) {
	this.has_sound = has_sound;
}
public String getTags() {
	return tags;
}
public void setTags(String tags) {
	this.tags = tags;
}
public int getAd_type() {
	return ad_type;
}
public void setAd_type(int ad_type) {
	this.ad_type = ad_type;
}
public String getAd_url() {
	return ad_url;
}
public void setAd_url(String ad_url) {
	this.ad_url = ad_url;
}
public String getEdited() {
	return edited;
}
public void setEdited(String edited) {
	this.edited = edited;
}
public boolean isIn_gallery() {
	return in_gallery;
}
public void setIn_gallery(boolean in_gallery) {
	this.in_gallery = in_gallery;
}
private String tags;
private int ad_type;
private String ad_url;
private String edited;
private boolean in_gallery;
private String deleteHash;
private String name;
private String link;
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public String getType() {
	return type;
}
public void setType(String type) {
	this.type = type;
}
public int getWidth() {
	return width;
}
public void setWidth(int width) {
	this.width = width;
}
public int getHeight() {
	return height;
}
public void setHeight(int height) {
	this.height = height;
}
public int getSize() {
	return size;
}
public void setSize(int size) {
	this.size = size;
}
public String getAccountUrl() {
	return accountUrl;
}
public void setAccountUrl(String accountUrl) {
	this.accountUrl = accountUrl;
}
public String getAccountId() {
	return accountId;
}
public void setAccountId(String accountId) {
	this.accountId = accountId;
}
public String getDeleteHash() {
	return deleteHash;
}
public void setDeleteHash(String deleteHash) {
	this.deleteHash = deleteHash;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getLink() {
	return link;
}
public void setLink(String link) {
	this.link = link;
}



}
