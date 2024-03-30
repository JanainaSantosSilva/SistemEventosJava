package service;

import module.Categoria;
import module.Endereco;
import module.Evento;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class EventoService {

    private Scanner scanner;
    private static int ultimoId = 0;
    private EstadoService estadoService;


    public EventoService() {
        scanner = new Scanner(System.in);
        estadoService = new EstadoService();
    }

    public void cadastrarEventos() {
        Evento evento = new Evento();
        Endereco enderecoEvento = new Endereco();

        evento.setId(++ultimoId);


        System.out.println("Digite o nome do evento: ");
        String nomeEvento;
        do {
            nomeEvento = scanner.nextLine();

            if (nomeEvento.isEmpty()) {
                System.out.println("Nome do evento não pode estar vazio. Por favor, digite novamente.");
            }
        } while (nomeEvento.isEmpty());

        evento.setNome(nomeEvento);

        System.out.println("Digite a descrição do evento: ");
        String descricaoEvento;
        do {
            descricaoEvento = scanner.nextLine();
            if (descricaoEvento.isEmpty()) {
                System.out.println("Descrição não pode estar vazia. Por favor, digite novamente");
            }
        } while (descricaoEvento.isEmpty());

        evento.setDescricao(descricaoEvento);

        System.out.println("Digite a data e hora do evento (no formato dd/MM/yyyy HH:mm): ");
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        Date dataHoraEvento = null;
        do {
            String dataHoraString = scanner.nextLine();
            try {
                dataHoraEvento = dateFormat.parse(dataHoraString);
                if (dataHoraEvento == null) {
                    System.out.println("Data/Hora não pode estar vazia. Por favor, digite novamente: ");
                }
            } catch (ParseException e) {
                System.out.println("Formato de data/hora inválido. Por favor, digite novamente (no formato dd/MM/yyyy HH:mm): ");
            }
        } while (dataHoraEvento == null);

        evento.setHorario(dataHoraEvento);

        menuCategoria();
        Integer opcaoCategoria;
        do {
            opcaoCategoria = Integer.valueOf(scanner.nextLine());
            try {
                escolhaCategoria(opcaoCategoria, evento);
            } catch (NumberFormatException e) {
                System.out.println("Digite uma opção válida");
                opcaoCategoria = null;
            }
        } while (opcaoCategoria == null);

        estadoService.menuEstado();
        Integer opcaoEstado;
        do {
            opcaoEstado = Integer.valueOf(scanner.nextLine());
            try {
                estadoService.escolhaEstado(opcaoEstado, enderecoEvento);
            } catch (NumberFormatException e) {
                System.out.println("Digite uma opção válida");
                opcaoEstado = null;
            }
        } while (opcaoEstado == null);

        System.out.println("Digite a cidade em que o evento vai ocorrer: ");
        String cidadeEvento;
        do {
            cidadeEvento = scanner.nextLine();
            if (cidadeEvento.isEmpty()) {
                System.out.println("Cidade não pode estar vazia. Por favor, digite novamente");
            }
        } while (cidadeEvento.isEmpty());

        enderecoEvento.setCidade(cidadeEvento);


        evento.setEndereco(enderecoEvento);

        Evento.getListaEventos().add(evento);

        System.out.println("Evento Cadastrado com sucesso!");
    }

    public void consultarEventos(List<Evento> listaEventos) {

        if (listaEventos.isEmpty()) {
            System.out.println("Nenhum evento encontrado.");
            return;
        }

        System.out.println("Lista de eventos:");
        for (Evento evento : listaEventos) {
            System.out.println("");
            System.out.println(evento.getId() + " - Nome Evento: " + evento.getNome());
            System.out.println("Categoria: " + evento.getCategoria());
            System.out.println("Data/Hora: " + new SimpleDateFormat("dd/MM/yyyy HH:mm").format(evento.getHorario()));
            System.out.println("Local: " + evento.getEndereco().getCidade() + " - " + evento.getEndereco().getEstado());
            System.out.println("");
        }
    }

    private void escolhaCategoria(Integer opcaoCategoria, Evento evento) {
        switch (opcaoCategoria) {
            case 0: evento.setCategoria(Categoria.FESTA);
            case 1: evento.setCategoria(Categoria.SHOW);
            case 2: evento.setCategoria(Categoria.ESPORTIVO);
            case 4: evento.setCategoria(Categoria.OUTRO);
            default: break;
        }
    }

    private void menuCategoria() {
        System.out.println("Selecione a categoria que o evento pertence: ");

        System.out.println("1. Festa");
        System.out.println("2. Show");
        System.out.println("3. Esportivo");
        System.out.println("4. Outros");

        System.out.println("Escolha uma opção: ");
    }
}
