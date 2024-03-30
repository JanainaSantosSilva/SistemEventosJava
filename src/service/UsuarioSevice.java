package service;

import com.sun.tools.javac.Main;
import module.Endereco;
import module.Estado;
import module.Evento;
import module.Usuario;

import java.text.SimpleDateFormat;
import java.util.Scanner;

public class UsuarioSevice {

    private Scanner scanner;

    private EventoService eventoService;

    private EstadoService estadoService;

    private static int ultimoId = 0;


    public UsuarioSevice() {
        scanner = new Scanner(System.in);
        eventoService = new EventoService();
        estadoService = new EstadoService();

    }

    public void cadastrarUsuario() {
        System.out.println("Você escolheu cadastrar usuário.");

        Usuario usuario =  new Usuario();
        Endereco enderecoUsuario =  new Endereco();
        usuario.setId(ultimoId++);

        System.out.println("Digite o nome do usuário: ");
        String nomeUsuario;

        do {
            nomeUsuario = scanner.nextLine();
            if (nomeUsuario.isEmpty()) {
                System.out.println("Nome não pode estar vazio. Por favor, digite novamente: ");
            }
        } while (nomeUsuario.isEmpty());

        usuario.setNome(nomeUsuario);

        System.out.println("Cadastre uma senha: ");
        String senhaUsuario;

        do {
            senhaUsuario = scanner.nextLine();
            if (senhaUsuario.isEmpty()) {
                System.out.println("Senha não pode estar vazia. Por favor, digite novamente: ");
            }
        } while (senhaUsuario.isEmpty());

        usuario.setSenha(senhaUsuario);

        System.out.println("Digite a idade do usuário: ");
        Integer idadeUsuario;

        do {
            try {
                idadeUsuario = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Por favor, digite uma idade válida: ");
                idadeUsuario = null;
            }
        } while (idadeUsuario == null);

        usuario.setIdade(idadeUsuario);

        estadoService.menuEstado();
        Integer opcaoEstado;
        do {
            opcaoEstado = Integer.valueOf(scanner.nextLine());
            try {
                estadoService.escolhaEstado(opcaoEstado, enderecoUsuario);
            } catch (NumberFormatException e) {
                System.out.println("Digite uma opção válida");
                opcaoEstado = null;
            }
        } while (opcaoEstado == null);

        System.out.println("Digite a cidade em que o usuário mora: ");
        String cidadeUsuario;
        do {
            cidadeUsuario = scanner.nextLine();
            if (cidadeUsuario.isEmpty()) {
                System.out.println("Cidade não pode estar vazia. Por favor, digite novamente: ");
            }
        } while (cidadeUsuario.isEmpty());

        usuario.setEndereco(enderecoUsuario);

        Usuario.getUsuarios().add(usuario);


        System.out.println("Usuário cadastrado com sucesso!");
    }

    public void participarEvento() {
        Usuario usuario = usuarioLogado();

        System.out.println("Escolha uma opção");

        eventoService.consultarEventos(Evento.getListaEventos());

        if (Evento.getListaEventos().isEmpty()) {
            System.out.println("Não existem eventos cadastrados no sistema");
        }

        int opcao = scanner.nextInt();

        usuario.getEventosConfirmados().add(Evento.getListaEventos().get(opcao - 1));

        System.out.println("Agora voce está participando do evento!");
    }

    public void cancelarParticipacao() {
        Usuario usuario = usuarioLogado();

        if ( usuario.getEventosConfirmados().isEmpty()) {
            System.out.println("Não existem eventos confirmados para esse usuário");
        }

        System.out.println("Escolha uma opção");

        System.out.println("Lista de eventos:");

        eventoService.consultarEventos(usuario.getEventosConfirmados());

        int opcao = scanner.nextInt();

        usuario.getEventosConfirmados().remove(Evento.getListaEventos().get(opcao - 1));
    }

    public Usuario usuarioLogado () {
        System.out.println("Digite o nome do usuário: ");
        String nomeUsuario;
        Usuario usuario = null;
        do {
            do {
                nomeUsuario = scanner.nextLine();
                if (nomeUsuario.isEmpty()) {
                    System.out.println("Nome não pode estar vazio. Por favor, digite novamente: ");
                }
            } while (nomeUsuario.isEmpty());

            System.out.println("Digite sua senha: ");
            String senhaUsuario;

            do {
                senhaUsuario = scanner.nextLine();
                if (senhaUsuario.isEmpty()) {
                    System.out.println("Senha não pode estar vazia. Por favor, digite novamente: ");
                }
            } while (senhaUsuario.isEmpty());

            String finalNomeUsuario = nomeUsuario;
            String finalSenhaUsuario = senhaUsuario;
            usuario = Usuario.getUsuarios()
                    .stream()
                    .filter(user -> user.getNome().equals(finalNomeUsuario) && user.getSenha().equals(finalSenhaUsuario))
                    .findAny()
                    .orElse(null);

            if (usuario == null) {
                System.out.println("Usuário não encontrado. Por favor, digite usuário e senha novamente");
            }
        } while (usuario == null);

        return usuario;
    }
}
