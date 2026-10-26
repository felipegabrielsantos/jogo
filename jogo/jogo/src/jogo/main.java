package jogo;
import javax.swing.JOptionPane;
public class main {
	public static void main(String args[]) { 
		int win, pts, empates, derrotas,verificado, jogo, fase, falha=0;
		String PPT, r, nome="",rank="";
		String adversario[] = {"pedra","papel","tesoura"};
		String vitoria[] = {"papel","tesoura","pedra"};

		String perguntas[] = {
			    "1) Qual palavra é usada para exibir algo no console em Java?\nA) print\nB) System.out.println\nC) echo",
			    "2) Qual é o nome do método principal que inicia um programa Java?\nA) start\nB) main\nC) run",
			    "3) Qual tipo é usado para guardar texto em Java?\nA) String\nB) int\nC) boolean",
			    "4) Qual símbolo é usado para comentar uma linha em Java?\nA) #\nB) //\nC) <!-- -->",
			    "5) Qual palavra-chave é usada para criar um objeto em Java?\nA) new\nB) create\nC) make",
			};
			String gabarito[] = {"B","B","A","B","A"};
			String respostas[] = {"A","B","C"};
			
			String perguntas2[] = {
				    "1. Qual abertura começa com os lances 1.e4 c5?\nA) Siciliana\nB) Francesa\nC) Caro-Kann",
				    "2. Qual enxadrista venceu Spassky no Campeonato Mundial de 1972?\nA) Karpov\nB) Fischer\nC) Kasparov",
				    "3. Em que ano foi fundada a FIDE, a federação internacional de xadrez?\nA) 1900\nB) 1924\nC) 1950",
				    "4. Qual defesa começa com o lance 1.e4 c6?\nA) Escandinava\nB) Pirc\nC) Caro-Kann",
				    "5. Qual partida de 1851 é conhecida como \"Partida Imortal\"?\nA) Anderssen x Kieseritzky\nB) Morphy x Duque de Brunswick\nC) Steinitz x Zukertort",
				    "6. Qual gambito começa com 1.d4 d5 2.c4, oferecendo um peão para ganhar o controle do centro?\nA) Gambito da Dama\nB) Gambito do Rei\nC) Gambito Evans",
				    "7. Qual o nome da variate da Caro-Kann que consiste nos lances: 1. e4 c6 2. d4 d5 3. e5 Bf5 4. h4?\nA) Variante do Recuo\nB) Contra-ataque Botvinnik \nC) Variante Tal",
				    "8. Quantas casas o Cavalo pode atingir a partir de uma casa central, como d4?\nA) 6\nB) 8\nC) 10",
				    "9. Qual enxadrista alcançou a maior distancia em pontos de Rating dos jogadores mais fortes de sua época?\nA) Garry Kasparov\nB) Magnus Carlsen\nC) Bobby Fischer",
				    "10. Segundo as regras oficiais da FIDE, em um final de Rei e Bispo contra Rei e Bispo, sob qual condição a partida é considerada empate automático por falta de material suficiente para dar xeque-mate?\nA) Quando os bispos estão em casas de cores iguais\nB) Quando os bispos estão em casas de cores opostas\nC) Em qualquer situação com apenas essas peças no tabuleiro"
				};
			String gabarito2[] = {"A","B","B","C","A","A","C","B","C","C"};
		
		do {
			if (falha != 1) {
			JOptionPane.showMessageDialog(null,"Você vai jogar um jogo de 3 fases, se perder, volta do inicio."
					+ "\nJogo 1 - Pedra-Papel-Tesoura"
					+ "\nJogo 2 - Perguntas sobre Java"
					+ "\nJogo 3 - Perguntas sobre xadrez"
					+ "\nBoa sorte :)");
			nome = JOptionPane.showInputDialog("Para competitividade insira um nick");
			}
			win = 0; pts=0; empates=0; derrotas=0; jogo=1; fase=1;
			
			//fase 1 pedra papel tesoura
			if (fase == 1){
			for (int i = 0; i < 3; i++) {
				PPT = (JOptionPane.showInputDialog("ROUND " + (i+1) + "/3\nescolha entre: \n - pedra \n - papel \n - tesoura")).toLowerCase();
				verificado = 0;
				for (int a = 0; a < 3; a++) {
					if (PPT.equals(adversario[a])) {
						verificado = 1;
					}
				}
				
				if (verificado == 1) {
					if (PPT.equals(vitoria[i])) {
						win ++;
						pts = pts + 15;
						JOptionPane.showMessageDialog(null, "resultado da rodada " + (i+1) + "º: \nVocê venceu a rodada com " + PPT +"\n\nplacar atual:\n" + win +"-"+empates+"-"+derrotas);
					} else if (PPT.equals(adversario[i])) {
						empates ++;
						JOptionPane.showMessageDialog(null, "resultado da rodada " + (i+1) + "º: \nVocê jogou o mesmo que seu adversário"+"\n\nplacar atual:\n" + win +"-"+empates+"-"+derrotas);
					} else {
						derrotas++;
						pts = pts - 15; 
						JOptionPane.showMessageDialog(null, "resultado da rodada " + (i+1) + "º: \nVocê jogou '" + PPT + "' contra '" + adversario[i] + "'\nvocê perdeu"+"\n\n"
								+ "placar atual:\n" + win +"-"+empates+"-"+derrotas);
					}
				} else {
					JOptionPane.showMessageDialog(null, "Por favor selecione uma jogada valida");
					i = i - 1;
				}
			}
			if (win >= 2) {
				fase = 2;
				JOptionPane.showMessageDialog(null, "Parabens você venceu com " + win + "/3 \nvocê ira seguir para a proxima fase com " + pts + " pontos");
			} else {
				fase = 1;
				JOptionPane.showMessageDialog(null, "O placar ficou " + win+"-"+empates+"-"+derrotas + " significa que você perdeu\n(você precisa no minimo duas vitorias)");
				r = (JOptionPane.showInputDialog("Você deseja interromper o jogo? responda com: \n - S\n - N")).toUpperCase();
				if (r.equals("S")) {
					jogo=1;
				} else {
					jogo=0;
					JOptionPane.showMessageDialog(null, "tente novamente " + nome);
				}
				falha = 1;
			}
			}
			
			
			//fase 2 
			if (fase == 2) {
				JOptionPane.showMessageDialog(null,"Você ira jogar um jogo de perguntas e respostas sobre java."
						+ "\nCada  pergunta respondida corretamente adicionara 15 pontos do seu total."
						+ "\nVocê só passara para a proxima fase com ao menos 60 pontos.");
				for (int i = 0; i < 5; i++) {
					r = (JOptionPane.showInputDialog(perguntas[i])).toUpperCase();
					
					verificado = 0;
					for (int a = 0; a < 3; a++) {
						if (r.equals(respostas[a])) {
							verificado = 1;
						}
					}
						
					if (verificado == 1) {
						if (r.equals(gabarito[i])) {
							pts = pts + 15;
							JOptionPane.showMessageDialog(null,"Você respondeu corretamente e ganhou +15 pontos \n\nQuantidade de pontos atualmente: "+pts);
						} else {
							JOptionPane.showMessageDialog(null,"Você respondeu "+r+" mas a resposta correta era " + gabarito[i]+ "\n\nQuantidade de pontos atualmente: "+pts);
						}
					} else {
						JOptionPane.showMessageDialog(null, "Por favor selecione uma resposta valida");
						i = i - 1;
					}
				}
				
				if (pts >= 60) {
					fase = 3;
					JOptionPane.showMessageDialog(null,"Você passou para a proxima fase com "+pts+" pontos");
				} else {
					fase = 0;
					JOptionPane.showMessageDialog(null,"Você teve apenas " + pts +" pontos\nisso te deixa a baixo do corte de 60 pontos");
					r = (JOptionPane.showInputDialog("Você deseja interromper o jogo? responda com: \n - S\n - N")).toUpperCase();
					if (r.equals("S")) {
						jogo=1;
					} else {
						jogo=0;
					}
				}
			}
			
			//fase 3
			if (fase == 3) {
				JOptionPane.showMessageDialog(null,"Você irá jogar um jogo de perguntas e respostas sobre Xadrez."
						+ "\nCada  pergunta respondida corretamente adicionara 15 pontos ao seu total.");
				for (int i = 0; i < 10; i++) {
					r = (JOptionPane.showInputDialog(perguntas2[i])).toUpperCase();
					
					verificado = 0;
					for (int a = 0; a < 3; a++) {
						if (r.equals(respostas[a])) {
							verificado = 1;
						}
					}
						
					if (verificado == 1) {
						if (r.equals(gabarito2[i])) {
							pts = pts + 15;
							JOptionPane.showMessageDialog(null,"Você respondeu corretamente e ganhou +15 pontos \n\nQuantidade de pontos atualmente: "+pts);
						} else {
							JOptionPane.showMessageDialog(null,"Você respondeu "+r+" mas a resposta correta era " + gabarito2[i]+ "\n\nQuantidade de pontos atualmente: "+pts);
						}
					} else {
						JOptionPane.showMessageDialog(null, "Por favor selecione uma resposta valida");
						i = i - 1;
					}
				}
				JOptionPane.showMessageDialog(null, "Parabens por chegar até aqui. Você fez "+pts+" pontos");
				rank = rank + nome + ": " + pts + "\n";
				JOptionPane.showMessageDialog(null, "Rank atual: \n" + rank);
				r = (JOptionPane.showInputDialog("Você deseja interromper o jogo? responda com: \n - S\n - N")).toUpperCase();
				if (r.equals("S")) {
					jogo=1;
				} else {
					jogo=0;
				}
			}
			
		} while (jogo == 0);
	}
}
