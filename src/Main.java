import module.Evento;
import service.EstadoService;
import service.EventoService;
import service.UsuarioSevice;

import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {

    private Scanner scanner;

    private UsuarioSevice serviceUsuario;

    private EventoService serviceEvento;

    public Main() {
        scanner = new Scanner(System.in);
        serviceUsuario = new UsuarioSevice();
        serviceEvento = new EventoService();
        menuPrincipal();
    }

    public void menuPrincipal() {
        System.out.println("");
        System.out.println("Menu");
        System.out.println("");
        System.out.println("1. Cadastrar usuário");
        System.out.println("2. Cadastrar evento");
        System.out.println("3. Consultar eventos");
        System.out.println("4. Participar de evento");
        System.out.println("5. Cancelar participação");
        System.out.println("6. Sair");
        System.out.println("");

        System.out.print("Escolha uma opção: ");
        int opcao = scanner.nextInt();

        switch (opcao) {
            case 1:
                serviceUsuario.cadastrarUsuario();
                menuPrincipal();
                break;
            case 2:
                serviceEvento.cadastrarEventos();
                menuPrincipal();
                break;
            case 3:
                serviceEvento.consultarEventos(Evento.getListaEventos());
                menuPrincipal();
                break;
            case 4:
                serviceUsuario.participarEvento();
                menuPrincipal();
                break;
            case 5:
                serviceUsuario.cancelarParticipacao();
                menuPrincipal();
                break;
            case 6:
                sair();
                break;
            default:
                System.out.println("Opção inválida");
                menuPrincipal();
                break;
        }
    }

    private void sair() {
        System.out.println("Você escolheu sair.");
    }

    public static void main(String[] args) {
        Main main = new Main();
    }

}