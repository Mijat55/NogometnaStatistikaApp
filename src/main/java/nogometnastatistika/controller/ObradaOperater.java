/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nogometnastatistika.controller;

import jakarta.persistence.NoResultException;
import java.util.List;
import nogometnastatistika.model.Operater;
import nogometnastatistika.util.Alati;
import nogometnastatistika.util.NogometnaStatistikaException;
import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author Marko
 */
public class ObradaOperater extends Obrada<Operater>{
      @Override
    public List<Operater> read() {
        return session.createQuery("from Operater",Operater.class).list();
    }
     @Override
    protected void kontrolaUnos() throws NogometnaStatistikaException {
        kontrolaIme();
        kontrolaPrezime();
        kontrolaOib();
        kontrolaLozinke();
    }

    @Override
    protected void kontrolaPromjena() throws NogometnaStatistikaException {
        kontrolaIme();
        kontrolaPrezime();
        kontrolaOib();
        kontrolaLozinke();
    }

    @Override
    protected void kontrolaBrisanje() throws NogometnaStatistikaException {
    }
    
    public void unosAdminOperatera() {
        Operater o = new Operater();
        o.setIme("Marko");
        o.setPrezime("Mijatović");
        o.setEmail("mijat5555@gmail.com");
        o.setOib("54585269677");
        o.setLozinka(BCrypt.hashpw("edunova", 
                BCrypt.gensalt()).toCharArray());
        
       
        entitet=o;
        try {
            create();
        } catch (NogometnaStatistikaException ex) {
            System.out.println(ex.getPoruka());
        }
        
        
    }
    
    public Operater login(String email, char[] lozinka){
        Operater o;
        try {
            o = session.createQuery(
                    "from Operater o where o.email=:email", 
                    Operater.class)
                    .setParameter("email",email)
                    .getSingleResult();
            
        } catch (NoResultException e) {
            return null;
        }
        
        if(BCrypt.checkpw(
                new String(lozinka), 
                new String(o.getLozinka())
                            )
                ){
            return o;
        }
        
        return null;
    }
    
    private void kontrolaLozinke() throws NogometnaStatistikaException{
        
    }
   
    
     private void kontrolaOib() throws NogometnaStatistikaException {
        if(!Alati.kontrolaOIB(entitet.getOib())){
            throw new NogometnaStatistikaException("OIB nije u dobrom formatu");
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
}
