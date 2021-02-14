package atividademodulo8;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
/**
 *
 * @author Victor
 */
public class MenuBanco {
    Banco banco = new Banco();
    Scanner entradaTeclado = new Scanner(System.in);
    private boolean ativo = true;
    public void menuPrincipal(){
        while(ativo){
            System.out.println("\n-------Banco--Mananger--2.0-------");
            System.out.println("");
            System.out.println("Selecione uma opção abaixo:");
            System.out.println("(1) Cadastrar novo cliente");
            System.out.println("(2) Abrir nova conta");
            System.out.println("(3) Relatórios");
            System.out.println("(0) Encerrar programa");
            System.out.print("Digite a opção: ");
            int opcao = entradaTeclado.nextInt();
            switch (opcao){
                case 1:
                    menuCadastrarCliente();
                    break;
                case 2:
                    menuAbrirConta();
                    break;
                case 3:
                    System.out.println("\nQual relatório deseja receber? "
                            + "\n1) Clientes Cadastrados no banco"
                            + "\n2) - Saldo Total Em Banco ");
                    int opcaoRelatorio = entradaTeclado.nextInt();
                    menuRelatorio(opcaoRelatorio);
                    break;
                case 0:
                    entradaTeclado.close();
                    System.out.println("Opção 0");
                    this.ativo = false;
                    break;
                default:
                    break;
            }
        }
    }
    
    public void menuCadastrarCliente(){
        System.out.println("\nDigite o nome do cliente a ser cadastrado");
        banco.addCliente(entradaTeclado.next());
    }
    
    public void menuAbrirConta(){
        System.out.println("Selecione o cliente que deseja abrir a conta: \n");
        banco.getClientesDoBanco().values().stream().map(cliente -> cliente.getNome()).sorted().forEach(System.out::println);
        System.out.println("\nDigite o nome do cliente: ");
        String nomeCliente = entradaTeclado.next();
        if (banco.getClientesDoBanco().containsKey(nomeCliente)){
            System.out.println("\nSelecione o tipo  de conta: ");
            System.out.println("1 - Conta Corrente\n2 - Conta Poupança\n3 - Conta Salário");
            int tipoDeConta = entradaTeclado.nextInt();
            menuAberturaDeConta(nomeCliente, tipoDeConta);
        }
        
    }
    
    private void menuAberturaDeConta(String nomeCliente, int tipoDeConta){
        switch (tipoDeConta){
            case 1:
                System.out.println("\n\n\n");
                System.out.println("Digite os dados do Cliente");
                System.out.println("Número da agência: ");
                int numeroAgencia = entradaTeclado.nextInt();
                System.out.println("Número da  Conta: ");
                int numeroConta = entradaTeclado.nextInt();
                System.out.println("Saldo inicial: ");
                double saldoInicial = entradaTeclado.nextDouble();
                System.out.println("Saldo cheque-especial: ");
                double saldoChequeEspecial = entradaTeclado.nextDouble();
                banco.getClientesDoBanco().get(nomeCliente).abrirContaCorrente(numeroAgencia, numeroConta, saldoInicial, saldoChequeEspecial);
                break;
            case 2:
                System.out.println("\n\n\n");
                System.out.println("Digite os dados do Cliente");
                System.out.println("Número da agência: ");
                numeroAgencia = entradaTeclado.nextInt();
                System.out.println("Número da  Conta: ");
                numeroConta = entradaTeclado.nextInt();
                System.out.println("Saldo inicial: ");
                saldoInicial = entradaTeclado.nextDouble();
                System.out.println("Dia de aniversário: ");
                int diaAniversario = entradaTeclado.nextInt();
                System.out.println("Valor taxa de juros: ");
                double valorTaxaDeJuros = entradaTeclado.nextDouble();
                banco.getClientesDoBanco().get(nomeCliente).abrirContaPoupanca(numeroAgencia, numeroConta, saldoInicial, diaAniversario, valorTaxaDeJuros);
                break;
            case 3:
                System.out.println("\n\n\n");
                System.out.println("Digite os dados do Cliente");
                System.out.println("Número da agência: ");
                numeroAgencia = entradaTeclado.nextInt();
                System.out.println("Número da  Conta: ");
                numeroConta = entradaTeclado.nextInt();
                System.out.println("Saldo inicial: ");
                saldoInicial = entradaTeclado.nextDouble();
                System.out.println("Dia de aniversário: ");
                int limiteDeSaques = entradaTeclado.nextInt();
                banco.getClientesDoBanco().get(nomeCliente).abrirContaSalario(numeroAgencia, numeroConta, saldoInicial, limiteDeSaques);
                break;
            default:
                System.out.println("Opção inválida\n");
                menuPrincipal();
        }
    }
    
    public void menuRelatorio(int relatorio){
        switch (relatorio){
            case 1:
                System.out.println("Clientes cadastrados no banco: ");
                banco.getClientesDoBanco().values().stream().map(cliente -> cliente.getNome()).sorted().forEach(System.out::println);
                menuPrincipal();
                break;
            case 2:
                List<Double> listSaldoTotalEmBanco;
                listSaldoTotalEmBanco = banco.getClientesDoBanco().values()
                        .stream().map(cliente -> cliente.getSaldoTotalCliente())
                        .sorted().collect(Collectors.toList());
                double saldoTotalEmBanco = 0;
                for(double saldo: listSaldoTotalEmBanco){
                    saldoTotalEmBanco += saldo; 
               }
                System.out.printf("\nValor total no banco: R$ %.2f \n", saldoTotalEmBanco);
                menuPrincipal();
                break;
            default:
                menuPrincipal();
        }
    }
    
    private boolean validaConta(int numAgencia, int numConta){
        boolean validado = false;
        for (Cliente cliente: banco.getClientesDoBanco().values()){
            for(Conta conta: cliente.getListaDeContas()){
                validado = conta.autenticacaoConta(numAgencia, numConta);
                if(validado){
                    break;
                }
            }
            if(validado){
                break;
            }
        }
        
        return validado;
    }
    
//    public void menuTransferencia(){
//        mostra(informe a agencia da conta destinataria)
//        recebe(agencia);
//        mostra(informe o numero da conta destinataria);
//        recebe(numeroConta);
//        se(contaValida(agencia, numeroConta)){ (Criar Método boolean contaValida())
//            mostra(de onde saira o dinhero);
//            mostra(contas disponiveis());
//            recebe(o tipo da conta);
//            mostra(qual o valor a ser transferido?);
//            recebe(valor);
//            se(valor estiver disponivel){
//                contaRemetente.saldo -= valor;
//                contaDestinataria += valor
//            }senão: saldo insuficiente
//        }senão: contaInexistente
        
        
}

