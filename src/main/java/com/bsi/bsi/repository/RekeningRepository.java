package com.bsi.bsi.repository;

import com.bsi.bsi.model.entity.Rekening;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RekeningRepository extends JpaRepository<Rekening, Long> {
    Optional<Rekening> findByNoRekening(long noRekening);

}
