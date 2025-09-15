package com.ohgiraffers.payment.controller;

import com.ohgiraffers.merchant.model.dao.MerchantMapper;
import com.ohgiraffers.merchant.model.dto.MerchantDTO;
import com.ohgiraffers.usehistory.model.dao.UseHistoryMapper;
import com.ohgiraffers.usehistory.model.dto.UseHistoryDTO;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Date;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    private final MerchantMapper merchantMapper;
    private final UseHistoryMapper useHistoryMapper;

    public PaymentController(MerchantMapper merchantMapper, UseHistoryMapper useHistoryMapper) {
        this.merchantMapper = merchantMapper;
        this.useHistoryMapper = useHistoryMapper;
    }

    // ✅ 네이버페이 결제 완료 → 결제 내역 저장
    @PostMapping("/complete")
    public String completePayment(@RequestParam("merchantNum") String merchantNum,
                                  @RequestParam("memberNum") String memberNum,
                                  @RequestParam("phoneNum") String phoneNum,
                                  @RequestParam("categoryCd") String categoryCd) {
        // 1. 가맹점 정보 조회
        MerchantDTO merchant = merchantMapper.findByMerchantNum(merchantNum);
        if (merchant == null) {
            return "가맹점이 존재하지 않습니다.";
        }

        // 2. 결제 내역 저장
        UseHistoryDTO history = new UseHistoryDTO();
        history.setMemberNum(memberNum);
        history.setPhoneNum(phoneNum);
        history.setCategoryCd(categoryCd);
        history.setMerchantNum(merchantNum);
        history.setBrokerage(merchant.getBrokerage());  // 중개수수료 결제금액
        history.setPaymentDateTime(LocalDateTime.now()); // ✅ 결제일자 기록
        history.setReservationStatus("Y");

        useHistoryMapper.insertUseHistory(history);

        return "결제 완료 - 이용내역 저장 성공";
    }
}
