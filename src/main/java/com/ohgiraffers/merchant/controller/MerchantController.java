package com.ohgiraffers.merchant.controller;

import com.ohgiraffers.merchant.model.dao.MerchantMapper;
import com.ohgiraffers.merchant.model.dto.MerchantDTO;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/merchant")
public class MerchantController {

    private final MerchantMapper merchantMapper;

    public MerchantController(MerchantMapper merchantMapper) {
        this.merchantMapper = merchantMapper;
    }

    // ✅ 가맹점 수수료(결제금액) 조회 API
    // 예: GET http://localhost:8001/api/merchant/M123/brokerage
    @GetMapping("/{merchantNum}/brokerage")
    public String getBrokerage(@PathVariable("merchantNum") String merchantNum) {
        MerchantDTO merchant = merchantMapper.findByMerchantNum(merchantNum);
        if (merchant == null) {
            return "해당 가맹점이 존재하지 않습니다.";
        }
        return String.valueOf(merchant.getBrokerage()); // 수수료 금액 반환
    }
}
