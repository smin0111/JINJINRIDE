package com.ohgiraffers.usehistory.model.dao;

import com.ohgiraffers.usehistory.model.dto.UseHistoryDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UseHistoryMapper {
    int insertUseHistory(UseHistoryDTO useHistory);
}
