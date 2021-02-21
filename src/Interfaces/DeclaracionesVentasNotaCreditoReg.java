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
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Bryan
 */
public class DeclaracionesVentasNotaCreditoReg extends javax.swing.JFrame {
    
    
    
    validarCampos validar = new validarCampos();
    validarFecha fecha = new validarFecha();
    ConexionSQL coneccion = new ConexionSQL();

    /**
     * Creates new form ContribuyentesPrincipal
     */
    public DeclaracionesVentasNotaCreditoReg() {
        initComponents();
        rsscalelabel.RSScaleLabel.setScaleLabel(jLSidimLogo, "src/Iconos/LogoSidim3670ab.png");
        jPaCerrarSesion.setVisible(false);
        this.setSize(1366, 768);
       jPanOpcFacturas.setVisible(false);
      
       jPanOpcNotasVenta.setVisible(false);
       TextPrompt fechPlHol= new TextPrompt("AAA/MM/DD", jTextFechVenNotaCred);
       TextPrompt rucPlHol= new TextPrompt("RUC de la nota de crédito", jTextRucVenNotaCred);
       TextPrompt razSocPlHol= new TextPrompt("Nombre y apellido del Cliente de la nota de crédito", jTextRazSocVenNotaCred);
       TextPrompt numFactPlHol= new TextPrompt("Número de la nota de crédito", jTextNumFacVenNotaCred);
       TextPrompt base12PlHol= new TextPrompt("Valor de la base 12% de la nota de crédito", jTextBase12VenNotaCred);
       TextPrompt base0PlHol= new TextPrompt("Valor de la base 0% de la nota de crédito", jTextBase0VenNotaCred);
       
         
       cmbTipoCompraVenpNotaCred.setEnabled(false);
       jTextRucVenNotaCred.setEnabled(false);
       jTextRazSocVenNotaCred.setEnabled(false);
       jTextNumFacVenNotaCred.setEnabled(false);
       jTextBase12VenNotaCred.setEnabled(false);
       jTextBase0VenNotaCred.setEnabled(false);
       jButRegFactVenNotaCred.setEnabled(false);
        
        
    }
    
    
    public boolean numeroUnicoNotaCredito() throws SQLException
     {
         boolean bandera = false;
         coneccion.hacerConexion();
                            String query = "Select * from NotaCreditoVentas where numeroNotaCredVentas = ?  ";
                            PreparedStatement pst = coneccion.conexion.prepareStatement(query);                     
                            pst.setString(1, jTextNumFacVenNotaCred.getText());
                            ResultSet rs = pst.executeQuery();
                            if(rs.next()){
                                JOptionPane.showConfirmDialog(null,"Este nota de credito ya está registrada, ingrese un número de credito  nuevo");
                            }
                            else
                            {
                                bandera = true;
                            }
                            coneccion.cerrarConexion();
                            return bandera;
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
        jTextRucVenNotaCred = new javax.swing.JTextField();
        jTextFechVenNotaCred = new javax.swing.JTextField();
        jTextNumFacVenNotaCred = new javax.swing.JTextField();
        jTextRazSocVenNotaCred = new javax.swing.JTextField();
        jTextBase12VenNotaCred = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jButRegFactVenNotaCred = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        cmbTipoCompraVenpNotaCred = new javax.swing.JComboBox<>();
        jLabel15 = new javax.swing.JLabel();
        jTextBase0VenNotaCred = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jValor = new javax.swing.JLabel();
        jIVA = new javax.swing.JLabel();

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
        jLabel4.setText("Registro Nota de Crédito");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(163, 164, 166));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Llena el formulario para registrar una Nota de Crédito en Ventas.");

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
        jLabel11.setText("Número de Nota de Crédito");

        jTextRucVenNotaCred.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextRucVenNotaCredActionPerformed(evt);
            }
        });
        jTextRucVenNotaCred.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextRucVenNotaCredKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextRucVenNotaCredKeyTyped(evt);
            }
        });

        jTextFechVenNotaCred.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFechVenNotaCredActionPerformed(evt);
            }
        });
        jTextFechVenNotaCred.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFechVenNotaCredKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFechVenNotaCredKeyTyped(evt);
            }
        });

        jTextNumFacVenNotaCred.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextNumFacVenNotaCredActionPerformed(evt);
            }
        });
        jTextNumFacVenNotaCred.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextNumFacVenNotaCredKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextNumFacVenNotaCredKeyTyped(evt);
            }
        });

        jTextRazSocVenNotaCred.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextRazSocVenNotaCredKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextRazSocVenNotaCredKeyTyped(evt);
            }
        });

        jTextBase12VenNotaCred.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextBase12VenNotaCredKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextBase12VenNotaCredKeyTyped(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel13.setText("Base 12%:");

        jButRegFactVenNotaCred.setBackground(new java.awt.Color(38, 112, 171));
        jButRegFactVenNotaCred.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButRegFactVenNotaCred.setForeground(new java.awt.Color(240, 240, 241));
        jButRegFactVenNotaCred.setText("Registrar");
        jButRegFactVenNotaCred.setBorderPainted(false);
        jButRegFactVenNotaCred.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButRegFactVenNotaCredActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel14.setText("IVA:");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel12.setText("Tipo de Venta:");

        cmbTipoCompraVenpNotaCred.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cmbTipoCompraVenpNotaCred.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--Seleccionar--", "Ventas General", "Anulado", "Ventas Fijos 12%", "Ventas Fijos 0%", "Reembolsos" }));
        cmbTipoCompraVenpNotaCred.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbTipoCompraVenpNotaCredItemStateChanged(evt);
            }
        });
        cmbTipoCompraVenpNotaCred.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbTipoCompraVenpNotaCredActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel15.setText("Base 0%:");

        jTextBase0VenNotaCred.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextBase0VenNotaCredKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextBase0VenNotaCredKeyTyped(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel16.setText("VALOR TOTAL:");

        javax.swing.GroupLayout PanelVerTodosLayout = new javax.swing.GroupLayout(PanelVerTodos);
        PanelVerTodos.setLayout(PanelVerTodosLayout);
        PanelVerTodosLayout.setHorizontalGroup(
            PanelVerTodosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelVerTodosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelVerTodosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelVerTodosLayout.createSequentialGroup()
                        .addComponent(jTextBase12VenNotaCred, javax.swing.GroupLayout.PREFERRED_SIZE, 393, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addGroup(PanelVerTodosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PanelVerTodosLayout.createSequentialGroup()
                                .addComponent(jLabel16)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jValor, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jTextBase0VenNotaCred)))
                    .addComponent(jTextRucVenNotaCred)
                    .addComponent(jTextRazSocVenNotaCred)
                    .addComponent(jTextNumFacVenNotaCred)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelVerTodosLayout.createSequentialGroup()
                        .addGroup(PanelVerTodosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jTextFechVenNotaCred, javax.swing.GroupLayout.PREFERRED_SIZE, 444, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, Short.MAX_VALUE)
                        .addGroup(PanelVerTodosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(PanelVerTodosLayout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addGap(208, 208, 208))
                            .addComponent(cmbTipoCompraVenpNotaCred, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(PanelVerTodosLayout.createSequentialGroup()
                        .addGroup(PanelVerTodosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PanelVerTodosLayout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addGap(324, 324, 324)
                                .addComponent(jLabel15))
                            .addComponent(jLabel9)
                            .addComponent(jLabel10)
                            .addComponent(jLabel11)
                            .addComponent(jButRegFactVenNotaCred, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(PanelVerTodosLayout.createSequentialGroup()
                                .addComponent(jLabel14)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jIVA, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(51, 51, 51))
        );
        PanelVerTodosLayout.setVerticalGroup(
            PanelVerTodosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelVerTodosLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(PanelVerTodosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel12))
                .addGap(5, 5, 5)
                .addGroup(PanelVerTodosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFechVenNotaCred, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbTipoCompraVenpNotaCred, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addGap(6, 6, 6)
                .addComponent(jTextRucVenNotaCred, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10)
                .addGap(6, 6, 6)
                .addComponent(jTextRazSocVenNotaCred, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel11)
                .addGap(6, 6, 6)
                .addComponent(jTextNumFacVenNotaCred, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addGroup(PanelVerTodosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jLabel15))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(PanelVerTodosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextBase0VenNotaCred, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextBase12VenNotaCred, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(PanelVerTodosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelVerTodosLayout.createSequentialGroup()
                        .addGroup(PanelVerTodosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jValor, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(PanelVerTodosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel14)
                                .addComponent(jLabel16)))
                        .addGap(37, 37, 37)
                        .addComponent(jButRegFactVenNotaCred))
                    .addComponent(jIVA, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 383, Short.MAX_VALUE)
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
        DeclaracionesVentasFacturaList listar = new DeclaracionesVentasFacturaList();
        listar.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButVerTodFacturaActionPerformed

    private void jButVerTodNotasVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButVerTodNotasVentaActionPerformed
         DeclaracionesVentasNotaCreditoList listar = new DeclaracionesVentasNotaCreditoList();
       listar.setVisible(true);
       this.setVisible(false);
    }//GEN-LAST:event_jButVerTodNotasVentaActionPerformed

    private void jButRegNotasVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButRegNotasVentaActionPerformed
         DeclaracionesVentasNotaCreditoReg registrar = new DeclaracionesVentasNotaCreditoReg();
       registrar.setVisible(true);
       this.setVisible(false);
    }//GEN-LAST:event_jButRegNotasVentaActionPerformed

    private void jTextRucVenNotaCredActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextRucVenNotaCredActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextRucVenNotaCredActionPerformed

    private void jTextFechVenNotaCredActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFechVenNotaCredActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFechVenNotaCredActionPerformed

    private void jTextNumFacVenNotaCredActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextNumFacVenNotaCredActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextNumFacVenNotaCredActionPerformed

    private void jButRegFactVenNotaCredActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButRegFactVenNotaCredActionPerformed
        //Posible opcion a registrar otra factura
        String query = "INSERT INTO NotaCreditoVentas(idContribuyente, fecha, tipoVenta,ruc,razonSocialCliente, numeroNotaCredVentas, base12,iva,base0,total)\n" +
"VALUES (?,?,?,?,?,?,?,?,?,?);";
         
        try {
            coneccion.hacerConexion();
            PreparedStatement pst = coneccion.conexion.prepareStatement(query);
            String idContribuyente=obtenerIdContribuyente();
            
            pst.setString(1,idContribuyente);
            pst.setString(2, jTextFechVenNotaCred.getText());
            String tipoDecompra = cmbTipoCompraVenpNotaCred.getSelectedItem().toString();
            pst.setString(3,tipoDecompra);
            pst.setString(4, jTextRucVenNotaCred.getText());
            pst.setString(5, jTextRazSocVenNotaCred.getText());
            double base12 = Double.parseDouble(jTextBase12VenNotaCred.getText());
                       
            double iva = Double.parseDouble(jIVA.getText());
            
            double base0 = Double.parseDouble(jTextBase0VenNotaCred.getText());
           
            double total = Double.parseDouble(jValor.getText());
            

            pst.setString(6, jTextNumFacVenNotaCred.getText());
            pst.setDouble(7, base12);
            pst.setDouble(8, iva);
            pst.setDouble(9, base0);
            pst.setDouble(10, total);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Los datos han sido ingresados satisfactoriamente ");
            coneccion.cerrarConexion();
            ////////////BORRADO DE CAMPOS////////////////
            DeclaracionesVentasFacturaReg nueva = new DeclaracionesVentasFacturaReg();
            nueva.setVisible(true);
            this.setVisible(false);
  
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Algo ha fallado intenta de nuevo");
            Logger.getLogger(ContribuyentesRegistro.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_jButRegFactVenNotaCredActionPerformed

    private void cmbTipoCompraVenpNotaCredActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbTipoCompraVenpNotaCredActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbTipoCompraVenpNotaCredActionPerformed

    private void jTextFechVenNotaCredKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFechVenNotaCredKeyTyped
        // TODO add your handling code here:
        
        validar.tamanoCam(jTextFechVenNotaCred, 10, evt);
        validar.fechaSlash(jTextFechVenNotaCred, evt);
    }//GEN-LAST:event_jTextFechVenNotaCredKeyTyped

    private void jTextFechVenNotaCredKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFechVenNotaCredKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()== KeyEvent.VK_ENTER)
            { 
                if(jTextFechVenNotaCred.getText().length()!=0){
                    try {
                        if((fecha.esValidaFecha(jTextFechVenNotaCred.getText())==true)){
                            jTextRucVenNotaCred.setEnabled(true);
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
    }//GEN-LAST:event_jTextFechVenNotaCredKeyPressed

    private void jTextRucVenNotaCredKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextRucVenNotaCredKeyTyped
        // TODO add your handling code here:
        
         validar.soloDigitos(jTextRucVenNotaCred, evt);
        validar.tamanoCam(jTextRucVenNotaCred,13 , evt);
    }//GEN-LAST:event_jTextRucVenNotaCredKeyTyped

    private void jTextRucVenNotaCredKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextRucVenNotaCredKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()== KeyEvent.VK_ENTER)
            { 
                if(jTextRucVenNotaCred.getText().length()==13)
                {   
                        ValidacionPersonaNaturalesRUC validar = new ValidacionPersonaNaturalesRUC();

                        if((validar.personaNaturalRUC(jTextRucVenNotaCred.getText())==true))
                            
                        {
                            if((DeclaracionesInicio.tomarRUCDECLARACIONES.equals(jTextRucVenNotaCred.getText()))==false)
                            {
                                cmbTipoCompraVenpNotaCred.setEnabled(true);
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
    }//GEN-LAST:event_jTextRucVenNotaCredKeyPressed

    private void jTextRazSocVenNotaCredKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextRazSocVenNotaCredKeyTyped
        // TODO add your handling code here:
        validar.soloLetras(jTextRazSocVenNotaCred, evt);
        validar.tamanoCam(jTextRazSocVenNotaCred, 130, evt);
    }//GEN-LAST:event_jTextRazSocVenNotaCredKeyTyped

    private void jTextRazSocVenNotaCredKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextRazSocVenNotaCredKeyPressed
        // TODO add your handling code here:
        if(jTextRazSocVenNotaCred.getText().length()!=0){
           
            if(evt.getKeyCode()== KeyEvent.VK_ENTER)
                { 
                    jTextNumFacVenNotaCred.setEnabled(true);
                }
        }
    }//GEN-LAST:event_jTextRazSocVenNotaCredKeyPressed

    private void jTextNumFacVenNotaCredKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextNumFacVenNotaCredKeyTyped
        // TODO add your handling code here:
            validar.soloDigitos(jTextNumFacVenNotaCred, evt);
        validar.tamanoCam(jTextNumFacVenNotaCred, 15, evt);
    }//GEN-LAST:event_jTextNumFacVenNotaCredKeyTyped

    private void jTextNumFacVenNotaCredKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextNumFacVenNotaCredKeyPressed
        // TODO add your handling code here:
          if(evt.getKeyCode()== KeyEvent.VK_ENTER){
         if(jTextNumFacVenNotaCred.getText().length()!=0)
                { 
             try {
                 if(numeroUnicoNotaCredito()==true) {
                     jTextBase12VenNotaCred.setEnabled(true); 
                 }
             } catch (SQLException ex) {
                 Logger.getLogger(DeclaracionesComprasFacturaReg.class.getName()).log(Level.SEVERE, null, ex);
             }
                        
                }
        }
    }//GEN-LAST:event_jTextNumFacVenNotaCredKeyPressed

    private void jTextBase12VenNotaCredKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextBase12VenNotaCredKeyTyped
        // TODO add your handling code here:
        validar.valoresDEcimales(jTextBase12VenNotaCred, evt);
    }//GEN-LAST:event_jTextBase12VenNotaCredKeyTyped

    private void jTextBase12VenNotaCredKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextBase12VenNotaCredKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()== KeyEvent.VK_ENTER){
         if(jTextBase12VenNotaCred.getText().length()!=0)
                { 
                      if(validar.validarDecimal(jTextBase12VenNotaCred.getText())==true)
                      {
                          String caclIVA= jTextBase12VenNotaCred.getText();
                          jTextBase0VenNotaCred.setEnabled(true);
                          jIVA.setText(calcularIVA(caclIVA));
                      }
                }
        }
    }//GEN-LAST:event_jTextBase12VenNotaCredKeyPressed

    private void jTextBase0VenNotaCredKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextBase0VenNotaCredKeyTyped
        // TODO add your handling code here:
        validar.valoresDEcimales(jTextBase0VenNotaCred, evt);
    }//GEN-LAST:event_jTextBase0VenNotaCredKeyTyped

    private void jTextBase0VenNotaCredKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextBase0VenNotaCredKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()== KeyEvent.VK_ENTER){
         if(jTextBase0VenNotaCred.getText().length()!=0)
                { 
                      if(validar.validarDecimal(jTextBase0VenNotaCred.getText())==true)
                      {
                          String base0 = jTextBase0VenNotaCred.getText();
                          String base12=jTextBase12VenNotaCred.getText();
                          jValor.setText(calcularValorTotal(base0,base12));
                          jButRegFactVenNotaCred.setEnabled(true);
                      }
                }
        }
    }//GEN-LAST:event_jTextBase0VenNotaCredKeyPressed

    private void cmbTipoCompraVenpNotaCredItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbTipoCompraVenpNotaCredItemStateChanged
        // TODO add your handling code here:
         if(cmbTipoCompraVenpNotaCred.getSelectedIndex()!=0)
        {
            jTextRazSocVenNotaCred.setEnabled(true);
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Debe seleccionar algún tipo de compra");
        }
    }//GEN-LAST:event_cmbTipoCompraVenpNotaCredItemStateChanged

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
            java.util.logging.Logger.getLogger(DeclaracionesVentasNotaCreditoReg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DeclaracionesVentasNotaCreditoReg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DeclaracionesVentasNotaCreditoReg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DeclaracionesVentasNotaCreditoReg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new DeclaracionesVentasNotaCreditoReg().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelVerTodos;
    private javax.swing.JComboBox<String> cmbTipoCompraVenpNotaCred;
    private javax.swing.JButton jBCerrarSesion;
    private javax.swing.JButton jButClientes;
    private javax.swing.JButton jButCompras;
    private javax.swing.JButton jButRegFactVenNotaCred;
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
    private javax.swing.JTextField jTextBase0VenNotaCred;
    private javax.swing.JTextField jTextBase12VenNotaCred;
    private javax.swing.JTextField jTextFechVenNotaCred;
    private javax.swing.JTextField jTextNumFacVenNotaCred;
    private javax.swing.JTextField jTextRazSocVenNotaCred;
    private javax.swing.JTextField jTextRucVenNotaCred;
    private javax.swing.JLabel jValor;
    // End of variables declaration//GEN-END:variables
}
