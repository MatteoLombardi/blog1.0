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
import javax.persistence.Table;

/**
 *
 * @author UTENTE
 */
@Entity
@Table(name="commento")
public class CommentoEntity implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID",nullable = false,unique = true)
    private long id;
    
    @Column(name = "ID_POST",nullable = false,unique = true)
    private long idPost;
    
    @Column(name = "NICKNAME",nullable = false,unique = true)
    private String nickname;
    
    @Column(name = "EMAIL",nullable = false,unique = true)
    private String email;
    
    @Column(name = "TESTO",nullable = false,unique = true)
    private String testo;
    
    @Column(name = "RISPOSTA",nullable = false,unique = true)
    private String risposta;
    
    @Column(name = "DATA_INSERIMENTO",nullable = false,unique = true)
    private LocalDate dataInserimento;
    
    @Column(name = "DATA_RISPOSTA",nullable = false,unique = true)
    private LocalDate dataRisposta;
    
    @Column(name = "VISIBILE",nullable = false,unique = true)
    private boolean visibile;

    public CommentoEntity() {
    }

    public CommentoEntity(long id, long idPost, String nickname, String email, String testo, String risposta, LocalDate dataInserimento, LocalDate dataRisposta, boolean visibile) {
        this.id = id;
        this.idPost = idPost;
        this.nickname = nickname;
        this.email = email;
        this.testo = testo;
        this.risposta = risposta;
        this.dataInserimento = dataInserimento;
        this.dataRisposta = dataRisposta;
        this.visibile = visibile;
    }

    public CommentoEntity(long idPost, String nickname, String email, String testo, String risposta, LocalDate dataInserimento, LocalDate dataRisposta, boolean visibile) {
        this.idPost = idPost;
        this.nickname = nickname;
        this.email = email;
        this.testo = testo;
        this.risposta = risposta;
        this.dataInserimento = dataInserimento;
        this.dataRisposta = dataRisposta;
        this.visibile = visibile;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getIdPost() {
        return idPost;
    }

    public void setIdPost(long idPost) {
        this.idPost = idPost;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTesto() {
        return testo;
    }

    public void setTesto(String testo) {
        this.testo = testo;
    }

    public String getRisposta() {
        return risposta;
    }

    public void setRisposta(String risposta) {
        this.risposta = risposta;
    }

    public LocalDate getDataInserimento() {
        return dataInserimento;
    }

    public void setDataInserimento(LocalDate dataInserimento) {
        this.dataInserimento = dataInserimento;
    }

    public LocalDate getDataRisposta() {
        return dataRisposta;
    }

    public void setDataRisposta(LocalDate dataRisposta) {
        this.dataRisposta = dataRisposta;
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
        hash = 89 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 89 * hash + (int) (this.idPost ^ (this.idPost >>> 32));
        hash = 89 * hash + Objects.hashCode(this.nickname);
        hash = 89 * hash + Objects.hashCode(this.email);
        hash = 89 * hash + Objects.hashCode(this.testo);
        hash = 89 * hash + Objects.hashCode(this.risposta);
        hash = 89 * hash + Objects.hashCode(this.dataInserimento);
        hash = 89 * hash + Objects.hashCode(this.dataRisposta);
        hash = 89 * hash + (this.visibile ? 1 : 0);
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
        final CommentoEntity other = (CommentoEntity) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.idPost != other.idPost) {
            return false;
        }
        if (this.visibile != other.visibile) {
            return false;
        }
        if (!Objects.equals(this.nickname, other.nickname)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.testo, other.testo)) {
            return false;
        }
        if (!Objects.equals(this.risposta, other.risposta)) {
            return false;
        }
        if (!Objects.equals(this.dataInserimento, other.dataInserimento)) {
            return false;
        }
        if (!Objects.equals(this.dataRisposta, other.dataRisposta)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "CommentoEntity{" + "id=" + id + ", idPost=" + idPost + ", nickname=" + nickname + ", email=" + email + ", testo=" + testo + ", risposta=" + risposta + ", dataInserimento=" + dataInserimento + ", dataRisposta=" + dataRisposta + ", visibile=" + visibile + '}';
    }
    
    
}
