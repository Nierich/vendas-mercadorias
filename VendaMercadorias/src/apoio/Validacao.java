/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package apoio;

import java.awt.Color;
import javax.swing.JTextField;

/**
 *
 * @author Fabricio Pretto
 */
public class Validacao {

    private static final int[] pesoCPF = {11, 10, 9, 8, 7, 6, 5, 4, 3, 2};
    private static final int[] pesoCNPJ = {6, 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};
    private static int[] dddsTelefoneBrasil = {11, 12, 13, 14, 15, 16, 17, 18, 19, 21, 22, 24, 27, 28, 31, 32, 33, 34, 35, 37, 38, 41, 42, 43, 44, 45, 46, 47, 48, 49, 51, 53, 54, 55, 61, 62, 63, 64, 65, 66, 67, 68, 69, 71, 73, 74, 75, 77, 79, 81, 82, 83, 84, 85, 86, 87, 88, 89, 91, 92, 93, 94, 95, 96, 97, 98, 99};

    private static int calcularDigito(String str, int[] peso) {
        int soma = 0;
        for (int indice = str.length() - 1, digito; indice >= 0; indice--) {
            digito = Integer.parseInt(str.substring(indice, indice + 1));
            soma += digito * peso[peso.length - str.length() + indice];
        }
        soma = 11 - soma % 11;
        return soma > 9 ? 0 : soma;
    }

    public static boolean validarCPF(String cpf) {
        
        if ((cpf == null) || (cpf.length() != 11)) {
            return false;
        }
        Integer digito1 = calcularDigito(cpf.substring(0, 9), pesoCPF);
        Integer digito2 = calcularDigito(cpf.substring(0, 9) + digito1, pesoCPF);
        return cpf.equals(cpf.substring(0, 9) + digito1.toString() + digito2.toString());
    }

    public static boolean validarCNPJ(String cnpj) {
        if ((cnpj == null) || (cnpj.length() != 14)) {
            return false;
        }
        Integer digito1 = calcularDigito(cnpj.substring(0, 12), pesoCNPJ);
        Integer digito2 = calcularDigito(cnpj.substring(0, 12) + digito1, pesoCNPJ);
        return cnpj.equals(cnpj.substring(0, 12) + digito1.toString() + digito2.toString());
    }

    public static boolean validarDataDMA (int d, int m, int a) {
        
        boolean correto = true;
        
        int[] dias = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        
        if (a < 0 || m < 1 || m > 12) {
            correto = false;
        } else {
            // valida o dia
            if (a % 4 == 0 && (a % 100 != 0 || a % 400 == 0)) {
                dias[1] = 29;
            }
            if (d < 1 || d > dias[m - 1]) {
                correto = false;
            }
        }
        return (correto);
    }

    public static boolean validarDataFormatada (String dataComFormato) {
        try{
            String[] data = dataComFormato.split("/");
            return (validarDataDMA(Integer.parseInt(data[0]), Integer.parseInt(data[1]), Integer.parseInt(data[2])));
        }
        catch(NumberFormatException e) {
            return false;
        }
    }

    public static boolean validarTelefone(String telefone) {
        if (telefone.trim().length() != 11) {
            return false;
        }

        int ddd = Integer.parseInt(telefone.substring(0, 2));
        boolean dddMatch = false;
        for (int i = 0; i < dddsTelefoneBrasil.length; i++) {
            if (ddd == dddsTelefoneBrasil[i]) {
                dddMatch = true;
                break;
            }
        }

        if (!dddMatch) {
            return false;
        } else {
            return true;
        }
    }
    
    public static boolean validarCEP(String cep) {
        if ((cep == null) || (cep.length() != 8)) {
            return false;
        } else {
            return true;
        }
    }
    //Valida se o usuario está digitando apenas um @. Deve conter "@" e "." no email.
    public static boolean validarEmail(JTextField campo) {
        // Verificar se o email contém exatamente um caractere "@"
        int quantidadeArrobas = 0;
        for (int i = 0; i < campo.getText().length(); i++) {
            if (campo.getText().charAt(i) == '@') {
                quantidadeArrobas++;
            }
        }
        if (quantidadeArrobas != 1) {
            campo.setBackground(Color.decode("#FF9696"));
            return false;
        }

        // Verificar se o email contém pelo menos um ponto após o "@"
        int posicaoArroba = campo.getText().indexOf("@");
        int posicaoUltimoPonto = campo.getText().lastIndexOf(".");
        if (posicaoUltimoPonto < posicaoArroba) {
            campo.setBackground(Color.decode("#FF9696"));
            return false;
        }

        campo.setBackground(Color.white);
        return true;
    }
}
