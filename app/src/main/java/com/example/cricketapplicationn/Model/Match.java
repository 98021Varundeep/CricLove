package com.example.cricketapplicationn.Model;

import java.io.Serializable;

public class   Match implements Serializable {

    public MatchInfo matchInfo;
    public MatchScore matchScore;


    public Match(MatchInfo matchInfo, MatchScore matchScore) {
        this.matchInfo = matchInfo;
        this.matchScore = matchScore;
    }
}
