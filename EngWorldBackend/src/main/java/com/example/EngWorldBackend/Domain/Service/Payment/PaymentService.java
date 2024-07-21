package com.example.EngWorldBackend.Domain.Service.Payment;

import com.example.EngWorldBackend.DTO.Course.OrderDetailDto;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;

public interface PaymentService {

    String createPayment(HttpServletRequest req, Long amount, String bankCode, long id) throws UnsupportedEncodingException;

    OrderDetailDto paymentSuccess(long vnp_OrderInfo, String vnp_PayDate
            , long vnp_Amount, String vnp_BankCode, String vnp_CardType);
}
