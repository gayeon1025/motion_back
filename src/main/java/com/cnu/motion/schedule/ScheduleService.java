package com.cnu.motion.schedule;

import com.cnu.motion.common.exception.ResourceNotFoundException;
import com.cnu.motion.common.type.Exception;
import com.cnu.motion.domain.Schedule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Transactional
    public Schedule updateSchedule(int id, Schedule changes) {
        Schedule schedule = scheduleRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(Exception.SCHEDULE_NOT_FOUND));

        logger.info("============= Update schedule ============= ");
        logger.info("Updated schedule id : {}", id);

        if (changes.getType() != null) {
            schedule.setType(changes.getType());
        }

        if (changes.getTitle() != null) {
            schedule.setTitle(changes.getTitle());
        }

        if (changes.getStartAt() != null) {
            schedule.setStartAt(changes.getStartAt());
        }

        if (changes.getEndAt() != null) {
            schedule.setEndAt(changes.getEndAt());
        }

        if (changes.getLocation() != null) {
            schedule.setLocation(changes.getLocation());
        }

        if (changes.getState() != null) {
            schedule.setState(changes.getState());
        }

        if (changes.getRaw() != null) {
            schedule.setRaw(changes.getRaw());
        }
        schedule.setAllDay(changes.isAllDay());

        Schedule savedSchedule = scheduleRepository.save(schedule);

        return savedSchedule;
    }

    @Transactional
    public Schedule deleteSchedule(int id) {
        Schedule schedule = scheduleRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(Exception.SCHEDULE_NOT_FOUND));

        scheduleRepository.delete(schedule);
        logger.info("============= Delete schedule ============= ");
        logger.info("Deleted schedule id : {}", id);

        return schedule;
    }
}
