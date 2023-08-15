package com.example.cricketapplicationn;

import com.example.cricketapplicationn.Model.Value;

import java.util.List;

public interface PlayerCareerListener {
    void didFetch(List<Value> values,String message);
    void didError(String message);
}
