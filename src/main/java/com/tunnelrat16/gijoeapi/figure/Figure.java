package com.tunnelrat16.gijoeapi.figure;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Column;

import lombok.Data;

@Entity
@Data
@Table(name = "figure")
public class Figure {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  @Column(name = "name")
  private String name;

  @Column(name = "year")
  private String year;

  @Column(name = "team")
  private String team;

  @Column(name = "variation")
  private String variation;

  @Column(name = "image_url")
  private String imageUrl;
}