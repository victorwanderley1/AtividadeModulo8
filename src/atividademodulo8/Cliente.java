package atividademodulo8;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Victor
 */
public class Cliente {
    public final int CONTACORRENTE = 0;
    public final int CONTAPOUPANCA = 1;
    public final int CONTASALARIO = 2;
    
    
    public String nome;
    private boolean verifiContaCorrente;
    private boolean verifiContaPoupanca;
    private boolean verifiContaSalario;
    private List<Conta> listaDeContas = new ArrayList();
    
    public Cliente(String nome){
        this.nome = nome;
        this.verifiContaCorrente = false;
        this.verifiContaPoupanca = false;
        this.verifiContaSalario = false;
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
    
    public double getSaldoTotalCliente(){
        double saldoTotal = 0;
        for (Conta conta: getListaDeContas()){
            saldoTotal += conta.getSaldo();
        }
        return saldoTotal;
    }
    
    /**
     * Cria uma instância de uma conta corrente e adiciona à listaDeContas do Cliente
     * @param numeroAgencia
     * @param numeroConta
     * @param saldo
     * @param chequeEspecial
     * @return retorna false caso o cliente já tenha uma conta poupança
     */
    public boolean abrirContaCorrente(int numeroAgencia, int numeroConta, 
            double saldo, double chequeEspecial){
        if(!this.verifiContaPoupanca){
            ContaCorrente contaCorrente = new ContaCorrente(this, numeroAgencia,
                numeroConta, saldo, chequeEspecial);
            addConta(contaCorrente);
            this.verifiContaCorrente = false;
            return true;
        }else return false;
        
    }
    
    /**
     * Cria uma instância de uma conta poupança e adiciona à listaDeContas do Cliente
     * @param numeroAgencia
     * @param numeroConta
     * @param saldo
     * @param diaAniversario
     * @param taxaDeJuros
     * @return retorna false caso o cliente já tenha uma conta poupança
     */
    public boolean abrirContaPoupanca(int numeroAgencia, int numeroConta, 
            double saldo, int diaAniversario, double taxaDeJuros){
        
        if(!this.verifiContaPoupanca){
            ContaPoupanca contaPoupanca = new ContaPoupanca(this, numeroAgencia, numeroConta,
                saldo, diaAniversario, taxaDeJuros);
            addConta(contaPoupanca);
            this.verifiContaPoupanca = true;
            return true;
        }else return false;
    }
    
    /**
     * Cria uma instância de uma conta salário e adiciona à listaDeContas do Cliente
     * 
     * @param numeroAgencia
     * @param numeroConta
     * @param saldo
     * @param limiteSaques
     * @return retorna false caso o cliente já tenha uma conta salário 
     */
    public boolean abrirContaSalario(int numeroAgencia, int numeroConta,
            double saldo, int limiteSaques){
        if (!this.verifiContaSalario){
            ContaSalario contaSalario = new ContaSalario(this, numeroAgencia,
                    numeroConta, saldo, limiteSaques);
            addConta(contaSalario);
            this.verifiContaSalario = true;
            return true;
        } else return false;
    }

}
