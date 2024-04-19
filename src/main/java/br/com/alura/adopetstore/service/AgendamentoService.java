package br.com.alura.adopetstore.service;

import br.com.alura.adopetstore.email.EmailRelatorioGerado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;

@Service
public class AgendamentoService {
    @Autowired
    private RelatorioService relatorioService;

    @Autowired
    private EmailRelatorioGerado enviador;

    @Scheduled(cron = "0 21 9 * * *")
    public void envioEmailsAgendados(){
        var estoqueZerado = relatorioService.infoEstoque();
        var faturamento = relatorioService.faturamentoObtido();
        try {
            enviador.enviar(estoqueZerado.get(), faturamento.get());
        } catch (ExecutionException | InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Thread do AGendamentoService: " + Thread.currentThread().getName());
    }
}
