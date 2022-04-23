package com.kruger.test.service;

import com.kruger.test.entity.Empleado;
import com.kruger.test.repository.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class EmpleadoService {
    @Autowired
    private EmpleadoRepository empleadoRepository;

    public Empleado findByCedula(int cedula){
        return empleadoRepository.findById(cedula).orElse(null);
    }

    public void actualizarFechaNacimiento(int cedula, String fecha) throws ParseException {
        Date d;
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        d = sdf.parse(fecha);
        empleadoRepository.findById(cedula).orElse(null).setFechaNacimiento(d);
    }

    public void actualizarDireccion(int cedula, String direccion){
        empleadoRepository.findById(cedula).orElse(null).setDireccion(direccion);
    }
    public void actualizarTelefonoMovil(int cedula, int telefono){
        empleadoRepository.findById(cedula).orElse(null).setTelefonoMovil(telefono);
    }
    public void actualizarEstadoVacunacion(int cedula, boolean vacunado){
        empleadoRepository.findById(cedula).orElse(null).setVacunado(vacunado);
    }
    public void actualizarTipoVacuna(int cedula, String tipoVacuna){
        empleadoRepository.findById(cedula).orElse(null).setTipoVacuna(tipoVacuna);
    }
    public void actualizarFechaVacuna(int cedula, String fechaVacuna) throws ParseException {
        Date d;
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        d = sdf.parse(fechaVacuna);
        empleadoRepository.findById(cedula).orElse(null).setFechaVacuna(d);
    }
    public void actualizarDosis(int cedula, int numDosis){
        empleadoRepository.findById(cedula).orElse(null).setNumeroDosis(numDosis);
    }
}
