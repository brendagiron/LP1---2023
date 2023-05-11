import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    private String nome;
    private Dono dono;
    private List<Livros> livros = new ArrayList<>();
    private List<Funcionarios> funcionarios = new ArrayList<>();

    public Biblioteca(String nome, Dono dono) {
        this.nome = nome;
        this.dono = dono;
    }

    public String getNome() {
        return nome;
    }

    public List<Livros> getLivros() {
        return livros;
    }

    public void setLivros(List<Livros> livros) {
        this.livros = livros;
    }

    public List<Funcionarios> getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(List<Funcionarios> funcionarios) {
        this.funcionarios = funcionarios;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Dono getDono() {
        return dono;
    }

    public void setDono(Dono dono) {
        this.dono = dono;
    }

    public void addLivros(Livros novoLivro){
        livros.add(novoLivro);
    }

    public void addFuncionarios(Funcionarios novoFuncionario){
        funcionarios.add(novoFuncionario);
    }

    public void mostrarLivros(){
        for (Livros livros: this.livros) {
            System.out.println("Livro: " + livros.getNome());
            System.out.println("Autor: " + livros.getAutor());
            System.out.println("Ano: " + livros.getAno());
            System.out.println("_______________________________________");
        }
    }

    public void mostrarFuncionarios(){
        for (Funcionarios funcionarios: this.funcionarios) {
            System.out.println("Funcionário:" + funcionarios.getNome());
            System.out.println("CPF:" + funcionarios.getCPF() );
            System.out.println("_______________________________________");
        }
    }


}
