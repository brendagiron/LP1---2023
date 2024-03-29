package entity;

import jakarta.persistence.*;

@Entity
@Table

public class Piloto {

    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String nome;

    @Column
    private String codAutorizacao;

    public Piloto(String nome, String codAutorizacao) {
        this.nome = nome;
        this.codAutorizacao = codAutorizacao;
    }

    @Override
    public String toString() {
        return "Piloto{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", codAutorizacao='" + codAutorizacao + '\'' +
                '}';
    }
}
