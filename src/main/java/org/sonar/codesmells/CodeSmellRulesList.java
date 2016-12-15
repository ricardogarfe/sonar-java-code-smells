package org.sonar.codesmells;

import com.google.common.collect.ImmutableList;
import org.sonar.codesmells.checks.AvoidSwitchCheck;
import org.sonar.plugins.java.api.JavaCheck;

import java.util.List;

/**
 * Created by ricardo on 15/12/16.
 */
public class CodeSmellRulesList {

  private CodeSmellRulesList() {

  }

  public static List<Class> getChecks() {
    return ImmutableList.<Class>builder().addAll(getJavaChecks()).addAll(getJavaTestChecks()).build();
  }

  /**
   * Add rules targeting java files
   * @return
   */
  public static List<Class<? extends JavaCheck>> getJavaChecks() {
    return ImmutableList.<Class<? extends JavaCheck>>builder()
        .add(AvoidSwitchCheck.class)
        .build();
  }

  /**
   * Add rules targeting test files
   * @return
   */
  public static List<Class<? extends JavaCheck>> getJavaTestChecks() {
    return ImmutableList.<Class<? extends JavaCheck>>builder()
        .add(AvoidSwitchCheck.class)
        .build();
  }
}

