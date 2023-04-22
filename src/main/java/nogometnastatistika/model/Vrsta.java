/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nogometnastatistika.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import java.util.List;

@Entity
public class Vrsta extends Entitet{
    @Column(
    columnDefinition = "varchar(30)")
        private String naziv;
	private boolean gol;
        @OneToMany(mappedBy = "vrsta")
        private List<Dogadjaj> dogadjaji;

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public boolean isGol() {
        return gol;
    }

    public void setGol(boolean gol) {
        this.gol = gol;
    }

    public List<Dogadjaj> getDogadjaji() {
        return dogadjaji;
    }

    public void setDogadjaji(List<Dogadjaj> dogadjaji) {
        this.dogadjaji = dogadjaji;
    }
    
 
    @Override
    public String toString() {
        return naziv;
        
       }
               
    
}
