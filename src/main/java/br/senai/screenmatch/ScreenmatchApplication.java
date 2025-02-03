package br.senai.screenmatch;

import br.senai.screenmatch.model.DadosSerie;
import br.senai.screenmatch.service.ConsumoApi;
import br.senai.screenmatch.service.ConverterDados;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ScreenmatchApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ScreenmatchApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		var consumoApi = new ConsumoApi();
		var json = consumoApi.obterDados("https://www.omdbapi.com/?t=gilmore+girls&apikey=ae96eb08");

		System.out.println(json);

		/* json = consumoApi.obterDados("https://coffee.alexflipnote.dev/random.json");
		System.out.println(json); */

		ConverterDados conversor = new ConverterDados();
		DadosSerie dados = conversor.obterDados(json, DadosSerie.class);
		System.out.println(dados);
	}
}
