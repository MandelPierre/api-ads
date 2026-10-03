package com.pierre.api_pedidos.controller;

import com.pierre.api_pedidos.model.ItemPedido;
import com.pierre.api_pedidos.model.Pedido;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.ArrayList;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {
    private List<Pedido> pedidos = new ArrayList<>();
    private long proximoId = 1;
    private long proximoIdItem = 1;

    @PostMapping
    public Pedido gerarPedido(@RequestBody Pedido pedido) {
        pedido.setId(this.proximoId);
        proximoId++;
        pedidos.add(pedido);
        return pedido;
    }

    @GetMapping
    public List<Pedido> listarPedidos() {
        return pedidos;
    }

    @PostMapping("{idPedido}/itens")
    public Pedido adicionarItem(@PathVariable("idPedido") Long idPedido, @RequestBody ItemPedido itemPedido) {
        for (Pedido pedido : pedidos) {
            if (pedido.getId().equals(idPedido)) {
                itemPedido.setId(proximoIdItem);
                this.proximoIdItem++;

                pedido.getItens().add(itemPedido);

                return pedido;
            }
        }

        return null;
    }

    @DeleteMapping("/{idPedido}/itens/{idItem}")
    public Pedido excluirItem(@PathVariable("idPedido") Long idPedido, @PathVariable("idItem") Long idItem) {
        for (Pedido pedido : pedidos) {
            if (pedido.getId().equals(idPedido)) {
                pedido.getItens().removeIf(item -> item.getId().equals(idItem));
                return pedido;
            }
        }

        return null;
    }
}
