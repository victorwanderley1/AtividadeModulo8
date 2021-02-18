package atividademodulo8;

/**
 *
 * @author Victor
 */
public class ContaSalario extends Conta implements Tributavel, Comparable<Conta>{
    private final int limiteSaques;
    private int quantSaques;

    public ContaSalario(Cliente cliente, int numeroAgencia, int numeroConta,
            double saldo, int limiteSaques) {
        super(cliente, numeroAgencia, numeroConta, saldo);
        this.limiteSaques = limiteSaques;
        this.quantSaques = 0;
        super.tipoDeConta = "Conta Salário";
    }

    @Override
    public boolean sacar(double valorSaque) {
        if (verificarPossibilidadeSaque(valorSaque)){
            this.saldo -= valorSaque;
            this.saldo -= valorImpostoMovimentacao(valorSaque); // Subtrai o imposto caso o valor de saque seja aprovado. Conta ficará com saldo negativo caso seja zerada.
            return true;
        } else return false;
    }
    
    private boolean verificarPossibilidadeSaque(double valorSaque){
        if (verificarQuantidadeSaques()) {
            if(valorSaque <= this.saldo) return true;
            else {
                System.out.println("Saldo insuficiente!");
                return false;
            }
        }else {
            System.out.println("Limite de saques atingido!");
            return false;
        }
        
    }
    
    private boolean verificarQuantidadeSaques(){
        return this.quantSaques < this.limiteSaques;
    }
    
    @Override
    public String toString(){
        return super.toString()+
                "\nSaldo em conta: R$ "+String.format("%.2f", this.getSaldo())+
                "\nQuantidade de saques restantes: "+
                (this.limiteSaques-this.quantSaques);
    }
    
    @Override
    public int compareTo(Conta o) {
        return 2;
    }

    @Override
    public double valorImpostoMovimentacao(double valor) {
        return 0.018*valor;
    }
}
