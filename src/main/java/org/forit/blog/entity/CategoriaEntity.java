/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.forit.blog.entity;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author UTENTE
 */
@Entity
@Table(name = "categoria")
public class CategoriaEntity implements Serializable {

    @Id
    @Column(name = "ID", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "nome", nullable = false, unique = true)
    private String nome;

    @Column(name = "descrizione", nullable = false, unique = true)
    private String descrizione;

    @Column(name = "immagine", nullable = false, unique = true)
    private String immagine;

    @Column(name = "visibile", nullable = false, unique = true)
    private boolean visibile;

    public CategoriaEntity() {
    }

    public CategoriaEntity(long id, String nome, String descrizione, String immagine, boolean visibile) {
        this.id = id;
        this.nome = nome;
        this.descrizione = descrizione;
        this.immagine = immagine;
        this.visibile = visibile;
    }
    
    public CategoriaEntity(String nome, String descrizione, String immagine, boolean visibile) {
        this.nome = nome;
        this.descrizione = descrizione;
        this.immagine = immagine;
        this.visibile = visibile;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public String getImmagine() {
        return immagine;
    }

    public void setImmagine(String immagine) {
        this.immagine = immagine;
    }

    public boolean isVisibile() {
        return visibile;
    }

    public void setVisibile(boolean visibile) {
        this.visibile = visibile;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 11 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 11 * hash + Objects.hashCode(this.nome);
        hash = 11 * hash + Objects.hashCode(this.descrizione);
        hash = 11 * hash + Objects.hashCode(this.immagine);
        hash = 11 * hash + (this.visibile ? 1 : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final CategoriaEntity other = (CategoriaEntity) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.visibile != other.visibile) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.descrizione, other.descrizione)) {
            return false;
        }
        if (!Objects.equals(this.immagine, other.immagine)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "CategoriaEntity{" + "id=" + id + ", nome=" + nome + ", descrizione=" + descrizione + ", immagine=" + immagine + ", visibile=" + visibile + '}';
    }

}
