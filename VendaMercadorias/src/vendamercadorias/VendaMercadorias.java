/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package vendamercadorias;

import apoio.ConexaoBD;
import java.sql.Connection;
import javax.swing.JOptionPane;
import tela.DlgLogin;

/**
 *
 * @author gabri
 */
public class VendaMercadorias {
    
    static Connection conexao = null;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        
         if (ConexaoBD.getInstance().getConnection() != null) {
            new DlgLogin(null, true).setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Erro ao conectar no Banco de Dados!");
        }
    }
}
