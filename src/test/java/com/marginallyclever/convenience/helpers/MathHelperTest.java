package com.marginallyclever.convenience.helpers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.vecmath.Point2d;
import javax.vecmath.Tuple2d;
import javax.vecmath.Vector2d;

public class MathHelperTest {
    @Test
    public void testBetween() {
        Point2d a = new Point2d();
        Point2d b = new Point2d();
        Point2d c;
        double epsilon = 1e-9;

        for (int i = 0; i < 50; ++i) {
            a.set(Math.random() * 500 - 250, Math.random() * 500 - 250);
            b.set(Math.random() * 500 - 250, Math.random() * 500 - 250);
            c = MathHelper.lerp(a, b, Math.random());
            assert (MathHelper.between(a, b, c, epsilon));
        }
    }

    @Test
    public void testNotBetween() {
        Point2d a = new Point2d();
        Point2d b = new Point2d();
        Point2d c;
        double epsilon = 1e-9;

        for(int i=0;i<50;++i) {
            a.set(Math.random()*500-250, Math.random()*500-250);
            b.set(Math.random()*500-250, Math.random()*500-250);
            c = MathHelper.lerp(a,b,1.0+epsilon+Math.random());
            Assertions.assertFalse(MathHelper.between(a, b, c, epsilon));
        }

        for(int i=0;i<50;++i) {
            a.set(Math.random()*500-250, Math.random()*500-250);
            b.set(Math.random()*500-250, Math.random()*500-250);
            c = MathHelper.lerp(a,b,-epsilon-Math.random());
            Assertions.assertFalse(MathHelper.between(a, b, c, epsilon));
        }
    }

    @Test
    public void testOffLine() {
        Point2d a = new Point2d();
        Point2d b = new Point2d();
        Point2d ortho = new Point2d();
        Point2d c;
        double epsilon = 1e-9;

        for(int i=0;i<50;++i) {
            a.set(Math.random()*500-250, Math.random()*500-250);
            b.set(Math.random()*500-250, Math.random()*500-250);
            c = MathHelper.lerp(a,b,Math.random());
            ortho.set(b);
            ortho.sub(a);
            c.x+=ortho.y;
            c.y+=ortho.x;
            Assertions.assertFalse(MathHelper.between(a, b, c, epsilon));
        }

        for(int i=0;i<50;++i) {
            a.set(Math.random()*500-250, Math.random()*500-250);
            b.set(Math.random()*500-250, Math.random()*500-250);
            c = MathHelper.lerp(a,b,1.0+epsilon+Math.random());
            ortho.set(b);
            ortho.sub(a);
            c.x+=ortho.y;
            c.y+=ortho.x;
            Assertions.assertFalse(MathHelper.between(a, b, c, epsilon));
        }

        for(int i=0;i<50;++i) {
            a.set(Math.random()*500-250, Math.random()*500-250);
            b.set(Math.random()*500-250, Math.random()*500-250);
            c = MathHelper.lerp(a,b,-epsilon-Math.random());
            ortho.set(b);
            ortho.sub(a);
            c.x+=ortho.y;
            c.y+=ortho.x;
            Assertions.assertFalse(MathHelper.between(a, b, c, epsilon));
        }
    }

    //
    // NEW TESTS
    //

    // Case 1: 
    // First condition passes (a0 == b0 and a1 == b1)
    // Second condition fails (a0 != b1 and a1 != b0) (but is never reached)
    @Test
    void testEqualsBranche1() {
        // Arrange
        double epsilon = 0.01;
        Tuple2d a0 = new Vector2d(0.0, 0.0);
        Tuple2d a1 = new Vector2d(1.0, 1.0);
        Tuple2d b0 = new Vector2d(0.0, 0.0);
        Tuple2d b1 = new Vector2d(1.0, 1.0);

        // Act
        boolean result = MathHelper.equals(a0, a1, b0, b1, epsilon);

        // Assert
        Assertions.assertTrue(result);
    }

        // Case 2: 
        // First condition fails (a0 == b0 and a1 != b1)
        // Second condition fails (a0 != b1 and a1 != b0)
        @Test
        void testEqualsBranche2() {
        // Arrange
        double epsilon = 0.01;
        Tuple2d a0 = new Vector2d(0.0, 0.0);
        Tuple2d a1 = new Vector2d(1.0, 1.0);
        Tuple2d b0 = new Vector2d(0.0, 0.0);
        Tuple2d b1 = new Vector2d(1.0, 1.02);
    
        // Act
        boolean result = MathHelper.equals(a0, a1, b0, b1, epsilon);

        // Assert
        Assertions.assertFalse(result);
    }

        // Case 3: 
        // First condition fails (a0 != b0 and a1 == b1)
        // Second condition fails (a0 != b1 and a1 != b0)
        @Test
        void testEqualsBranche3() {
        // Arrange
        double epsilon = 0.01;
        Tuple2d a0 = new Vector2d(0.0, 0.0);
        Tuple2d a1 = new Vector2d(1.0, 1.0);
        Tuple2d b0 = new Vector2d(0.02, 0.0);
        Tuple2d b1 = new Vector2d(1.0, 1.0);
    
        // Act
        boolean result = MathHelper.equals(a0, a1, b0, b1, epsilon);

        // Assert
        Assertions.assertFalse(result);
    }

    // Case 4: 
    // First condition fails (a0 != b0 and a1 != b1)
    // Second condition passes (a0 == b1 and a1 == b0)
    @Test
    void testEqualsBranche4() {
        // Arrange
        double epsilon = 0.01;
        Tuple2d a0 = new Vector2d(0.0, 0.0);
        Tuple2d a1 = new Vector2d(1.0, 1.0);
        Tuple2d b0 = new Vector2d(1.0, 1.0);
        Tuple2d b1 = new Vector2d(0.0, 0.0);

        // Act
        boolean result = MathHelper.equals(a0, a1, b0, b1, epsilon);

        // Assert
        Assertions.assertTrue(result);
    }

    // Case 5: 
    //
    // Important test that revealed a bug in the previous implementation,
    // showcasing that branch coverage maximization can be worthwhile.
    //
    // First condition fails (a0 != b0 and a1 != b1)
    // Second condition passes (a0 != b1 and a1 == b0)
    @Test
    void testEqualsBranche5() {
        // Arrange
        double epsilon = 0.01;
        Tuple2d a0 = new Vector2d(0.0, 0.0);
        Tuple2d a1 = new Vector2d(1.0, 1.0);
        Tuple2d b0 = new Vector2d(1.0, 1.0);
        Tuple2d b1 = new Vector2d(0.005, 0.02);

        // Act
        boolean result = MathHelper.equals(a0, a1, b0, b1, epsilon);

        // Assert
        Assertions.assertFalse(result);
    }

    // Case 6: 
    // First condition fails (a0 != b0 and a1 != b1)
    // Second condition passes (a0 == b1 and a1 != b0)
    @Test
    void testEqualsBranche6() {
        // Arrange
        double epsilon = 0.01;
        Tuple2d a0 = new Vector2d(0.0, 0.0);
        Tuple2d a1 = new Vector2d(1.0, 1.0);
        Tuple2d b0 = new Vector2d(1.0, 1.2);
        Tuple2d b1 = new Vector2d(0.00, 0.000);

        // Act
        boolean result = MathHelper.equals(a0, a1, b0, b1, epsilon);

        // Assert
        Assertions.assertFalse(result);
    }
}

