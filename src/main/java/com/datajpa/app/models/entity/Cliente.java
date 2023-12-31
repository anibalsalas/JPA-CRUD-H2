package com.datajpa.app.models.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

import java.util.Date;
import java.text.SimpleDateFormat;


@Entity
@Table(name="clientes")
public class Cliente implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
   @NotEmpty
   private String nombre;
    @NotEmpty
   private String apellido;
    @NotEmpty
    @Email
   private String email;

    @NotNull
   @Column(name = "create_at")
    @Temporal(TemporalType.DATE)
   @DateTimeFormat(pattern = "dd-MM-yyyy")
   private Date createAt;

   /*
   @PrePersist
   public void prePersist(){
       createAt = new Date();
   }
*/
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }



    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public String getFormattedCreateAt() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return formatter.format(this.createAt);
    }

    private static final long serialVersinoUID =1L;
}
