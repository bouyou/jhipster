package com.mycompany.myapp.domain;

import io.swagger.annotations.ApiModel;
import java.io.Serializable;
import java.time.Instant;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * The Borne entity.
 */
@ApiModel(description = "The Borne entity.")
@Document(collection = "borne")
public class Borne implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private String id;

    @Field("x")
    private Float x;

    @Field("y")
    private Float y;

    @Field("amenageur")
    private String amenageur;

    @Field("operateur")
    private String operateur;

    @Field("nenseigne")
    private String nenseigne;

    @Field("idstation")
    private Integer idstation;

    @Field("nstation")
    private String nstation;

    @Field("adstation")
    private String adstation;

    @Field("codeinsee")
    private String codeinsee;

    @Field("xlongitude")
    private Float xlongitude;

    @Field("ylatitude")
    private Float ylatitude;

    @Field("nbrepdc")
    private Integer nbrepdc;

    @Field("idpdc")
    private Integer idpdc;

    @Field("puissmax")
    private Float puissmax;

    @Field("typeprise")
    private String typeprise;

    @Field("accesrecharge")
    private String accesrecharge;

    @Field("accessibilite")
    private String accessibilite;

    @Field("observations")
    private String observations;

    @Field("datemajnoperateur")
    private Instant datemajnoperateur;

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Float getX() {
        return x;
    }

    public Borne x(Float x) {
        this.x = x;
        return this;
    }

    public void setX(Float x) {
        this.x = x;
    }

    public Float getY() {
        return y;
    }

    public Borne y(Float y) {
        this.y = y;
        return this;
    }

    public void setY(Float y) {
        this.y = y;
    }

    public String getAmenageur() {
        return amenageur;
    }

    public Borne amenageur(String amenageur) {
        this.amenageur = amenageur;
        return this;
    }

    public void setAmenageur(String amenageur) {
        this.amenageur = amenageur;
    }

    public String getOperateur() {
        return operateur;
    }

    public Borne operateur(String operateur) {
        this.operateur = operateur;
        return this;
    }

    public void setOperateur(String operateur) {
        this.operateur = operateur;
    }

    public String getNenseigne() {
        return nenseigne;
    }

    public Borne nenseigne(String nenseigne) {
        this.nenseigne = nenseigne;
        return this;
    }

    public void setNenseigne(String nenseigne) {
        this.nenseigne = nenseigne;
    }

    public Integer getIdstation() {
        return idstation;
    }

    public Borne idstation(Integer idstation) {
        this.idstation = idstation;
        return this;
    }

    public void setIdstation(Integer idstation) {
        this.idstation = idstation;
    }

    public String getNstation() {
        return nstation;
    }

    public Borne nstation(String nstation) {
        this.nstation = nstation;
        return this;
    }

    public void setNstation(String nstation) {
        this.nstation = nstation;
    }

    public String getAdstation() {
        return adstation;
    }

    public Borne adstation(String adstation) {
        this.adstation = adstation;
        return this;
    }

    public void setAdstation(String adstation) {
        this.adstation = adstation;
    }

    public String getCodeinsee() {
        return codeinsee;
    }

    public Borne codeinsee(String codeinsee) {
        this.codeinsee = codeinsee;
        return this;
    }

    public void setCodeinsee(String codeinsee) {
        this.codeinsee = codeinsee;
    }

    public Float getXlongitude() {
        return xlongitude;
    }

    public Borne xlongitude(Float xlongitude) {
        this.xlongitude = xlongitude;
        return this;
    }

    public void setXlongitude(Float xlongitude) {
        this.xlongitude = xlongitude;
    }

    public Float getYlatitude() {
        return ylatitude;
    }

    public Borne ylatitude(Float ylatitude) {
        this.ylatitude = ylatitude;
        return this;
    }

    public void setYlatitude(Float ylatitude) {
        this.ylatitude = ylatitude;
    }

    public Integer getNbrepdc() {
        return nbrepdc;
    }

    public Borne nbrepdc(Integer nbrepdc) {
        this.nbrepdc = nbrepdc;
        return this;
    }

    public void setNbrepdc(Integer nbrepdc) {
        this.nbrepdc = nbrepdc;
    }

    public Integer getIdpdc() {
        return idpdc;
    }

    public Borne idpdc(Integer idpdc) {
        this.idpdc = idpdc;
        return this;
    }

    public void setIdpdc(Integer idpdc) {
        this.idpdc = idpdc;
    }

    public Float getPuissmax() {
        return puissmax;
    }

    public Borne puissmax(Float puissmax) {
        this.puissmax = puissmax;
        return this;
    }

    public void setPuissmax(Float puissmax) {
        this.puissmax = puissmax;
    }

    public String getTypeprise() {
        return typeprise;
    }

    public Borne typeprise(String typeprise) {
        this.typeprise = typeprise;
        return this;
    }

    public void setTypeprise(String typeprise) {
        this.typeprise = typeprise;
    }

    public String getAccesrecharge() {
        return accesrecharge;
    }

    public Borne accesrecharge(String accesrecharge) {
        this.accesrecharge = accesrecharge;
        return this;
    }

    public void setAccesrecharge(String accesrecharge) {
        this.accesrecharge = accesrecharge;
    }

    public String getAccessibilite() {
        return accessibilite;
    }

    public Borne accessibilite(String accessibilite) {
        this.accessibilite = accessibilite;
        return this;
    }

    public void setAccessibilite(String accessibilite) {
        this.accessibilite = accessibilite;
    }

    public String getObservations() {
        return observations;
    }

    public Borne observations(String observations) {
        this.observations = observations;
        return this;
    }

    public void setObservations(String observations) {
        this.observations = observations;
    }

    public Instant getDatemajnoperateur() {
        return datemajnoperateur;
    }

    public Borne datemajnoperateur(Instant datemajnoperateur) {
        this.datemajnoperateur = datemajnoperateur;
        return this;
    }

    public void setDatemajnoperateur(Instant datemajnoperateur) {
        this.datemajnoperateur = datemajnoperateur;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Borne)) {
            return false;
        }
        return id != null && id.equals(((Borne) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Borne{" +
            "id=" + getId() +
            ", x=" + getX() +
            ", y=" + getY() +
            ", amenageur='" + getAmenageur() + "'" +
            ", operateur='" + getOperateur() + "'" +
            ", nenseigne='" + getNenseigne() + "'" +
            ", idstation=" + getIdstation() +
            ", nstation='" + getNstation() + "'" +
            ", adstation='" + getAdstation() + "'" +
            ", codeinsee='" + getCodeinsee() + "'" +
            ", xlongitude=" + getXlongitude() +
            ", ylatitude=" + getYlatitude() +
            ", nbrepdc=" + getNbrepdc() +
            ", idpdc=" + getIdpdc() +
            ", puissmax=" + getPuissmax() +
            ", typeprise='" + getTypeprise() + "'" +
            ", accesrecharge='" + getAccesrecharge() + "'" +
            ", accessibilite='" + getAccessibilite() + "'" +
            ", observations='" + getObservations() + "'" +
            ", datemajnoperateur='" + getDatemajnoperateur() + "'" +
            "}";
    }
}
