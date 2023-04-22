/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nogometnastatistika.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Dogadjaj extends Entitet{
    
        private Integer minuta;
        @ManyToOne
     @JoinColumn(
     name = "igrac")
	private Igrac igrac;
        @ManyToOne
     @JoinColumn(
     name = "utakmica")
	private Utakmica utakmica;
        @ManyToOne
     @JoinColumn(
     name = "vrsta")
	private Vrsta vrsta;

    public Integer getMinuta() {
        return minuta;
    }

    public void setMinuta(Integer minuta) {
        this.minuta = minuta;
    }

    public Igrac getIgrac() {
        return igrac;
    }

    public void setIgrac(Igrac igrac) {
        this.igrac = igrac;
    }

    public Utakmica getUtakmica() {
        return utakmica;
    }

    public void setUtakmica(Utakmica utakmica) {
        this.utakmica = utakmica;
    }

    public Vrsta getVrsta() {
        return vrsta;
    }

    public void setVrsta(Vrsta vrsta) {
        this.vrsta = vrsta;
    }

    public String getIgracVrstaMinutaUtakmica(){
       return getIgrac()+ " " + getVrsta() + " " + getMinuta() + " " + getUtakmica();
    }
    @Override
    public String toString() {
        return igrac + " " +"("+ " " + vrsta + " "+")"+" " + minuta +"'"+" "+"minuta" +" "+"*"+" " + utakmica + " " +"*";
        
    }
        
        
    
}
