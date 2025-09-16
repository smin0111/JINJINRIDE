package com.ohgiraffers.merchant.controller;

import com.ohgiraffers.merchant.model.dao.MerchantMapper;
import com.ohgiraffers.merchant.model.dto.MerchantDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/merchant")
public class MerchantController {

    private final MerchantMapper merchantMapper;

    public MerchantController(MerchantMapper merchantMapper) {
        this.merchantMapper = merchantMapper;
    }

    // 전체 가맹점 조회
    @GetMapping("/all")
    public List<MerchantDTO> getAllMerchants() {
        return merchantMapper.findAllMerchants();
    }

    // 단일 가맹점 조회 (중개수수료 확인용)
    @GetMapping("/{merchantNum}/fee")
    public Double getMerchantFee(@PathVariable String merchantNum) {
        MerchantDTO merchant = merchantMapper.findByMerchantNum(merchantNum);
        if (merchant != null) {
            return merchant.getBrokerage().doubleValue();
        } else {
            return 0.0;
        }
    }
}
