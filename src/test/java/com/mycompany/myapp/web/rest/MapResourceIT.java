package com.mycompany.myapp.web.rest;

import com.mycompany.myapp.JhipsterSampleApplicationApp;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
/**
 * Test class for the MapResource REST controller.
 *
 * @see MapResource
 */
@SpringBootTest(classes = JhipsterSampleApplicationApp.class)
public class MapResourceIT {

    private MockMvc restMockMvc;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        MapResource mapResource = new MapResource();
        restMockMvc = MockMvcBuilders
            .standaloneSetup(mapResource)
            .build();
    }

    /**
     * Test show
     */
    @Test
    public void testShow() throws Exception {
        restMockMvc.perform(get("/api/map/show"))
            .andExpect(status().isOk());
    }
}
