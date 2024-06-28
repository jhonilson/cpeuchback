package com.coopeuch.mantenedor.service.impl;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.coopeuch.mantenedor.entity.Tarea;
import com.coopeuch.mantenedor.repository.TareaRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {TareaServiceImpl.class})
@ExtendWith(SpringExtension.class)
@DisabledInAotMode
class TareaServiceImplDiffblueTest {
    @MockBean
    private TareaRepository tareaRepository;

    @Autowired
    private TareaServiceImpl tareaServiceImpl;

    /**
     * Method under test: {@link TareaServiceImpl#listAllTareas()}
     */
    @Test
    void testListAllTareas() {
        // Arrange
        ArrayList<Tarea> tareaList = new ArrayList<>();
        when(tareaRepository.findAll()).thenReturn(tareaList);

        // Act
        List<Tarea> actualListAllTareasResult = tareaServiceImpl.listAllTareas();

        // Assert
        verify(tareaRepository).findAll();
        assertTrue(actualListAllTareasResult.isEmpty());
        assertSame(tareaList, actualListAllTareasResult);
    }

    /**
     * Method under test: {@link TareaServiceImpl#getTarea(int)}
     */
    @Test
    void testGetTarea() {
        // Arrange
        Tarea tarea = new Tarea();
        tarea.setDescripcion("Descripcion");
        tarea.setFechaCreacion("Fecha Creacion");
        tarea.setIdentificador(1);
        tarea.setVigente(true);
        Optional<Tarea> ofResult = Optional.of(tarea);
        when(tareaRepository.findById(Mockito.<Integer>any())).thenReturn(ofResult);

        // Act
        Tarea actualTarea = tareaServiceImpl.getTarea(1);

        // Assert
        verify(tareaRepository).findById(eq(1));
        assertSame(tarea, actualTarea);
    }

    /**
     * Method under test: {@link TareaServiceImpl#saveTarea(Tarea)}
     */
    @Test
    void testSaveTarea() {
        // Arrange
        Tarea tarea = new Tarea();
        tarea.setDescripcion("Descripcion");
        tarea.setFechaCreacion("Fecha Creacion");
        tarea.setIdentificador(1);
        tarea.setVigente(true);
        when(tareaRepository.save(Mockito.<Tarea>any())).thenReturn(tarea);

        Tarea tarea2 = new Tarea();
        tarea2.setDescripcion("Descripcion");
        tarea2.setFechaCreacion("Fecha Creacion");
        tarea2.setIdentificador(1);
        tarea2.setVigente(true);

        // Act
        Tarea actualSaveTareaResult = tareaServiceImpl.saveTarea(tarea2);

        // Assert
        verify(tareaRepository).save(isA(Tarea.class));
        assertSame(tarea, actualSaveTareaResult);
    }

    /**
     * Method under test: {@link TareaServiceImpl#deleteTarea(int)}
     */
    @Test
    void testDeleteTarea() {
        // Arrange
        doNothing().when(tareaRepository).deleteById(Mockito.<Integer>any());

        // Act
        tareaServiceImpl.deleteTarea(1);

        // Assert that nothing has changed
        verify(tareaRepository).deleteById(eq(1));
    }

    /**
     * Method under test: {@link TareaServiceImpl#updateTarea(Tarea)}
     */
    @Test
    void testUpdateTarea() {
        // Arrange
        Tarea tarea = new Tarea();
        tarea.setDescripcion("Descripcion");
        tarea.setFechaCreacion("Fecha Creacion");
        tarea.setIdentificador(1);
        tarea.setVigente(true);
        when(tareaRepository.save(Mockito.<Tarea>any())).thenReturn(tarea);

        Tarea tarea2 = new Tarea();
        tarea2.setDescripcion("Descripcion");
        tarea2.setFechaCreacion("Fecha Creacion");
        tarea2.setIdentificador(1);
        tarea2.setVigente(true);

        // Act
        Tarea actualUpdateTareaResult = tareaServiceImpl.updateTarea(tarea2);

        // Assert
        verify(tareaRepository).save(isA(Tarea.class));
        assertSame(tarea, actualUpdateTareaResult);
    }
}
