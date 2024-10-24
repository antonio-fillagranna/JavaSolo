public class JogoDaVelha {

  public static void main(String[] args) 
  {
    char[] tabuleiro = { '1', '2', '3', 
                         '4', '5', '6', 
                         '7', '8', '9' };

    var numeroDeJogadas = 0;
    var vezDoJogador = 'x';

    while (numeroDeJogadas < 9) 
    {
      imprimirTabuleiro(tabuleiro);
      System.out.printf("Escolha uma posição, jogador %s:", vezDoJogador);
      var scanner = new java.util.Scanner(System.in);
      var entrada = scanner.nextInt();
      tabuleiro[entrada - 1] = vezDoJogador;

      if (  (tabuleiro[0] + tabuleiro[1] + tabuleiro[2] == (vezDoJogador * 3))
         || (tabuleiro[3] + tabuleiro[4] + tabuleiro[5] == (vezDoJogador * 3))
         || (tabuleiro[6] + tabuleiro[7] + tabuleiro[8] == (vezDoJogador * 3))
         || (tabuleiro[0] + tabuleiro[3] + tabuleiro[6] == (vezDoJogador * 3))
         || (tabuleiro[1] + tabuleiro[4] + tabuleiro[7] == (vezDoJogador * 3))
         || (tabuleiro[2] + tabuleiro[5] + tabuleiro[8] == (vezDoJogador * 3))
         || (tabuleiro[0] + tabuleiro[4] + tabuleiro[8] == (vezDoJogador * 3))
         || (tabuleiro[2] + tabuleiro[4] + tabuleiro[6] == (vezDoJogador * 3))
      ) 
      {
         imprimirTabuleiro(tabuleiro);
         System.out.println("Você venceu!!! Parabéns!");
         break;
      } else {
         numeroDeJogadas++;
         vezDoJogador = (vezDoJogador == 'x') ? 'o' : 'x';
      }
      scanner.close();
    }
  }

  private static void imprimirTabuleiro(char[] tabuleiro) 
  {
    System.out.printf("%n %s | %s | %s %n", tabuleiro[0], tabuleiro[1], tabuleiro[2]);
    System.out.println(" - + - + - ");
    System.out.printf(" %s | %s | %s %n", tabuleiro[3], tabuleiro[4], tabuleiro[5]);
    System.out.println(" - + - + - "); 
    System.out.printf(" %s | %s | %s %n%n", tabuleiro[6], tabuleiro[7], tabuleiro[8]);
  }

}