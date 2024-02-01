package com.mycompany.myapp.settings.domain;

import static com.mycompany.myapp.settings.domain.FillRuleItemTestSamples.*;
import static com.mycompany.myapp.settings.domain.SysFillRuleTestSamples.*;
import static org.assertj.core.api.Assertions.assertThat;

import com.mycompany.myapp.web.rest.TestUtil;
import java.util.ArrayList;
import java.util.Set;
import org.junit.jupiter.api.Test;

class SysFillRuleTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(SysFillRule.class);
        SysFillRule sysFillRule1 = getSysFillRuleSample1();
        SysFillRule sysFillRule2 = new SysFillRule();
        assertThat(sysFillRule1).isNotEqualTo(sysFillRule2);

        sysFillRule2.setId(sysFillRule1.getId());
        assertThat(sysFillRule1).isEqualTo(sysFillRule2);

        sysFillRule2 = getSysFillRuleSample2();
        assertThat(sysFillRule1).isNotEqualTo(sysFillRule2);
    }

    @Test
    void ruleItemsTest() throws Exception {
        SysFillRule sysFillRule = getSysFillRuleRandomSampleGenerator();
        FillRuleItem fillRuleItemBack = getFillRuleItemRandomSampleGenerator();

        // sysFillRule.addRuleItems(fillRuleItemBack);
        assertThat(sysFillRule.getRuleItems()).containsOnly(fillRuleItemBack);
        assertThat(fillRuleItemBack.getFillRule()).isEqualTo(sysFillRule);

        // sysFillRule.removeRuleItems(fillRuleItemBack);
        assertThat(sysFillRule.getRuleItems()).doesNotContain(fillRuleItemBack);
        assertThat(fillRuleItemBack.getFillRule()).isNull();

        sysFillRule.ruleItems(new ArrayList<>(Set.of(fillRuleItemBack)));
        assertThat(sysFillRule.getRuleItems()).containsOnly(fillRuleItemBack);
        assertThat(fillRuleItemBack.getFillRule()).isEqualTo(sysFillRule);

        sysFillRule.setRuleItems(new ArrayList<>());
        assertThat(sysFillRule.getRuleItems()).doesNotContain(fillRuleItemBack);
        assertThat(fillRuleItemBack.getFillRule()).isNull();
    }
}