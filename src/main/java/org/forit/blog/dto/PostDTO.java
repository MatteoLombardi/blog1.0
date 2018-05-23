/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.forit.blog.dto;

import java.time.LocalDate;
import java.util.Objects;

/**
 *
 * @author UTENTE
 */
public class PostDTO {
    private long id,idCategoria,idAutore;
    private String titolo,descrizione;
    private LocalDate data;
    private int visite;
    private boolean visibile;

    public PostDTO() {
    }

    public PostDTO(long id, long idCategoria, long idAutore, String titolo, String descrizione, LocalDate data, int visite, boolean visibile) {
        this.id = id;
        this.idCategoria = idCategoria;
        this.idAutore = idAutore;
        this.titolo = titolo;
        this.descrizione = descrizione;
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

    public long getIdAutore() {
        return idAutore;
    }

    public void setIdAutore(long idAutore) {
        this.idAutore = idAutore;
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
        int hash = 3;
        hash = 31 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 31 * hash + (int) (this.idCategoria ^ (this.idCategoria >>> 32));
        hash = 31 * hash + (int) (this.idAutore ^ (this.idAutore >>> 32));
        hash = 31 * hash + Objects.hashCode(this.titolo);
        hash = 31 * hash + Objects.hashCode(this.descrizione);
        hash = 31 * hash + Objects.hashCode(this.data);
        hash = 31 * hash + this.visite;
        hash = 31 * hash + (this.visibile ? 1 : 0);
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
        final PostDTO other = (PostDTO) obj;
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
        return "PostDTO{" + "id=" + id + ", idCategoria=" + idCategoria + ", idAutore=" + idAutore + ", titolo=" + titolo + ", descrizione=" + descrizione + ", data=" + data + ", visite=" + visite + ", visibile=" + visibile + '}';
    }

    
}
