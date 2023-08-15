package com.example.cricketapplicationn.Model;

import java.io.Serializable;

public class Matchbasicinfo implements Serializable {
    private String team1Name;
    private String team2Name;
    private String team2Score;
    private String team1Score;
    private String matchBrief;
    private String matchStatus;
    private String seriesName;
    private int imageTeam1;
    private int imageTeam2;
    private String dateandTime;
    private String status ;

    public Matchbasicinfo(String team1Name, String team2Name, String team2Score, String team1Score, String matchBrief, String matchStatus, String seriesName, int imageTeam1, int imageTeam2, String dateandTime, String status) {
        this.team1Name = team1Name;
        this.team2Name = team2Name;
        this.team1Score = team2Score;
        this.team2Score = team1Score;
        this.matchBrief = matchBrief;
        this.matchStatus = matchStatus;
        this.seriesName = seriesName;
        this.imageTeam1 = imageTeam1;
        this.imageTeam2 = imageTeam2;
        this.dateandTime = dateandTime;
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDateandTime() {
        return dateandTime;
    }

    public void setDateandTime(String dateandTime) {
        this.dateandTime = dateandTime;
    }


    public Matchbasicinfo(String team1Name, String team2Name, String  team2Score, String team1Score, String matchStatus, String seriesName, int imageTeam1, int imageTeam2) {
        this.team1Name = team1Name;
        this.team2Name = team2Name;
        this.team2Score = team2Score;
        this.team1Score = team1Score;
        this.matchStatus = matchStatus;
        this.seriesName = seriesName;
        this.imageTeam1 = imageTeam1;
        this.imageTeam2 = imageTeam2;
    }

    public String getMatchBrief() {
        return matchBrief;
    }

    public void setMatchBrief(String matchBrief) {
        this.matchBrief = matchBrief;
    }

    public Matchbasicinfo() {
    }

    public String getTeam1Name() {
        return team1Name;
    }

    public void setTeam1Name(String team1Name) {
        this.team1Name = team1Name;
    }

    public String getTeam2Name() {
        return team2Name;
    }

    public void setTeam2Name(String team2Name) {
        this.team2Name = team2Name;
    }

    public String  getTeam2Score() {
        return team2Score;
    }

    public void setTeam2Score(String team2Score) {
        this.team2Score = team2Score;
    }

    public String getTeam1Score() {
        return team1Score;
    }

    public void setTeam1Score(String team1Score) {
        this.team1Score = team1Score;
    }

    public String getMatchStatus() {
        return matchStatus;
    }

    public void setMatchStatus(String matchStatus) {
        this.matchStatus = matchStatus;
    }

    public String getSeriesName() {
        return seriesName;
    }

    public void setSeriesName(String seriesName) {
        this.seriesName = seriesName;
    }

    public int getImageTeam1() {
        return imageTeam1;
    }

    public void setImageTeam1(int imageTeam1) {
        this.imageTeam1 = imageTeam1;
    }

    public int getImageTeam2() {
        return imageTeam2;
    }

    public void setImageTeam2(int imageTeam2) {
        this.imageTeam2 = imageTeam2;
    }
}
