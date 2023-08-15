package com.example.cricketapplicationn.Model;

import java.io.Serializable;

public class MatchInfo implements Serializable {

    public int matchId;
    public int seriesId;
    public String seriesName;
    public String matchDesc;
    public String matchFormat;
    public long startDate;
    public String endDate;
    public String state;
    public String status;
    public Team1 team1;
    public Team2 team2;
    public VenueInfo venueInfo;

    public int currBatTeamId;
    public String seriesStartDt;
    public String seriesEndDt;
    public boolean isTimeAnnounced;
    public String stateTitle;
    public boolean livestreamEnabled;
}
