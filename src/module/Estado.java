package module;

public enum Estado {
    AC(0), AL(1), AP(2), AM(3), BA(4), CE(5), DF(6), ES(7), GO(8), MA(9),
    MT(10), MS(11), MG(12), PA(13), PB(14), PR(15), PE(16), PI(17), RJ(18),
    RN(19), RS(20), RO(21),  RR(22), SC(23), SP(24), SE(25),  TO(26);

    private int key;

    Estado(int key) {
        this.key = key;
    }

    public String getLabel() {
        switch (key) {
            case 0:
                return "Acre";
            case 1:
                return "Alagoas";
            case 2:
                return "Amapá";
            case 3:
                return "Amazonas";
            case 4:
                return "Bahia";
            case 5:
                return "Ceará";
            case 6:
                return "Distrito Federal";
            case 7:
                return "Espírito Santo";
            case 8:
                return "Goiás";
            case 9:
                return "Maranhão";
            case 10:
                return "Mato Grosso";
            case 11:
                return "Mato Grosso do Sul";
            case 12:
                return "Minas Gerais";
            case 13:
                return "Pará";
            case 14:
                return "Paraíba";
            case 15:
                return "Paraná";
            case 16:
                return "Pernambuco";
            case 17:
                return "Piauí";
            case 18:
                return "Rio de Janeiro";
            case 19:
                return "Rio Grande do Norte";
            case 20:
                return "Rio Grande do Sul";
            case 21:
                return "Rondônia";
            case 22:
                return "Roraima";
            case 23:
                return "Santa Catarina";
            case 24:
                return "São Paulo";
            case 25:
                return "Sergipe";
            case 26:
                return "Tocantins";

        }

        return null;

    }

    public int getKey() {
        return this.getKey();
    }

    public String toString() {
        return getLabel();
    }

}
