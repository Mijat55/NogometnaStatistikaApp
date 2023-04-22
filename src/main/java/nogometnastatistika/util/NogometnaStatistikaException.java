/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nogometnastatistika.util;

/**
 *
 * @author Marko
 */
public class NogometnaStatistikaException extends Exception{
       private String poruka;

    public NogometnaStatistikaException(String poruka){
        super();
        this.poruka = poruka;
    }

    public String getPoruka() {
        return poruka;
    }
}
