/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nogometnastatistika.controller;

import java.util.List;
import nogometnastatistika.model.Utakmica;
import nogometnastatistika.util.NogometnaStatistikaException;

/**
 *
 * @author Marko
 */
public class ObradaUtakmica extends Obrada<Utakmica>{

    @Override
    public List<Utakmica> read() {
          return session.createQuery("from Utakmica", 
                Utakmica.class).list();
    }

    @Override
    protected void kontrolaUnos() throws NogometnaStatistikaException {
       // postaviti kontrolu pri unosu da domaci klub ne moze biti isti kao gostujuci klub!!
       if(entitet.getDomaciKlub().getSifra()==0){
           throw new NogometnaStatistikaException("Obavezno odabir Domaćeg Kluba");
       }
        if(entitet.getGostiKlub().getSifra()==0){
           throw new NogometnaStatistikaException("Obavezno odabir Gostujućeg Kluba");
       }
    }

    @Override
    protected void kontrolaPromjena() throws NogometnaStatistikaException {
        
    }

    @Override
    protected void kontrolaBrisanje() throws NogometnaStatistikaException {
         if(entitet.getDogadjaji()!=null && !entitet.getDogadjaji().isEmpty()){
             throw new NogometnaStatistikaException("Utakmica se ne može obrisati jer ima događaj");
           
       }
    }
    
    
    
}
