package com.votalot.services;

import com.votalot.entities.Candidate;
import com.votalot.entities.Voter;
import com.votalot.repositories.ICandidateRepository;
import com.votalot.repositories.IVoterRepository;
import org.hibernate.annotations.SourceType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VotersService {
    private IVoterRepository repository;
    private CandidatesService candidateService;

    @Autowired
    public void setRepository(IVoterRepository repository) {
        this.repository = repository;
    }

    @Autowired
    public void setService(CandidatesService candidateService) { this.candidateService = candidateService; }

    public Page<Voter> findAll(int page) {
        PageRequest pr = new PageRequest(page, 3);
        return this.repository.findAll(pr);
    }

    public Voter findOne(int id) { return this.repository.findOne(id); }

    public Voter create(Voter voter) { return this.repository.save(voter); }

    public Voter findByName(String name) { return this.repository.findByName(name); }

    public void destroy(int id) { this.repository.delete(id); }

    public List<Candidate> findCandidatesByVoterId(int id) {
        return this.repository.findOne(id).getCandidates();
    }

    public void voteForCandidate(int voterId, int candidateId) {
        Voter voter = this.repository.findOne(voterId);
        List<Candidate> candidates = voter.getCandidates();
        Candidate candidate = this.candidateService.findOne(candidateId);
        candidates.add(candidate);
        voter.setCandidates(candidates);
        this.repository.save(voter);
    }
}
