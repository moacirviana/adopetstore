package br.com.alura.adopetstore.controller;

import br.com.alura.adopetstore.dto.CadastroPedidoDTO;
import br.com.alura.adopetstore.dto.PedidoDTO;
import br.com.alura.adopetstore.email.EmailPedidoRealizado;
import br.com.alura.adopetstore.model.Usuario;
import br.com.alura.adopetstore.service.PedidoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("pedidos")
public class PedidoController {

    @Autowired
    private PedidoService service;
    @Autowired
    private EmailPedidoRealizado email;
    @PostMapping
    public ResponseEntity<PedidoDTO> cadastrar(@Valid @RequestBody CadastroPedidoDTO dto, @AuthenticationPrincipal Usuario usuario) {
        var pedido = this.service.cadastrar(dto, usuario);
        System.out.println("Thread do email " + Thread.currentThread().getName());
        email.enviar(pedido, usuario);
        return ResponseEntity.ok(pedido);
    }

    @GetMapping("/{pedido_id}")
    public ResponseEntity<PedidoDTO> findById(@PathVariable Long pedido_id, @AuthenticationPrincipal Usuario usuario) {
        PedidoDTO pedido = this.service.findById(pedido_id);
        //email.enviar(pedido, usuario);
        return ResponseEntity.ok(pedido);
    }
}
