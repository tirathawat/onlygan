package game.router;

import game.view.View;

public class Router {
    private static Router instance = null;
    private RouterObserver observer;

    private Router() {
    }

    public static Router getInstance() {
        if (instance == null)
            instance = new Router();

        return instance;
    }

    public void setObserver(RouterObserver observer) {
        this.observer = observer;
    }

    public void navigateTo(View view) {
        observer.navigateTo(view);
    }
}
