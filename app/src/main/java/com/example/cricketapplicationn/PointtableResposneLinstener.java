package com.example.cricketapplicationn;

import com.example.cricketapplicationn.Model.PointsTable;
import com.example.cricketapplicationn.Model.getPointTable;

import java.util.List;

public interface PointtableResposneLinstener<getPointTable> {

    void didFetch(List<PointsTable> response, String message);
    void didError(String message);
}
