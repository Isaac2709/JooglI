/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import controllers.SearchEngineController;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.GroupLayout;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import models.InfoSystem;
import models.SearchEngine;
import models.Sites;
import models.SummaryInfoSystem;
import models.Token;
import multicore.ParallelTasks;
import org.hyperic.sigar.SigarException;

/**
 *
 * @author isaac
 */
public class SearchEngineView extends javax.swing.JFrame implements Runnable{
    private SearchEngineController searchEngine = new SearchEngineController();
    private Thread tempThreadLogo;
    private Thread tempThreadBtnSearch;
    private Thread tempThreadTxtSearch;
    private Thread tempInfoSystem;
    private boolean flag=false;    
    private boolean implementsMultiCore = false;
    private static final int threads = Runtime.getRuntime().availableProcessors();
    private static models.InfoSystem infoSystem;
    private int searchFlag = 3;
    private boolean flagStoreSearchStatistics = false;
    private ArrayList<SummaryInfoSystem> storeSearchStatistics = new ArrayList<SummaryInfoSystem>();    
    public static ArrayList<Sites> listSitesSequential=new ArrayList<Sites>();
    public static ArrayList<Sites> listSitesParallel=new ArrayList<Sites>();
    /**
     * Creates new form SearchEngineView
     */
    public SearchEngineView(SearchEngineController searchEngine) {
        initComponents(); 
        this.setLocationRelativeTo(null);
        this.searchEngine = searchEngine;
        searchJPanel.setVisible(false);        
        infoSystem = new InfoSystem();        
        //searchEngine.consultSites();
        // Listen for changes in the text        
    }            

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    //@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        searchJPanel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jTxtSearch2 = new javax.swing.JTextField();
        jBtnSearch1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanelResult = new javax.swing.JPanel();
        jTimeTotalDurationSequential = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jButton3 = new javax.swing.JButton();
        jProcessorLabel = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        mainJPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTxtSearch = new javax.swing.JTextField();
        jBtnSearch = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 2, 36)); // NOI18N
        jLabel2.setText("JooglI");

        jTxtSearch2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTxtSearch2KeyPressed(evt);
            }
        });

        jBtnSearch1.setText("Search");
        jBtnSearch1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnSearch1ActionPerformed(evt);
            }
        });

        jPanelResult.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jScrollPane1.setViewportView(jPanelResult);

        jCheckBox1.setText("MultiNucleo");
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });

        jButton3.setText("Grafico");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton1.setText("Config");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout searchJPanelLayout = new javax.swing.GroupLayout(searchJPanel);
        searchJPanel.setLayout(searchJPanelLayout);
        searchJPanelLayout.setHorizontalGroup(
            searchJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(searchJPanelLayout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTxtSearch2, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jBtnSearch1)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(searchJPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(searchJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jProcessorLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(searchJPanelLayout.createSequentialGroup()
                        .addGroup(searchJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton1)
                            .addGroup(searchJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(searchJPanelLayout.createSequentialGroup()
                                    .addComponent(jCheckBox1)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jTimeTotalDurationSequential, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton3))
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 532, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 18, Short.MAX_VALUE)))
                .addContainerGap())
        );
        searchJPanelLayout.setVerticalGroup(
            searchJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(searchJPanelLayout.createSequentialGroup()
                .addGroup(searchJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(searchJPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(searchJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTxtSearch2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jBtnSearch1)
                            .addComponent(jButton1)))
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addGroup(searchJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, searchJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jButton3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jCheckBox1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jTimeTotalDurationSequential, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jProcessorLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7))
        );

        getContentPane().add(searchJPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 570, 430));

        jLabel1.setFont(new java.awt.Font("Tahoma", 2, 36)); // NOI18N
        jLabel1.setText("JooglI");

        jTxtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTxtSearchKeyPressed(evt);
            }
        });

        jBtnSearch.setText("Search");
        jBtnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnSearchActionPerformed(evt);
            }
        });

        jButton2.setText("I'm lucky");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout mainJPanelLayout = new javax.swing.GroupLayout(mainJPanel);
        mainJPanel.setLayout(mainJPanelLayout);
        mainJPanelLayout.setHorizontalGroup(
            mainJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainJPanelLayout.createSequentialGroup()
                .addGap(0, 107, Short.MAX_VALUE)
                .addGroup(mainJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainJPanelLayout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(mainJPanelLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jTxtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(mainJPanelLayout.createSequentialGroup()
                        .addComponent(jBtnSearch)
                        .addGap(135, 135, 135)
                        .addComponent(jButton2)))
                .addGap(0, 107, Short.MAX_VALUE))
        );
        mainJPanelLayout.setVerticalGroup(
            mainJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainJPanelLayout.createSequentialGroup()
                .addGap(0, 77, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(26, 26, 26)
                .addComponent(jTxtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(mainJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBtnSearch)
                    .addComponent(jButton2))
                .addGap(0, 78, Short.MAX_VALUE))
        );

        getContentPane().add(mainJPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 480, 300));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTxtSearchKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTxtSearchKeyPressed
        // TODO add your handling code here:        
        if(!flag){
            try{                
                tempThreadLogo = new Thread(this);
                tempThreadBtnSearch  = new Thread(this);
                tempThreadTxtSearch  = new Thread(this);
                tempInfoSystem  = new Thread(this);
                        
                tempThreadLogo.start();
                tempThreadBtnSearch.start();
                tempThreadTxtSearch.start();
                tempInfoSystem.start();
            }
            catch(Exception e){
                System.err.println("ERROR EN HILOS");
            }    
        }        
    }//GEN-LAST:event_jTxtSearchKeyPressed

    private void jBtnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnSearchActionPerformed
//        try {
//            search(jTxtSearch2.getText());
//        } catch (InterruptedException ex) {
//            Logger.getLogger(SearchEngineView.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }//GEN-LAST:event_jBtnSearchActionPerformed

    private void jBtnSearch1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnSearch1ActionPerformed
        try {
            search(jTxtSearch2.getText());
        } catch (InterruptedException ex) {
            Logger.getLogger(SearchEngineView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jBtnSearch1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
//        try {
//            search(jTxtSearch2.getText());
//        } catch (InterruptedException ex) {
//            Logger.getLogger(SearchEngineView.class.getName()).log(Level.SEVERE, null, ex);
//        }   
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTxtSearch2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTxtSearch2KeyPressed
//        try {
//            search(jTxtSearch2.getText());
//        } catch (InterruptedException ex) {
//            Logger.getLogger(SearchEngineView.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }//GEN-LAST:event_jTxtSearch2KeyPressed

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        if(jCheckBox1.isSelected()){
            this.implementsMultiCore=true;
        }
        else{
            this.implementsMultiCore=false;
        }        
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        StatisticsView statisticsView = new StatisticsView();
        statisticsView.setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        SitesView siteView = new SitesView(searchEngine);
        siteView.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed
        
    private void jBtnOpenLinkActionPerformed(java.awt.event.ActionEvent evt, String url) {                                         
        searchEngine.openWebSite(url);
    }
    
    private void search(String strSearch) throws InterruptedException{  
        storeSearchStatistics.clear();
        flagStoreSearchStatistics = true;
        ArrayList<Sites> listSites = searchEngine.search(strSearch, implementsMultiCore);
        flagStoreSearchStatistics = false;
        System.out.println("******************************************");
        searchEngine.printSites(listSites);        
        loadResults(listSites);  
        if(!this.implementsMultiCore){
            this.listSitesSequential=listSites;
        }
        else{
            this.listSitesParallel=listSites;
        }
    }
  
    private void loadResults(ArrayList<Sites> listSites){
        jPanelResult.removeAll();
        int countForVerticalPanelSize =0;
        int countForVerticalPanelSize2 =0;
        boolean verificarCount=false;        
        //javax.swing.JLabel jTotalSequentialDuration = new javax.swing.JLabel();
               
        for(int i = 0; i < listSites.size(); i++){
            countForVerticalPanelSize=0;
            
            javax.swing.JButton jBtnOpenLink = new javax.swing.JButton();
            javax.swing.JLabel jDescription = new javax.swing.JLabel();
            javax.swing.JLabel jMatches = new javax.swing.JLabel();
            javax.swing.JLabel jTotalTimePerSite = new javax.swing.JLabel();
            
            javax.swing.JLabel jtimeFirstMatch = new javax.swing.JLabel();
            
            jBtnOpenLink.setText("Open");
            String a = listSites.get(i).getAddress();
            jBtnOpenLink.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jBtnOpenLinkActionPerformed(evt, a);
                }
            });
            
            jTotalTimePerSite.setText("Tiempo total por pagina: "+listSites.get(i).getTimeTotalMatchPerSite().toString()+" milisegundos.");
            jDescription.setText(listSites.get(i).getBody());
            ArrayList<Token> listTokenMatches = listSites.get(i).getListTokensMatches();
            String matches = "";
            for(int n = 0; n < listTokenMatches.size(); n++){
                matches = "<html><body>"+matches + listTokenMatches.get(n).getToken() + " aparecio " + listTokenMatches.get(n).getNumberMatches() + " veces; <br> Tiempo de primera coincidencia: "+ listTokenMatches.get(n).getFirstMatchTime()+" milisegundos. <br> Tiempo total del token: "+listTokenMatches.get(n).getTotalMachTime()+" milisegundos.<br><html><body>";
                countForVerticalPanelSize++;
            }
            if(!verificarCount){
                countForVerticalPanelSize2=countForVerticalPanelSize;
                verificarCount=true;
            }
            if(verificarCount && countForVerticalPanelSize>countForVerticalPanelSize2){
                countForVerticalPanelSize2=countForVerticalPanelSize;
            }
            jMatches.setText(matches);        
            javax.swing.JPanel jPanel = new javax.swing.JPanel();
            jPanel.setBorder(BorderFactory.createTitledBorder(listSites.get(i).getTitle()));
            javax.swing.GroupLayout jPanelLayout = new javax.swing.GroupLayout(jPanel);
            jPanel.setLayout(jPanelLayout);
            jPanelLayout.setHorizontalGroup(
                jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelLayout.createSequentialGroup()
                    .addGap(18, 18, 18)
                    .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jMatches)
                        .addComponent(jDescription)
                        .addComponent(jTotalTimePerSite)
                            .addComponent(jBtnOpenLink)
                    )
                    .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBtnOpenLink)
                    )                                    
                )
            );
            jPanelLayout.setVerticalGroup(
                jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelLayout.createSequentialGroup()
                    .addGap(10, 10, 10)
                    .addComponent(jMatches) 
                    .addComponent(jDescription)
                    .addComponent(jTotalTimePerSite)
                        .addComponent(jBtnOpenLink)
                )
                .addGroup(jPanelLayout.createSequentialGroup()
                    .addComponent(jBtnOpenLink)
                    )
            );
            int boxSize=0;
            int numMult=35;
            if(countForVerticalPanelSize2>1){
                numMult=numMult+(countForVerticalPanelSize2*3);
                boxSize=countForVerticalPanelSize2*numMult;
            }
            int withPanel = 130;
            jPanelResult.add(jPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, (i*(withPanel+boxSize)), 1200, boxSize+withPanel));
        }  
        //searchJPanel.add(jTotalSequentialDuration.setText())
        jTimeTotalDurationSequential.setText("Tiempo total secuencial: "+searchEngine.getTimeTotalSequential().toString()+" milisegundos.");
        //searchJPanel.add(jTimeTotalDurationSequential);
        pack();       
    }
    
    private void annimationLogo() throws InterruptedException{        
        int withLabel= 120;
        int withTextField = 260;
        int animationSpeed = 3;
        while(true){
            if(jLabel1.getLocation().x > 0){
                jLabel1.setLocation(jLabel1.getLocation().x -1, jLabel1.getLocation().y);
            }
            if(jLabel1.getLocation().y > 0){
                jLabel1.setLocation(jLabel1.getLocation().x, jLabel1.getLocation().y -1);
            }            
            if(jLabel1.getLocation().x == 0 && jLabel1.getLocation().y == 0){
                break;
            }
            tempThreadLogo.sleep(animationSpeed);
        } 
        searchFlag = searchFlag - 1;
        tempThreadLogo.stop();
    }
    
    private void annimationTextField() throws InterruptedException{   
        int withLabel= 120;
        int withTextField = 260;
        int animationSpeed = 3;
        tempThreadTxtSearch.sleep(100);
        while(true){
            if(jTxtSearch.getLocation().x > jLabel1.getLocation().x + withLabel){
                jTxtSearch.setLocation(jTxtSearch.getLocation().x - 1, jTxtSearch.getLocation().y);
            }
            else if(jTxtSearch.getLocation().x < jLabel1.getLocation().x + withLabel){
                jTxtSearch.setLocation(jTxtSearch.getLocation().x + 1, jTxtSearch.getLocation().y);
            }
            if(jTxtSearch.getLocation().y > 20){
                jTxtSearch.setLocation(jTxtSearch.getLocation().x, jTxtSearch.getLocation().y -1);
            }                    
            if(jTxtSearch.getLocation().x == jLabel1.getLocation().x + withLabel && jTxtSearch.getLocation().y == 20){
                break;
            }            
            tempThreadTxtSearch.sleep(animationSpeed);
        }
        searchFlag = searchFlag - 1;
        tempThreadTxtSearch.stop();
    }    
    
    private void annimationButtonSearch() throws InterruptedException{   
        int withLabel= 120;
        int withTextField = 260;
        int animationSpeed = 3;
        tempThreadTxtSearch.sleep(200);
        while(true){
            if(jBtnSearch.getLocation().x > jTxtSearch.getLocation().x + withTextField){
                jBtnSearch.setLocation(jBtnSearch.getLocation().x - 1, jBtnSearch.getLocation().y);
            }
            else if(jBtnSearch.getLocation().x < jTxtSearch.getLocation().x + withTextField){
                jBtnSearch.setLocation(jBtnSearch.getLocation().x + 1, jBtnSearch.getLocation().y);
            }
            if(jBtnSearch.getLocation().y > 10){
                jBtnSearch.setLocation(jBtnSearch.getLocation().x, jBtnSearch.getLocation().y -1);
            }                    
            if(jBtnSearch.getLocation().x == jTxtSearch.getLocation().x + withTextField && jBtnSearch.getLocation().y == 10){
                break;
            }            
            tempThreadBtnSearch.sleep(animationSpeed);
        }
        
        mainJPanel.setVisible(false);
        searchJPanel.setVisible(true);
        searchJPanel.setBackground(new java.awt.Color(245, 245, 245));
        jTxtSearch2.setText(jTxtSearch.getText());
        jTxtSearch2.requestFocusInWindow();
        jTxtSearch2.setCaretPosition(jTxtSearch2.getText().length());
        searchFlag = searchFlag - 1;
        tempThreadBtnSearch.stop();            
    } 
    
    private void loadInfoSystem() throws InterruptedException{
        try {
            boolean t = true;
            while(searchFlag > 0){System.err.print("");}
            while(t){
                int sleepTime = 500;
                String totalUsageCPU = infoSystem.getInfoCPU().getTotalUsageCPU();                
                long totalRamMemoryUsage = infoSystem.getInfoMemory().getRamMemoryUsage();
                
                if(flagStoreSearchStatistics){
                    sleepTime = 50;
                    storeSearchStatistics.add(
                            new SummaryInfoSystem(jTxtSearch2.getText(), implementsMultiCore, totalUsageCPU, totalRamMemoryUsage)
                    );
                }                                
                jProcessorLabel.setText(
                        "Processors: " + threads
                        + " | Total CPU usage: " + totalUsageCPU   
                        + " | RamMemory usage: " + totalRamMemoryUsage                         
                        + " of " + infoSystem.getInfoMemory().getRamMemory()
                );
                Thread.sleep(sleepTime);
            }
            tempInfoSystem.stop();
        } catch (SigarException ex) {
            Logger.getLogger(SearchEngineView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SearchEngineView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SearchEngineView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SearchEngineView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SearchEngineView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SearchEngineView(null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnSearch;
    private javax.swing.JButton jBtnSearch1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanelResult;
    private javax.swing.JLabel jProcessorLabel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jTimeTotalDurationSequential;
    private javax.swing.JTextField jTxtSearch;
    private javax.swing.JTextField jTxtSearch2;
    private javax.swing.JPanel mainJPanel;
    private javax.swing.JPanel searchJPanel;
    // End of variables declaration//GEN-END:variables

    
    @Override
    public void run() {        
        Thread ct = Thread.currentThread();
 
        if (ct == tempThreadLogo) {        
            try {
                flag=true;
                annimationLogo();
            } catch (InterruptedException ex) {
                Logger.getLogger(SearchEngineView.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if (ct == tempThreadTxtSearch) {        
            try {
                flag=true;
                annimationTextField();
            } catch (InterruptedException ex) {
                Logger.getLogger(SearchEngineView.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if (ct == tempThreadBtnSearch) {        
            try {
                flag=true;
                annimationButtonSearch();
            } catch (InterruptedException ex) {
                Logger.getLogger(SearchEngineView.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if(ct == tempInfoSystem){
             try {
                flag=true;
                loadInfoSystem();
            } catch (InterruptedException ex) {
                Logger.getLogger(SearchEngineView.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
