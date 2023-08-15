package com.example.cricketapplicationn.Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class FixtureResponse implements Serializable {
    public List<TypeMatch> typeMatches;
    public Filters filters;
    public AppIndex appIndex;
    public String responseLastUpdated;

}
