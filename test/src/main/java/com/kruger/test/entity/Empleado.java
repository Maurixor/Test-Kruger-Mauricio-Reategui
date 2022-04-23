package com.kruger.test.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "empleados")
@Getter
@Setter
@ToString
public class Empleado {
    //Llenado por Administrador
    @Id
    @Column(name = "cedula")
    private Integer cedula;
    @Column(name = "nombres")
    private String nombres;
    @Column(name = "apellidos")
    private String apellidos;
    @Column(name = "correoelectronico")
    private String correoElectronico;
    //CREATE TABLE empleados(cedula BIGINT PRIMARY KEY, nombres VARCHAR(255), apellidos VARCHAR(255), correoElectronico VARCHAR(255), fechaNacimiento DATE, direccion VARCHAR(255), telefonoMovil BIGINT, vacunado BOOLEAN, tipoVacuna VARCHAR(255), fechaVacuna DATE, numeroDosis BIGINT);
    //INSERT INTO empleados (cedula, nombres, apellidos, correoelectronico) VALUES (1725234403, 'Mauricio', 'Reategui', 'mauricio@hotmail.com');
    //INSERT INTO empleados (cedula, nombres, apellidos, correoelectronico) VALUES (1725234401, 'Carlos Enrique', 'Reategui Tapia', 'carlos@gmail.com');
    //Llenado por Empleado
    @Column(name = "fechanacimiento")
    private Date fechaNacimiento;
    @Column(name = "direccion")
    private String direccion;
    @Column(name = "telefonomovil")
    private Integer telefonoMovil;
    @Column(name = "vacunado")
    private Boolean vacunado;
    //Llenado si está vacunado
    @Column(name = "tipovacuna")
    private String tipoVacuna;
    @Column(name = "fechavacuna")
    private Date fechaVacuna;
    @Column(name = "numerodosis")
    private Integer numeroDosis;

    public Empleado(){}

    public Empleado(int pCedula, String pNombres, String pApellidos, String pCorreo){
        cedula=pCedula;
        nombres=pNombres;
        apellidos=pApellidos;
        correoElectronico=pCorreo;
    }
}

