package com.LMS.demo.controllers;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.LMS.demo.models.Speaker;
import com.LMS.demo.repositories.SessionRepository;
import com.LMS.demo.repositories.SpeakerRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("api/v1/speakers")
public class SpeakerController {
	@Autowired
	private SpeakerRepository speakerRepository;
	
	@GetMapping
	public List<Speaker> list() {
		return speakerRepository.findAll();
	}
	
	@GetMapping
	@RequestMapping("{id}")
	public Speaker get(Long id) {
		return speakerRepository.getReferenceById(id);
	}
	
	@PostMapping
	public Speaker create(@RequestBody final Speaker speaker) {
		return speakerRepository.saveAndFlush(speaker);
	}
	
	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable Long id) {
		speakerRepository.deleteById(id);
	}
	
	@RequestMapping(value = "{id}", method = RequestMethod.PUT)
	public Speaker update(@PathVariable Long id, @RequestBody Speaker speaker) {
		Speaker excistingSpeaker = speakerRepository.getReferenceById(id);
		BeanUtils.copyProperties(speaker, excistingSpeaker, "speaker_id");
		return speakerRepository.saveAndFlush(speaker);
	}
}
