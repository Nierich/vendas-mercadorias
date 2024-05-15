/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidade;

/**
 *
 * @author gabri
 */
public class Produto {
    
    int id;
    String descricao;
    double valor_unitario;
    String qntd_estoque;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValor_unitario() {
        return valor_unitario;
    }

    public void setValor_unitario(double valor_unitario) {
        this.valor_unitario = valor_unitario;
    }

    public String getQntd_estoque() {
        return qntd_estoque;
    }

    public void setQntd_estoque(String qntd_estoque) {
        this.qntd_estoque = qntd_estoque;
    }
    
}
