package com.cnu.motion.schedule;

import com.cnu.motion.domain.Schedule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/schedules")
public class ScheduleController {
    @Autowired
    ScheduleService scheduleService;

    @Autowired
    ConversionService conversionService;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @GetMapping
    public List<Schedule> getSchedules(@RequestParam(value = "year", defaultValue = "0")int year
                                , @RequestParam(value = "month", defaultValue = "0")int month) {
        //TODO
        // handle invalid month (like 13)
        // just redirect today?

        if (year == 0 || month == 0) {
            return scheduleService.getSchedules(LocalDate.now().getYear(), LocalDate.now().getMonthValue());
        }

        return scheduleService.getSchedules(year, month);
    }

    @PostMapping
    public Schedule addSchedule(@RequestBody Schedule schedule) {
        return scheduleService.addSchedule(schedule);
    }

    @PutMapping("/{id}")
    public Schedule updateSchedule(@PathVariable(value = "id")int id, @RequestBody Schedule schedule) {
        return scheduleService.updateSchedule(id, schedule);
    }

    @DeleteMapping("/{id}")
    public Schedule deleteSchedule(@PathVariable(value = "id")int id) {
        return scheduleService.deleteSchedule(id);
    }
}
