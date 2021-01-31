package atividademodulo8;

/**
 *
 * @author Victor-Vanessa
 */
public class ContaCorrente extends Conta implements Tributavel{
    protected double chequeEspecial;

    public ContaCorrente(Cliente cliente, int numeroAgencia, int numeroConta, 
            double saldo, double chequeEspecial) {
        super(cliente, numeroAgencia, numeroConta, saldo);
        this.chequeEspecial = chequeEspecial;
    }

    @Override
    public double getSaldo() {
        return this.saldo + chequeEspecial;
    }
    
    public boolean sacar(double valorSaque){
        switch (verificarPossibilidadeSaque(valorSaque)){
            case 1:
                this.saldo -= valorSaque;
                return true;
                
            case 2:
                valorSaque -= this.saldo;
                this.saldo = 0;
                chequeEspecial -= valorSaque;
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
    public double valorImpostoTransferencia() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public double valorImpostoManutencaoDaConta() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public String toString(){
        return super.toString() +
                "\nSaldo em conta: R$ "+String.format("%.2f", this.saldo)+
                "\nSaldo Cheque-Especial: R$ "+String.format("%.2f", this.chequeEspecial);
    }
}
