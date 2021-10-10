/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amna.easyparking;

import com.amna.easyparking.vo.PuestoVO;
import com.amna.easyparking.vo.RegistroVO;
import com.amna.easyparking.vo.TipoVehiculoVO;
import com.amna.easyparking.vo.UsuarioVO;
import java.awt.Desktop;
import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author Elsa Mellissa
 */
public class FrmRegistro extends javax.swing.JDialog {

    private UsuarioVO usuarioVO = null;

    private DateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    private Modelo modelo = new Modelo();

    int valorFraccion = 0;

    private RegistroVO regActual = null;

    /**
     * Creates new form FrmRegistro
     */
    public FrmRegistro(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        cmbTipoVehiculo.setSelectedIndex(-1);
        modelo.consultarTarifa().ifPresent(tarifa -> valorFraccion = tarifa.getValorFraccion());
        txtValorFraccion.setText(String.valueOf(valorFraccion));
        setLocationRelativeTo(parent);
    }

    public void setUsuario(UsuarioVO usuarioVO) {
        this.usuarioVO = usuarioVO;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtPlaca = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtFechaSalida = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtFechaIngreso = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtPermanencia = new javax.swing.JTextField();
        txtSubtotal = new javax.swing.JTextField();
        txtIva = new javax.swing.JTextField();
        txtTotal = new javax.swing.JTextField();
        ComboBoxModel cmbTipoVehiculoModel = new DefaultComboBoxModel(modelo.listarTipoVehiculo().toArray());
        cmbTipoVehiculo = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        txtValorFraccion = new javax.swing.JTextField();
        btnCerrar = new javax.swing.JToggleButton();
        btnRegEntrada = new javax.swing.JToggleButton();
        btnRegSalida = new javax.swing.JButton();
        txtPuesto = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Registro de Entrada/Salida");

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Placa");

        txtPlaca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPlacaActionPerformed(evt);
            }
        });

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Fecha Ingreso");

        txtFechaSalida.setEnabled(false);

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Fecha Salida");

        txtFechaIngreso.setEnabled(false);

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Tipo Vehiculo");

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Permanencia");

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Subtotal");

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("IVA");

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("Total");

        txtPermanencia.setEnabled(false);

        txtSubtotal.setEnabled(false);

        txtIva.setEnabled(false);

        txtTotal.setEnabled(false);

        cmbTipoVehiculo.setModel(cmbTipoVehiculoModel);
        cmbTipoVehiculo.setEnabled(false);

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("Valor Fracción");

        txtValorFraccion.setEnabled(false);

        btnCerrar.setText("Cerrar");
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });

        btnRegEntrada.setText("Registrar Entrada");
        btnRegEntrada.setEnabled(false);
        btnRegEntrada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegEntradaActionPerformed(evt);
            }
        });

        btnRegSalida.setText("Registrar Salida");
        btnRegSalida.setEnabled(false);
        btnRegSalida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegSalidaActionPerformed(evt);
            }
        });

        txtPuesto.setEnabled(false);

        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel11.setText("Puesto");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 217, Short.MAX_VALUE)
                        .addComponent(btnRegSalida, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnRegEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(77, 77, 77)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtIva, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtSubtotal, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtPermanencia, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtFechaSalida, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtFechaIngreso, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmbTipoVehiculo, javax.swing.GroupLayout.Alignment.LEADING, 0, 216, Short.MAX_VALUE)
                            .addComponent(txtValorFraccion, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtPlaca, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTotal)
                            .addComponent(txtPuesto))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtValorFraccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbTipoVehiculo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPuesto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFechaIngreso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFechaSalida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPermanencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSubtotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtIva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnCerrar)
                            .addComponent(btnRegEntrada)
                            .addComponent(btnRegSalida)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtPlacaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPlacaActionPerformed
        // TODO add your handling code here:
        if (txtPlaca.getText().isBlank()) {
            JOptionPane.showMessageDialog(rootPane, "Debe indicar la placa del vehículo");
            btnRegEntrada.setEnabled(false);
            btnRegSalida.setEnabled(false);
            return;
        }

        Optional<RegistroVO> optRegistro = modelo.consultarRegistro(txtPlaca.getText().trim());
        if (optRegistro.isEmpty()) { // el vehiculo va ingresando            
            Optional<PuestoVO> optPuesto = modelo.consultarPuestoLibre();
            if (optPuesto.isEmpty()) {
                JOptionPane.showMessageDialog(rootPane, "No hay puestos libres");
                return;
            }

            cmbTipoVehiculo.setSelectedIndex(-1);
            cmbTipoVehiculo.setEnabled(true);
            txtPuesto.setText(optPuesto.get().getPlaza());
            txtFechaIngreso.setText(formatoFecha.format(new Date()));
            txtFechaSalida.setText("");
            txtPermanencia.setText("");
            txtSubtotal.setText("");
            txtIva.setText("");
            txtTotal.setText("");

            btnRegEntrada.setEnabled(true);
            btnRegSalida.setEnabled(false);

            regActual = new RegistroVO();
            regActual.setFecha_ingreso(new Date());
            regActual.setId_puesto(optPuesto.get().getIdPuesto());
            regActual.setPlaza(optPuesto.get().getPlaza());

        } else { // el vehiculo va de salida
            regActual = optRegistro.get();
            // cmbTipoVehiculo.setSelectedItem(ABORT);
            Date salida = new Date();
            Date ingreso = regActual.getFecha_ingreso();
            int permanencia = (int) ((salida.getTime() - ingreso.getTime()) / (1000 * 60)); // 1000 para pasar de milisegundos a segundos
            if (permanencia == 0) {
                permanencia = 1;
            }
            // 60 para pasar de segundos a minutos                                                                               
            int fracciones = permanencia / 15;
            if (permanencia % 15 > 0) {
                fracciones = fracciones + 1;
            }
            int total = fracciones * valorFraccion;
            int subtotal = (int) (total / 1.19);
            int iva = total - subtotal;

            for (int i = 0; i < cmbTipoVehiculo.getItemCount(); i++) {
                TipoVehiculoVO tipoVehiculo = (TipoVehiculoVO) cmbTipoVehiculo.getItemAt(i);
                if (tipoVehiculo.getIdTipoVehiculo() == regActual.getId_tipo_vehiculo()) {
                    cmbTipoVehiculo.setSelectedIndex(i);
                    break;
                }
            }

            txtPuesto.setText(regActual.getPlaza());
            txtFechaIngreso.setText(formatoFecha.format(ingreso));
            txtFechaSalida.setText(formatoFecha.format(salida));
            txtPermanencia.setText(String.valueOf(permanencia));
            txtSubtotal.setText(String.valueOf(subtotal));
            txtIva.setText(String.valueOf(iva));
            txtTotal.setText(String.valueOf(total));
            btnRegEntrada.setEnabled(false);
            btnRegSalida.setEnabled(true);

            regActual.setFecha_salida(salida);
            regActual.setTarifa(iva);
            regActual.setPermanencia(permanencia);
            regActual.setSubtotal(subtotal);
            regActual.setIva(iva);
            regActual.setTotal(total);
        }
    }//GEN-LAST:event_txtPlacaActionPerformed

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_btnCerrarActionPerformed

    private void btnRegEntradaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegEntradaActionPerformed
        // TODO add your handling code here:
        if (txtPlaca.getText().isBlank()) {
            JOptionPane.showMessageDialog(rootPane, "Debe ingresar la placa");
            return;
        }
        if (cmbTipoVehiculo.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(rootPane, "Debe Indicar el tipo de vehículo");
            return;
        }

        regActual.setPlaca(txtPlaca.getText().trim().toUpperCase());
        regActual.setId_tipo_vehiculo(((TipoVehiculoVO) cmbTipoVehiculo.getSelectedItem()).getIdTipoVehiculo());
        regActual.setNombreTipoVehiculo(((TipoVehiculoVO) cmbTipoVehiculo.getSelectedItem()).getNombre());
        regActual.setId_usuario(usuarioVO.getIdUsuario());
        if (modelo.insertarRegistro(regActual)) {
            modelo.ocuparPuesto(regActual.getId_puesto());
            try {
                File recibo = modelo.generarReciboEntrada(regActual);
                Desktop.getDesktop().open(recibo);
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(rootPane, "Ocurrió un error generando el recibo de entrada");
            } finally {
                JOptionPane.showMessageDialog(rootPane, "Ingreso registrado satisfactoriamente");
            }
            limpiar();
        } else {
            JOptionPane.showMessageDialog(rootPane, "Ocurrió un error registrando el ingreso");
        }
    }//GEN-LAST:event_btnRegEntradaActionPerformed

    private void btnRegSalidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegSalidaActionPerformed
        // TODO add your handling code here:
        if (txtPlaca.getText().isBlank()) {
            JOptionPane.showMessageDialog(rootPane, "Debe ingresar la placa");
            return;
        }

        regActual.setId_usuario(usuarioVO.getIdUsuario());
        regActual.setNombreTipoVehiculo(((TipoVehiculoVO) cmbTipoVehiculo.getSelectedItem()).getNombre());
        if (modelo.actualizarRegistro(regActual)) {
            modelo.liberarPuesto(regActual.getId_puesto());
            try {
                File recibo = modelo.generarReciboSalida(regActual);
                Desktop.getDesktop().open(recibo);
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(rootPane, "Ocurrió un error generando el recibo de salida");
            } finally {
                JOptionPane.showMessageDialog(rootPane, "Salida registrada satisfactoriamente");
            }
            limpiar();
        } else {
            JOptionPane.showMessageDialog(rootPane, "Ocurrió un error registrando la salida");
        }
    }//GEN-LAST:event_btnRegSalidaActionPerformed

    private void limpiar() {
        txtPlaca.setText("");
        cmbTipoVehiculo.setSelectedIndex(-1);
        cmbTipoVehiculo.setEnabled(false);
        txtFechaIngreso.setText("");
        txtFechaSalida.setText("");
        txtPermanencia.setText("");
        txtSubtotal.setText("");
        txtIva.setText("");
        txtTotal.setText("");
        txtPuesto.setText("");
        btnRegEntrada.setEnabled(false);
        btnRegSalida.setEnabled(false);
    }

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
            java.util.logging.Logger.getLogger(FrmRegistro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmRegistro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmRegistro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmRegistro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FrmRegistro dialog = new FrmRegistro(new javax.swing.JFrame(), true);
                dialog.setUsuario(new Modelo().consultarUsuario("vigilante").get());
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton btnCerrar;
    private javax.swing.JToggleButton btnRegEntrada;
    private javax.swing.JButton btnRegSalida;
    private javax.swing.JComboBox<Object> cmbTipoVehiculo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField txtFechaIngreso;
    private javax.swing.JTextField txtFechaSalida;
    private javax.swing.JTextField txtIva;
    private javax.swing.JTextField txtPermanencia;
    private javax.swing.JTextField txtPlaca;
    private javax.swing.JTextField txtPuesto;
    private javax.swing.JTextField txtSubtotal;
    private javax.swing.JTextField txtTotal;
    private javax.swing.JTextField txtValorFraccion;
    // End of variables declaration//GEN-END:variables
}
