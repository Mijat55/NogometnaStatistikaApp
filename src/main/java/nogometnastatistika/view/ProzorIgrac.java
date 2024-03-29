/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package nogometnastatistika.view;

import com.github.lgooddatepicker.components.DatePickerSettings;

import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.math.BigDecimal;
import java.sql.Time;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Locale;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import nogometnastatistika.controller.ObradaIgrac;
import nogometnastatistika.controller.ObradaKlub;
import nogometnastatistika.model.Dogadjaj;
import nogometnastatistika.model.Igrac;
import nogometnastatistika.model.Klub;
import nogometnastatistika.util.Aplikacija;
import nogometnastatistika.util.NogometnaStatistikaException;
import nogometnastatistika.util.Alati;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
/**
 *
 * @author Marko
 */
public class ProzorIgrac extends javax.swing.JFrame {
 private ObradaIgrac obrada;
 private DecimalFormat df;
    /**
     * Creates new form ProzorIgrac
     */
    public ProzorIgrac() {
        initComponents();
        setIcon();
         obrada = new ObradaIgrac();
         DecimalFormatSymbols dfs = new DecimalFormatSymbols(new Locale("hr", "HR"));
         df = new DecimalFormat("###,##0.00",dfs);
         
        setTitle(Aplikacija.NAZIV_APP + ": " + 
                Aplikacija.OPERATER.getImePrezime() +
                ": Klubovi");
        definirajDatumRodjenja();
        ucitajKlubove();
        ucitaj();
    }
    private void ucitaj(){
        DefaultListModel<Igrac> m = new DefaultListModel<>();
    m.addAll(obrada.read(txtUvjet.getText()));
    lstPodaci.setModel(m);
    lstPodaci.repaint();
    
}
    private void ucitajKlubove(){
       
        DefaultComboBoxModel<Klub> m
                = new DefaultComboBoxModel<>();
        Klub k = new Klub();
        k.setSifra(0);
        k.setNaziv("Nije odabrano");
        m.addElement(k);
        m.addAll(new ObradaKlub().read());
        cmbKlubovi.setModel(m);
        cmbKlubovi.repaint();
        
        
        
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
        txtIme = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtPrezime = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtOib = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtTrenutnaVrijednost = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtPozicija = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        btnPromjeni = new javax.swing.JButton();
        btnDodaj = new javax.swing.JButton();
        btnObrisi = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        txtBrojIgraca = new javax.swing.JTextField();
        txtUvjet = new javax.swing.JTextField();
        btnTrazi = new javax.swing.JButton();
        btnDovuciOib = new javax.swing.JButton();
        cmbKlubovi = new javax.swing.JComboBox<>();
        dpDatumRodjenja = new com.github.lgooddatepicker.components.DatePicker();
        btnUtakmica = new javax.swing.JButton();
        btnVrsta = new javax.swing.JButton();
        btnDogadjaj = new javax.swing.JButton();
        btnIzbornik = new javax.swing.JButton();
        btnIzlaz = new javax.swing.JButton();
        btnKlub = new javax.swing.JButton();
        btnExExcel = new javax.swing.JButton();

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

        jLabel1.setText("~Ime~");
        jLabel1.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N

        txtIme.setFont(new java.awt.Font("Georgia", 3, 12)); // NOI18N
        txtIme.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel2.setText("~Prezime~");
        jLabel2.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N

        txtPrezime.setFont(new java.awt.Font("Georgia", 3, 12)); // NOI18N
        txtPrezime.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel3.setText("~Datum Rođenja~");
        jLabel3.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N

        jLabel4.setText("~OiB~");
        jLabel4.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N

        txtOib.setFont(new java.awt.Font("Georgia", 3, 12)); // NOI18N
        txtOib.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel5.setText("~Vrijednost Igrača~");
        jLabel5.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N

        txtTrenutnaVrijednost.setFont(new java.awt.Font("Georgia", 3, 12)); // NOI18N
        txtTrenutnaVrijednost.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtTrenutnaVrijednost.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtTrenutnaVrijednost.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtTrenutnaVrijednostKeyPressed(evt);
            }
        });

        jLabel6.setText("~Pozicija Igrača~");
        jLabel6.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N

        txtPozicija.setFont(new java.awt.Font("Georgia", 3, 12)); // NOI18N
        txtPozicija.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel7.setText("~Klub Igrača~");
        jLabel7.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N

        btnPromjeni.setText("Promjeni");
        btnPromjeni.setFont(new java.awt.Font("Georgia", 1, 12)); // NOI18N
        btnPromjeni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPromjeniActionPerformed(evt);
            }
        });

        btnDodaj.setText("Dodaj");
        btnDodaj.setFont(new java.awt.Font("Georgia", 1, 12)); // NOI18N
        btnDodaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDodajActionPerformed(evt);
            }
        });

        btnObrisi.setText("Obriši ");
        btnObrisi.setFont(new java.awt.Font("Georgia", 1, 12)); // NOI18N
        btnObrisi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnObrisiActionPerformed(evt);
            }
        });

        jLabel8.setText("~Broj Igrača~");
        jLabel8.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N

        txtBrojIgraca.setFont(new java.awt.Font("Georgia", 3, 12)); // NOI18N
        txtBrojIgraca.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtBrojIgraca.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtBrojIgracaKeyPressed(evt);
            }
        });

        txtUvjet.setFont(new java.awt.Font("Georgia", 3, 12)); // NOI18N
        txtUvjet.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtUvjet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUvjetActionPerformed(evt);
            }
        });
        txtUvjet.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtUvjetKeyPressed(evt);
            }
        });

        btnTrazi.setText("🔍");
        btnTrazi.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnTrazi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTraziActionPerformed(evt);
            }
        });

        btnDovuciOib.setText("G");
        btnDovuciOib.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnDovuciOib.setFont(new java.awt.Font("Georgia", 1, 12)); // NOI18N
        btnDovuciOib.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDovuciOibActionPerformed(evt);
            }
        });

        cmbKlubovi.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        cmbKlubovi.setFont(new java.awt.Font("Georgia", 3, 12)); // NOI18N

        btnUtakmica.setText("Utakmica");
        btnUtakmica.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));
        btnUtakmica.setFont(new java.awt.Font("Georgia", 1, 12)); // NOI18N
        btnUtakmica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUtakmicaActionPerformed(evt);
            }
        });

        btnVrsta.setText("Vrsta");
        btnVrsta.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));
        btnVrsta.setFont(new java.awt.Font("Georgia", 1, 12)); // NOI18N
        btnVrsta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVrstaActionPerformed(evt);
            }
        });

        btnDogadjaj.setText("Događaj");
        btnDogadjaj.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));
        btnDogadjaj.setFont(new java.awt.Font("Georgia", 1, 12)); // NOI18N
        btnDogadjaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDogadjajActionPerformed(evt);
            }
        });

        btnIzbornik.setText("Izbornik");
        btnIzbornik.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));
        btnIzbornik.setFont(new java.awt.Font("Georgia", 1, 12)); // NOI18N
        btnIzbornik.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIzbornikActionPerformed(evt);
            }
        });

        btnIzlaz.setText("Izlaz");
        btnIzlaz.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));
        btnIzlaz.setFont(new java.awt.Font("Georgia", 1, 12)); // NOI18N
        btnIzlaz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIzlazActionPerformed(evt);
            }
        });

        btnKlub.setText("Klub");
        btnKlub.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));
        btnKlub.setFont(new java.awt.Font("Georgia", 1, 12)); // NOI18N
        btnKlub.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKlubActionPerformed(evt);
            }
        });

        btnExExcel.setText("ExExcel");
        btnExExcel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExExcelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 8, Short.MAX_VALUE)
                        .addComponent(btnIzbornik, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnKlub, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnUtakmica, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnVrsta, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDogadjaj, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnIzlaz, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtUvjet, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnTrazi, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)
                                .addComponent(btnExExcel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jScrollPane1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnDodaj, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnPromjeni, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnObrisi, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPrezime)
                            .addComponent(txtIme)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtOib, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnDovuciOib))
                            .addComponent(cmbKlubovi, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(dpDatumRodjenja, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtTrenutnaVrijednost)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtBrojIgraca)
                            .addComponent(txtPozicija)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnIzbornik)
                    .addComponent(btnKlub)
                    .addComponent(btnUtakmica)
                    .addComponent(btnVrsta)
                    .addComponent(btnDogadjaj)
                    .addComponent(btnIzlaz))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtIme, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtPrezime, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel3)
                            .addGap(3, 3, 3)
                            .addComponent(dpDatumRodjenja, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel4)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtOib, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnDovuciOib))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel5)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtTrenutnaVrijednost, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel6)
                            .addGap(8, 8, 8)
                            .addComponent(txtPozicija, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel8)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtBrojIgraca, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel7))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 404, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtUvjet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnTrazi)
                        .addComponent(btnExExcel, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cmbKlubovi, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnDodaj)
                        .addComponent(btnPromjeni)
                        .addComponent(btnObrisi)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnPromjeniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPromjeniActionPerformed
    if(lstPodaci.getSelectedValue()==null){
           JOptionPane.showMessageDialog(getRootPane(), "Prvo odaberite igrača :)");
           return;
       }
       if(JOptionPane.showConfirmDialog(getRootPane(),"Sigurno promjeniti 👀" + " " + obrada.getEntitet().getImePrezime()+" " + "?" + " ","Brisanje"
              ,JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE)==JOptionPane.NO_OPTION){
          return;}
       napuniModel();
        try {
            obrada.update();
            txtUvjet.setText(obrada.getEntitet().getPrezime());
            ucitaj();
        } catch (NogometnaStatistikaException ex) {
JOptionPane.showMessageDialog(getRootPane(), ex.getPoruka());        }
    }//GEN-LAST:event_btnPromjeniActionPerformed

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

    private void btnDodajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDodajActionPerformed
  obrada.setEntitet(new Igrac());
       napuniModel();
        try {
            obrada.create();
            txtUvjet.setText(obrada.getEntitet().getPrezime());
            ucitaj();
        } catch (NogometnaStatistikaException ex) {
            JOptionPane.showMessageDialog(getRootPane(), ex.getPoruka()); }
            
                }//GEN-LAST:event_btnDodajActionPerformed

    private void btnObrisiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnObrisiActionPerformed
       if(lstPodaci.getSelectedValue()==null){
          JOptionPane.showMessageDialog(getRootPane(), "Prvo odaberite igrača");
          return;
      }
          if(JOptionPane.showConfirmDialog(getRootPane(), "Sigurno obrisati" + obrada.getEntitet().getImePrezime()+ "?"+"😱","Brisanje"
              ,JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE)==JOptionPane.NO_OPTION){
          return;
      }
         try {
            obrada.delete();
            ucitaj();
        } catch (NogometnaStatistikaException ex) {
JOptionPane.showMessageDialog(getRootPane(), ex.getPoruka());        }
    }//GEN-LAST:event_btnObrisiActionPerformed

    private void txtUvjetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUvjetActionPerformed
       
    }//GEN-LAST:event_txtUvjetActionPerformed

    private void txtUvjetKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUvjetKeyPressed
       if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            ucitaj();
        }
    }//GEN-LAST:event_txtUvjetKeyPressed

    private void btnTraziActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTraziActionPerformed
       ucitaj();
    }//GEN-LAST:event_btnTraziActionPerformed

    private void btnDovuciOibActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDovuciOibActionPerformed
     txtOib.setText(Alati.dovuciOib());
    }//GEN-LAST:event_btnDovuciOibActionPerformed

    private void txtTrenutnaVrijednostKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTrenutnaVrijednostKeyPressed
        char c = evt.getKeyChar();
        if(Character.isLetter(c)){
            txtTrenutnaVrijednost.setEditable(true);
          JOptionPane.showMessageDialog(getRootPane(), "Možete unijeti samo broj");  
        }
    }//GEN-LAST:event_txtTrenutnaVrijednostKeyPressed

    private void txtBrojIgracaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBrojIgracaKeyPressed
         char c = evt.getKeyChar();
        if(Character.isLetter(c)){
            txtBrojIgraca.setEditable(true);
          JOptionPane.showMessageDialog(getRootPane(), "Možete unijeti samo broj");  
        }
    }//GEN-LAST:event_txtBrojIgracaKeyPressed

    private void btnUtakmicaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUtakmicaActionPerformed
        new ProzorUtakmica().setVisible(true);
        dispose();
    }//GEN-LAST:event_btnUtakmicaActionPerformed

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

    private void btnExExcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExExcelActionPerformed
        JFileChooser jfc = new JFileChooser();
        jfc.setCurrentDirectory(new File(System.getProperty("user.home")));
        jfc.setSelectedFile(new File(System.getProperty("user.home")
                + File.separator + "podaci.xlsx"));
        if (jfc.showSaveDialog(this) != JFileChooser.APPROVE_OPTION) {
            return;
        }

        try {

            Workbook workbook = new XSSFWorkbook(); 
            CreationHelper createHelper = workbook.getCreationHelper();
            Sheet sheet = workbook.createSheet("Igraci klubova");
            Font headerFont = workbook.createFont();
            headerFont.setBold(true);
            headerFont.setFontHeightInPoints((short) 14);
            headerFont.setColor(IndexedColors.RED.getIndex());

           
            CellStyle headerCellStyle = workbook.createCellStyle();
            headerCellStyle.setFont(headerFont);

            
            Row headerRow = sheet.createRow(0);

            
            Cell cell = headerRow.createCell(0);
            cell.setCellValue("Igrac");
            cell.setCellStyle(headerCellStyle);

            cell = headerRow.createCell(1);
            cell.setCellValue("Utakmica");
            cell.setCellStyle(headerCellStyle);

            cell = headerRow.createCell(2);
            cell.setCellValue("Vrsta");
            cell.setCellStyle(headerCellStyle);

            cell = headerRow.createCell(3);
            cell.setCellValue("Minuta");
            cell.setCellStyle(headerCellStyle);

          
            int rowNum = 1;
            Row row;
           
            for (Dogadjaj d : obrada.getEntitet().getDogadjaji()) {
                
                    
                
                row = sheet.createRow(rowNum++);

                row.createCell(0)
                        .setCellValue(d.getIgrac().getImePrezime());

                row.createCell(1)
                        .setCellValue(d.getUtakmica().getDomaciGosti());

                row.createCell(2)
                        .setCellValue(d.getVrsta().getNaziv());

                row.createCell(3)
                        .setCellValue(d.getMinuta());
                

            }
            

            row = sheet.createRow(rowNum);
            cell = row.createCell(3);
            CellStyle style = workbook.createCellStyle();
            DataFormat format = workbook.createDataFormat();
            style.setDataFormat(format.getFormat("0.00"));
            cell.setCellStyle(style);
            cell.setCellFormula("sum(E2:E" + (rowNum) + ")");

           
            for (int i = 0; i < 4; i++) {
                sheet.autoSizeColumn(i);
            }

           
            FileOutputStream fileOut = new FileOutputStream(jfc.getSelectedFile());
            workbook.write(fileOut);
            fileOut.close();

            
            workbook.close();

            ProcessBuilder builder = new ProcessBuilder(
                    "cmd.exe", "/c", jfc.getSelectedFile().getAbsolutePath());
            builder.redirectErrorStream(true);
            Process p = builder.start();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnExExcelActionPerformed
private void napuniView(){
    var i = obrada.getEntitet();
    txtIme.setText(i.getIme());
    txtPrezime.setText(i.getPrezime());
    txtOib.setText(i.getOib());
    txtPozicija.setText(i.getPozicija());
    txtBrojIgraca.setText(String.valueOf(i.getBroj()));
    LocalDate ld = i.getDatumRodjenja().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    dpDatumRodjenja.setDate(ld);
    txtTrenutnaVrijednost.setText(df.format(i.getTrenutnaVrijednost()));
    cmbKlubovi.setSelectedItem(i.getKlub());
    
}
    
    
    
     private void napuniModel(){
    var i = obrada.getEntitet();
    i.setIme(txtIme.getText());
    i.setPrezime(txtPrezime.getText());
    i.setPozicija(txtPozicija.getText());
    i.setOib(txtOib.getText());
     try {
       i.setBroj(Integer.parseInt(txtBrojIgraca.getText()));
     } catch (Exception e) {
         i.setBroj( 0);
     }
   i.setDatumRodjenja(dpDatumRodjenja.getDate()!=null
                            ? 
                            Date.from(dpDatumRodjenja.getDate()
                            .atStartOfDay()
                            .atZone(ZoneId.systemDefault())
                            .toInstant())
                            : null);
   
  i.setKlub((Klub)cmbKlubovi.getSelectedItem());
         try {
              i.setTrenutnaVrijednost(BigDecimal.valueOf(df.parse(txtTrenutnaVrijednost.getText()).doubleValue()));
         } catch (Exception e) {
             i.setTrenutnaVrijednost(BigDecimal.ZERO);
         }
         
    
    
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDodaj;
    private javax.swing.JButton btnDogadjaj;
    private javax.swing.JButton btnDovuciOib;
    private javax.swing.JButton btnExExcel;
    private javax.swing.JButton btnIzbornik;
    private javax.swing.JButton btnIzlaz;
    private javax.swing.JButton btnKlub;
    private javax.swing.JButton btnObrisi;
    private javax.swing.JButton btnPromjeni;
    private javax.swing.JButton btnTrazi;
    private javax.swing.JButton btnUtakmica;
    private javax.swing.JButton btnVrsta;
    private javax.swing.JComboBox<Klub> cmbKlubovi;
    private com.github.lgooddatepicker.components.DatePicker dpDatumRodjenja;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<Igrac> lstPodaci;
    private javax.swing.JTextField txtBrojIgraca;
    private javax.swing.JTextField txtIme;
    private javax.swing.JTextField txtOib;
    private javax.swing.JTextField txtPozicija;
    private javax.swing.JTextField txtPrezime;
    private javax.swing.JTextField txtTrenutnaVrijednost;
    private javax.swing.JTextField txtUvjet;
    // End of variables declaration//GEN-END:variables

    private void setIcon() {
setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/ball.png" )));
    }

    private void definirajDatumRodjenja() {
          DatePickerSettings dps = 
                new DatePickerSettings(new Locale("hr","HR"));
       dps.setFormatForDatesCommonEra("dd. MM. YYYY.");
       dps.setTranslationClear("Očisti");
       dps.setTranslationToday("Danas");
       dpDatumRodjenja.setSettings(dps);
    }
}
