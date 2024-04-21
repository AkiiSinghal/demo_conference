package com.LMS.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.LMS.demo.models.Session;

public interface SessionRepository extends JpaRepository<Session, Long> {

}
