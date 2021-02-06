package atividademodulo8;

/**
 *
 * @author Victor
 */
public class ContaSalario extends Conta implements Comparable<Conta>{
    private final int limiteSaques;
    public int quantSaques;

    public ContaSalario(Cliente cliente, int numeroAgencia, int numeroConta,
            double saldo, int limiteSaques) {
        super(cliente, numeroAgencia, numeroConta, saldo);
        this.limiteSaques = limiteSaques;
        this.quantSaques = 0;
    }

    @Override
    public boolean sacar(double valorSaque) {
        if (verificarPossibilidadeSaque(valorSaque)){
            this.saldo -= valorSaque;
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
}
