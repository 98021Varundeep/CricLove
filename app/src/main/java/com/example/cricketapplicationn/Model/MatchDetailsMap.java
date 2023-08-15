package com.example.cricketapplicationn.Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MatchDetailsMap implements Serializable {
    public String key;
    public List<Match> match;
    public int seriesId;

}
