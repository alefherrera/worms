package service;

import model.elements.Element;

public class CollisionVerifier {

    public boolean hasCollision(Element a, Element b) {
        return isCollisionInX(a, b) && isCollisionInX(b, a) && isCollisionInY(a, b) && isCollisionInY(b, a);
    }

    private boolean isCollisionInX(Element a, Element b) {
        return a.getPosition().getX() < (b.getPosition().getX() + b.getSize().getWidth());
    }

    private boolean isCollisionInY(Element a, Element b) {
        return a.getPosition().getY() < b.getPosition().getY() + b.getSize().getHeight();
    }

}
