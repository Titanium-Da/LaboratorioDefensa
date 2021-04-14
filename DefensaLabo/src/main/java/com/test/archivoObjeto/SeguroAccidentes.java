/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.archivoObjeto;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

/**
 *
 * @author usuario
 */
public class SeguroAccidentes extends seguro  implements Serializable{
    static final long serialVersionUID = 45L;
    
    //atributos
    private double pagoSeguro;
    
    //metodos
    @Override
    public void registrarSeguro(){
        Scanner sc=new Scanner(System.in);
        super.registrarSeguro();
        System.out.println("Ingrese pago del seguro");
        this.pagoSeguro=sc.nextDouble();
    }
    
    @Override
    public void mostrarAsegurado(){
        super.mostrarAsegurado();
        System.out.println("Pago Seguro: "+this.pagoSeguro);
    }
    public void fechafinal(){
        mostrarAsegurado();
        //Definiendo el formato de la fecha
        DateTimeFormatter format=DateTimeFormatter.ofPattern("dd/MM/yyyy");
        //parseando la fecha de ingreso
        String fec=super.getFechainicio();
        LocalDate fi= LocalDate.parse(fec,format);
        //parseando fecha final
        LocalDate ff = fi.plusYears(1);
        System.out.println("Vigencia Seguro "+ff);
    }
    //getter y setter

    public double getPagoSeguro() {
        return pagoSeguro;
    }

    public void setPagoSeguro(double pagoSeguro) {
        this.pagoSeguro = pagoSeguro;
    }
    
}
