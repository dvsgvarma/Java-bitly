package com.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Link {

    @JsonProperty("short_url")
    @ApiModelProperty(notes = "shorten version of the url")
    @Id
    private String shortUrl;

    @JsonProperty("full_url")
    @ApiModelProperty(notes = "Full version of the url")
    private String fullUrl;

    @JsonIgnore
    private int clickCount;

    protected Link() {
        // for hibernate
    }

    public Link(String shortUrl, String fullUrl) {
        this.shortUrl = shortUrl;
        this.fullUrl = fullUrl;
    }

    public Link(String shortUrl, String fullUrl, int clickCount) {
        this.shortUrl = shortUrl;
        this.fullUrl = fullUrl;
        this.clickCount = clickCount;
    }

    public String getShortUrl() {
        return shortUrl;
    }

    public String getFullUrl() {
        return fullUrl;
    }

    public int getClickCount() {
        return clickCount;
    }
}
