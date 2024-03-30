package module;

public enum TipoLogradouro {

    RUA(0), AV(1), TRAVESSA(2), ALAMEDA(3), BECO(4), VIELA(5), OUTROS(6);

    private int key;

    TipoLogradouro(int key) {
        this.key = key;
    }

    public String getLabel() {
        switch(key) {
            case 0: return "Rua";
            case 1: return "Avenida";
            case 2: return "Travessa";
            case 3: return "Alameda";
            case 4: return "Beco";
            case 5: return "Viela";
            case 6: return "Outros";
        }

        return null;
    }

    public int getKey() {
        return this.key;
    }

    public String toString() {
        return getLabel();
    }
}
