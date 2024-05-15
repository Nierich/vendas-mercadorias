/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import apoio.ConexaoBD;
import apoio.IDAOT;
import entidade.Fornecedor;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author gabri
 */
public class FornecedorDAO  implements IDAOT<Fornecedor>  {

    @Override
    public String salvar(Fornecedor o) {
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "insert into fornecedor "
                    + "values"
                    + "(default, "
                    + "'" + o.getNome()+ "', "
                    + "'" + o.getEmail()+ "', "
                    + "'" + o.getTelefone()+ "', "
                    + "'" + o.getCnpj()+ "');";

            System.out.println("SQL: " + sql);

            int retorno = st.executeUpdate(sql);

            return null;

        } catch (Exception e) {
            System.out.println("Erro ao inserir Fornecedor " + e);
            return e.toString();
        }
    }

    @Override
    public String atualizar(Fornecedor o) {
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "update fornecedor SET "
                    + "nome = '" + o.getNome() + "', "
                    + "email = '" + o.getEmail() + "', "
                    + "telefone = '" + o.getTelefone() + "', "
                    + "cnpj = '" + o.getCnpj() + "' "
                    + "where id = " + o.getId();
            
            System.out.println("SQL: " + sql);

            int retorno = st.executeUpdate(sql);

            return null;

        } catch (Exception e) {
            System.out.println("Erro ao atualizar Fornecedor " + e);
            return e.toString();
        }
    }

    @Override
    public String excluir(int id) {
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "delete from fornecedor "
                    + "where id = " + id;

            System.out.println("SQL: " + sql);

            int retorno = st.executeUpdate(sql);

            return null;

        } catch (Exception e) {
            System.out.println("Erro ao excluir Fornecedor: " + e);
            return e.toString();
        }
    }

    @Override
    public ArrayList<Fornecedor> consultarTodos() {
        ArrayList<Fornecedor> fornecedores = new ArrayList();
        
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = ""
                    + "select * "
                    + "from fornecedor "
                    + "order by id";

            System.out.println("SQL: " + sql);

            ResultSet retorno = st.executeQuery(sql);
            
            while (retorno.next()) {
                Fornecedor fornecedor = new Fornecedor();
                
                fornecedor.setId(retorno.getInt("id"));
                fornecedor.setNome(retorno.getString("nome"));
                fornecedor.setEmail(retorno.getString("email"));
                fornecedor.setTelefone(retorno.getString("telefone"));
                fornecedor.setCnpj(retorno.getString("cnpj"));
                
                fornecedores.add(fornecedor);                
            }


        } catch (Exception e) {
            System.out.println("Erro ao consultar Fornecedores: " + e);
        }
        
        return fornecedores;
    }

    @Override
    public ArrayList<Fornecedor> consultar(String criterio) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Fornecedor consultarId(int id) {
        Fornecedor fornecedor = null;

        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = ""
                    + "select * "
                    + "from fornecedor "
                    + "where id = " + id;

            System.out.println("SQL: " + sql);

            ResultSet retorno = st.executeQuery(sql);

            while (retorno.next()) {
                fornecedor = new Fornecedor();

                fornecedor.setId(retorno.getInt("id"));
                fornecedor.setNome(retorno.getString("nome"));
                fornecedor.setEmail(retorno.getString("email"));
                fornecedor.setTelefone(retorno.getString("telefone"));
                fornecedor.setCnpj(retorno.getString("cnpj"));
            }

        } catch (Exception e) {
            System.out.println("Erro ao consultar FORNECEDOR: " + e);
        }

        return fornecedor;
    }
    public void popularTabela(JTable tabela, String criterio) {
        
        ResultSet resultadoQ;
        
        // dados da tabela
        Object[][] dadosTabela = null;

        // cabecalho da tabela
        Object[] cabecalho = new Object[5];
        cabecalho[0] = "Id";
        cabecalho[1] = "Nome";
        cabecalho[2] = "Email";
        cabecalho[3] = "Telefone";
        cabecalho[4] = "Cnpj";
        
         

        // cria matriz de acordo com nº de registros da tabela
        try {
            resultadoQ = ConexaoBD.getInstance().getConnection().createStatement().executeQuery(""
                    + "SELECT * "
                    + "FROM fornecedor "
                    + "WHERE "
                    + "NOME ILIKE '%" + criterio + "%' "
                    + "OR EMAIL ILIKE '%" + criterio + "%'"
                    + "OR TELEFONE ILIKE '%" + criterio + "%'"
                    + "OR CNPJ ILIKE '%" + criterio + "%'"        
                    + "ORDER BY id");

            resultadoQ.next();

            dadosTabela = new Object[resultadoQ.getInt(1)][5];

        } catch (Exception e) {
            System.out.println("Erro ao consultar fornecedores: " + e);
        }

        int lin = 0;

        // efetua consulta na tabela
        try {
            resultadoQ = ConexaoBD.getInstance().getConnection().createStatement().executeQuery(""
                    + "SELECT * "
                    + "FROM fornecedor "
                    + "WHERE "
                    + "NOME ILIKE '%" + criterio + "%' "
                    + "OR EMAIL ILIKE '%" + criterio + "%' "
                    + "OR TELEFONE ILIKE '%" + criterio + "%'"
                    + "OR CNPJ ILIKE '%" + criterio + "%'");
            

            while (resultadoQ.next()) {

                dadosTabela[lin][0] = resultadoQ.getInt("id");
                dadosTabela[lin][1] = resultadoQ.getString("nome");
                dadosTabela[lin][2] = resultadoQ.getString("email");
                dadosTabela[lin][3] = resultadoQ.getString("telefone");
                dadosTabela[lin][4] = resultadoQ.getString("cnpj");

                // caso a coluna precise exibir uma imagem
//                if (resultadoQ.getBoolean("Situacao")) {
//                    dadosTabela[lin][2] = new ImageIcon(getClass().getClassLoader().getResource("Interface/imagens/status_ativo.png"));
//                } else {
//                    dadosTabela[lin][2] = new ImageIcon(getClass().getClassLoader().getResource("Interface/imagens/status_inativo.png"));
//                }
                lin++;
            }
        } catch (Exception e) {
            System.out.println("problemas para popular tabela...");
            System.out.println(e);
        }

        // configuracoes adicionais no componente tabela
        tabela.setModel(new DefaultTableModel(dadosTabela, cabecalho) {
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
