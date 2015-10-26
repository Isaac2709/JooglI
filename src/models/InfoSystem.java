/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import controllers.*;
import org.hyperic.sigar.SigarException;
/**
 *
 * @author luigi
 */
public class InfoSystem {
    private static InfoCPUController infoCPU;
    private static InfoFileSystemController infoFileSystem;
    private static InfoMemoryController infoMemory;
    private static InfoSOController infoSO;

    public InfoSystem() {
        infoCPU = new InfoCPUController();                                                    
        infoFileSystem = new controllers.InfoFileSystemController();
        infoMemory = new controllers.InfoMemoryController();
        infoSO = new InfoSOController(); 
    }
    
    public void printInfo(){
        try {
            System.out.println("====Informacion del sistema====");
            new controllers.InfoSOController().imprimirInfo();
            System.out.println("\n==== Informacion de la CPU ====");
            new controllers.InfoCPUController().imprimirInfoCPU();
            System.out.println("\n====Informacion del sistema de archivos====");
            new controllers.InfoFileSystemController().imprimirInfo();
            System.out.println("\n====Informacion de la memoria====");
            new controllers.InfoMemoryController().imprimirInfo();
        } catch (SigarException e) {
            e.printStackTrace();
        }
    }

    public static InfoCPUController getInfoCPU() {
        return infoCPU;
    }

    public static void setInfoCPU(InfoCPUController infoCPU) {
        InfoSystem.infoCPU = infoCPU;
    }

    public static InfoFileSystemController getInfoFileSystem() {
        return infoFileSystem;
    }

    public static void setInfoFileSystem(InfoFileSystemController infoFileSystem) {
        InfoSystem.infoFileSystem = infoFileSystem;
    }

    public static InfoMemoryController getInfoMemory() {
        return infoMemory;
    }

    public static void setInfoMemory(InfoMemoryController infoMemory) {
        InfoSystem.infoMemory = infoMemory;
    }

    public static InfoSOController getInfoSO() {
        return infoSO;
    }

    public static void setInfoSO(InfoSOController infoSO) {
        InfoSystem.infoSO = infoSO;
    }
    
    
}
