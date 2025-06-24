package com.familycircle.repository;

import com.familycircle.model.BondingPoint;
import com.familycircle.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface BondingPointRepository extends JpaRepository<BondingPoint, Long> {
    List<BondingPoint> findByUser(User user);
}
