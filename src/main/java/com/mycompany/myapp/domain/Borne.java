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

    @Field("X")
    private Double x;

    @Field("Y")
    private Double y;

    @Field("amenageur")
    private String amenageur;

    @Field("operateur")
    private String operateur;

    @Field("enseigne")
    private String enseigne;

    @Field("idstation")
    private String idstation;

    @Field("station")
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
    private String nbrepdc;

    @Field("idpdc")
    private String idpdc;

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

    @Field("date_maj")
    private Instant datemaj;

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public String getId() {
        return id;
    }

    public void setId(final String id) {
        this.id = id;
    }

    public Double getX() {
        return x;
    }

    public Borne x(final Double x) {
        this.x = x;
        return this;
    }

    public void setX(final Double x) {
        this.x = x;
    }

    public Double getY() {
        return y;
    }

    public Borne y(final Double y) {
        this.y = y;
        return this;
    }

    public void setY(final Double y) {
        this.y = y;
    }

    public String getAmenageur() {
        return amenageur;
    }

    public Borne amenageur(final String amenageur) {
        this.amenageur = amenageur;
        return this;
    }

    public void setAmenageur(final String amenageur) {
        this.amenageur = amenageur;
    }

    public String getOperateur() {
        return operateur;
    }

    public Borne operateur(final String operateur) {
        this.operateur = operateur;
        return this;
    }

    public void setOperateur(final String operateur) {
        this.operateur = operateur;
    }

    public String getEnseigne() {
        return enseigne;
    }

    public Borne enseigne(final String enseigne) {
        this.enseigne = enseigne;
        return this;
    }

    public void setEnseigne(final String enseigne) {
        this.enseigne = enseigne;
    }

    public String getIdstation() {
        return idstation;
    }

    public Borne idstation(final String idstation) {
        this.idstation = idstation;
        return this;
    }

    public void setIdstation(final String idstation) {
        this.idstation = idstation;
    }

    public String getStation() {
        return station;
    }

    public Borne station(final String station) {
        this.station = station;
        return this;
    }

    public void setStation(final String station) {
        this.station = station;
    }

    public String getAdstation() {
        return adstation;
    }

    public Borne adstation(final String adstation) {
        this.adstation = adstation;
        return this;
    }

    public void setAdstation(final String adstation) {
        this.adstation = adstation;
    }

    public Integer getCodeinsee() {
        return codeinsee;
    }

    public Borne codeinsee(final Integer codeinsee) {
        this.codeinsee = codeinsee;
        return this;
    }

    public void setCodeinsee(final Integer codeinsee) {
        this.codeinsee = codeinsee;
    }

    public Double getXlongitude() {
        return xlongitude;
    }

    public Borne xlongitude(final Double xlongitude) {
        this.xlongitude = xlongitude;
        return this;
    }

    public void setXlongitude(final Double xlongitude) {
        this.xlongitude = xlongitude;
    }

    public Double getYlatitude() {
        return ylatitude;
    }

    public Borne ylatitude(final Double ylatitude) {
        this.ylatitude = ylatitude;
        return this;
    }

    public void setYlatitude(final Double ylatitude) {
        this.ylatitude = ylatitude;
    }

    public String getNbrepdc() {
        return nbrepdc;
    }

    public Borne nbrepdc(final String nbrepdc) {
        this.nbrepdc = nbrepdc;
        return this;
    }

    public void setNbrepdc(final String nbrepdc) {
        this.nbrepdc = nbrepdc;
    }

    public String getIdpdc() {
        return idpdc;
    }

    public Borne idpdc(final String idpdc) {
        this.idpdc = idpdc;
        return this;
    }

    public void setIdpdc(final String idpdc) {
        this.idpdc = idpdc;
    }

    public String getPuissmax() {
        return puissmax;
    }

    public Borne puissmax(final String puissmax) {
        this.puissmax = puissmax;
        return this;
    }

    public void setPuissmax(final String puissmax) {
        this.puissmax = puissmax;
    }

    public String getTypeprise() {
        return typeprise;
    }

    public Borne typeprise(final String typeprise) {
        this.typeprise = typeprise;
        return this;
    }

    public void setTypeprise(final String typeprise) {
        this.typeprise = typeprise;
    }

    public String getAccesrecharge() {
        return accesrecharge;
    }

    public Borne accesrecharge(final String accesrecharge) {
        this.accesrecharge = accesrecharge;
        return this;
    }

    public void setAccesrecharge(final String accesrecharge) {
        this.accesrecharge = accesrecharge;
    }

    public String getAccessibilite() {
        return accessibilite;
    }

    public Borne accessibilite(final String accessibilite) {
        this.accessibilite = accessibilite;
        return this;
    }

    public void setAccessibilite(final String accessibilite) {
        this.accessibilite = accessibilite;
    }

    public String getObservations() {
        return observations;
    }

    public Borne observations(final String observations) {
        this.observations = observations;
        return this;
    }

    public void setObservations(final String observations) {
        this.observations = observations;
    }

    public Instant getDatemaj() {
        return datemaj;
    }

    public Borne datemajnoperateur(final Instant datemaj) {
        this.datemaj = datemaj;
        return this;
    }

    public void setDatemajnoperateur(final Instant datemaj) {
        this.datemaj = datemaj;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and
    // setters here

    @Override
    public boolean equals(final Object o) {
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
            ", enseigne='" + getEnseigne() + "'" +
            ", idstation='" + getIdstation() + "'" +
            ", station='" + getStation() + "'" +
            ", adstation='" + getAdstation() + "'" +
            ", codeinsee=" + getCodeinsee() +
            ", xlongitude=" + getXlongitude() +
            ", ylatitude=" + getYlatitude() +
            ", nbrepdc='" + getNbrepdc() + "'" +
            ", idpdc='" + getIdpdc() + "'" +
            ", puissmax='" + getPuissmax() + "'" +
            ", typeprise='" + getTypeprise() + "'" +
            ", accesrecharge='" + getAccesrecharge() + "'" +
            ", accessibilite='" + getAccessibilite() + "'" +
            ", observations='" + getObservations() + "'" +
            ", datemaj='" + getDatemaj() + "'" +
            "}";
    }
}
