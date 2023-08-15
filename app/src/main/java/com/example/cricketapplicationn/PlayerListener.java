package com.example.cricketapplicationn;

import com.example.cricketapplicationn.Model.Player;

import java.util.List;

public interface PlayerListener {
    void didFetch(List<Player> list,String message);
    void didError(String message);
}
