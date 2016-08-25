package com.votalot.repositories;

import com.votalot.entities.Candidate;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ICandidateRepository extends PagingAndSortingRepository<Candidate, Integer> {
}
