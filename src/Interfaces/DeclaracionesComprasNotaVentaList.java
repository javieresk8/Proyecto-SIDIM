/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Conexiones.ConexionSQL;
import static Interfaces.DeclaracionesComprasFacturaList.manadarIDfactura;
import static Interfaces.DeclaracionesComprasFacturaList.mandarRUC;
import InterfacesAdministración.AsisInicio;
import InterfacesAdministración.InicioAdminUsuarios;
import InterfacesAdministración.Login;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.YES_OPTION;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Bryan
 */
public class DeclaracionesComprasNotaVentaList extends javax.swing.JFrame {
    
        public static String mandarRUC;
    public static String manadarIDnotaVenta;
        ConexionSQL coneccion = new ConexionSQL();

    /**
     * Creates new form ContribuyentesPrincipal
     */
    public DeclaracionesComprasNotaVentaList() {
        initComponents();
        rsscalelabel.RSScaleLabel.setScaleLabel(jLSidimLogo, "src/Iconos/LogoSidim3670ab.png");
        jPaCerrarSesion.setVisible(false);
        this.setSize(1366, 768);
        TextPrompt fechPlHol= new TextPrompt("Buscar por número de nota de venta...", jTextBuscarFacturaComp);
       
       jPanOpcFacturas.setVisible(false);
       jPanOpcNotasCredito.setVisible(false);
       jPanOpcNotasVenta.setVisible(false);
       jPaOpcionesCompFact.setVisible(false);
       
         try {
                CargarDatos();
            } catch (SQLException ex) {
                Logger.getLogger(DeclaracionesComprasFacturaList.class.getName()).log(Level.SEVERE, null, ex);
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
    
    public void CargarDatos() throws SQLException{
         coneccion.hacerConexion();
        DefaultTableModel modelo = (DefaultTableModel) jTabContribuyentes.getModel();
        modelo.setRowCount(0);
        String idContribuyente = obtenerIdContribuyente();
       
        String query = "select * from NotaVenta where idContribuyente ='"+idContribuyente+"'";
        ResultSet respuesta= coneccion.getSentencia().executeQuery(query);
        try{
           
            while(respuesta.next()){
                Vector v = new Vector();
                v.add(respuesta.getString(3));
                v.add(respuesta.getString(4));
                v.add(respuesta.getString(5));
                v.add(respuesta.getString(6));
                v.add(respuesta.getString(7));
                v.add(respuesta.getString(8));
                modelo.addRow(v);
                jTabContribuyentes.setModel(modelo);
               
            }
            coneccion.cerrarConexion();
        }
        catch(SQLException e){
            
        }
    }  
    
      
       public void EliminarNotaVenta() throws SQLException{
           String idContribuyente = obtenerIdContribuyente();
           String idNotaVenta = tomarIDnotaVenta();
            coneccion.hacerConexion();    
            Statement st = coneccion.conexion.createStatement();
           
            String query = "delete from FacturaCompras where idFacturaComp='"+idNotaVenta+"' and idContribuyente='"+idContribuyente+"'";
            System.out.println(query);
            st.execute(query);  
            JOptionPane.showMessageDialog(null, "Se ha eliminado la nota de venta exitosamente");
            CargarDatos();
    }
    
     public String tomarRUC()
    {
        DefaultTableModel modelo = (DefaultTableModel) jTabContribuyentes.getModel();
        String  editarRUC= (String)modelo.getValueAt(jTabContribuyentes.getSelectedRow(),4); 
        return editarRUC;
    }
     
     public String tomarIDnotaVenta() throws SQLException       
    {
        String idNotaVenta = null; 
       String idContribuyente = obtenerIdContribuyente();
       DefaultTableModel modelo = (DefaultTableModel) jTabContribuyentes.getModel();
       String  editarRUC= (String)modelo.getValueAt(jTabContribuyentes.getSelectedRow(),4); 
       //JOptionPane.showMessageDialog(null, "Metodo tomar id "+editarRUC);
       String query = "SELECT * from NotaVenta where numeroNotaVenta='"+editarRUC+"' and idContribuyente='"+idContribuyente+"'"; 
       try
        {
        coneccion.hacerConexion();
         PreparedStatement   pst = coneccion.conexion.prepareStatement(query);                         
         ResultSet   rs = pst.executeQuery();
            while(rs.next())
            {
                idNotaVenta=rs.getString("idNotaVenta");
                //JOptionPane.showMessageDialog(null,"Este es id nota de veta "+ idNotaVenta);
            }                      
        }
        catch(SQLException e)
        {
            
            JOptionPane.showMessageDialog(null,"Error al conectar. "+e.getMessage());
        }
        return idNotaVenta;
        
        
        
    }
     
     
     
       ////////////BUSQUEDA
       public DefaultTableModel busqueda(String buscar) throws SQLException
    {
        String idContribuyente = obtenerIdContribuyente();
        String []  nombresColumnas = {"Fecha","RUC ","Razón Social","Tipo de Compra","Número nota de venta","Total"};
        DefaultTableModel modelo = new DefaultTableModel(null,nombresColumnas);
        String query = "SELECT * FROM NotaVenta WHERE numeroNotaVenta LIKE '%"+buscar+"%'and idContribuyente='"+idContribuyente+"'"; 
        String [] registros = new String[9];
        try
        {
        coneccion.hacerConexion();
         PreparedStatement   pst = coneccion.conexion.prepareStatement(query);                         
         ResultSet   rs = pst.executeQuery();
            while(rs.next())
            {
                
                registros[0] = rs.getString("fecha");
                registros[1] = rs.getString("ruc");
                registros[2] = rs.getString("razonSocial");
                registros[3] = rs.getString("tipoCompra");
                registros[4] = rs.getString("numeroNotaVenta");
                registros[5] = rs.getString("total");

                modelo.addRow(registros);                
            }                      
        }
        catch(SQLException e)
        {
            
            JOptionPane.showMessageDialog(null,"Error al conectar. "+e.getMessage());
        }
        
         return modelo;
    }    
     
    public void buscarNotaVenta(String buscar) throws SQLException
    {
        DefaultTableModel modelo = busqueda(buscar);
      
        jTabContribuyentes.setModel(modelo);
        
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jTabContribuyentes = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jTextBuscarFacturaComp = new javax.swing.JTextField();
        jPaOpcionesCompFact = new javax.swing.JPanel();
        jButton5 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();

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
        jLabel4.setText("Lista de Notas de Venta.");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(163, 164, 166));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Aquí encuentra todas las Notas de Venta registradas.");

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

        jTabContribuyentes.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTabContribuyentes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Fecha", "RUC", "Razón Social", "Tipo de Compra", "Número de Nota de Venta", "TOTAL"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Object.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTabContribuyentes.setGridColor(new java.awt.Color(204, 204, 204));
        jTabContribuyentes.setPreferredSize(new java.awt.Dimension(700, 700));
        jTabContribuyentes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabContribuyentesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTabContribuyentes);

        javax.swing.GroupLayout PanelVerTodosLayout = new javax.swing.GroupLayout(PanelVerTodos);
        PanelVerTodos.setLayout(PanelVerTodosLayout);
        PanelVerTodosLayout.setHorizontalGroup(
            PanelVerTodosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelVerTodosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1032, Short.MAX_VALUE)
                .addContainerGap())
        );
        PanelVerTodosLayout.setVerticalGroup(
            PanelVerTodosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelVerTodosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/iconFind32x32.png"))); // NOI18N

        jTextBuscarFacturaComp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextBuscarFacturaCompActionPerformed(evt);
            }
        });
        jTextBuscarFacturaComp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextBuscarFacturaCompKeyReleased(evt);
            }
        });

        jButton5.setBackground(new java.awt.Color(217, 0, 27));
        jButton5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton5.setForeground(new java.awt.Color(240, 240, 241));
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/iconClose32x32.png"))); // NOI18N
        jButton5.setText("Eliminar");
        jButton5.setBorderPainted(false);
        jButton5.setFocusPainted(false);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton7.setBackground(new java.awt.Color(38, 112, 171));
        jButton7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton7.setForeground(new java.awt.Color(240, 240, 241));
        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/iconEdit32x32.png"))); // NOI18N
        jButton7.setText("Editar");
        jButton7.setBorderPainted(false);
        jButton7.setFocusPainted(false);
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPaOpcionesCompFactLayout = new javax.swing.GroupLayout(jPaOpcionesCompFact);
        jPaOpcionesCompFact.setLayout(jPaOpcionesCompFactLayout);
        jPaOpcionesCompFactLayout.setHorizontalGroup(
            jPaOpcionesCompFactLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPaOpcionesCompFactLayout.createSequentialGroup()
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(131, 131, 131)
                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPaOpcionesCompFactLayout.setVerticalGroup(
            jPaOpcionesCompFactLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPaOpcionesCompFactLayout.createSequentialGroup()
                .addGroup(jPaOpcionesCompFactLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton5)
                    .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 52, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPMod, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jTextBuscarFacturaComp, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel6))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel4)
                                .addComponent(PanelVerTodos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPaCerrarSesion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPaOpcionesCompFact, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
            .addComponent(jPEncabezado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPEncabezado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPaCerrarSesion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(2, 2, 2)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextBuscarFacturaComp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jLabel6))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(PanelVerTodos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPaOpcionesCompFact, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jPMod, javax.swing.GroupLayout.PREFERRED_SIZE, 655, javax.swing.GroupLayout.PREFERRED_SIZE))))
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
         DeclaracionesComprasNotaCreditoReg registro = new DeclaracionesComprasNotaCreditoReg();
        registro.setVisible(true);
        this.setVisible(false);
        
    }//GEN-LAST:event_jButRegNotasCreditoActionPerformed

    private void jTabContribuyentesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabContribuyentesMouseClicked
        // TODO add your handling code here:

        jPaOpcionesCompFact.setVisible(true);
    }//GEN-LAST:event_jTabContribuyentesMouseClicked

    private void jTextBuscarFacturaCompActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextBuscarFacturaCompActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextBuscarFacturaCompActionPerformed

    private void jTextBuscarFacturaCompKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextBuscarFacturaCompKeyReleased
            try {
                // TODO add your handling code here:
                buscarNotaVenta(jTextBuscarFacturaComp.getText());
            } catch (SQLException ex) {
                Logger.getLogger(DeclaracionesComprasNotaVentaList.class.getName()).log(Level.SEVERE, null, ex);
            }
    }//GEN-LAST:event_jTextBuscarFacturaCompKeyReleased

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
   

        
    if( JOptionPane.showConfirmDialog(null, "<html>¿Esta seguro que desea Eliminar esta Nota de Venta? "
            + "<br> Esta acción no se puede deshacer</html>","Eliminar Nota de Venta de Compras",JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE)==YES_OPTION){
            try {
                EliminarNotaVenta();
                
            } catch (SQLException ex) {
                Logger.getLogger(ContribuyentesVerTodo.class.getName()).log(Level.SEVERE, null, ex);
            }
            jPaOpcionesCompFact.setVisible(false);
       }
      else
      {
          jPaOpcionesCompFact.setVisible(false);
      }
        
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        try {
         manadarIDnotaVenta=tomarIDnotaVenta();
         mandarRUC = tomarRUC();
        DeclaracionesComprasNotaVentaEdit listar = new DeclaracionesComprasNotaVentaEdit();
        listar.setVisible(true);
        this.setVisible(false);
        } catch (SQLException ex) {
            Logger.getLogger(DeclaracionesComprasFacturaList.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
       
    }//GEN-LAST:event_jButton7ActionPerformed

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
            java.util.logging.Logger.getLogger(DeclaracionesComprasNotaVentaList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DeclaracionesComprasNotaVentaList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DeclaracionesComprasNotaVentaList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DeclaracionesComprasNotaVentaList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DeclaracionesComprasNotaVentaList().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelVerTodos;
    private javax.swing.JButton jBCerrarSesion;
    private javax.swing.JButton jButClientes;
    private javax.swing.JButton jButCompras;
    private javax.swing.JButton jButRegFactura;
    private javax.swing.JButton jButRegNotasCredito;
    private javax.swing.JButton jButRegNotasVenta;
    private javax.swing.JButton jButVerTodFactura;
    private javax.swing.JButton jButVerTodNotasCredito;
    private javax.swing.JButton jButVerTodNotasVenta;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButventas;
    private javax.swing.JLabel jLSidimLogo;
    private javax.swing.JLabel jLabNombreContribuyente;
    private javax.swing.JLabel jLabNombreContribuyente1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPEncabezado;
    private javax.swing.JPanel jPMod;
    private javax.swing.JPanel jPaCerrarSesion;
    private javax.swing.JPanel jPaOpcionesCompFact;
    private javax.swing.JPanel jPanOpcFacturas;
    private javax.swing.JPanel jPanOpcNotasCredito;
    private javax.swing.JPanel jPanOpcNotasVenta;
    private javax.swing.JPanel jPanOpcionesDeclaracion;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTabContribuyentes;
    private javax.swing.JTextField jTextBuscarFacturaComp;
    // End of variables declaration//GEN-END:variables
}
