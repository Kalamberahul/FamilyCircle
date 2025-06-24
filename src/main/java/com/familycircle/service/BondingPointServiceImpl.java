package com.familycircle.service;

import com.familycircle.model.BondingPoint;
import com.familycircle.model.User;
import com.familycircle.repository.BondingPointRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class BondingPointServiceImpl implements BondingPointService {

    @Autowired
    private BondingPointRepository bondingPointRepository;

    @Override
    public void addPoints(User user, int points, String reason) {
        BondingPoint point = new BondingPoint();
        point.setUser(user);
        point.setPoints(points);
        point.setReason(reason);
        point.setTimestamp(LocalDateTime.now());

        bondingPointRepository.save(point);
    }

    @Override
    public List<BondingPoint> getPointsForUser(User user) {
        return bondingPointRepository.findByUser(user);
    }
}
