package com.example.ninja.model;

public class User {
    private String country;
    private int lastOnlineTimeSeconds;
    private String city;
    private int rating;
    private int friendOfCount;
    private String handle;
    private int contribution;
    private String organization;
    private String rank;
    private int maxRating;
    private int registrationTimeSeconds;
    private String maxRank;
    private String titlePhoto;


    public User() {
    }
    //add toString for each attribute


    public User(String country, int lastOnlineTimeSeconds, String city, int rating, int friendOfCount, String handle, int contribution, String organization, String rank, int maxRating, int registrationTimeSeconds, String maxRank, String titlePhoto) {
        this.country = country;
        this.lastOnlineTimeSeconds = lastOnlineTimeSeconds;
        this.city = city;
        this.rating = rating;
        this.friendOfCount = friendOfCount;
        this.handle = handle;
        this.contribution = contribution;
        this.organization = organization;
        this.rank = rank;
        this.maxRating = maxRating;
        this.registrationTimeSeconds = registrationTimeSeconds;
        this.maxRank = maxRank;
        this.titlePhoto = titlePhoto;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getLastOnlineTimeSeconds() {
        return lastOnlineTimeSeconds;
    }

    public void setLastOnlineTimeSeconds(int lastOnlineTimeSeconds) {
        this.lastOnlineTimeSeconds = lastOnlineTimeSeconds;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getFriendOfCount() {
        return friendOfCount;
    }

    public void setFriendOfCount(int friendOfCount) {
        this.friendOfCount = friendOfCount;
    }

    public String getHandle() {
        return handle;
    }

    public void setHandle(String handle) {
        this.handle = handle;
    }

    public int getContribution() {
        return contribution;
    }

    public void setContribution(int contribution) {
        this.contribution = contribution;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public int getMaxRating() {
        return maxRating;
    }

    public void setMaxRating(int maxRating) {
        this.maxRating = maxRating;
    }

    public int getRegistrationTimeSeconds() {
        return registrationTimeSeconds;
    }

    public void setRegistrationTimeSeconds(int registrationTimeSeconds) {
        this.registrationTimeSeconds = registrationTimeSeconds;
    }

    public String getMaxRank() {
        return maxRank;
    }

    public void setMaxRank(String maxRank) {
        this.maxRank = maxRank;
    }

    public String getTitlePhoto() {
        return titlePhoto;
    }

    public void setTitlePhoto(String titlePhoto) {
        this.titlePhoto = titlePhoto;
    }
}
