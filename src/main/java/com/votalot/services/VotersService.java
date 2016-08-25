package com.votalot.services;

import com.votalot.entities.Voter;
import com.votalot.repositories.IVoterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class VotersService {
    private IVoterRepository repository;

    @Autowired
    public void setRepository(IVoterRepository repository) {
        this.repository = repository;
    }

    public Page<Voter> findAll(int page) {
        PageRequest pr = new PageRequest(page, 3);
        return this.repository.findAll(pr);
    }

    public Voter findOne(int id) { return this.repository.findOne(id); }

    public Voter create(Voter voter) { return this.repository.save(voter); }

    public Voter findByName(String name) { return this.repository.findByName(name); }

    public void destroy(int id) { this.repository.delete(id); }
}
