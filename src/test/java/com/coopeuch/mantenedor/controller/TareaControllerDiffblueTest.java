package com.coopeuch.mantenedor.controller;

import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import com.coopeuch.mantenedor.entity.Tarea;
import com.coopeuch.mantenedor.service.impl.TareaService;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {TareaController.class})
@ExtendWith(SpringExtension.class)
@DisabledInAotMode
class TareaControllerDiffblueTest {
    @Autowired
    private TareaController tareaController;

    @MockBean
    private TareaService tareaService;

    /**
     * Method under test: {@link TareaController#create(Tarea)}
     */
    @Test
    void testCreate() throws Exception {
        // Arrange
        Tarea tarea = new Tarea();
        tarea.setDescripcion("Descripcion");
        tarea.setFechaCreacion("Fecha Creacion");
        tarea.setIdentificador(1);
        tarea.setVigente(true);
        when(tareaService.saveTarea(Mockito.<Tarea>any())).thenReturn(tarea);

        Tarea tarea2 = new Tarea();
        tarea2.setDescripcion("Descripcion");
        tarea2.setFechaCreacion("Fecha Creacion");
        tarea2.setIdentificador(1);
        tarea2.setVigente(true);
        String content = (new ObjectMapper()).writeValueAsString(tarea2);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/tarea/crear")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);

        // Act and Assert
        MockMvcBuilders.standaloneSetup(tareaController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"identificador\":1,\"descripcion\":\"Descripcion\",\"fechaCreacion\":\"Fecha Creacion\",\"vigente\":true}"));
    }

    /**
     * Method under test: {@link TareaController#delete(int)}
     */
    @Test
    void testDelete() throws Exception {
        // Arrange
        doNothing().when(tareaService).deleteTarea(anyInt());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/api/tarea/borrar/{id}", 1);

        // Act and Assert
        MockMvcBuilders.standaloneSetup(tareaController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    /**
     * Method under test: {@link TareaController#delete(int)}
     */
    @Test
    void testDelete2() throws Exception {
        // Arrange
        doNothing().when(tareaService).deleteTarea(anyInt());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/api/tarea/borrar/{id}", 1);
        requestBuilder.contentType("https://example.org/example");

        // Act and Assert
        MockMvcBuilders.standaloneSetup(tareaController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    /**
     * Method under test: {@link TareaController#getById(int)}
     */
    @Test
    void testGetById() throws Exception {
        // Arrange
        Tarea tarea = new Tarea();
        tarea.setDescripcion("Descripcion");
        tarea.setFechaCreacion("Fecha Creacion");
        tarea.setIdentificador(1);
        tarea.setVigente(true);
        when(tareaService.getTarea(anyInt())).thenReturn(tarea);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/tarea/buscar/{id}", 1);

        // Act and Assert
        MockMvcBuilders.standaloneSetup(tareaController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"identificador\":1,\"descripcion\":\"Descripcion\",\"fechaCreacion\":\"Fecha Creacion\",\"vigente\":true}"));
    }

    /**
     * Method under test: {@link TareaController#listar()}
     */
    @Test
    void testListar() throws Exception {
        // Arrange
        when(tareaService.listAllTareas()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/tarea/listar");

        // Act and Assert
        MockMvcBuilders.standaloneSetup(tareaController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link TareaController#update(Tarea)}
     */
    @Test
    void testUpdate() throws Exception {
        // Arrange
        Tarea tarea = new Tarea();
        tarea.setDescripcion("Descripcion");
        tarea.setFechaCreacion("Fecha Creacion");
        tarea.setIdentificador(1);
        tarea.setVigente(true);
        when(tareaService.updateTarea(Mockito.<Tarea>any())).thenReturn(tarea);

        Tarea tarea2 = new Tarea();
        tarea2.setDescripcion("Descripcion");
        tarea2.setFechaCreacion("Fecha Creacion");
        tarea2.setIdentificador(1);
        tarea2.setVigente(true);
        String content = (new ObjectMapper()).writeValueAsString(tarea2);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.put("/api/tarea/actualizar")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);

        // Act and Assert
        MockMvcBuilders.standaloneSetup(tareaController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"identificador\":1,\"descripcion\":\"Descripcion\",\"fechaCreacion\":\"Fecha Creacion\",\"vigente\":true}"));
    }
}
