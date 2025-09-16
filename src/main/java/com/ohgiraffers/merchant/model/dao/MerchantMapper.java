package com.ohgiraffers.merchant.model.dao;

import com.ohgiraffers.merchant.model.dto.MerchantDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MerchantMapper {

    // 전체 가맹점 조회
    List<MerchantDTO> findAllMerchants();

    // 단일 가맹점 조회 (merchant_num 기준)
    MerchantDTO findByMerchantNum(String merchantNum);

}
