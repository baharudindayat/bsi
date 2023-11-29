package com.bsi.bsi.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
@Table(name = "rekening", schema = "public")
public class Rekening {

    @Id
    @Column(name = "no_rekening",nullable = false, unique = true)
    private long noRekening;

    @Column(nullable = false)
    private Double saldo = 0.0;

    @Column(name = "created_at", nullable = false)
    @CreationTimestamp
    private Timestamp createdAt;

    @Column(name = "name", nullable = false)
    private String name;
}
