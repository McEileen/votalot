package com.votalot.controllers;

import com.votalot.entities.Candidate;
import com.votalot.entities.Voter;
import com.votalot.enums.Race;
import com.votalot.services.CandidatesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Entity;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/candidates")
public class CandidatesController {
    private CandidatesService service;

    @Autowired
    public void setService(CandidatesService service) { this.service = service; }

    @RequestMapping(path = {"", "/"}, method = RequestMethod.GET)
    public Page<Candidate> index(@RequestParam(name = "page", required = false, defaultValue = "0") int page) {
        return this.service.findAll(page);
    }

    @RequestMapping(path = {"/{id}"}, method = RequestMethod.GET)
    public Candidate show(@PathVariable int id) { return this.service.findOne(id);}

    @RequestMapping(path = {"", "/"}, method = RequestMethod.POST)
    public Candidate create(@RequestBody Candidate candidate) { return this.service.create(candidate); }

    @RequestMapping(path = {"/{id}"}, method = RequestMethod.DELETE)
    public void destroy(@PathVariable int id) { this.service.destroy(id); }

    @RequestMapping(path = {"/{id}/voters"}, method = RequestMethod.GET)
    public Page<Voter> findVoters(@PathVariable int id, @RequestParam(name = "page", required = false, defaultValue = "0") int page) {
        return this.service.findVotersByCandidateId(id, page);
    }

//    @RequestMapping(path = {"{candidateId}/demographics/{race}/race"}, method = RequestMethod.GET)
//    public void voteForCandidates(@PathVariable int candidateId, @PathVariable Race race) { this.service.votersByRace(candidateId, race); }

}
