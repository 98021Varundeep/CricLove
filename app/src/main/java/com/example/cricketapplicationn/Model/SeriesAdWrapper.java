package com.example.cricketapplicationn.Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class SeriesAdWrapper implements Serializable {

    public int seriesId;
    public String seriesName;
    public List<Match> matches;

}
