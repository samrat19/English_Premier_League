package com.example.samrat.epl;

public class StandingList {

    String name,rank,playedgames,gf,ga,gd,points,wins,losses,drwas,poster;

    public StandingList(String name, String rank, String playedgames, String gf, String ga, String gd, String points, String wins, String losses, String drwas,String poster) {
        this.name = name;
        this.rank = rank;
        this.playedgames = playedgames;
        this.gf = gf;
        this.ga = ga;
        this.gd = gd;
        this.points = points;
        this.wins = wins;
        this.losses = losses;
        this.drwas = drwas;
        this.poster=poster;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getPlayedgames() {
        return playedgames;
    }

    public void setPlayedgames(String playedgames) {
        this.playedgames = playedgames;
    }

    public String getGf() {
        return gf;
    }

    public void setGf(String gf) {
        this.gf = gf;
    }

    public String getGa() {
        return ga;
    }

    public void setGa(String ga) {
        this.ga = ga;
    }

    public String getGd() {
        return gd;
    }

    public void setGd(String gd) {
        this.gd = gd;
    }

    public String getPoints() {
        return points;
    }

    public void setPoints(String points) {
        this.points = points;
    }

    public String getWins() {
        return wins;
    }

    public void setWins(String wins) {
        this.wins = wins;
    }

    public String getLosses() {
        return losses;
    }

    public void setLosses(String losses) {
        this.losses = losses;
    }

    public String getDrwas() {
        return drwas;
    }

    public void setDrwas(String drwas) {
        this.drwas = drwas;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }
}
