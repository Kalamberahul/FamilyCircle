package com.familycircle.service;

import com.familycircle.model.Mood;
import com.familycircle.model.User;
import com.familycircle.repository.MoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MoodServiceImpl implements MoodService {
    @Autowired
    private MoodRepository moodRepository;

    @Override
    public void saveMood(Mood mood) {
        moodRepository.save(mood);
    }

    @Override
    public List<Mood> getMoodsForUser(User user) {
        return moodRepository.findByUser(user);
    }
}
