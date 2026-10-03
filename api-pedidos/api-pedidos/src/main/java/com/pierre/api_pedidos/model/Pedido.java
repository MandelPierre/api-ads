package com.pierre.api_pedidos.model;

import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;

public class Pedido {
    private Long id;
    private String nomeCliente;
    private String status;
    private LocalDate data;
    private List<ItemPedido> itens;

    public Pedido() {
        this.itens = new ArrayList<>();
    }

    public Pedido(Long id, String nomeCliente, String status, LocalDate data) {
        this.id = id;
        this.nomeCliente = nomeCliente;
        this.status = status;
        this.data = data;
        this.itens = new ArrayList<>();
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<ItemPedido> getItens() {
        return itens;
    }
}
