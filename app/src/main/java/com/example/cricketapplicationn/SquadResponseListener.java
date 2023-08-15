package com.example.cricketapplicationn;

import com.example.cricketapplicationn.Model.GetSquads;

public interface SquadResponseListener {
    void didError(String message);
    void didFetch(GetSquads response,String message);
}
