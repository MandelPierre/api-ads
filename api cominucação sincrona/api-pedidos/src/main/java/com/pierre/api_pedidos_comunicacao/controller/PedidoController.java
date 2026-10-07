    package com.pierre.api_pedidos_comunicacao.controller;

    import com.pierre.api_pedidos_comunicacao.model.Pedido;
    import com.pierre.api_pedidos_comunicacao.model.ProdutoResposta;
    import org.springframework.web.bind.annotation.PostMapping;
    import org.springframework.web.bind.annotation.RequestBody;
    import org.springframework.web.bind.annotation.RequestMapping;
    import org.springframework.web.bind.annotation.RestController;
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

            return null;
        }

    }
