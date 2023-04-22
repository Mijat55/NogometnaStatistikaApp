/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nogometnastatistika.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Entity
public class Igrac extends Entitet{
    @Column(
    columnDefinition = "varchar(30)")
        private String ime;
    @Column(
    columnDefinition = "varchar(50)")
	private String prezime;
    @Column(
    name = "datum_rodjenja",
    columnDefinition = "datetime")
	private Date datumRodjenja;
    @Column(
    columnDefinition = "varchar(11)")
	private String oib;
    @Column(
    name = "trenutna_vrijednost")
	private BigDecimal trenutnaVrijednost;
    @Column(
    columnDefinition = "varchar(20)")
	private String pozicija;
        private Integer broj;
        @ManyToOne
    @JoinColumn(
    name = "klub")
	private Klub klub;
        @OneToMany(mappedBy = "igrac")
        private List<Dogadjaj> dogadjaji;

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public Date getDatumRodjenja() {
        return datumRodjenja;
    }

    public void setDatumRodjenja(Date datumRodjenja) {
        this.datumRodjenja = datumRodjenja;
    }

    public String getOib() {
        return oib;
    }

    public void setOib(String oib) {
        this.oib = oib;
    }

    public BigDecimal getTrenutnaVrijednost() {
        return trenutnaVrijednost;
    }

    public void setTrenutnaVrijednost(BigDecimal trenutnaVrijednost) {
        this.trenutnaVrijednost = trenutnaVrijednost;
    }

    public Integer getBroj() {
        return broj;
    }

    public void setBroj(Integer broj) {
        this.broj = broj;
    }

    

   
    public String getPozicija() {
        return pozicija;
    }

    public void setPozicija(String pozicija) {
        this.pozicija = pozicija;
    }

    public Klub getKlub() {
        return klub;
    }

    public void setKlub(Klub klub) {
        this.klub = klub;
    }

    public List<Dogadjaj> getDogadjaji() {
        return dogadjaji;
    }

    public void setDogadjaji(List<Dogadjaj> dogadjaji) {
        this.dogadjaji = dogadjaji;
    }
    
    public String getImePrezime(){
        return getIme() + " " + getPrezime() + " " + getBroj();
    }

    @Override
    public String toString() {
       // if(broj ==null || klub ==null){
         //   return ime + " " +prezime;
      //  }
        return  ime + " " + prezime + "(" + broj + ")";
    }

  


    
   
        
    
}
