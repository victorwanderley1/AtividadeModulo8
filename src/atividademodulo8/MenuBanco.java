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
        int opcao = 0;
        while(ativo){
            opcao = 0;
            System.out.println("\n-------Banco--Mananger--2.0-------");
            System.out.println("");
            System.out.println("Selecione uma opção abaixo:");
            System.out.println("(1) Cadastrar novo cliente");
            System.out.println("(2) Abrir nova conta");
            System.out.println("(3) Relatórios");
            System.out.println("(4) Realizar Transferência");
            System.out.println("(0) Encerrar programa");
            System.out.print("Digite a opção: ");
            opcao = entradaTeclado.nextInt();
            entradaTeclado.nextLine();
            switch (opcao){
                case 1:
                    menuCadastrarCliente();
                    break;
                case 2:
                    menuAbrirConta();
                    break;
                case 3:
                    System.out.println("\nQual relatório deseja receber? "
                            + "\n1) - Clientes Cadastrados no banco"
                            + "\n2) - Saldo Total Em Banco "
                            + "\n3) - Saldo Por Cliente");
                    int opcaoRelatorio = entradaTeclado.nextInt();
                    entradaTeclado.nextLine();
                    menuRelatorio(opcaoRelatorio);
                    break;
                case 4:
                    menuTransferencia();
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
        banco.addCliente(entradaTeclado.nextLine());
    }
    
    public void menuAbrirConta(){
        String nomeCliente = "";
        System.out.println("Selecione o cliente que deseja abrir a conta: \n");
        banco.getClientesDoBanco().values().stream().map(cliente -> cliente.getNome()).sorted().forEach(System.out::println);
        System.out.println("\nDigite o nome do cliente: ");
        nomeCliente = entradaTeclado.nextLine();
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
                banco.getClientesDoBanco().get(nomeCliente)
                        .abrirContaPoupanca(numeroAgencia, numeroConta, saldoInicial, diaAniversario, valorTaxaDeJuros);
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
                System.out.println("Quantidades de saques: ");
                int limiteDeSaques = entradaTeclado.nextInt();
                banco.getClientesDoBanco().get(nomeCliente).abrirContaSalario(numeroAgencia, numeroConta, saldoInicial, limiteDeSaques);
                break;
            default:
                System.out.println("Opção inválida\n");
                break;
        }
        menuPrincipal();
    }
    
    public void mostraClientesBancoOrdemAlfabetica(){
        banco.getClientesDoBanco().values().stream().map(cliente -> cliente.getNome()).sorted().forEach(System.out::println);
    }
    
    public void menuRelatorio(int relatorio){
        switch (relatorio){
            case 1:
                System.out.println("Clientes cadastrados no banco: ");
                mostraClientesBancoOrdemAlfabetica();
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
                break;
            case 3:
                System.out.println("");
                for(Cliente cliente: banco.getClientesDoBanco().values()){
                    System.out.println("");
                    System.out.println("Cliente: "+cliente.getNome());
                    System.out.println("Contas:");
                    for(Conta conta: cliente.getListaDeContas()){
                        System.out.println("");
                        System.out.println(conta.tipoDeConta);
                        System.out.println("Dados Da Conta"+conta.toString());
                        System.out.println("Saldo: "+conta.getSaldo());
                        System.out.println("\n");
                    }
                }
                
            default:
                System.out.println("Opção inválida!");
                break;
        }
        menuPrincipal();
    }
    
    private boolean depositoEmContaPorAgenciaENumeroConta(int numAgencia, int numConta, double valorTransferencia){
        boolean validado = false;
        for (Cliente cliente: banco.getClientesDoBanco().values()){
            int cont = 0;
            for(Conta conta: cliente.getListaDeContas()){
                validado = conta.autenticacaoConta(numAgencia, numConta);
                if(validado){
                    banco.getClientesDoBanco().get(cliente.nome)
                            .getListaDeContas().get(cont).depositar(valorTransferencia);
                    break;
                }
                cont++;
            }
            if(validado){
                break;
            }
        }
        return validado;
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
    
    public void menuTransferencia(){
        System.out.println("Clientes cadastrados: ");
        mostraClientesBancoOrdemAlfabetica();
        System.out.println("Digite o nome do cliente remetente: ");
        String nomeCliente = entradaTeclado.nextLine();
        System.out.println("Informe o número de agência da conta destinatária: ");
        int agContDestino = entradaTeclado.nextInt();
        System.out.println("Informe o número da conta destinatária: ");
        int numContDestino = entradaTeclado.nextInt();
        if(validaConta(agContDestino, numContDestino)){
            System.out.println("De onde sairá o dinheiro? ");
            System.out.println("Contas disponíveis para o cliente "+nomeCliente
                    +"\n"+this.banco.getClientesDoBanco()
                    .get(nomeCliente).mostraContas());
            System.out.println("Digite de qual conta deverá ser transferido o dinheiro: ");
            int tipoContaTransferencia = entradaTeclado.nextInt();
            System.out.println("Valor disponível em conta: ");
            System.out.println(banco.getClientesDoBanco().get(nomeCliente)
                    .getListaDeContas().get(tipoContaTransferencia).getSaldo());
            System.out.println("Qual valor deseja transferir: ");
            double valorTransferencia = entradaTeclado.nextDouble();
            if(valorTransferencia <= banco.getClientesDoBanco().get(nomeCliente)
                    .getListaDeContas().get(tipoContaTransferencia).getSaldo()){
                banco.getClientesDoBanco().get(nomeCliente).getListaDeContas()
                        .get(tipoContaTransferencia).sacar(valorTransferencia);
                depositoEmContaPorAgenciaENumeroConta(agContDestino, numContDestino, valorTransferencia);
            }else System.out.println("Saldo insuficiente!");
        }else System.out.println("Conta inexistente!");
    }
}    