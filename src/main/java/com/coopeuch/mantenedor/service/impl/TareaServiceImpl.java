package com.coopeuch.mantenedor.service.impl;

import com.coopeuch.mantenedor.entity.Tarea;
import com.coopeuch.mantenedor.repository.TareaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TareaServiceImpl implements TareaService{

    @Autowired
    private TareaRepository tareaRepository;

    @Override
    public List<Tarea> listAllTareas() {
        List<Tarea> tareas = tareaRepository.findAll();
        return tareas;
    }

    @Override
    public Tarea getTarea(int id) {
        Tarea tarea = tareaRepository.findById(id).get();
        return tarea;
    }

    @Override
    public Tarea saveTarea(Tarea tarea) {
        Tarea tareaGuardada = tareaRepository.save(tarea);
        return tareaGuardada;
    }

    @Override
    public void deleteTarea(int id) {
        tareaRepository.deleteById(id);
    }

    @Override
    public Tarea updateTarea(Tarea tarea) {
        Tarea tareaActualizada = tareaRepository.save(tarea);
        return tareaActualizada;
    }
}
