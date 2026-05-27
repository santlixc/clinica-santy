package com.clinica.santy.clinica.controller;

// =====================================================================
//  PRUEBAS FUNCIONALES - CitaController
//  Materia: Ingeniería de Software
//  Herramientas: JUnit 5 + MockMvc + Mockito
// =====================================================================
//
//  ¿Qué es MockMvc?
//  Es una herramienta de Spring que simula peticiones HTTP (GET, POST,
//  PUT, DELETE) sin necesidad de levantar un servidor real. Perfecta
//  para pruebas funcionales del backend.
//
//  ¿Qué es Mockito?
//  Es una librería que nos permite crear "dobles" del servicio (mocks),
//  para que las pruebas no dependan de la base de datos real.
// =====================================================================

import com.clinica.santy.clinica.entity.Cita;
import com.clinica.santy.clinica.service.CitaService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

// @WebMvcTest: le dice a Spring que solo cargue la capa web del controller
// No levanta toda la aplicación, solo lo necesario para probar el controller
@WebMvcTest(CitaController.class)
public class CitaControllerTest {

    // MockMvc nos permite simular peticiones HTTP en las pruebas
    @Autowired
    private MockMvc mockMvc;

    // @MockBean: crea un "doble" del servicio para no usar la BD real
    @MockBean
    private CitaService citaService;

    // ObjectMapper convierte objetos Java a JSON y viceversa
    private ObjectMapper objectMapper;

    // Objetos de prueba que reutilizaremos en varios tests
    private Cita citaValida;
    private Cita citaActualizada;

    // @BeforeEach: este método se ejecuta ANTES de cada prueba
    // Aquí preparamos los datos de prueba
    @BeforeEach
    void setUp() {
        objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule()); // Necesario para LocalDateTime

        // Cita de ejemplo que usaremos en las pruebas
        citaValida = new Cita(
            1,                                          // idPaciente
            2,                                          // idMedico
            3,                                          // idFranja
            LocalDateTime.of(2025, 6, 1, 10, 0),       // fechaCreacion
            LocalDateTime.of(2025, 6, 15, 9, 0),       // fechaProgramada
            1,                                          // idEstadoCita (1 = Pendiente)
            "Dolor de cabeza frecuente"                 // motivo
        );
        citaValida.setIdCita(1);

        // Cita con datos modificados para la prueba de actualización
        citaActualizada = new Cita(
            1,
            2,
            3,
            LocalDateTime.of(2025, 6, 1, 10, 0),
            LocalDateTime.of(2025, 6, 20, 14, 0),      // fecha cambiada
            2,                                          // idEstadoCita (2 = Confirmada)
            "Dolor de cabeza y mareos"                  // motivo actualizado
        );
        citaActualizada.setIdCita(1);
    }


    // =================================================================
    //  PRUEBA 1: Obtener todas las citas (caso exitoso)
    //  Endpoint: GET /api/citas
    // =================================================================
    @Test
    @DisplayName("CP-01: Obtener lista de todas las citas exitosamente")
    void testGetAllCitas_RetornaListaExitosamente() throws Exception {

        // ARRANGE (preparar): definimos qué debe devolver el servicio mock
        List<Cita> listaCitas = Arrays.asList(citaValida);
        when(citaService.findAll()).thenReturn(listaCitas);

        // ACT + ASSERT (ejecutar y verificar): hacemos la petición y verificamos
        mockMvc.perform(get("/api/citas")
                .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())                     // Esperamos HTTP 200
            .andExpect(jsonPath("$.length()").value(1))     // Esperamos 1 elemento
            .andExpect(jsonPath("$[0].idCita").value(1))    // El primer elemento tiene idCita=1
            .andExpect(jsonPath("$[0].motivo").value("Dolor de cabeza frecuente"));

        // Verificamos que el servicio fue llamado exactamente 1 vez
        verify(citaService, times(1)).findAll();
    }


    // =================================================================
    //  PRUEBA 2: Obtener cita por ID (caso exitoso)
    //  Endpoint: GET /api/citas/{id}
    // =================================================================
    @Test
    @DisplayName("CP-02: Obtener cita por ID existente - debe retornar la cita")
    void testGetCitaById_IdExistente_RetornaCita() throws Exception {

        // ARRANGE
        when(citaService.findById(1)).thenReturn(Optional.of(citaValida));

        // ACT + ASSERT
        mockMvc.perform(get("/api/citas/1"))
            .andExpect(status().isOk())                                      // HTTP 200
            .andExpect(jsonPath("$.idCita").value(1))
            .andExpect(jsonPath("$.idPaciente").value(1))
            .andExpect(jsonPath("$.idMedico").value(2))
            .andExpect(jsonPath("$.motivo").value("Dolor de cabeza frecuente"));
    }


    // =================================================================
    //  PRUEBA 3: Obtener cita por ID (caso de error - ID no existe)
    //  Endpoint: GET /api/citas/{id}
    // =================================================================
    @Test
    @DisplayName("CP-03: Obtener cita por ID inexistente - debe retornar 404")
    void testGetCitaById_IdInexistente_Retorna404() throws Exception {

        // ARRANGE: el servicio devuelve vacío (ID no existe)
        when(citaService.findById(999)).thenReturn(Optional.empty());

        // ACT + ASSERT
        mockMvc.perform(get("/api/citas/999"))
            .andExpect(status().isNotFound()); // Esperamos HTTP 404
    }


    // =================================================================
    //  PRUEBA 4: Crear una nueva cita (caso exitoso)
    //  Endpoint: POST /api/citas
    // =================================================================
    @Test
    @DisplayName("CP-04: Crear nueva cita con datos válidos - debe retornar cita creada")
    void testCreateCita_DatosValidos_RetornaCitaCreada() throws Exception {

        // ARRANGE
        when(citaService.save(any(Cita.class))).thenReturn(citaValida);

        // Convertimos el objeto Java a JSON para enviarlo en el cuerpo de la petición
        String citaJson = objectMapper.writeValueAsString(citaValida);

        // ACT + ASSERT
        mockMvc.perform(post("/api/citas")
                .contentType(MediaType.APPLICATION_JSON)
                .content(citaJson))
            .andExpect(status().isOk())                          // HTTP 200
            .andExpect(jsonPath("$.idCita").value(1))
            .andExpect(jsonPath("$.idPaciente").value(1))
            .andExpect(jsonPath("$.motivo").value("Dolor de cabeza frecuente"));

        // Verificamos que el servicio guardó exactamente 1 vez
        verify(citaService, times(1)).save(any(Cita.class));
    }


    // =================================================================
    //  PRUEBA 5: Actualizar una cita existente (caso exitoso)
    //  Endpoint: PUT /api/citas/{id}
    // =================================================================
    @Test
    @DisplayName("CP-05: Actualizar cita existente - debe retornar cita actualizada")
    void testUpdateCita_IdExistente_RetornaCitaActualizada() throws Exception {

        // ARRANGE
        when(citaService.findById(1)).thenReturn(Optional.of(citaValida));
        when(citaService.save(any(Cita.class))).thenReturn(citaActualizada);

        String citaActualizadaJson = objectMapper.writeValueAsString(citaActualizada);

        // ACT + ASSERT
        mockMvc.perform(put("/api/citas/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(citaActualizadaJson))
            .andExpect(status().isOk())                              // HTTP 200
            .andExpect(jsonPath("$.idEstadoCita").value(2))          // Estado actualizado
            .andExpect(jsonPath("$.motivo").value("Dolor de cabeza y mareos")); // Motivo actualizado
    }


    // =================================================================
    //  PRUEBA 6: Actualizar una cita que no existe (caso de error)
    //  Endpoint: PUT /api/citas/{id}
    // =================================================================
    @Test
    @DisplayName("CP-06: Actualizar cita inexistente - debe retornar 404")
    void testUpdateCita_IdInexistente_Retorna404() throws Exception {

        // ARRANGE: la cita con ID 999 no existe
        when(citaService.findById(999)).thenReturn(Optional.empty());

        String citaJson = objectMapper.writeValueAsString(citaValida);

        // ACT + ASSERT
        mockMvc.perform(put("/api/citas/999")
                .contentType(MediaType.APPLICATION_JSON)
                .content(citaJson))
            .andExpect(status().isNotFound()); // HTTP 404
    }


    // =================================================================
    //  PRUEBA 7: Eliminar una cita existente (caso exitoso)
    //  Endpoint: DELETE /api/citas/{id}
    // =================================================================
    @Test
    @DisplayName("CP-07: Eliminar cita existente - debe retornar 204 No Content")
    void testDeleteCita_IdExistente_Retorna204() throws Exception {

        // ARRANGE
        when(citaService.findById(1)).thenReturn(Optional.of(citaValida));
        doNothing().when(citaService).deleteById(1); // deleteById no retorna nada (void)

        // ACT + ASSERT
        mockMvc.perform(delete("/api/citas/1"))
            .andExpect(status().isNoContent()); // HTTP 204

        // Verificamos que sí se llamó el método de eliminar
        verify(citaService, times(1)).deleteById(1);
    }


    // =================================================================
    //  PRUEBA 8: Eliminar una cita que no existe (caso de error)
    //  Endpoint: DELETE /api/citas/{id}
    // =================================================================
    @Test
    @DisplayName("CP-08: Eliminar cita inexistente - debe retornar 404")
    void testDeleteCita_IdInexistente_Retorna404() throws Exception {

        // ARRANGE
        when(citaService.findById(999)).thenReturn(Optional.empty());

        // ACT + ASSERT
        mockMvc.perform(delete("/api/citas/999"))
            .andExpect(status().isNotFound()); // HTTP 404

        // Verificamos que deleteById NUNCA fue llamado (no debería eliminar nada)
        verify(citaService, never()).deleteById(999);
    }
}
