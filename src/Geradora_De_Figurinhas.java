import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import javax.imageio.ImageIO;

public class Geradora_De_Figurinhas {
    //É necessário um método para criar uma imagem como saída
                       //Java requer que seja posicionado uma Exceção OU Try/Catch para lidar com erros em caso de não encontrar o File chamado
    public void cria(InputStream inputStream, String NomeArquivo) throws IOException {
        //Leitura da imagem
        //InputStream inputStream = new URL("https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies_10.jpg").openStream();
        BufferedImage ImagemOriginal = ImageIO.read(inputStream);
        //Criar nova imagem em memória com transparência e tamanho novo
        int largura = ImagemOriginal.getWidth();
        int altura = ImagemOriginal.getHeight();
        int NovaAltura = altura + 200;
        BufferedImage ImagemNova = new BufferedImage(largura, NovaAltura, BufferedImage.TRANSLUCENT);

        //Copiar a imagem original para a nova imagem (in memory)
        Graphics2D Graphics = (Graphics2D) ImagemNova.getGraphics(); //O nome da classe em () serve para 'forçar' a definição da classe
        Graphics.drawImage(ImagemOriginal, null, 0, 0);

        //Setar a fonte
        var FonteImagem = new Font(Font.SANS_SERIF, Font.BOLD, 64);
        Graphics.setColor(Color.YELLOW);
        Graphics.setFont(FonteImagem);

        //Escrever nova frase na imagem
        Graphics.drawString("STICKER_CREATED_IN_JAVA_BY_ENZO", 80, NovaAltura - 100);

        //Salvar em um arquivo
        ImageIO.write(ImagemNova, "png", new File(NomeArquivo));
    }

}
