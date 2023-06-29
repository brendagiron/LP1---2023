public class Main {
    public static void main(String[] args) {
        Fixo conta1 = new Fixo("Spotify", 9.99);
        Fixo conta2 = new Fixo("Prestação celular", 520.88);
        Fixo conta3 = new Fixo("VSCO", 38.40);

        Lazer teatro= new Lazer("Candlelight", 85.00);
        Lazer jogos= new Lazer("T-Rex games", 55.00);

        Variavel bolsa= new Variavel("Bolsa", 3.700, 6);
        Variavel joias= new Variavel("Joias", 908.000, 4);

        System.out.println("");
        System.out.println("Contas fixas:");
        System.out.println(conta1.getNome());
        System.out.print("Valor da conta: R$"+ conta1.getValor());

        System.out.println("");
        System.out.println("");

        System.out.println("Lazer:");
        System.out.print("Valor inicial do teatro: R$");
        System.out.println(teatro.getValor());
        teatro.mudarvalor(100.00);
        System.out.print("Valor reajustado do teatro: R$");
        System.out.println(teatro.getValor());
        System.out.println("");

        System.out.print("Valor inicial dos jogos: R$");
        System.out.println(jogos.getValor());
        jogos.mudarvalor(500);
        System.out.print("Valor reajustado dos jogos: R$");
        System.out.println(jogos.getValor());
        System.out.println("");

        System.out.println("Contas variáveis:");
        System.out.println(bolsa.getNome());
        System.out.println("Valor da conta: R$"+ bolsa.getValor());
        System.out.println("Quantidade de parcelas: "+ bolsa.getTempoMeses());
    }

    }

