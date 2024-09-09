package com.example.caja.service.Impl;

import com.example.caja.model.Oficina;
import com.example.caja.repository.IGenericRepo;
import com.example.caja.repository.IOficinaRepository;
import com.example.caja.service.IOficinaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OficinaServiceImpl extends CRUDImpl<Oficina,Integer> implements IOficinaService {

    private final IOficinaRepository oficinaRepository;

    @Override
    protected IGenericRepo<Oficina, Integer> getRepo() {
        return oficinaRepository;
    }
}
