/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.archivoObjeto;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author usuario
 */
public class OperacionesSeguro {

    List<SeguroAccidentes> listaSeguroAccidentes;
    List<SeguroVida> listaSeguroVida;
    Scanner leer = new Scanner(System.in);

    public OperacionesSeguro() {
        this.listaSeguroAccidentes = new ArrayList<>();
        this.listaSeguroVida = new ArrayList<>();
    }

    //metodos
    //registro de seguros de vida
    public void vida() {
        SeguroVida sv = new SeguroVida();
        sv.registrarSeguro();
        this.listaSeguroVida.add(sv);
        System.out.println("--- REGISTRO COMPLETO V -----");
    }

    //registro de seguros de accidentes
    public void accidentes() {
        SeguroAccidentes sa = new SeguroAccidentes();
        sa.registrarSeguro();
        this.listaSeguroAccidentes.add(sa);
        System.out.println("--- REGISTRO COMPLETO A -----");
    }

    //mostrar seguros de vida
    public void mostrarVida() {
        int sw = 0;
        for (SeguroVida lv : this.listaSeguroVida) {
            lv.mostrarAsegurado();
            System.out.println("*------*");
        }
//        if (sw == 0) {
//            System.out.println("El Asegurado no se encuentra ");
//        }
    }

    // mostrar seguros de accidentes
    public void mostrarAccidentes() {
        int sw = 0;
        for (SeguroAccidentes lva : this.listaSeguroAccidentes) {
            sw = 1;
            lva.mostrarAsegurado();
            lva.fechafinal();

        }
//        if (sw == 0) {
//            System.out.println("El Asegurado no se encuentra ");
//        }
    }

    //CREANDO UN DIRECTORIO
    public void crearDirectorio() {
        Path path = Paths.get("D:\\programacionIIITEST");
        try {
            if (!Files.exists(path)) {
                Files.createDirectory(path);
                System.out.println("directorio creado");
            } else {
                System.out.println("Ya existe el directorio");
            }
        } catch (IOException e) {
        }

    }

    //CREANDO UN ARCHIVO
    public void crearArchivoA() {
        Path path = Paths.get("D:\\programacionIIITEST\\archivoSegurosA.txt");
        try {
            if (!Files.exists(path)) {
                Files.createFile(path);
                System.out.println("El archivo se creo correctamente");
            } else {
                System.out.println("El archivo ya existe");
            }
        } catch (IOException e) {
        }
    }
    public void crearArchivoV() {
        Path path = Paths.get("D:\\programacionIIITEST\\archivoSegurosV.txt");
        try {
            if (!Files.exists(path)) {
                Files.createFile(path);
                System.out.println("El archivo se creo correctamente");
            } else {
                System.out.println("El archivo ya existe");
            }
        } catch (IOException e) {
        }
    }

    //guardando la listacliente dentro del archivo creado con anterioridad
    public void guardarObjetosV() {
        String ruta = "D:\\programacionIIITEST\\archivoSegurosV.txt";
        try {
            FileOutputStream archiv = new FileOutputStream(ruta);
            ObjectOutputStream ooos = new ObjectOutputStream(archiv);
            ooos.writeObject(this.listaSeguroVida);
            ooos.close();
            archiv.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(OperacionesSeguro.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(OperacionesSeguro.class.getName()).log(Level.SEVERE, null, ex);

        }
    }
    public void guardarObjetosA() {
        String ruta = "D:\\programacionIIITEST\\archivoSegurosA.txt";
        try {
            FileOutputStream archi = new FileOutputStream(ruta);
            ObjectOutputStream os = new ObjectOutputStream(archi);
            os.writeObject(this.listaSeguroAccidentes);
            os.close();
            archi.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(OperacionesSeguro.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(OperacionesSeguro.class.getName()).log(Level.SEVERE, null, ex);

        }
    }

    //cargamos los datos del archivo a un list<SeguroAccidentes> 
    public void leerClientesA() {
        String ruta = "D:\\programacionIIITEST\\archivoSegurosA.txt";
        try {
            FileInputStream archivo = new FileInputStream(ruta);
            ObjectInputStream ois = new ObjectInputStream(archivo);
            if (ois != null) {
                this.listaSeguroAccidentes = (List<SeguroAccidentes>) ois.readObject();
            } else {
                System.out.println("El objeto es nulo");
            }
        } catch (FileNotFoundException e) {
            Logger.getLogger(OperacionesSeguro.class.getName()).log(Level.SEVERE, null, e);
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(OperacionesSeguro.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void leerClientesV() {
        String ruta = "D:\\programacionIIITEST\\archivoSegurosV.txt";
        try {
            FileInputStream archivo = new FileInputStream(ruta);
            ObjectInputStream oios = new ObjectInputStream(archivo);
            if (oios != null) {
                this.listaSeguroVida = (List<SeguroVida>) oios.readObject();
            } else {
                System.out.println("El objeto es nulo");
            }
        } catch (FileNotFoundException e) {
            Logger.getLogger(OperacionesSeguro.class.getName()).log(Level.SEVERE, null, e);
        } catch (IOException ex) {
            Logger.getLogger(OperacionesSeguro.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(OperacionesSeguro.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
