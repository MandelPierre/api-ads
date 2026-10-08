    package com.pierre.api_pedidos_comunicacao.controller;

    import com.pierre.api_pedidos_comunicacao.model.Pedido;
    import com.pierre.api_pedidos_comunicacao.model.ProdutoResposta;
    import org.springframework.web.bind.annotation.*;
    import org.springframework.web.client.RestClient;

    import java.util.ArrayList;
    import java.util.List;

    @RestController
    @RequestMapping("/pedidos")
    public class PedidoController {
        private List<Pedido> pedidos = new ArrayList<>();
        private long proximoId = 1L;
        private RestClient clienteProdutos = RestClient.create("http://localhost:8080");

        private ProdutoResposta buscarProduto(Long produtoId) {
            return clienteProdutos.get()
                    .uri("/produtos/{id}", produtoId)
                    .retrieve()
                    .body(ProdutoResposta.class);
        }

        @PostMapping
        public Pedido criarPedido(@RequestBody Pedido pedido) {
            ProdutoResposta produto = buscarProduto(pedido.getProdutoId());
            if (produto == null) {
                pedido.setStatus("PRODUTO_NAO_ENCONTRADO");
                return pedido;
            }
            if (produto.getQtdDisponivel() < pedido.getQuantidade()) {
                pedido.setStatus("SEM_ESTOQUE");
                return pedido;
            }

            int novoEstoque = produto.getQtdDisponivel() - pedido.getQuantidade();
            produto.setQtdDisponivel(novoEstoque);

            atualizarEstoque(produto);

            return null;
        }

        private void atualizarEstoque(ProdutoResposta produto) {
            clienteProdutos.put()
                    .uri("/produtos/{id}", produto.getId())
                    .body(produto)
                    .retrieve()
                    .toBodilessEntity();
        }

    }
