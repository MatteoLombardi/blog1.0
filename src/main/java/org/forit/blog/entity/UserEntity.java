/*
 * To change this license header; choose License Headers in Project Properties.
 * To change this template file; choose Tools | Templates
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
@Table(name="account")
public class UserEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID",nullable = false,unique=false)
    private long id;
    
    @Column(name = "ID_RUOLO",nullable = false,unique=false)
    private long idRuolo;
    
    @Column(name = "NUMERO_TENTATIVI",nullable = false,unique=false)
    private long numeroTentativi;
    
    @Column(name = "NOME",nullable = false,unique=false)
    private String nome;
    
    @Column(name = "COGNOME",nullable = false,unique=false)
    private String cognome;
    
    @Column(name = "USERNAME",nullable = false,unique=false)
    private String username;
    
    @Column(name = "EMAIL",nullable = false,unique=false)
    private String email;
    
    @Column(name = "PASSWORD",nullable = false,unique=false)
    private String password;
    
    @Column(name = "ATTIVO",nullable = false,unique=false)
    private boolean attivo;
    
    @Column(name = "BLOCCATO",nullable = false,unique=false)
    private boolean bloccato;
    
    @Column(name = "DATA_REGISTRAZIONE",nullable = false,unique=false)
    private LocalDate dataIscrizione;
    
    @Column(name = "DATA_ULTIMO_ACCESSO",nullable = false,unique=false)
    private LocalDate dataUltimoAccesso;

    public UserEntity() {
    }

    public UserEntity(long id, long idRuolo, long numeroTentativi, String nome, String cognome, String username, String email, String password, boolean attivo, boolean bloccato, LocalDate dataIscrizione, LocalDate dataUltimoAccesso) {
        this.id = id;
        this.idRuolo = idRuolo;
        this.numeroTentativi = numeroTentativi;
        this.nome = nome;
        this.cognome = cognome;
        this.username = username;
        this.email = email;
        this.password = password;
        this.attivo = attivo;
        this.bloccato = bloccato;
        this.dataIscrizione = dataIscrizione;
        this.dataUltimoAccesso = dataUltimoAccesso;
    }
    
    public UserEntity(long idRuolo, long numeroTentativi, String nome, String cognome, String username, String email, String password, boolean attivo, boolean bloccato, LocalDate dataIscrizione, LocalDate dataUltimoAccesso) {
        this.idRuolo = idRuolo;
        this.numeroTentativi = numeroTentativi;
        this.nome = nome;
        this.cognome = cognome;
        this.username = username;
        this.email = email;
        this.password = password;
        this.attivo = attivo;
        this.bloccato = bloccato;
        this.dataIscrizione = dataIscrizione;
        this.dataUltimoAccesso = dataUltimoAccesso;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getIdRuolo() {
        return idRuolo;
    }

    public void setIdRuolo(long idRuolo) {
        this.idRuolo = idRuolo;
    }

    public long getNumeroTentativi() {
        return numeroTentativi;
    }

    public void setNumeroTentativi(long numeroTentativi) {
        this.numeroTentativi = numeroTentativi;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isAttivo() {
        return attivo;
    }

    public void setAttivo(boolean attivo) {
        this.attivo = attivo;
    }

    public boolean isBloccato() {
        return bloccato;
    }

    public void setBloccato(boolean bloccato) {
        this.bloccato = bloccato;
    }

    public LocalDate getDataIscrizione() {
        return dataIscrizione;
    }

    public void setDataIscrizione(LocalDate dataIscrizione) {
        this.dataIscrizione = dataIscrizione;
    }

    public LocalDate getDataUltimoAccesso() {
        return dataUltimoAccesso;
    }

    public void setDataUltimoAccesso(LocalDate dataUltimoAccesso) {
        this.dataUltimoAccesso = dataUltimoAccesso;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 53 * hash + (int) (this.idRuolo ^ (this.idRuolo >>> 32));
        hash = 53 * hash + (int) (this.numeroTentativi ^ (this.numeroTentativi >>> 32));
        hash = 53 * hash + Objects.hashCode(this.nome);
        hash = 53 * hash + Objects.hashCode(this.cognome);
        hash = 53 * hash + Objects.hashCode(this.username);
        hash = 53 * hash + Objects.hashCode(this.email);
        hash = 53 * hash + Objects.hashCode(this.password);
        hash = 53 * hash + (this.attivo ? 1 : 0);
        hash = 53 * hash + (this.bloccato ? 1 : 0);
        hash = 53 * hash + Objects.hashCode(this.dataIscrizione);
        hash = 53 * hash + Objects.hashCode(this.dataUltimoAccesso);
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
        final UserEntity other = (UserEntity) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.idRuolo != other.idRuolo) {
            return false;
        }
        if (this.numeroTentativi != other.numeroTentativi) {
            return false;
        }
        if (this.attivo != other.attivo) {
            return false;
        }
        if (this.bloccato != other.bloccato) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.cognome, other.cognome)) {
            return false;
        }
        if (!Objects.equals(this.username, other.username)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.password, other.password)) {
            return false;
        }
        if (!Objects.equals(this.dataIscrizione, other.dataIscrizione)) {
            return false;
        }
        if (!Objects.equals(this.dataUltimoAccesso, other.dataUltimoAccesso)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "AccountEntity{" + "id=" + id + ", idRuolo=" + idRuolo + ", numeroTentativi=" + numeroTentativi + ", nome=" + nome + ", cognome=" + cognome + ", username=" + username + ", email=" + email + ", password=" + password + ", attivo=" + attivo + ", bloccato=" + bloccato + ", dataIscrizione=" + dataIscrizione + ", dataUltimoAccesso=" + dataUltimoAccesso + '}';
    }
}
