package com.familycircle.service;

import com.familycircle.model.Gratitude;
import com.familycircle.model.User;

import java.util.List;

public interface GratitudeService {
    void saveGratitude(Gratitude gratitude);
    List<Gratitude> getGratitudesForUser(User user);
}
