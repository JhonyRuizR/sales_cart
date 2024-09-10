package com.example.caja.controller;

import com.example.caja.dto.OficinaDTO;
import com.example.caja.model.Oficina;
import com.example.caja.service.IOficinaService;
import com.example.caja.util.MapperUtil;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/oficina")
@AllArgsConstructor
public class OficinaController {
    private final IOficinaService oficinaService;
    private final MapperUtil mapperUtil;

    @GetMapping
    public ResponseEntity<List<OficinaDTO>> findAll() {
        List<OficinaDTO> list=mapperUtil.mapList(oficinaService.findAll(), OficinaDTO.class);
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OficinaDTO> findById(@PathVariable("id") Integer id) {
        Oficina obj=oficinaService.findById(id);
        return ResponseEntity.ok(mapperUtil.map(obj, OficinaDTO.class));
    }

    @PostMapping
    public ResponseEntity<Void> save(@Valid @RequestBody OficinaDTO dto) {
        Oficina obj=oficinaService.save(mapperUtil.map(dto, Oficina.class));
        URI location= ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdOficina()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<OficinaDTO> update(@Valid @PathVariable("id") Integer id, @RequestBody OficinaDTO dto) {
        dto.setIdOficina(id);
        Oficina obj=oficinaService.update(id, mapperUtil.map(dto, Oficina.class));
        return  ResponseEntity.ok(mapperUtil.map(obj, OficinaDTO.class));
    }

    @DeleteMapping
    public ResponseEntity<Void> delete(@RequestBody Integer id) {
        oficinaService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
