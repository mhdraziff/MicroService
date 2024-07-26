package com.razif.pegawai.service;

import com.razif.pegawai.entity.Pegawai;
import com.razif.pegawai.repository.PegawaiRepository;
import com.razif.pegawai.vo.Product;
import com.razif.pegawai.vo.ResponseTemplate;
import jakarta.transaction.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

@Service
public class PegawaiService {
    @Autowired
    private PegawaiRepository pegawaiRepository;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping
    public List<Pegawai> getAll(){
        return pegawaiRepository.findAll();
    }
    public Pegawai getPegawaiById(Long id){
        return pegawaiRepository.findById(id).get();

    }
    public void insert(Pegawai pegawai){
        pegawaiRepository.save(pegawai);
    }
    @Transactional
    public void update(Long pegawaiId,Integer nip, String nama){
        Pegawai pegawai = pegawaiRepository.findById(pegawaiId).orElseThrow
                (()
                        -> new IllegalStateException("Pegawai Tidak ada"));
        if(nip != null){
            pegawai.setNip(nip);
        }
        if(nama != null && nama.length()>0
                && !Objects.equals(nama.getNama(), nama)){
            nama.setNama(nama);
        }
    }
    public void delete(Long id){
        pegawaiRepository.deleteById(id);
    }

    public ResponseTemplate getPegawaiWithProductById(Long id){
        ResponseTemplate responseTemplate = new ResponseTemplate();
        Pegawai pegawai = getPegawaiById(id);
        Product product = restTemplate.getForObject("http://localhost:9001/api/v1/product/" + pegawai.getProductId(), Product.class);
        responseTemplate.setPegawai(pegawai);
        responseTemplate.setProduct(product);
        return responseTemplate;
    }

}