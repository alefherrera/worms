package service;

import model.units.Position;
import model.elements.Character;
import model.elements.Element;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CollisionVerifierTest {

    @Test
    public void hasCollision() {
        Element a = new Character(new Position(0D, 0D));
        Element b = new Character(new Position(10D, 0D));
        CollisionVerifier collisionVerifier = new CollisionVerifier();
        assertTrue(collisionVerifier.hasCollision(a, b));
    }

    @Test
    public void hasCollision2() {
        Element a = new Character(new Position(0D, 0D));
        Element b = new Character(new Position(20D, 0D));
        CollisionVerifier collisionVerifier = new CollisionVerifier();
        assertFalse(collisionVerifier.hasCollision(a, b));
    }

    @Test
    public void noCollision() {
        Element a = new Character(new Position(0D, 0D));
        Element b = new Character(new Position(30D, 0D));
        CollisionVerifier collisionVerifier = new CollisionVerifier();
        assertFalse(collisionVerifier.hasCollision(a, b));
    }
}