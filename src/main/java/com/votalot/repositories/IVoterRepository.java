package com.votalot.repositories;

import com.votalot.entities.Voter;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IVoterRepository extends PagingAndSortingRepository<Voter, Integer> {
}
