/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.forit.blog.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author UTENTE
 */
@Entity
@Table(name = "post")
public class PostEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true, nullable = false)
    private long id;

    @Column(name = "ID_CATEGORIA", unique = false, nullable = false)
    private long idCategoria;

    @Column(name = "TITOLO", unique = false, nullable = false)
    private String titolo;

    @Column(name = "DESCRIZIONE", unique = false, nullable = true)
    private String descrizione;

    @Column(name = "ID_AUTORE", unique = false, nullable = false)
    private long idAutore;

    @Column(name = "DATA", unique = false, nullable = false)
    private LocalDate data;

    @Column(name = "VISITE", unique = false, nullable = false)
    private int visite;

    @Column(name = "VISIBILE", unique = false, nullable = false)
    private boolean visibile;

    public PostEntity() {
    }

    public PostEntity(long id, long idCategoria, String titolo, String descrizione, long idAutore, LocalDate data, int visite, boolean visibile) {
        this.id = id;
        this.idCategoria = idCategoria;
        this.titolo = titolo;
        this.descrizione = descrizione;
        this.idAutore = idAutore;
        this.data = data;
        this.visite = visite;
        this.visibile = visibile;
    }
    
    public PostEntity(long idCategoria, String titolo, String descrizione, long idAutore, LocalDate data, int visite, boolean visibile) {
        this.idCategoria = idCategoria;
        this.titolo = titolo;
        this.descrizione = descrizione;
        this.idAutore = idAutore;
        this.data = data;
        this.visite = visite;
        this.visibile = visibile;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(long idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public long getIdAutore() {
        return idAutore;
    }

    public void setIdAutore(long idAutore) {
        this.idAutore = idAutore;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public int getVisite() {
        return visite;
    }

    public void setVisite(int visite) {
        this.visite = visite;
    }

    public boolean isVisibile() {
        return visibile;
    }

    public void setVisibile(boolean visibile) {
        this.visibile = visibile;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 59 * hash + (int) (this.idCategoria ^ (this.idCategoria >>> 32));
        hash = 59 * hash + Objects.hashCode(this.titolo);
        hash = 59 * hash + Objects.hashCode(this.descrizione);
        hash = 59 * hash + (int) (this.idAutore ^ (this.idAutore >>> 32));
        hash = 59 * hash + Objects.hashCode(this.data);
        hash = 59 * hash + this.visite;
        hash = 59 * hash + (this.visibile ? 1 : 0);
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
        final PostEntity other = (PostEntity) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.idCategoria != other.idCategoria) {
            return false;
        }
        if (this.idAutore != other.idAutore) {
            return false;
        }
        if (this.visite != other.visite) {
            return false;
        }
        if (this.visibile != other.visibile) {
            return false;
        }
        if (!Objects.equals(this.titolo, other.titolo)) {
            return false;
        }
        if (!Objects.equals(this.descrizione, other.descrizione)) {
            return false;
        }
        if (!Objects.equals(this.data, other.data)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "PostEntity{" + "id=" + id + ", idCategoria=" + idCategoria + ", titolo=" + titolo + ", descrizione=" + descrizione + ", idAutore=" + idAutore + ", data=" + data + ", visite=" + visite + ", visibile=" + visibile + '}';
    }

    
}
