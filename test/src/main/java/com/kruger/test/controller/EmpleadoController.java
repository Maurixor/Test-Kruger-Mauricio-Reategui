package com.kruger.test.controller;

import com.kruger.test.entity.Empleado;
import com.kruger.test.service.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.text.ParseException;

@RestController
public class EmpleadoController {
    @Autowired
    private EmpleadoService empleadoService;

    @GetMapping("/empleado/login/{cedula}")
    public Empleado loginEmpleado(@PathVariable int cedula){
        return empleadoService.findByCedula(cedula);
    }

    @GetMapping("/empleado/updateCumpleaños/{cedula}/{cumpleaños}")
    public String updateCumpleaños(@PathVariable int cedula, @PathVariable String cumpleaños) throws ParseException {
        empleadoService.actualizarFechaNacimiento(cedula, cumpleaños);
        return "Cumpleaños de "+cedula+" actualizado por "+cumpleaños;
    }

    @GetMapping("/empleado/updateDireccion/{cedula}/{direccion}")
    public String updateDireccion(@PathVariable int cedula, @PathVariable String direccion){
        empleadoService.actualizarDireccion(cedula, direccion);
        return "Dirección de "+cedula+" actualizado por "+direccion;
    }

    @GetMapping("/empleado/updateTelefono/{cedula}/{telefono}")
    public String updateTelefono(@PathVariable int cedula, @PathVariable int telefono){
        empleadoService.actualizarTelefonoMovil(cedula, telefono);
        return "Teléfono móvil de "+cedula+" actualizado por "+telefono;
    }

    @GetMapping("/empleado/updateEstadoVacunacion/{cedula}/{estado}")
    public String updateEstadoVacunacion(@PathVariable int cedula, @PathVariable boolean estado){
        empleadoService.actualizarEstadoVacunacion(cedula, estado);
        return "Estado de vacunación de "+cedula+" actualizado por "+estado;
    }

    @GetMapping("/empleado/updateTipoVacuna/{cedula}/{tipoVacuna}")
    public String updateTipoVacuna(@PathVariable int cedula, @PathVariable String tipoVacuna){
        empleadoService.actualizarTipoVacuna(cedula, tipoVacuna);
        return "Tipo de vacuna de "+cedula+" actualizado por "+tipoVacuna;
    }

    @GetMapping("/empleado/updateFechaVacuna/{cedula}/{fechaVacuna}")
    public String updateFechhaVacuna(@PathVariable int cedula, @PathVariable String fechaVacuna) throws ParseException {
        empleadoService.actualizarFechaVacuna(cedula, fechaVacuna);
        return "Fecha de vacunación de "+cedula+" actualizado por "+fechaVacuna;
    }

    @GetMapping("/empleado/updateNumDosis/{cedula}/{numDosis}")
    public String updateNumDosis(@PathVariable int cedula, @PathVariable int numDosis){
        empleadoService.actualizarDosis(cedula, numDosis);
        return "Número de dosis de "+cedula+" actualizado por "+numDosis;
    }
}
