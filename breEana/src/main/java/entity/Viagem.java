package entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table

public class Viagem {

    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private Integer vagas;
    @Column

    private String destino;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "pilotoid")
    private Piloto piloto;
    @ManyToMany
    @JoinTable(name = "ViagemPassageiro", joinColumns = @JoinColumn(name = "viagemid"), inverseJoinColumns = @JoinColumn(name = "passageiroid"))

    private List<Passageiro> passageiros = new ArrayList<>();


    public Viagem(Integer vagas, String destino) {
        this.vagas = vagas;
        this.destino = destino;
        this.passageiros = new ArrayList<>();
    }

    public Piloto getPiloto() {
        return piloto;
    }

    public void setPiloto(Piloto piloto) {
        this.piloto = piloto;
    }

    public List<Passageiro> getPassageiros() {
        return passageiros;
    }

    public void setPassageiros(List<Passageiro> passageiros) {
        //finalidade tbm
        if (passageiros.size() > vagas)
            System.out.println("essa viagem só pode receber"+ this.vagas + "vagas");
        else
            this.passageiros = passageiros;
    }

    //metodo para fzr a funcionalidade e tbm um metodo para add o passageiro de forma q ele veja se tem vaga
    public void addPassageiro(Passageiro passageiro){
        //se a lista de passageiro for menor ao numero de vagas podese adicionar o passageiro epode continuar com o sistema
        if (this.passageiros.size() < vagas) {
            this.passageiros.add(passageiro);
        }
        //se nao retorna na tela mensagem
        else {
            System.out.println("Limite de vagas Excedido");
        }
    }

    @Override
    public String toString() {
        return "Viagem{" +
                "id=" + id +
                ", vagas=" + vagas +
                ", destino='" + destino + '\'' +
                ", piloto=" + piloto +
                ", passageiros=" + passageiros +
                '}';
    }
}
