/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ulbra.view;

import br.ulbra.controller.AnimalController;
import br.ulbra.controller.DonoController;
import br.ulbra.model.Animal;
import br.ulbra.model.Dono;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author s.lucas
 */


public class FRUPDDon extends javax.swing.JDialog {
    
    private int pkDono;
    
    public void setPkDono(int pk){
        this.pkDono = pk;
    }
    /**
     * Creates new form FRUPDDon
     */
    public FRUPDDon(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
    }
    
    private void pesquisar(){
        DefaultTableModel modelo = (DefaultTableModel) tabela.getModel();
        modelo.setNumRows(0);
        AnimalController controller = new AnimalController();
        for(Animal usu : controller.readForDon(Integer.parseInt(txtCodigo.getText()))){
            Object[] linha = {usu.getPkAnimal()
                    , usu.getNomeAni()
                    , usu.getRacaAni()
                    , usu.getEspecieAni()
                    , usu.isVivoAni()
                    , usu.isVacinaAni()};
            modelo.addRow(linha);
        }
    }
    
    private boolean verificarCampos(){
        if(txtNome.getText().equals("")){
            JOptionPane.showMessageDialog(null,"Campo 'Nome' em branco");
            return false;
        }
        
        if(!txtNome.getText().matches("^[\\p{L} ]+$")){
            JOptionPane.showMessageDialog(null,
                    "Campo 'Nome' possui caracteres inválidos");
            return false;
        }
        
        if(txtEmail.getText().equals("")){
            JOptionPane.showMessageDialog(null,"Campo 'Email' em branco");
            return false;
        }
        if(!txtEmail.getText().matches("^[a-zA-Z._0-9]+@[a-zA-Z._]+.[a-zA-Z._]+$")){
            JOptionPane.showMessageDialog(null,
                    "Campo 'Email' possui formato inválido");
            return false;
        }
        
        if(!txtCpf.getText().matches("^[0-9]{9}-[0-9]{2}$")){
            JOptionPane.showMessageDialog(null,
                    "Campo 'CPF' possui formato inválido."
                    +" Ex: 123456789-01");
            return false;
        }
        
        return true;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtEndereco = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtCpf = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        btAlterar = new javax.swing.JButton();
        btVoltar = new javax.swing.JButton();
        btExcluir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(0, 102, 102));

        jLabel1.setFont(new java.awt.Font("Arial Black", 1, 36)); // NOI18N
        jLabel1.setText("Dono");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/ulbra/img/user.png"))); // NOI18N

        jLabel3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(240, 240, 240));
        jLabel3.setText("Codigo");

        jLabel4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(240, 240, 240));
        jLabel4.setText("Nome");

        jLabel5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(240, 240, 240));
        jLabel5.setText("Endereco");

        jLabel6.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(240, 240, 240));
        jLabel6.setText("CPF");

        jLabel7.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(240, 240, 240));
        jLabel7.setText("E-mail");

        tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Cod", "Nome", "Raça", "Especie", "Vivo", "Vacinado"
            }
        ));
        tabela.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabela);

        jLabel8.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(240, 240, 240));
        jLabel8.setText("Animais");

        btAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/ulbra/img/edit.png"))); // NOI18N
        btAlterar.setText("Alterar");
        btAlterar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btAlterarMouseClicked(evt);
            }
        });

        btVoltar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/ulbra/img/cancelar.png"))); // NOI18N
        btVoltar.setText("Voltar");
        btVoltar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btVoltarMouseClicked(evt);
            }
        });

        btExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/ulbra/img/trash.png"))); // NOI18N
        btExcluir.setText("Excluir");
        btExcluir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btExcluirMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel7)
                                .addComponent(jLabel6)
                                .addComponent(jLabel4)
                                .addComponent(jLabel3)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jLabel1))
                                .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtNome, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
                                .addComponent(jLabel5)
                                .addComponent(txtEndereco)
                                .addComponent(txtCpf)
                                .addComponent(txtEmail))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(35, 35, 35)
                                .addComponent(btExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(38, 38, 38)
                                .addComponent(btVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 33, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btExcluir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btVoltar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(btAlterar, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE))
                .addContainerGap(64, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tabelaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaMouseClicked
        if (tabela.getSelectedRow() != -1) {
            int pk = Integer.parseInt(
                tabela.getValueAt(tabela.getSelectedRow(), 0).toString()
            );
            FRUPDAni telaUPD = new FRUPDAni(null, rootPaneCheckingEnabled);
            telaUPD.setPkAnimal(pk);
            telaUPD.carregarDono();
            telaUPD.setVisible(true);
        }
    }//GEN-LAST:event_tabelaMouseClicked

    public void carregarDono(){
        DonoController controller = new DonoController();
        Dono usu = controller.readForPk(pkDono);
       
        String codigo = String.valueOf(usu.getPkDono());
        txtCodigo.setText(codigo);
        txtNome.setText(usu.getNomeDon());
        txtEndereco.setText(usu.getEnderecoDon());
        txtCpf.setText(usu.getCpfDon());
        txtEmail.setText(usu.getEmailDon());
        
        pesquisar();
    }
    
    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        
    }//GEN-LAST:event_formWindowActivated

    private void btAlterarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btAlterarMouseClicked
        if(!verificarCampos()){
            return;
        }

        DonoController controller = new DonoController();
        Dono dono = new Dono();
        dono.setPkDono(pkDono);
        dono.setNomeDon(txtNome.getText());
        dono.setEnderecoDon(txtEndereco.getText());
        dono.setCpfDon(txtCpf.getText());
        dono.setEmailDon(txtEmail.getText());
        if(controller.alterarDono(dono)){
            this.dispose();
        };
    }//GEN-LAST:event_btAlterarMouseClicked

    private void btExcluirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btExcluirMouseClicked
        int resposta = JOptionPane.showConfirmDialog(null, "Deseja excluir o dono?",
            "Confirmação", JOptionPane.YES_NO_OPTION);

        if (resposta == JOptionPane.YES_OPTION) {
            DonoController controller = new DonoController();
            if(controller.excluirDono(pkDono)){
                this.dispose();
            };
        }
    }//GEN-LAST:event_btExcluirMouseClicked

    private void btVoltarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btVoltarMouseClicked
        this.dispose();
    }//GEN-LAST:event_btVoltarMouseClicked

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
            java.util.logging.Logger.getLogger(FRUPDDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FRUPDDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FRUPDDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FRUPDDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FRUPDDon dialog = new FRUPDDon(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btAlterar;
    private javax.swing.JButton btExcluir;
    private javax.swing.JButton btVoltar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabela;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtCpf;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtEndereco;
    private javax.swing.JTextField txtNome;
    // End of variables declaration//GEN-END:variables
}
