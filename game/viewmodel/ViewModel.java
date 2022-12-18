package game.viewmodel;

import game.view.*;

public abstract class ViewModel {
    private Rebuildable observer;

    public void setObserver(Rebuildable observer) {
        this.observer = observer;
    }

    protected void rebuild() {
        observer.rebuild();
    }
}
