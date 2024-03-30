package service;

import module.Categoria;
import module.Endereco;
import module.Estado;

public class EstadoService {

    public void menuEstado() {
        System.out.println("Selecione o estado em que o evento vai ocorrer: ");
        System.out.println("0 - Acre");
        System.out.println("1 - Alagoas");
        System.out.println("2 - Amapá");
        System.out.println("3 - Amazonas");
        System.out.println("4 - Bahia");
        System.out.println("5 - Ceará");
        System.out.println("6 - Distrito Federal");
        System.out.println("7 - Espírito Santo");
        System.out.println("8 - Goiás");
        System.out.println("9 - Maranhão");
        System.out.println("10 - Mato Grosso");
        System.out.println("11 - Mato Grosso do Sul");
        System.out.println("12 - Minas Gerais");
        System.out.println("13 - Pará");
        System.out.println("14 - Paraíba");
        System.out.println("15 - Paraná");
        System.out.println("16 - Pernambuco");
        System.out.println("17 - Piauí");
        System.out.println("18 - Rio de Janeiro");
        System.out.println("19 - Rio Grande do Norte");
        System.out.println("20 - Rio Grande do Sul");
        System.out.println("21 - Rondônia");
        System.out.println("22 - Roraima");
        System.out.println("23 - Santa Catarina");
        System.out.println("24 - São Paulo");
        System.out.println("25 - Sergipe");
        System.out.println("26 - Tocantins");

    }
    public void escolhaEstado(Integer opcaoEstado, Endereco endereco) {
        Estado estadoSelecionado;
        switch (opcaoEstado) {
            case 0:
                estadoSelecionado = Estado.AC;
                break;
            case 1:
                estadoSelecionado = Estado.AL;
                break;
            case 2:
                estadoSelecionado = Estado.AP;
                break;
            case 3:
                estadoSelecionado = Estado.AM;
                break;
            case 4:
                estadoSelecionado = Estado.BA;
                break;
            case 5:
                estadoSelecionado = Estado.CE;
                break;
            case 6:
                estadoSelecionado = Estado.DF;
                break;
            case 7:
                estadoSelecionado = Estado.ES;
                break;
            case 8:
                estadoSelecionado = Estado.GO;
                break;
            case 9:
                estadoSelecionado = Estado.MA;
                break;
            case 10:
                estadoSelecionado = Estado.MT;
                break;
            case 11:
                estadoSelecionado = Estado.MS;
                break;
            case 12:
                estadoSelecionado = Estado.MG;
                break;
            case 13:
                estadoSelecionado = Estado.PA;
                break;
            case 14:
                estadoSelecionado = Estado.PB;
                break;
            case 15:
                estadoSelecionado = Estado.PR;
                break;
            case 16:
                estadoSelecionado = Estado.PE;
                break;
            case 17:
                estadoSelecionado = Estado.PI;
                break;
            case 18:
                estadoSelecionado = Estado.RJ;
                break;
            case 19:
                estadoSelecionado = Estado.RN;
                break;
            case 20:
                estadoSelecionado = Estado.RS;
                break;
            case 21:
                estadoSelecionado = Estado.RO;
                break;
            case 22:
                estadoSelecionado = Estado.RR;
                break;
            case 23:
                estadoSelecionado = Estado.SC;
                break;
            case 24:
                estadoSelecionado = Estado.SP;
                break;
            case 25:
                estadoSelecionado = Estado.SE;
                break;
            case 26:
                estadoSelecionado = Estado.TO;
                break;
            default:
                System.out.println("Opção inválida.");
                return;
        }

        endereco.setEstado(estadoSelecionado);
    }
}
