package com.votalot.controllers;

import com.votalot.entities.Voter;
import com.votalot.services.VotersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/voters")
public class VotersController {
    private VotersService service;

    @Autowired
    public void setService(VotersService service) { this.service = service; }

    @RequestMapping(path = {"","/"}, method = RequestMethod.GET)
    public Page<Voter> index(@RequestParam(name = "page", required = false, defaultValue = "0") int page) {
        return this.service.findAll(page);
    }

    @RequestMapping(path = {"/{id}"}, method = RequestMethod.GET)
    public Voter show(@PathVariable int id) { return this.service.findOne(id);}

    @RequestMapping(path = {"", "/"}, method = RequestMethod.POST)
    public Voter create(@RequestBody Voter voter) { return this.service.create(voter); }

    @RequestMapping(path = {"/name/{name}"}, method = RequestMethod.GET)
    public Voter findByName(@PathVariable String name) { return this.service.findByName(name); }

    @RequestMapping(path = {"/{id}"}, method = RequestMethod.DELETE)
    public void destroy(@PathVariable int id) { this.service.destroy(id); }


}
