import java.io.*;
import java.util.Scanner;


public class main {

	public static void main(String[] args) {
		
		int novaLargura = 80; // Nova largura desejada
	    int novaAltura = 80; // Nova altura desejada
		String inputFile = "/home/adriano/Imagens/PDI/Entrada_EscalaCinza.pgm"; // Caminho da imagem de entrada
        String outputFile = "/home/adriano/Imagens/PDI/resultado"+novaLargura+"-por-"+novaAltura+".pgm"; // Caminho da imagem redimensionada de saída
       

        try {
            // Carrega a imagem PGM de entrada
            FileInputStream inputStream = new FileInputStream(inputFile);
            Scanner scanner = new Scanner(inputStream);
            
            // Lê o cabeçalho da imagem PGM
            String tipoImagem = scanner.nextLine();
            int largura = scanner.nextInt();
            int altura = scanner.nextInt();
            int valorMaximo = scanner.nextInt();
            
            // Cria uma nova imagem PGM redimensionada
            int[][] pixels = new int[altura][largura];
            for (int y = 0; y < altura; y++) {
                for (int x = 0; x < largura; x++) {
                    pixels[y][x] = scanner.nextInt();
                }
            }
            
            // Calcula a escala de redimensionamento
            double xScala = (double) novaLargura / largura;
            double yScala = (double) novaAltura / altura;
            
            // Cria uma nova matriz para a imagem redimensionada
            int[][] redimPixels = new int[novaLargura][novaLargura];
            for (int y = 0; y < novaAltura; y++) {
                for (int x = 0; x < novaLargura; x++) {
                    int origX = (int) (x / xScala);
                    int origY = (int) (y / yScala);
                    redimPixels[y][x] = pixels[origY][origX];
                }
            }
            
         // Salva a nova imagem PGM redimensionada
            FileWriter writer = new FileWriter(outputFile);
            writer.write(tipoImagem + "\n");
            writer.write(novaLargura + " " + novaAltura + "\n");
            writer.write(valorMaximo + "\n");
            for (int y = 0; y < novaAltura; y++) {
                for (int x = 0; x < novaLargura; x++) {
                    writer.write(redimPixels[y][x] + " ");
                }
                writer.write("\n");
            }
            writer.close();
            
            System.out.println("Imagem PGM redimensionada com sucesso!");
        } catch (IOException e) {
            System.out.println("Erro ao redimensionar a imagem PGM: " + e.getMessage());
        }
                
	}

}
