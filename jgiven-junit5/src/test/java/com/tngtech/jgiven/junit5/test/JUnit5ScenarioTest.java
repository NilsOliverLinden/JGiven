package com.tngtech.jgiven.junit5.test;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import com.tngtech.jgiven.junit5.ScenarioTest;

public class JUnit5ScenarioTest extends ScenarioTest<GivenStage, WhenStage, ThenStage> {

    @Test
    public void JGiven_works_with_JUnit5_DISABLED() {
        given().some_state();
        when().some_action();
        then().some_outcome();
    }

}
