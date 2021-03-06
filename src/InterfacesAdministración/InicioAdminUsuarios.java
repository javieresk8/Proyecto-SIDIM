/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfacesAdministración;

import Interfaces.ContribuyentesPrincipal;
import Interfaces.DeclaracionesInicio;
import InterfacesProveedor.TextPrompt;
import InterfacesProveedor.ProveedorPrincipal;
import InterfacesReportes.ReportesPrincipal;




/**
 *
 * @author Bryan
 */
public class InicioAdminUsuarios extends javax.swing.JFrame {

    /**
     * Creates new form ContribuyentesPrincipal
     */

    public InicioAdminUsuarios() {
        initComponents();
        this.setSize(1366, 768);
        jBCerrarSesion.setVisible(false);
        JPOUsuarios.setVisible(false);
        jPRegistrar.setVisible(false);
        

        
        TextPrompt Cedula = new TextPrompt("Cédula del Usuario", txtCedula);
        TextPrompt Nombres = new TextPrompt("Nombres del Usuario", txtNombres);
        TextPrompt Apellidos = new TextPrompt("Apellidos del Usuario", txtApellidos);
        TextPrompt Correo = new TextPrompt("Correo Electrónico del USuario", txtCorreo);
        TextPrompt Usuario = new TextPrompt("Usuario para el ingreso ddel Usuario", txtUsuario);
        TextPrompt Contrasena = new TextPrompt("Contraseña del Usuario", txtContrasena);
        
        
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPEncabezado = new javax.swing.JPanel();
        jLSidimLogo = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPVer = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        btnRegistrarProveedor = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnListarProveedor = new javax.swing.JButton();
        btnConsultasProveedor = new javax.swing.JButton();
        btnConsultasProveedor1 = new javax.swing.JButton();
        btnConsultasProveedor2 = new javax.swing.JButton();
        btnConsultasProveedor3 = new javax.swing.JButton();
        JPOUsuarios = new javax.swing.JPanel();
        btnRegistrar = new javax.swing.JButton();
        btnVerTodos = new javax.swing.JButton();
        jPRegistrar = new javax.swing.JPanel();
        lblCedula = new javax.swing.JLabel();
        txtCedula = new javax.swing.JTextField();
        lblNombres = new javax.swing.JLabel();
        txtNombres = new javax.swing.JTextField();
        lblApellidos = new javax.swing.JLabel();
        txtApellidos = new javax.swing.JTextField();
        lblCorreo = new javax.swing.JLabel();
        txtCorreo = new javax.swing.JTextField();
        lbUsuario = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        lbContraseña = new javax.swing.JLabel();
        txtContrasena = new javax.swing.JTextField();
        lblRol = new javax.swing.JLabel();
        jCBRol = new javax.swing.JComboBox<>();
        lblRucProveedor1 = new javax.swing.JLabel();
        lblRucProveedor2 = new javax.swing.JLabel();
        btnGuardar = new javax.swing.JButton();
        jBCerrarSesion = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPEncabezado.setBackground(new java.awt.Color(54, 112, 171));

        jLSidimLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IconosProveedor/Logo.jpeg"))); // NOI18N

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Hola Luis López");
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPEncabezadoLayout = new javax.swing.GroupLayout(jPEncabezado);
        jPEncabezado.setLayout(jPEncabezadoLayout);
        jPEncabezadoLayout.setHorizontalGroup(
            jPEncabezadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPEncabezadoLayout.createSequentialGroup()
                .addComponent(jLSidimLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 899, Short.MAX_VALUE)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
        );
        jPEncabezadoLayout.setVerticalGroup(
            jPEncabezadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLSidimLogo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPEncabezadoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPVer.setBackground(new java.awt.Color(51, 51, 51));
        jPVer.setForeground(new java.awt.Color(51, 51, 51));
        jPVer.setMaximumSize(new java.awt.Dimension(300, 200));
        jPVer.setPreferredSize(new java.awt.Dimension(300, 280));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(240, 240, 241));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Luis López");

        btnRegistrarProveedor.setBackground(new java.awt.Color(38, 35, 36));
        btnRegistrarProveedor.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnRegistrarProveedor.setForeground(new java.awt.Color(240, 240, 241));
        btnRegistrarProveedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IconosAdmini/Usuarios.png"))); // NOI18N
        btnRegistrarProveedor.setText("Usuarios");
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
        btnListarProveedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IconosAdmini/Usuarios.png"))); // NOI18N
        btnListarProveedor.setText("Contribuyentes");
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
        btnConsultasProveedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IconosAdmini/proveedores.png"))); // NOI18N
        btnConsultasProveedor.setText("Proveedores");
        btnConsultasProveedor.setBorderPainted(false);
        btnConsultasProveedor.setFocusPainted(false);
        btnConsultasProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultasProveedorActionPerformed(evt);
            }
        });

        btnConsultasProveedor1.setBackground(new java.awt.Color(38, 35, 36));
        btnConsultasProveedor1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnConsultasProveedor1.setForeground(new java.awt.Color(240, 240, 241));
        btnConsultasProveedor1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IconosAdmini/AccesosAlSite.png"))); // NOI18N
        btnConsultasProveedor1.setText("Accesos al Sistema");
        btnConsultasProveedor1.setBorderPainted(false);
        btnConsultasProveedor1.setFocusPainted(false);
        btnConsultasProveedor1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultasProveedor1ActionPerformed(evt);
            }
        });

        btnConsultasProveedor2.setBackground(new java.awt.Color(38, 35, 36));
        btnConsultasProveedor2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnConsultasProveedor2.setForeground(new java.awt.Color(240, 240, 241));
        btnConsultasProveedor2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IconosAdmini/reportes.png"))); // NOI18N
        btnConsultasProveedor2.setText("Reportes");
        btnConsultasProveedor2.setBorderPainted(false);
        btnConsultasProveedor2.setFocusPainted(false);
        btnConsultasProveedor2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultasProveedor2ActionPerformed(evt);
            }
        });

        btnConsultasProveedor3.setBackground(new java.awt.Color(38, 35, 36));
        btnConsultasProveedor3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnConsultasProveedor3.setForeground(new java.awt.Color(240, 240, 241));
        btnConsultasProveedor3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IconosAdmini/declaraciones.png"))); // NOI18N
        btnConsultasProveedor3.setText("Declaraciones");
        btnConsultasProveedor3.setBorderPainted(false);
        btnConsultasProveedor3.setFocusPainted(false);
        btnConsultasProveedor3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultasProveedor3ActionPerformed(evt);
            }
        });

        btnRegistrar.setBackground(new java.awt.Color(153, 153, 153));
        btnRegistrar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnRegistrar.setForeground(new java.awt.Color(240, 240, 241));
        btnRegistrar.setText("Registrar");
        btnRegistrar.setBorderPainted(false);
        btnRegistrar.setFocusPainted(false);
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        btnVerTodos.setBackground(new java.awt.Color(153, 153, 153));
        btnVerTodos.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnVerTodos.setForeground(new java.awt.Color(240, 240, 241));
        btnVerTodos.setText("Ver Todos");
        btnVerTodos.setBorderPainted(false);
        btnVerTodos.setFocusPainted(false);
        btnVerTodos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerTodosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout JPOUsuariosLayout = new javax.swing.GroupLayout(JPOUsuarios);
        JPOUsuarios.setLayout(JPOUsuariosLayout);
        JPOUsuariosLayout.setHorizontalGroup(
            JPOUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnRegistrar, javax.swing.GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE)
            .addComponent(btnVerTodos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        JPOUsuariosLayout.setVerticalGroup(
            JPOUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPOUsuariosLayout.createSequentialGroup()
                .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addComponent(btnVerTodos, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jPVerLayout = new javax.swing.GroupLayout(jPVer);
        jPVer.setLayout(jPVerLayout);
        jPVerLayout.setHorizontalGroup(
            jPVerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnRegistrarProveedor, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnListarProveedor, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 234, Short.MAX_VALUE)
            .addComponent(btnConsultasProveedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnConsultasProveedor2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnConsultasProveedor1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnConsultasProveedor3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPVerLayout.createSequentialGroup()
                .addGroup(jPVerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPVerLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(JPOUsuarios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPVerLayout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1)))
                .addContainerGap())
        );
        jPVerLayout.setVerticalGroup(
            jPVerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPVerLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPVerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnRegistrarProveedor)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JPOUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addComponent(btnListarProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnConsultasProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnConsultasProveedor2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnConsultasProveedor1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnConsultasProveedor3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lblCedula.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblCedula.setText("Cédula:");

        txtCedula.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtCedula.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtCedulaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCedulaFocusLost(evt);
            }
        });
        txtCedula.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtCedulaMouseClicked(evt);
            }
        });
        txtCedula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCedulaActionPerformed(evt);
            }
        });

        lblNombres.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblNombres.setText("Nombres:");

        txtNombres.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtNombres.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtNombresFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtNombresFocusLost(evt);
            }
        });

        lblApellidos.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblApellidos.setText("Apellidos:");

        txtApellidos.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtApellidos.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtApellidosFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtApellidosFocusLost(evt);
            }
        });

        lblCorreo.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblCorreo.setText("Correo Electrónico:");

        txtCorreo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtCorreo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtCorreoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCorreoFocusLost(evt);
            }
        });

        lbUsuario.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbUsuario.setText("Usuarios para ingreso al sistema:");

        txtUsuario.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtUsuario.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtUsuarioFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtUsuarioFocusLost(evt);
            }
        });

        lbContraseña.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbContraseña.setText("Contraseña:");

        txtContrasena.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtContrasena.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtContrasenaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtContrasenaFocusLost(evt);
            }
        });

        lblRol.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblRol.setText("Rol del Usuario:");

        jCBRol.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Administrador", "Asistente Contable" }));
        jCBRol.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jCBRolMouseClicked(evt);
            }
        });
        jCBRol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBRolActionPerformed(evt);
            }
        });

        lblRucProveedor1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblRucProveedor1.setText("Registro de Usuario:");

        lblRucProveedor2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblRucProveedor2.setText("Llene el formulario para registrar un Usuario del sistema:");

        btnGuardar.setBackground(new java.awt.Color(38, 35, 36));
        btnGuardar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnGuardar.setForeground(new java.awt.Color(240, 240, 241));
        btnGuardar.setText("Registrar");
        btnGuardar.setBorderPainted(false);
        btnGuardar.setFocusPainted(false);
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPRegistrarLayout = new javax.swing.GroupLayout(jPRegistrar);
        jPRegistrar.setLayout(jPRegistrarLayout);
        jPRegistrarLayout.setHorizontalGroup(
            jPRegistrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPRegistrarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPRegistrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPRegistrarLayout.createSequentialGroup()
                        .addGroup(jPRegistrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblCorreo)
                            .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 757, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 757, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbContraseña)
                            .addComponent(txtContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, 757, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbUsuario)
                            .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 757, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblRol)
                            .addGroup(jPRegistrarLayout.createSequentialGroup()
                                .addComponent(jCBRol, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(118, 118, 118)
                                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lblNombres)
                            .addComponent(lblApellidos)
                            .addComponent(txtNombres, javax.swing.GroupLayout.PREFERRED_SIZE, 757, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, 757, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(27, Short.MAX_VALUE))
                    .addGroup(jPRegistrarLayout.createSequentialGroup()
                        .addGroup(jPRegistrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblRucProveedor1)
                            .addComponent(lblRucProveedor2)
                            .addComponent(lblCedula))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPRegistrarLayout.setVerticalGroup(
            jPRegistrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPRegistrarLayout.createSequentialGroup()
                .addComponent(lblRucProveedor1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblRucProveedor2)
                .addGap(18, 18, 18)
                .addComponent(lblCedula)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblNombres)
                .addGap(9, 9, 9)
                .addComponent(txtNombres, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblApellidos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblCorreo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbUsuario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbContraseña)
                .addGap(24, 24, 24)
                .addComponent(txtContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(lblRol)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPRegistrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCBRol, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGuardar))
                .addGap(1441, 1441, 1441))
        );

        jBCerrarSesion.setBackground(new java.awt.Color(0, 153, 51));
        jBCerrarSesion.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jBCerrarSesion.setForeground(new java.awt.Color(240, 240, 241));
        jBCerrarSesion.setText("Cerrar Sesión");
        jBCerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBCerrarSesionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPEncabezado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPVer, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(896, 896, 896)
                                .addComponent(jBCerrarSesion)))))
                .addContainerGap(889, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPEncabezado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jBCerrarSesion)
                        .addGap(3, 3, 3)
                        .addComponent(jPRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 601, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPVer, javax.swing.GroupLayout.DEFAULT_SIZE, 635, Short.MAX_VALUE))
                .addGap(0, 23, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistrarProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarProveedorActionPerformed
       //lblBienvenido.setVisible(false);
       JPOUsuarios.setVisible(true);
    }//GEN-LAST:event_btnRegistrarProveedorActionPerformed

    private void btnListarProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListarProveedorActionPerformed
        // TODO add your handling code here:
          ContribuyentesPrincipal contribuyentes = new ContribuyentesPrincipal();
        contribuyentes.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnListarProveedorActionPerformed

    private void jBCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBCerrarSesionActionPerformed
        // TODO add your handling code here:
        Login salir = new Login();
        this.setVisible(false);
        salir.setVisible(true);
    }//GEN-LAST:event_jBCerrarSesionActionPerformed

    private void btnConsultasProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultasProveedorActionPerformed
        ProveedorPrincipal p = new ProveedorPrincipal();
        p.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnConsultasProveedorActionPerformed

    private void btnConsultasProveedor1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultasProveedor1ActionPerformed
        // TODO add your handling code here:
      InicioAdminAccesos accesos = new InicioAdminAccesos();
        accesos.setVisible(true);
        accesos.btnHora.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnConsultasProveedor1ActionPerformed

    private void btnConsultasProveedor2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultasProveedor2ActionPerformed
        ReportesPrincipal rp = new ReportesPrincipal();
        rp.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnConsultasProveedor2ActionPerformed

    private void btnConsultasProveedor3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultasProveedor3ActionPerformed
        // TODO add your handling code here:
          DeclaracionesInicio declaraciones = new DeclaracionesInicio();
       declaraciones.setVisible(true);
       this.setVisible(false);
    }//GEN-LAST:event_btnConsultasProveedor3ActionPerformed

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        // TODO add your handling code here:
        jPRegistrar.setVisible(true);
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void btnVerTodosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerTodosActionPerformed
        // TODO add your handling code here:
        InicioVerTod verTodos = new InicioVerTod();
        verTodos.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnVerTodosActionPerformed

    private void txtCedulaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCedulaFocusGained

    }//GEN-LAST:event_txtCedulaFocusGained

    private void txtCedulaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCedulaFocusLost

    }//GEN-LAST:event_txtCedulaFocusLost

    private void txtCedulaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtCedulaMouseClicked

    }//GEN-LAST:event_txtCedulaMouseClicked

    private void txtCedulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCedulaActionPerformed

    }//GEN-LAST:event_txtCedulaActionPerformed

    private void txtNombresFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNombresFocusGained

    }//GEN-LAST:event_txtNombresFocusGained

    private void txtNombresFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNombresFocusLost

    }//GEN-LAST:event_txtNombresFocusLost

    private void txtApellidosFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtApellidosFocusGained

    }//GEN-LAST:event_txtApellidosFocusGained

    private void txtApellidosFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtApellidosFocusLost

    }//GEN-LAST:event_txtApellidosFocusLost

    private void txtCorreoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCorreoFocusGained

    }//GEN-LAST:event_txtCorreoFocusGained

    private void txtCorreoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCorreoFocusLost

    }//GEN-LAST:event_txtCorreoFocusLost

    private void txtUsuarioFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtUsuarioFocusGained

    }//GEN-LAST:event_txtUsuarioFocusGained

    private void txtUsuarioFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtUsuarioFocusLost

    }//GEN-LAST:event_txtUsuarioFocusLost

    private void txtContrasenaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtContrasenaFocusGained

    }//GEN-LAST:event_txtContrasenaFocusGained

    private void txtContrasenaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtContrasenaFocusLost

    }//GEN-LAST:event_txtContrasenaFocusLost

    private void jCBRolMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCBRolMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jCBRolMouseClicked

    private void jCBRolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBRolActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCBRolActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed

    }//GEN-LAST:event_btnGuardarActionPerformed

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        jBCerrarSesion.setVisible(true);
    }//GEN-LAST:event_jLabel5MouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               new InicioAdminUsuarios().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JPanel JPOUsuarios;
    private javax.swing.JButton btnConsultasProveedor;
    private javax.swing.JButton btnConsultasProveedor1;
    private javax.swing.JButton btnConsultasProveedor2;
    private javax.swing.JButton btnConsultasProveedor3;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnListarProveedor;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JButton btnRegistrarProveedor;
    private javax.swing.JButton btnVerTodos;
    private javax.swing.JButton jBCerrarSesion;
    private javax.swing.JComboBox<String> jCBRol;
    private javax.swing.JLabel jLSidimLogo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPEncabezado;
    public javax.swing.JPanel jPRegistrar;
    private javax.swing.JPanel jPVer;
    private javax.swing.JLabel lbContraseña;
    private javax.swing.JLabel lbUsuario;
    private javax.swing.JLabel lblApellidos;
    private javax.swing.JLabel lblCedula;
    private javax.swing.JLabel lblCorreo;
    private javax.swing.JLabel lblNombres;
    private javax.swing.JLabel lblRol;
    private javax.swing.JLabel lblRucProveedor1;
    private javax.swing.JLabel lblRucProveedor2;
    private javax.swing.JTextField txtApellidos;
    private javax.swing.JTextField txtCedula;
    private javax.swing.JTextField txtContrasena;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtNombres;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
