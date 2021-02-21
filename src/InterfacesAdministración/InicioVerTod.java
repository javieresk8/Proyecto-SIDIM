/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfacesAdministración;

import Interfaces.ContribuyentesPrincipal;
import Interfaces.DeclaracionesInicio;
import InterfacesProveedor.ProveedorPrincipal;
import InterfacesReportes.ReportesPrincipal;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.YES_OPTION;
import javax.swing.table.DefaultTableModel;






/**
 *
 * @author Bryan
 */
public class InicioVerTod extends javax.swing.JFrame {

    /**
     * Creates new form ContribuyentesPrincipal
     */

    public InicioVerTod() {
        initComponents();
        this.setSize(1366, 768);
        jBCerrarSesion.setVisible(false);
        JPOUsuarios.setVisible(false);
        jPEE.setVisible(false);
      
        
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPEncabezado = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLSidimLogo = new javax.swing.JLabel();
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
        jBCerrarSesion = new javax.swing.JButton();
        btnCerrarSesion = new javax.swing.JButton();
        jPVerTodos = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtBuscarUsuarios = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblListadoUsuarios = new javax.swing.JTable();
        btnBuscarUsuarios = new javax.swing.JButton();
        jPEE = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPEncabezado.setBackground(new java.awt.Color(54, 112, 171));

        jLabel2.setBackground(new java.awt.Color(80, 125, 180));
        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(240, 240, 241));
        jLabel2.setText("Hola: Luis López");
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 959, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33))
        );
        jPEncabezadoLayout.setVerticalGroup(
            jPEncabezadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLSidimLogo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

        jBCerrarSesion.setBackground(new java.awt.Color(0, 153, 51));
        jBCerrarSesion.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jBCerrarSesion.setForeground(new java.awt.Color(240, 240, 241));
        jBCerrarSesion.setText("Cerrar Sesión");
        jBCerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBCerrarSesionActionPerformed(evt);
            }
        });

        btnCerrarSesion.setBackground(new java.awt.Color(38, 35, 36));
        btnCerrarSesion.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnCerrarSesion.setForeground(new java.awt.Color(240, 240, 241));
        btnCerrarSesion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/iconBack48x48.png"))); // NOI18N
        btnCerrarSesion.setText("CerrarSesión");
        btnCerrarSesion.setBorderPainted(false);
        btnCerrarSesion.setFocusPainted(false);
        btnCerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarSesionActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 35)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(38, 35, 36));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Listado de Usuarios");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(163, 164, 166));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Aquí encuentra todos los usuarios que están registrados");

        txtBuscarUsuarios.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtBuscarUsuarios.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtBuscarUsuariosFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtBuscarUsuariosFocusLost(evt);
            }
        });

        tblListadoUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Cédula", "Nombres", "Apellidos", "Correo Electrónico", "Usuario", "Contraseña", "Rol"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblListadoUsuarios.getTableHeader().setReorderingAllowed(false);
        tblListadoUsuarios.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tblListadoUsuariosFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                tblListadoUsuariosFocusLost(evt);
            }
        });
        tblListadoUsuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblListadoUsuariosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblListadoUsuarios);

        btnBuscarUsuarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IconosProveedor/1490129321-rounded10_82180.png"))); // NOI18N
        btnBuscarUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarUsuariosActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(255, 51, 51));
        jButton1.setText("Eliminar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(0, 51, 204));
        jButton2.setText("Editar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPEELayout = new javax.swing.GroupLayout(jPEE);
        jPEE.setLayout(jPEELayout);
        jPEELayout.setHorizontalGroup(
            jPEELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPEELayout.createSequentialGroup()
                .addContainerGap(59, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44))
        );
        jPEELayout.setVerticalGroup(
            jPEELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPEELayout.createSequentialGroup()
                .addContainerGap(50, Short.MAX_VALUE)
                .addGroup(jPEELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50))
        );

        javax.swing.GroupLayout jPVerTodosLayout = new javax.swing.GroupLayout(jPVerTodos);
        jPVerTodos.setLayout(jPVerTodosLayout);
        jPVerTodosLayout.setHorizontalGroup(
            jPVerTodosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPVerTodosLayout.createSequentialGroup()
                .addGroup(jPVerTodosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPVerTodosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPVerTodosLayout.createSequentialGroup()
                            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtBuscarUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnBuscarUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPVerTodosLayout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1057, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPVerTodosLayout.createSequentialGroup()
                        .addGap(326, 326, 326)
                        .addComponent(jPEE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPVerTodosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPVerTodosLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPVerTodosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel6)
                        .addComponent(jLabel7))
                    .addContainerGap(562, Short.MAX_VALUE)))
        );
        jPVerTodosLayout.setVerticalGroup(
            jPVerTodosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPVerTodosLayout.createSequentialGroup()
                .addGap(132, 132, 132)
                .addGroup(jPVerTodosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnBuscarUsuarios)
                    .addComponent(txtBuscarUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPEE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPVerTodosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPVerTodosLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(2, 2, 2)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(644, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPVer, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPVerTodos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jBCerrarSesion, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                        .addComponent(btnCerrarSesion, javax.swing.GroupLayout.DEFAULT_SIZE, 391, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPEncabezado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPEncabezado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnCerrarSesion, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jBCerrarSesion)
                        .addGap(25, 25, 25)
                        .addComponent(jPVerTodos, javax.swing.GroupLayout.PREFERRED_SIZE, 586, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 16, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPVer, javax.swing.GroupLayout.DEFAULT_SIZE, 647, Short.MAX_VALUE)
                        .addContainerGap())))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarSesionActionPerformed
         Login volver = new Login();
        this.setVisible(false);
        volver.setVisible(true);
    }//GEN-LAST:event_btnCerrarSesionActionPerformed

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

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
    jBCerrarSesion.setVisible(true);  
    }//GEN-LAST:event_jLabel2MouseClicked

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
    InicioAdminUsuarios registrar = new InicioAdminUsuarios();
    registrar.setVisible(true);
    registrar.jPRegistrar.setVisible(true);
    this.setVisible(false);
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void btnVerTodosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerTodosActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_btnVerTodosActionPerformed

    private void txtBuscarUsuariosFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtBuscarUsuariosFocusGained

    }//GEN-LAST:event_txtBuscarUsuariosFocusGained

    private void txtBuscarUsuariosFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtBuscarUsuariosFocusLost

    }//GEN-LAST:event_txtBuscarUsuariosFocusLost

    private void tblListadoUsuariosFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tblListadoUsuariosFocusGained

    }//GEN-LAST:event_tblListadoUsuariosFocusGained

    private void tblListadoUsuariosFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tblListadoUsuariosFocusLost

    }//GEN-LAST:event_tblListadoUsuariosFocusLost

    private void btnBuscarUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarUsuariosActionPerformed
        String RUC_Proveedor= "";
        if (!(txtBuscarUsuarios.getText().equals("Buscar Proveedor..."))){
            RUC_Proveedor = txtBuscarUsuarios.getText();

        }
    }//GEN-LAST:event_btnBuscarUsuariosActionPerformed

    private void tblListadoUsuariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblListadoUsuariosMouseClicked
        // TODO add your handling code here:
        
      jPEE.setVisible(true);
    }//GEN-LAST:event_tblListadoUsuariosMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
      int filaSelecciona = tblListadoUsuarios.getSelectedRow();
      if(JOptionPane.showConfirmDialog(null, "¿Está seguro que desea Eliminar a este Usuario?","Esta acción no se podrá deshacer",JOptionPane.YES_NO_OPTION)==YES_OPTION){
          DefaultTableModel tabla1 = new  DefaultTableModel();
          tabla1 = (DefaultTableModel) tblListadoUsuarios.getModel();
          tabla1.removeRow(filaSelecciona);
          tblListadoUsuarios.setModel(tabla1);
       }
      else
      {
          jPEE.setVisible(false);
      }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        InicioAdmiUsuariosEditar editar  = new InicioAdmiUsuariosEditar();
        editar.setVisible(true);
        this.setVisible(false);
  
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               new InicioVerTod().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel JPOUsuarios;
    private javax.swing.JButton btnBuscarUsuarios;
    private javax.swing.JButton btnCerrarSesion;
    private javax.swing.JButton btnConsultasProveedor;
    private javax.swing.JButton btnConsultasProveedor1;
    private javax.swing.JButton btnConsultasProveedor2;
    private javax.swing.JButton btnConsultasProveedor3;
    private javax.swing.JButton btnListarProveedor;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JButton btnRegistrarProveedor;
    private javax.swing.JButton btnVerTodos;
    private javax.swing.JButton jBCerrarSesion;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLSidimLogo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPEE;
    private javax.swing.JPanel jPEncabezado;
    private javax.swing.JPanel jPVer;
    private javax.swing.JPanel jPVerTodos;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblListadoUsuarios;
    private javax.swing.JTextField txtBuscarUsuarios;
    // End of variables declaration//GEN-END:variables
}
