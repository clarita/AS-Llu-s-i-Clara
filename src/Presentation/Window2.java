/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Window2.java
 *
 * Created on 28/12/2011, 16:15:51
 */
package Presentation;

import TupleTypes.DadesHotel;
import TupleTypes.DadesReserva;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

/**
 *
 * @author clara
 */
public class Window2 extends javax.swing.JFrame {

    private ReservarHabitacioView viewController;
    Map<String,HotelView> contingutLlistaHotels = new HashMap<String,HotelView>();
    
    //atributs per facilitar el càlcul
    private String currentHotel;
    private String currentTipus;
    
    /** Creates new form Window2 */
    public Window2(ReservarHabitacioView controller) {
        this.viewController = controller;
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        initComponents();
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        poblacioLabel = new javax.swing.JLabel();
        poblacioValueLabel = new javax.swing.JLabel();
        dIniLabel = new javax.swing.JLabel();
        dIniValueLabel = new javax.swing.JLabel();
        dFiLabel = new javax.swing.JLabel();
        numOcLabel = new javax.swing.JLabel();
        dFiValueLabel = new javax.swing.JLabel();
        numOcValueLabel = new javax.swing.JLabel();
        hotelsScrollPanel = new javax.swing.JScrollPane();
        okButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        poblacioLabel.setText("Població");

        poblacioValueLabel.setText("jLabel2");

        dIniLabel.setText("Data d'inici");

        dIniValueLabel.setText("jLabel4");

        dFiLabel.setText("Data de finalització");

        numOcLabel.setText("Número d'ocupants");

        dFiValueLabel.setText("jLabel7");

        numOcValueLabel.setText("jLabel8");

        okButton.setText("D'acord");
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });

        cancelButton.setText("Cancel·la");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                        .add(layout.createSequentialGroup()
                            .add(numOcLabel)
                            .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .add(numOcValueLabel))
                        .add(layout.createSequentialGroup()
                            .add(dFiLabel)
                            .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .add(dFiValueLabel))
                        .add(layout.createSequentialGroup()
                            .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                .add(poblacioLabel)
                                .add(dIniLabel))
                            .add(81, 81, 81)
                            .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                                .add(poblacioValueLabel)
                                .add(dIniValueLabel))))
                    .add(hotelsScrollPanel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 477, Short.MAX_VALUE))
                .addContainerGap())
            .add(layout.createSequentialGroup()
                .add(78, 78, 78)
                .add(okButton, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 120, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 130, Short.MAX_VALUE)
                .add(cancelButton, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 120, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(69, 69, 69))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(poblacioLabel)
                    .add(poblacioValueLabel))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(dIniLabel)
                    .add(dIniValueLabel))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(dFiLabel)
                    .add(dFiValueLabel))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(numOcLabel)
                    .add(numOcValueLabel))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(hotelsScrollPanel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 198, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(18, 18, 18)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(okButton)
                    .add(cancelButton))
                .addContainerGap(41, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed
        if((currentHotel != null) && (currentTipus != null))
        viewController.confirmacioWindow2(currentHotel, currentTipus);
    }//GEN-LAST:event_okButtonActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        viewController.tanca();
    }//GEN-LAST:event_cancelButtonActionPerformed

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
            java.util.logging.Logger.getLogger(Window2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Window2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Window2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Window2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>


      
    }
    
    public void loadData(DadesReserva basicData, Set<DadesHotel> data) {
        SimpleDateFormat s = new SimpleDateFormat("dd/MM/yyyy");
        poblacioValueLabel.setText(basicData.pob);
        dIniValueLabel.setText(s.format(basicData.dIni));
        dFiValueLabel.setText(s.format(basicData.dFi));
        numOcValueLabel.setText(basicData.numOc.toString());
        System.out.println("printing " + data.size() + " hotels");
        
        JPanel infoHabPanel = new JPanel();
        infoHabPanel.setLayout(new BoxLayout(infoHabPanel, BoxLayout.Y_AXIS));
        
        for(DadesHotel hotel : data) {
            HotelView vistaHotel = new HotelView(this);
            vistaHotel.loadData(hotel);
            infoHabPanel.add(vistaHotel);
            contingutLlistaHotels.put(hotel.nom,vistaHotel);
        }
        hotelsScrollPanel.setViewportView(infoHabPanel);
        hotelsScrollPanel.validate();
    }
    
    public void habitacioWasSelected(String nomHotel, String nomTipus) {
        currentHotel = nomHotel;
        currentTipus = nomTipus;
        
        //eliminem la selecció sobre els altres hotels
        Set<String> mapKeys = contingutLlistaHotels.keySet();
        for(String key : mapKeys) {
            if(!key.equals(nomHotel)){
                contingutLlistaHotels.get(key).unselect();
            }
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelButton;
    private javax.swing.JLabel dFiLabel;
    private javax.swing.JLabel dFiValueLabel;
    private javax.swing.JLabel dIniLabel;
    private javax.swing.JLabel dIniValueLabel;
    private javax.swing.JScrollPane hotelsScrollPanel;
    private javax.swing.JLabel numOcLabel;
    private javax.swing.JLabel numOcValueLabel;
    private javax.swing.JButton okButton;
    private javax.swing.JLabel poblacioLabel;
    private javax.swing.JLabel poblacioValueLabel;
    // End of variables declaration//GEN-END:variables
}
