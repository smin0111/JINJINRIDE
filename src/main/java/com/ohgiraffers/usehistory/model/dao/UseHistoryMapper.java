package com.ohgiraffers.usehistory.model.dao;

import com.ohgiraffers.usehistory.model.dto.UseHistoryDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UseHistoryMapper {

    // 결제 내역 INSERT
    int insertUseHistory(UseHistoryDTO useHistory);

}
