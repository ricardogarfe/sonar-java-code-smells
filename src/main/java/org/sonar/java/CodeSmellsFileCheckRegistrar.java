package org.sonar.java;

import com.google.common.collect.Lists;
import org.sonar.java.checks.AvoidSwitchCheck;
import org.sonar.plugins.java.api.CheckRegistrar;
import org.sonar.plugins.java.api.JavaCheck;

import java.util.List;

/**
 * Provide the "checks" (implementations of rules) classes that are gonna be
 * executed during source code analysis.
 * <p>
 * This class is a batch extension by implementing the
 * {@link org.sonar.plugins.java.api.CheckRegistrar} interface.
 */
public class CodeSmellsFileCheckRegistrar implements CheckRegistrar {

    private static final List<Class<? extends JavaCheck>> checkClasses;

    private static final List<Class<? extends JavaCheck>> testCheckClasses;

    /*
     * Block that builds the list of JavaCheck once and for all.
     */
    static {
        checkClasses = Lists.<Class<? extends JavaCheck>>newArrayList();
        checkClasses.add(AvoidSwitchCheck.class);
        testCheckClasses = Lists.<Class<? extends JavaCheck>>newArrayList();
        testCheckClasses.add(AvoidSwitchCheck.class);
    }

    /**
     * Returns all {@link JavaCheck} that need to be applied to source code.
     *
     * @return checks to be applied to source code
     */
    public static Iterable<Class<? extends JavaCheck>> checkClasses() {
        return checkClasses;
    }

    /**
     * Returns all {@link JavaCheck} that need to be applied to test code.
     *
     * @return checks to be applied to test code
     */
    public static Iterable<Class<? extends JavaCheck>> testCheckClasses() {
        return testCheckClasses;
    }

    @Override
    public void register(final RegistrarContext registrarContext) {
        registrarContext.registerClassesForRepository(CodeSmellsJavaRulesDefinition.REPOSITORY_KEY, checkClasses(),
                testCheckClasses());
    }

}
