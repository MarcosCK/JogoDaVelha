package trabalho;
import java.util.Scanner;

public class JogoDaVelha extends Campo {
	
	public static void main(String[] args){		
		Campo[][] velha=new Campo[3][3];
		char simboloAtual='X';
		Boolean game=true;
		char victory=' ';
		Scanner scan=new Scanner(System.in);
		startGame(velha);
		while(game){
			drawnGame(velha);
			victory=verifyVictory(velha);
			if(victory!=(' ')){
				System.out.printf("Jogador %s venceu%n",victory);
				game=false;
				break;
			}
			try{
				if(verifyVictory(velha,toPlay(scan,simboloAtual),simboloAtual)){
					if(simboloAtual=='X'){
						simboloAtual='O';
					}else{
						simboloAtual='X';
					}
				}
			}catch(Exception e){
				System.out.print("Ocurreu um erro durante o jogo:" + e);
			}
		}
		System.out.print("Fim de jogo!");
	}
	
	
	//Function para realizar template do tabuleiro/jogo
	public static void drawnGame(Campo[][] velha){
		cleanScreen();
		System.out.println("    0  1  2");
		System.out.printf("0 %c | %c | %c %n",velha[0][0].getSimbolo(),velha[0][1].getSimbolo(),velha[0][2].getSimbolo());
		System.out.printf("1 %c | %c | %c %n",velha[1][0].getSimbolo(),velha[1][1].getSimbolo(),velha[1][2].getSimbolo());
		System.out.printf("2 %c | %c | %c %n",velha[2][0].getSimbolo(),velha[2][1].getSimbolo(),velha[2][2].getSimbolo());
	}
	
	//Funcao pra Limpar tela
	public static void cleanScreen(){
		System.out.print("\033\143");
	}
	
	
	//Function para passar valor da jogada
	public static int[] toPlay(Scanner scan, char sa){
		int ponto[]=new int[2];
		System.out.printf("%s %c%n","Quem joga: ",sa);
		System.out.print("Informe a linha: ");
		ponto[0]=scan.nextInt();
		System.out.print("Informe a coluna: ");
		ponto[1]=scan.nextInt();
		return ponto;
	}
	
	//Function verifica jogada
	public static Boolean verifyVictory(Campo[][] velha, int ponto[], char simboloAtual){
		if(velha[ponto[0]][ponto[1]].getSimbolo()==' '){
			velha[ponto[0]][ponto[1]].setSimbolo(simboloAtual);
			return true;
		}else{
			return false;
		}
	}
	
	//Function inicar o Jogo
	public static void startGame(Campo[][] velha){
		for(int l=0;l<3;l++){
			for(int c=0;c<3;c++){
				velha[l][c]=new Campo();
			}
		}
	}
	
	//Function verifica quem ganhou game
	public static char verifyVictory(Campo[][] velha){
		for(int i=0;i<3;i++){
			if((velha[i][0].getSimbolo()=='X' && velha[i][1].getSimbolo()=='X' && velha[i][2].getSimbolo()=='X')||(velha[i][0].getSimbolo()=='O' && velha[i][1].getSimbolo()=='O' && velha[i][2].getSimbolo()=='O')){
				return velha[i][0].getSimbolo();
			}
		}
		for(int i=0;i<3;i++){
			if((velha[0][i].getSimbolo()=='X' && velha[1][i].getSimbolo()=='X' && velha[2][i].getSimbolo()=='X')||(velha[0][i].getSimbolo()=='O' && velha[1][i].getSimbolo()=='O' && velha[2][i].getSimbolo()=='O')){
				return velha[0][i].getSimbolo();
			}
		}
		if((velha[0][0].getSimbolo()=='X' && velha[1][1].getSimbolo()=='X' && velha[2][2].getSimbolo()=='X')||(velha[0][2].getSimbolo()=='O' && velha[1][1].getSimbolo()=='O' && velha[2][0].getSimbolo()=='O')){
			return velha[0][0].getSimbolo();
		}
		return ' ';
	}
}

