package com.mycompany.reto_metadatosimg;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.drew.imaging.ImageMetadataReader;
import com.drew.imaging.ImageProcessingException;
import com.drew.metadata.Directory;
import com.drew.metadata.Metadata;
import com.drew.metadata.Tag;
import com.drew.metadata.exif.ExifSubIFDDirectory;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Guillem
 */
public class App {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        try {
            Scanner e = new Scanner(System.in);
            //String ruta;
            //System.out.println("Introdueix la ruta de la foto");
            File almacen = new File("D:\\SEGON DAM\\AD\\AD-JAVA\\Reto01_MetadatosImg\\Almacent");
            almacen.mkdir();
            File img = new File("D:\\SEGON DAM\\AD\\AD-JAVA\\Reto01_MetadatosImg\\imgAProbar\\proba.jpeg");

            
            Metadata metadata = ImageMetadataReader.readMetadata(img);

            ExifSubIFDDirectory directory2 = metadata.getFirstDirectoryOfType(ExifSubIFDDirectory.class);
            //Tinc un error en la data que no me deixa avançar en el proyecte
            //Date date = directory2.getDate(ExifSubIFDDirectory.TAG_DATETIME_ORIGINAL);
            //System.out.println(date);
            for (Directory directory : metadata.getDirectories()) {
                for (Tag tag : directory.getTags()) {
                    System.out.format("[%s] - %s = %s",
                            directory.getName(), tag.getTagName(), tag.getDescription());
                    String nombre = tag.getTagName();
                    System.out.println(nombre);
                    
                    if (tag.getTagName().contains("Date/Time")) {
                        String data = tag.getDescription();
                        System.out.println(data+"pepe");
                    }
                    
                    if (tag.toString().contains("GPS")) {
                        if (tag.getTagName().contains("GPS Latitude")) {
                            String latitud = tag.getDescription();
                            System.out.println(latitud);
                        }
                        if (tag.toString().contains("GPS")) {
                            if (tag.getTagName().contains("GPS Longitude")) {
                                String longitude = tag.getDescription();
                                System.out.println(longitude);
                            }
                        }

                    }
                    if (directory.hasErrors()) {
                        for (String error : directory.getErrors()) {
                            System.err.format("ERROR: %s", error);
                        }
                    }
                }

            }
            //ExifSubIFDDirectory directory1
              //      = metadata.getFirstDirectoryOfType(ExifSubIFDDirectory.class);
     //       Date date
//                   = directory1.getDate(ExifSubIFDDirectory.TAG_DATETIME_ORIGINAL);
//            File carpetaNova = new File("/almacen/" + date.toString());
//            if (!carpetaNova.exists()) {
//                carpetaNova.mkdir();
//            } else {
//
//                Path origen = FileSystems.getDefault().getPath("D:\\SEGON DAM\\AD\\AD-JAVA\\Reto01_MetadatosImg\\imgAProbar\\Londres.jpg");
//                Path destino = FileSystems.getDefault().getPath("D:\\SEGON DAM\\AD\\AD-JAVA\\Reto01_MetadatosImg\\almacen\\" + date.toString());
//                try {
//                    Files.move(origen, destino, StandardCopyOption.REPLACE_EXISTING);
//                } catch (IOException ioe) {
//                    ioe.printStackTrace();
//                }
//
//            }
//
        } catch (ImageProcessingException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
           Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
    }
//
    }
}
