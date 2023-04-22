/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nogometnastatistika.controller;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Date;
import java.util.List;
import nogometnastatistika.model.Igrac;
import nogometnastatistika.model.Klub;
import nogometnastatistika.util.Alati;
import nogometnastatistika.util.NogometnaStatistikaException;

/**
 *
 * @author Marko
 */
public class ObradaIgrac extends Obrada<Igrac>{

    @Override
    public List<Igrac> read() {
        return session.createQuery("from Igrac", Igrac.class).list();
       
    }
      public List<Igrac> read(String uvjet) {
        uvjet=uvjet.trim();
        uvjet = "%" + uvjet + "%";
       return session.createQuery("from Igrac "
               + " where concat(ime,' ',prezime,' ',broj,' ',ime) "
               + " like :uvjet "
               + " order by prezime, ime, broj ", 
               Igrac.class)
               .setParameter("uvjet", uvjet)
               .setMaxResults(30)
               .list();
    }
    @Override
    protected void kontrolaUnos() throws NogometnaStatistikaException {
        kontrolaIme();
        kontrolaPrezime();
        kontrolaTrenutnaVrijednost();
        kontrolaOib();
        if(entitet.getKlub().getSifra()==0){
           throw new NogometnaStatistikaException("Obavezno odabir Kluba");
       }
        kontrolaPozicijaNijeBroj();
    }

    @Override
    protected void kontrolaPromjena() throws NogometnaStatistikaException {
        kontrolaIme();
        kontrolaPrezime();
        kontrolaTrenutnaVrijednost();
        kontrolaOib();
        kontrolaPozicijaNijeBroj();
    }

    @Override
    protected void kontrolaBrisanje() throws NogometnaStatistikaException {
         if(entitet.getDogadjaji()!=null && !entitet.getDogadjaji().isEmpty()){
             throw new NogometnaStatistikaException("Igrač se ne može obrisati jer ima događaj");
           
       }
    }
   // private void kontrolaDatum()throws NogometnaStatistikaException{
        
                
       // }
                        
        
                        
    
    
    private void kontrolaOib() throws NogometnaStatistikaException {
        if(!Alati.kontrolaOIB(entitet.getOib())){
            throw new NogometnaStatistikaException("OIB nije u dobrom formatu");
        }
    }
    
    private void kontrolaTrenutnaVrijednost () throws NogometnaStatistikaException{
         if(entitet.getTrenutnaVrijednost()==null ||
                entitet.getTrenutnaVrijednost().compareTo(BigDecimal.ZERO)<=0 ||
                entitet.getTrenutnaVrijednost().compareTo(new BigDecimal(100000000))==1){
           throw new NogometnaStatistikaException("Cijena mora biti postavljena, "
                   + "veća od 0 i manja od 100000000(100miliona)");
       }
    }
    private void kontrolaPrezime () throws NogometnaStatistikaException{
        kontrolaPrezimeNull();
        kontrolaPrezimeMaksimalnaDuzina();
        kontrolaPrezimeMinimalnaDuzina();
        kontrolaPrezimeNijeBroj();
    }
     private void kontrolaPrezimeNull() throws NogometnaStatistikaException  {
        if(entitet.getPrezime()==null){
            throw new NogometnaStatistikaException("Prezime mora biti postavljeno");
        }
    }
       private void kontrolaPrezimeMaksimalnaDuzina() throws NogometnaStatistikaException  {
         if(entitet.getPrezime().trim().length()>40){
             throw new NogometnaStatistikaException("Prezime može imati maksimalno 40 znakova");
         } 
    }
               private void kontrolaPrezimeMinimalnaDuzina() throws NogometnaStatistikaException  {
         if(entitet.getPrezime().trim().length()<3){
             throw new NogometnaStatistikaException("Prezime mora imati minimalno 3 znaka");
         } 
    }
  private void kontrolaPrezimeNijeBroj() throws NogometnaStatistikaException  {
     
        boolean broj=false;
        
        try {
            Double.parseDouble(entitet.getPrezime());
            broj=true;
        } catch (Exception e) {
            
        }
        
        if(broj){
            throw new NogometnaStatistikaException("Prezime ne smije biti broj");
        }
        
    }
  
    
    private void kontrolaIme() throws NogometnaStatistikaException{
        kontrolaImeNull();
        kontrolaImeMaksimalnaDuzina();
        kontrolaImeMinimalnaDuzina();
        kontrolaImeNijeBroj();
    }
    private void kontrolaImeNull() throws NogometnaStatistikaException  {
        if(entitet.getIme()==null){
            throw new NogometnaStatistikaException("Ime mora biti postavljeno");
        }
    }
      private void kontrolaImeMaksimalnaDuzina() throws NogometnaStatistikaException  {
         if(entitet.getIme().trim().length()>30){
             throw new NogometnaStatistikaException("Ime može imati maksimalno 30 znakova");
         } 
    }
            private void kontrolaImeMinimalnaDuzina() throws NogometnaStatistikaException  {
         if(entitet.getIme().trim().length()<3){
             throw new NogometnaStatistikaException("Ime mora imati minimalno 3 znaka");
         } 
    }
        private void kontrolaImeNijeBroj() throws NogometnaStatistikaException  {
        boolean broj=false;
        try {
            Double.parseDouble(entitet.getIme());
            broj=true;
        } catch (Exception e) {
        }
        
        if(broj){
            throw new NogometnaStatistikaException("Ime ne smije biti broj");
        }
    }
   private void kontrolaPozicijaNijeBroj() throws NogometnaStatistikaException  {
        boolean broj=false;
        try {
            Double.parseDouble(entitet.getPozicija());
            broj=true;
        } catch (Exception e) {
        }
        if(broj){
            throw new NogometnaStatistikaException("Pozicija ne smije biti broj");
        }
    }
}
