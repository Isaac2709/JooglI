/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import org.hyperic.sigar.Mem;
import org.hyperic.sigar.Sigar;
import org.hyperic.sigar.Swap;
import org.hyperic.sigar.SigarException;

/**
 *
 * @author luigi
 */
public class InfoMemoryController {
    private static Sigar sigar = new Sigar();
    private static long ramMemory;
    private static long ramMemoryTotal;
    private static long ramMemoryUsage;
    private static long ramMemoryAvailable;
    private static long swapMemoryTotal;
    private static long swapMemoryUsage;
    private static long swapMemoryFree;
    
    public void imprimirInfo() throws SigarException {
        Mem memoria = sigar.getMem();
        Swap intercambio = sigar.getSwap();
        System.out.println("Cantidad de memoria RAM: "+ memoria.getRam() + "MB");
        System.out.println("Total: "+enBytes(memoria.getTotal()));
        System.out.println("Usada: "+enBytes(memoria.getUsed()));
        System.out.println("Disponible: "+enBytes(memoria.getFree()));
        System.out.println("Memoria SWAP total: "+enBytes(intercambio.getTotal()));
        System.out.println("Memoria SWAP usada: "+enBytes(intercambio.getUsed()));
        System.out.println("Memoria SWAP libre: "+enBytes(intercambio.getFree()));
    }
    
    private Long enBytes(long valor) {
        return new Long(valor / 1024);
    }
    
    private Long toMegaBytes(long valor) {
        return new Long((valor / 1024) / 1024);
    }

    public Sigar getSigar() {
        return sigar;
    }

    public static long getRamMemory() throws SigarException {
        ramMemory = sigar.getMem().getRam();
        return ramMemory;
    }

    public long getRamMemoryTotal() {
        return ramMemoryTotal;
    }

    public long getRamMemoryUsage() throws SigarException {
        ramMemoryUsage = toMegaBytes(sigar.getMem().getUsed());
        return ramMemoryUsage;
    }

    public long getRamMemoryAvailable() throws SigarException {
        ramMemoryAvailable = toMegaBytes(sigar.getMem().getFree());
        return ramMemoryAvailable;
    }

    public long getSwapMemoryTotal() {
        return swapMemoryTotal;
    }

    public static long getSwapMemoryUsage() {
        return swapMemoryUsage;
    }

    public static long getSwapMemoryFree() {
        return swapMemoryFree;
    }
    
    
}
