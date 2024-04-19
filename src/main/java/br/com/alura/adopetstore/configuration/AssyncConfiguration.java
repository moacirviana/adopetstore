package br.com.alura.adopetstore.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

@Configuration
public class AssyncConfiguration {
    @Bean
    public Executor assyncExecutor(){
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(3); // minimo de threads criadas
        executor.setMaxPoolSize(5);
        executor.setQueueCapacity(100); // capacidade máxima da fila
        executor.setThreadNamePrefix("AsyncThread-");
        executor.initialize();
        return executor;
    }
    // Classe de configuração, como minhas Threads serão executadas
    //executor.setCorePoolSize(5);
    //executor.setMaxPoolSize(10);
    //executor.setQueueCapacity(100);
    /*
     Esta configuração é apropriada pois oferece um tamanho de pool inicial
     suficiente para lidar com transações normais e permite expansão até o máximo
     em momentos de pico, com uma fila de espera que evita rejeição imediata de tarefas.
    */
}
