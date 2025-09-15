package com.ohgiraffers.merchant.model.dao;

import com.ohgiraffers.merchant.model.dto.MerchantDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface MerchantMapper {

    // 가맹점 조회 (merchant_num 기준)
    @Select("SELECT * FROM T_Merchant WHERE merchant_num = #{merchantNum}")
    MerchantDTO findByMerchantNum(String merchantNum);
}
