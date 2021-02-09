package atividademodulo8;

import java.util.Hashtable;

/**
 *
 * @author Victor
 */
public class Banco {
    private Hashtable<String, Cliente> clientesDoBanco = new Hashtable();
    
    public Hashtable<String, Cliente> getClientesDoBanco(){
        return this.clientesDoBanco;
    }
    
    public void addCliente(String nomeCliente){
        if(!this.getClientesDoBanco().containsKey(nomeCliente)){
            Cliente cliente = new Cliente(nomeCliente);
            this.getClientesDoBanco().put(cliente.getNome(), cliente);
            System.out.println("Cadastro Realizado Com Sucesso!");
        }else System.out.println("Cliente já cadastrado");
    }
}
