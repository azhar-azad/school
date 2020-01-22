package com.azad.practice.school.io.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.azad.practice.school.io.entity.PassportEntity;

@Repository
public interface PassportRepository extends PagingAndSortingRepository<PassportEntity, Long> {

	PassportEntity findByNumber(String passportNumber);

	PassportEntity findByPassportId(String passportId);

}
