/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Window4.java
 *
 * Created on 05/01/2012, 15:21:14
 */
package Presentation;

import TupleTypes.DadesReserva;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lluisgh28
 */
public class Window4 extends javax.swing.JFrame {

    ReservarHabitacioView viewController;
    
    /** Creates new form Window4 */
    public Window4(ReservarHabitacioView viewController) {
        this.viewController = viewController;
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        initComponents();
    }
    
    public void mostraDades(DadesReserva dades) {
        poblacioValueLabel.setText(dades.pob);
        SimpleDateFormat s = new SimpleDateFormat("dd/MM/yyyy");
        dataIniciValueLabel.setText(s.format(dades.dIni));
        dataFiValueLabel.setText(s.format(dades.dFi));
        numOcupValueLabel.setText(dades.numOc.toString());
        
        hotelValueLabel.setText(dades.nomHotel);
        habitacioValueLabel.setText(dades.nomTipusHab);
        preuTotalValueLabel.setText(dades.preuTotal.toString());
        
        dniValueLabel.setText(dades.dni);
        nomValueLabel.setText(dades.nomClient);
        cognomsValueLabel.setText(dades.cognomsClient);
        emailValueLabel.setText(dades.emailClient);        
    }

    public void mostraError(String m){
        messageAreaLabel.setText(m);
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dacord = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        dataIniciValueLabel = new javax.swing.JLabel();
        poblacioValueLabel = new javax.swing.JLabel();
        dataFiValueLabel = new javax.swing.JLabel();
        numOcupValueLabel = new javax.swing.JLabel();
        hotelValueLabel = new javax.swing.JLabel();
        habitacioValueLabel = new javax.swing.JLabel();
        preuTotalValueLabel = new javax.swing.JLabel();
        numTargTextField = new javax.swing.JTextField();
        dniValueLabel = new javax.swing.JLabel();
        nomValueLabel = new javax.swing.JLabel();
        cognomsValueLabel = new javax.swing.JLabel();
        emailValueLabel = new javax.swing.JLabel();
        dataCadTextField = new javax.swing.JFormattedTextField();
        messageAreaLabel = new javax.swing.JLabel();

        dacord.setText("D'acord");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel8.setText("Número de targeta");

        jButton1.setText("D'acord");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dacordActionPerformed(evt);
            }
        });

        jButton2.setText("Cancel·la");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelaActionPerformed(evt);
            }
        });

        jLabel7.setText("Preu total");

        jLabel9.setText("Data de caducitat");

        jLabel6.setText("Habitació");

        jLabel3.setText("Data de finalització");

        jLabel2.setText("Data d'inici");

        jLabel1.setText("Població");

        jLabel5.setText("Hotel");

        jLabel4.setText("Número d'ocupants");

        jLabel10.setText("DNI");

        jLabel11.setText("Nom");

        jLabel12.setText("Cognoms");

        jLabel13.setText("E-Mail");

        dataIniciValueLabel.setText("jLabel2");

        poblacioValueLabel.setText("jLabel2");

        dataFiValueLabel.setText("jLabel2");

        numOcupValueLabel.setText("jLabel2");

        hotelValueLabel.setText("jLabel2");

        habitacioValueLabel.setText("jLabel2");

        preuTotalValueLabel.setText("jLabel2");

        numTargTextField.setText("jTextField7");

        dniValueLabel.setText("jLabel2");

        nomValueLabel.setText("jLabel2");

        cognomsValueLabel.setText("jLabel2");

        emailValueLabel.setText("jLabel2");

        dataCadTextField.setText("jFormattedTextField1");
        dataCadTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dataCadTextFieldActionPerformed(evt);
            }
        });

        messageAreaLabel.setText(" ");

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .addContainerGap()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jLabel1)
                            .add(jLabel2)
                            .add(jLabel3)
                            .add(jLabel4)
                            .add(jLabel8)
                            .add(jLabel5)
                            .add(jLabel6)
                            .add(jLabel7)
                            .add(jLabel9))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(layout.createSequentialGroup()
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                    .add(preuTotalValueLabel)
                                    .add(habitacioValueLabel)
                                    .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                                            .add(org.jdesktop.layout.GroupLayout.LEADING, layout.createSequentialGroup()
                                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                                    .add(dataIniciValueLabel)
                                                    .add(poblacioValueLabel)
                                                    .add(dataFiValueLabel)
                                                    .add(numOcupValueLabel))
                                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                                    .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                                                        .add(135, 135, 135)
                                                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                                            .add(jLabel13)
                                                            .add(jLabel12))
                                                        .add(26, 26, 26))
                                                    .add(layout.createSequentialGroup()
                                                        .add(134, 134, 134)
                                                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                                            .add(jLabel10)
                                                            .add(jLabel11))
                                                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 57, Short.MAX_VALUE)))
                                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                                                    .add(dniValueLabel)
                                                    .add(nomValueLabel)
                                                    .add(cognomsValueLabel)
                                                    .add(emailValueLabel)))
                                            .add(layout.createSequentialGroup()
                                                .add(jButton1)
                                                .add(64, 64, 64)
                                                .add(jButton2)))
                                        .add(112, 112, 112))
                                    .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING, false)
                                        .add(org.jdesktop.layout.GroupLayout.LEADING, dataCadTextField)
                                        .add(org.jdesktop.layout.GroupLayout.LEADING, numTargTextField, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 266, Short.MAX_VALUE)))
                                .add(85, 85, 85))
                            .add(hotelValueLabel)))
                    .add(layout.createSequentialGroup()
                        .add(95, 95, 95)
                        .add(messageAreaLabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 442, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(layout.createSequentialGroup()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                            .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                                .add(jLabel1)
                                .add(poblacioValueLabel))
                            .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                                .add(dniValueLabel)
                                .add(jLabel10, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 16, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                            .add(jLabel2)
                            .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                                .add(nomValueLabel)
                                .add(jLabel11))))
                    .add(dataIniciValueLabel))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                        .add(jLabel3)
                        .add(dataFiValueLabel))
                    .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                        .add(cognomsValueLabel)
                        .add(jLabel12)))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                        .add(jLabel4)
                        .add(numOcupValueLabel))
                    .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                        .add(emailValueLabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 16, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(jLabel13, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 16, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .add(22, 22, 22)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel5)
                    .add(hotelValueLabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 16, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel6)
                    .add(habitacioValueLabel))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel7)
                    .add(preuTotalValueLabel))
                .add(47, 47, 47)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel8)
                    .add(numTargTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel9)
                    .add(dataCadTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(messageAreaLabel)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 13, Short.MAX_VALUE)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jButton1)
                    .add(jButton2))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
        
    private void dataCadTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dataCadTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dataCadTextFieldActionPerformed

    private void cancelaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelaActionPerformed
        viewController.tanca();
    }//GEN-LAST:event_cancelaActionPerformed

    private void dacordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dacordActionPerformed
        SimpleDateFormat s = new SimpleDateFormat("dd/MM/yyyy");
        String numTarg = numTargTextField.getText();
        if (numTarg.length() <= 0) mostraError("Has d'indicar un número de targeta.");
        else {
            try {
                Date dCad = s.parse(dataCadTextField.getText());
                viewController.confirmacioWindow4(numTarg, dCad);
            } catch (ParseException ex) {
                mostraError("La data s'ha d'indicar amb format dd/mm/aaaa.");
            }
        }
    }//GEN-LAST:event_dacordActionPerformed

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
            java.util.logging.Logger.getLogger(Window4.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Window4.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Window4.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Window4.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel cognomsValueLabel;
    private javax.swing.JButton dacord;
    private javax.swing.JFormattedTextField dataCadTextField;
    private javax.swing.JLabel dataFiValueLabel;
    private javax.swing.JLabel dataIniciValueLabel;
    private javax.swing.JLabel dniValueLabel;
    private javax.swing.JLabel emailValueLabel;
    private javax.swing.JLabel habitacioValueLabel;
    private javax.swing.JLabel hotelValueLabel;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel messageAreaLabel;
    private javax.swing.JLabel nomValueLabel;
    private javax.swing.JLabel numOcupValueLabel;
    private javax.swing.JTextField numTargTextField;
    private javax.swing.JLabel poblacioValueLabel;
    private javax.swing.JLabel preuTotalValueLabel;
    // End of variables declaration//GEN-END:variables
}
