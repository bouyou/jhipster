package com.mycompany.myapp.web.rest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.mycompany.myapp.JhipsterSampleApplicationApp;
import com.mycompany.myapp.domain.Borne;
import com.mycompany.myapp.repository.BorneRepository;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

/**
 * Integration tests for the {@link BorneResource} REST controller.
 */
@SpringBootTest(classes = JhipsterSampleApplicationApp.class)
@AutoConfigureMockMvc
@WithMockUser
public class BorneResourceIT {
    private static final Double DEFAULT_X = 1D;
    private static final Double UPDATED_X = 2D;

    private static final Double DEFAULT_Y = 1D;
    private static final Double UPDATED_Y = 2D;

    private static final String DEFAULT_AMENAGEUR = "AAAAAAAAAA";
    private static final String UPDATED_AMENAGEUR = "BBBBBBBBBB";

    private static final String DEFAULT_OPERATEUR = "AAAAAAAAAA";
    private static final String UPDATED_OPERATEUR = "BBBBBBBBBB";

    private static final String DEFAULT_ENSEIGNE = "AAAAAAAAAA";
    private static final String UPDATED_ENSEIGNE = "BBBBBBBBBB";

    private static final String DEFAULT_IDSTATION = "AAAAAAAAAA";
    private static final String UPDATED_IDSTATION = "BBBBBBBBBB";

    private static final String DEFAULT_STATION = "AAAAAAAAAA";
    private static final String UPDATED_STATION = "BBBBBBBBBB";

    private static final String DEFAULT_ADSTATION = "AAAAAAAAAA";
    private static final String UPDATED_ADSTATION = "BBBBBBBBBB";

    private static final Integer DEFAULT_CODEINSEE = 1;
    private static final Integer UPDATED_CODEINSEE = 2;

    private static final Double DEFAULT_XLONGITUDE = 1D;
    private static final Double UPDATED_XLONGITUDE = 2D;

    private static final Double DEFAULT_YLATITUDE = 1D;
    private static final Double UPDATED_YLATITUDE = 2D;

    private static final String DEFAULT_NBREPDC = "AAAAAAAAAA";
    private static final String UPDATED_NBREPDC = "BBBBBBBBBB";

    private static final String DEFAULT_IDPDC = "AAAAAAAAAA";
    private static final String UPDATED_IDPDC = "BBBBBBBBBB";

    private static final String DEFAULT_PUISSMAX = "AAAAAAAAAA";
    private static final String UPDATED_PUISSMAX = "BBBBBBBBBB";

    private static final String DEFAULT_TYPEPRISE = "AAAAAAAAAA";
    private static final String UPDATED_TYPEPRISE = "BBBBBBBBBB";

    private static final String DEFAULT_ACCESRECHARGE = "AAAAAAAAAA";
    private static final String UPDATED_ACCESRECHARGE = "BBBBBBBBBB";

    private static final String DEFAULT_ACCESSIBILITE = "AAAAAAAAAA";
    private static final String UPDATED_ACCESSIBILITE = "BBBBBBBBBB";

    private static final String DEFAULT_OBSERVATIONS = "AAAAAAAAAA";
    private static final String UPDATED_OBSERVATIONS = "BBBBBBBBBB";

    private static final Instant DEFAULT_DATEMAJ = Instant.ofEpochMilli(0L);
    private static final Instant UPDATED_DATEMAJ = Instant.now().truncatedTo(ChronoUnit.MILLIS);

    @Autowired
    private BorneRepository borneRepository;

    @Autowired
    private MockMvc restBorneMockMvc;

    private Borne borne;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Borne createEntity() {
        Borne borne = new Borne()
            .x(DEFAULT_X)
            .y(DEFAULT_Y)
            .amenageur(DEFAULT_AMENAGEUR)
            .operateur(DEFAULT_OPERATEUR)
            .enseigne(DEFAULT_ENSEIGNE)
            .idstation(DEFAULT_IDSTATION)
            .station(DEFAULT_STATION)
            .adstation(DEFAULT_ADSTATION)
            .codeinsee(DEFAULT_CODEINSEE)
            .xlongitude(DEFAULT_XLONGITUDE)
            .ylatitude(DEFAULT_YLATITUDE)
            .nbrepdc(DEFAULT_NBREPDC)
            .idpdc(DEFAULT_IDPDC)
            .puissmax(DEFAULT_PUISSMAX)
            .typeprise(DEFAULT_TYPEPRISE)
            .accesrecharge(DEFAULT_ACCESRECHARGE)
            .accessibilite(DEFAULT_ACCESSIBILITE)
            .observations(DEFAULT_OBSERVATIONS)
            .datemajnoperateur(DEFAULT_DATEMAJ);
        return borne;
    }

    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Borne createUpdatedEntity() {
        Borne borne = new Borne()
            .x(UPDATED_X)
            .y(UPDATED_Y)
            .amenageur(UPDATED_AMENAGEUR)
            .operateur(UPDATED_OPERATEUR)
            .enseigne(UPDATED_ENSEIGNE)
            .idstation(UPDATED_IDSTATION)
            .station(UPDATED_STATION)
            .adstation(UPDATED_ADSTATION)
            .codeinsee(UPDATED_CODEINSEE)
            .xlongitude(UPDATED_XLONGITUDE)
            .ylatitude(UPDATED_YLATITUDE)
            .nbrepdc(UPDATED_NBREPDC)
            .idpdc(UPDATED_IDPDC)
            .puissmax(UPDATED_PUISSMAX)
            .typeprise(UPDATED_TYPEPRISE)
            .accesrecharge(UPDATED_ACCESRECHARGE)
            .accessibilite(UPDATED_ACCESSIBILITE)
            .observations(UPDATED_OBSERVATIONS)
            .datemajnoperateur(UPDATED_DATEMAJ);
        return borne;
    }

    @BeforeEach
    public void initTest() {
        borneRepository.deleteAll();
        borne = createEntity();
    }

    @Test
    public void createBorne() throws Exception {
        int databaseSizeBeforeCreate = borneRepository.findAll().size();
        // Create the Borne
        restBorneMockMvc
            .perform(post("/api/bornes").contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(borne)))
            .andExpect(status().isCreated());

        // Validate the Borne in the database
        List<Borne> borneList = borneRepository.findAll();
        assertThat(borneList).hasSize(databaseSizeBeforeCreate + 1);
        Borne testBorne = borneList.get(borneList.size() - 1);
        assertThat(testBorne.getX()).isEqualTo(DEFAULT_X);
        assertThat(testBorne.getY()).isEqualTo(DEFAULT_Y);
        assertThat(testBorne.getAmenageur()).isEqualTo(DEFAULT_AMENAGEUR);
        assertThat(testBorne.getOperateur()).isEqualTo(DEFAULT_OPERATEUR);
        assertThat(testBorne.getEnseigne()).isEqualTo(DEFAULT_ENSEIGNE);
        assertThat(testBorne.getIdstation()).isEqualTo(DEFAULT_IDSTATION);
        assertThat(testBorne.getStation()).isEqualTo(DEFAULT_STATION);
        assertThat(testBorne.getAdstation()).isEqualTo(DEFAULT_ADSTATION);
        assertThat(testBorne.getCodeinsee()).isEqualTo(DEFAULT_CODEINSEE);
        assertThat(testBorne.getXlongitude()).isEqualTo(DEFAULT_XLONGITUDE);
        assertThat(testBorne.getYlatitude()).isEqualTo(DEFAULT_YLATITUDE);
        assertThat(testBorne.getNbrepdc()).isEqualTo(DEFAULT_NBREPDC);
        assertThat(testBorne.getIdpdc()).isEqualTo(DEFAULT_IDPDC);
        assertThat(testBorne.getPuissmax()).isEqualTo(DEFAULT_PUISSMAX);
        assertThat(testBorne.getTypeprise()).isEqualTo(DEFAULT_TYPEPRISE);
        assertThat(testBorne.getAccesrecharge()).isEqualTo(DEFAULT_ACCESRECHARGE);
        assertThat(testBorne.getAccessibilite()).isEqualTo(DEFAULT_ACCESSIBILITE);
        assertThat(testBorne.getObservations()).isEqualTo(DEFAULT_OBSERVATIONS);
        assertThat(testBorne.getDatemaj()).isEqualTo(DEFAULT_DATEMAJ);
    }

    @Test
    public void createBorneWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = borneRepository.findAll().size();

        // Create the Borne with an existing ID
        borne.setId("existing_id");

        // An entity with an existing ID cannot be created, so this API call must fail
        restBorneMockMvc
            .perform(post("/api/bornes").contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(borne)))
            .andExpect(status().isBadRequest());

        // Validate the Borne in the database
        List<Borne> borneList = borneRepository.findAll();
        assertThat(borneList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    public void getAllBornes() throws Exception {
        // Initialize the database
        borneRepository.save(borne);

        // Get all the borneList
        restBorneMockMvc
            .perform(get("/api/bornes?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(borne.getId())))
            .andExpect(jsonPath("$.[*].x").value(hasItem(DEFAULT_X.doubleValue())))
            .andExpect(jsonPath("$.[*].y").value(hasItem(DEFAULT_Y.doubleValue())))
            .andExpect(jsonPath("$.[*].amenageur").value(hasItem(DEFAULT_AMENAGEUR)))
            .andExpect(jsonPath("$.[*].operateur").value(hasItem(DEFAULT_OPERATEUR)))
            .andExpect(jsonPath("$.[*].enseigne").value(hasItem(DEFAULT_ENSEIGNE)))
            .andExpect(jsonPath("$.[*].idstation").value(hasItem(DEFAULT_IDSTATION)))
            .andExpect(jsonPath("$.[*].station").value(hasItem(DEFAULT_STATION)))
            .andExpect(jsonPath("$.[*].adstation").value(hasItem(DEFAULT_ADSTATION)))
            .andExpect(jsonPath("$.[*].codeinsee").value(hasItem(DEFAULT_CODEINSEE)))
            .andExpect(jsonPath("$.[*].xlongitude").value(hasItem(DEFAULT_XLONGITUDE.doubleValue())))
            .andExpect(jsonPath("$.[*].ylatitude").value(hasItem(DEFAULT_YLATITUDE.doubleValue())))
            .andExpect(jsonPath("$.[*].nbrepdc").value(hasItem(DEFAULT_NBREPDC)))
            .andExpect(jsonPath("$.[*].idpdc").value(hasItem(DEFAULT_IDPDC)))
            .andExpect(jsonPath("$.[*].puissmax").value(hasItem(DEFAULT_PUISSMAX)))
            .andExpect(jsonPath("$.[*].typeprise").value(hasItem(DEFAULT_TYPEPRISE)))
            .andExpect(jsonPath("$.[*].accesrecharge").value(hasItem(DEFAULT_ACCESRECHARGE)))
            .andExpect(jsonPath("$.[*].accessibilite").value(hasItem(DEFAULT_ACCESSIBILITE)))
            .andExpect(jsonPath("$.[*].observations").value(hasItem(DEFAULT_OBSERVATIONS)))
            .andExpect(jsonPath("$.[*].datemaj").value(hasItem(DEFAULT_DATEMAJ.toString())));
    }

    @Test
    public void getBorne() throws Exception {
        // Initialize the database
        borneRepository.save(borne);

        // Get the borne
        restBorneMockMvc
            .perform(get("/api/bornes/{id}", borne.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(borne.getId()))
            .andExpect(jsonPath("$.x").value(DEFAULT_X.doubleValue()))
            .andExpect(jsonPath("$.y").value(DEFAULT_Y.doubleValue()))
            .andExpect(jsonPath("$.amenageur").value(DEFAULT_AMENAGEUR))
            .andExpect(jsonPath("$.operateur").value(DEFAULT_OPERATEUR))
            .andExpect(jsonPath("$.enseigne").value(DEFAULT_ENSEIGNE))
            .andExpect(jsonPath("$.idstation").value(DEFAULT_IDSTATION))
            .andExpect(jsonPath("$.station").value(DEFAULT_STATION))
            .andExpect(jsonPath("$.adstation").value(DEFAULT_ADSTATION))
            .andExpect(jsonPath("$.codeinsee").value(DEFAULT_CODEINSEE))
            .andExpect(jsonPath("$.xlongitude").value(DEFAULT_XLONGITUDE.doubleValue()))
            .andExpect(jsonPath("$.ylatitude").value(DEFAULT_YLATITUDE.doubleValue()))
            .andExpect(jsonPath("$.nbrepdc").value(DEFAULT_NBREPDC))
            .andExpect(jsonPath("$.idpdc").value(DEFAULT_IDPDC))
            .andExpect(jsonPath("$.puissmax").value(DEFAULT_PUISSMAX))
            .andExpect(jsonPath("$.typeprise").value(DEFAULT_TYPEPRISE))
            .andExpect(jsonPath("$.accesrecharge").value(DEFAULT_ACCESRECHARGE))
            .andExpect(jsonPath("$.accessibilite").value(DEFAULT_ACCESSIBILITE))
            .andExpect(jsonPath("$.observations").value(DEFAULT_OBSERVATIONS))
            .andExpect(jsonPath("$.datemajnoperateur").value(DEFAULT_DATEMAJ.toString()));
    }

    @Test
    public void getNonExistingBorne() throws Exception {
        // Get the borne
        restBorneMockMvc.perform(get("/api/bornes/{id}", Long.MAX_VALUE)).andExpect(status().isNotFound());
    }

    @Test
    public void updateBorne() throws Exception {
        // Initialize the database
        borneRepository.save(borne);

        int databaseSizeBeforeUpdate = borneRepository.findAll().size();

        // Update the borne
        Borne updatedBorne = borneRepository.findById(borne.getId()).get();
        updatedBorne
            .x(UPDATED_X)
            .y(UPDATED_Y)
            .amenageur(UPDATED_AMENAGEUR)
            .operateur(UPDATED_OPERATEUR)
            .enseigne(UPDATED_ENSEIGNE)
            .idstation(UPDATED_IDSTATION)
            .station(UPDATED_STATION)
            .adstation(UPDATED_ADSTATION)
            .codeinsee(UPDATED_CODEINSEE)
            .xlongitude(UPDATED_XLONGITUDE)
            .ylatitude(UPDATED_YLATITUDE)
            .nbrepdc(UPDATED_NBREPDC)
            .idpdc(UPDATED_IDPDC)
            .puissmax(UPDATED_PUISSMAX)
            .typeprise(UPDATED_TYPEPRISE)
            .accesrecharge(UPDATED_ACCESRECHARGE)
            .accessibilite(UPDATED_ACCESSIBILITE)
            .observations(UPDATED_OBSERVATIONS)
            .datemajnoperateur(UPDATED_DATEMAJ);

        restBorneMockMvc
            .perform(put("/api/bornes").contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(updatedBorne)))
            .andExpect(status().isOk());

        // Validate the Borne in the database
        List<Borne> borneList = borneRepository.findAll();
        assertThat(borneList).hasSize(databaseSizeBeforeUpdate);
        Borne testBorne = borneList.get(borneList.size() - 1);
        assertThat(testBorne.getX()).isEqualTo(UPDATED_X);
        assertThat(testBorne.getY()).isEqualTo(UPDATED_Y);
        assertThat(testBorne.getAmenageur()).isEqualTo(UPDATED_AMENAGEUR);
        assertThat(testBorne.getOperateur()).isEqualTo(UPDATED_OPERATEUR);
        assertThat(testBorne.getEnseigne()).isEqualTo(UPDATED_ENSEIGNE);
        assertThat(testBorne.getIdstation()).isEqualTo(UPDATED_IDSTATION);
        assertThat(testBorne.getStation()).isEqualTo(UPDATED_STATION);
        assertThat(testBorne.getAdstation()).isEqualTo(UPDATED_ADSTATION);
        assertThat(testBorne.getCodeinsee()).isEqualTo(UPDATED_CODEINSEE);
        assertThat(testBorne.getXlongitude()).isEqualTo(UPDATED_XLONGITUDE);
        assertThat(testBorne.getYlatitude()).isEqualTo(UPDATED_YLATITUDE);
        assertThat(testBorne.getNbrepdc()).isEqualTo(UPDATED_NBREPDC);
        assertThat(testBorne.getIdpdc()).isEqualTo(UPDATED_IDPDC);
        assertThat(testBorne.getPuissmax()).isEqualTo(UPDATED_PUISSMAX);
        assertThat(testBorne.getTypeprise()).isEqualTo(UPDATED_TYPEPRISE);
        assertThat(testBorne.getAccesrecharge()).isEqualTo(UPDATED_ACCESRECHARGE);
        assertThat(testBorne.getAccessibilite()).isEqualTo(UPDATED_ACCESSIBILITE);
        assertThat(testBorne.getObservations()).isEqualTo(UPDATED_OBSERVATIONS);
        assertThat(testBorne.getDatemaj()).isEqualTo(UPDATED_DATEMAJ);
    }

    @Test
    public void updateNonExistingBorne() throws Exception {
        int databaseSizeBeforeUpdate = borneRepository.findAll().size();

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restBorneMockMvc
            .perform(put("/api/bornes").contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(borne)))
            .andExpect(status().isBadRequest());

        // Validate the Borne in the database
        List<Borne> borneList = borneRepository.findAll();
        assertThat(borneList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    public void deleteBorne() throws Exception {
        // Initialize the database
        borneRepository.save(borne);

        int databaseSizeBeforeDelete = borneRepository.findAll().size();

        // Delete the borne
        restBorneMockMvc
            .perform(delete("/api/bornes/{id}", borne.getId()).accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<Borne> borneList = borneRepository.findAll();
        assertThat(borneList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
