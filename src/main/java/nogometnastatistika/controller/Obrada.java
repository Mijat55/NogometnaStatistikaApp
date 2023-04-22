/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nogometnastatistika.controller;

import java.util.List;
import nogometnastatistika.model.Entitet;
import nogometnastatistika.util.HibernateUtil;
import nogometnastatistika.util.NogometnaStatistikaException;
import org.hibernate.Session;

/**
 *
 * @author Marko
 */
public abstract class Obrada<T extends Entitet> {
     protected T entitet;
    protected Session session;

    public abstract List<T> read();

    protected abstract void kontrolaUnos() throws NogometnaStatistikaException;

    protected abstract void kontrolaPromjena() throws NogometnaStatistikaException;

    protected abstract void kontrolaBrisanje() throws NogometnaStatistikaException;

    public Obrada() {
        this.session = HibernateUtil.getSession();
    }

    public void create() throws NogometnaStatistikaException {
        if(entitet==null){
            throw new NogometnaStatistikaException("Entitet je null");
        }
        kontrolaUnos();
        persist();
    }

    public void update() throws NogometnaStatistikaException {
        kontrolaPromjena();
        persist();
    }

    public void delete() throws NogometnaStatistikaException {
        kontrolaBrisanje();
        session.beginTransaction();
        session.remove(entitet);
        session.getTransaction().commit();
    }

    private void persist() {
        session.beginTransaction();
        session.persist(entitet);
        session.getTransaction().commit();
    }

    public T getEntitet() {
        return entitet;
    }

    public void setEntitet(T entitet) {
        this.entitet = entitet;
    }
    
}
