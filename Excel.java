package com.mycompany.app;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
/**
 *
 * @author decodigo
 */
public class Excel {

   public static ObservableList<Usuario>  excelUsuario() {
       ObservableList<Usuario> lista = FXCollections.observableArrayList();
       try {
           String rutaArchivoExcel = "C:\\Users\\Giovanna Rodriguez\\Desktop\\PRACTICAS\\proyecto final\\Biblioteca\\src\\main\\resources\\BD\\Usuarios.xlsx";
           FileInputStream inputStream = new FileInputStream(new File(rutaArchivoExcel));
           Workbook workbook = new XSSFWorkbook(inputStream);
           Sheet firstSheet = workbook.getSheetAt(0);
           Iterator<Row> iterator = firstSheet.iterator();
           int i = 0;
           String Fila[] = new String[5];
           String contenidoCelda = new String();
           DataFormatter formatter = new DataFormatter();
           while (iterator.hasNext()) {
               Row nextRow = iterator.next();

               Iterator<Cell> cellIterator = nextRow.cellIterator();
               while (cellIterator.hasNext()) {
                   Cell cell = cellIterator.next();
                   contenidoCelda = formatter.formatCellValue(cell);
                   Fila[i] = contenidoCelda;
                   i++;
                   if (i == 5) {
                       System.out.println(Arrays.toString(Fila));
                       lista.add(new Usuario(Fila[0], Fila[1], Fila[2], Fila[3], Fila[4]));
                       i = 0;
                   }
               }

           }
       } catch (Exception e) {
           System.out.println("Error.");
           e.printStackTrace();
       }
       return lista;
   }
       public static ObservableList<Libro>  excelLibro(){
           ObservableList<Libro> lista= FXCollections.observableArrayList();
           try {
               String rutaArchivoExcel = "C:\\Users\\Giovanna Rodriguez\\Desktop\\PRACTICAS\\proyecto final\\Biblioteca\\src\\main\\resources\\BD\\Libros.xlsx";
               FileInputStream inputStream = new FileInputStream(new File(rutaArchivoExcel));
               Workbook workbook = new XSSFWorkbook(inputStream);
               Sheet firstSheet = workbook.getSheetAt(0);
               Iterator<Row> iterator = firstSheet.iterator();
               int i=0;
               String Fila[]=new String[6];
               String contenidoCelda= new String();
               DataFormatter formatter = new DataFormatter();
               while (iterator.hasNext()) {
                   Row nextRow = iterator.next();

                   Iterator<Cell> cellIterator = nextRow.cellIterator();
                   while(cellIterator.hasNext()) {
                       Cell cell = cellIterator.next();
                       contenidoCelda = formatter.formatCellValue(cell);
                       Fila[i]=contenidoCelda;
                       i++;
                       if(i==6) {
                           System.out.println(Arrays.toString(Fila));
                           lista.add(new Libro(Fila[0], Fila[1], Fila[2], Fila[3], Fila[4],Fila[5]));
                           i=0;
                       }
                   }

               }
           } catch (Exception e) {
               System.out.println("Error.");
               e.printStackTrace();
           }
           return lista;
       }
       public static ObservableList<Tesis>  excelTesis(){
           ObservableList<Tesis> lista= FXCollections.observableArrayList();
           try {
               String rutaArchivoExcel = "C:\\Users\\Giovanna Rodriguez\\Desktop\\PRACTICAS\\proyecto final\\Biblioteca\\src\\main\\resources\\BD\\Tesis.xlsx";
               FileInputStream inputStream = new FileInputStream(new File(rutaArchivoExcel));
               Workbook workbook = new XSSFWorkbook(inputStream);
               Sheet firstSheet = workbook.getSheetAt(0);
               Iterator<Row> iterator = firstSheet.iterator();
               int i=0;
               String Fila[]=new String[6];
               String contenidoCelda= new String();
               DataFormatter formatter = new DataFormatter();
               while (iterator.hasNext()) {
                   Row nextRow = iterator.next();

                   Iterator<Cell> cellIterator = nextRow.cellIterator();
                   while(cellIterator.hasNext()) {
                       Cell cell = cellIterator.next();
                       contenidoCelda = formatter.formatCellValue(cell);
                       Fila[i]=contenidoCelda;
                       i++;
                       if(i==6) {
                           System.out.println(Arrays.toString(Fila));
                           lista.add(new Tesis(Fila[0], Fila[1], Fila[2], Fila[3], Fila[4], Fila[5]));
                           i=0;
                       }
                   }

               }
           } catch (Exception e) {
               System.out.println("Error.");
               e.printStackTrace();
           }
           return lista;
       }
       public static ObservableList<Revista>  excelRev(){
           ObservableList<Revista> lista= FXCollections.observableArrayList();
           try {
               String rutaArchivoExcel = "C:\\Users\\Giovanna Rodriguez\\Desktop\\PRACTICAS\\proyecto final\\Biblioteca\\src\\main\\resources\\BD\\Revista.xlsx";
               FileInputStream inputStream = new FileInputStream(new File(rutaArchivoExcel));
               Workbook workbook = new XSSFWorkbook(inputStream);
               Sheet firstSheet = workbook.getSheetAt(0);
               Iterator<Row> iterator = firstSheet.iterator();
               int i=0;
               String Fila[]=new String[6];
               String contenidoCelda= new String();
               DataFormatter formatter = new DataFormatter();
               while (iterator.hasNext()) {
                   Row nextRow = iterator.next();

                   Iterator<Cell> cellIterator = nextRow.cellIterator();
                   while(cellIterator.hasNext()) {
                       Cell cell = cellIterator.next();
                       contenidoCelda = formatter.formatCellValue(cell);
                       Fila[i]=contenidoCelda;
                       i++;
                       if(i==6) {
                           System.out.println(Arrays.toString(Fila));
                           lista.add(new Revista(Fila[0], Fila[1], Fila[2], Fila[3], Fila[4], Fila[5]));
                           i=0;
                       }
                   }

               }
           } catch (Exception e) {
               System.out.println("Error.");
               e.printStackTrace();
           }
           return lista;
       }
       public static ObservableList<Prestamo>  excelPrestamo(){
           ObservableList<Prestamo> lista= FXCollections.observableArrayList();
           try {
               String rutaArchivoExcel = "C:\\Users\\Giovanna Rodriguez\\Desktop\\PRACTICAS\\proyecto final\\Biblioteca\\src\\main\\resources\\BD\\Prestamo.xlsx";
               FileInputStream inputStream = new FileInputStream(new File(rutaArchivoExcel));
               Workbook workbook = new XSSFWorkbook(inputStream);
               Sheet firstSheet = workbook.getSheetAt(0);
               Iterator<Row> iterator = firstSheet.iterator();
               int i=0;
               String Fila[]=new String[5];
               String contenidoCelda= new String();
               DataFormatter formatter = new DataFormatter();
               while (iterator.hasNext()) {
                   Row nextRow = iterator.next();

                   Iterator<Cell> cellIterator = nextRow.cellIterator();
                   while(cellIterator.hasNext()) {
                       Cell cell = cellIterator.next();
                       contenidoCelda = formatter.formatCellValue(cell);
                       Fila[i]=contenidoCelda;
                       i++;
                       if(i==5) {
                           System.out.println(Arrays.toString(Fila));
                           lista.add(new Prestamo(Fila[0], Fila[1], Fila[2], Fila[3], Fila[4]));
                           i=0;
                       }
                   }
               }

           } catch (Exception e) {
               System.out.println("Error.");
               e.printStackTrace();
           }
           return lista;
       }
}