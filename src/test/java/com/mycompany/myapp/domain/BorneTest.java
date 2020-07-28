package com.mycompany.myapp.domain;

import static org.assertj.core.api.Assertions.assertThat;

import com.mycompany.myapp.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

public class BorneTest {

    @Test
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(Borne.class);
        Borne borne1 = new Borne();
        borne1.setId("id1");
        Borne borne2 = new Borne();
        borne2.setId(borne1.getId());
        assertThat(borne1).isEqualTo(borne2);
        borne2.setId("id2");
        assertThat(borne1).isNotEqualTo(borne2);
        borne1.setId(null);
        assertThat(borne1).isNotEqualTo(borne2);
    }
}
