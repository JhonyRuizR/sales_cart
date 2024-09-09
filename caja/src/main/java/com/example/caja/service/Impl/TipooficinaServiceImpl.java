package com.example.caja.service.Impl;

import com.example.caja.model.Tipooficina;
import com.example.caja.repository.IGenericRepo;
import com.example.caja.repository.ITipooficinaRepository;
import com.example.caja.service.ITipooficinaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TipooficinaServiceImpl extends CRUDImpl<Tipooficina,Integer> implements ITipooficinaService {

    private final ITipooficinaRepository tipooficinaRepository;

    @Override
    protected IGenericRepo<Tipooficina, Integer> getRepo() {
        return tipooficinaRepository;
    }
}
