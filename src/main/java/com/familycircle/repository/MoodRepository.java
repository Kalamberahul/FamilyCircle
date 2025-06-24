package com.familycircle.repository;

import com.familycircle.model.Mood;
import com.familycircle.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface MoodRepository extends JpaRepository<Mood, Long> {
    List<Mood> findByUser(User user);
}
