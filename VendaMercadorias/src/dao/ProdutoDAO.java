/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import apoio.ConexaoBD;
import apoio.Formatacao;
import apoio.IDAOT;
import entidade.Produto;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.ResultSet;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author gabri
 */
public class ProdutoDAO implements IDAOT<Produto> {

    @Override
    public String salvar(Produto o) {
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "insert into produto "
                    + "values"
                    + "(default, "
                    + "'" + o.getDescricao()+ "', "
                    + "'" + o.getValor_unitario()+ "', "
                    + "'" + o.getQntd_estoque()+ "');";

            System.out.println("SQL: " + sql);

            int retorno = st.executeUpdate(sql);

            return null;

        } catch (Exception e) {
            System.out.println("Erro ao inserir Produto " + e);
            return e.toString();
        }
    }

    @Override
    public String atualizar(Produto o) {
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "update produto SET "
                    + "descricao = '" + o.getDescricao()+ "', "
                    + "valor_unitario = '" + o.getValor_unitario()+ "', "
                    + "qtde_estoque = '" + o.getQntd_estoque()+ "' "
                    + "where id = " + o.getId();
            
            System.out.println("SQL: " + sql);

            int retorno = st.executeUpdate(sql);

            return null;

        } catch (Exception e) {
            System.out.println("Erro ao atualizar Produto " + e);
            return e.toString();
        }
    }

    @Override
    public String excluir(int id) {
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "delete from produto "
                    + "where id = " + id;

            System.out.println("SQL: " + sql);

            int retorno = st.executeUpdate(sql);

            return null;

        } catch (Exception e) {
            System.out.println("Erro ao excluir Produto: " + e);
            return e.toString();
        }
    }

    @Override
    public ArrayList<Produto> consultarTodos() {
        ArrayList<Produto> produtos = new ArrayList();
        
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = ""
                    + "select * "
                    + "from produto "
                    + "order by id";

            System.out.println("SQL: " + sql);

            ResultSet retorno = st.executeQuery(sql);
            
            while (retorno.next()) {
                Produto produto = new Produto();
                
                produto.setId(retorno.getInt("id"));
                produto.setDescricao(retorno.getString("descricao"));
                produto.setValor_unitario(retorno.getDouble("valor_unitario"));
                produto.setQntd_estoque(retorno.getString("qtde_estoque"));
                
                produtos.add(produto);                
            }


        } catch (Exception e) {
            System.out.println("Erro ao consultar Produtos: " + e);
        }
        
        return produtos;
    }

    @Override
    public ArrayList<Produto> consultar(String criterio) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Produto consultarId(int id) {
        Produto produto = null;

        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = ""
                    + "select * "
                    + "from produto "
                    + "where id = " + id;

            System.out.println("SQL: " + sql);

            ResultSet retorno = st.executeQuery(sql);

            while (retorno.next()) {
                produto = new Produto();

                produto.setId(retorno.getInt("id"));
                produto.setDescricao(retorno.getString("descricao"));
                produto.setValor_unitario(retorno.getDouble("valor_unitario"));
                produto.setQntd_estoque(retorno.getString("qtde_estoque"));
            }

        } catch (Exception e) {
            System.out.println("Erro ao consultar PRODUTO: " + e);
        }

        return produto;
    }
    
    public void popularTabela(JTable tabela, String criterio) {
        
        ResultSet resultadoQ;

        // Dados da Tabela
        ArrayList<Object[]> dadosTabela = new ArrayList<>();

        // Cabecalho da tabela
        Object[] cabecalho = new Object[4];
        cabecalho[0] = "ID";
        cabecalho[1] = "Descrição";
        cabecalho[2] = "Valor Unitario";
        cabecalho[3] = "Quantidade em estoque";

        //Efetua a consulta na Tabela
        try {
            resultadoQ = ConexaoBD.getInstance().getConnection().createStatement().executeQuery(""
                    
                   
                        + "SELECT * "
                        + "FROM produto "
                        + "WHERE "
                        + "descricao ILIKE '%" + criterio + "%' "
                        + "OR qtde_estoque ILIKE '%" + criterio + "%' " 
                        + "ORDER BY id ");
            
            
            while (resultadoQ.next()) {
                Object[] linha = new Object[4];
                linha[0] = resultadoQ.getInt("id");
                linha[1] = resultadoQ.getString("descricao");
                linha[2] = Formatacao.formatarDecimal2casasRS(resultadoQ.getDouble("valor_unitario"));
                linha[3] = resultadoQ.getString("qtde_estoque");
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
