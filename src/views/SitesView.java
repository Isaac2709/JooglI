/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import controllers.SearchEngineController;
import database.DBConnection;
import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import models.Sites;

/**
 *
 * @author isaac
 */
public class SitesView extends javax.swing.JFrame {    
    SearchEngineController searchEngine;
    ListSelectionModel listSelectionModel;
    private static int lenght;
    /**
     * Creates new form ConfigSitesView
     */
    public SitesView(SearchEngineController searchEngine) {
        initComponents();  
        //listSelectionModel = jTable1.getSelectionModel();        
        //jTable1.setModel(model);    
        this.setLocationRelativeTo(null);
        this.searchEngine = searchEngine;
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
        //searchEngine.printSites(searchEngine.getListSites());
        loadTable();
        
        model.addTableModelListener(new TableModelListener() {
            @Override
            public void tableChanged(TableModelEvent evt) {
              // UPDATE SQL into MDBas
                if(evt.getColumn()!=-1){
                    //model.getValueAt(evt.getFirstRow(), evt.getColumn());
                   if(model.getValueAt(evt.getFirstRow(), evt.getColumn())!= null){
                       if(evt.getFirstRow()+1 > lenght){
                            if(evt.getColumn() == 1){
                                if( !(model.getValueAt(evt.getFirstRow(), evt.getColumn()).toString().equals("")) && !(model.getValueAt(evt.getFirstRow(), evt.getColumn() - 1).toString().equals("")) ){
                                    String nameWEBSite = model.getValueAt(evt.getFirstRow(), evt.getColumn() - 1).toString();
                                    String addressWEBSite = model.getValueAt(evt.getFirstRow(), evt.getColumn()).toString();                                
                                    Sites site = new Sites(nameWEBSite, addressWEBSite);                                
                                    if(site.existURL()){
                                        if(site.registerSite(searchEngine.getConn())){
                                            lenght ++;
                                            searchEngine.consultSites();
                                        }                                   
                                    }                                
                                }
                                else if(!(model.getValueAt(evt.getFirstRow(), evt.getColumn()).toString().equals(""))){                                
                                    String addressWEBSite = model.getValueAt(evt.getFirstRow(), evt.getColumn()).toString();                                
                                    Sites site = new Sites("", addressWEBSite);                                
                                    try {
                                        String nameWEBSite = site.getTitleFromSource();
                                        if(nameWEBSite != null){
                                            site.setTitle(nameWEBSite);
                                            if(site.existURL()){                                        
                                                model.setValueAt(site.getTitle(),evt.getFirstRow(), evt.getColumn() - 1);
                                                if(site.registerSite(searchEngine.getConn())){
                                                    searchEngine.consultSites();
                                                    lenght ++;
                                                }                                                
                                            }
                                        }
                                        else{
                                            model.setValueAt("", evt.getFirstRow(), evt.getColumn());
                                        }
                                    } catch (IOException ex) {
                                        Logger.getLogger(SitesView.class.getName()).log(Level.SEVERE, null, ex);
                                    }                                
                                }
                            }
                            else if(evt.getColumn() == 0){
                                if( !(model.getValueAt(evt.getFirstRow(), evt.getColumn()).toString().equals("")) && !(model.getValueAt(evt.getFirstRow(), evt.getColumn() + 1).toString().equals("")) ){
                                    String nameWEBSite = model.getValueAt(evt.getFirstRow(), evt.getColumn()).toString();
                                    String addressWEBSite = model.getValueAt(evt.getFirstRow(), evt.getColumn() + 1).toString();                                
                                    Sites site = new Sites(nameWEBSite, addressWEBSite);                                
                                    if(site.existURL()){
                                        if(site.registerSite(searchEngine.getConn())){
                                            searchEngine.consultSites();
                                            lenght ++;
                                        }                                    
                                    }
                                }
                           }
                       }
                   }                    
                }                
            }
        });
    }
    
    private void loadTable(){
        ArrayList<models.Sites> listSites = searchEngine.getListSites();
        lenght = listSites.size();
        Object []obj = new Object[2];
        for(int i = 0; i < listSites.size(); i++){
            obj[0] = listSites.get(i).getTitle();
            obj[1] = listSites.get(i).getAddress();
            model.addRow(obj);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        model = new javax.swing.table.DefaultTableModel(
            null,
            new String [] {
                "Nombre del sitio web", "Dirección web"
            }
        );
        jTable1 = new javax.swing.JTable();
        jBtnAdd = new javax.swing.JButton();
        jBtnDelete = new javax.swing.JButton();
        jBtnSave = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setModel(model);
        jScrollPane1.setViewportView(jTable1);

        jBtnAdd.setText("+");
        jBtnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnAddActionPerformed(evt);
            }
        });

        jBtnDelete.setText("-");
        jBtnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnDeleteActionPerformed(evt);
            }
        });

        jBtnSave.setText("s");
        jBtnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnSaveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 645, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jBtnAdd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jBtnDelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jBtnSave, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jBtnAdd)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jBtnDelete)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jBtnSave)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBtnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnAddActionPerformed
       
        Object []obj = new Object[2];
        //for(int i = 0; i < listSites.size(); i++){
            obj[0] = "";
            obj[1] = "";
            model.addRow(obj);
        //}
    }//GEN-LAST:event_jBtnAddActionPerformed

    private void jBtnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnDeleteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBtnDeleteActionPerformed

    private void jBtnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnSaveActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBtnSaveActionPerformed

    public void addRow(){
        Object []obj = new Object[2];        
        obj[0] = "";
        obj[1] = "";
        model.addRow(obj);
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
            java.util.logging.Logger.getLogger(SitesView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SitesView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SitesView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SitesView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SitesView(null).setVisible(true);
            }
        });
    }
    
    /*class SharedListSelectionHandler implements ListSelectionListener {
        public void valueChanged(ListSelectionEvent e) { 
            System.out.print("CHANGE");
        }
    }*/

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnAdd;
    private javax.swing.JButton jBtnDelete;
    private javax.swing.JButton jBtnSave;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
    private javax.swing.table.DefaultTableModel model;
}
