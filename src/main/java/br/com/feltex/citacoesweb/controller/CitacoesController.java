package br.com.feltex.citacoesweb.controller;

import br.com.feltex.citacoesweb.model.citacao.Citacao;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;


@RestController
@RequestMapping("/api")
public class CitacoesController {

    private final List<Citacao> citacoes = new ArrayList<>();

    public CitacoesController() throws IOException {
        carregarCitacoesDoArquivo();
    }

    @GetMapping
    public ResponseEntity<Citacao> lerCitacao() {
        return new ResponseEntity<>(getCitacao(), HttpStatus.OK);
    }

    private Citacao getCitacao() {
        int index = new Random().nextInt(citacoes.size());
        return citacoes.get(index);
    }


    private void carregarCitacoesDoArquivo() throws IOException {
        try (InputStream input = new ClassPathResource("citacoes.txt").getInputStream()) {
            var scanner = new Scanner(input);

            while (scanner.hasNext()) {
                citacoes.add(new Citacao(scanner.nextLine()));
            }
            scanner.close();
        }
    }
}
