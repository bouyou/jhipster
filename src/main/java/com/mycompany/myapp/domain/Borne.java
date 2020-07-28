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
@Document(collection = "Borne")
public class Borne implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private String id;

    @Field("x")
    private Double x;

    @Field("y")
    private Double y;

    @Field("amenageur")
    private String amenageur;

    @Field("operateur")
    private String operateur;

    @Field("nenseigne")
    private String enseigne;

    @Field("idstation")
    private String idstation;

    @Field("nstation")
    private String station;

    @Field("adstation")
    private String adstation;

    @Field("codeinsee")
    private Integer codeinsee;

    @Field("xlongitude")
    private Double xlongitude;

    @Field("ylatitude")
    private Double ylatitude;

    @Field("nbrepdc")
    private Integer nbrepdc;

    @Field("idpdc")
    private Integer idpdc;

    @Field("puissmax")
    private String puissmax;

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

    public Double getX() {
        return x;
    }

    public Borne x(Double x) {
        this.x = x;
        return this;
    }

    public void setX(Double x) {
        this.x = x;
    }

    public Double getY() {
        return y;
    }

    public Borne y(Double y) {
        this.y = y;
        return this;
    }

    public void setY(Double y) {
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
        return enseigne;
    }

    public Borne nenseigne(String enseigne) {
        this.enseigne = enseigne;
        return this;
    }

    public void setNenseigne(String enseigne) {
        this.enseigne = enseigne;
    }

    public String getIdstation() {
        return idstation;
    }

    public Borne idstation(String idstation) {
        this.idstation = idstation;
        return this;
    }

    public void setIdstation(String idstation) {
        this.idstation = idstation;
    }

    public String getNstation() {
        return station;
    }

    public Borne nstation(String nstation) {
        this.station = nstation;
        return this;
    }

    public void setNstation(String nstation) {
        this.station = nstation;
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

    public Integer getCodeinsee() {
        return codeinsee;
    }

    public Borne codeinsee(Integer codeinsee) {
        this.codeinsee = codeinsee;
        return this;
    }

    public void setCodeinsee(Integer codeinsee) {
        this.codeinsee = codeinsee;
    }

    public Double getXlongitude() {
        return xlongitude;
    }

    public Borne xlongitude(Double xlongitude) {
        this.xlongitude = xlongitude;
        return this;
    }

    public void setXlongitude(Double xlongitude) {
        this.xlongitude = xlongitude;
    }

    public Double getYlatitude() {
        return ylatitude;
    }

    public Borne ylatitude(Double ylatitude) {
        this.ylatitude = ylatitude;
        return this;
    }

    public void setYlatitude(Double ylatitude) {
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

    public String getPuissmax() {
        return puissmax;
    }

    public Borne puissmax(String puissmax) {
        this.puissmax = puissmax;
        return this;
    }

    public void setPuissmax(String puissmax) {
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
