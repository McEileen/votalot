package com.votalot.repositories;

import com.votalot.entities.Candidate;
import com.votalot.entities.Voter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IVoterRepository extends PagingAndSortingRepository<Voter, Integer> {

    public Voter findByName(String name);

}
