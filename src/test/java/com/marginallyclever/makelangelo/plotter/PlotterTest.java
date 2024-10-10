package com.marginallyclever.makelangelo.plotter;

import com.marginallyclever.convenience.Point2D;
import com.marginallyclever.makelangelo.turtle.MovementType;
import com.marginallyclever.makelangelo.turtle.TurtleMove;
import com.marginallyclever.util.PreferencesHelper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

// NEW TESTS FOR THE 'turtleMove' FUNCTION
// Tests of different movement combinations and verify the expected destination and pen position
class PlotterTest {

    Plotter plotter;

    @BeforeEach
    void setUp() {
        PreferencesHelper.start();
        plotter = new Plotter();
    }

    // Tests the turtle's movement with the "TRAVEL" movement type
    @Test
    void turtleMoveTravel() {
        // ARRANGE
        TurtleMove m0 = new TurtleMove(10.0, 10.0, MovementType.TRAVEL);
        TurtleMove m1 = new TurtleMove(0.0, 0.0, MovementType.TRAVEL);

        // ACT
        plotter.turtleMove(m0);
        plotter.turtleMove(m1);

        // ASSERT
        Point2D expectedPosition = new Point2D(0.0, 0.0);
        Assertions.assertEquals(expectedPosition.x, plotter.getPos().x);
        Assertions.assertEquals(expectedPosition.y, plotter.getPos().y);
        Assertions.assertTrue(plotter.getPenIsUp());
    }

    // Tests the turtle's movement with the "DRAW_LINE" movement type
    @Test
    void turtleMoveDrawLine() {
        // ARRANGE
        TurtleMove m0 = new TurtleMove(10.0, 10.0, MovementType.DRAW_LINE);
        TurtleMove m1 = new TurtleMove(0.0, 0.0, MovementType.DRAW_LINE);

        // ACT
        plotter.turtleMove(m0);
        plotter.turtleMove(m1);

        // ASSERT
        Point2D expectedPosition = new Point2D(0.0, 0.0);
        Assertions.assertEquals(expectedPosition.x, plotter.getPos().x);
        Assertions.assertEquals(expectedPosition.y, plotter.getPos().y);
        Assertions.assertFalse(plotter.getPenIsUp());
    }

    // Tests a sequence of turtle movements involving both "TRAVEL" and "DRAW_LINE"
    @Test
    void turtleMoveComplexCommandSequence(){
        // ARRANGE
        TurtleMove m0 = new TurtleMove(10.0, 10.0, MovementType.TRAVEL);
        TurtleMove m1 = new TurtleMove(-10.0, -10.0, MovementType.DRAW_LINE);
        TurtleMove m2 = new TurtleMove(12.3, 32.1, MovementType.TRAVEL);

        // ACT
        plotter.turtleMove(m0);
        plotter.turtleMove(m1);
        plotter.turtleMove(m2);

        // ASSERT
        Point2D expectedPosition = new Point2D(12.3, 32.1);
        Assertions.assertEquals(expectedPosition.x, plotter.getPos().x);
        Assertions.assertEquals(expectedPosition.y, plotter.getPos().y);
        Assertions.assertTrue(plotter.getPenIsUp());
    }

    // Tests the turtle's movement with the "TOOL_CHANGE" movement type
    @Test
    void turtleMoveToolChange(){
        // ARRANGE
        TurtleMove m0 = new TurtleMove(10.0, 10.0, MovementType.TOOL_CHANGE);

        // ACT
        plotter.turtleMove(m0);

        // ASSERT
        Point2D expectedPosition = new Point2D(0.0, 0.0);
        Assertions.assertEquals(expectedPosition.x, plotter.getPos().x);
        Assertions.assertEquals(expectedPosition.y, plotter.getPos().y);
        Assertions.assertFalse(plotter.getPenIsUp());
    }
}
