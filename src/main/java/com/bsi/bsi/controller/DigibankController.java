package com.bsi.bsi.controller;

import com.bsi.bsi.dto.GetAcountBsiDto;
import com.bsi.bsi.dto.Response;
import com.bsi.bsi.dto.TransferDigibankDto;
import com.bsi.bsi.service.DigibankService;
import com.bsi.bsi.utils.ResponseHandler.ResponseHandlerDigibank;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;

@RestController
@AllArgsConstructor
@RequestMapping("bsi/digibank")
@Slf4j
public class DigibankController {

    private DigibankService digibankService;

    @PostMapping("/accountbsi")
    public ResponseEntity<?> getAccountRekening(@RequestBody GetAcountBsiDto id){
        Object newRekeningNameDto = digibankService.getAccountRekening(Long.parseLong(id.getNoRekening()));
        return ResponseHandlerDigibank.generateResponseDigibank("Rekening Bsi Berhasil Ditemukan", HttpStatus.OK, newRekeningNameDto);
    }

    @PostMapping("/transferbsi")
    public ResponseEntity<?> createTransferBsi(@RequestBody TransferDigibankDto digibankDto){
        TransferDigibankDto newRekeningNameDto = digibankService.createTransfer(digibankDto);
        Object rekeningBsi = digibankService.getAccountRekening(Long.parseLong(String.valueOf(digibankDto.getNoRekeningBsi())));
        return ResponseHandlerDigibank.generateResponseTransferBsi("Transfer Bsi Berhasil", HttpStatus.OK, newRekeningNameDto,rekeningBsi);
    }

    @GetMapping("/kartu")
    private ResponseEntity<Object> getKartu(){
        String uri = "http://localhost:18000/api/v1/users/cards";
        RestTemplate restTemplate = new RestTemplate();
        Response result = restTemplate.getForObject(uri, Response.class);
        return ResponseEntity.ok(result);

    }



}
