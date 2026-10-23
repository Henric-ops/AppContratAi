package com.example.appcontratai;

public class Servico {

    private int id;
    private int prestadorId;
    private String categoria;
    private String nomeServico;
    private String descricao;
    private String preco;
    private String contato;



    public Servico( int prestadorId, String categoria, String nomeServico, String descricao, String preco, String contato) {
        this.prestadorId = prestadorId;
        this.categoria = categoria;
        this.nomeServico = nomeServico;
        this.descricao = descricao;
        this.preco = preco;
        this.contato =contato;
    }

    public Servico() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrestadorId() { return prestadorId; }
    public void setPrestadorId(int prestadorId) { this.prestadorId = prestadorId; }

    public String getCategoria() { return categoria; }
    public void setCategoria(String categoria) { this.categoria = categoria; }

    public String getNomeServico() { return nomeServico; }
    public void setNomeServico(String nomeServico) { this.nomeServico = nomeServico; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public String getPreco() { return preco; }
    public void setPreco(String preco) { this.preco = preco; }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

}
