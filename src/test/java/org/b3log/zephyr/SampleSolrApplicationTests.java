package org.b3log.zephyr;

/**
 * Created by yaya on 17-3-1.
 */
import org.b3log.zephyr.solr.SampleSolrApplication;
import org.junit.Rule;
import org.junit.Test;

import org.springframework.boot.test.rule.OutputCapture;
import org.springframework.core.NestedCheckedException;

import static org.assertj.core.api.Assertions.assertThat;

public class SampleSolrApplicationTests {

    @Rule
    public OutputCapture outputCapture = new OutputCapture();

    @Test
    public void testDefaultSettings() throws Exception {

        try {
            SampleSolrApplication.main(new String[0]);
        }
        catch (IllegalStateException ex) {
            if (serverNotRunning(ex)) {
                return;
            }
        }
        String output = this.outputCapture.toString();
        assertThat(output).contains("name=Sony Playstation");
    }

    private boolean serverNotRunning(IllegalStateException ex) {

        @SuppressWarnings("serial")
        NestedCheckedException nested = new NestedCheckedException("failed", ex) {
        };
        Throwable root = nested.getRootCause();
        if (root.getMessage().contains("Connection refused")) {
            return true;
        }
        return false;
    }

}