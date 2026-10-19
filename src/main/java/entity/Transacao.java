package entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
public class Transacao extends PanacheEntity {
    public String descricao;
    public BigDecimal valor;
    public String tipo;
    public LocalDateTime datatransacao;

    @ManyToOne
    @JoinColumn(name = "conta_id")
    public Conta conta;

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    public Categoria categoria;

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public BigDecimal getValor() { return valor; }
    public void setValor(BigDecimal valor) { this.valor = valor; }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    public LocalDateTime getDatatransacao() { return datatransacao; }
    public void setDatatransacao(LocalDateTime datatransacao) { this.datatransacao = datatransacao; }

    public Conta getConta() { return conta; }
    public void setConta(Conta conta) { this.conta = conta; }

    public Categoria getCategoria() { return categoria; }
    public void setCategoria(Categoria categoria) { this.categoria = categoria; }
}
