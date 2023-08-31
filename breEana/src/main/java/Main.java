import entity.*;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        //criando o objeto piloto
        Piloto piloto = new Piloto("Roberto", "a123");
        //criando os passageiros
        Passageiro passageiro1 = new Passageiro("larissa", "12345678954");
        Passageiro passageiro2 = new Passageiro("pedro", "54789632154");
        Passageiro passageiro3 = new Passageiro("ana", "45269871235");
        Passageiro passageiro4 = new Passageiro("vitor", "78542369854");
        Passageiro passageiro5 = new Passageiro("edson", "58974630215");
        Passageiro passageiro6 = new Passageiro("valdir", "32541089754");

        //criando a viagem
        Viagem viagem =new Viagem(4, "Salvador");

        //adicionando o piloto na vaigem. ele ta pegando o piloto que a gente acabou de criar
        viagem.setPiloto(piloto);
        //adicionando os passageiros na viagem
        viagem.setPassageiros(new ArrayList<>(List.of(passageiro1,passageiro2,passageiro3,passageiro4, passageiro5,passageiro6)));

        //exibindo a viagem
        System.out.println(viagem);

        //cadastrando a viagem dentro do banco de dados
        //criando a sessao
        Session session = HibernateUtil.getSessionFactory().openSession();
        //se der erro ver se ta pegando do import do hibernate certo

        //salvando elementos dentro do banco de dados
        //começou a salvar
        Transaction transaction = session.beginTransaction();
        //comando para salvar com o parametro dq quer salvar
        session.persist(viagem);
        //finalizando o salvamento
        transaction.commit();

        //buscando a viagem
        List<Viagem> viagems = session.createQuery("From Viagem", Viagem.class).list();

        //percorrer
        for (Viagem v: viagems){
            System.out.println(v);
        }
//        //criando mais passageiros para testar a funcionalidade, pra ver se da erro
//        Passageiro passageiro5 = new Passageiro("edson", "58974630215");
//        Passageiro passageiro6 = new Passageiro("valdir", "32541089754");
//
//        //add esses passageiros no viagem (exclusivamente esses passageiros)
//        viagems.get(0).addPassageiro(passageiro5);
//        viagems.get(0).addPassageiro(passageiro6);
//        //viagems.get(0).getPassageiros().add(passageiro5); (sem o metodo addpassageiro)
//        //viagems.get(0).getPassageiros().add(passageiro6);(sem o metodo addpassageiro)
//        //vendo se os passageiros foram add
//        System.out.println(viagems.get(0));


    }
}
