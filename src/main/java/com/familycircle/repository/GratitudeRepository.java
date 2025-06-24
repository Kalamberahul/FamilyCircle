package com.familycircle.repository;

import com.familycircle.model.Gratitude;
import com.familycircle.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GratitudeRepository extends JpaRepository<Gratitude, Long> {
    List<Gratitude> findByUser(User user);
}
