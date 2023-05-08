/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany;

import com.mycompany.daos.VeiculoDAO;
import com.mycompany.models.Veiculo;

/**
 *
 * @author larissa
 */
public class FormVeiculo extends javax.swing.JFrame {
    private Veiculo V;
    private VeiculoDAO veiculoDAO;
    /**
     * Creates new form FormVeiculo
     */
    public FormVeiculo() {
        initComponents();
        V = new Veiculo();
        veiculoDAO = new VeiculoDAO();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        modeloJL = new javax.swing.JLabel();
        placaJL = new javax.swing.JLabel();
        anoJL = new javax.swing.JLabel();
        corJL = new javax.swing.JLabel();
        salvarBT = new javax.swing.JButton();
        exibirBT = new javax.swing.JButton();
        modeloTF = new javax.swing.JTextField();
        placaTF = new javax.swing.JTextField();
        anoTF = new javax.swing.JTextField();
        corTF = new javax.swing.JTextField();
        retornoModeloJL = new javax.swing.JLabel();
        retornoPlacaJL = new javax.swing.JLabel();
        retornoAnoJL = new javax.swing.JLabel();
        retornoCorJL = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Veículo");
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                formMouseExited(evt);
            }
        });

        modeloJL.setText("Modelo:");

        placaJL.setText("Placa:");

        anoJL.setText("Ano:");

        corJL.setText("Cor:");

        salvarBT.setText("Salvar");
        salvarBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salvarBTActionPerformed(evt);
            }
        });

        exibirBT.setText("Exibir");
        exibirBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exibirBTActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(modeloJL)
                                .addGap(18, 18, 18)
                                .addComponent(modeloTF))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(placaJL)
                                .addGap(27, 27, 27)
                                .addComponent(placaTF))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(corJL)
                                    .addComponent(anoJL))
                                .addGap(39, 39, 39)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(retornoModeloJL, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(corTF)
                                    .addComponent(anoTF)
                                    .addComponent(retornoPlacaJL, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(101, 101, 101)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(retornoAnoJL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(retornoCorJL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(166, 166, 166)
                        .addComponent(salvarBT, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 246, Short.MAX_VALUE)
                        .addComponent(exibirBT, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(124, 124, 124)))
                .addGap(28, 28, 28))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(modeloJL)
                    .addComponent(modeloTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(placaJL)
                    .addComponent(placaTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(anoJL)
                    .addComponent(anoTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(corJL)
                    .addComponent(corTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addComponent(retornoModeloJL)
                .addGap(18, 18, 18)
                .addComponent(retornoPlacaJL)
                .addGap(18, 18, 18)
                .addComponent(retornoAnoJL)
                .addGap(18, 18, 18)
                .addComponent(retornoCorJL)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 150, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(exibirBT, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(salvarBT, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void salvarBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salvarBTActionPerformed
        // TODO add your handling code here:
        V.setModelo(modeloTF.getText());
        V.setPlaca(placaTF.getText());
        V.setAno(Integer.parseInt(anoTF.getText()));
        V.setCor(corTF.getText());
        
        veiculoDAO.save(V);
        
        modeloTF.setText("");
        placaTF.setText("");
        anoTF.setText("");
        corTF.setText("");
        retornoAnoJL.setText("Dados armazenados");
    }//GEN-LAST:event_salvarBTActionPerformed

    private void exibirBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exibirBTActionPerformed
        // TODO add your handling code here:
        Veiculo veiculo = veiculoDAO.getLastVeiculo();
        
        String modelo = veiculo.getModelo();
        String placa = veiculo.getPlaca();
        long ano = veiculo.getAno();
        String cor = veiculo.getCor();
        retornoModeloJL.setText("Modelo: " + modelo);
        retornoPlacaJL.setText("Placa: " + placa);
        retornoAnoJL.setText("Ano: " + ano);
        retornoCorJL.setText("Cor: " + cor);
    }//GEN-LAST:event_exibirBTActionPerformed

    private void formMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseExited
        // TODO add your handling code here:
        setDefaultCloseOperation(FormVeiculo.DISPOSE_ON_CLOSE);
    }//GEN-LAST:event_formMouseExited

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
            java.util.logging.Logger.getLogger(FormVeiculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormVeiculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormVeiculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormVeiculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormVeiculo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel anoJL;
    private javax.swing.JTextField anoTF;
    private javax.swing.JLabel corJL;
    private javax.swing.JTextField corTF;
    private javax.swing.JButton exibirBT;
    private javax.swing.JLabel modeloJL;
    private javax.swing.JTextField modeloTF;
    private javax.swing.JLabel placaJL;
    private javax.swing.JTextField placaTF;
    private javax.swing.JLabel retornoAnoJL;
    private javax.swing.JLabel retornoCorJL;
    private javax.swing.JLabel retornoModeloJL;
    private javax.swing.JLabel retornoPlacaJL;
    private javax.swing.JButton salvarBT;
    // End of variables declaration//GEN-END:variables
}
