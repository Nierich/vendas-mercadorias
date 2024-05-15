/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import apoio.ConexaoBD;
import apoio.Formatacao;
import apoio.IDAOT;
import entidade.ItemCompra;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**S
 *
 * @author gabri
 */
public class ItemCompraDAO  implements IDAOT<ItemCompra>{

    @Override
    public String salvar(ItemCompra o) {
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "insert into item_compra "
                    + "values"
                    + "(default, "
                    + "'" + o.getCompra_id() + "', "
                    + "'" + o.getProduto_id() + "', "
                    + "'" + o.getQtde() + "', "
                    + "" + o.getValor()+ ") ";

            System.out.println("SQL: " + sql);

            int retorno = st.executeUpdate(sql);

            return null;

        } catch (Exception e) {
            System.out.println("Erro ao inserir OS_Item: " + e);
            return e.toString();
        }
    }

    @Override
    public String atualizar(ItemCompra o) {
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "update item_compra SET "
                    + "compra_id = '" + o.getCompra_id()+ "', "
                    + "produto_id = '" + o.getProduto_id()+ "', "
                    + "qtde = '" + o.getQtde()+ "', "
                    + "valor = '" + o.getValor()+ "' "
                    + "where id = " + o.getId();
            
            System.out.println("SQL: " + sql);

            int retorno = st.executeUpdate(sql);

            return null;

        } catch (Exception e) {
            System.out.println("Erro ao atualizar Item " + e);
            return e.toString();
        }
    }

    @Override
    public String excluir(int id) {
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "delete "
                    + "from item_compra "
                    + "where "
                    + "id = " + id;

            System.out.println("SQL: " + sql);

            int retorno = st.executeUpdate(sql);

            return null;

        } catch (Exception e) {
            System.out.println("Erro ao excluir OS_Item: " + e);
            return e.toString();
        }
    }
    
     @Override
    public ArrayList<ItemCompra> consultarTodos() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<ItemCompra> consultar(String criterio) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ItemCompra consultarId(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void popularTabela(JTable tabela, String string, int idItemCompra) {
        
        ResultSet resultadoQ;

        // Dados da Tabela
        ArrayList<Object[]> dadosTabela = new ArrayList<>();

        // Cabecalho da tabela
        Object[] cabecalho = new Object[5];
        cabecalho[0] = "ID";
        cabecalho[1] = "ID - Produto";
        cabecalho[2] = "Produto";
        cabecalho[3] = "Quantidade";
        cabecalho[4] = "Valor(Unidade)";

        //Efetua a consulta na Tabela
        try {
            resultadoQ = ConexaoBD.getInstance().getConnection().createStatement().executeQuery(""
                    
                   
                        + "SELECT "
                        + "item_compra.id, "
                        + "produto.id AS produto_id, "
                        + "produto.descricao, " 
                        + "item_compra.qtde, "
                        + "item_compra.valor "
                        + "FROM item_compra, fornecedor, produto, compra "
                        + "WHERE item_compra.compra_id = compra.id "
                        + "AND item_compra.produto_id = produto.id "
                        + "AND fornecedor.id = compra.fornecedor_id "
                        + "AND item_compra.compra_id = " + idItemCompra);
            
            
            while (resultadoQ.next()) {
                Object[] linha = new Object[5];
                linha[0] = resultadoQ.getInt("id");
                linha[1] = resultadoQ.getString("produto_id");
                linha[2] = resultadoQ.getString("descricao");
                linha[3] = Formatacao.formatarDecimal(resultadoQ.getDouble("qtde"));
                linha[4] = Formatacao.formatarDecimal2casasRS(resultadoQ.getDouble("valor"));
                dadosTabela.add(linha);
            }
            
        } catch (Exception e) {
            System.out.println("problemas para popular tabela...");
            System.out.println(e);
        }

        // configuracoes adicionais no componente tabela
        tabela.setModel(new DefaultTableModel(dadosTabela.toArray(new Object[0][0]), cabecalho) {
            @Override
            // quando retorno for FALSE, a tabela nao é editavel
            public boolean isCellEditable(int row, int column) {
                return false;
                /*  
                 if (column == 3) {  // apenas a coluna 3 sera editavel
                 return true;
                 } else {
                 return false;
                 }
                 */
            }

            // alteracao no metodo que determina a coluna em que o objeto ImageIcon devera aparecer
            @Override
            public Class getColumnClass(int column) {

                if (column == 2) {
//                    return ImageIcon.class;
                }
                return Object.class;
            }
        });

        // permite selecao de apenas uma linha da tabela
        tabela.setSelectionMode(0);

        // redimensiona as colunas de uma tabela
        TableColumn column = null;
        for (int i = 0; i < tabela.getColumnCount(); i++) {
            column = tabela.getColumnModel().getColumn(i);
            switch (i) {
                case 0:
                    column.setPreferredWidth(17);
                    break;
                case 1:
                    column.setPreferredWidth(140);
                    break;
//                case 2:
//                    column.setPreferredWidth(14);
//                    break;
            }
        }
        // renderizacao das linhas da tabela = mudar a cor
//        jTable1.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
//
//            @Override
//            public Component getTableCellRendererComponent(JTable table, Object value,
//                    boolean isSelected, boolean hasFocus, int row, int column) {
//                super.getTableCellRendererComponent(table, value, isSelected,
//                        hasFocus, row, column);
//                if (row % 2 == 0) {
//                    setBackground(Color.GREEN);
//                } else {
//                    setBackground(Color.LIGHT_GRAY);
//                }
//                return this;
//            }
//        });
    }
    
}
