package com.example.EngWorldBackend.Presentation.Controller.PaymentController;


import com.example.EngWorldBackend.DTO.Course.OrderDetailDto;
import com.example.EngWorldBackend.Domain.Respones.ResponseMessages;
import com.example.EngWorldBackend.Domain.Respones.ResponseObject;
import com.example.EngWorldBackend.Domain.Respones.ResponseUtils;
import com.example.EngWorldBackend.Domain.Service.Payment.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;

@RestController
@RequestMapping("/api/user/payment")
@RequiredArgsConstructor
public class PaymentController {
    private final PaymentService paymentService;

    @GetMapping("/create")
    public ResponseEntity<ResponseObject> createOrder(HttpServletRequest req
            , @RequestParam long amount
            , @RequestParam String bankCode
            , @RequestParam long id) throws UnsupportedEncodingException {

        String paymentUrl = paymentService.createPayment(req, amount, bankCode, id);
        return ResponseUtils.buildCreatedResponse(paymentUrl, ResponseMessages.CREATED_SUCCESS_RESPONES);
    }

    @GetMapping("/success")
    public ResponseEntity<ResponseObject> paymentSuccess(@RequestParam long vnp_OrderInfo
            , @RequestParam String vnp_PayDate
            , @RequestParam long vnp_Amount
            , @RequestParam String vnp_BankCode
            , @RequestParam String vnp_CardType
    ) {
        try {

            OrderDetailDto orderDetailDto = paymentService.paymentSuccess(vnp_OrderInfo, vnp_PayDate, vnp_Amount, vnp_BankCode, vnp_CardType);

            return ResponseUtils.buildSuccessResponse(orderDetailDto, ResponseMessages.SUCCESS_RESPONSE);
        } catch (Exception e) {
            return ResponseUtils.buildErrorResponse(HttpStatus.BAD_REQUEST, ResponseMessages.BAD_REQUEST + e.getMessage());
        }
    }

}
