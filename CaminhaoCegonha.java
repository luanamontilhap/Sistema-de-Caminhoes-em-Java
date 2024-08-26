class CaminhaoCegonha extends Caminhao {
    private double cargaMax;

    public CaminhaoCegonha(String modelo, int ano, double valor, int ident, double cargaMax) {
        super(valor, ano, modelo, ident);
        this.cargaMax = cargaMax;
    }

    public double getCargaMax() {
        return cargaMax;
    }


    public String toString() {
        return super.toString() + ", Carga Máx =" + cargaMax;
    }
}
