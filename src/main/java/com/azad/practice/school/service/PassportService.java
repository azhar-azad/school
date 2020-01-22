package com.azad.practice.school.service;

import java.util.List;

import com.azad.practice.school.io.entity.PassportEntity;
import com.azad.practice.school.shared.dto.PassportDto;

public interface PassportService {

	PassportDto createPassport(PassportDto passportDto);

	PassportEntity getPassportByPassportNumber(String number);

	PassportDto getPassportByPassportId(String passportId);

	List<PassportDto> getAll(int page, int limit);

	void deletePassport(String passportId);

	PassportDto updatePassport(String passportId, PassportDto updatedPassportDto);

}
