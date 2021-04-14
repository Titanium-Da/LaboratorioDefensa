/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.archivoObjeto;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

/**
 *
 * @author usuario
 */
public class SeguroVida extends seguro implements Serializable{
    static final long serialVersionUID = 44L;
    
    //atributos
    private String fechafinal;
    private String nombreBeneficiario;
    private int CostoSeguro;
    private float cuota;
    //implementos del seguro
    private seguro seguro;
    long antiguedad;
    //metodos   
    @Override
    public void registrarSeguro(){
        Scanner sc=new Scanner(System.in);
        super.registrarSeguro();
        System.out.println("Ingrese la fecha final");
        this.fechafinal=sc.nextLine();
        System.out.println("Ingrese nombre del Beneficiario");
        this.nombreBeneficiario=sc.nextLine();
        System.out.println("Ingrese costo del seguro");
        this.CostoSeguro=sc.nextInt();
        sc.nextLine();
        
    }
    
    public long antiguedad(){
        //Definiendo el formato de la fecha
        DateTimeFormatter format=DateTimeFormatter.ofPattern("dd/MM/yyyy");
        //parseando fecha final
        LocalDate ff = LocalDate.parse(this.fechafinal, format);
        //parseando la fecha de ingreso
        String fec=super.getFechainicio();
        LocalDate fi= LocalDate.parse(fec,format);
        //diferencia de años
        antiguedad=ChronoUnit.MONTHS.between(fi, ff);
        return antiguedad;
    }
    
    @Override
    public void mostrarAsegurado(){
        super.mostrarAsegurado();
        System.out.println("Fecha final: "+this.fechafinal);
        System.out.println("Beneficiario :"+this.nombreBeneficiario);
        System.out.println("Costo Seguro :"+this.CostoSeguro);
        cuota=this.CostoSeguro/this.antiguedad;
        System.out.println("Cuota Mensual   :"+cuota);
    }
    
//    public void cuotaMensual(){
//        
//        
//        
//    }

    public String getFechafinal() {
        return fechafinal;
    }

    public void setFechafinal(String fechafinal) {
        this.fechafinal = fechafinal;
    }

    public String getNombreBeneficiario() {
        return nombreBeneficiario;
    }

    public void setNombreBeneficiario(String nombreBeneficiario) {
        this.nombreBeneficiario = nombreBeneficiario;
    }

    public int getCostoSeguro() {
        return CostoSeguro;
    }

    public void setCostoSeguro(int CostoSeguro) {
        this.CostoSeguro = CostoSeguro;
    }

    public seguro getSeguro() {
        return seguro;
    }

    public void setSeguro(seguro seguro) {
        this.seguro = seguro;
    }
    
}
