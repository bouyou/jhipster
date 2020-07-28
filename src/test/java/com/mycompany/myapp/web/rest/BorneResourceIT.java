package com.mycompany.myapp.web.rest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.mycompany.myapp.JhipsterSampleApplicationApp;
import com.mycompany.myapp.domain.Borne;
import com.mycompany.myapp.repository.BorneRepository;
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
        Borne borne = new Borne();
        return borne;
    }

    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Borne createUpdatedEntity() {
        Borne borne = new Borne();
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
            .andExpect(jsonPath("$.[*].id").value(hasItem(borne.getId())));
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
            .andExpect(jsonPath("$.id").value(borne.getId()));
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

        restBorneMockMvc
            .perform(put("/api/bornes").contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(updatedBorne)))
            .andExpect(status().isOk());

        // Validate the Borne in the database
        List<Borne> borneList = borneRepository.findAll();
        assertThat(borneList).hasSize(databaseSizeBeforeUpdate);
        Borne testBorne = borneList.get(borneList.size() - 1);
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
