package com.bsi.bsi.service;

import com.bsi.bsi.dto.TransferDigibankDto;

public interface DigibankService {

    Object getAccountRekening(long id);

    TransferDigibankDto createTransfer(TransferDigibankDto transferDigibankDto);

}
