package com.example.cricketapplicationn;

import com.example.cricketapplicationn.Model.PlayerInfo;

public interface PlayerInfoListener {
 void didFectch(PlayerInfo info,String message);
 void didError(String message);


}
