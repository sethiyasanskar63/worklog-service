package com.service.worklog.service;

import com.service.worklog.domain.TimeCard;
import com.service.worklog.repository.TimeCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
public class TimeCardService {

  private final TimeCardRepository timeCardRepository;

  @Autowired
  public TimeCardService(TimeCardRepository timeCardRepository) {
    this.timeCardRepository = timeCardRepository;
  }

  public Page<TimeCard> getTimeCards(Specification<TimeCard> specification, Pageable pageable) {
    return timeCardRepository.findAll(specification, pageable);
  }

  public TimeCard getTimeCard(Long id) {
    return timeCardRepository.findById(id).orElse(null);
  }

  public TimeCard saveTimeCard(TimeCard timeCard) {
    return timeCardRepository.save(timeCard);
  }

  public void deleteTimeCard(Long id) {
    timeCardRepository.deleteById(id);
  }
}
