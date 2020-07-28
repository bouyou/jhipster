package com.mycompany.myapp.web.rest;

import com.mycompany.myapp.domain.Borne;
import com.mycompany.myapp.repository.BorneRepository;
import com.mycompany.myapp.web.rest.errors.BadRequestAlertException;
import io.github.jhipster.web.util.HeaderUtil;
import io.github.jhipster.web.util.ResponseUtil;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

/**
 * REST controller for managing {@link com.mycompany.myapp.domain.Borne}.
 */
@RestController
@RequestMapping("/api")
public class BorneResource {
    private final Logger log = LoggerFactory.getLogger(BorneResource.class);

    private static final String ENTITY_NAME = "borne";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final BorneRepository borneRepository;

    public BorneResource(BorneRepository borneRepository) {
        this.borneRepository = borneRepository;
    }

    /**
     * {@code POST  /bornes} : Create a new borne.
     *
     * @param borne the borne to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new borne, or with status {@code 400 (Bad Request)} if the borne has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/bornes")
    public ResponseEntity<Borne> createBorne(@RequestBody Borne borne) throws URISyntaxException {
        log.debug("REST request to save Borne : {}", borne);
        if (borne.getId() != null) {
            throw new BadRequestAlertException("A new borne cannot already have an ID", ENTITY_NAME, "idexists");
        }
        Borne result = borneRepository.save(borne);
        return ResponseEntity
            .created(new URI("/api/bornes/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId()))
            .body(result);
    }

    /**
     * {@code PUT  /bornes} : Updates an existing borne.
     *
     * @param borne the borne to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated borne,
     * or with status {@code 400 (Bad Request)} if the borne is not valid,
     * or with status {@code 500 (Internal Server Error)} if the borne couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/bornes")
    public ResponseEntity<Borne> updateBorne(@RequestBody Borne borne) throws URISyntaxException {
        log.debug("REST request to update Borne : {}", borne);
        if (borne.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        Borne result = borneRepository.save(borne);
        return ResponseEntity
            .ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, borne.getId()))
            .body(result);
    }

    /**
     * {@code GET  /bornes} : get all the bornes.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of bornes in body.
     */
    @GetMapping("/bornes")
    public List<Borne> getAllBornes() {
        log.debug("REST request to get all Bornes");
        return borneRepository.findAll();
    }

    /**
     * {@code GET  /bornes/:id} : get the "id" borne.
     *
     * @param id the id of the borne to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the borne, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/bornes/{id}")
    public ResponseEntity<Borne> getBorne(@PathVariable String id) {
        log.debug("REST request to get Borne : {}", id);
        Optional<Borne> borne = borneRepository.findById(id);
        return ResponseUtil.wrapOrNotFound(borne);
    }

    /**
     * {@code DELETE  /bornes/:id} : delete the "id" borne.
     *
     * @param id the id of the borne to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/bornes/{id}")
    public ResponseEntity<Void> deleteBorne(@PathVariable String id) {
        log.debug("REST request to delete Borne : {}", id);
        borneRepository.deleteById(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id)).build();
    }
}
