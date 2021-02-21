/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Conexiones.ConexionSQL;
import InterfacesAdministración.AsisInicio;
import InterfacesAdministración.InicioAdminUsuarios;
import InterfacesAdministración.Login;
import Validaciones.ValidacionPersonaNaturalesRUC;
import Validaciones.validarCampos;
import Validaciones.validarFecha;
import java.awt.event.KeyEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Bryan
 */
public class DeclaracionesVentasFacturaEdit extends javax.swing.JFrame {

     validarCampos validar = new validarCampos();
    validarFecha fecha = new validarFecha();
    ConexionSQL coneccion = new ConexionSQL();
    /**
     * Creates new form ContribuyentesPrincipal
     */
    public DeclaracionesVentasFacturaEdit() {
        initComponents();
        rsscalelabel.RSScaleLabel.setScaleLabel(jLSidimLogo, "src/Iconos/LogoSidim3670ab.png");
        jPaCerrarSesion.setVisible(false);
        this.setSize(1366, 768);
       jPanOpcFacturas.setVisible(false);
       
       jPanOpcNotasVenta.setVisible(false);
       
       
       
       String variable = DeclaracionesVentasFacturaList.mandarRUC;
       
            try {
                cargarCamposEnEditar(variable);
            } catch (SQLException ex) {
                Logger.getLogger(DeclaracionesComprasFacturaEdit.class.getName()).log(Level.SEVERE, null, ex);
            }

    }
    
    public void cargarCamposEnEditar(String buscar ) throws SQLException{
        String idContribuyente =  obtenerIdContribuyente();
     
        String query = "SELECT * from FacturaVentas where numeroFacturaVentas='"+buscar+"' and idContribuyente='"+idContribuyente+"'"; 

        try
        {
        coneccion.hacerConexion();
         PreparedStatement   pst = coneccion.conexion.prepareStatement(query);                         
         ResultSet   rs = pst.executeQuery();
            while(rs.next())
            {
                jTextFechVenFact.setText(rs.getString("fecha"));
                cmbTipoVentaVentFact.setSelectedItem(rs.getString("tipoVenta"));
                cmbPorcRetVentaFact.setSelectedItem(rs.getString("porcentajeRetenIVA"));
                cmbRetFuenVentaFact.setSelectedItem(rs.getString("porcentajeRetenFuente"));
                jTextRucVenFact.setText(rs.getString("ruc"));
                jTextRazCliVenFact.setText(rs.getString("razonSocialCliente"));
                jTextNumFacVenFact.setText(rs.getString("numeroFacturaVentas"));
                jTextBase12VenFact.setText(rs.getString("base12"));
                jTextBase0VenFact.setText(rs.getString("base0"));
                jIVA.setText(rs.getString("iva"));
                jValor.setText(rs.getString("total"));           
            }                      
        }
        catch(SQLException e)
        {
            
            JOptionPane.showMessageDialog(null,"Error al conectar. "+e.getMessage());
        }
        
         
    }
    
    public boolean numeroUnicoFactura() throws SQLException
     {
         boolean bandera = false;
         coneccion.hacerConexion();
        String query = "Select * from FacturaVentas where numeroFacturaVentas = ?  ";
        PreparedStatement pst = coneccion.conexion.prepareStatement(query);                     
        pst.setString(1, jTextNumFacVenFact.getText());
        ResultSet rs = pst.executeQuery();
        if(rs.next()){
            JOptionPane.showConfirmDialog(null,"Este factura ya está registrada, ingrese un número de factura nuevo");
        }
        else
        {
            bandera = true;
        }
        coneccion.cerrarConexion();
        return bandera;
     }
     
     
      
        public String obtenerIdContribuyente() throws SQLException{
            
            
            
            String idContribuyente =null;
              String query = "SELECT * FROM Contribuyente WHERE ruc = '"+DeclaracionesInicio.tomarRUCDECLARACIONES+"'"; 

        try
        {
        coneccion.hacerConexion();
         PreparedStatement   pst = coneccion.conexion.prepareStatement(query);                         
         ResultSet   rs = pst.executeQuery();
            while(rs.next())
            {
                idContribuyente=rs.getString("idContribuyente");
            }                      
        }
        catch(SQLException e)
        {
            
            JOptionPane.showMessageDialog(null,"Error al conectar. "+e.getMessage());
        }
        return idContribuyente;
        
     }
       
       public String calcularIVA(String valorBase12){

        double valor12 =0; 
                valor12=Double.parseDouble(valorBase12);
        double calcular =0; 
                calcular=valor12*(0.12);
                
                calcular = (double)Math.round(calcular * 100d) / 100d;
        String IVA =""+calcular;
        
        return IVA;
    }
    
      public String calcularValorTotal(String valorBase0,String valorBase12){
        double valor0 = 0;
             valor0 =   Double.parseDouble(valorBase0);
        double valor12 =0;
                valor12=Double.parseDouble(valorBase12);
        
        double IVA = 0;
                IVA=valor12*0.12;
        System.out.println(IVA);
        double calcular = 0;
                calcular=valor12+valor0+IVA;
                
              calcular = (double)Math.round(calcular * 100d) / 100d;
      
        
        String valorTotal =""+calcular;
        return valorTotal;
    }
      
       public String calcularPorcentajeRetencionesIVA(String valorBase0,String valorBase12,String porcentajeRetenciones){
        double valor0 = 0;
             valor0 =   Double.parseDouble(valorBase0);
        double valor12 =0;
                valor12=Double.parseDouble(valorBase12);
        
        double IVA = 0;
                IVA=valor12*0.12;
                
        double porcentajeRet = 0;
        porcentajeRet=Double.parseDouble(porcentajeRetenciones);
        
        double calcular = 0;
                calcular=(porcentajeRet*IVA)/100;
                
              calcular = (double)Math.round(calcular * 100d) / 100d;
      
        
        String valorTotal =""+calcular;
        return valorTotal;
    }
      public String calcularRetencionesFuente(String valorBase0,String valorBase12,String porcentajeFuente){
        double valor0 = 0;
             valor0 =   Double.parseDouble(valorBase0);
        double valor12 =0;
                valor12=Double.parseDouble(valorBase12);
        
      
        
        double porcentajeFue = 0;
        porcentajeFue=Double.parseDouble(porcentajeFuente);
        
        double calcular = 0;
                calcular=((porcentajeFue)*(valor0+valor12))/100;
                
              calcular = (double)Math.round(calcular * 100d) / 100d;
      
        
        String valorTotal =""+calcular;
        return valorTotal;
    }
      
       public void ActualizarFacturaCompra(){
      try {
           String idContribuyente =  obtenerIdContribuyente();
           String idFactura = DeclaracionesVentasFacturaList.manadarIDfactura;
           JOptionPane.showMessageDialog(null, idContribuyente+"jhgbrvfecd"+idFactura);
            coneccion.hacerConexion();
            Statement st = coneccion.conexion.createStatement();
            String fecha  = jTextFechVenFact.getText();
            String ruc = jTextRucVenFact.getText();
            String tipoCompra = cmbTipoVentaVentFact.getSelectedItem().toString();
            int porcentajeRetenIva= Integer.parseInt(cmbPorcRetVentaFact.getSelectedItem().toString());
            double porcentajeRetenFuente = Double.parseDouble(cmbRetFuenVentaFact.getSelectedItem().toString());
            String razonSocial = jTextRazCliVenFact.getText();
            String numFac = jTextNumFacVenFact.getText();
            double base12 = Double.parseDouble(jTextBase12VenFact.getText());         
            double iva = Double.parseDouble(jIVA.getText());
            double base0 = Double.parseDouble(jTextBase0VenFact.getText());
            double total = Double.parseDouble(jValor.getText());
            
            
            
            double  valorRetenIVA =Double.parseDouble( calcularPorcentajeRetencionesIVA(jTextBase0VenFact.getText(),jTextBase12VenFact.getText(),cmbPorcRetVentaFact.getSelectedItem().toString()));
            
            double valorRetenFuente=Double.parseDouble(calcularPorcentajeRetencionesIVA(jTextBase0VenFact.getText(),jTextBase12VenFact.getText(),cmbRetFuenVentaFact.getSelectedItem().toString()));
                JOptionPane.showMessageDialog(null, valorRetenFuente);
            
            JOptionPane.showMessageDialog(null,"update FacturaVentas set idContribuyente='"+idContribuyente+"' , fecha='"+fecha+"' , tipoVenta='"+tipoCompra+"' , ruc='"+ruc+"' ,razonSocialCliente='"+razonSocial+"' , numeroFacturaVentas ='"+numFac+"' ,base12="+base12+" , iva="+iva+" , base0="+base0+" , total="+total+" , porcentajeRetenIVA ="+porcentajeRetenIva+" ,valorRetenIVA="+valorRetenIVA+" , porcentajeRetenFuente="+porcentajeRetenFuente+" , valorRetenFuente="+valorRetenFuente+" where idFacturaVentas='"+idFactura+"' and idContribuyente='"+idContribuyente+"';");

            st.execute("update FacturaVentas set  fecha='"+fecha+"' , tipoVenta='"+tipoCompra+"' , ruc='"+ruc+"' ,razonSocialCliente='"+razonSocial+"' , numeroFacturaVentas ='"+numFac+"' ,base12="+base12+" , iva="+iva+" , base0="+base0+" , total="+total+" , porcentajeRetenIVA ="+porcentajeRetenIva+" ,valorRetenIVA="+valorRetenIVA+" , porcentajeRetenFuente="+porcentajeRetenFuente+" , valorRetenFuente="+valorRetenFuente+" where idFacturaVentas='"+idFactura+"' and idContribuyente='"+idContribuyente+"';") ;  
            JOptionPane.showMessageDialog(null, "Se ha actualizado con exito");
            
         } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "id de producto ya existe , ingrese uno id diferente"+ex);
        }  
      catch (Exception e) {
            System.out.println(""+e);
        }
      
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPEncabezado = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLSidimLogo = new javax.swing.JLabel();
        jPMod = new javax.swing.JPanel();
        jLabNombreContribuyente = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanOpcionesDeclaracion = new javax.swing.JPanel();
        jButClientes = new javax.swing.JButton();
        jButCompras = new javax.swing.JButton();
        jPanOpcFacturas = new javax.swing.JPanel();
        jButRegFactura = new javax.swing.JButton();
        jButVerTodFactura = new javax.swing.JButton();
        jPanOpcNotasVenta = new javax.swing.JPanel();
        jButRegNotasVenta = new javax.swing.JButton();
        jButVerTodNotasVenta = new javax.swing.JButton();
        jLabNombreContribuyente1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPaCerrarSesion = new javax.swing.JPanel();
        jBCerrarSesion = new javax.swing.JButton();
        PanelVerTodos = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jTextRucVenFact = new javax.swing.JTextField();
        jTextFechVenFact = new javax.swing.JTextField();
        jTextNumFacVenFact = new javax.swing.JTextField();
        jTextRazCliVenFact = new javax.swing.JTextField();
        jTextBase12VenFact = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jButRegFactVen = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        cmbTipoVentaVentFact = new javax.swing.JComboBox<>();
        jLabel15 = new javax.swing.JLabel();
        jTextBase0VenFact = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        cmbPorcRetVentaFact = new javax.swing.JComboBox<>();
        jLabel17 = new javax.swing.JLabel();
        cmbRetFuenVentaFact = new javax.swing.JComboBox<>();
        jLabel18 = new javax.swing.JLabel();
        jIVA = new javax.swing.JLabel();
        jValor = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPEncabezado.setBackground(new java.awt.Color(54, 112, 171));

        jLabel2.setBackground(new java.awt.Color(80, 125, 180));
        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(240, 240, 241));
        jLabel2.setText("Hola: Admin");
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPEncabezadoLayout = new javax.swing.GroupLayout(jPEncabezado);
        jPEncabezado.setLayout(jPEncabezadoLayout);
        jPEncabezadoLayout.setHorizontalGroup(
            jPEncabezadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPEncabezadoLayout.createSequentialGroup()
                .addComponent(jLSidimLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPEncabezadoLayout.setVerticalGroup(
            jPEncabezadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
            .addComponent(jLSidimLogo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPMod.setBackground(new java.awt.Color(51, 51, 51));
        jPMod.setForeground(new java.awt.Color(51, 51, 51));
        jPMod.setMaximumSize(new java.awt.Dimension(300, 200));
        jPMod.setPreferredSize(new java.awt.Dimension(300, 280));

        jLabNombreContribuyente.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabNombreContribuyente.setForeground(new java.awt.Color(240, 240, 241));
        jLabNombreContribuyente.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabNombreContribuyente.setText("Juan Perez");

        jButton1.setBackground(new java.awt.Color(38, 35, 36));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(240, 240, 241));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/iconBack48x48.png"))); // NOI18N
        jButton1.setText("Volver");
        jButton1.setBorderPainted(false);
        jButton1.setFocusPainted(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/iconUser48x48.png"))); // NOI18N

        jPanOpcionesDeclaracion.setBackground(new java.awt.Color(51, 51, 51));

        jButClientes.setBackground(new java.awt.Color(38, 35, 36));
        jButClientes.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButClientes.setForeground(new java.awt.Color(240, 240, 241));
        jButClientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/iconClip32x32.png"))); // NOI18N
        jButClientes.setText("      Facturas       ");
        jButClientes.setBorderPainted(false);
        jButClientes.setFocusPainted(false);
        jButClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButClientesActionPerformed(evt);
            }
        });

        jButCompras.setBackground(new java.awt.Color(38, 35, 36));
        jButCompras.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButCompras.setForeground(new java.awt.Color(240, 240, 241));
        jButCompras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/iconHoja1-32x32.png"))); // NOI18N
        jButCompras.setText(" Notas de Crédito");
        jButCompras.setBorderPainted(false);
        jButCompras.setFocusPainted(false);
        jButCompras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButComprasActionPerformed(evt);
            }
        });

        jPanOpcFacturas.setBackground(new java.awt.Color(51, 51, 51));

        jButRegFactura.setBackground(new java.awt.Color(85, 85, 85));
        jButRegFactura.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButRegFactura.setForeground(new java.awt.Color(240, 240, 241));
        jButRegFactura.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/iconAdd24x24.png"))); // NOI18N
        jButRegFactura.setText("Registrar");
        jButRegFactura.setBorderPainted(false);
        jButRegFactura.setFocusPainted(false);
        jButRegFactura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButRegFacturaActionPerformed(evt);
            }
        });

        jButVerTodFactura.setBackground(new java.awt.Color(85, 85, 85));
        jButVerTodFactura.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButVerTodFactura.setForeground(new java.awt.Color(240, 240, 241));
        jButVerTodFactura.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/iconList24x24.png"))); // NOI18N
        jButVerTodFactura.setText("Ver Todos");
        jButVerTodFactura.setBorderPainted(false);
        jButVerTodFactura.setFocusPainted(false);
        jButVerTodFactura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButVerTodFacturaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanOpcFacturasLayout = new javax.swing.GroupLayout(jPanOpcFacturas);
        jPanOpcFacturas.setLayout(jPanOpcFacturasLayout);
        jPanOpcFacturasLayout.setHorizontalGroup(
            jPanOpcFacturasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jButRegFactura, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jButVerTodFactura, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanOpcFacturasLayout.setVerticalGroup(
            jPanOpcFacturasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanOpcFacturasLayout.createSequentialGroup()
                .addComponent(jButRegFactura, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButVerTodFactura, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanOpcNotasVenta.setBackground(new java.awt.Color(51, 51, 51));

        jButRegNotasVenta.setBackground(new java.awt.Color(85, 85, 85));
        jButRegNotasVenta.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButRegNotasVenta.setForeground(new java.awt.Color(240, 240, 241));
        jButRegNotasVenta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/iconAdd24x24.png"))); // NOI18N
        jButRegNotasVenta.setText("Registrar");
        jButRegNotasVenta.setBorderPainted(false);
        jButRegNotasVenta.setFocusPainted(false);
        jButRegNotasVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButRegNotasVentaActionPerformed(evt);
            }
        });

        jButVerTodNotasVenta.setBackground(new java.awt.Color(85, 85, 85));
        jButVerTodNotasVenta.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButVerTodNotasVenta.setForeground(new java.awt.Color(240, 240, 241));
        jButVerTodNotasVenta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/iconList24x24.png"))); // NOI18N
        jButVerTodNotasVenta.setText("Ver Todos");
        jButVerTodNotasVenta.setBorderPainted(false);
        jButVerTodNotasVenta.setFocusPainted(false);
        jButVerTodNotasVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButVerTodNotasVentaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanOpcNotasVentaLayout = new javax.swing.GroupLayout(jPanOpcNotasVenta);
        jPanOpcNotasVenta.setLayout(jPanOpcNotasVentaLayout);
        jPanOpcNotasVentaLayout.setHorizontalGroup(
            jPanOpcNotasVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jButRegNotasVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jButVerTodNotasVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanOpcNotasVentaLayout.setVerticalGroup(
            jPanOpcNotasVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanOpcNotasVentaLayout.createSequentialGroup()
                .addComponent(jButRegNotasVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButVerTodNotasVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jPanOpcionesDeclaracionLayout = new javax.swing.GroupLayout(jPanOpcionesDeclaracion);
        jPanOpcionesDeclaracion.setLayout(jPanOpcionesDeclaracionLayout);
        jPanOpcionesDeclaracionLayout.setHorizontalGroup(
            jPanOpcionesDeclaracionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanOpcFacturas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jButCompras, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(jPanOpcionesDeclaracionLayout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addComponent(jPanOpcNotasVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanOpcionesDeclaracionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanOpcionesDeclaracionLayout.createSequentialGroup()
                    .addComponent(jButClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanOpcionesDeclaracionLayout.setVerticalGroup(
            jPanOpcionesDeclaracionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanOpcionesDeclaracionLayout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addComponent(jPanOpcFacturas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButCompras)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanOpcNotasVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(198, Short.MAX_VALUE))
            .addGroup(jPanOpcionesDeclaracionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanOpcionesDeclaracionLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jButClientes)
                    .addContainerGap(385, Short.MAX_VALUE)))
        );

        jLabNombreContribuyente1.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabNombreContribuyente1.setForeground(new java.awt.Color(240, 240, 241));
        jLabNombreContribuyente1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabNombreContribuyente1.setText("VENTAS");

        javax.swing.GroupLayout jPModLayout = new javax.swing.GroupLayout(jPMod);
        jPMod.setLayout(jPModLayout);
        jPModLayout.setHorizontalGroup(
            jPModLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPModLayout.createSequentialGroup()
                .addComponent(jLabNombreContribuyente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addGap(10, 10, 10))
            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPModLayout.createSequentialGroup()
                .addComponent(jPanOpcionesDeclaracion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPModLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabNombreContribuyente1, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPModLayout.setVerticalGroup(
            jPModLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPModLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPModLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabNombreContribuyente, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabNombreContribuyente1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanOpcionesDeclaracion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50))
        );

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 35)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(38, 35, 36));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Editar Factura");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(163, 164, 166));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Llena el formulario para editar una Factura de Venta.");

        jPaCerrarSesion.setBackground(new java.awt.Color(255, 255, 255));

        jBCerrarSesion.setBackground(new java.awt.Color(0, 153, 51));
        jBCerrarSesion.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jBCerrarSesion.setForeground(new java.awt.Color(240, 240, 241));
        jBCerrarSesion.setText("Cerrar Sesión");
        jBCerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBCerrarSesionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPaCerrarSesionLayout = new javax.swing.GroupLayout(jPaCerrarSesion);
        jPaCerrarSesion.setLayout(jPaCerrarSesionLayout);
        jPaCerrarSesionLayout.setHorizontalGroup(
            jPaCerrarSesionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jBCerrarSesion, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPaCerrarSesionLayout.setVerticalGroup(
            jPaCerrarSesionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPaCerrarSesionLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jBCerrarSesion, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        PanelVerTodos.setBackground(new java.awt.Color(255, 255, 255));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel8.setText("Fecha:");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel9.setText("RUC:");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel10.setText("Razón Social del Cliente:");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel11.setText("Número de Factura");

        jTextRucVenFact.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextRucVenFactActionPerformed(evt);
            }
        });
        jTextRucVenFact.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextRucVenFactKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextRucVenFactKeyTyped(evt);
            }
        });

        jTextFechVenFact.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFechVenFactActionPerformed(evt);
            }
        });
        jTextFechVenFact.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFechVenFactKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFechVenFactKeyTyped(evt);
            }
        });

        jTextNumFacVenFact.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextNumFacVenFactActionPerformed(evt);
            }
        });
        jTextNumFacVenFact.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextNumFacVenFactKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextNumFacVenFactKeyTyped(evt);
            }
        });

        jTextRazCliVenFact.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextRazCliVenFactKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextRazCliVenFactKeyTyped(evt);
            }
        });

        jTextBase12VenFact.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextBase12VenFactKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextBase12VenFactKeyTyped(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel13.setText("Base 12%:");

        jButRegFactVen.setBackground(new java.awt.Color(38, 112, 171));
        jButRegFactVen.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButRegFactVen.setForeground(new java.awt.Color(240, 240, 241));
        jButRegFactVen.setText("Guardar");
        jButRegFactVen.setBorderPainted(false);
        jButRegFactVen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButRegFactVenActionPerformed(evt);
            }
        });
        jButRegFactVen.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jButRegFactVenKeyTyped(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel14.setText("IVA:");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel12.setText("Tipo de Venta:");

        cmbTipoVentaVentFact.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cmbTipoVentaVentFact.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ventas General", "Anulado", "Ventas Activos Fijos 12%", "Ventas Activos Fijos 0%", "Reembolsos" }));
        cmbTipoVentaVentFact.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbTipoVentaVentFactItemStateChanged(evt);
            }
        });
        cmbTipoVentaVentFact.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbTipoVentaVentFactActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel15.setText("Base 0%:");

        jTextBase0VenFact.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextBase0VenFactKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextBase0VenFactKeyTyped(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel16.setText("VALOR TOTAL:");

        cmbPorcRetVentaFact.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cmbPorcRetVentaFact.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "30", "70", "100" }));
        cmbPorcRetVentaFact.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbPorcRetVentaFactActionPerformed(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel17.setText("% Retenciones IVA");

        cmbRetFuenVentaFact.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cmbRetFuenVentaFact.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "1.75", "2", "2.75", "8", "10" }));
        cmbRetFuenVentaFact.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbRetFuenVentaFactActionPerformed(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel18.setText("% Retenciones en la Fuente:");

        javax.swing.GroupLayout PanelVerTodosLayout = new javax.swing.GroupLayout(PanelVerTodos);
        PanelVerTodos.setLayout(PanelVerTodosLayout);
        PanelVerTodosLayout.setHorizontalGroup(
            PanelVerTodosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelVerTodosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelVerTodosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(PanelVerTodosLayout.createSequentialGroup()
                        .addGroup(PanelVerTodosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jTextFechVenFact, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(PanelVerTodosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addComponent(cmbTipoVentaVentFact, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(PanelVerTodosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel17)
                            .addComponent(cmbPorcRetVentaFact, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(PanelVerTodosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cmbRetFuenVentaFact, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, PanelVerTodosLayout.createSequentialGroup()
                        .addComponent(jTextBase12VenFact, javax.swing.GroupLayout.PREFERRED_SIZE, 393, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addGroup(PanelVerTodosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PanelVerTodosLayout.createSequentialGroup()
                                .addComponent(jLabel16)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jValor, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jTextBase0VenFact)))
                    .addComponent(jTextRucVenFact, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextRazCliVenFact, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextNumFacVenFact, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, PanelVerTodosLayout.createSequentialGroup()
                        .addGroup(PanelVerTodosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PanelVerTodosLayout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addGap(324, 324, 324)
                                .addComponent(jLabel15))
                            .addComponent(jLabel9)
                            .addComponent(jLabel10)
                            .addComponent(jLabel11)
                            .addComponent(jButRegFactVen, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(PanelVerTodosLayout.createSequentialGroup()
                                .addComponent(jLabel14)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jIVA, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(51, 51, 51))
        );
        PanelVerTodosLayout.setVerticalGroup(
            PanelVerTodosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelVerTodosLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(PanelVerTodosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(PanelVerTodosLayout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(8, 8, 8)
                        .addComponent(jTextFechVenFact, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelVerTodosLayout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addGap(5, 5, 5)
                        .addGroup(PanelVerTodosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmbPorcRetVentaFact, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbRetFuenVentaFact, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(PanelVerTodosLayout.createSequentialGroup()
                        .addComponent(jLabel18)
                        .addGap(44, 44, 44))
                    .addComponent(cmbTipoVentaVentFact, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(PanelVerTodosLayout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addGap(43, 43, 43)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addGap(6, 6, 6)
                .addComponent(jTextRucVenFact, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10)
                .addGap(6, 6, 6)
                .addComponent(jTextRazCliVenFact, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel11)
                .addGap(6, 6, 6)
                .addComponent(jTextNumFacVenFact, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addGroup(PanelVerTodosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jLabel15))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(PanelVerTodosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelVerTodosLayout.createSequentialGroup()
                        .addGroup(PanelVerTodosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextBase0VenFact, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextBase12VenFact, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(PanelVerTodosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(jLabel16)
                            .addComponent(jIVA, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jValor, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addComponent(jButRegFactVen)
                .addGap(23, 23, 23))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPMod, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 489, Short.MAX_VALUE)
                        .addComponent(jPaCerrarSesion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(PanelVerTodos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addComponent(jPEncabezado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPEncabezado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PanelVerTodos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPaCerrarSesion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPMod, javax.swing.GroupLayout.PREFERRED_SIZE, 655, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Login login = new Login();
        String rol = Login.rol;
        if (rol.compareTo("Administrador")==0){
            InicioAdminUsuarios A = new InicioAdminUsuarios();
            A.setVisible(true);
            this.setVisible(false);
        }
        else{
            AsisInicio A = new AsisInicio();
            A.setVisible(true);
            this.setVisible(false);
            
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButClientesActionPerformed
        if (jPanOpcNotasVenta.isVisible()){
            jPanOpcNotasVenta.setVisible(false);
        }
       
        if(jPanOpcFacturas.isVisible())
            jPanOpcFacturas.setVisible(false);
        else
            jPanOpcFacturas.setVisible(true);
    }//GEN-LAST:event_jButClientesActionPerformed

    private void jButComprasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButComprasActionPerformed
        if (jPanOpcFacturas.isVisible()){
            jPanOpcFacturas.setVisible(false);
        }
      
        if(jPanOpcNotasVenta.isVisible())
            jPanOpcNotasVenta.setVisible(false);
        else
            jPanOpcNotasVenta.setVisible(true);
        
    }//GEN-LAST:event_jButComprasActionPerformed

    private void jBCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBCerrarSesionActionPerformed
Login login = new Login();
        login.setVisible(true);
        this.setVisible(false);        // TODO add your handling code here:
    }//GEN-LAST:event_jBCerrarSesionActionPerformed

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        
        if(jPaCerrarSesion.isVisible())
            jPaCerrarSesion.setVisible(false);
        else jPaCerrarSesion.setVisible(true);
        
    }//GEN-LAST:event_jLabel2MouseClicked

    private void jButRegFacturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButRegFacturaActionPerformed
         DeclaracionesVentasFacturaReg registrar = new DeclaracionesVentasFacturaReg();
        registrar.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButRegFacturaActionPerformed

    private void jButVerTodFacturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButVerTodFacturaActionPerformed
        DeclaracionesVentasFacturaList lista = new DeclaracionesVentasFacturaList();
        lista.setVisible(true);
        this.setVisible(false); 
    }//GEN-LAST:event_jButVerTodFacturaActionPerformed

    private void jButVerTodNotasVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButVerTodNotasVentaActionPerformed
        DeclaracionesVentasNotaCreditoList lista = new DeclaracionesVentasNotaCreditoList();
        lista.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButVerTodNotasVentaActionPerformed

    private void jButRegNotasVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButRegNotasVentaActionPerformed
        DeclaracionesVentasNotaCreditoReg registrar = new DeclaracionesVentasNotaCreditoReg();
       registrar.setVisible(true);
       this.setVisible(false);
    }//GEN-LAST:event_jButRegNotasVentaActionPerformed

    private void jTextRucVenFactActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextRucVenFactActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextRucVenFactActionPerformed

    private void jTextFechVenFactActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFechVenFactActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFechVenFactActionPerformed

    private void jTextNumFacVenFactActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextNumFacVenFactActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextNumFacVenFactActionPerformed

    private void jButRegFactVenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButRegFactVenActionPerformed
        ActualizarFacturaCompra();
        DeclaracionesVentasFacturaList lista = new DeclaracionesVentasFacturaList();
        lista.setVisible(true);
        this.setVisible(false);
        
    }//GEN-LAST:event_jButRegFactVenActionPerformed

    private void cmbTipoVentaVentFactActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbTipoVentaVentFactActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbTipoVentaVentFactActionPerformed

    private void cmbPorcRetVentaFactActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbPorcRetVentaFactActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbPorcRetVentaFactActionPerformed

    private void cmbRetFuenVentaFactActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbRetFuenVentaFactActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbRetFuenVentaFactActionPerformed

    private void jTextFechVenFactKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFechVenFactKeyTyped
        // TODO add your handling code here:
                
        validar.tamanoCam(jTextFechVenFact, 10, evt);
        validar.fechaSlash(jTextFechVenFact, evt);
    }//GEN-LAST:event_jTextFechVenFactKeyTyped

    private void jTextFechVenFactKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFechVenFactKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()== KeyEvent.VK_ENTER)
            { 
                if(jTextFechVenFact.getText().length()!=0){
                    try {
                        if((fecha.esValidaFecha(jTextFechVenFact.getText())==true)){
                            jTextRucVenFact.setEnabled(true);
                        }
                        else
                        {
                            JOptionPane.showMessageDialog(null,"Ingrese una fecha valida");
                        }
                    } catch (ParseException ex) {
                        Logger.getLogger(DeclaracionesComprasFacturaReg.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"No se puede ingresar una fecha vacia");
                }
            }
    }//GEN-LAST:event_jTextFechVenFactKeyPressed

    private void jTextRucVenFactKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextRucVenFactKeyTyped
        // TODO add your handling code here:
         validar.soloDigitos(jTextRucVenFact, evt);
        validar.tamanoCam(jTextRucVenFact,13 , evt);
    }//GEN-LAST:event_jTextRucVenFactKeyTyped

    private void jTextRucVenFactKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextRucVenFactKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()== KeyEvent.VK_ENTER)
            { 
                if(jTextRucVenFact.getText().length()==13)
                {   
                        ValidacionPersonaNaturalesRUC validar = new ValidacionPersonaNaturalesRUC();

                        if((validar.personaNaturalRUC(jTextRucVenFact.getText())==true))
                            
                        {
                            if((DeclaracionesInicio.tomarRUCDECLARACIONES.equals(jTextRucVenFact.getText()))==false)
                            {
                                cmbTipoVentaVentFact.setEnabled(true);
                                cmbPorcRetVentaFact.setEnabled(true);
                                cmbRetFuenVentaFact.setEnabled(true);
                                 }
                                else
                                {
                                    JOptionPane.showConfirmDialog(null,"No se puede registrar como cliente siendo contribuyente");
                                }
                        }
                        else
                        {
                            JOptionPane.showMessageDialog(null,"Ingrese un RUC  que valga");
                        }
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "El RUC consta de 13 números");
                }
            }
    }//GEN-LAST:event_jTextRucVenFactKeyPressed

    private void cmbTipoVentaVentFactItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbTipoVentaVentFactItemStateChanged
        // TODO add your handling code here:
           if(cmbTipoVentaVentFact.getSelectedIndex()!=0)
        {
            jTextRazCliVenFact.setEnabled(true);
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Debe seleccionar algún tipo de venta");
        }
    }//GEN-LAST:event_cmbTipoVentaVentFactItemStateChanged

    private void jTextRazCliVenFactKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextRazCliVenFactKeyTyped
        // TODO add your handling code here:
         validar.soloLetras(jTextRazCliVenFact, evt);
        validar.tamanoCam(jTextRazCliVenFact, 130, evt);
    }//GEN-LAST:event_jTextRazCliVenFactKeyTyped

    private void jTextRazCliVenFactKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextRazCliVenFactKeyPressed
        // TODO add your handling code here:
        if(jTextRazCliVenFact.getText().length()!=0){
           
            if(evt.getKeyCode()== KeyEvent.VK_ENTER)
                { 
                    jTextNumFacVenFact.setEnabled(true);
                }
        }
    }//GEN-LAST:event_jTextRazCliVenFactKeyPressed

    private void jTextNumFacVenFactKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextNumFacVenFactKeyTyped
        // TODO add your handling code here:
        validar.soloDigitos(jTextNumFacVenFact, evt);
        validar.tamanoCam(jTextNumFacVenFact, 15, evt);
    }//GEN-LAST:event_jTextNumFacVenFactKeyTyped

    private void jTextNumFacVenFactKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextNumFacVenFactKeyPressed
        // TODO add your handling code here:
         if(evt.getKeyCode()== KeyEvent.VK_ENTER){
         if(jTextNumFacVenFact.getText().length()!=0)
                {
                     jTextBase12VenFact.setEnabled(true); 
                 }
     
                }
        
    }//GEN-LAST:event_jTextNumFacVenFactKeyPressed

    private void jTextBase12VenFactKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextBase12VenFactKeyTyped
        // TODO add your handling code here:
        validar.valoresDEcimales(jTextBase12VenFact, evt);
    }//GEN-LAST:event_jTextBase12VenFactKeyTyped

    private void jTextBase12VenFactKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextBase12VenFactKeyPressed
        // TODO add your handling code here:
         if(evt.getKeyCode()== KeyEvent.VK_ENTER){
         if(jTextBase12VenFact.getText().length()!=0)
                { 
                      if(validar.validarDecimal(jTextBase12VenFact.getText())==true)
                      {
                          String caclIVA= jTextBase12VenFact.getText();
                          jTextBase0VenFact.setEnabled(true);
                          JOptionPane.showMessageDialog(null, calcularIVA(caclIVA));
                          jIVA.setText(calcularIVA(caclIVA));
                      }
                }
        }
    }//GEN-LAST:event_jTextBase12VenFactKeyPressed

    private void jTextBase0VenFactKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextBase0VenFactKeyTyped
        // TODO add your handling code here:
         validar.valoresDEcimales(jTextBase0VenFact, evt);
    }//GEN-LAST:event_jTextBase0VenFactKeyTyped

    private void jTextBase0VenFactKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextBase0VenFactKeyPressed
        // TODO add your handling code here:
         if(evt.getKeyCode()== KeyEvent.VK_ENTER){
         if(jTextBase0VenFact.getText().length()!=0)
                { 
                      if(validar.validarDecimal(jTextBase0VenFact.getText())==true)
                      {
                          String base0 = jTextBase0VenFact.getText();
                          String base12=jTextBase12VenFact.getText();
                          jValor.setText(calcularValorTotal(base0,base12));
                          jButRegFactVen.setEnabled(true);
                      }
                }
        }
    }//GEN-LAST:event_jTextBase0VenFactKeyPressed

    private void jButRegFactVenKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButRegFactVenKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jButRegFactVenKeyTyped

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DeclaracionesVentasFacturaEdit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DeclaracionesVentasFacturaEdit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DeclaracionesVentasFacturaEdit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DeclaracionesVentasFacturaEdit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DeclaracionesVentasFacturaEdit().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelVerTodos;
    private javax.swing.JComboBox<String> cmbPorcRetVentaFact;
    private javax.swing.JComboBox<String> cmbRetFuenVentaFact;
    private javax.swing.JComboBox<String> cmbTipoVentaVentFact;
    private javax.swing.JButton jBCerrarSesion;
    private javax.swing.JButton jButClientes;
    private javax.swing.JButton jButCompras;
    private javax.swing.JButton jButRegFactVen;
    private javax.swing.JButton jButRegFactura;
    private javax.swing.JButton jButRegNotasVenta;
    private javax.swing.JButton jButVerTodFactura;
    private javax.swing.JButton jButVerTodNotasVenta;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jIVA;
    private javax.swing.JLabel jLSidimLogo;
    private javax.swing.JLabel jLabNombreContribuyente;
    private javax.swing.JLabel jLabNombreContribuyente1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPEncabezado;
    private javax.swing.JPanel jPMod;
    private javax.swing.JPanel jPaCerrarSesion;
    private javax.swing.JPanel jPanOpcFacturas;
    private javax.swing.JPanel jPanOpcNotasVenta;
    private javax.swing.JPanel jPanOpcionesDeclaracion;
    private javax.swing.JTextField jTextBase0VenFact;
    private javax.swing.JTextField jTextBase12VenFact;
    private javax.swing.JTextField jTextFechVenFact;
    private javax.swing.JTextField jTextNumFacVenFact;
    private javax.swing.JTextField jTextRazCliVenFact;
    private javax.swing.JTextField jTextRucVenFact;
    private javax.swing.JLabel jValor;
    // End of variables declaration//GEN-END:variables
}
