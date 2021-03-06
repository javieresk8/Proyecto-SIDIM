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
public class DeclaracionesComprasNotaVentaEdit extends javax.swing.JFrame {
          validarCampos validar = new validarCampos();
    validarFecha fecha = new validarFecha();
    ConexionSQL coneccion = new ConexionSQL();
    /**
     * Creates new form ContribuyentesPrincipal
     */
    public DeclaracionesComprasNotaVentaEdit() {
        initComponents();
        rsscalelabel.RSScaleLabel.setScaleLabel(jLSidimLogo, "src/Iconos/LogoSidim3670ab.png");
        jPaCerrarSesion.setVisible(false);
        this.setSize(1366, 768);
       jPanOpcFacturas.setVisible(false);
       jPanOpcNotasCredito.setVisible(false);
       jPanOpcNotasVenta.setVisible(false);
       
       String variable = DeclaracionesComprasNotaVentaList.mandarRUC;
       
       jTextRucCompNotaVenta.setEnabled(false);
       jTextRucCompNotaVenta.setEnabled(false);
       jTextNumNotVenCompNotaVenta.setEnabled(false);
       jTextTotalCompNotaVenta.setEnabled(false);
       jButRegNotaVentaComp.setEnabled(false);
       
       
            try {
                cargarCamposEnEditar(variable);
            } catch (SQLException ex) {
                Logger.getLogger(DeclaracionesComprasFacturaEdit.class.getName()).log(Level.SEVERE, null, ex);
            }
 
    }
    
    public void cargarCamposEnEditar(String buscar ) throws SQLException{
        String idContribuyente =  obtenerIdContribuyente();
     
        String query = "SELECT * from NotaVenta where numeroNotaVenta='"+buscar+"' and idContribuyente='"+idContribuyente+"'"; 
       // JOptionPane.showMessageDialog(null, "SELECT * from NotaVenta where numeroNotaVenta='"+buscar+"' and idContribuyente='"+idContribuyente+"'");
        try
        {
        coneccion.hacerConexion();
         PreparedStatement   pst = coneccion.conexion.prepareStatement(query);                         
         ResultSet   rs = pst.executeQuery();
            while(rs.next())
            {
                jTextFechCompNotaVenta.setText(rs.getString("fecha"));
                jTextRucCompNotaVenta.setText(rs.getString("ruc"));
                jTextRazSocCompNotaVenta.setText(rs.getString("razonSocial"));
                jTextNumNotVenCompNotaVenta.setText(rs.getString("numeroNotaVenta"));
                jTextTotalCompNotaVenta.setText(rs.getString("total"));
                          
            }                      
        }
        catch(SQLException e)
        {
            
            JOptionPane.showMessageDialog(null,"Error al conectar. "+e.getMessage());
        }
        
         
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
        
         public void ActualizarNotaVenta(){
             
      try {
           String idContribuyente =  obtenerIdContribuyente();
           String idNotaVenta = DeclaracionesComprasNotaVentaList.manadarIDnotaVenta;
          // JOptionPane.showMessageDialog(null, "Actualiza3 nota "+ idNotaVenta);
           

  
            coneccion.hacerConexion();
            Statement st = coneccion.conexion.createStatement();
            String fecha  = jTextFechCompNotaVenta.getText();
            String ruc = jTextRucCompNotaVenta.getText();
            String tipoCompra = "Compras RISE";
            String razonSocial = jTextRazSocCompNotaVenta.getText();
            String numNota = jTextNumNotVenCompNotaVenta.getText();
        
            double total = Double.parseDouble(jTextTotalCompNotaVenta.getText());         
            
        
            //JOptionPane.showMessageDialog(null,"update NotaVenta set fecha='"+fecha+"' , ruc='"+ruc+"' , razonSocial='"+razonSocial+"' ,tipoCompra='"+tipoCompra+"' , numeroNotaVenta ='"+numNota+"' ,total="+total+" where idNotaVenta='"+idNotaVenta+"';") ;  

            st.execute("update NotaVenta set fecha='"+fecha+"' , ruc='"+ruc+"' , razonSocial='"+razonSocial+"' ,tipoCompra='"+tipoCompra+"' , numeroNotaVenta ='"+numNota+"' ,total="+total+" where idNotaVenta='"+idNotaVenta+"';") ;  
            JOptionPane.showMessageDialog(null, "La Nota de Venta se actualizó exitosamente");
            
         } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ""+ex);
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
        jButventas = new javax.swing.JButton();
        jPanOpcFacturas = new javax.swing.JPanel();
        jButRegFactura = new javax.swing.JButton();
        jButVerTodFactura = new javax.swing.JButton();
        jPanOpcNotasVenta = new javax.swing.JPanel();
        jButRegNotasVenta = new javax.swing.JButton();
        jButVerTodNotasVenta = new javax.swing.JButton();
        jPanOpcNotasCredito = new javax.swing.JPanel();
        jButRegNotasCredito = new javax.swing.JButton();
        jButVerTodNotasCredito = new javax.swing.JButton();
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
        jTextRucCompNotaVenta = new javax.swing.JTextField();
        jTextFechCompNotaVenta = new javax.swing.JTextField();
        jTextNumNotVenCompNotaVenta = new javax.swing.JTextField();
        jTextRazSocCompNotaVenta = new javax.swing.JTextField();
        jTextTotalCompNotaVenta = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jButRegNotaVentaComp = new javax.swing.JButton();

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
        jButCompras.setText(" Notas de Venta");
        jButCompras.setBorderPainted(false);
        jButCompras.setFocusPainted(false);
        jButCompras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButComprasActionPerformed(evt);
            }
        });

        jButventas.setBackground(new java.awt.Color(38, 35, 36));
        jButventas.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButventas.setForeground(new java.awt.Color(240, 240, 241));
        jButventas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/iconoHoja2-32x32.png"))); // NOI18N
        jButventas.setText("Notas de Crédito");
        jButventas.setBorderPainted(false);
        jButventas.setFocusPainted(false);
        jButventas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButventasActionPerformed(evt);
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

        jPanOpcNotasCredito.setBackground(new java.awt.Color(51, 51, 51));

        jButRegNotasCredito.setBackground(new java.awt.Color(85, 85, 85));
        jButRegNotasCredito.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButRegNotasCredito.setForeground(new java.awt.Color(240, 240, 241));
        jButRegNotasCredito.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/iconAdd24x24.png"))); // NOI18N
        jButRegNotasCredito.setText("Registrar");
        jButRegNotasCredito.setBorderPainted(false);
        jButRegNotasCredito.setFocusPainted(false);
        jButRegNotasCredito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButRegNotasCreditoActionPerformed(evt);
            }
        });

        jButVerTodNotasCredito.setBackground(new java.awt.Color(85, 85, 85));
        jButVerTodNotasCredito.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButVerTodNotasCredito.setForeground(new java.awt.Color(240, 240, 241));
        jButVerTodNotasCredito.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/iconList24x24.png"))); // NOI18N
        jButVerTodNotasCredito.setText("Ver Todos");
        jButVerTodNotasCredito.setBorderPainted(false);
        jButVerTodNotasCredito.setFocusPainted(false);
        jButVerTodNotasCredito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButVerTodNotasCreditoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanOpcNotasCreditoLayout = new javax.swing.GroupLayout(jPanOpcNotasCredito);
        jPanOpcNotasCredito.setLayout(jPanOpcNotasCreditoLayout);
        jPanOpcNotasCreditoLayout.setHorizontalGroup(
            jPanOpcNotasCreditoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jButRegNotasCredito, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jButVerTodNotasCredito, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanOpcNotasCreditoLayout.setVerticalGroup(
            jPanOpcNotasCreditoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanOpcNotasCreditoLayout.createSequentialGroup()
                .addComponent(jButRegNotasCredito, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButVerTodNotasCredito, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jPanOpcionesDeclaracionLayout = new javax.swing.GroupLayout(jPanOpcionesDeclaracion);
        jPanOpcionesDeclaracion.setLayout(jPanOpcionesDeclaracionLayout);
        jPanOpcionesDeclaracionLayout.setHorizontalGroup(
            jPanOpcionesDeclaracionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanOpcFacturas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jButCompras, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(jPanOpcionesDeclaracionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                .addComponent(jButventas, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jPanOpcNotasVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jPanOpcNotasCredito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButventas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanOpcNotasCredito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(82, Short.MAX_VALUE))
            .addGroup(jPanOpcionesDeclaracionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanOpcionesDeclaracionLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jButClientes)
                    .addContainerGap(385, Short.MAX_VALUE)))
        );

        jLabNombreContribuyente1.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabNombreContribuyente1.setForeground(new java.awt.Color(240, 240, 241));
        jLabNombreContribuyente1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabNombreContribuyente1.setText("COMPRAS");

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
        jLabel4.setText("Editar Nota de Venta");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(163, 164, 166));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Llena el formulario para registrar una Nota de Venta en Compras.");

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
        jLabel10.setText("Razón Social:");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel11.setText("Número de Nota de Venta");

        jTextRucCompNotaVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextRucCompNotaVentaActionPerformed(evt);
            }
        });
        jTextRucCompNotaVenta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextRucCompNotaVentaKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextRucCompNotaVentaKeyTyped(evt);
            }
        });

        jTextFechCompNotaVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFechCompNotaVentaActionPerformed(evt);
            }
        });
        jTextFechCompNotaVenta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFechCompNotaVentaKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFechCompNotaVentaKeyTyped(evt);
            }
        });

        jTextNumNotVenCompNotaVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextNumNotVenCompNotaVentaActionPerformed(evt);
            }
        });
        jTextNumNotVenCompNotaVenta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextNumNotVenCompNotaVentaKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextNumNotVenCompNotaVentaKeyTyped(evt);
            }
        });

        jTextRazSocCompNotaVenta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextRazSocCompNotaVentaKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextRazSocCompNotaVentaKeyTyped(evt);
            }
        });

        jTextTotalCompNotaVenta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextTotalCompNotaVentaKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextTotalCompNotaVentaKeyTyped(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel13.setText("Valor Total:");

        jButRegNotaVentaComp.setBackground(new java.awt.Color(38, 112, 171));
        jButRegNotaVentaComp.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButRegNotaVentaComp.setForeground(new java.awt.Color(240, 240, 241));
        jButRegNotaVentaComp.setText("Guardar");
        jButRegNotaVentaComp.setBorderPainted(false);
        jButRegNotaVentaComp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButRegNotaVentaCompActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelVerTodosLayout = new javax.swing.GroupLayout(PanelVerTodos);
        PanelVerTodos.setLayout(PanelVerTodosLayout);
        PanelVerTodosLayout.setHorizontalGroup(
            PanelVerTodosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelVerTodosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelVerTodosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextRucCompNotaVenta)
                    .addComponent(jTextRazSocCompNotaVenta)
                    .addComponent(jTextNumNotVenCompNotaVenta)
                    .addComponent(jTextTotalCompNotaVenta)
                    .addGroup(PanelVerTodosLayout.createSequentialGroup()
                        .addGroup(PanelVerTodosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel13)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10)
                            .addComponent(jLabel11)
                            .addComponent(jButRegNotaVentaComp, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 593, Short.MAX_VALUE))
                    .addComponent(jTextFechCompNotaVenta))
                .addGap(51, 51, 51))
        );
        PanelVerTodosLayout.setVerticalGroup(
            PanelVerTodosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelVerTodosLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel8)
                .addGap(8, 8, 8)
                .addComponent(jTextFechCompNotaVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel9)
                .addGap(6, 6, 6)
                .addComponent(jTextRucCompNotaVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel10)
                .addGap(6, 6, 6)
                .addComponent(jTextRazSocCompNotaVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(jLabel11)
                .addGap(6, 6, 6)
                .addComponent(jTextNumNotVenCompNotaVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTextTotalCompNotaVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(jButRegNotaVentaComp)
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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 378, Short.MAX_VALUE)
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
           if (jPanOpcNotasCredito.isVisible()){
            jPanOpcNotasCredito.setVisible(false);
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
        if (jPanOpcNotasCredito.isVisible()){
            jPanOpcNotasCredito.setVisible(false);
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

    private void jButventasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButventasActionPerformed
           if (jPanOpcNotasVenta.isVisible()){
            jPanOpcNotasVenta.setVisible(false);
        }
           if (jPanOpcFacturas.isVisible()){
            jPanOpcFacturas.setVisible(false);
        }
        if(jPanOpcNotasCredito.isVisible())
            jPanOpcNotasCredito.setVisible(false);
        else
            jPanOpcNotasCredito.setVisible(true);
    }//GEN-LAST:event_jButventasActionPerformed

    private void jButRegFacturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButRegFacturaActionPerformed
        DeclaracionesComprasFacturaReg registro = new DeclaracionesComprasFacturaReg();
        registro.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButRegFacturaActionPerformed

    private void jButVerTodFacturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButVerTodFacturaActionPerformed
        DeclaracionesComprasFacturaList listar = new DeclaracionesComprasFacturaList();
        listar.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButVerTodFacturaActionPerformed

    private void jButVerTodNotasVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButVerTodNotasVentaActionPerformed
        DeclaracionesComprasNotaVentaList listar = new DeclaracionesComprasNotaVentaList();
        listar.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButVerTodNotasVentaActionPerformed

    private void jButRegNotasVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButRegNotasVentaActionPerformed
        DeclaracionesComprasNotaVentaReg registrar = new DeclaracionesComprasNotaVentaReg();
        registrar.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButRegNotasVentaActionPerformed

    private void jButVerTodNotasCreditoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButVerTodNotasCreditoActionPerformed
        DeclaracionesComprasNotaCreditoList listar = new DeclaracionesComprasNotaCreditoList();
        listar.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButVerTodNotasCreditoActionPerformed

    private void jButRegNotasCreditoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButRegNotasCreditoActionPerformed
        DeclaracionesComprasNotaCreditoReg registrar = new DeclaracionesComprasNotaCreditoReg();
        registrar.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButRegNotasCreditoActionPerformed

    private void jTextRucCompNotaVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextRucCompNotaVentaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextRucCompNotaVentaActionPerformed

    private void jTextFechCompNotaVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFechCompNotaVentaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFechCompNotaVentaActionPerformed

    private void jTextNumNotVenCompNotaVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextNumNotVenCompNotaVentaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextNumNotVenCompNotaVentaActionPerformed

    private void jButRegNotaVentaCompActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButRegNotaVentaCompActionPerformed

        ActualizarNotaVenta();
        
        DeclaracionesComprasNotaVentaList listar = new DeclaracionesComprasNotaVentaList();
        listar.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButRegNotaVentaCompActionPerformed

    private void jTextFechCompNotaVentaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFechCompNotaVentaKeyTyped
        // TODO add your handling code here:
        validar.tamanoCam(jTextFechCompNotaVenta, 10, evt);
        validar.fechaSlash(jTextFechCompNotaVenta, evt);
    }//GEN-LAST:event_jTextFechCompNotaVentaKeyTyped

    private void jTextFechCompNotaVentaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFechCompNotaVentaKeyPressed
        // TODO add your handling code here:
         if(evt.getKeyCode()== KeyEvent.VK_ENTER)
            { 
                if(jTextFechCompNotaVenta.getText().length()!=0){
                    try {
                        if((fecha.esValidaFecha(jTextFechCompNotaVenta.getText())==true)){
                            jTextRucCompNotaVenta.setEnabled(true);
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
    }//GEN-LAST:event_jTextFechCompNotaVentaKeyPressed

    private void jTextRucCompNotaVentaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextRucCompNotaVentaKeyTyped
        // TODO add your handling code here:
           validar.soloDigitos(jTextRucCompNotaVenta, evt);
        validar.tamanoCam(jTextRucCompNotaVenta,13 , evt);
    }//GEN-LAST:event_jTextRucCompNotaVentaKeyTyped

    private void jTextRucCompNotaVentaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextRucCompNotaVentaKeyPressed
        // TODO add your handling code here:
        
         if(evt.getKeyCode()== KeyEvent.VK_ENTER)
            { 
                if(jTextRucCompNotaVenta.getText().length()==13)
                {   
                        ValidacionPersonaNaturalesRUC validar = new ValidacionPersonaNaturalesRUC();

                        if((validar.personaNaturalRUC(jTextRucCompNotaVenta.getText())==true))
                            
                        {
                            if((DeclaracionesInicio.tomarRUCDECLARACIONES.equals(jTextRucCompNotaVenta.getText()))==false)
                            {
                                jTextRazSocCompNotaVenta.setEnabled(true);
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
    }//GEN-LAST:event_jTextRucCompNotaVentaKeyPressed

    private void jTextRazSocCompNotaVentaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextRazSocCompNotaVentaKeyTyped
        // TODO add your handling code here:
          validar.soloLetras(jTextRazSocCompNotaVenta, evt);
        validar.tamanoCam(jTextRazSocCompNotaVenta, 130, evt);
    }//GEN-LAST:event_jTextRazSocCompNotaVentaKeyTyped

    private void jTextRazSocCompNotaVentaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextRazSocCompNotaVentaKeyPressed
        // TODO add your handling code here:
         if(jTextRazSocCompNotaVenta.getText().length()!=0){
           
            if(evt.getKeyCode()== KeyEvent.VK_ENTER)
                { 
                    jTextNumNotVenCompNotaVenta.setEnabled(true);
                }
        }
    }//GEN-LAST:event_jTextRazSocCompNotaVentaKeyPressed

    private void jTextNumNotVenCompNotaVentaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextNumNotVenCompNotaVentaKeyTyped
        // TODO add your handling code here:
        validar.soloDigitos(jTextNumNotVenCompNotaVenta, evt);
        validar.tamanoCam(jTextNumNotVenCompNotaVenta, 15, evt);
    }//GEN-LAST:event_jTextNumNotVenCompNotaVentaKeyTyped

    private void jTextNumNotVenCompNotaVentaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextNumNotVenCompNotaVentaKeyPressed
        // TODO add your handling code here:
         if(evt.getKeyCode()== KeyEvent.VK_ENTER){
         if(jTextNumNotVenCompNotaVenta.getText().length()!=0)
                { 
                      jTextTotalCompNotaVenta.setEnabled(true);      
                }
        }
    }//GEN-LAST:event_jTextNumNotVenCompNotaVentaKeyPressed

    private void jTextTotalCompNotaVentaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextTotalCompNotaVentaKeyTyped
        // TODO add your handling code here:
        validar.valoresDEcimales(jTextTotalCompNotaVenta, evt);
    }//GEN-LAST:event_jTextTotalCompNotaVentaKeyTyped

    private void jTextTotalCompNotaVentaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextTotalCompNotaVentaKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()== KeyEvent.VK_ENTER){
         if(jTextTotalCompNotaVenta.getText().length()!=0)
                { 
                      if(validar.validarDecimal(jTextTotalCompNotaVenta.getText())==true)
                      {
                         
                          jButRegNotaVentaComp.setEnabled(true);
                     
                      }
                }
        }
    }//GEN-LAST:event_jTextTotalCompNotaVentaKeyPressed

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
            java.util.logging.Logger.getLogger(DeclaracionesComprasNotaVentaEdit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DeclaracionesComprasNotaVentaEdit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DeclaracionesComprasNotaVentaEdit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DeclaracionesComprasNotaVentaEdit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new DeclaracionesComprasNotaVentaEdit().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelVerTodos;
    private javax.swing.JButton jBCerrarSesion;
    private javax.swing.JButton jButClientes;
    private javax.swing.JButton jButCompras;
    private javax.swing.JButton jButRegFactura;
    private javax.swing.JButton jButRegNotaVentaComp;
    private javax.swing.JButton jButRegNotasCredito;
    private javax.swing.JButton jButRegNotasVenta;
    private javax.swing.JButton jButVerTodFactura;
    private javax.swing.JButton jButVerTodNotasCredito;
    private javax.swing.JButton jButVerTodNotasVenta;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButventas;
    private javax.swing.JLabel jLSidimLogo;
    private javax.swing.JLabel jLabNombreContribuyente;
    private javax.swing.JLabel jLabNombreContribuyente1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPEncabezado;
    private javax.swing.JPanel jPMod;
    private javax.swing.JPanel jPaCerrarSesion;
    private javax.swing.JPanel jPanOpcFacturas;
    private javax.swing.JPanel jPanOpcNotasCredito;
    private javax.swing.JPanel jPanOpcNotasVenta;
    private javax.swing.JPanel jPanOpcionesDeclaracion;
    private javax.swing.JTextField jTextFechCompNotaVenta;
    private javax.swing.JTextField jTextNumNotVenCompNotaVenta;
    private javax.swing.JTextField jTextRazSocCompNotaVenta;
    private javax.swing.JTextField jTextRucCompNotaVenta;
    private javax.swing.JTextField jTextTotalCompNotaVenta;
    // End of variables declaration//GEN-END:variables
}
