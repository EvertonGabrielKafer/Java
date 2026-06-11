package main.TrabalhoBanco.app;

import main.TrabalhoBanco.dao.ClienteDAO;
import main.TrabalhoBanco.dao.VeiculoDAO;
import main.TrabalhoBanco.dao.VendaDAO;
import main.TrabalhoBanco.dao.impl.ClienteDAOImpl;
import main.TrabalhoBanco.dao.impl.VeiculoDAOImpl;
import main.TrabalhoBanco.dao.impl.VendaDAOImpl;
import main.TrabalhoBanco.model.Cliente;
import main.TrabalhoBanco.model.Veiculo;
import main.TrabalhoBanco.model.Venda;
import main.TrabalhoBanco.service.ClienteService;
import main.TrabalhoBanco.service.VeiculoService;
import main.TrabalhoBanco.service.VendaService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.println("Venda de carros");

        Scanner sc = new Scanner(System.in);

        int opcaoInicio;

        do {
            exibirMenuInicial();
            opcaoInicio = sc.nextInt();

            switch (opcaoInicio) {
                case 0:
                    System.out.println();
                    System.out.println("Saindo");
                    return;
                case 1:
                    lerCliente();
                    break;
                case 2:
                    lerVeiculo();
                    break;
                case 3:
                    lerVenda();
                    break;
                case 4:

                    break;
                default:
                    System.out.println();
                    System.out.println("Opção inválida.");
            }
        } while (opcaoInicio != 0);
    }

        public static void lerCliente() {
            Scanner sc = new Scanner(System.in);
            int opcao;

            do {
                exibirMenu();
                opcao = sc.nextInt();

                switch (opcao) {
                    case 0:
                        System.out.println();
                        System.out.println("Saindo");
                        return;
                    case 1:
                        System.out.println();
                        sc.nextLine();
                        System.out.println("Digite o nome do cliente:");
                        String nomeCliente = sc.nextLine();

                        System.out.println("Digite a cpf do cliente:");
                        String cpf = sc.nextLine();

                        System.out.println("Digite a telefone do cliente:");
                        String telefone = sc.nextLine();

                        Cliente cliente = salvarCliente(nomeCliente, cpf, telefone);
                        System.out.println("Cliente cadastrado com sucesso! Código: " +
                                cliente.getCodigo());
                        break;
                    case 2:
                        System.out.println();
                        listarClientes();
                        break;
                    case 3:
                        System.out.println();
                        atualizarCliente();
                        break;
                    case 4:
                        System.out.println();
                        excluirCliente();
                        break;
                    default:
                        System.out.println();
                        System.out.println("Opção inválida.");
                }
            } while (opcao != 0);
        }



    public static void exibirMenuInicial() {
        System.out.println();
        System.out.println("Selecione uma opção:");
        System.out.println("1 - Cliente");
        System.out.println("2 - Veiculo");
        System.out.println("3 - Venda");
        System.out.println("0 - Sair");
    }

    public static void exibirMenu() {
        System.out.println();
        System.out.println("Selecione uma opção:");
        System.out.println("1 - Cadastrar cliente");
        System.out.println("2 - Listar clientes");
        System.out.println("3 - Atualizar clientes");
        System.out.println("4 - Deletar clientes");
        System.out.println("0 - Sair");
    }



    public static Cliente salvarCliente(String nomeCliente, String cpf, String telefone) {
        ClienteDAO clienteDAO = new ClienteDAOImpl();
        ClienteService clienteService = new ClienteService(clienteDAO);

        Cliente novoCliente = new Cliente();
        novoCliente.setNome(nomeCliente);
        novoCliente.setCpf(cpf);
        novoCliente.setTelefone(telefone);

        return clienteService.salvarCliente(novoCliente);

    }



    public static List<Cliente> listarClientes() {
        ClienteDAO clienteDAO = new ClienteDAOImpl();
        ClienteService clienteService = new ClienteService(clienteDAO);

        List<Cliente> clientes = clienteService.listarTodos();
        for (Cliente cliente : clientes) {
            System.out.println(cliente.getCodigo() + " - " +
                    cliente.getNome() + "\n" +
                    cliente.getCpf() + "\n" +
                    cliente.getTelefone() + "\n");
        }
        return clientes;
    }



    private static void atualizarCliente() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Código: ");
        Integer codigo = sc.nextInt();
        sc.nextLine();

        System.out.print("Novo nome: ");
        String nome = sc.nextLine();

        System.out.print("Novo cpf: ");
        String cpf = sc.nextLine();

        System.out.print("Novo telefone: ");
        String telefone = sc.nextLine();

        Cliente cliente = new Cliente(
                codigo,
                nome,
                cpf,
                telefone
        );

        ClienteDAO clienteDAO = new ClienteDAOImpl();
        ClienteService clienteService = new ClienteService(clienteDAO);

        clienteService.atualizarCliente(cliente);


        System.out.println("Cliente atualizado com sucesso!");
    }


    private static void excluirCliente() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Código do cliente: ");
        Integer codigo = sc.nextInt();


        ClienteDAO clienteDAO = new ClienteDAOImpl();
        ClienteService clienteService = new ClienteService(clienteDAO);
        clienteService.excluirCliente(codigo);

        System.out.println("Cliente excluído com sucesso!");
    }



    //--------------------------Veiculo-----------------------------



    public static void lerVeiculo() {
        Scanner sc = new Scanner(System.in);
        int opcao;

        do {
            exibirMenuVeiculo();
            opcao = sc.nextInt();

            switch (opcao) {
                case 0:
                    System.out.println();
                    System.out.println("Saindo");
                    return;
                case 1:
                    System.out.println();
                    sc.nextLine();
                    System.out.println("Digite A Marca:");
                    String marca = sc.nextLine();

                    System.out.println("Digite o Modelo:");
                    String modelo = sc.nextLine();

                    System.out.println("Digite o Ano:");
                    Integer ano = sc.nextInt();

                    System.out.println("Digite o Valor:");
                    Double valor = sc.nextDouble();

                    System.out.println("Digite se o veiculo se encontra disponível:");
                    Boolean disponivel = sc.nextBoolean();

                    Veiculo veiculo = salvarVeiculo(marca, modelo, ano, valor, disponivel);
                    System.out.println("Veiculo cadastrado com sucesso! Código: " +
                            veiculo.getCodigo());
                    break;
                case 2:
                    System.out.println();
                    listarVeiculos();
                    break;
                case 3:
                    System.out.println();
                    atualizarVeiculo();
                    break;
                case 4:
                    System.out.println();
                    excluirVeiculo();
                    break;
                default:
                    System.out.println();
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 0);
    }



    public static void exibirMenuVeiculo() {
        System.out.println();
        System.out.println("Selecione uma opção:");
        System.out.println("1 - Cadastrar veiculo");
        System.out.println("2 - Listar veiculos");
        System.out.println("3 - Atualizar veiculo");
        System.out.println("4 - Deletar veiculo");
        System.out.println("0 - Sair");
    }



    public static Veiculo salvarVeiculo(String marca, String modelo, Integer ano, Double valor, Boolean disponivel) {
        VeiculoDAO veiculoDAO = new VeiculoDAOImpl();
        VeiculoService veiculoService = new VeiculoService(veiculoDAO);

        Veiculo novoVeiculo = new Veiculo();
        novoVeiculo.setMarca(marca);
        novoVeiculo.setModelo(modelo);
        novoVeiculo.setAno(ano);
        novoVeiculo.setValor(valor);
        novoVeiculo.setDisponivel(disponivel);
        return veiculoService.salvarVeiculo(novoVeiculo);

    }



    public static List<Veiculo> listarVeiculos() {
        VeiculoDAO veiculoDAO = new VeiculoDAOImpl();
        VeiculoService veiculoService = new VeiculoService(veiculoDAO);

        List<Veiculo> veiculos = veiculoService.listarTodos();
        for (Veiculo veiculo : veiculos) {
            System.out.println(veiculo.getCodigo() + " - " +
                    veiculo.getMarca() + "\n" +
                    veiculo.getModelo() + "\n" +
                    veiculo.getAno() + "\n"+
                    veiculo.getValor() + "\n"+
                    veiculo.getDisponivel() + "\n");
        }
        return veiculos;
    }



    private static void atualizarVeiculo() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Código: ");
        Integer codigo = sc.nextInt();
        sc.nextLine();

        System.out.print("Nova marca: ");
        String marca = sc.nextLine();

        System.out.print("Novo modelo: ");
        String modelo = sc.nextLine();

        System.out.print("Novo ano: ");
        Integer ano = sc.nextInt();

        System.out.print("Novo valor: ");
        Double valor = sc.nextDouble();

        System.out.print("Nova disponibilidade: ");
        Boolean disponivel = sc.nextBoolean();

        Veiculo veiculo = new Veiculo(
                codigo,
                marca,
                modelo,
                ano,
                valor,
                disponivel
        );

        VeiculoDAO veiculoDAO = new VeiculoDAOImpl();
        VeiculoService veiculoService = new VeiculoService(veiculoDAO);

        veiculoService.atualizarVeiculo(veiculo);


        System.out.println("Veiculo atualizado com sucesso!");
    }


    private static void excluirVeiculo() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Código do veiculo: ");
        Integer codigo = sc.nextInt();


        VeiculoDAO veiculoDAO = new VeiculoDAOImpl();
        VeiculoService veiculoService = new VeiculoService(veiculoDAO);
        veiculoService.excluirVeiculo(codigo);

        System.out.println("Veiculo excluído com sucesso!");
    }




    //--------------------------Venda-----------------------------



    public static void lerVenda() {
        Scanner sc = new Scanner(System.in);
        int opcao;

        do {
            exibirMenuVenda();
            opcao = sc.nextInt();

            switch (opcao) {
                case 0:
                    System.out.println();
                    System.out.println("Saindo");
                    return;
                case 1:
                    System.out.println();
                    sc.nextLine();
                    SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
                    System.out.println("Digite A Data:");
                    String dataVendaDigitada = sc.nextLine();
                    Date dataVenda = null;

                    try {
                        dataVenda = formato.parse(dataVendaDigitada);
                        System.out.println("Data recebida com sucesso: " + formato.format(dataVenda));
                    } catch (ParseException e) {
                        System.out.println("Formato de data inválido! Use o padrão dd/MM/yyyy.");
                        return;
                    }

                    System.out.println("Digite o código do cliente:");
                    Integer cliente = sc.nextInt();

                    System.out.println("Digite o código do veiculo:");
                    Integer veiculo = sc.nextInt();

                    System.out.println("Digite o Valor da venda:");
                    Double valorVenda = sc.nextDouble();

                    Venda venda = salvarVenda(dataVenda, cliente, veiculo, valorVenda);
                    System.out.println("Venda cadastrado com sucesso! Código: " +
                            venda.getCodigo());
                    break;
                case 2:
                    System.out.println();
                    listarVendas();
                    break;
                case 3:
                    System.out.println();
                    atualizarVenda();
                    break;
                case 4:
                    System.out.println();
                    excluirVenda();
                    break;
                default:
                    System.out.println();
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 0);
    }



    public static void exibirMenuVenda() {
        System.out.println();
        System.out.println("Selecione uma opção:");
        System.out.println("1 - Cadastrar venda");
        System.out.println("2 - Listar vendas");
        System.out.println("3 - Atualizar venda");
        System.out.println("4 - Deletar venda");
        System.out.println("0 - Sair");
    }



    public static Venda salvarVenda(Date dataVenda, Integer cliente, Integer veiculo, Double valorVenda) {
        VendaDAO vendaDAO = new VendaDAOImpl();
        VeiculoDAO veiculoDAO = new VeiculoDAOImpl();
        VendaService vendaService = new VendaService(vendaDAO, veiculoDAO);

        Venda novoVenda = new Venda();
        novoVenda.setDataVenda(dataVenda);
        Cliente clienteVenda = new Cliente();
        clienteVenda.setCodigo(cliente);
        novoVenda.setCliente(clienteVenda);

        Veiculo veiculoVenda = new Veiculo();
        veiculoVenda.setCodigo(veiculo);
        novoVenda.setVeiculo(veiculoVenda);
        novoVenda.setValorVenda(valorVenda);
        return vendaService.salvarVenda(novoVenda);

    }



    public static List<Venda> listarVendas() {
        VendaDAO vendaDAO = new VendaDAOImpl();
        VeiculoDAO veiculoDAO = new VeiculoDAOImpl();
        VendaService vendaService = new VendaService(vendaDAO, veiculoDAO);

        List<Venda> vendas = vendaService.listarTodos();
        for (Venda venda : vendas) {
            System.out.println(venda.getCodigo() + " - " +
                    venda.getDataVenda() + "\n" +
                    venda.getCliente() + "\n" +
                    venda.getVeiculo() + "\n"+
                    venda.getValorVenda() + "\n");
        }
        return vendas;
    }



    private static void atualizarVenda() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Código: ");
        Integer codigo = sc.nextInt();
        sc.nextLine();

        System.out.print("Nova Data: ");
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        String dataVendaDigitada = sc.nextLine();
        Date dataVenda = null;

        try {
            dataVenda = formato.parse(dataVendaDigitada);
            System.out.println("Data recebida com sucesso: " + formato.format(dataVenda));
        } catch (ParseException e) {
            System.out.println("Formato de data inválido! Use o padrão dd/MM/yyyy.");
            return;
        }

        System.out.print("Novo Cliente: ");
        Integer cliente = sc.nextInt();

        System.out.print("Novo veiculo: ");
        Integer veiculo = sc.nextInt();

        System.out.print("Novo valorVenda: ");
        Double valorVenda = sc.nextDouble();

        Cliente clienteVenda = new Cliente();
        clienteVenda.setCodigo(cliente);

        Veiculo veiculoVenda = new Veiculo();
        veiculoVenda.setCodigo(veiculo);

        Venda venda = new Venda();
        venda.setCodigo(codigo);
        venda.setDataVenda(dataVenda);
        venda.setCliente(clienteVenda);
        venda.setVeiculo(veiculoVenda);
        venda.setValorVenda(valorVenda);

        VendaDAO vendaDAO = new VendaDAOImpl();
        VeiculoDAO veiculoDAO = new VeiculoDAOImpl();
        VendaService vendaService = new VendaService(vendaDAO, veiculoDAO);

        vendaService.atualizarVenda(venda);


        System.out.println("Venda atualizado com sucesso!");
    }


    private static void excluirVenda() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Código do venda: ");
        Integer codigo = sc.nextInt();


        VendaDAO vendaDAO = new VendaDAOImpl();
        VeiculoDAO veiculoDAO = new VeiculoDAOImpl();
        VendaService vendaService = new VendaService(vendaDAO, veiculoDAO);
        vendaService.excluirVenda(codigo);

        System.out.println("Venda excluído com sucesso!");
    }
}
