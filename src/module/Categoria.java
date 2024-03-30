package module;

public enum Categoria {
    FESTA(0), SHOW(1), ESPORTIVO(2), OUTRO(3);

    private int key;

    Categoria(int key) {
        this.key = key;
    }

    public String getLabel() {
        switch (key) {
            case 0: return "Festa";
            case 1: return "Show";
            case 2: return "Esportivo";
            case 3: return "Outro";
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
