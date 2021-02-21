/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Validaciones;

/**
 *
 * @author Bryan
 */
public class pruebas {
    
     public static String calcularIVA(String valorBase12){
        System.out.println(valorBase12);
        double valor12 =0; 
                valor12=Double.parseDouble(valorBase12);
                System.out.println("En double"+valor12);
        double calcular =0; 
                calcular=valor12*(0.12);
                System.out.println("Calculado"+calcular);
        
        System.out.println(calcular);
        
        String IVA =String.format("%.2f", calcular);
        
        System.out.println(IVA);
        
        return IVA;
    }
     
      public static String calcularValorTotal(String valorBase0,String valorBase12){
        double valor0 = 0;
             valor0 =   Double.parseDouble(valorBase0);
        double valor12 =0;
                valor12=Double.parseDouble(valorBase12);
        
        double IVA = 0;
                IVA=valor12*0.12;
        System.out.println(IVA);
        double calcular = 0;
                calcular=valor12+valor0+IVA;
        
        String valorTotal =String.format("%.2f", calcular);
        
        return valorTotal;
    }
     
     public static void main(String[] args){
         System.out.println(calcularValorTotal("100.00","100.00"));
     }
     
     
     
      /////////INGRESODE DATOS A LA BASE////////////
        
       /* coneccion.hacerConexion();
        String query = "INSERT INTO Contribuyente(ruc, razonSocial, telefono,direccion,correoElectronico, tipoDeclaracionImp, Estado)\n" +
"VALUES (?,?,?,?,?,?,?);";
        try {
            PreparedStatement pst = coneccion.conexion.prepareStatement(query);
            pst.setString(1, jTextRucContReg.getText());
            pst.setString(2, jTextRazSocContReg.getText());
            pst.setString(3, jTextNumTelContReg.getText());
            pst.setString(4, jTextDirContReg.getText());
            pst.setString(5, jTextCorrElecContReg.getText());
            String tipoDEclaracion = jComTipoDeclara.getSelectedItem().toString();
            pst.setString(6, tipoDEclaracion);
            pst.setString(7, "Activo");    
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Los datos han sido ingresados satisfactoriamente ");
            coneccion.cerrarConexion();
            ////////////BORRADO DE CAMPOS////////////////
            ContribuyentesRegistro nueva = new ContribuyentesRegistro();
            nueva.setVisible(true);
            this.setVisible(false);
  
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Algo ha fallado intenta de nuevo");
            Logger.getLogger(ContribuyentesRegistro.class.getName()).log(Level.SEVERE, null, ex);
        }*/
        
        
        
    
}
