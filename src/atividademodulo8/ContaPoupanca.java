package atividademodulo8;

/**
 * 
 * @author Victor-Vanessa
 */
public class ContaPoupanca extends Conta{
    private final int diaAniversario;
    private final double taxaDeJuros;

    public ContaPoupanca(Cliente cliente, int numeroAgencia, int numeroConta, 
            double saldo, int diaAniversario, double taxaDeJuros) {
        super(cliente, numeroAgencia, numeroConta, saldo);
        this.diaAniversario = diaAniversario;
        this.taxaDeJuros = taxaDeJuros;
    }
    
    public double getSaldo(int dia) {
        if (dia >= diaAniversario) return this.saldo+=(this.saldo*taxaDeJuros);
        else return this.saldo;
    }
    
    @Override
    public String toString(){
        return super.toString() +
                "\nSaldo em conta: R$ "+String.format("%.2f", this.saldo);
    }
    
}
