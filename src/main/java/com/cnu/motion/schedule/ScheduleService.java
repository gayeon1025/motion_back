package com.cnu.motion.schedule;

import com.cnu.motion.domain.Schedule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
public class ScheduleService {
    @Autowired
    ScheduleRepository scheduleRepository;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());


    public List<Schedule> getSchedules(int year, int month) {//TODO : test codes are required.
        LocalDate start = LocalDate.of(year, month, 1);
        LocalDate end   = (LocalDate.of(year, month+1, 1)).minusDays(1);

        return scheduleRepository.findAllByStartAtBetweenOrEndAtBetween(start, end, start, end);
    }

    @Transactional
    public Schedule addSchedule(Schedule schedule) {
        Schedule savedSchedule = scheduleRepository.save(schedule);
        return savedSchedule;
    }
}
