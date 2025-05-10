package br.com.smartpark.model;

import jakarta.persistence.*;

// Criação de entidades, tabelas no BD
@Entity
@Table(name = "tb_cadastro_vagas")
public class ParkingSpotModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String endereco;
    private boolean disponivel;

    public ParkingSpotModel() {
    }

    public ParkingSpotModel(Long id, String endereco, boolean disponivel) {
        this.id = id;
        this.endereco = endereco;
        this.disponivel = disponivel;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }
}
