package atividademodulo8;

/**
 * 
 * @author Victor
 */
public class ContaPoupanca extends Conta implements Comparable<Conta>{
    private final int diaAniversario;
    private final double taxaDeJuros;

    public ContaPoupanca(Cliente cliente, int numeroAgencia, int numeroConta, 
            double saldo, int diaAniversario, double taxaDeJuros) {
        super(cliente, numeroAgencia, numeroConta, saldo);
        this.diaAniversario = diaAniversario;
        this.taxaDeJuros = taxaDeJuros;
        super.tipoDeConta = "Conta Poupança";
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

    @Override
    public boolean sacar(double valorSaque) {
        if (verificarPossibilidadeSaque(valorSaque)){
            this.saldo -= valorSaque;
            return true;
        } else return false;
    }
    
    public boolean verificarPossibilidadeSaque(double valorSaque){
        return valorSaque <= this.saldo;
    }

    @Override
    public int compareTo(Conta o) {
        return 1;
    }
}
