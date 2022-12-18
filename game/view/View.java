package game.view;

import javax.swing.*;
import game.viewmodel.*;

public abstract class View extends JPanel implements Rebuildable {
    protected View(ViewModel viewModel) {
        viewModel.setObserver(this);
    }

    abstract void build();

    @Override
    public void rebuild() {
        removeAll();
        build();
        revalidate();
        repaint();
    }
}
