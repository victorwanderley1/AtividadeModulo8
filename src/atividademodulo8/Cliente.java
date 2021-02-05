package atividademodulo8;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Victor
 */
public class Cliente {
    public String nome;
    List<Conta> listaDeContas = new ArrayList();
    
    public Cliente(String nome){
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Conta> getListaDeContas() {
        return listaDeContas;
    }

    public void addConta(Conta conta) {
        this.listaDeContas.add(conta);
    }

}
