package com.cnu.motion.schedule;

import com.cnu.motion.domain.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Integer> {
    List<Schedule> findAllByStartAtBetweenOrEndAtBetween(LocalDateTime start, LocalDateTime end, LocalDateTime start2, LocalDateTime end2);
}
