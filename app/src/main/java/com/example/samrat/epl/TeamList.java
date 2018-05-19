package com.example.samrat.epl;

public class TeamList {

    String maday,homeTeam,awayTeam,hg,ag;

    public TeamList(String maday, String homeTeam, String awayTeam, String hg, String ag) {
        this.maday = maday;
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.hg = hg;
        this.ag = ag;
    }

    public String getMaday() {
        return maday;
    }

    public void setMaday(String maday) {
        this.maday = maday;
    }

    public String getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(String homeTeam) {
        this.homeTeam = homeTeam;
    }

    public String getAwayTeam() {
        return awayTeam;
    }

    public void setAwayTeam(String awayTeam) {
        this.awayTeam = awayTeam;
    }

    public String getHg() {
        return hg;
    }

    public void setHg(String hg) {
        this.hg = hg;
    }

    public String getAg() {
        return ag;
    }

    public void setAg(String ag) {
        this.ag = ag;
    }
}
