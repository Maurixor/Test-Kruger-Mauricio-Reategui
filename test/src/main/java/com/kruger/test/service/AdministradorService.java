package com.kruger.test.service;

import com.kruger.test.entity.Empleado;
import com.kruger.test.repository.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Objects;

@Service
public class AdministradorService {
    @Autowired
    private EmpleadoRepository empleadoRepository;

    public List<Empleado> encontrarTodosEmpleados(){
        return (List<Empleado>)empleadoRepository.findAll();
    }

    public boolean agregarEmpleado(int cedula, String nombres, String apellidos, String correo){
        boolean canAddEmployee=true;

        if(Integer.valueOf(cedula) == null || nombres==null || apellidos==null || correo==null){
            canAddEmployee=false;
        }
        if(String.valueOf(cedula).toCharArray().length!=10 && empleadoRepository.findById(cedula).orElse(null)==null){
            canAddEmployee=false;
        }
        if(!correo.contains("@")){
            canAddEmployee=false;
        }
        for (int i = 0; i < nombres.length(); i++)
        {
            char caracter = nombres.toUpperCase().charAt(i);
            int valorASCII = (int)caracter;
            if (valorASCII != 165 && (valorASCII < 65 || valorASCII > 90))
                canAddEmployee=false;
        }
        for (int i = 0; i < apellidos.length(); i++)
        {
            char caracter = apellidos.toUpperCase().charAt(i);
            int valorASCII = (int)caracter;
            if (valorASCII != 165 && (valorASCII < 65 || valorASCII > 90))
                canAddEmployee=false;
        }

        if(canAddEmployee){
            Empleado e = new Empleado(cedula,nombres,apellidos,correo);
            empleadoRepository.save(e);
        }

        return canAddEmployee;
    }
    public boolean editarEmpleado(int cedula, String nombres, String apellidos, String correo){
        boolean empleadoEditado=true;

        if(Integer.valueOf(cedula) == null || nombres==null || apellidos==null || correo==null){
            empleadoEditado=false;
        }
        if(String.valueOf(cedula).toCharArray().length!=10 && empleadoRepository.findById(cedula).orElse(null)==null){
            empleadoEditado=false;
        }
        if(!correo.contains("@")){
            empleadoEditado=false;
        }
        for (int i = 0; i < nombres.length(); i++)
        {
            char caracter = nombres.toUpperCase().charAt(i);
            int valorASCII = (int)caracter;
            if (valorASCII != 165 && (valorASCII < 65 || valorASCII > 90))
                empleadoEditado=false;
        }
        for (int i = 0; i < apellidos.length(); i++)
        {
            char caracter = apellidos.toUpperCase().charAt(i);
            int valorASCII = (int)caracter;
            if (valorASCII != 165 && (valorASCII < 65 || valorASCII > 90))
                empleadoEditado=false;
        }
        if(empleadoEditado){
            empleadoRepository.findById(cedula).orElse(null).setNombres(nombres);
            empleadoRepository.findById(cedula).orElse(null).setApellidos(apellidos);
            empleadoRepository.findById(cedula).orElse(null).setCorreoElectronico(correo);
        }

        return empleadoEditado;
    }

    public boolean eliminarEmpleado(int cedula){
        boolean canDelete=true;
        if(empleadoRepository.findById(cedula).orElse(null)==null){
            canDelete=false;
        }else {
            empleadoRepository.deleteById(cedula);
        }
        return canDelete;
    }

    public List<Empleado> filtrarPorEstadoVacunacion(boolean estado){
        List<Empleado> empleados = (List<Empleado>)empleadoRepository.findAll();
        for(int i=0; i<empleados.size(); i++){
            if(empleados.get(i).getVacunado()!=estado){
                empleados.remove(i);
            }
        }

        return empleados;
    }

    public List<Empleado> filtrarPorTipoVacuna(String tipoVacuna){
        List<Empleado> empleados = (List<Empleado>)empleadoRepository.findAll();
        for(int i=0; i<empleados.size(); i++){
            if(!Objects.equals(empleados.get(i).getTipoVacuna(), tipoVacuna)){
                empleados.remove(i);
            }
        }

        return empleados;
    }

    public List<Empleado> filtrarPorRangoFechaVacunacion(Date date1, Date date2){
        List<Empleado> empleados = (List<Empleado>)empleadoRepository.findAll();
        for(int i=0; i<empleados.size(); i++){
            if(empleados.get(i).getFechaVacuna().before(date1) || empleados.get(i).getFechaVacuna().after(date2)){
                empleados.remove(i);
            }
        }

        return empleados;
    }
}
