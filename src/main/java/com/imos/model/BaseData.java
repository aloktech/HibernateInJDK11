/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imos.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * The base data model having
 *
 * @author alok.meher
 */
@MappedSuperclass
public class BaseData implements IData, Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected long id;

    protected LocalDate dateOfCreate;

    protected LocalDateTime dateAndTimeOfUpdate;

    @Override
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDate getDateOfCreate() {
        return dateOfCreate;
    }

    public void setDateOfCreate(LocalDate dateOfCreate) {
        this.dateOfCreate = dateOfCreate;
    }

    public LocalDateTime getDateAndTimeOfUpdate() {
        return dateAndTimeOfUpdate;
    }

    public void setDateAndTimeOfUpdate(LocalDateTime dateAndTimeOfUpdate) {
        this.dateAndTimeOfUpdate = dateAndTimeOfUpdate;
    }

}
