class CaminhaoPlataforma extends Caminhao {
    private double tamanhoMax;

    public CaminhaoPlataforma(String modelo, int ano, double valor, int ident, double tamanhoMax) {
        super(valor, ano, modelo, ident);
        this.tamanhoMax = tamanhoMax;
    }

    public double getTamanhoMax() {
        return tamanhoMax;
    }


    public String toString() {
        return super.toString() + ", Tamanho Máx =" + tamanhoMax;
    }
}
