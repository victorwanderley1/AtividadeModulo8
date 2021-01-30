package atividademodulo8;

/**
 *
 * @author Victor
 */
public abstract class Conta {
    public Cliente cliente;
    protected int numeroAgencia;
    protected int numeroConta;
    protected double saldo;
    

    public Conta(Cliente cliente, int numeroAgencia, int numeroConta, double saldo) {
        this.cliente = cliente;
        this.numeroAgencia = numeroAgencia;
        this.numeroConta = numeroConta;
        this.saldo = saldo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public int getNumeroAgencia() {
        return numeroAgencia;
    }

    public void setNumeroAgencia(int numeroAgencia) {
        this.numeroAgencia = numeroAgencia;
    }

    public int getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(int numeroConta) {
        this.numeroConta = numeroConta;
    }

    public abstract double getSaldo();

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    
    public boolean depositar(double valorDeposito){
        try{
            this.saldo +=  valorDeposito;
            return true;
        }catch (NullPointerException e){
            System.out.println("Erro: "+e);
            return false;
        }
    }

    @Override
    public String toString() {
        return "\nCliente: "+cliente.getNome()+
                "\nNúmero da Agência: "+this.getNumeroAgencia()+
                "\nNúmero da Conta: "+this.getNumeroConta();
    }
    
    
}
