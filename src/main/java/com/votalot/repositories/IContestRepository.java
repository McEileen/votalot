package com.votalot.repositories;

import com.votalot.entities.Contest;
import org.springframework.data.repository.PagingAndSortingRepository;


public interface IContestRepository extends PagingAndSortingRepository<Contest, Integer> {
}
