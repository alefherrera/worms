package worms.render;

import javafx.scene.Group;
import javafx.scene.text.Text;
import worms.model.Match;
import worms.model.MatchObserver;
import worms.model.MatchStatus;

public class MatchRenderer implements MatchObserver {

    private final Match match;
    private final Text text;

    public MatchRenderer(final Group root, final Match match) {
        this.match = match;
        text = new Text(0, 10, getSize(match.getStatus()));
        root.getChildren().add(text);
        match.add(this);
    }

    private String getSize(final MatchStatus matchStatus) {
        final int size = matchStatus.getTurns().size();
        return String.valueOf(size);
    }

    @Override
    public void update(final MatchStatus matchStatus) {
        text.setText(getSize(matchStatus));
    }
}
