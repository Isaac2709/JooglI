/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import controllers.InfoCPUController;
import controllers.SearchEngineController;
import java.util.ArrayList;
import models.InfoSystem;
import models.Token;
import views.SearchEngineView;
//import org.jfree.chart.axis.NumberAxis; 
import org.jfree.chart.*;

import org.jfree.chart.renderer.xy.XYSplineRenderer;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.axis.*;
import org.jfree.data.xy.*;

import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import org.jfree.data.general.DefaultPieDataset;
/*import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
*/



/**
 *
 * @author luigi
 */
public class StatisticsView extends javax.swing.JFrame {
    private InfoCPUController infoCPU;
    
    /**
     * Creates new form StatisticsView
     */
    public StatisticsView() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.jBarMatchesSequentialGraphPane.setVisible(false);
        this.jBarGraphicPane.setVisible(false);
        this.jBarTimeParallelPane.setVisible(false);
        this.jCoreStatistics.setVisible(false);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMainPane = new javax.swing.JLayeredPane();
        jBarMatchesSequentialGraphPane = new javax.swing.JPanel();
        jBarGraphicPane = new javax.swing.JPanel();
        jBarTimeParallelPane = new javax.swing.JPanel();
        jCoreStatistics = new javax.swing.JPanel();
        jMatchesSequentialGraphRadioBtn = new javax.swing.JRadioButton();
        jTimeSequentialGraphicRadioBtn = new javax.swing.JRadioButton();
        jMatchesParallelRadioBtn = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jCPURadioBtn = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(800, 600));
        setSize(new java.awt.Dimension(800, 600));

        jMainPane.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout jBarMatchesSequentialGraphPaneLayout = new javax.swing.GroupLayout(jBarMatchesSequentialGraphPane);
        jBarMatchesSequentialGraphPane.setLayout(jBarMatchesSequentialGraphPaneLayout);
        jBarMatchesSequentialGraphPaneLayout.setHorizontalGroup(
            jBarMatchesSequentialGraphPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 456, Short.MAX_VALUE)
        );
        jBarMatchesSequentialGraphPaneLayout.setVerticalGroup(
            jBarMatchesSequentialGraphPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 358, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jBarGraphicPaneLayout = new javax.swing.GroupLayout(jBarGraphicPane);
        jBarGraphicPane.setLayout(jBarGraphicPaneLayout);
        jBarGraphicPaneLayout.setHorizontalGroup(
            jBarGraphicPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 188, Short.MAX_VALUE)
        );
        jBarGraphicPaneLayout.setVerticalGroup(
            jBarGraphicPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 362, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jBarTimeParallelPaneLayout = new javax.swing.GroupLayout(jBarTimeParallelPane);
        jBarTimeParallelPane.setLayout(jBarTimeParallelPaneLayout);
        jBarTimeParallelPaneLayout.setHorizontalGroup(
            jBarTimeParallelPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 476, Short.MAX_VALUE)
        );
        jBarTimeParallelPaneLayout.setVerticalGroup(
            jBarTimeParallelPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 336, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jCoreStatisticsLayout = new javax.swing.GroupLayout(jCoreStatistics);
        jCoreStatistics.setLayout(jCoreStatisticsLayout);
        jCoreStatisticsLayout.setHorizontalGroup(
            jCoreStatisticsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 476, Short.MAX_VALUE)
        );
        jCoreStatisticsLayout.setVerticalGroup(
            jCoreStatisticsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 358, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jMainPaneLayout = new javax.swing.GroupLayout(jMainPane);
        jMainPane.setLayout(jMainPaneLayout);
        jMainPaneLayout.setHorizontalGroup(
            jMainPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jMainPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jBarMatchesSequentialGraphPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jMainPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jMainPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jBarGraphicPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
            .addGroup(jMainPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jMainPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jBarTimeParallelPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
            .addGroup(jMainPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jMainPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jCoreStatistics, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jMainPaneLayout.setVerticalGroup(
            jMainPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jMainPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jBarMatchesSequentialGraphPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jMainPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jMainPaneLayout.createSequentialGroup()
                    .addGap(10, 10, 10)
                    .addComponent(jBarGraphicPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
            .addGroup(jMainPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jMainPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jBarTimeParallelPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
            .addGroup(jMainPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jMainPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jCoreStatistics, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jMainPane.setLayer(jBarMatchesSequentialGraphPane, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jMainPane.setLayer(jBarGraphicPane, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jMainPane.setLayer(jBarTimeParallelPane, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jMainPane.setLayer(jCoreStatistics, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jMatchesSequentialGraphRadioBtn.setText("Coincidencias");
        jMatchesSequentialGraphRadioBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMatchesSequentialGraphRadioBtnActionPerformed(evt);
            }
        });

        jTimeSequentialGraphicRadioBtn.setText("Tiempo total por sitio");
        jTimeSequentialGraphicRadioBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTimeSequentialGraphicRadioBtnActionPerformed(evt);
            }
        });

        jMatchesParallelRadioBtn.setText("Coincidencias");
        jMatchesParallelRadioBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMatchesParallelRadioBtnActionPerformed(evt);
            }
        });

        jLabel1.setText("Graficos Secuenciales");

        jLabel2.setText("Graficos Multinucleo");

        jLabel3.setText("Informacin del sistema");

        jCPURadioBtn.setText("Informacion del CPU");
        jCPURadioBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCPURadioBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jMatchesSequentialGraphRadioBtn)
                            .addComponent(jMatchesParallelRadioBtn)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jCPURadioBtn)
                            .addComponent(jLabel3))
                        .addGap(39, 39, 39))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jTimeSequentialGraphicRadioBtn)
                        .addGap(18, 18, 18)))
                .addComponent(jMainPane))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jMainPane)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jMatchesSequentialGraphRadioBtn)
                .addGap(31, 31, 31)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTimeSequentialGraphicRadioBtn)
                .addGap(28, 28, 28)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jMatchesParallelRadioBtn)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jCPURadioBtn)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMatchesSequentialGraphRadioBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMatchesSequentialGraphRadioBtnActionPerformed
        jMatchesParallelRadioBtn.setSelected(false);
        jTimeSequentialGraphicRadioBtn.setSelected(false);
        jCPURadioBtn.setSelected(false);
        jBarMatchesSequentialGraphPane.setVisible(true);
        jMainPane.setLayer(jBarMatchesSequentialGraphPane, 0, 0);
        jBarGraphicPane.setVisible(false);
        jBarTimeParallelPane.setVisible(false);
        jCoreStatistics.setVisible(false);
        loadGraphic();
    }//GEN-LAST:event_jMatchesSequentialGraphRadioBtnActionPerformed

    private void jTimeSequentialGraphicRadioBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTimeSequentialGraphicRadioBtnActionPerformed
        jMatchesSequentialGraphRadioBtn.setSelected(false);
        jMatchesParallelRadioBtn.setSelected(false);
        jCPURadioBtn.setSelected(false);
        jBarGraphicPane.setVisible(true);
        jMainPane.setLayer(jBarGraphicPane, 0, 0);
        jBarMatchesSequentialGraphPane.setVisible(false);
        jBarTimeParallelPane.setVisible(false);
        jCoreStatistics.setVisible(false);
        loadGraphic();
    }//GEN-LAST:event_jTimeSequentialGraphicRadioBtnActionPerformed

    private void jMatchesParallelRadioBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMatchesParallelRadioBtnActionPerformed
        jTimeSequentialGraphicRadioBtn.setSelected(false);
        jMatchesSequentialGraphRadioBtn.setSelected(false);
        jCPURadioBtn.setSelected(false);
        jBarTimeParallelPane.setVisible(true);
        jMainPane.setLayer(jBarTimeParallelPane, 0, 0);
        jBarMatchesSequentialGraphPane.setVisible(false);
        jBarGraphicPane.setVisible(false);
        jCoreStatistics.setVisible(false);
        loadGraphic();
    }//GEN-LAST:event_jMatchesParallelRadioBtnActionPerformed

    private void jCPURadioBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCPURadioBtnActionPerformed
        jMatchesParallelRadioBtn.setSelected(false);
        jTimeSequentialGraphicRadioBtn.setSelected(false);
        jMatchesSequentialGraphRadioBtn.setSelected(false);               
        jCoreStatistics.setVisible(true);
        jMainPane.setLayer(jCoreStatistics, 0, 0);
        jBarTimeParallelPane.setVisible(false);
        jBarMatchesSequentialGraphPane.setVisible(false);
        jBarGraphicPane.setVisible(false);
        //InfoSystem infoSystem = new InfoSystem();   
        //infoSystem.printInfo();
        infoCPU = new controllers.InfoCPUController();
        //infoCPU.imprimirInfoCPU();
        loadGraphic();        
    }//GEN-LAST:event_jCPURadioBtnActionPerformed

    private void loadGraphic(){
        ChartPanel panel;
        JFreeChart chart = null;
        if(jMatchesSequentialGraphRadioBtn.isSelected()){
            DefaultCategoryDataset data = new DefaultCategoryDataset();
            for(int i=0;i<SearchEngineView.listSitesSequential.size();i++){
                
                //data.addValue(totalmilis, palabra, sitio);
                ArrayList<Token> listTokenMatch= SearchEngineView.listSitesSequential.get(i).getListTokensMatches();
                for(int i2=0;i2<listTokenMatch.size();i2++){
                    data.addValue(listTokenMatch.get(i2).getNumberMatches(), listTokenMatch.get(i2).getToken(), SearchEngineView.listSitesSequential.get(i).getTitle());
                }
            }
            chart = ChartFactory.createBarChart("Cantidad de coincidencias por sitio", 
                    "Paginas",
                    "Cantidad de Coincidencias", 
                    data, 
                    PlotOrientation.HORIZONTAL, 
                    true, 
                    true, 
                    true
            );
            
            CategoryPlot plot = (CategoryPlot) chart.getCategoryPlot();
            plot.setDomainGridlinesVisible(true);
            
        }
        else if(jTimeSequentialGraphicRadioBtn.isSelected()){
            DefaultCategoryDataset data = new DefaultCategoryDataset();
            for(int i=0;i<SearchEngineView.listSitesSequential.size();i++){
                
                //data.addValue(totalmilis, palabra, sitio);
                ArrayList<Token> listTokenMatch= SearchEngineView.listSitesSequential.get(i).getListTokensMatches();
                for(int i2=0;i2<listTokenMatch.size();i2++){
                    data.addValue(listTokenMatch.get(i2).getTotalMachTime(), listTokenMatch.get(i2).getToken(), SearchEngineView.listSitesSequential.get(i).getTitle());
                }
            }
            chart = ChartFactory.createBarChart("Tiempo Total por PaginaWeb", 
                    "Paginas",
                    "Tiempo en milisegundos", 
                    data, 
                    PlotOrientation.HORIZONTAL, 
                    true, 
                    true, 
                    true
            );
            
            CategoryPlot plot = (CategoryPlot) chart.getCategoryPlot();
            plot.setDomainGridlinesVisible(true);
        }
        else if(jMatchesParallelRadioBtn.isSelected()){
            DefaultCategoryDataset data = new DefaultCategoryDataset();
            for(int i=0;i<SearchEngineView.listSitesParallel.size();i++){
                
                //data.addValue(totalmilis, palabra, sitio);
                ArrayList<Token> listTokenMatch= SearchEngineView.listSitesParallel.get(i).getListTokensMatches();
                for(int i2=0;i2<listTokenMatch.size();i2++){
                    data.addValue(listTokenMatch.get(i2).getTotalMachTime(), listTokenMatch.get(i2).getToken(), SearchEngineView.listSitesParallel.get(i).getTitle());
                }
            }
            chart = ChartFactory.createBarChart("Tiempo Total por PaginaWeb", 
                    "Paginas",
                    "Tiempo en milisegundos", 
                    data, 
                    PlotOrientation.HORIZONTAL, 
                    true, 
                    true, 
                    true
            );
            
            CategoryPlot plot = (CategoryPlot) chart.getCategoryPlot();
            plot.setDomainGridlinesVisible(true);
        }
        else if(jCPURadioBtn.isSelected()){
            DefaultPieDataset data = new DefaultPieDataset();
            ArrayList consumoCPU = infoCPU.getInfoCPU();
            for(int i = 0; i<consumoCPU.size() - 1; i++){
                String consumo = consumoCPU.get(i).toString();
                System.out.println("Consumo de CPU"+ (i + 1) +": " + Double.parseDouble(consumo.substring(0, consumo.length() - 2)));
                data.setValue("CPU " + (i + 1), Double.parseDouble(consumo.substring(0, consumo.length() - 2)));
            }
            
            /*data.setValue("Categoria 2", 10);
            data.setValue("Categoria 3", 40);
            data.setValue("Categoria 4", 60);*/
            
            chart = ChartFactory.createPieChart("Grafico De Consumo Por CPU", data, true, true, true);               
        }
        panel = new ChartPanel(chart);
        panel.setBounds(5, 10, 410, 350);    
        rePaint(panel);
    }
    
    private void rePaint(ChartPanel panel){
        if(jMatchesSequentialGraphRadioBtn.isSelected()){
            jBarMatchesSequentialGraphPane.add(panel);
            jBarMatchesSequentialGraphPane.repaint();
        }
        else if(jTimeSequentialGraphicRadioBtn.isSelected()){
            jBarGraphicPane.add(panel);
            jBarGraphicPane.repaint();
        }
        else if(jMatchesParallelRadioBtn.isSelected()){
            jBarTimeParallelPane.add(panel);
            jBarTimeParallelPane.repaint();
        }
        else if(jCPURadioBtn.isSelected()){
            jCoreStatistics.add(panel);
            jCoreStatistics.repaint();
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
            java.util.logging.Logger.getLogger(StatisticsView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StatisticsView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StatisticsView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StatisticsView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StatisticsView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jBarGraphicPane;
    private javax.swing.JPanel jBarMatchesSequentialGraphPane;
    private javax.swing.JPanel jBarTimeParallelPane;
    private javax.swing.JRadioButton jCPURadioBtn;
    private javax.swing.JPanel jCoreStatistics;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLayeredPane jMainPane;
    private javax.swing.JRadioButton jMatchesParallelRadioBtn;
    private javax.swing.JRadioButton jMatchesSequentialGraphRadioBtn;
    private javax.swing.JRadioButton jTimeSequentialGraphicRadioBtn;
    // End of variables declaration//GEN-END:variables
}
