package com.service.worklog.repository;

import com.service.worklog.domain.TimeCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface TimeCardRepository extends JpaRepository<TimeCard, Long>, JpaSpecificationExecutor<TimeCard> {
}
