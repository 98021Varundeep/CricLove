package com.example.cricketapplicationn;

import com.example.cricketapplicationn.Model.MatchDetail;
import com.example.cricketapplicationn.Model.SereisMatches;
import com.example.cricketapplicationn.Model.SeriesMatch;

import java.util.List;

public interface SeriesResponseListener<SereisMatches> {

    void didError(String message);
    void didFetch(List<MatchDetail> response, String message);
}
