package com.votalot.repositories;

import com.votalot.entities.Candidate;

import com.votalot.entities.Voter;
import com.votalot.enums.Race;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ICandidateRepository extends PagingAndSortingRepository<Candidate, Integer> {
    @Query("select distinct v from Voter v join v.candidates c where c.id = :id")
    public Page<Voter> findVotersByCandidateId(@Param("id") int id, Pageable pageable);

//    @Query("select distinct v from Voter join v.candidates c where c.id = :id and v.race = :race")
//    public List<Voter> findVotersByCandidateIdAndRace(@Param("id") int id, @Param("race") Race race);

}
