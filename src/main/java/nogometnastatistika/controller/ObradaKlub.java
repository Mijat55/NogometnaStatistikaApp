/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nogometnastatistika.controller;

import java.util.List;
import nogometnastatistika.model.Igrac;
import nogometnastatistika.model.Klub;
import nogometnastatistika.util.Alati;
import nogometnastatistika.util.NogometnaStatistikaException;

/**
 *
 * @author Marko
 */
public class ObradaKlub extends Obrada<Klub>{

    @Override
    public List<Klub> read() {
        return session.createQuery("from Klub", Klub.class).list();
    }
   

    @Override
    protected void kontrolaUnos() throws NogometnaStatistikaException {
        kontrolaNaziv();
    }

    @Override
    protected void kontrolaPromjena() throws NogometnaStatistikaException {
        kontrolaNazivNull();
        kontrolaNazivNijeBroj();
        kontrolaNazivMinimalnaDuzina();
        kontrolaNazivMaksimalnaDuzina();
    }

    @Override
    protected void kontrolaBrisanje() throws NogometnaStatistikaException {
       if(entitet.getIgraci()!=null && !entitet.getIgraci().isEmpty()){
           throw new NogometnaStatistikaException("Klub se ne može obrisati jer ima igrače");
       }
       if(entitet.getUtakmica()!=null && !entitet.getUtakmica().isEmpty()){
           throw new NogometnaStatistikaException("Klub se ne može obrisati jer ima utakmice");
       }
       if(entitet.getUtakmice()!=null && !entitet.getUtakmice().isEmpty()){
           throw new NogometnaStatistikaException("Klub se ne može obrisati jer ima utakmice");
       }
    }
    
    private void kontrolaNaziv() throws NogometnaStatistikaException{
         kontrolaNazivDupliUBazi();
         kontrolaNazivNull();
         kontrolaNazivMaksimalnaDuzina();
         kontrolaNazivMinimalnaDuzina();
         kontrolaNazivNijeBroj();
    }
    
    
    private void kontrolaNazivDupliUBazi() throws NogometnaStatistikaException  {
        List<Klub> klubovi=null;
        try {
            klubovi = session.createQuery("from Klub k "
                    + " where k.naziv=:naziv", 
                    Klub.class)
                    .setParameter("naziv", entitet.getNaziv())
                    .list();
        } catch (Exception e) {
        }
        if(klubovi!=null && !klubovi.isEmpty()){
            throw new NogometnaStatistikaException("Klub s istim nazivom postoji u bazi");
        }
    }
    
     private void kontrolaNazivNull() throws NogometnaStatistikaException  {
        if(entitet.getNaziv()==null){
            throw new NogometnaStatistikaException("Naziv mora biti postavljen");
        }
    }
     
        private void kontrolaNazivMaksimalnaDuzina() throws NogometnaStatistikaException  {
         if(entitet.getNaziv().trim().length()>20){
             throw new NogometnaStatistikaException("Naziv kluba može imati maksimalno 20 znakova");
         } 
    }
        
            private void kontrolaNazivMinimalnaDuzina() throws NogometnaStatistikaException  {
         if(entitet.getNaziv().trim().length()<3){
             throw new NogometnaStatistikaException("Naziv kluba mora imati minimalno 3 znaka");
         } 
    }
             private void kontrolaNazivNijeBroj() throws NogometnaStatistikaException  {
     
        boolean broj=false;
        
        try {
            Double.parseDouble(entitet.getNaziv());
            broj=true;
        } catch (Exception e) {
            
        }
        
        if(broj){
            throw new NogometnaStatistikaException("Naziv kluba ne smije biti broj");
        }
        
    }
           
		
             
}
