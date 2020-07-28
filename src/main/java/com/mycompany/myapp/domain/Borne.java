package com.mycompany.myapp.domain;

import io.swagger.annotations.ApiModel;
import java.io.Serializable;
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

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
            "}";
    }
}
