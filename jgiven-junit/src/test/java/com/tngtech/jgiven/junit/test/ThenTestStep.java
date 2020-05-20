package com.tngtech.jgiven.junit.test;

import static org.assertj.core.api.Assertions.assertThat;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.Format;
import com.tngtech.jgiven.format.NotFormatter;

public class ThenTestStep extends Stage<ThenTestStep> {
    @ExpectedScenarioState
    int intResult;

    public void the_value_is_$not_greater_than_zero( @Format( NotFormatter.class ) boolean b ) {
        assertThat( intResult > 0 ).isEqualTo( b );
    }

    public void the_result_is( int i ) {
        assertThat( intResult ).isEqualTo( i );
    }

    public void something() {}
}
