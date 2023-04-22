/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nogometnastatistika.controller;

import java.util.ArrayList;
import java.util.List;
import nogometnastatistika.model.Dogadjaj;
import nogometnastatistika.model.Igrac;
import nogometnastatistika.model.Klub;
import nogometnastatistika.model.Utakmica;
import nogometnastatistika.util.NogometnaStatistikaException;

/**
 *
 * @author Marko
 */
public class ObradaDogadjaj extends Obrada<Dogadjaj>{

    @Override
    public List<Dogadjaj> read() {
        return session.createQuery("from Dogadjaj", Dogadjaj.class).list();
    }
  public List<Dogadjaj> read(Utakmica u) {
       return session.createQuery("from Dogadjaj" + " where utakmica=:utakmica",
              Dogadjaj.class).setParameter("utakmica", u).list();
   }
  
   public List<Igrac> readIgraciNaUtakmici(Utakmica u) {
      
      List<Igrac> l = new ArrayList<>();
        // preraditi na listu Grafpodaci
         List<Object[]> lista =  session.createNativeQuery(
                 " select a.* " + 
" from igrac a inner join klub b " +  
" on a.klub  = b.sifra  " + 
" inner join utakmica c on b.sifra =c.domaci_sifra " +  
" where c.sifra=" + u.getSifra() + " " + 
" union  " + 
" select a.* " + 
" from igrac a inner join klub b " +  
" on a.klub  = b.sifra  " + 
" inner join utakmica c on b.sifra =c.gosti_sifra " + 
" where c.sifra=" + u.getSifra() + ";",Object[].class
                 )
                 //.setParameter(1, u.getSifra())
                 .getResultList();
       
         Igrac gf;
         for(Object[] niz : lista){
            gf = new Igrac();
            gf.setSifra(Integer.parseInt(niz[0].toString()));
            gf.setIme(niz[3].toString());
            gf.setPrezime(niz[6].toString());
            gf.setBroj(Integer.parseInt(niz[1].toString()));
            l.add(gf);
         }
        
        return l;
              
      
      
   }
   
   
    public List<Dogadjaj> read(String uvjet) {
       uvjet=uvjet.trim();
       uvjet = "%" + uvjet + "%";
      return session.createQuery("from Dogadjaj "
            + " where concat(igrac.ime, igrac.prezime, igrac.broj, vrsta.naziv, vrsta.gol, utakmica.domaciKlub.naziv, utakmica.gostiKlub.naziv ) "
            + " like :uvjet "
            + " order by igrac, vrsta, minuta, utakmica ", 
             Dogadjaj.class)
             .setParameter("uvjet", uvjet)
             .setMaxResults(30)
             .list();
    }


    @Override
    protected void kontrolaUnos() throws NogometnaStatistikaException {
       kontrolaUnosUtakmica();
       kontrolaUnosIgrac();
       kontrolaUnosVrsta();
       //kontrolaUnosMinuta();
    }

    @Override
    protected void kontrolaPromjena() throws NogometnaStatistikaException {
        promjenaUtakmica();
        promjenaUnosVrsta();
        promjenaUnosIgrac();
    }

     @Override
    protected void kontrolaBrisanje() throws NogometnaStatistikaException {
    
    }
   
    private void kontrolaUnosUtakmica()throws NogometnaStatistikaException{
          if(entitet.getUtakmica().getSifra()==0){
            throw new NogometnaStatistikaException("Obavezan odabir utakmice");
        }
    }
    private void kontrolaUnosIgrac() throws NogometnaStatistikaException{
        if(entitet.getIgrac().getSifra()==0){
            throw new NogometnaStatistikaException("Obavezan odabir igrača");
        }
    }
    private void kontrolaUnosVrsta()throws NogometnaStatistikaException{
        if(entitet.getVrsta().getSifra()==0){
            throw new NogometnaStatistikaException("Obavezan odabir vrste");
        }
    }
    private void promjenaUtakmica()throws NogometnaStatistikaException{
          if(entitet.getUtakmica().getSifra()==0){
            throw new NogometnaStatistikaException("Obavezan odabir utakmice na kojoj želite promjeniti događaj");
        }
    }
    private void promjenaUnosIgrac() throws NogometnaStatistikaException{
        if(entitet.getIgrac().getSifra()==0){
            throw new NogometnaStatistikaException("Obavezan odabir igrača kojem želite promjeniti događaj");
        }
    }
    private void promjenaUnosVrsta()throws NogometnaStatistikaException{
        if(entitet.getVrsta().getSifra()==0){
            throw new NogometnaStatistikaException("Obavezan odabir vrste kojoj želite promjeniti događaj");
        }
    }
}
