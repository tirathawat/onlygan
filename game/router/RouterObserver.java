package game.router;

import game.view.View;

public interface RouterObserver {
    void navigateTo(View view);
}
