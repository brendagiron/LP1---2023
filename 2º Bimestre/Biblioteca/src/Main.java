
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca("Jade", new Dono("Sofia", "45435454634"));

       biblioteca.addLivros(new Livros("Salem", "Marina", 2008));
        biblioteca.addLivros(new Livros("Deuses de Neon", "Katee Robert", 2020));
       biblioteca.addFuncionarios(new Funcionarios("Isabela", "2344498617"));

       biblioteca.mostrarFuncionarios();

       biblioteca.mostrarLivros();

    }
}