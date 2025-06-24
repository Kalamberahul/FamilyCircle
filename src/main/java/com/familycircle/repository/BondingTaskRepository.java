package com.familycircle.repository;

import com.familycircle.model.BondingTask;
import com.familycircle.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface BondingTaskRepository extends JpaRepository<BondingTask, Long> {
    List<BondingTask> findByUser(User user);  // ✅ This is what was missing!
}
