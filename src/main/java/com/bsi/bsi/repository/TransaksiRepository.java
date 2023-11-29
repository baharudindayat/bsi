package com.bsi.bsi.repository;

import com.bsi.bsi.model.entity.Transaksi;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransaksiRepository extends JpaRepository<Transaksi, Long> {
}
