package com.ohgiraffers.payment.controller;

import com.ohgiraffers.merchant.model.dao.MerchantMapper;
import com.ohgiraffers.merchant.model.dto.MerchantDTO;
import com.ohgiraffers.usehistory.model.dao.UseHistoryMapper;
import com.ohgiraffers.usehistory.model.dto.UseHistoryDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Date;
import java.time.LocalDateTime;
import java.time.ZoneId;

@Controller
@RequestMapping("/payment")
public class PaymentController {

    private final MerchantMapper merchantMapper;
    private final UseHistoryMapper useHistoryMapper;

    public PaymentController(MerchantMapper merchantMapper, UseHistoryMapper useHistoryMapper) {
        this.merchantMapper = merchantMapper;
        this.useHistoryMapper = useHistoryMapper;
    }

    // ✅ 네이버페이 결제 완료 → 결제 내역 저장 후 index.html로 리다이렉트
    @PostMapping("/complete")
    public RedirectView completePayment(@RequestParam("merchantNum") String merchantNum,
                                        @RequestParam("memberNum") String memberNum,
                                        @RequestParam("phoneNum") String phoneNum,
                                        @RequestParam("categoryCd") String categoryCd) {
        // 1. 가맹점 정보 조회
        MerchantDTO merchant = merchantMapper.findByMerchantNum(merchantNum);
        if (merchant == null) {
            // 가맹점 없으면 index로 리다이렉트 + 파라미터로 메시지 전달 가능
            return new RedirectView("/index.html?error=merchantNotFound");
        }

        // 2. 결제 내역 저장
        UseHistoryDTO history = new UseHistoryDTO();
        history.setMemberNum(memberNum);
        history.setPhoneNum(phoneNum);
        history.setCategoryCd(categoryCd);
        history.setMerchantNum(merchantNum);
        history.setBrokerage(merchant.getBrokerage()); // 중개수수료 금액

        // LocalDateTime → Date 변환
        Date paymentDate = Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant());
        history.setPaymentDateTime(paymentDate);

        history.setReservationStatus("Y");

        useHistoryMapper.insertUseHistory(history);

        // 3. 결제 완료 후 index.html로 리다이렉트
        return new RedirectView("/index.html?success=paymentComplete");
    }
}
