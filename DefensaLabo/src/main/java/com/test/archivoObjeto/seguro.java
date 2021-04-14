/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.archivoObjeto;

import java.io.Serializable;
import java.util.Scanner;

/**
 *
 * @author usuario
 */
public class seguro implements Serializable {

    static final long serialVersionUID = 43L;
    
    //atributos
    private String nombreAsegurado;
    private String montoAsegurado;
    private String fechainicio;

    //metodos
    public void mostrarAsegurado() {
        System.out.println("Nombre: " + this.nombreAsegurado);
        System.out.println("Paterno: " + this.montoAsegurado);
        System.out.println("Materno: " + this.fechainicio);
    }
    public void registrarSeguro(){
        Scanner r= new Scanner(System.in);
        System.out.println("Ingrese nombre del Asegurado");
        this.nombreAsegurado=r.nextLine();
        System.out.println("Ingrese monto del Seguro");
        this.montoAsegurado=r.nextLine();
        System.out.println("Ingrese fecha de inicio");
        this.fechainicio=r.nextLine();
        
    }

    public String getNombreAsegurado() {
        return nombreAsegurado;
    }

    public void setNombreAsegurado(String nombreAsegurado) {
        this.nombreAsegurado = nombreAsegurado;
    }

    public String getMontoAsegurado() {
        return montoAsegurado;
    }

    public void setMontoAsegurado(String montoAsegurado) {
        this.montoAsegurado = montoAsegurado;
    }

    public String getFechainicio() {
        return fechainicio;
    }

    public void setFechainicio(String fechainicio) {
        this.fechainicio = fechainicio;
    }

}
