package org.sonar.codesmells.checks;

import org.junit.Test;
import org.sonar.java.checks.verifier.CheckVerifier;

public class AvoidSwitchCheckTest {

    @Test
    public void detected() {

        // Use an instance of the check under test to raise the issue.
        AvoidSwitchCheck check = new AvoidSwitchCheck();

        // Verifies that the check will raise the adequate issues with the expected
        // message.
        // In the test file, lines which should raise an issue have been commented
        // out
        // by using the following syntax: "// Noncompliant {{EXPECTED_MESSAGE}}"
        CheckVerifier.newVerifier()
            .onFile("src/test/files/AvoidSwitchCheck.java")
            .withCheck(check)
            .verifyIssues();

    }
}
