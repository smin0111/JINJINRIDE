package com.ohgiraffers.usehistory.model.dto;

import java.math.BigDecimal;
import java.util.Date;

public class UseHistoryDTO {

    private Integer transactionNum;    // 거래번호, AUTO_INCREMENT
    private String memberNum;          // 회원번호
    private String phoneNum;           // 전화번호 (비회원일 경우 기재)
    private String categoryCd;         // 카테고리 코드
    private String merchantNum;        // 가맹점 번호
    private BigDecimal brokerage;      // 중개수수료 금액
    private Date paymentDateTime;      // 결제일자
    private Date useStartDateTime;     // 이용 시작일자
    private Date useEndDateTime;       // 이용 종료일자
    private String reservationStatus;  // 예약상태 (Y:예약중, N:이용완료, C:예약취소)

    public UseHistoryDTO() {}

    public UseHistoryDTO(String memberNum, String phoneNum, String categoryCd, String merchantNum,
                         BigDecimal brokerage, Date paymentDateTime, Date useStartDateTime,
                         Date useEndDateTime, String reservationStatus) {
        this.memberNum = memberNum;
        this.phoneNum = phoneNum;
        this.categoryCd = categoryCd;
        this.merchantNum = merchantNum;
        this.brokerage = brokerage;
        this.paymentDateTime = paymentDateTime;
        this.useStartDateTime = useStartDateTime;
        this.useEndDateTime = useEndDateTime;
        this.reservationStatus = reservationStatus;
    }

    // ======= Getter & Setter =======
    public Integer getTransactionNum() { return transactionNum; }
    public void setTransactionNum(Integer transactionNum) { this.transactionNum = transactionNum; }

    public String getMemberNum() { return memberNum; }
    public void setMemberNum(String memberNum) { this.memberNum = memberNum; }

    public String getPhoneNum() { return phoneNum; }
    public void setPhoneNum(String phoneNum) { this.phoneNum = phoneNum; }

    public String getCategoryCd() { return categoryCd; }
    public void setCategoryCd(String categoryCd) { this.categoryCd = categoryCd; }

    public String getMerchantNum() { return merchantNum; }
    public void setMerchantNum(String merchantNum) { this.merchantNum = merchantNum; }

    public BigDecimal getBrokerage() { return brokerage; }
    public void setBrokerage(BigDecimal brokerage) { this.brokerage = brokerage; }

    public Date getPaymentDateTime() { return paymentDateTime; }
    public void setPaymentDateTime(Date paymentDateTime) { this.paymentDateTime = paymentDateTime; }

    public Date getUseStartDateTime() { return useStartDateTime; }
    public void setUseStartDateTime(Date useStartDateTime) { this.useStartDateTime = useStartDateTime; }

    public Date getUseEndDateTime() { return useEndDateTime; }
    public void setUseEndDateTime(Date useEndDateTime) { this.useEndDateTime = useEndDateTime; }

    public String getReservationStatus() { return reservationStatus; }
    public void setReservationStatus(String reservationStatus) { this.reservationStatus = reservationStatus; }

    @Override
    public String toString() {
        return "UseHistoryDTO{" +
                "transactionNum=" + transactionNum +
                ", memberNum='" + memberNum + '\'' +
                ", phoneNum='" + phoneNum + '\'' +
                ", categoryCd='" + categoryCd + '\'' +
                ", merchantNum='" + merchantNum + '\'' +
                ", brokerage=" + brokerage +
                ", paymentDateTime=" + paymentDateTime +
                ", useStartDateTime=" + useStartDateTime +
                ", useEndDateTime=" + useEndDateTime +
                ", reservationStatus='" + reservationStatus + '\'' +
                '}';
    }
}
