package com.cnu.motion.schedule;

import com.cnu.motion.domain.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Integer> {
    List<Schedule> findAllByStartAtBetweenOrEndAtBetween(LocalDate start, LocalDate end, LocalDate start2, LocalDate end2);
}
