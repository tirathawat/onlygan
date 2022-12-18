package game.view;

import javax.swing.*;

import game.assets.Assets;
import game.viewmodel.GameViewModel;

import java.awt.*;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class HomePage extends View {
    private transient GameViewModel viewModel;

    public HomePage(GameViewModel viewModel) {
        super(viewModel);
        this.viewModel = viewModel;
    }

    @Override
    void build() {
        JLabel gameLogo = createGameLogo();
        JLabel gameTitle = createTitle();
        JLabel gameSubtitle = createSubtitle();
        JButton startButton = createStartButton();
        GridBagConstraints constraints = setLayout();
        List<Component> components = List.of(gameLogo, gameTitle, gameSubtitle, startButton);
        addComponents(constraints, components);
    }

    private GridBagConstraints setLayout() {
        setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(10, 10, 10, 10);
        return constraints;
    }

    private void addComponents(GridBagConstraints constraints, List<Component> components) {
        for (int i = 0; i < components.size(); i++) {
            constraints.gridx = 0;
            constraints.gridy = i;
            add(components.get(i), constraints);
        }
    }

    private JLabel createGameLogo() {
        ImageIcon imageIcon = new ImageIcon(Assets.GAME_ICON);
        Image image = imageIcon.getImage();
        Image resizedImage = image.getScaledInstance(300, 100, Image.SCALE_SMOOTH);
        imageIcon.setImage(resizedImage);
        return new JLabel(imageIcon);
    }

    private JLabel createTitle() {
        InputStream fontStream = getClass().getResourceAsStream("/assets/fonts/MNKunghaeng.ttf");
        Font font = null;
        try {
            font = Font.createFont(Font.TRUETYPE_FONT, fontStream);
        } catch (FontFormatException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        JLabel gameTitle = new JLabel("ยินดีตอนรับสู่เกม OnlyGan!");
        gameTitle.setFont(font.deriveFont(20f));
        gameTitle.setHorizontalAlignment(SwingConstants.CENTER);
        return gameTitle;
    }

    private JLabel createSubtitle() {
        JLabel gameSubtitle = new JLabel("รักใส ๆ กับนายแกน มาเริ่มจีบแกนกันเลย");
        gameSubtitle.setHorizontalAlignment(SwingConstants.CENTER);
        return gameSubtitle;
    }

    private JButton createStartButton() {
        JButton startButton = new JButton("เริ่มเกม");
        startButton.setMargin(new Insets(0, 50, 0, 50));
        startButton.addActionListener(e -> viewModel.startGame());
        return startButton;
    }
}