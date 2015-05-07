package radek.tesar.myapplication.solver;


import radek.tesar.myapplication.data.Pyramid;


/**
 *  Represents the API of a problem solver.
 *  Refer to {@link radek.tesar.myapplication.data.Pyramid} for problem description.
 */
public interface PyramidSolver {
    long pyramidMaximumTotal(Pyramid pyramid);
}
