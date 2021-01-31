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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
