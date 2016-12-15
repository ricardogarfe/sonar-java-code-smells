package org.sonar.codesmells.checks;

import com.google.common.collect.ImmutableList;
import org.sonar.api.server.rule.RulesDefinition;
import org.sonar.check.Priority;
import org.sonar.check.Rule;
import org.sonar.plugins.java.api.IssuableSubscriptionVisitor;
import org.sonar.plugins.java.api.JavaFileScanner;
import org.sonar.plugins.java.api.JavaFileScannerContext;
import org.sonar.plugins.java.api.tree.BaseTreeVisitor;
import org.sonar.plugins.java.api.tree.SwitchStatementTree;
import org.sonar.plugins.java.api.tree.Tree;
import org.sonar.squidbridge.annotations.ActivatedByDefault;
import org.sonar.squidbridge.annotations.SqaleConstantRemediation;
import org.sonar.squidbridge.annotations.SqaleSubCharacteristic;

import java.util.List;

@Rule(key = "AvoidSwitch", name = "\"switch\" statements are evil", tags = {
        "error", "apocalypse", "bug"}, description = "<p>You have a conditional that chooses different behavior depending on the type of an object.</p>\n" +
        "\n" +
        "<h2>Noncompliant Code Example</h2>\n" +
        "\n" +
        "<pre>\n" +
        "double getSpeed() {\n" +
        "  switch (_type) {\n" +
        "    case EUROPEAN:\n" +
        "      return getBaseSpeed();\n" +
        "    case AFRICAN:\n" +
        "      return getBaseSpeed() - getLoadFactor() * _numberOfCoconuts;\n" +
        "    case NORWEGIAN_BLUE:\n" +
        "      return (_isNailed) ? 0 : getBaseSpeed(_voltage);\n" +
        "  }\n" +
        "  throw new RuntimeException (\"Should be unreachable\");\n" +
        "}\n" +
        "</pre>\n" +
        "\n" +
        "<h2>Compliant Solution</h2>\n" +
        "\n" +
        "<p>Move each leg of the conditional to an overriding method in a subclass. Make the original method abstract.</p>\n" +
        "\n" +
        "<ul>\n" +
        "    <li><a href=\"http://www.refactoring.com/catalog/replaceConditionalWithPolymorphism.html\">Replace Conditional with\n" +
        "        Polymorphism</a> - Fowler Refactoring Catalog\n" +
        "    </li>\n" +
        "</ul>", priority = Priority.BLOCKER)
public class AvoidSwitchCheck extends IssuableSubscriptionVisitor {

  @Override
  public List<Tree.Kind> nodesToVisit() {
    return ImmutableList.of(Tree.Kind.SWITCH_STATEMENT);
  }

  @Override
  public void visitNode(Tree tree) {
    SwitchStatementTree switchStatementTree = (SwitchStatementTree) tree;
    reportIssue(switchStatementTree, "Remove this \"switch\" statement and develop with Polymorphism.");
  }
}
