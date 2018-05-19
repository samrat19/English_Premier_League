package com.example.samrat.epl;

public class ChampionList {

    String club,year;
    int cimage;

    public ChampionList(String club, String year, int cimage) {
        this.club = club;
        this.year = year;
        this.cimage = cimage;
    }

    public String getClub() {
        return club;
    }

    public void setClub(String club) {
        this.club = club;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public int getCimage() {
        return cimage;
    }

    public void setCimage(int cimage) {
        this.cimage = cimage;
    }
}
