package com.familycircle.service;

import com.familycircle.model.Gratitude;
import com.familycircle.model.User;
import com.familycircle.repository.GratitudeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GratitudeServiceImpl implements GratitudeService {

    @Autowired
    private GratitudeRepository gratitudeRepository;

    @Override
    public void saveGratitude(Gratitude gratitude) {
        gratitudeRepository.save(gratitude);
    }

    @Override
    public List<Gratitude> getGratitudesForUser(User user) {
        return gratitudeRepository.findByUser(user);
    }
}
