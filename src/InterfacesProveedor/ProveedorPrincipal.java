/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfacesProveedor;

import InterfacesAdministración.AsisInicio;
import InterfacesAdministración.InicioAdminUsuarios;
import InterfacesAdministración.Login;



/**
 *
 * @author Bryan
 */
public class ProveedorPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form ContribuyentesPrincipal
     */
    public ProveedorPrincipal() {
        initComponents();
        panelDocumentos6.setVisible(false);
        jPaCerrarSesion.setVisible(false);
        this.setSize(1366, 768);
    }
boolean bandera = false ;
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
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPaCerrarSesion = new javax.swing.JPanel();
        jBCerrarSesion = new javax.swing.JButton();
        jPMod = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        btnSalirProveedor = new javax.swing.JButton();
        btnRegistrarProveedor = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnListarProveedor = new javax.swing.JButton();
        btnConsultasProveedor = new javax.swing.JButton();
        panelDocumentos6 = new javax.swing.JPanel();
        btnNotaCredito6 = new javax.swing.JButton();
        btnFacturas6 = new javax.swing.JButton();
        btnNotaVenta6 = new javax.swing.JButton();

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

        jLSidimLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IconosProveedor/Logo.jpeg"))); // NOI18N

        javax.swing.GroupLayout jPEncabezadoLayout = new javax.swing.GroupLayout(jPEncabezado);
        jPEncabezado.setLayout(jPEncabezadoLayout);
        jPEncabezadoLayout.setHorizontalGroup(
            jPEncabezadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPEncabezadoLayout.createSequentialGroup()
                .addComponent(jLSidimLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 1033, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPEncabezadoLayout.setVerticalGroup(
            jPEncabezadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLSidimLogo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 35)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(38, 35, 36));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Registro Proveedor");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(163, 164, 166));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Gestiona aquí tus proveedores.");

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

        jPMod.setBackground(new java.awt.Color(51, 51, 51));
        jPMod.setForeground(new java.awt.Color(51, 51, 51));
        jPMod.setMaximumSize(new java.awt.Dimension(300, 200));
        jPMod.setPreferredSize(new java.awt.Dimension(300, 280));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(240, 240, 241));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Proveedores");

        btnSalirProveedor.setBackground(new java.awt.Color(38, 35, 36));
        btnSalirProveedor.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnSalirProveedor.setForeground(new java.awt.Color(240, 240, 241));
        btnSalirProveedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/iconBack48x48.png"))); // NOI18N
        btnSalirProveedor.setText("Volver");
        btnSalirProveedor.setBorderPainted(false);
        btnSalirProveedor.setFocusPainted(false);
        btnSalirProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirProveedorActionPerformed(evt);
            }
        });

        btnRegistrarProveedor.setBackground(new java.awt.Color(38, 35, 36));
        btnRegistrarProveedor.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnRegistrarProveedor.setForeground(new java.awt.Color(240, 240, 241));
        btnRegistrarProveedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/iconAdd32x32.png"))); // NOI18N
        btnRegistrarProveedor.setText("Registrar");
        btnRegistrarProveedor.setBorderPainted(false);
        btnRegistrarProveedor.setFocusPainted(false);
        btnRegistrarProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarProveedorActionPerformed(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/iconUser48x48.png"))); // NOI18N

        btnListarProveedor.setBackground(new java.awt.Color(38, 35, 36));
        btnListarProveedor.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnListarProveedor.setForeground(new java.awt.Color(240, 240, 241));
        btnListarProveedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/iconList32x32.png"))); // NOI18N
        btnListarProveedor.setText("Ver Todos");
        btnListarProveedor.setBorderPainted(false);
        btnListarProveedor.setFocusPainted(false);
        btnListarProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListarProveedorActionPerformed(evt);
            }
        });

        btnConsultasProveedor.setBackground(new java.awt.Color(38, 35, 36));
        btnConsultasProveedor.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnConsultasProveedor.setForeground(new java.awt.Color(240, 240, 241));
        btnConsultasProveedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IconosProveedor/Consulta1.png"))); // NOI18N
        btnConsultasProveedor.setText("Consultar Documentos");
        btnConsultasProveedor.setBorderPainted(false);
        btnConsultasProveedor.setFocusPainted(false);
        btnConsultasProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultasProveedorActionPerformed(evt);
            }
        });

        panelDocumentos6.setBackground(new java.awt.Color(51, 51, 51));

        btnNotaCredito6.setBackground(new java.awt.Color(38, 35, 36));
        btnNotaCredito6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnNotaCredito6.setForeground(new java.awt.Color(240, 240, 241));
        btnNotaCredito6.setText("Notas de Credito");
        btnNotaCredito6.setBorderPainted(false);
        btnNotaCredito6.setFocusPainted(false);
        btnNotaCredito6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNotaCredito6ActionPerformed(evt);
            }
        });

        btnFacturas6.setBackground(new java.awt.Color(38, 35, 36));
        btnFacturas6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnFacturas6.setForeground(new java.awt.Color(240, 240, 241));
        btnFacturas6.setText("Facturas");
        btnFacturas6.setBorderPainted(false);
        btnFacturas6.setFocusPainted(false);
        btnFacturas6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFacturas6ActionPerformed(evt);
            }
        });

        btnNotaVenta6.setBackground(new java.awt.Color(38, 35, 36));
        btnNotaVenta6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnNotaVenta6.setForeground(new java.awt.Color(240, 240, 241));
        btnNotaVenta6.setText("Notas de Venta");
        btnNotaVenta6.setBorderPainted(false);
        btnNotaVenta6.setFocusPainted(false);
        btnNotaVenta6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNotaVenta6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelDocumentos6Layout = new javax.swing.GroupLayout(panelDocumentos6);
        panelDocumentos6.setLayout(panelDocumentos6Layout);
        panelDocumentos6Layout.setHorizontalGroup(
            panelDocumentos6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDocumentos6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelDocumentos6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelDocumentos6Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnNotaVenta6, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelDocumentos6Layout.createSequentialGroup()
                        .addGroup(panelDocumentos6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnFacturas6, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnNotaCredito6, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panelDocumentos6Layout.setVerticalGroup(
            panelDocumentos6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDocumentos6Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(btnFacturas6, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnNotaVenta6, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnNotaCredito6, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPModLayout = new javax.swing.GroupLayout(jPMod);
        jPMod.setLayout(jPModLayout);
        jPModLayout.setHorizontalGroup(
            jPModLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnRegistrarProveedor, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnListarProveedor, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPModLayout.createSequentialGroup()
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addGap(10, 10, 10))
            .addComponent(btnSalirProveedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnConsultasProveedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panelDocumentos6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPModLayout.setVerticalGroup(
            jPModLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPModLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPModLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnRegistrarProveedor)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnListarProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnConsultasProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelDocumentos6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSalirProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addComponent(jPMod, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 618, Short.MAX_VALUE)
                .addComponent(jPaCerrarSesion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jPEncabezado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPEncabezado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(2, 2, 2)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPaCerrarSesion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 761, Short.MAX_VALUE))
                    .addComponent(jPMod, javax.swing.GroupLayout.DEFAULT_SIZE, 844, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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

    private void btnSalirProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirProveedorActionPerformed
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
    }//GEN-LAST:event_btnSalirProveedorActionPerformed

    private void btnRegistrarProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarProveedorActionPerformed
        ProveedorRegistrar registrar = new ProveedorRegistrar();
        registrar.setVisible(true);
        this.setVisible(false);

    }//GEN-LAST:event_btnRegistrarProveedorActionPerformed

    private void btnListarProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListarProveedorActionPerformed
        ProveedoresListar listaProveedor = new ProveedoresListar();
        listaProveedor.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnListarProveedorActionPerformed

    private void btnConsultasProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultasProveedorActionPerformed
    
    if (bandera ==false){
        panelDocumentos6.setVisible(true);
        bandera = true;
    }
    
    else{
         panelDocumentos6.setVisible(false);
        bandera = false;
    }
    }//GEN-LAST:event_btnConsultasProveedorActionPerformed

    private void btnNotaCredito6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNotaCredito6ActionPerformed
        InicioAdministra credito = new InicioAdministra();
        credito.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnNotaCredito6ActionPerformed

    private void btnFacturas6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFacturas6ActionPerformed
         ConsultasFacturas facturas = new ConsultasFacturas();
        facturas.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnFacturas6ActionPerformed

    private void btnNotaVenta6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNotaVenta6ActionPerformed
        ConsultarNotasVenta notasVenta = new ConsultarNotasVenta();
        notasVenta.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnNotaVenta6ActionPerformed

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
            java.util.logging.Logger.getLogger(ProveedorPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ProveedorPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ProveedorPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ProveedorPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ProveedorPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConsultasProveedor;
    private javax.swing.JButton btnFacturas;
    private javax.swing.JButton btnFacturas1;
    private javax.swing.JButton btnFacturas2;
    private javax.swing.JButton btnFacturas3;
    private javax.swing.JButton btnFacturas4;
    private javax.swing.JButton btnFacturas5;
    private javax.swing.JButton btnFacturas6;
    private javax.swing.JButton btnListarProveedor;
    private javax.swing.JButton btnNotaCredito;
    private javax.swing.JButton btnNotaCredito1;
    private javax.swing.JButton btnNotaCredito2;
    private javax.swing.JButton btnNotaCredito3;
    private javax.swing.JButton btnNotaCredito4;
    private javax.swing.JButton btnNotaCredito5;
    private javax.swing.JButton btnNotaCredito6;
    private javax.swing.JButton btnNotaVenta;
    private javax.swing.JButton btnNotaVenta1;
    private javax.swing.JButton btnNotaVenta2;
    private javax.swing.JButton btnNotaVenta3;
    private javax.swing.JButton btnNotaVenta4;
    private javax.swing.JButton btnNotaVenta5;
    private javax.swing.JButton btnNotaVenta6;
    private javax.swing.JButton btnRegistrarProveedor;
    private javax.swing.JButton btnSalirProveedor;
    private javax.swing.JButton jBCerrarSesion;
    private javax.swing.JLabel jLSidimLogo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPEncabezado;
    private javax.swing.JPanel jPMod;
    private javax.swing.JPanel jPaCerrarSesion;
    private javax.swing.JPanel panelDocumentos;
    private javax.swing.JPanel panelDocumentos1;
    private javax.swing.JPanel panelDocumentos2;
    private javax.swing.JPanel panelDocumentos3;
    private javax.swing.JPanel panelDocumentos4;
    private javax.swing.JPanel panelDocumentos5;
    private javax.swing.JPanel panelDocumentos6;
    // End of variables declaration//GEN-END:variables
}
