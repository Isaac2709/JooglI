/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author luigi
 */
public class SummaryInfoSystem {
    private String strSearch;
    private boolean implementsMultiCore;
    private String infoCPUUsage;
    private long infoMemoryUsage;   

    public SummaryInfoSystem(String strSearch, boolean implementsMultiCore, String infoCPUUsage, long infoMemoryUsage) {
        this.strSearch = strSearch;
        this.implementsMultiCore = implementsMultiCore;
        this.infoCPUUsage = infoCPUUsage;
        this.infoMemoryUsage = infoMemoryUsage;
    }
    
    
}
