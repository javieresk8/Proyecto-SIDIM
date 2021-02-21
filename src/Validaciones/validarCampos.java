/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Validaciones;

import java.awt.Event;
import java.awt.event.KeyEvent;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Bryan
 */
public class validarCampos {
    
    public void tamanoCam(JTextField j, int tamano,java.awt.event.KeyEvent e )
    {
     
    if(j.getText().length()==tamano)
        {
            e.consume();
            
        }
       
    }
    
    public void soloLetras(JTextField j,java.awt.event.KeyEvent e )
    {
       char validar = e.getKeyChar();
       if(!Character.isLetter(validar)){
            if(!(e.getKeyChar()==32 || e.getKeyChar()==13))
            {
                e.consume();
            }

       }
    }
    
    public void soloDigitos(JTextField j,java.awt.event.KeyEvent e )
    {
        char validar = e.getKeyChar();
       if(!Character.isDigit(validar)){
            if(!(e.getKeyChar()==13))
            {
                e.consume();
            }

       }
    }
    
    public  boolean validarTelefono(String telefono)
    {
        boolean bandera = false;
        Pattern pat = Pattern.compile("^0[2-8]([0-9]){7}|0[9]([0-9]){8}");
        Matcher mat = pat.matcher(telefono);
        String auxiliar ="";
        auxiliar=telefono;
        if(mat.matches())
            {
                 telefono=auxiliar;
                 bandera = true;
            }
        else
            {
                JOptionPane.showMessageDialog(null, "El "+telefono+" no es valido");
                
            }
        return bandera;
    }
    
    public void todoMenosEspeciales(JTextField j,java.awt.event.KeyEvent e )
    {
       char validar = e.getKeyChar();
       if(!(Character.isLetter(validar)||Character.isDigit(validar))){
            if(!(e.getKeyChar()==32 || e.getKeyChar()==13||e.getKeyChar()==45))
            {
                e.consume();
            }

       }
    }
    
      public void fechaSlash(JTextField j,java.awt.event.KeyEvent e )
    {
       char validar = e.getKeyChar();
       if(!(Character.isDigit(validar))){
            if(!(e.getKeyChar()==13||e.getKeyChar()==45))
            {
                e.consume();
            }

       }
    }
      
        public void valoresDEcimales(JTextField j,java.awt.event.KeyEvent e )
    {
       char validar = e.getKeyChar();
       if(!(Character.isDigit(validar))){
            if(!(e.getKeyChar()==13||e.getKeyChar()==46))
            {
                e.consume();
            }

       }
    }
      
      
      
    
    public  boolean validacionCorreo(String correo){
        boolean bandera = false;
        Pattern pat = Pattern.compile("^[_a-zA-Z0-9-]+(.[_a-zA-Z0-9-]+)*@[a-zA-Z0-9-]+(.[a-zA-Z0-9-]+)*(.[a-zA-Z]{2,4})$");
        Matcher mat = pat.matcher(correo);
        String auxiliar ="";
        auxiliar=correo;
        if(mat.matches())
            {
                 correo=auxiliar;
                 bandera = true;
            }
        else
            {
                JOptionPane.showMessageDialog(null, "El "+correo+" no es valido");
                
            }
        return bandera;
    }
    
   
    public boolean validarDecimal(String decimal)
    {
      boolean bandera = false;
 
    String patron ="^[0-9]{1,10}[.][0-9]{2}$";

    Pattern pat = Pattern.compile(patron);
    Matcher mat = pat.matcher(decimal);
         if (mat.matches()) {
             System.out.println("SI");
             bandera= true;
             
         } else {
             JOptionPane.showMessageDialog(null, "Valor ingresado no válido");
         }
         return bandera;
    }
    
   

}
