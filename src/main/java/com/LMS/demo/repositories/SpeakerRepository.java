package com.LMS.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.LMS.demo.models.Speaker;

public interface SpeakerRepository extends JpaRepository<Speaker, Long> {

}
