package com.vijay.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Date;
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Tutorial")
public class Tutorial
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  long id;
    private  String title;
    private String description;
    private  int level;
    private  boolean published;
    //@Temporal(TemporalType.DATE) drops the time value and only preserves the date.
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
}
