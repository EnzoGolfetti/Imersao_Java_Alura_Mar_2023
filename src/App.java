//imports - muito semelhante ao Python
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;

//LEMBRETE = Ao final de cada linha é necessário incluir um ';'
public class App {
    public static void main(String[] args) throws Exception {
        //System.out.println("Hello, World!");
    
        //Acessar via HTTP a API do IMDB através de um GET
        //Buscar os top 250 filmes da plataforma
        //Guardar a resposta da API em uma string
        String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies.json";
        URI adress = URI.create(url);
        var client = HttpClient.newHttpClient(); //ou HttpClient client = HttpClient.newHttpClient()  
            //Lógica de orientação a objetos - guardar em uma variável declarando que é uma variável, pode ser o próprio tipo ou somente 'var' nas mais versões mais novas
        var request = HttpRequest.newBuilder(adress).GET().build(); //GET e a forma de solicitar dados de uma API no padrão HTTP
        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
        String body = response.body();
        System.out.println(body);
        
        //Filtrar e extrair apenas as informações que sejam de interesse do projeto
        //Título - Poster - Rating (Parsing)
        var parser = new JsonParser_Alura_Imersao_Java();
        List<Map<String, String>> lista_de_filmes = parser.parse(body);
        System.out.println(lista_de_filmes.size());
        System.out.println(lista_de_filmes.get(0));
        
        //Exibir e manipular os dados
        for (Map<String,String> filme : lista_de_filmes) {
            System.out.println(filme.get("title"));
            System.out.println(filme.get("image"));
            System.out.println(filme.get("imDbRating"));
            System.out.println(); //printar um espaço em branco para ser a quebra de linha em cada iteração
            
        }




    
    }
}
