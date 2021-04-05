/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Empleado;

/**
 *
 * @author danie
 */
public class Servidor extends javax.swing.JFrame {

    /**
     * Creates new form Servidor
     */
    public Servidor() {
        initComponents();
        setTitle("Servidor");
        setResizable(false);
        setLocationRelativeTo(null);
    }

    
    //Borra todas la filas del jTable
    private void limpiarListadoTabla(){
        DefaultTableModel modelo;
        modelo = (DefaultTableModel) tablaEmpleados.getModel();
        for(int i=modelo.getRowCount()-1; i>=0 ; i--){
            modelo.removeRow(i);
        }
    }
    
    
    //Carga los datos de las comunas en el jTable
    public void cargarEmpleados(ArrayList<Empleado> listado){
        DefaultTableModel modelo;
        modelo = (DefaultTableModel) tablaEmpleados.getModel();        
        limpiarListadoTabla();
        for(int i= 0; i < listado.size(); i++){
              modelo.addRow(new Object[]{
              listado.get(i).getNombre(),
              listado.get(i).getCorreo(),
              listado.get(i).getSexo(),
              listado.get(i).getCodigo(),
              listado.get(i).getDependencia(),
              listado.get(i).getSubDependencia()
              });
        }
    }
    
    
    //Metodo para mostrar mensajes cuando se presente una exepción
    public void gestionMensajes(String mensaje, String titulo, int icono){
         JOptionPane.showMessageDialog(this,mensaje, titulo, icono);
    }
    
    
    //GETTERS
    
    //Nombre Completo
    public String getNombre(){
        return txtNomServidor.getText();
    }
    
    //Correo Electronico
    public String getCorreo(){
        return txtCorreoServidor.getText();
    }
    
    //Dependencias en registro
    public String getDependencia(){
        return cbxDependencias.getSelectedItem().toString().trim();
    }
    
    //Subdependencias en registro
    public String getSubdependencia(){
        return cbxSubDep.getSelectedItem().toString().trim();
    }
    
    //Sexo
    public String getSexo(){
        return cbxSexo.getSelectedItem().toString().trim();
    }
    
    //Codigo
    public String getCodigo(){
        return txtCodigo.getText();
    }
    
    //Dependencias en busqueda
    public String getDependenciaBusq(){
        return cbxDepListado.getSelectedItem().toString().trim();
    }
    
    //Subdependencias en busqueda
    public String getSubdependenciaBusq(){
        return cbxSubDepListados.getSelectedItem().toString().trim();
    }
    
    //Nombre en busqueda
    public String getNombreBusq(){
        return txtNombreBusq.getText();
    }
    
    
    //Se agregan escuchas a los botones
    
    public void addListenerBtnModEmpleados(ActionListener listenPrograma){
        btnModEmpleados.addActionListener(listenPrograma);        
    }
    
    public void addListenerBtnElmEmpleados(ActionListener listenPrograma){
        btnElmEmpleados.addActionListener(listenPrograma);        
    }
    
    public void addListenerBtnRegistrarEmpleados(ActionListener listenPrograma){
        btnRegistrarEmpleados.addActionListener(listenPrograma);        
    }
    
    public void addListenerBtnRegistrarAdmin(ActionListener listenPrograma){
        btnRegistrarAdmin.addActionListener(listenPrograma);        
    }
    
    public void addListenerBtnBusListado(ActionListener listenPrograma){
        btnBusListado.addActionListener(listenPrograma);        
    }
    
    
    //Metodo para llenar los ComboBox de dependencias
    public void comboDependencias(ArrayList<String> dependencias){
        
        for(int i=0; i<dependencias.size(); i++){
            
            //En registro
            cbxDependencias.addItem(dependencias.get(i));
            
            //En busqueda
            cbxDepListado.addItem(dependencias.get(i));
        }
    }
    
    
    //Metodos para llenar los ComboBox de subdependencias
    
    //En registro
    public void comboSubdepenRegistro(ArrayList<String> subdependencias){
        
        for(int i=0; i<subdependencias.size(); i++){
            cbxSubDep.addItem(subdependencias.get(i));
        }
    }
    
    //En busqueda
    public void comboSubdepenBusq(ArrayList<String> subdependencias){
        
        for(int i=0; i<subdependencias.size(); i++){
            cbxSubDepListados.addItem(subdependencias.get(i));
        }
    }
    
   
    //Metodo para activar y desactivar componentes
    public void activarControles(boolean estado){
        txtNomServidor.setEnabled(estado);
        txtCorreoServidor.setEnabled(estado);
        txtCodigo.setEnabled(estado);
        cbxDependencias.setEnabled(estado);
        cbxSexo.setEnabled(estado);
        cbxSubDep.setEnabled(estado);
        tablaEmpleados.setEnabled(!estado);
    }
    
    
    //Metodo para limpiar componentes
    public void limpiar(){
        txtNomServidor.setText("");
        txtCorreoServidor.setText("");
        txtCodigo.setText("");
        txtNombreBusq.setText("");
        cbxSexo.setSelectedItem("Seleccionar");
        cbxDependencias.setSelectedItem("TODAS");
        cbxSubDep.setSelectedItem("TODAS");
        cbxDepListado.setSelectedItem("TODAS");
        cbxSubDepListados.setSelectedItem("TODAS");
    } 
    
    
    //Metodo para limpiar comboBox
    public void limpiaCombox(){
        cbxDependencias.removeAllItems();
        cbxSubDep.removeAllItems();
        cbxDepListado.removeAllItems();
        cbxSubDepListados.removeAllItems();
        
        cbxDependencias.addItem("TODAS");
        cbxSubDep.addItem("TODAS");
        cbxDepListado.addItem("TODAS");
        cbxSubDepListados.addItem("TODAS");
    }
    
    
    //Metodo para modificar componentes cuando se desee registrar un empleado o administrador
    public void accionRegistrar(){          
        
        if(btnRegistrarEmpleados.getText().equals("Registrar Empleado") || btnRegistrarAdmin.getText().equals("Registrar Administrador")){  
            limpiar();
            activarControles(true);
            btnRegistrarEmpleados.setEnabled(false);
            btnRegistrarAdmin.setEnabled(false);
            btnModEmpleados.setText("Guardar");
            btnModEmpleados.setActionCommand("Guardar");            
            btnElmEmpleados.setText("Cancelar");
            btnElmEmpleados.setActionCommand("Cancelar");
            txtNomServidor.requestFocusInWindow();
        }
        else{
            limpiar();
            activarControles(false); 
            btnRegistrarEmpleados.setEnabled(true);
            btnRegistrarAdmin.setEnabled(true);
            btnModEmpleados.setText("Modificar");
            btnModEmpleados.setActionCommand("Modificar");            
            btnElmEmpleados.setText("Eliminar");
            btnElmEmpleados.setActionCommand("Eliminar");
            txtNomServidor.requestFocusInWindow();
        }
    }  
    
    
    //Metodo para modificar componentes cuando se desee modificar un empleado
    public void accionModificar(){
        
        if(btnModEmpleados.getText().equals("Modificar")){
            
            if(tablaEmpleados.getSelectedRow() == -1){
                
               if(tablaEmpleados.getRowCount() == 0){
                   JOptionPane.showMessageDialog(this,"NO HAY REGISTROS");
               }
               else{
                   JOptionPane.showMessageDialog(this,"SELECCIONE UN EMPLEADO EN LA TABLA");
               }
            }
            else{ 
                activarControles(true); 
                txtCodigo.setEnabled(false);
                btnRegistrarEmpleados.setEnabled(false);
                btnRegistrarAdmin.setEnabled(false);
                tablaEmpleados.setEnabled(false);
                
                btnModEmpleados.setText("Actualizar");
                btnModEmpleados.setActionCommand("Actualizar");  
                btnElmEmpleados.setText("Cancelar");
                btnElmEmpleados.setActionCommand("Cancelar");
                txtNomServidor.requestFocusInWindow();
            }
        }
        else{
            activarControles(false);
            btnRegistrarEmpleados.setEnabled(true);
            btnRegistrarAdmin.setEnabled(true);
            tablaEmpleados.setEnabled(true);
            
            btnModEmpleados.setText("Modificar");
            btnModEmpleados.setActionCommand("Modificar");  
            btnElmEmpleados.setText("Eliminar");
            btnElmEmpleados.setActionCommand("Eliminar");
            txtNomServidor.requestFocusInWindow();
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

        jScrollPane2 = new javax.swing.JScrollPane();
        lblNombre = new javax.swing.JLabel();
        pnlInfEmpleado = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtNomServidor = new javax.swing.JTextField();
        txtCorreoServidor = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        cbxDependencias = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        cbxSubDep = new javax.swing.JComboBox<>();
        cbxSexo = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        btnRegistrarEmpleados = new javax.swing.JButton();
        btnModEmpleados = new javax.swing.JButton();
        btnElmEmpleados = new javax.swing.JButton();
        btnRegistrarAdmin = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        cbxDepListado = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        cbxSubDepListados = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        txtNombreBusq = new javax.swing.JTextField();
        btnBusListado = new javax.swing.JButton();
        srcListadoEmpleadosS = new javax.swing.JScrollPane();
        tablaEmpleados = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblNombre.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblNombre.setText("REGISTRO EMPLEADOS");

        pnlInfEmpleado.setBackground(new java.awt.Color(255, 255, 255));
        pnlInfEmpleado.setBorder(javax.swing.BorderFactory.createTitledBorder("Informacion de Empleados"));

        jLabel1.setText("Nombre Completo");

        jLabel2.setText("Correo Electronico");

        txtNomServidor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomServidorActionPerformed(evt);
            }
        });

        txtCorreoServidor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCorreoServidorActionPerformed(evt);
            }
        });

        jLabel3.setText("Código");

        jLabel4.setText("Dependencia");

        txtCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodigoActionPerformed(evt);
            }
        });

        cbxDependencias.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "TODAS" }));

        jLabel5.setText("Sexo");

        jLabel6.setText("Subdependencia");

        cbxSubDep.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "TODAS" }));

        cbxSexo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar", "Femenino", "Masculino" }));

        javax.swing.GroupLayout pnlInfEmpleadoLayout = new javax.swing.GroupLayout(pnlInfEmpleado);
        pnlInfEmpleado.setLayout(pnlInfEmpleadoLayout);
        pnlInfEmpleadoLayout.setHorizontalGroup(
            pnlInfEmpleadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlInfEmpleadoLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(pnlInfEmpleadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlInfEmpleadoLayout.createSequentialGroup()
                        .addGroup(pnlInfEmpleadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnlInfEmpleadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbxDependencias, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbxSubDep, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnlInfEmpleadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlInfEmpleadoLayout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlInfEmpleadoLayout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(8, 8, 8)))
                        .addGroup(pnlInfEmpleadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtCodigo)
                            .addComponent(cbxSexo, 0, 122, Short.MAX_VALUE))
                        .addGap(26, 26, 26))
                    .addGroup(pnlInfEmpleadoLayout.createSequentialGroup()
                        .addGroup(pnlInfEmpleadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(30, 30, 30)
                        .addGroup(pnlInfEmpleadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtNomServidor, javax.swing.GroupLayout.DEFAULT_SIZE, 310, Short.MAX_VALUE)
                            .addComponent(txtCorreoServidor))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        pnlInfEmpleadoLayout.setVerticalGroup(
            pnlInfEmpleadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlInfEmpleadoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlInfEmpleadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNomServidor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlInfEmpleadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtCorreoServidor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(pnlInfEmpleadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlInfEmpleadoLayout.createSequentialGroup()
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addGroup(pnlInfEmpleadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbxSubDep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(37, 37, 37))
                    .addGroup(pnlInfEmpleadoLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(pnlInfEmpleadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbxSexo)
                            .addComponent(cbxDependencias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(79, 79, 79))))
        );

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        btnRegistrarEmpleados.setText("Registrar Empleado");
        btnRegistrarEmpleados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarEmpleadosActionPerformed(evt);
            }
        });

        btnModEmpleados.setText("Modificar");

        btnElmEmpleados.setText("Eliminar");

        btnRegistrarAdmin.setText("Registrar Administrador");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btnRegistrarAdmin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnRegistrarEmpleados, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnModEmpleados)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnElmEmpleados)))
                .addGap(22, 22, 22))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnModEmpleados)
                    .addComponent(btnElmEmpleados))
                .addGap(32, 32, 32)
                .addComponent(btnRegistrarEmpleados)
                .addGap(35, 35, 35)
                .addComponent(btnRegistrarAdmin)
                .addGap(30, 30, 30))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Listado de Empleados"));

        jLabel7.setText("Dependencia");

        cbxDepListado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "TODAS" }));

        jLabel8.setText("Subdependencia");

        cbxSubDepListados.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "TODAS" }));

        jLabel9.setText("Nombre de Empleado");

        txtNombreBusq.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreBusqActionPerformed(evt);
            }
        });

        btnBusListado.setText("Buscar");

        tablaEmpleados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Nombre", "Correo Electronico", "Codigo", "Sexo", "Dependencia", "Subdependencia"
            }
        ));
        tablaEmpleados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaEmpleadosMouseClicked(evt);
            }
        });
        srcListadoEmpleadosS.setViewportView(tablaEmpleados);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(srcListadoEmpleadosS)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbxDepListado, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbxSubDepListados, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtNombreBusq, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnBusListado)))
                .addGap(18, 18, 18))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(cbxDepListado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(cbxSubDepListados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(txtNombreBusq, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBusListado))
                .addGap(31, 31, 31)
                .addComponent(srcListadoEmpleadosS, javax.swing.GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(pnlInfEmpleado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(35, 35, 35))
            .addGroup(layout.createSequentialGroup()
                .addGap(301, 301, 301)
                .addComponent(lblNombre)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(lblNombre)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlInfEmpleado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(33, 33, 33)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(13, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNomServidorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomServidorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomServidorActionPerformed

    private void txtCorreoServidorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCorreoServidorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCorreoServidorActionPerformed

    private void btnRegistrarEmpleadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarEmpleadosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRegistrarEmpleadosActionPerformed

    private void txtCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodigoActionPerformed

    private void txtNombreBusqActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreBusqActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreBusqActionPerformed

    private void tablaEmpleadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaEmpleadosMouseClicked
        
        DefaultTableModel modelo;
        modelo = (DefaultTableModel) tablaEmpleados.getModel();
                            
        if(tablaEmpleados.getSelectedRow()==-1){
            
            if(tablaEmpleados.getRowCount()==0){
                JOptionPane.showMessageDialog(this,"NO HAY REGISTROS");
            }
            else{
                JOptionPane.showMessageDialog(this,"SELECCIONE UN EMPLEADO EN LA TABLA");
            }
        }
        else {                               
            txtNomServidor.setText(modelo.getValueAt(tablaEmpleados.getSelectedRow(), 0).toString());            
            txtCorreoServidor.setText(modelo.getValueAt(tablaEmpleados.getSelectedRow(), 1).toString());
            txtCodigo.setText(modelo.getValueAt(tablaEmpleados.getSelectedRow(), 2).toString());    
            cbxSexo.setSelectedItem(modelo.getValueAt(tablaEmpleados.getSelectedRow(), 3).toString());
            cbxDependencias.setSelectedItem(modelo.getValueAt(tablaEmpleados.getSelectedRow(), 4).toString());
            cbxSubDep.setSelectedItem(modelo.getValueAt(tablaEmpleados.getSelectedRow(), 5).toString());
        }
    }//GEN-LAST:event_tablaEmpleadosMouseClicked

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
            java.util.logging.Logger.getLogger(Servidor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Servidor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Servidor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Servidor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Servidor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBusListado;
    private javax.swing.JButton btnElmEmpleados;
    private javax.swing.JButton btnModEmpleados;
    private javax.swing.JButton btnRegistrarAdmin;
    private javax.swing.JButton btnRegistrarEmpleados;
    private javax.swing.JComboBox<String> cbxDepListado;
    private javax.swing.JComboBox<String> cbxDependencias;
    private javax.swing.JComboBox<String> cbxSexo;
    private javax.swing.JComboBox<String> cbxSubDep;
    private javax.swing.JComboBox<String> cbxSubDepListados;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JPanel pnlInfEmpleado;
    private javax.swing.JScrollPane srcListadoEmpleadosS;
    private javax.swing.JTable tablaEmpleados;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtCorreoServidor;
    private javax.swing.JTextField txtNomServidor;
    private javax.swing.JTextField txtNombreBusq;
    // End of variables declaration//GEN-END:variables
}
