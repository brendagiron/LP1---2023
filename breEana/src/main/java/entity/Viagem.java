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
//        E colar lá e não esquecer de tirar o Pom se tiver. Depois pegar e colar na segunda dependência o hibernate h2, se tiver scope test tem q tirar. Executar o maven.
//
//        Criar pacote
//
//        entity.(alguma classe) já cria o packed automaticamente
//
//        Colocar o hibernate.útil que tá no moodle num packed chamado util
//
//        Criar o main no Java msm
//
//        Colocar o hibernate.cfg q tbm tá no moodle no resources
//
//        Pra mapear as classes colocar o “@Entity e @Table” antes da public class
//
//        gerar o Id automaticamente deve colocar os 2 @ padrões
//
//        colocar @column em todo o resto
//
//        Para ver a cardinalidade sempre pela tabela que você está
//        Ou seja, está em viagem seria muitas viagens para um único piloto
//
//        Colocar o @Manytoone e o casacade, que é oq farense que ao fzr o cadastro de uma viagem ela tem q fzr o cadastro do piloto tbm
//
//        Manytomany criar outra tabela
//
//        Para adicionar os passageiros e piloto depois na viagem vc faz o construtor sem eles, mas como o passageiro é uma lista vc precisa inicializar ele no construtor, mas só com o this.
//
//        this.passageiros = new ArrayList<>();
//
//E como vai precisar add o piloto e passageiro depois você vai precisar de get e set pra eles