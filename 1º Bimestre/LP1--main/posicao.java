public class posicao {
    private char simbolo;
    public posicao(){
        this.simbolo= ' ';
    }
    public char pegarsimbolo(){
        return this.simbolo;
    }

    public void setdefinirsimbolo(char simbolo){
        if(this.simbolo==' '){
            this.simbolo=simbolo;
        }
        else{
            System.out.println("posição já preenchida");
        }
    }
}
