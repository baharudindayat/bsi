package com.bsi.bsi.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TransferDigibankDto {

    private long noRekeningBsi;

    private long noRekeningDigibank;

    private Double nominal;

    private String catatan;


}
