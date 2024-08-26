abstract class Caminhao {
    private int ident;
    private double valor;
    private String modelo;
    private int ano;

    public Caminhao(double valor, int ano, String modelo, int ident) {
        this.valor = valor;
        this.modelo = modelo;
        this.ano = ano;
        this.ident = ident;
    }

    public double getValor() {
        return valor;
    }

    public String getModelo() {
        return modelo;
    }

    public int getIdent() {
        return ident;
    }

    public int getAno() {
        return ano;
    }


    public String toString() {
        return "Caminhão [Identificação =" + ident + ", Modelo =" + modelo + ", Ano =" + ano + ", Valor =" + valor + "]";
    }
}
