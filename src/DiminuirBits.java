import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class DiminuirBits {
	
    public static String DiminuirBits(String inputFile2, int tamanhoBits, int tamanhoDesejado) throws IOException {
    	
    	// Carrega a imagem PGM de entrada
        FileInputStream inputStream2 = new FileInputStream(inputFile2);
        Scanner scanner = new Scanner(inputStream2);
        
        // Lê o cabeçalho da imagem PGM
        String tipoImagem = scanner.nextLine();
        int largura = scanner.nextInt();
        int altura = scanner.nextInt();
        int valorMaximo = scanner.nextInt();
        	
        String outputFile2 = "/home/adriano/Imagens/PDI/resultado5B.pgm"; // Caminho da imagem redimensionada de saída
        FileWriter writer = new FileWriter(outputFile2);
        writer.write(tipoImagem + "\n");
        writer.write(largura + " " + altura + "\n");
        writer.write(tamanhoDesejado + "\n");
        
        for (int y = 0; y < altura; y++) {
            for (int x = 0; x < largura; x++) {
                int bits = scanner.nextInt();
                int cincoBits = bits / tamanhoBits;
                writer.write(cincoBits + " ");
            }
            writer.write("\n");
        }
        writer.close();
    	
    	String teste = "OK";
        
        return teste;
    }
    
public static String GanhoBrilho(String inputFile2, double ganho) throws IOException {
    	
    	// Carrega a imagem PGM de entrada
        FileInputStream inputStream2 = new FileInputStream(inputFile2);
        Scanner scanner = new Scanner(inputStream2);
        
        // Lê o cabeçalho da imagem PGM
        String tipoImagem = scanner.nextLine();
        int largura = scanner.nextInt();
        int altura = scanner.nextInt();
        int valorMaximo = scanner.nextInt();
        	
        String outputFile2 = "/home/adriano/Imagens/PDI/resultadoGanhoBrilho.pgm"; // Caminho da imagem redimensionada de saída
        FileWriter writer = new FileWriter(outputFile2);
        writer.write(tipoImagem + "\n");
        writer.write(largura + " " + altura + "\n");
        writer.write(valorMaximo + "\n");
        
        for (int y = 0; y < altura; y++) {
            for (int x = 0; x < largura; x++) {
                int bits = scanner.nextInt();
                int ganhoBrilho = (int) (bits * ganho);
                if (ganhoBrilho <= valorMaximo) {
                	writer.write(ganhoBrilho + " ");
                }else {
                	writer.write(valorMaximo + " ");
                }
            }
            writer.write("\n");
        }
        writer.close();
    	
    	String teste = "OK";
        
        return teste;
    }

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String inputFile = "/home/adriano/Imagens/PDI/Entrada_EscalaCinza.pgm"; // Caminho da imagem de entrada
		String inputFile2 = "/home/adriano/Imagens/PDI/resultado5B.pgm"; // Caminho da imagem de entrada
		
		DiminuirBits(inputFile, 8, 31);
		GanhoBrilho(inputFile2, 1.2);
		
	}

}
