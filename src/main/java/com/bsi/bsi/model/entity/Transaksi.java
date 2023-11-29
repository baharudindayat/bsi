package com.bsi.bsi.model.entity;

import com.bsi.bsi.model.enums.JenisTransaksi;
import com.bsi.bsi.model.enums.TipeTransaksi;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
@Table(name = "Transaksi", schema = "public")
public class Transaksi {

    @Id
    @Column(name = "transaksi_id",nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long transaksiId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rekening_tujuan")
    private Rekening rekeningTujuan;

    @Column(name = "rekening_asal",nullable = false)
    private long rekeningAsal;

    @Column(nullable = false)
    private Double Nominal;

    @ManyToOne
    @JoinColumn(name = "kode_bank")
    private Bank bank;

    @Column(nullable = false)
    @CreationTimestamp
    private Timestamp waktuTransaksi;

    @Column(name="jenis_transaksi", nullable = false)
    @Enumerated(EnumType.STRING)
    private JenisTransaksi jenisTransaksi;

    @Column(nullable = false)
    private String catatan;

    @Column(name="tipe_transaksi",nullable = false)
    @Enumerated(EnumType.STRING)
    private TipeTransaksi tipeTransaksi;

    @Column(name = "total_transaksi",nullable = false)
    private Double totalTransaksi;

}
