package com.ups.oop.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class PayMethodDTO {
    private String idPayMethod;
    private String payMethodName; //CASH, CREDIT CARD, TRANSFER, DEBIT CARD
    private String detail;
}
