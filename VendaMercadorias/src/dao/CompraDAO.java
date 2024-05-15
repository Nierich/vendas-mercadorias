/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import apoio.ConexaoBD;
import apoio.IDAOT;
import entidade.Compra;
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
public class CompraDAO implements IDAOT<Compra> {

    @Override
    public String salvar(Compra o) {
        
        String retornoConsulta = "";
        
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "insert into compra "
                    + "values"
                    + "(default, "
                    + "'" + o.getData()+ "', "
                    + "'" + o.getFornecedor_id()+ "')returning id; ";

            System.out.println("SQL: " + sql);

            ResultSet retorno = st.executeQuery(sql);

            if (retorno.next()) 
                retornoConsulta = retorno.getString(1);
 
        } catch (Exception e) {
            System.out.println("Erro ao inserir OS: " + e);
            retornoConsulta = "ERROR:" + e.toString();
        }
        return retornoConsulta;
    }

    @Override
    public String atualizar(Compra o) {
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "update compra SET "
                    + "data = '" + o.getData() + "', "
                    + "fornecedor_id = '" + o.getFornecedor_id() + "' "
                    + "where id = " + o.getId();
            
            System.out.println("SQL: " + sql);

            int retorno = st.executeUpdate(sql);

            return null;

        } catch (Exception e) {
                System.out.println("Erro ao atualizar Compra " + e);
            return e.toString();
        }
    }

    @Override
    public String excluir(int id) {
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "delete from compra "
                    + "where id = " + id;

            System.out.println("SQL: " + sql);

            int retorno = st.executeUpdate(sql);

            return null;

        } catch (Exception e) {
            System.out.println("Erro ao excluir Compra: " + e);
            return e.toString();
        }
    }

    @Override
    public ArrayList<Compra> consultarTodos() {
        ArrayList<Compra> compras = new ArrayList();
        
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = ""
                    + "select * "
                    + "from compra "
                    + "order by id";

            System.out.println("SQL: " + sql);

            ResultSet retorno = st.executeQuery(sql);
            
            while (retorno.next()) {
                Compra compra = new Compra();
                
                compra.setId(retorno.getInt("id"));
                compra.setData(retorno.getString("data"));
                compra.setFornecedor_id(retorno.getInt("fornecedor_id"));
                
                compras.add(compra);                
            }


        } catch (Exception e) {
            System.out.println("Erro ao consultar Compras: " + e);
        }
        
        return compras;
    }

    @Override
    public ArrayList<Compra> consultar(String criterio) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Compra consultarId(int id) {
        Compra compra = null;

        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = ""
                    + "select * "
                    + "from compra "
                    + "where id = " + id;

            System.out.println("SQL: " + sql);

            ResultSet retorno = st.executeQuery(sql);

            while (retorno.next()) {
                compra = new Compra();
                
                compra.setId(retorno.getInt("id"));
                compra.setData(retorno.getString("data"));
                compra.setFornecedor_id(retorno.getInt("fornecedor_id"));
            }

        } catch (Exception e) {
            System.out.println("Erro ao consultar: " + e);
        }

        return compra;
    }
    
    public void popularTabela(JTable tabela, String criterio) {
        
        ResultSet resultadoQ;

        // Dados da Tabela
        ArrayList<Object[]> dadosTabela = new ArrayList<>();

        // Cabecalho da tabela
        Object[] cabecalho = new Object[3];
        cabecalho[0] = "ID - compra";
        cabecalho[1] = "Data";
        cabecalho[2] = "Fornecedor";

        //Efetua a consulta na Tabela
        try {
            resultadoQ = ConexaoBD.getInstance().getConnection().createStatement().executeQuery(""
                    
                   
                        + "SELECT "
                        + "compra.id, "
                        + "compra.data, "
                        + "fornecedor.nome "
                        + "FROM fornecedor, compra "
                        + "WHERE compra.fornecedor_id = fornecedor.id "
                        + "AND compra.data ILIKE '%" + criterio + "%' "
                        + "ORDER BY compra.id ");
            
            
            while (resultadoQ.next()) {
                Object[] linha = new Object[3];
                linha[0] = resultadoQ.getInt("id");
                linha[1] = resultadoQ.getString("data");
                linha[2] = resultadoQ.getString("nome");
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
