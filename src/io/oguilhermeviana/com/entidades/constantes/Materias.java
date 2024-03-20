package io.oguilhermeviana.com.entidades.constantes;

public enum Materias {
    M5(2),
    M10(5),
    M15(10);

    private double fator;

    /**
     * Construtor.
     * @param fator Valor por tipo que influencia no cálculo do frete.
     */
    Materias(double fator) {
        this.fator = fator / 10;
    }

    public double getFator() {
        return fator;
    }
}
