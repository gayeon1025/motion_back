package com.cnu.motion.schedule;

import com.cnu.motion.domain.Schedule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ScheduleService {
    @Autowired
    ScheduleRepository scheduleRepository;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());


    public List<Schedule> getSchedules(int year, int month) {//TODO : test codes are required.
        LocalDateTime start = LocalDateTime.of(year, month, 1, 0, 0, 0);
        LocalDateTime end = (LocalDateTime.of(year, month + 1, 1, 23, 59, 59)).minusDays(1);

        return scheduleRepository.findAllByStartAtBetweenOrEndAtBetween(start, end, start, end);
    }

    //    @Transactional
    public Schedule addSchedule(Schedule schedule) {
        Schedule savedSchedule = scheduleRepository.save(schedule);

        logger.info("============= Success to save new schedule ============= ");
        logger.info("id : {}, title : {}", savedSchedule.getId(), savedSchedule.getTitle());

        return savedSchedule;
    }
}
