package com.example.cricketapplicationn.Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PointsTableInfo implements Serializable {

    public int teamId;
    public String teamName;
    public int matchesPlayed;
    public int matchesWon;
    public int points;
    public String nrr;
    public String teamFullName;
    public List<TeamMatch> teamMatches;
    public List<String> form;
    public int teamImageId;
    public int matchesLost;

}
