/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.util.ArrayList;
import org.hyperic.sigar.CpuInfo;
import org.hyperic.sigar.CpuPerc;
import org.hyperic.sigar.Sigar;
import org.hyperic.sigar.SigarException;

/**
 *
 * @author luigi
 */
public class InfoCPUController {
    private static Sigar sigar;
    private static String manufacturer;
    private static String model;
    private static int mhz;
    private static int cpus;
    private static int cpusF;
    private static int coresPerCPU;
    private static long cache;
    private static ArrayList<String> usageCPU;
    private static String totalUsageCPU;
    
    public InfoCPUController(){
        usageCPU = new ArrayList<String>();
        sigar = new Sigar();
        CpuInfo[] infos = null;
        CpuPerc[] cpusTemp = null;
        try {
            infos = sigar.getCpuInfoList();
            cpusTemp = sigar.getCpuPercList();
        } catch (SigarException e) {
            e.printStackTrace();
        }
        CpuInfo info = infos[0];
        long tamanioCache = info.getCacheSize();
        manufacturer = info.getVendor();
        model = info.getModel();
        mhz = info.getMhz();
        cpus = info.getTotalCores();
        
        if ((info.getTotalCores() != info.getTotalSockets())
                || (info.getCoresPerSocket() > info.getTotalCores())) {
            cpusF = info.getTotalSockets();
            coresPerCPU = info.getCoresPerSocket();
        }
        if (tamanioCache != Sigar.FIELD_NOTIMPL)
            cache = tamanioCache;        
        for (int i = 0; i < cpusTemp.length; i++)
            usageCPU.add("Consumo de CPU " + i + CpuPerc.format(cpusTemp[i].getUser()));
        try {
            totalUsageCPU = CpuPerc.format(sigar.getCpuPerc().getUser());
        } catch (SigarException e) {
            e.printStackTrace();
        }
    }
    
    public void imprimirInfoCPU() {
        sigar = new Sigar();
        CpuInfo[] infos = null;
        CpuPerc[] cpus = null;
        try {
            infos = sigar.getCpuInfoList();
            cpus = sigar.getCpuPercList();
        } catch (SigarException e) {
            e.printStackTrace();
        }
        CpuInfo info = infos[0];
        long tamanioCache = info.getCacheSize();
        System.out.println("Fabricante:\t\t" + info.getVendor());
        System.out.println("Modelo\t\t\t" + info.getModel());
        System.out.println("Mhz\t\t\t" + info.getMhz());
        System.out.println("Total CPUs\t\t" + info.getTotalCores());
        if ((info.getTotalCores() != info.getTotalSockets())
                || (info.getCoresPerSocket() > info.getTotalCores())) {
            System.out.println("CPUs fisiscas\t\t" + info.getTotalSockets());
            System.out
                    .println("Nucleos por CPU\t\t" + info.getCoresPerSocket());
        }
        if (tamanioCache != Sigar.FIELD_NOTIMPL)
            System.out.println("Tamanio cache\t\t" + tamanioCache);
        System.out.println("");
        for (int i = 0; i < cpus.length; i++)
            System.out.println("Consumo de CPU " + i + "\t"
                    + CpuPerc.format(cpus[i].getUser()));
        try {
            System.out.println("Consumo total de CPU\t"
                    + CpuPerc.format(sigar.getCpuPerc().getUser()));
        } catch (SigarException e) {
            e.printStackTrace();
        }
    }
    
    public ArrayList getInfoCPU() {
        ArrayList consumoCPU = new ArrayList<>();
        sigar = new Sigar();
        CpuInfo[] infos = null;
        CpuPerc[] cpus = null;
        try {
            infos = sigar.getCpuInfoList();
            cpus = sigar.getCpuPercList();
        } catch (SigarException e) {
            e.printStackTrace();
        }
        CpuInfo info = infos[0];
        long tamanioCache = info.getCacheSize();                
        for (int i = 0; i < cpus.length; i++){
            consumoCPU.add(CpuPerc.format(cpus[i].getUser()));
            //System.out.println("Consumo de CPU " + i + "\t"                    
                   // + CpuPerc.format(cpus[i].getUser()));
        }
        try {
            consumoCPU.add(CpuPerc.format(sigar.getCpuPerc().getUser()));
            //ystem.out.println("Consumo total de CPU\t"
                    //+ CpuPerc.format(sigar.getCpuPerc().getUser()));
        } catch (SigarException e) {
            e.printStackTrace();
        }
        return consumoCPU;
    }

    public static Sigar getSigar() {
        return sigar;
    }

    public static String getManufacturer() {
        return manufacturer;
    }

    public static String getModel() {
        return model;
    }

    public static int getMhz() {
        return mhz;
    }

    public static int getCpus() {
        return cpus;
    }

    public static int getCpusF() {
        return cpusF;
    }

    public static int getCoresPerCPU() {
        return coresPerCPU;
    }

    public static long getCache() {
        return cache;
    }

    public static ArrayList<String> getUsageCPU() {
        return usageCPU;
    }

    public static String getTotalUsageCPU() throws SigarException {
        totalUsageCPU = CpuPerc.format(sigar.getCpuPerc().getUser());
        return totalUsageCPU;
    }

    
    
}

