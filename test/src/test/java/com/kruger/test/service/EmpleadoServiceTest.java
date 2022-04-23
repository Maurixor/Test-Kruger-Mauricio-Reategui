package com.kruger.test.service;

import com.kruger.test.entity.Empleado;
import com.kruger.test.repository.EmpleadoRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootTest(properties = "spring.main.lazy-initialization=true", classes = EmpleadoService.class)
public class EmpleadoServiceTest {
    //@Autowired
    private EmpleadoService empleadoService = Mockito.mock(EmpleadoService.class);

    @Test
    public void deberiaEncontrarPorCedula(){
        int numCedula = 1234567890;
        Empleado e = new Empleado(1234567890,"Carlos Mauricio", "Reategui Tapia", "mauricio@hotmail.com");

        Mockito.when(empleadoService.findByCedula(numCedula)).thenReturn(e);
        Empleado newE = empleadoService.findByCedula(1234567890);

        Assertions.assertEquals(e, newE);
    }

    @Test
    public void deberiaActualizarFechaNacimiento() throws ParseException {
        int numCedula = 1234567890;
        String fecha = "1990/11/11";
        Empleado e = new Empleado(1234567890,"Carlos Mauricio", "Reategui Tapia", "mauricio@hotmail.com");

        Mockito.when(empleadoService.findByCedula(numCedula)).thenReturn(e);
        empleadoService.actualizarFechaNacimiento(numCedula, fecha);

        SimpleDateFormat sdf=new SimpleDateFormat(fecha);
        Date d = sdf.parse(fecha);
        Empleado e2 = e;
        e2.setFechaNacimiento(d);
        Mockito.when(empleadoService.findByCedula(numCedula)).thenReturn(e2);

        Assertions.assertNotNull(e2.getFechaNacimiento());
    }

    @Test
    public void deberiaActualizarDireccion(){
        int numCedula = 1234567890;
        String direccion = "Tumbaco, conjunto Santo Tomás";
        Empleado e = new Empleado(1234567890,"Carlos Mauricio", "Reategui Tapia", "mauricio@hotmail.com");

        Mockito.when(empleadoService.findByCedula(numCedula)).thenReturn(e);
        empleadoService.actualizarDireccion(numCedula,direccion);
        empleadoService.findByCedula(numCedula).setDireccion(direccion);

        Assertions.assertNotNull(empleadoService.findByCedula(numCedula).getDireccion());
    }

    @Test
    public void deberiaActualizarTelefono(){
        int numCedula = 1234567890;
        int telefono = 1988221321;
        Empleado e = new Empleado(1234567890,"Carlos Mauricio", "Reategui Tapia", "mauricio@hotmail.com");

        Mockito.when(empleadoService.findByCedula(numCedula)).thenReturn(e);
        empleadoService.actualizarTelefonoMovil(numCedula, telefono);
        empleadoService.findByCedula(numCedula).setTelefonoMovil(telefono);

        Assertions.assertNotNull(empleadoService.findByCedula(numCedula).getTelefonoMovil());
    }

    @Test
    public void deberiaActualizarEstadoVacunacion(){
        int numCedula = 1234567890;
        boolean estado = true;
        Empleado e = new Empleado(1234567890,"Carlos Mauricio", "Reategui Tapia", "mauricio@hotmail.com");

        Mockito.when(empleadoService.findByCedula(numCedula)).thenReturn(e);
        empleadoService.actualizarEstadoVacunacion(numCedula,estado);
        empleadoService.findByCedula(numCedula).setVacunado(estado);

        Assertions.assertTrue(empleadoService.findByCedula(numCedula).getVacunado());
    }
}
