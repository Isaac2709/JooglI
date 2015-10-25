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
import models.SearchEngine;
import models.Sites;
import models.Token;

/**
 *
 * @author isaac
 */
public class SearchEngineView extends javax.swing.JFrame implements Runnable{
    private SearchEngineController searchEngine = new SearchEngineController();
    private Thread tempThreadLogo;
    private Thread tempThreadBtnSearch;
    private Thread tempThreadTxtSearch;
    private boolean flag=false;    
    /**
     * Creates new form SearchEngineView
     */
    public SearchEngineView() {
        initComponents(); 
        searchJPanel.setVisible(false);
        searchEngine.consultSites();
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

        javax.swing.GroupLayout searchJPanelLayout = new javax.swing.GroupLayout(searchJPanel);
        searchJPanel.setLayout(searchJPanelLayout);
        searchJPanelLayout.setHorizontalGroup(
            searchJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(searchJPanelLayout.createSequentialGroup()
                .addGroup(searchJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, searchJPanelLayout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTxtSearch2, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jBtnSearch1)
                        .addGap(0, 18, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, searchJPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(searchJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTimeTotalDurationSequential, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING))))
                .addGap(29, 29, 29))
        );
        searchJPanelLayout.setVerticalGroup(
            searchJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(searchJPanelLayout.createSequentialGroup()
                .addGroup(searchJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(searchJPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(searchJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTxtSearch2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jBtnSearch1)))
                    .addGroup(searchJPanelLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTimeTotalDurationSequential, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(searchJPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 480, 330));

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
                .addGap(0, 0, Short.MAX_VALUE)
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
                .addGap(0, 0, Short.MAX_VALUE))
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
                        
                tempThreadLogo.start();
                tempThreadBtnSearch.start();
                tempThreadTxtSearch.start();
            }
            catch(Exception e){
                System.err.println("ERROR EN HILOS");
            }    
        }        
    }//GEN-LAST:event_jTxtSearchKeyPressed

    private void jBtnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnSearchActionPerformed
        ArrayList<Sites> listSites = searchEngine.search(jTxtSearch2.getText());
        System.out.println("******************************************");
        searchEngine.printSites(listSites);
        loadResults(listSites);
    }//GEN-LAST:event_jBtnSearchActionPerformed

    private void jBtnSearch1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnSearch1ActionPerformed
        ArrayList<Sites> listSites = searchEngine.search(jTxtSearch2.getText());
        System.out.println("******************************************");
        searchEngine.printSites(listSites);
        loadResults(listSites);
    }//GEN-LAST:event_jBtnSearch1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        /*ArrayList<Sites> listSites = searchEngine.search(jTxtSearch2.getText());
        System.out.println("******************************************");
        searchEngine.printSites(listSites);
        loadResults(listSites); */       
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTxtSearch2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTxtSearch2KeyPressed
        /*ArrayList<Sites> listSites = searchEngine.search(jTxtSearch2.getText());
        System.out.println("******************************************");
        searchEngine.printSites(listSites);        
        loadResults(listSites);        */
    }//GEN-LAST:event_jTxtSearch2KeyPressed
           
    private void loadResults(ArrayList<Sites> listSites){
        jPanelResult.removeAll();
        int countForVerticalPanelSize =0;
        int countForVerticalPanelSize2 =0;
        boolean verificarCount=false;
        
        //javax.swing.JLabel jTotalSequentialDuration = new javax.swing.JLabel();
        
       
        for(int i = 0; i < listSites.size(); i++){
            countForVerticalPanelSize=0;
            
            javax.swing.JLabel jDescription = new javax.swing.JLabel();
            javax.swing.JLabel jMatches = new javax.swing.JLabel();
            
            javax.swing.JLabel jtimeFirstMatch = new javax.swing.JLabel();
            jDescription.setText(listSites.get(i).getBody());
            ArrayList<Token> listTokenMatches = listSites.get(i).getListTokensMatches();
            String matches = "";
            for(int n = 0; n < listTokenMatches.size(); n++){
                matches = "<html><body>"+matches + listTokenMatches.get(n).getToken() + " aparecio " + listTokenMatches.get(n).getNumberMatches() + " veces; <br> Tiempo de primera coincidencia: "+ listTokenMatches.get(n).getFirstMatchTime()+" milisegundos. <br> Tiempo total: "+listTokenMatches.get(n).getTotalMachTime()+" milisegundos.<br><html><body>";
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
            if(listSites.get(i).getBody().length() > 50){
                jDescription.setText(listSites.get(i).getBody().substring(0, 50));
            }            
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
                    )
                )
            );
            jPanelLayout.setVerticalGroup(
                jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelLayout.createSequentialGroup()
                    .addGap(10, 10, 10)
                    .addComponent(jMatches) 
                    .addComponent(jDescription)
                )
            );
            int boxSize=0;
            int numMult=35;
            if(countForVerticalPanelSize2>1){
                numMult=numMult+(countForVerticalPanelSize2*3);
                boxSize=countForVerticalPanelSize2*numMult;
            }
            
            jPanelResult.add(jPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, (i*(80+boxSize)), 480, boxSize+80));
            
            
        }  
        //searchJPanel.add(jTotalSequentialDuration.setText())
        jTimeTotalDurationSequential.setText("Tiempo total secuencial: "+searchEngine.getTimeTotalSequential().toString()+" milisegundos.");
        searchJPanel.add(jTimeTotalDurationSequential);
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
        tempThreadBtnSearch.stop();    
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
                new SearchEngineView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnSearch;
    private javax.swing.JButton jBtnSearch1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanelResult;
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
