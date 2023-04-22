/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nogometnastatistika.controller;

import java.util.List;
import nogometnastatistika.model.Vrsta;
import nogometnastatistika.util.NogometnaStatistikaException;

/**
 *
 * @author Marko
 */
public class ObradaVrsta extends Obrada<Vrsta>{

    @Override
    public List<Vrsta> read() {
        return session.createQuery("from Vrsta", Vrsta.class).list();
    }

    @Override
    protected void kontrolaUnos() throws NogometnaStatistikaException {
        kontrolaVrsta();
        kontrolaNazivNijeBroj();
    }

    @Override
    protected void kontrolaPromjena() throws NogometnaStatistikaException {
        kontrolaVrsta();
        kontrolaNazivNijeBroj();
    }

    @Override
    protected void kontrolaBrisanje() throws NogometnaStatistikaException {
        
            if(entitet.getDogadjaji()!=null && !entitet.getDogadjaji().isEmpty()){
             throw new NogometnaStatistikaException("Vrsta se ne može obrisati jer ima događaj");
           
       }
       
    }
    
      private void kontrolaVrsta() throws NogometnaStatistikaException{
        kontrolaVrstaNull();
        kontrolaVrstaMaksimalnaDuzina();
        kontrolaVrstaMinimalnaDuzina();
        
    }
    private void kontrolaVrstaNull() throws NogometnaStatistikaException  {
        if(entitet.getNaziv()==null){
            throw new NogometnaStatistikaException("Naziv vrste mora biti postavljen");
        }
    }
      private void kontrolaVrstaMaksimalnaDuzina() throws NogometnaStatistikaException  {
         if(entitet.getNaziv().trim().length()>30){
             throw new NogometnaStatistikaException("Naziv vrste može imati maksimalno 30 znakova");
         } 
    }
            private void kontrolaVrstaMinimalnaDuzina() throws NogometnaStatistikaException  {
         if(entitet.getNaziv().trim().length()<3){
             throw new NogometnaStatistikaException("Naziv vrste mora imati minimalno 3 znaka");
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
            throw new NogometnaStatistikaException("Vrsta ne smije biti broj");
        }
    }
}
