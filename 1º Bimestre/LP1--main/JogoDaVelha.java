import java.util.ArrayList;
import java.util.Scanner;

public class JogoDaVelha {
    public static void main(String[] args) {

        posicao[][] jogo = new posicao[3][3];
        boolean game = true;
        char JogadorAtual = 'X';
        String vitoria = "";
        Scanner scan = new Scanner(System.in);

        IniciarPartida(jogo);

        while(game){
            MostraTabuleiro(jogo);
            vitoria=VerificarVitoria(jogo);
            if(!vitoria.equals("")){
                System.out.println("Jogador "+vitoria+" Venceu");
                break;
            }
            try{
                if (VerificaJogada(jogo,Jogada(scan,JogadorAtual),JogadorAtual)){
                    if (JogadorAtual=='X'){
                        JogadorAtual='O';
                    }
                    else {
                        JogadorAtual='X';
                    }
                }
            }catch (Exception erro){
                System.out.printf("erro");
            }
        }
        System.out.printf("Fim de Jogo");
    }
    public static void MostraTabuleiro(posicao[][] jogo){
        LimparTabuleiro();
        System.out.println("    0   1   2");
        System.out.printf("0   %c | %c | %c %n",jogo[0][0].pegarsimbolo(),jogo[0][1].pegarsimbolo(),jogo[0][2].pegarsimbolo());
        System.out.println("   -------------");
        System.out.printf("1   %c | %c | %c %n",jogo[1][0].pegarsimbolo(),jogo[1][1].pegarsimbolo(),jogo[1][2].pegarsimbolo());
        System.out.println("   -------------");
        System.out.printf("2   %c | %c | %c %n",jogo[2][0].pegarsimbolo(),jogo[2][1].pegarsimbolo(),jogo[2][2].pegarsimbolo());
    }

    public static void LimparTabuleiro() {
        for(int cont=0; cont<200; cont++){
            System.out.println("");
        }
    }

    public static int[] Jogada(Scanner scan, char jogadoratual){
        int j[]= new int [2];
        System.out.printf("%s %c%n", "Quem Joga: ", jogadoratual);
        System.out.print("Informa a Linha: ");
        j[0]=scan.nextInt();
        System.out.print("Informa a Coluna: ");
        j[1]=scan.nextInt();
        return j;
    }

    public static boolean VerificaJogada(posicao[][] jogo, int j[], char JoagadorAtual){
        if(jogo[j[0]][j[1]].pegarsimbolo()==' '){
            jogo[j[0]][j[1]].setdefinirsimbolo(JoagadorAtual);
            return true;
        }
        else {
            System.out.println("Posição já escolhida! Digite novamente.");
            return false;
        }
    }

    public static void IniciarPartida(posicao[][] jogo){
        for (int l=0; l<3; l++){
            for (int c=0;c<3;c++){
                jogo[l][c]= new posicao();
            }
        }
    }

    public static String VerificarVitoria (posicao[][] jogo){
        for (int linha = 0; linha < 3; linha++) {
            if (jogo[linha][0].pegarsimbolo() == jogo[linha][1].pegarsimbolo() && jogo[linha][1].pegarsimbolo() == jogo[linha][2].pegarsimbolo() && jogo[linha][0].pegarsimbolo() != ' ') {
                return Character.toString(jogo[linha][0].pegarsimbolo());
            }
        }
        for (int coluna = 0; coluna < 3; coluna++) {
            if (jogo[0][coluna].pegarsimbolo() == jogo[1][coluna].pegarsimbolo() && jogo[1][coluna].pegarsimbolo() == jogo[2][coluna].pegarsimbolo() && jogo[0][coluna].pegarsimbolo() != ' ') {
                return Character.toString(jogo[0][coluna].pegarsimbolo());
            }
        }
        if (jogo[0][0].pegarsimbolo() == jogo[1][1].pegarsimbolo() && jogo[1][1].pegarsimbolo() == jogo[2][2].pegarsimbolo() && jogo[0][0].pegarsimbolo() != ' ') {
            return Character.toString(jogo[0][0].pegarsimbolo());
        }
        if (jogo[0][2].pegarsimbolo() == jogo[1][1].pegarsimbolo() && jogo[1][1].pegarsimbolo() == jogo[2][0].pegarsimbolo() && jogo[0][2].pegarsimbolo() != ' ') {
            return Character.toString(jogo[0][2].pegarsimbolo());
        }
        return "";
    }


}
