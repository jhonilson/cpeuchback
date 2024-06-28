package com.coopeuch.mantenedor.controller;

import com.coopeuch.mantenedor.dto.Mensaje;
import com.coopeuch.mantenedor.entity.Tarea;
import com.coopeuch.mantenedor.service.impl.TareaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/tarea")
//@CrossOrigin(origins = "*")
@CrossOrigin(origins = "http://localhost:4200")
public class TareaController {

    @Autowired
    private TareaService tareaService;

    @GetMapping("/listar")
    public ResponseEntity<List<Tarea>> listar() {
        List<Tarea> list = tareaService.listAllTareas();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<Tarea> getById(@PathVariable("id") int id) {
        try {
            Tarea tarea = tareaService.getTarea(id);
            return new ResponseEntity(tarea, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/crear")
    public Tarea create(@RequestBody Tarea tarea) {
        try {
            return tareaService.saveTarea(tarea);
        } catch (Exception e) {
            return null;
        }
    }

    @PutMapping("/actualizar")
    public Tarea update(@RequestBody Tarea tarea) {
        try {
            return tareaService.updateTarea(tarea);
        } catch (Exception e) {
            return null;
        }
    }

    @DeleteMapping("/borrar/{id}")
    public void delete(@PathVariable("id") int id) {
        tareaService.deleteTarea(id);
    }
}
