package com.coopeuch.mantenedor.service.impl;

import com.coopeuch.mantenedor.entity.Tarea;

import java.util.List;

public interface TareaService {
    public List<Tarea> listAllTareas();
    public Tarea getTarea(int id);
    public Tarea saveTarea(Tarea tarea);
    public void deleteTarea(int id);
    public Tarea updateTarea(Tarea tarea);
}
