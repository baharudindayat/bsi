package com.bsi.bsi.service.Impl;

import com.bsi.bsi.dto.GetAcountBsiDto;
import com.bsi.bsi.dto.TransferDigibankDto;
import com.bsi.bsi.exception.AccountBsiNotFoundException;
import com.bsi.bsi.model.entity.Bank;
import com.bsi.bsi.model.entity.Rekening;
import com.bsi.bsi.model.entity.Transaksi;
import com.bsi.bsi.model.enums.JenisTransaksi;
import com.bsi.bsi.model.enums.TipeTransaksi;
import com.bsi.bsi.repository.RekeningRepository;
import com.bsi.bsi.repository.TransaksiRepository;
import com.bsi.bsi.service.DigibankService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class DigibankServiceImpl implements DigibankService {

    private RekeningRepository transferRepository;
    private TransaksiRepository transaksiRepository;
    @Override
    public Object getAccountRekening(long id) {
        Optional<Rekening> rekeningBsi = transferRepository.findByNoRekening(id);

        GetAcountBsiDto getAcountBsiDto = new GetAcountBsiDto();
        if (rekeningBsi.isPresent()){
            getAcountBsiDto.setNoRekening(String.valueOf(rekeningBsi.get().getNoRekening()));
            getAcountBsiDto.setNama(rekeningBsi.get().getName());
            getAcountBsiDto.setNamaBank("Bank Syariah Indonesia");
            return getAcountBsiDto;
        }else {
            throw new AccountBsiNotFoundException("Account BSI Not Found");
        }

    }

    @Override
    public TransferDigibankDto createTransfer(TransferDigibankDto transferDigibankDto) {

        Optional<Rekening> rekeningTujuan = transferRepository.findByNoRekening(transferDigibankDto.getNoRekeningBsi());
        if (rekeningTujuan.isEmpty()) {
            throw new AccountBsiNotFoundException("Rekening BSI Tidak Ditemukan");
        }

        rekeningTujuan.get().setSaldo(rekeningTujuan.get().getSaldo() + transferDigibankDto.getNominal());
        transferRepository.save(rekeningTujuan.get());

        Bank bank = new Bank();
        bank.setKodeBank(1);

        Transaksi transaksi = new Transaksi();
        transaksi.setRekeningAsal(transferDigibankDto.getNoRekeningDigibank());
        transaksi.setRekeningTujuan(rekeningTujuan.get());
        transaksi.setBank(bank);
        transaksi.setCatatan(transferDigibankDto.getCatatan());
        transaksi.setTipeTransaksi(TipeTransaksi.DEBIT);
        transaksi.setJenisTransaksi(JenisTransaksi.ANTARBANK);
        transaksi.setNominal(transferDigibankDto.getNominal());
        transaksi.setTotalTransaksi(transferDigibankDto.getNominal());
        transaksiRepository.save(transaksi);

        return transferDigibankDto;
    }
}
