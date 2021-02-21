package Validaciones;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import javax.swing.JOptionPane;
 
public class validarFecha {
/*public static void main(String[] args) throws ParseException {
        String fecha;
        Scanner leer=new Scanner(System.in);
    boolean res=true;
        System.out.println("Dame la fecha");
        fecha=leer.next();
        res=isFechaValida(fecha,compararFechaActual());
        if(res==true){
            System.out.println("La fecha es valida");
             }else
                 System.out.println("La fecha no es valida");
        
         }*/

public  String compararFechaActual()
{
    Calendar c1 = Calendar.getInstance();

    String dia = null;
    String mes = null;
    String ano = null;
      if(c1.get(Calendar.DATE)<=9)
      {
          dia = "0"+Integer.toString(c1.get(Calendar.DATE));
      }
      else
      {
          dia = Integer.toString(c1.get(Calendar.DATE));
      }
      
        if((c1.get(Calendar.MONTH)+1)<=9)
      {
          mes = "0"+Integer.toString(c1.get(Calendar.MONTH)+1);
      }
      else
      {
          mes = Integer.toString(c1.get(Calendar.MONTH)+1);
      }
       
      ano = Integer.toString(c1.get(Calendar.YEAR));
       
      
      //SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy/MM/dd");
      
      String date = ano+"-"+mes+"-"+dia;
      return date;

}


public  boolean esValidaFecha(String fechax) throws ParseException {
   String fechActual = compararFechaActual();
 SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
    try {
        formatoFecha.setLenient(false);
            formatoFecha.parse(fechax);
         if(formatoFecha.parse(fechax).equals(formatoFecha.parse(fechActual))||formatoFecha.parse(fechax).before(formatoFecha.parse(fechActual)))
              { 
                  if(formatoFecha.parse(fechax).after(formatoFecha.parse("2000-01-01")))
                          {
                             return true; 
                          }
                  else
                      {
                  JOptionPane.showMessageDialog(null, "El formato es AAAA-MM-DD");
                  return false;
                       }
             
        }
            else
   {
       JOptionPane.showMessageDialog(null, "Formato de fecha no válido");
       return false;
   }
        }catch (ParseException e) {
            return false;

     }
   
   
    } 
}
 
