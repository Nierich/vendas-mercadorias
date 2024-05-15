/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package tela;

import apoio.Formatacao;
import dao.ProdutoDAO;
import entidade.Produto;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author gabri
 */
public class IfrProduto extends javax.swing.JInternalFrame {

    int idProduto = 0;

    /**
     * Creates new form NewJInternalFrame
     */
    public IfrProduto() {
        initComponents();
        
        tffValorUnitarioProduto.setText(Formatacao.formatarDecimal2casasRS(0));

        new ProdutoDAO().popularTabela(tblProduto, "");

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnFechar = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        tfdConsulta = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProduto = new javax.swing.JTable();
        jlbBusca = new javax.swing.JLabel();
        TfdConsultarProduto = new javax.swing.JTextField();
        btnPesquisar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tfdDescricaoProduto = new javax.swing.JTextField();
        tffValorUnitarioProduto = new javax.swing.JFormattedTextField();
        jLabel3 = new javax.swing.JLabel();
        tfdQntdEstoqueProduto = new javax.swing.JTextField();
        btnConsultar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();

        setTitle("Produto");
        setToolTipText("");

        btnFechar.setText("Fechar");
        btnFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFecharActionPerformed(evt);
            }
        });

        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        tblProduto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblProduto);

        jlbBusca.setText("Busca:");

        btnPesquisar.setText("Pesquisar");
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout tfdConsultaLayout = new javax.swing.GroupLayout(tfdConsulta);
        tfdConsulta.setLayout(tfdConsultaLayout);
        tfdConsultaLayout.setHorizontalGroup(
            tfdConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tfdConsultaLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 645, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(tfdConsultaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlbBusca)
                .addGap(18, 18, 18)
                .addComponent(TfdConsultarProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnPesquisar)
                .addGap(26, 26, 26))
        );
        tfdConsultaLayout.setVerticalGroup(
            tfdConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tfdConsultaLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(tfdConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlbBusca)
                    .addComponent(TfdConsultarProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPesquisar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 292, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Listagem", tfdConsulta);

        jLabel1.setText("Descrição");

        jLabel2.setText("Valor Unitário (R$) :");

        tffValorUnitarioProduto.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tffValorUnitarioProdutoFocusLost(evt);
            }
        });

        jLabel3.setText("Quantidade em estoque:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfdDescricaoProduto)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(tffValorUnitarioProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(tfdQntdEstoqueProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 215, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tfdDescricaoProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tffValorUnitarioProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(tfdQntdEstoqueProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(227, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Manuntenção", jPanel2);

        btnConsultar.setText("Consultar");
        btnConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarActionPerformed(evt);
            }
        });

        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jTabbedPane1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(btnConsultar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnExcluir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnEditar)
                        .addGap(18, 18, 18)
                        .addComponent(btnSalvar)
                        .addGap(18, 18, 18)
                        .addComponent(btnFechar)))
                .addGap(24, 24, 24))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnFechar)
                    .addComponent(btnSalvar)
                    .addComponent(btnConsultar)
                    .addComponent(btnEditar)
                    .addComponent(btnExcluir))
                .addGap(21, 21, 21))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFecharActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnFecharActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        //declarando as variaveis
        String descricao = tfdDescricaoProduto.getText();
        double valor_unitario = Double.parseDouble(tffValorUnitarioProduto.getText().replace("R$", "" ).replace(',', '.'));
        String qntd_estoque = tfdQntdEstoqueProduto.getText();

        //Criação do objeto compra
        Produto produto = new Produto();
        produto.setId(idProduto);
        produto.setDescricao(descricao);
        produto.setValor_unitario(valor_unitario);
        produto.setQntd_estoque(qntd_estoque);

        //Criação do objeto cidadeDAO
        ProdutoDAO produtoDAO = new ProdutoDAO();

        if (idProduto == 0) {

            if (produtoDAO.salvar(produto) == null) {  //Representa uma inserção
                tfdDescricaoProduto.setText("");
                tffValorUnitarioProduto.setText("");
                tfdQntdEstoqueProduto.setText("");

                JOptionPane.showMessageDialog(this, "Produto registrado com sucesso!");

                tfdDescricaoProduto.requestFocus();
            } else {
                JOptionPane.showMessageDialog(this, "Problemas no registro de Produto");
            }
        } else {
            if (produtoDAO.atualizar(produto) == null) {  //Representa uma inserção
                tfdDescricaoProduto.setText("");
                tffValorUnitarioProduto.setText("");
                tfdQntdEstoqueProduto.setText("");

                JOptionPane.showMessageDialog(this, "Produto atualizada com sucesso!");

                tfdDescricaoProduto.requestFocus();
            }
        }

        idProduto = 0;
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarActionPerformed
        ArrayList<Produto> produtos = new ArrayList();

        produtos = new ProdutoDAO().consultarTodos();

        for (int i = 0; i < produtos.size(); i++) {
            System.out.println("Id: " + produtos.get(i).getId());
            System.out.println("descrição: " + produtos.get(i).getDescricao());
            System.out.println("valor unitario: " + produtos.get(i).getValor_unitario());
            System.out.println("quantidade estoque: " + produtos.get(i).getQntd_estoque());
            System.out.println("");
        }
    }//GEN-LAST:event_btnConsultarActionPerformed

    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed
        new ProdutoDAO().popularTabela(tblProduto, TfdConsultarProduto.getText());
    }//GEN-LAST:event_btnPesquisarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        String idTabela = String.valueOf(tblProduto.getValueAt(tblProduto.getSelectedRow(), 0));

        idProduto = Integer.parseInt(idTabela);

        Produto produto = new ProdutoDAO().consultarId(idProduto);

        if (produto != null) {
            jTabbedPane1.setSelectedIndex(1);

            tfdDescricaoProduto.setText(produto.getDescricao());
            tffValorUnitarioProduto.setText(Double.toString(produto.getValor_unitario()));
            tfdQntdEstoqueProduto.setText("");

            tfdDescricaoProduto.requestFocus();
        } else {
            JOptionPane.showMessageDialog(this, "Id do Produto não encontrado!");
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        String idTabela = String.valueOf(tblProduto.getValueAt(tblProduto.getSelectedRow(), 0));

        idProduto = Integer.parseInt(idTabela);

        if (new ProdutoDAO().excluir(idProduto) == null) {
            JOptionPane.showMessageDialog(this, "Produto excluido com sucesso!");

            new ProdutoDAO().popularTabela(tblProduto, "");
        } else {
            JOptionPane.showMessageDialog(this, "Problemas aos excluir");
        }
        idProduto = 0;
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void tffValorUnitarioProdutoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tffValorUnitarioProdutoFocusLost
        String valorUnitario = tffValorUnitarioProduto.getText();
        if (!valorUnitario.startsWith("R$")) {
            tffValorUnitarioProduto.setText("R$" + valorUnitario);
        }


    }//GEN-LAST:event_tffValorUnitarioProdutoFocusLost


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField TfdConsultarProduto;
    private javax.swing.JButton btnConsultar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnFechar;
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel jlbBusca;
    private javax.swing.JTable tblProduto;
    private javax.swing.JPanel tfdConsulta;
    private javax.swing.JTextField tfdDescricaoProduto;
    private javax.swing.JTextField tfdQntdEstoqueProduto;
    private javax.swing.JFormattedTextField tffValorUnitarioProduto;
    // End of variables declaration//GEN-END:variables
}
