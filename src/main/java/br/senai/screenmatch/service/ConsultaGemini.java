package br.senai.screenmatch.service;

import dev.langchain4j.model.chat.ChatLanguageModel;
import dev.langchain4j.model.googleai.GoogleAiGeminiChatModel;

public class ConsultaGemini {
    public static String obterTraducao(String texto) {

        String apiKey = System.getenv("API_KEY");

        if (apiKey == null || apiKey.isEmpty()) {
            throw new IllegalStateException("A chave da API não foi definida como variável de ambiente.");
        }

        ChatLanguageModel gemini = GoogleAiGeminiChatModel.builder()
                .apiKey(apiKey)
                .modelName("gemini-1.5-flash")
                .build();

        String response = gemini.generate("Traduza para português o texto: " + texto);
        return response;
    }

}
