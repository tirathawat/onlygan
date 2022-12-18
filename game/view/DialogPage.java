package game.view;

import java.awt.*;
import java.util.List;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import game.viewmodel.GameViewModel;
import game.command.Choice;

public class DialogPage extends View {
    private final transient GameViewModel viewModel;

    public DialogPage(GameViewModel viewModel) {
        super(viewModel);
        this.viewModel = viewModel;
    }

    @Override
    void build() {
        JLabel dialogMessage = createDialogMessage();
        List<JButton> choiceButtons = createChoiceButtons();
        JPanel choicesPanel = createChoicesPanel(choiceButtons);
        JPanel gamePanel = createGamePanel(dialogMessage, choicesPanel);
        setLayout(new BorderLayout());
        add(gamePanel, BorderLayout.SOUTH);
    }

    private JLabel createDialogMessage() {
        JLabel text = new JLabel("");
        text.setText(viewModel.getDialogMessage());
        text.setFont(text.getFont().deriveFont(20.0f));
        text.setPreferredSize(new Dimension(50, 150));
        text.setBorder(new EmptyBorder(20, 20, 20, 20));
        return text;
    }

    private List<JButton> createChoiceButtons() {
        List<JButton> choiceButtons = new ArrayList<>();
        for (Choice choice : viewModel.getChoices()) {
            JButton choiceButton = new JButton(choice.getText());
            choiceButton.setFont(choiceButton.getFont().deriveFont(16.0f));
            choiceButton.setMargin(new Insets(10, 0, 10, 0));
            choiceButton.addActionListener(e -> choice.onSelectedChoice());
            choiceButtons.add(choiceButton);
        }
        return choiceButtons;
    }

    private JPanel createGamePanel(JLabel dialogMessage, Component choicesPanel) {
        JPanel southPanel = new JPanel();
        southPanel.setLayout(new BorderLayout());
        southPanel.add(dialogMessage, BorderLayout.CENTER);
        southPanel.add(choicesPanel, BorderLayout.SOUTH);
        return southPanel;
    }

    private JPanel createChoicesPanel(List<JButton> choicesButton) {
        JPanel choicesPanel = new JPanel();
        choicesPanel.setLayout(new GridLayout(1, choicesButton.size()));
        for (JButton choiceButton : choicesButton) {
            choicesPanel.add(choiceButton);
        }
        return choicesPanel;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Image backgroundImage = Toolkit.getDefaultToolkit().getImage(viewModel.getBackground());
        Image foregroundImage = Toolkit.getDefaultToolkit().getImage(viewModel.getForeground());
        g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        g.drawImage(foregroundImage, 0, 0, getWidth(), getHeight(), this);
    }
}
