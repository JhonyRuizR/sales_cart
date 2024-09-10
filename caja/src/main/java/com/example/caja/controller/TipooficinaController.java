package com.example.caja.controller;

import com.example.caja.dto.TipooficinaDTO;
import com.example.caja.model.Tipooficina;
import com.example.caja.service.ITipooficinaService;
import com.example.caja.util.MapperUtil;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/tipooficina")
@AllArgsConstructor
public class TipooficinaController {
    private final ITipooficinaService tipooficinaService;
    private final MapperUtil mapperUtil;

    @GetMapping
    public ResponseEntity<List<TipooficinaDTO>> findAll() {
        List<TipooficinaDTO> list=mapperUtil.mapList(tipooficinaService.findAll(), TipooficinaDTO.class);
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipooficinaDTO> findById(@PathVariable("id") Integer id) {
        Tipooficina obj=tipooficinaService.findById(id);
        return ResponseEntity.ok(mapperUtil.map(obj, TipooficinaDTO.class));
    }

    @PostMapping
    public ResponseEntity<Void> save(@Valid @RequestBody TipooficinaDTO dto) {
        Tipooficina obj=tipooficinaService.save(mapperUtil.map(dto, Tipooficina.class));
        URI location= ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdTipooficina()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<TipooficinaDTO> update(@Valid @PathVariable("id") Integer id, @RequestBody TipooficinaDTO dto) {
        dto.setIdTipooficina(id);
        Tipooficina obj=tipooficinaService.update(id, mapperUtil.map(dto, Tipooficina.class));
        return  ResponseEntity.ok(mapperUtil.map(obj, TipooficinaDTO.class));
    }

    @DeleteMapping
    public ResponseEntity<Void> delete(@RequestBody Integer id) {
        tipooficinaService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
