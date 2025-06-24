package com.familycircle.service;

import com.familycircle.model.Mood;
import com.familycircle.model.User;
import java.util.List;

public interface MoodService {
    void saveMood(Mood mood);
    List<Mood> getMoodsForUser(User user);
}
