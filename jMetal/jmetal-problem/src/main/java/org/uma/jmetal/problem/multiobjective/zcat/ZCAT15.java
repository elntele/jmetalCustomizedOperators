package org.uma.jmetal.problem.multiobjective.zcat;

import java.util.Collections;
import org.uma.jmetal.problem.doubleproblem.DoubleProblem;
import org.uma.jmetal.problem.multiobjective.zcat.ffunction.F15;
import org.uma.jmetal.problem.multiobjective.zcat.gfunction.G0;
import org.uma.jmetal.problem.multiobjective.zcat.gfunction.G8;
import org.uma.jmetal.solution.doublesolution.DoubleSolution;

/**
 * Problem ZCAT15, defined in: "Challenging test problems for multi-and many-objective optimization",
 * DOI: https://doi.org/10.1016/j.swevo.2023.101350
 */
public class ZCAT15 extends ZCAT1 {

  public ZCAT15(int numberOfObjectives, int numberOfVariables) {
    this(numberOfObjectives, numberOfVariables, false, 1, false, false);
  }

  public ZCAT15() {
    this(3, 30, true, 1, false, false);
  }

  public ZCAT15(int numberOfObjectives,
      int numberOfVariables,
      boolean complicatedParetoSet,
      int level,
      boolean bias, boolean imbalance) {
    super(numberOfObjectives, numberOfVariables, complicatedParetoSet, level, bias, imbalance);
    name("ZCAT15");

    paretoSetDimension = 1;

    fFunction = new F15(numberOfObjectives);
    gFunction = complicatedParetoSet ? new G8(numberOfVariables, paretoSetDimension)
        : new G0(numberOfVariables, paretoSetDimension);
  }

  public static void main(String[] args) {
    DoubleProblem problem = new ZCAT15();

    DoubleSolution solution = problem.createSolution();
    Collections.fill(solution.variables(), 0.45);

    problem.evaluate(solution) ;
    System.out.println(solution) ;
  }
}
