package atividademodulo8;


/**
 *
 * @author Victor
 */
public class ClassePrincipal {
    public static void main(String[] args) {

        MenuBanco menu = new MenuBanco();
        menu.banco.addCliente("Victor Wanderley");
        menu.banco.addCliente("Vanessa Barros");
        menu.banco.addCliente("Pedro Silva");
        menu.banco.addCliente("Maria Santos");
        menu.banco.addCliente("Joaquina Amaral");
        menu.banco.getClientesDoBanco().get("Victor Wanderley").abrirContaCorrente(1, 139, 2500, 800);
        menu.banco.getClientesDoBanco().get("Victor Wanderley").abrirContaPoupanca(1, 255, 1000, 17, 0.5);
        menu.banco.getClientesDoBanco().get("Victor Wanderley").abrirContaSalario(1, 245, 2000, 10);
        menu.banco.getClientesDoBanco().get("Vanessa Barros").abrirContaCorrente(1, 123, 3000, 1000);
        menu.banco.getClientesDoBanco().get("Vanessa Barros").abrirContaPoupanca(1, 119, 2000, 29, 0.5);
        menu.banco.getClientesDoBanco().get("Pedro Silva").abrirContaCorrente(1, 124, 1200, 800);
        menu.banco.getClientesDoBanco().get("Maria Santos").abrirContaSalario(1, 149, 1100, 10);
        menu.banco.getClientesDoBanco().get("Joaquina Amaral").abrirContaSalario(1, 177, 1199, 10);
        
        menu.menuPrincipal();
    
    }
}
