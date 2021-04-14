/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.archivoObjeto;

import java.util.Scanner;

/**
 *
 * @author usuario
 */
public class PrincipalSeguros {

    public static void main(String[] args) {
        int opc = 0;
        boolean continuar = true;
        OperacionesSeguro obj = new OperacionesSeguro();
        Scanner leer = new Scanner(System.in);
        do {
            System.out.println("       MENU DE OPCIONES         ");
            System.out.println("1. Crear Archivo                ");
            System.out.println("2. Crear Seguro de Vida         ");
            System.out.println("3. Crear Seguro de Accidentes   ");
            System.out.println("4. Mostrar Seguros de Vida      ");
            System.out.println("5. Mostrar Seguros de Accidentes");
            System.out.println("6. Salir                        ");
            System.out.println("----- Digite una opcion --------");
            opc = leer.nextInt();
            switch (opc) {
                case 1:
                    obj.crearArchivoA();
                    obj.crearArchivoV();
                    break;
                case 2:
                    obj.vida();
                    //obj.leerClientesV();
                    obj.guardarObjetosV();
                    break;
                case 3:
                    obj.accidentes();
                    //obj.leerClientesA();
                    obj.guardarObjetosA();
                    break;
                case 4:
                    obj.leerClientesV();
                    obj.mostrarVida();
                    break;
                case 5:
                    obj.leerClientesA();
                    obj.mostrarAccidentes();
                    break;
                default:
                    continuar = false;
                    break;
            }
        } while (continuar);
    }

}
