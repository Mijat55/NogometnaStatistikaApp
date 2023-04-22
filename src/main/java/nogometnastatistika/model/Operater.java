/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nogometnastatistika.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

/**
 *
 * @author Marko
 */
@Entity
public class Operater extends Entitet{
     @Column(columnDefinition = "char(61)")
    private char[] lozinka;
     @Column(
     columnDefinition = "varchar(30)")
    private String ime;
     @Column(
     columnDefinition = "varchar(50)")
    private String prezime;
     @Column(
     columnDefinition = "varchar(11)")
    private String oib;
    private String email;

    public char[] getLozinka() {
        return lozinka;
    }

    public void setLozinka(char[] lozinka) {
        this.lozinka = lozinka;
    }

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

    public String getOib() {
        return oib;
    }

    public void setOib(String oib) {
        this.oib = oib;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
    public String getImePrezime(){
        return getIme() + " " + getPrezime();
    }
    
}

