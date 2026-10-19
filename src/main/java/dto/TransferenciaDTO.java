package dto;

import entity.Transacao;

public class TransferenciaDTO {
    public Transacao receber;
    public Transacao depositar;

    public Transacao getReceber() {
        return receber;
    }

    public void setReceber(Transacao receber) {
        this.receber = receber;
    }

    public Transacao getDepositar() {
        return depositar;
    }

    public void setDepositar(Transacao depositar) {
        this.depositar = depositar;
    }
}
