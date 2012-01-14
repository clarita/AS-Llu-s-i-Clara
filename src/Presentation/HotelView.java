/*
 * HotelView.java
 *
 * Created on 28/12/2011, 16:40:17
 */
package Presentation;

import TupleTypes.DadesHabitacio;
import TupleTypes.DadesHotel;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.border.TitledBorder;

/**
 * Classe que representa la informació d'un hotel, per ser inclosa al scroll
 * @author clara
 */
public class HotelView extends javax.swing.JPanel {

    private Window2 vistaPare;
    private String nomHotel;
    private ArrayList<String> nomsTipus = new ArrayList<String>();
    /** Creates new form HotelView */
    public HotelView(Window2 pare) {
        this.vistaPare = pare;
        initComponents();
    }
    
    public void loadData(DadesHotel hotel) {
        TitledBorder leftBorder = BorderFactory.createTitledBorder(hotel.nom);
        leftBorder.setTitleJustification(TitledBorder.LEFT);
        this.setBorder(leftBorder);
        nomHotel = hotel.nom;
        
        hotelDescriptionLabel.setText(hotel.desc);
        DefaultListModel model = new DefaultListModel();
        for(DadesHabitacio hab : hotel.habs){
            String dada = hab.tipusHab + " (" + hab.preu + "€) - " + 
                    hab.numeroDisp + " disponibles";
            model.addElement(dada);
            nomsTipus.add(hab.tipusHab);
        }
        tipusHabitacionsList.setModel(model);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        hotelDescriptionLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tipusHabitacionsList = new javax.swing.JList();

        hotelDescriptionLabel.setText("Description");

        tipusHabitacionsList.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        tipusHabitacionsList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                tipusHabitacionsListValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(tipusHabitacionsList);

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(hotelDescriptionLabel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 360, Short.MAX_VALUE)
                    .add(jScrollPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 360, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(hotelDescriptionLabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 30, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(30, 30, 30)
                .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 91, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(48, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tipusHabitacionsListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_tipusHabitacionsListValueChanged
        int selection = tipusHabitacionsList.getSelectedIndex();
        String tipusSeleccionat = nomsTipus.get(selection);
        vistaPare.habitacioWasSelected(nomHotel, tipusSeleccionat);
    }//GEN-LAST:event_tipusHabitacionsListValueChanged

    public void unselect() {
        this.tipusHabitacionsList.clearSelection();
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel hotelDescriptionLabel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList tipusHabitacionsList;
    // End of variables declaration//GEN-END:variables
}
