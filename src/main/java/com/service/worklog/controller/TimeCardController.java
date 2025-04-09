package com.service.worklog.controller;

import com.service.worklog.domain.TimeCard;
import com.service.worklog.service.TimeCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/timecards")
public class TimeCardController {

  private final TimeCardService timeCardService;

  @Autowired
  public TimeCardController(TimeCardService timeCardService) {
    this.timeCardService = timeCardService;
  }

  @GetMapping
  public Page<TimeCard> findAll(Specification<TimeCard> specification, Pageable pageable) {
    return timeCardService.getTimeCards(specification, pageable);
  }

  @GetMapping("/{id}")
  public TimeCard findById(@PathVariable Long id) {
    return timeCardService.getTimeCard(id);
  }

  @PostMapping
  public TimeCard save(@RequestBody TimeCard timeCard) {
    return timeCardService.saveTimeCard(timeCard);
  }

  @PutMapping("/{id}")
  public TimeCard update(@PathVariable Long id, @RequestBody TimeCard timeCard) {
    timeCard.setTimeCardId(id);
    return timeCardService.saveTimeCard(timeCard);
  }

  @DeleteMapping("/{id}")
  public void delete(@PathVariable Long id) {
    timeCardService.deleteTimeCard(id);
  }
}
