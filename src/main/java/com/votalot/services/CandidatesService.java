package com.votalot.services;


import com.votalot.entities.Candidate;
import com.votalot.entities.Voter;

import com.votalot.enums.Race;
import com.votalot.repositories.ICandidateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CandidatesService {
    private ICandidateRepository repository;

    @Autowired
    public void setRepository(ICandidateRepository repository) { this.repository = repository; }

    public Page<Candidate> findAll(int page) {
        PageRequest pr = new PageRequest(page, 3);
        return this.repository.findAll(pr);
    }

    public Candidate findOne(int id) {
        return this.repository.findOne(id);
    }

    public Candidate create(Candidate candidate) { return this.repository.save(candidate); }

    public void destroy(int id) { this.repository.delete(id); }

    public Page<Voter> findVotersByCandidateId(int id, int page) {
        PageRequest pr = new PageRequest(page, 3);
        return this.repository.findVotersByCandidateId(id, pr);
    }

//    public List<Voter> votersByRace (int id, Race race) {
//        return this.repository.findVotersByCandidateIdAndRace(id, race);
//    }
}
