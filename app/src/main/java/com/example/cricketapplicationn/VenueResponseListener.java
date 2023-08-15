package com.example.cricketapplicationn;

import com.example.cricketapplicationn.Model.getVenues;

public interface VenueResponseListener {


    void didError(String message);
    void didFetch(getVenues response,String message);

}
