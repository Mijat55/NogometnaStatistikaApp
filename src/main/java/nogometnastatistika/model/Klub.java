/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nogometnastatistika.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.OneToMany;
import java.util.List;

@Entity
public  class Klub extends Entitet{
         
    
    
         @OneToMany(mappedBy = "domaciKlub")
        private List<Utakmica> utakmice;
         @OneToMany(mappedBy = "gostiKlub")
         private List<Utakmica> utakmica;
         @OneToMany(mappedBy = "klub")
         private List<Igrac> igraci;
      
   
    @Column(
    columnDefinition = "varchar(20)")
    private String naziv;

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public List<Utakmica> getUtakmice() {
        return utakmice;
    }

    public void setUtakmice(List<Utakmica> utakmice) {
        this.utakmice = utakmice;
    }

    public List<Igrac> getIgraci() {
        return igraci;
    }

    public void setIgraci(List<Igrac> igraci) {
        this.igraci = igraci;
    }

    public List<Utakmica> getUtakmica() {
        return utakmica;
    }

    public void setUtakmica(List<Utakmica> utakmica) {
        this.utakmica = utakmica;
    }

   

    @Override
    public String toString() {
        return naziv;
    }

  
 
    
}
