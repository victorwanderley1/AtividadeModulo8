package atividademodulo8;

/**
 *
 * @author Victor-Vanessa
 */
public class ContaCorrente extends Conta implements Tributavel, Comparable<Conta>{
    protected double chequeEspecial;

    public ContaCorrente(Cliente cliente, int numeroAgencia, int numeroConta, 
            double saldo, double chequeEspecial) {
        super(cliente, numeroAgencia, numeroConta, saldo);
        this.chequeEspecial = chequeEspecial;
        super.tipoDeConta = "Conta Corrente";
    }

    @Override
    public double getSaldo() {
        return this.saldo + chequeEspecial;
    }
    
    @Override
    public boolean sacar(double valorSaque){
        switch (verificarPossibilidadeSaque(valorSaque)){
            case 1:
                this.saldo -= valorSaque;
                this.saldo -= valorImpostoMovimentacao(valorSaque); // Subtrai o imposto caso o valor de saque seja aprovado.
                return true;
                
            case 2:
                valorSaque -= this.saldo;
                this.saldo = 0;
                chequeEspecial -= valorSaque;
                this.saldo -= valorImpostoMovimentacao(valorSaque); // Subtrai o imposto caso o valor de saque seja aprovado com cheque especial. Conta ficará com saldo negativo.
                return true;
                
            default: 
                System.out.println("Saldo Insuficiente!");
                return false;
        }
    }
    
    public int verificarPossibilidadeSaque(double valorSaque){
        if (valorSaque <= this.saldo) return 1;
        else if (valorSaque <= getSaldo()) return 2;
        else return 3;
    }

    @Override
    public double valorImpostoMovimentacao(double valor) {
        return 0.018*valor;
    }

    @Override
    public String toString(){
        return super.toString() +
                "\nSaldo em conta: R$ "+String.format("%.2f", this.saldo)+
                "\nSaldo Cheque-Especial: R$ "+String.format("%.2f", this.chequeEspecial);
    }
    
    @Override
    public int compareTo(Conta o) {
        return 0;
    }
}
