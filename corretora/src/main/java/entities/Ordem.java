package entities;

import enums.TipoOrdem;

public class Ordem {
    private String nomeInvestidor;
    private TipoOrdem tipoOrdem;
    private double valor;

    public Ordem() {
    }

    public Ordem(String nomeInvestidor, TipoOrdem tipoOrdem, double valor) {
        this.nomeInvestidor = nomeInvestidor;
        this.tipoOrdem = tipoOrdem;
        this.valor = valor;
    }

    public String getNomeInvestidor() {
        return nomeInvestidor;
    }

    public void setNomeInvestidor(String nomeInvestidor) {
        this.nomeInvestidor = nomeInvestidor;
    }

    public TipoOrdem getTipoOrdem() {
        return tipoOrdem;
    }

    public void setTipoOrdem(TipoOrdem tipoOrdem) {
        this.tipoOrdem = tipoOrdem;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "Ordem{" +
                "nomeInvestidor='" + nomeInvestidor + '\'' +
                ", tipoOrdem=" + tipoOrdem +
                ", valor=" + valor +
                '}';
    }
}
