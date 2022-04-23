package com.kruger.test.controller;

import com.kruger.test.entity.Empleado;
import com.kruger.test.service.AdministradorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
public class AdministradorController {
    @Autowired
    AdministradorService administradorService;

    @GetMapping("/Administrador/listarEmpleados")
    public List<Empleado> agregarEmpleado(){
        return administradorService.encontrarTodosEmpleados();
    }

    @GetMapping("/Administrador/agregarEmpleado/{cedula}/{nombres}/{apellidos}/{correo}")
    public String agregarEmpleado(@PathVariable int cedula, @PathVariable String nombres, @PathVariable String apellidos, @PathVariable String correo){
        return "Empleado fue agregado exitosamente: "+administradorService.agregarEmpleado(cedula,nombres,apellidos,correo);
    }

    @GetMapping("/Administrador/editarEmpleado/{cedula}/{nombres}/{apellidos}/{correo}")
    public String editarEmpleado(@PathVariable int cedula, @PathVariable String nombres, @PathVariable String apellidos, @PathVariable String correo){
        return "Empleado fue editado exitosamente: "+administradorService.editarEmpleado(cedula,nombres,apellidos,correo);
    }

    @GetMapping("/Administrador/eliminarEmpleado/{cedula}")
    public String eliminarEmpleado(@PathVariable int cedula){
        return "Empleado fue eliminado exitosamente: "+administradorService.eliminarEmpleado(cedula);
    }

    @GetMapping("/Administrador/filtrarPorEstadoVacunacion/{estado}")
    public List<Empleado> filtrarPorEstadoVacunacion(@PathVariable boolean estado){
        return administradorService.filtrarPorEstadoVacunacion(estado);
    }

    @GetMapping("/Administrador/filtrarPorTipoVacuna/{tipo}")
    public List<Empleado> filtrarPorTipoVacuna(@PathVariable String tipo){
        return administradorService.filtrarPorTipoVacuna(tipo);
    }

    @GetMapping("/Administrador/filtrarPorRangoFechaVacunacion/{fecha1}/{fecha2}")
    public List<Empleado> filtrarPorRangoFechaVacunacion(@PathVariable Date fecha1, @PathVariable Date fecha2){
        return administradorService.filtrarPorRangoFechaVacunacion(fecha1,fecha2);
    }

}
