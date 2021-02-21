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
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import java.sql.Statement;
import java.sql.*;

/**
 *
 * @author Bryan
 */
public class ContribuyentesRegistro extends javax.swing.JFrame {
   
    validarCampos validar = new validarCampos();
    ConexionSQL coneccion = new ConexionSQL();


    /**
     * Creates new form ContribuyentesPrincipal
     */
    public ContribuyentesRegistro() {
        initComponents();
        rsscalelabel.RSScaleLabel.setScaleLabel(jLSidimLogo, "src/Iconos/LogoSidim3670ab.png");
        jPaCerrarSesion.setVisible(false);
        this.setSize(1366, 768);
        TextPrompt rucPlHol= new TextPrompt("Ingrese el Ruc del Contribuyente", jTextRucContReg);
        TextPrompt razSocPlHol= new TextPrompt("Razón social del Contrbuyente, nombres y apellidos completos", jTextRazSocContReg);
        TextPrompt numTelPlHol= new TextPrompt("Número telefónico, celular o convencional del Contribuyente", jTextNumTelContReg);
        TextPrompt direcPlHol= new TextPrompt("Dirección del Contribuyente", jTextDirContReg);
        TextPrompt corElecPlHol= new TextPrompt("Teléfono del Contribuyente", jTextCorrElecContReg);
        
        jTextRazSocContReg.setEnabled(false);
        jTextNumTelContReg.setEnabled(false);
        jTextDirContReg.setEnabled(false);
        jTextCorrElecContReg.setEnabled(false);
        jComTipoDeclara.setEnabled(false);
        btnRegistrar.setEnabled(false);
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
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPaCerrarSesion = new javax.swing.JPanel();
        jBCerrarSesion = new javax.swing.JButton();
        PanelVerTodos = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jTextRazSocContReg = new javax.swing.JTextField();
        jTextRucContReg = new javax.swing.JTextField();
        jTextDirContReg = new javax.swing.JTextField();
        jTextNumTelContReg = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jTextCorrElecContReg = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jComTipoDeclara = new javax.swing.JComboBox<>();
        btnRegistrar = new javax.swing.JButton();

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

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 22)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(240, 240, 241));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Contribuyentes");

        jButton1.setBackground(new java.awt.Color(38, 35, 36));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
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

        jButton5.setBackground(new java.awt.Color(38, 35, 36));
        jButton5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton5.setForeground(new java.awt.Color(240, 240, 241));
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/iconAdd32x32.png"))); // NOI18N
        jButton5.setText("Registrar");
        jButton5.setBorderPainted(false);
        jButton5.setFocusPainted(false);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/iconUser48x48.png"))); // NOI18N

        jButton2.setBackground(new java.awt.Color(38, 35, 36));
        jButton2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(240, 240, 241));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/iconList32x32.png"))); // NOI18N
        jButton2.setText("Ver Todos");
        jButton2.setBorderPainted(false);
        jButton2.setFocusPainted(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPModLayout = new javax.swing.GroupLayout(jPMod);
        jPMod.setLayout(jPModLayout);
        jPModLayout.setHorizontalGroup(
            jPModLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jButton5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPModLayout.createSequentialGroup()
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addGap(10, 10, 10))
            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPModLayout.setVerticalGroup(
            jPModLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPModLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPModLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButton5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 372, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50))
        );

        jPModLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jButton1, jButton2, jButton5});

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 35)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(38, 35, 36));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Registro Contribuyente.");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(163, 164, 166));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Llena el formulario para registrar un Contribuyente");

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
        jLabel8.setText("RUC del Contribuyente:");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel9.setText("Razón Social:");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel10.setText("Número Telefónico:");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel11.setText("Dirección:");

        jTextRazSocContReg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextRazSocContRegActionPerformed(evt);
            }
        });
        jTextRazSocContReg.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextRazSocContRegKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextRazSocContRegKeyTyped(evt);
            }
        });

        jTextRucContReg.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextRucContRegFocusGained(evt);
            }
        });
        jTextRucContReg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextRucContRegActionPerformed(evt);
            }
        });
        jTextRucContReg.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextRucContRegKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextRucContRegKeyTyped(evt);
            }
        });

        jTextDirContReg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextDirContRegActionPerformed(evt);
            }
        });
        jTextDirContReg.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextDirContRegKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextDirContRegKeyTyped(evt);
            }
        });

        jTextNumTelContReg.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextNumTelContRegKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextNumTelContRegKeyTyped(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel12.setText("Tipo de Declaración:");

        jTextCorrElecContReg.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextCorrElecContRegKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextCorrElecContRegKeyTyped(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel13.setText("Correo Electrónico:");

        jComTipoDeclara.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jComTipoDeclara.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mensual", "Semestral" }));
        jComTipoDeclara.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComTipoDeclaraActionPerformed(evt);
            }
        });

        btnRegistrar.setBackground(new java.awt.Color(38, 112, 171));
        btnRegistrar.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnRegistrar.setForeground(new java.awt.Color(240, 240, 241));
        btnRegistrar.setText("Registrar");
        btnRegistrar.setBorderPainted(false);
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelVerTodosLayout = new javax.swing.GroupLayout(PanelVerTodos);
        PanelVerTodos.setLayout(PanelVerTodosLayout);
        PanelVerTodosLayout.setHorizontalGroup(
            PanelVerTodosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelVerTodosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelVerTodosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelVerTodosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel8)
                        .addComponent(jLabel9)
                        .addComponent(jLabel10)
                        .addComponent(jLabel11)
                        .addComponent(jLabel13)
                        .addComponent(jTextRucContReg, javax.swing.GroupLayout.DEFAULT_SIZE, 850, Short.MAX_VALUE)
                        .addComponent(jTextRazSocContReg)
                        .addComponent(jTextNumTelContReg)
                        .addComponent(jTextDirContReg)
                        .addComponent(jTextCorrElecContReg))
                    .addGroup(PanelVerTodosLayout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addGap(59, 59, 59)
                        .addComponent(jComTipoDeclara, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(51, Short.MAX_VALUE))
        );
        PanelVerTodosLayout.setVerticalGroup(
            PanelVerTodosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelVerTodosLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel8)
                .addGap(8, 8, 8)
                .addComponent(jTextRucContReg, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addGap(6, 6, 6)
                .addComponent(jTextRazSocContReg, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10)
                .addGap(6, 6, 6)
                .addComponent(jTextNumTelContReg, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel11)
                .addGap(6, 6, 6)
                .addComponent(jTextDirContReg, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel13)
                .addGap(4, 4, 4)
                .addComponent(jTextCorrElecContReg, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PanelVerTodosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jComTipoDeclara, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnRegistrar)
                .addContainerGap(41, Short.MAX_VALUE))
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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 506, Short.MAX_VALUE)
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
                    .addComponent(jPMod, javax.swing.GroupLayout.PREFERRED_SIZE, 655, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(56, Short.MAX_VALUE))
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

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
    
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        ContribuyentesVerTodo lista = new ContribuyentesVerTodo();
        lista.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton2ActionPerformed

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

    private void jTextRucContRegActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextRucContRegActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextRucContRegActionPerformed

    private void jComTipoDeclaraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComTipoDeclaraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComTipoDeclaraActionPerformed

    private void jTextRazSocContRegActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextRazSocContRegActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextRazSocContRegActionPerformed

    private void jTextDirContRegActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextDirContRegActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextDirContRegActionPerformed

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed

        /////////INGRESODE DATOS A LA BASE////////////
        
        
        String query = "INSERT INTO Contribuyente(ruc, razonSocial, telefono,direccion,correoElectronico, tipoDeclaracionImp, Estado)\n" +
"VALUES (?,?,?,?,?,?,?);";
        try {
            coneccion.hacerConexion();
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
            JOptionPane.showMessageDialog(null, "El Contribuyente fue registrado exitosamente ");
            coneccion.cerrarConexion();
            ////////////BORRADO DE CAMPOS////////////////
            ContribuyentesRegistro nueva = new ContribuyentesRegistro();
            nueva.setVisible(true);
            this.setVisible(false);
  
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Algo ha fallado intenta de nuevo");
            Logger.getLogger(ContribuyentesRegistro.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
        
       

        
        
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void jTextRucContRegKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextRucContRegKeyTyped
        validar.soloDigitos(jTextRucContReg, evt);
        validar.tamanoCam(jTextRucContReg,13 , evt);
         
    }//GEN-LAST:event_jTextRucContRegKeyTyped

    private void jTextRucContRegFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextRucContRegFocusGained
        // TODO add your handling code here:
       
    }//GEN-LAST:event_jTextRucContRegFocusGained

    private void jTextRucContRegKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextRucContRegKeyPressed
            
            if(evt.getKeyCode()== KeyEvent.VK_ENTER)
            { 
                if(jTextRucContReg.getText().length()==13)
                {   
                    ValidacionPersonaNaturalesRUC validar = new ValidacionPersonaNaturalesRUC();

                    if(validar.personaNaturalRUC(jTextRucContReg.getText())==true)
                    {
                        try {
                            coneccion.hacerConexion();
                            String query = "Select * from Contribuyente where ruc = ?  ";
                            PreparedStatement pst = coneccion.conexion.prepareStatement(query);                     
                            pst.setString(1, jTextRucContReg.getText());
                            ResultSet rs = pst.executeQuery();
                            if(rs.next()){
                                JOptionPane.showConfirmDialog(null,"Este RUC ya está registrado, ingrese uno nuevo");
                            }
                            else
                            {
                                jTextRazSocContReg.setEnabled(true);
                            }
                            coneccion.cerrarConexion();
                        } catch (SQLException ex) {
                            Logger.getLogger(ContribuyentesRegistro.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null,"Ingrese un RUC  valido ");
                    }
                 }
                else
                {
                    JOptionPane.showMessageDialog(null,"El RUC consta de 13 números");
                }
            }
    }//GEN-LAST:event_jTextRucContRegKeyPressed

    private void jTextRazSocContRegKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextRazSocContRegKeyTyped
        // TODO add your handling code here:
         validar.soloLetras(jTextRazSocContReg, evt);
        validar.tamanoCam(jTextRazSocContReg, 130, evt);
        
    }//GEN-LAST:event_jTextRazSocContRegKeyTyped

    private void jTextNumTelContRegKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextNumTelContRegKeyTyped
        // TODO add your handling code here:
        validar.tamanoCam(jTextNumTelContReg, 10, evt);
        validar.soloDigitos(jTextDirContReg, evt);
    }//GEN-LAST:event_jTextNumTelContRegKeyTyped

    private void jTextRazSocContRegKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextRazSocContRegKeyPressed
        // TODO add your handling code here:
        if(jTextRazSocContReg.getText().length()!=0){
           
            if(evt.getKeyCode()== KeyEvent.VK_ENTER)
                { 
                    jTextNumTelContReg.setEnabled(true);
                }
        }
        
    }//GEN-LAST:event_jTextRazSocContRegKeyPressed

    private void jTextNumTelContRegKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextNumTelContRegKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()== KeyEvent.VK_ENTER){
         if(jTextNumTelContReg.getText().length()==9 || jTextNumTelContReg.getText().length()==10)
                { 
                    if(validar.validarTelefono(jTextNumTelContReg.getText())==true){
                      jTextDirContReg.setEnabled(true);  
                    }
                }
         else
         {
             JOptionPane.showMessageDialog(null,"El número consta de 9 o 10 digitos");
         }
        }
         
        
    }//GEN-LAST:event_jTextNumTelContRegKeyPressed

    private void jTextDirContRegKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextDirContRegKeyTyped
        // TODO add your handling code here:
        validar.tamanoCam(jTextDirContReg, 120, evt);
        validar.todoMenosEspeciales(jTextDirContReg, evt);
    }//GEN-LAST:event_jTextDirContRegKeyTyped

    private void jTextDirContRegKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextDirContRegKeyPressed

   if(evt.getKeyCode()== KeyEvent.VK_ENTER){
         if(jTextDirContReg.getText().length()!=0)
                { 
                      jTextCorrElecContReg.setEnabled(true);      
                }
        }
    }//GEN-LAST:event_jTextDirContRegKeyPressed

    private void jTextCorrElecContRegKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextCorrElecContRegKeyTyped
        // TODO add your handling code here:
        validar.tamanoCam(jTextCorrElecContReg, 120, evt);
    }//GEN-LAST:event_jTextCorrElecContRegKeyTyped

    private void jTextCorrElecContRegKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextCorrElecContRegKeyPressed
        // TODO add your handling code here:
       if(evt.getKeyCode()== KeyEvent.VK_ENTER){
         if(jTextCorrElecContReg.getText().length()!=0)
                { 
                    if(validar.validacionCorreo(jTextCorrElecContReg.getText())==true){
                      jComTipoDeclara.setEnabled(true);  
                      btnRegistrar.setEnabled(true);
                    }
                }
        }
    }//GEN-LAST:event_jTextCorrElecContRegKeyPressed

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
            java.util.logging.Logger.getLogger(ContribuyentesRegistro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ContribuyentesRegistro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ContribuyentesRegistro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ContribuyentesRegistro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ContribuyentesRegistro().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelVerTodos;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JButton jBCerrarSesion;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton5;
    private javax.swing.JComboBox<String> jComTipoDeclara;
    private javax.swing.JLabel jLSidimLogo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPEncabezado;
    private javax.swing.JPanel jPMod;
    private javax.swing.JPanel jPaCerrarSesion;
    private javax.swing.JTextField jTextCorrElecContReg;
    private javax.swing.JTextField jTextDirContReg;
    private javax.swing.JTextField jTextNumTelContReg;
    private javax.swing.JTextField jTextRazSocContReg;
    private javax.swing.JTextField jTextRucContReg;
    // End of variables declaration//GEN-END:variables
}