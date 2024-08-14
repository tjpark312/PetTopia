package com.sh.pettopia.enterprise.service;

import com.sh.pettopia.enterprise.dto.EnterpriseDetailResponseDto;
import com.sh.pettopia.enterprise.repository.SalonRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SalonService {

    private final SalonRepository salonRepository;


    // DB에서 병원 정보를 검색하고, 검색된 데이터를 DTO로 변환하는 기능을 제공합니다
//    public EnterpriseDetailResponseDto findById(Long id) {
//        return EnterpriseDetailResponseDto.fromSalon(enterpriseRepository.findById(id).orElseThrow());
//    }

    public EnterpriseDetailResponseDto findById(Long id) {
        return EnterpriseDetailResponseDto.fromSalon(salonRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Salon with id: " + id + "에 해당하는 정보를 찾을 수 없습니다")));
    }


}
