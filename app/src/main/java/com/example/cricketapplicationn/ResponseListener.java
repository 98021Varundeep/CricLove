package com.example.cricketapplicationn;

import com.example.cricketapplicationn.Model.FixtureResponse;
import com.example.cricketapplicationn.Model.MatchDetail;
import com.example.cricketapplicationn.Model.TypeMatch;

import java.util.List;

public interface ResponseListener<FixtureResponse> {
    void didError(String Message);

    void didFetch(List<TypeMatch> response, String message);

}
