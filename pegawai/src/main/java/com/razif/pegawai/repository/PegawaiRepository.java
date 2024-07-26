package com.razif.pegawai.repository;

import com.razif.pegawai.entity.Pegawai;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PegawaiRepository extends JpaRepository<Pegawai, Long> {
    public List<Pegawai> findAll();

}