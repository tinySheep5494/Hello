package com.chenyu.repository;

import java.io.Serializable;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;

@NoRepositoryBean
public interface BaseRepostory<T, ID extends Serializable> extends PagingAndSortingRepository<T, Serializable> {

	public Page<T> findAll(Specification<T> spec, Pageable pageable);

}
