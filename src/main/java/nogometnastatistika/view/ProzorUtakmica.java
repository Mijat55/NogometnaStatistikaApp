/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package nogometnastatistika.view;

import com.github.lgooddatepicker.components.DatePickerSettings;
import com.github.lgooddatepicker.components.TimePickerSettings;
import java.awt.Toolkit;
import java.sql.Time;
import java.time.Instant;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import nogometnastatistika.controller.ObradaKlub;
import nogometnastatistika.controller.ObradaUtakmica;
import nogometnastatistika.model.Klub;
import nogometnastatistika.model.Utakmica;
import nogometnastatistika.util.Aplikacija;
import nogometnastatistika.util.NogometnaStatistikaException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

/**
 *
 * @author Marko
 */
public class ProzorUtakmica extends javax.swing.JFrame {
private ObradaUtakmica obrada;

    /**
     * Creates new form ProzorUtakmica
     */
    public ProzorUtakmica() {
        initComponents();
        setIcon();
           obrada = new ObradaUtakmica();
        setTitle(Aplikacija.NAZIV_APP + ": " + 
                Aplikacija.OPERATER.getImePrezime() +
                ": Utakmice");
        definirajDatumPocetka();
        ucitajDomaceKlubove();
        ucitajGostujuceKlubove();
        ucitaj();
    }
   private void ucitaj(){
        DefaultListModel<Utakmica> m = new DefaultListModel<>();
    m.addAll(obrada.read());

    lstPodaci.setModel(m);
    lstPodaci.repaint();
    
}
    private void ucitajDomaceKlubove(){
        DefaultComboBoxModel<Klub> m
                = new DefaultComboBoxModel<>();
        Klub k = new Klub();
        k.setSifra(0);
        k.setNaziv("Nije odabrano");
        m.addElement(k);
        m.addAll(new ObradaKlub().read());
        cmbDomaciKlub.setModel(m);
        cmbDomaciKlub.repaint();
        
    }
     private void ucitajGostujuceKlubove(){
        DefaultComboBoxModel<Klub> m
                = new DefaultComboBoxModel<>();
        Klub k = new Klub();
        k.setSifra(0);
        k.setNaziv("Nije odabrano");
        m.addElement(k);
        m.addAll(new ObradaKlub().read());
        cmbGostiKlub.setModel(m);
        cmbGostiKlub.repaint();
        
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
        lstPodaci = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtBrojNavijaca = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtStadion = new javax.swing.JTextField();
        btnDodaj = new javax.swing.JButton();
        btnPromjeni = new javax.swing.JButton();
        btnObrisi = new javax.swing.JButton();
        cmbDomaciKlub = new javax.swing.JComboBox<>();
        cmbGostiKlub = new javax.swing.JComboBox<>();
        dpDatumPocetka = new com.github.lgooddatepicker.components.DateTimePicker();
        btnIgrac = new javax.swing.JButton();
        btnVrsta = new javax.swing.JButton();
        btnDogadjaj = new javax.swing.JButton();
        btnIzbornik = new javax.swing.JButton();
        btnIzlaz = new javax.swing.JButton();
        btnKlub = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        lstPodaci.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lstPodaci.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        lstPodaci.setFont(new java.awt.Font("Georgia", 3, 12)); // NOI18N
        lstPodaci.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstPodaciValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(lstPodaci);

        jLabel1.setText("~Domaći Klub~");
        jLabel1.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N

        jLabel2.setText("~Gostujući Klub~");
        jLabel2.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N

        jLabel3.setText("~Datum i vrijeme početka ~");
        jLabel3.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N

        jLabel4.setText("~Broj navijača ~");
        jLabel4.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N

        txtBrojNavijaca.setFont(new java.awt.Font("Georgia", 3, 12)); // NOI18N
        txtBrojNavijaca.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtBrojNavijaca.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel5.setText("~Stadion ~");
        jLabel5.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N

        txtStadion.setFont(new java.awt.Font("Georgia", 3, 12)); // NOI18N
        txtStadion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btnDodaj.setText("Dodaj");
        btnDodaj.setFont(new java.awt.Font("Georgia", 1, 12)); // NOI18N
        btnDodaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDodajActionPerformed(evt);
            }
        });

        btnPromjeni.setText("Promjeni");
        btnPromjeni.setFont(new java.awt.Font("Georgia", 1, 12)); // NOI18N
        btnPromjeni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPromjeniActionPerformed(evt);
            }
        });

        btnObrisi.setText("Obriši");
        btnObrisi.setFont(new java.awt.Font("Georgia", 1, 12)); // NOI18N
        btnObrisi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnObrisiActionPerformed(evt);
            }
        });

        cmbDomaciKlub.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        cmbDomaciKlub.setFont(new java.awt.Font("Georgia", 3, 12)); // NOI18N

        cmbGostiKlub.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        cmbGostiKlub.setFont(new java.awt.Font("Georgia", 3, 12)); // NOI18N

        btnIgrac.setFont(new java.awt.Font("Georgia", 1, 12)); // NOI18N
        btnIgrac.setText("Igrač");
        btnIgrac.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));
        btnIgrac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIgracActionPerformed(evt);
            }
        });

        btnVrsta.setFont(new java.awt.Font("Georgia", 1, 12)); // NOI18N
        btnVrsta.setText("Vrsta");
        btnVrsta.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));
        btnVrsta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVrstaActionPerformed(evt);
            }
        });

        btnDogadjaj.setFont(new java.awt.Font("Georgia", 1, 12)); // NOI18N
        btnDogadjaj.setText("Događaj");
        btnDogadjaj.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));
        btnDogadjaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDogadjajActionPerformed(evt);
            }
        });

        btnIzbornik.setFont(new java.awt.Font("Georgia", 1, 12)); // NOI18N
        btnIzbornik.setText("Izbornik");
        btnIzbornik.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));
        btnIzbornik.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIzbornikActionPerformed(evt);
            }
        });

        btnIzlaz.setFont(new java.awt.Font("Georgia", 1, 12)); // NOI18N
        btnIzlaz.setText("Izlaz");
        btnIzlaz.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));
        btnIzlaz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIzlazActionPerformed(evt);
            }
        });

        btnKlub.setFont(new java.awt.Font("Georgia", 1, 12)); // NOI18N
        btnKlub.setText("Klub");
        btnKlub.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));
        btnKlub.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKlubActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnDodaj)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnPromjeni)
                                .addGap(12, 12, 12)
                                .addComponent(btnObrisi, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel3)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel1)
                                                    .addComponent(cmbDomaciKlub, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jLabel2))
                                                .addComponent(cmbGostiKlub, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addComponent(dpDatumPocetka, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addComponent(txtBrojNavijaca, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtStadion, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnIzbornik, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnKlub, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnIgrac, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnVrsta, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDogadjaj, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnIzlaz, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnIzbornik)
                    .addComponent(btnKlub)
                    .addComponent(btnIgrac)
                    .addComponent(btnVrsta)
                    .addComponent(btnDogadjaj)
                    .addComponent(btnIzlaz))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbDomaciKlub, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(9, 9, 9)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbGostiKlub, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dpDatumPocetka, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(9, 9, 9)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtBrojNavijaca, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)
                        .addGap(5, 5, 5)
                        .addComponent(txtStadion, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnDodaj)
                            .addComponent(btnPromjeni)
                            .addComponent(btnObrisi))))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnDodajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDodajActionPerformed
       obrada.setEntitet(new Utakmica());
       napuniModel();
        try {
            obrada.create();
            ucitaj();
        } catch (NogometnaStatistikaException ex) {
            JOptionPane.showMessageDialog(getRootPane(), ex.getPoruka()); }
    }//GEN-LAST:event_btnDodajActionPerformed

    private void lstPodaciValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lstPodaciValueChanged
      if(evt.getValueIsAdjusting()){
           return;
       }
       if(lstPodaci.getSelectedValue()==null){
           return;
       }
       obrada.setEntitet(lstPodaci.getSelectedValue());
       
       napuniView();
    }//GEN-LAST:event_lstPodaciValueChanged

    private void btnPromjeniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPromjeniActionPerformed
      if(lstPodaci.getSelectedValue()==null){
           JOptionPane.showMessageDialog(getRootPane(), "Prvo odaberite utakmicu :)");
           return;
       }
      if(JOptionPane.showConfirmDialog(getRootPane(),"Sigurno promjeniti 👀" + " " + obrada.getEntitet().getDomaciGosti()+" " + "?" + " ","Brisanje"
              ,JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE)==JOptionPane.NO_OPTION){
          return;}
       
       napuniModel();
        try {
            obrada.update();
            ucitaj();
        } catch (NogometnaStatistikaException ex) {
JOptionPane.showMessageDialog(getRootPane(), ex.getPoruka());        }
    }//GEN-LAST:event_btnPromjeniActionPerformed

    private void btnObrisiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnObrisiActionPerformed
           if(lstPodaci.getSelectedValue()==null){
          JOptionPane.showMessageDialog(getRootPane(), "Prvo odaberite utakmicu");
          return;
      }
           if(JOptionPane.showConfirmDialog(getRootPane(), "Sigurno obrisati" + " " + obrada.getEntitet().getDomaciGosti()+" " + "?"+"😱","Brisanje"
              ,JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE)==JOptionPane.NO_OPTION){
          return;
      }
         try {
            obrada.delete();
            ucitaj();
        } catch (NogometnaStatistikaException ex) {
JOptionPane.showMessageDialog(getRootPane(), ex.getPoruka());        }
    }//GEN-LAST:event_btnObrisiActionPerformed

    private void btnIgracActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIgracActionPerformed
        new ProzorIgrac().setVisible(true);
        dispose();
    }//GEN-LAST:event_btnIgracActionPerformed

    private void btnVrstaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVrstaActionPerformed
        new ProzorVrsta().setVisible(true);
        dispose();
    }//GEN-LAST:event_btnVrstaActionPerformed

    private void btnDogadjajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDogadjajActionPerformed
        new ProzorDogadjaj().setVisible(true);
        dispose();
    }//GEN-LAST:event_btnDogadjajActionPerformed

    private void btnIzbornikActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIzbornikActionPerformed
        new ProzorIzbornik().setVisible(true);
        dispose();
    }//GEN-LAST:event_btnIzbornikActionPerformed

    private void btnIzlazActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIzlazActionPerformed
        dispose();
    }//GEN-LAST:event_btnIzlazActionPerformed

    private void btnKlubActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKlubActionPerformed
        new ProzorKlub().setVisible(true);
        dispose();
    }//GEN-LAST:event_btnKlubActionPerformed
 private void napuniView(){
    var u = obrada.getEntitet();
    cmbDomaciKlub.setSelectedItem(u.getDomaciKlub());
    cmbGostiKlub.setSelectedItem(u.getGostiKlub());
    txtBrojNavijaca.setText(String.valueOf(u.getMaksimalanBrojNavijaca()));
    LocalDate ld = u.getVrijemePocetka().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    dpDatumPocetka.datePicker.setDate(ld);
    LocalTime lt = u.getVrijemePocetka().toInstant().atZone(ZoneId.systemDefault()).toLocalTime();
    dpDatumPocetka.timePicker.setTime(lt);
    txtStadion.setText(u.getStadion());
}
    
    
    
    private void napuniModel(){
    var u = obrada.getEntitet();
   u.setDomaciKlub((Klub)cmbDomaciKlub.getSelectedItem());
   u.setGostiKlub((Klub)cmbGostiKlub.getSelectedItem());
   LocalDate ld = dpDatumPocetka.datePicker.getDate();
   LocalTime lt = dpDatumPocetka.timePicker.getTime();
   LocalDateTime fromDateAndTime = LocalDateTime.of(ld,
                                                           lt);
   Date datum = Date.from(fromDateAndTime.atZone(ZoneId.systemDefault()).toInstant());
   u.setVrijemePocetka(datum);
  
     try {
       u.setMaksimalanBrojNavijaca(Integer.parseInt(txtBrojNavijaca.getText()));
     } catch (Exception e) {
         u.setMaksimalanBrojNavijaca( 0);
     }
     u.setStadion(txtStadion.getText());
    
    
}
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDodaj;
    private javax.swing.JButton btnDogadjaj;
    private javax.swing.JButton btnIgrac;
    private javax.swing.JButton btnIzbornik;
    private javax.swing.JButton btnIzlaz;
    private javax.swing.JButton btnKlub;
    private javax.swing.JButton btnObrisi;
    private javax.swing.JButton btnPromjeni;
    private javax.swing.JButton btnVrsta;
    private javax.swing.JComboBox<Klub> cmbDomaciKlub;
    private javax.swing.JComboBox<Klub> cmbGostiKlub;
    private com.github.lgooddatepicker.components.DateTimePicker dpDatumPocetka;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<Utakmica> lstPodaci;
    private javax.swing.JTextField txtBrojNavijaca;
    private javax.swing.JTextField txtStadion;
    // End of variables declaration//GEN-END:variables

    private void setIcon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/ball.png" )));

    }

    private void definirajDatumPocetka() {
        DatePickerSettings dps = new DatePickerSettings(new Locale("hr", "HR"));
        dps.setFormatForDatesCommonEra("dd. MM. YYY. ");
        dps.setTranslationClear("Očisti");
       dpDatumPocetka.datePicker.setSettings(dps);
        
        
       TimePickerSettings tps = new TimePickerSettings(new Locale("hr", "HR"));
       tps.setFormatForDisplayTime("HH:mm");
      dpDatumPocetka.timePicker
                .getSettings()
         
               .use24HourClockFormat();
        
        ArrayList<LocalTime> lista = new ArrayList<>();
        
        for(int j=0;j<24;j++){
        for(int i=0;i<60;i+=5){
            lista.add(LocalTime.of(j, i));
        }
        }
        
        
        dpDatumPocetka.timePicker.getSettings()
                .generatePotentialMenuTimes(lista);
   
}
}
