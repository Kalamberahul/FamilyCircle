package com.familycircle.service;

import com.familycircle.model.BondingPoint;
import com.familycircle.model.User;

import java.util.List;

public interface BondingPointService {
    void addPoints(User user, int points, String reason);
    List<BondingPoint> getPointsForUser(User user);
}

