/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author isaac
 */
public class Token {
    private String token;
    private int numberMatches;
    private long firstMatchTime;
    private long totalMatchTime;

    public Token(String token, int numberMatches) {
        this.token = token;
        this.numberMatches = numberMatches;
    }
    
    public Token(String token, int numberMatches, long firstMatchTime, long totalMatchTime) {
        this.token = token;
        this.numberMatches = numberMatches;
        this.firstMatchTime=firstMatchTime;
        this.totalMatchTime=totalMatchTime;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public int getNumberMatches() {
        return numberMatches;
    }

    public void setNumberMatches(int numberMatches) {
        this.numberMatches = numberMatches;
    }

    public long getFirstMatchTime() {
        return firstMatchTime;
    }

    public void setFirstMatchTime(long firstMatchTime) {
        this.firstMatchTime = firstMatchTime;
    }

    public long getTotalMachTime() {
        return totalMatchTime;
    }

    public void setTotalMachTime(long totalMachTime) {
        this.totalMatchTime = totalMachTime;
    }
     
    
    
}
