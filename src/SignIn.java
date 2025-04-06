import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class SignIn {
    private static JFrame parent;
    private static BufferedImage bg, logo, user_icon, lock_icon, show_icon, hidden_icon;
    private static Font merriweather, boldonse;
    static final Color transparent = new Color(0, 0, 0, 0);
    private static CustomComponents.ImagePanel background;
    private static CustomComponents.ImageCell logo_cell, txt_icon1, txt_icon2;
    private static JLabel logo_text1, logo_text2, right_title;
    private static JPanel right_grid;
    private static CustomComponents.RoundedPanel right_panel, txt_grid, pick_grid;
    private static CustomComponents.EmptyTextField txt1;
    private static CustomComponents.EmptyPasswordField txt2;
    private static CustomComponents.CustomButton hidden, button;
    private static JCheckBox check;

    public static void SignInLoader(JFrame parent, Font merriweather, Font boldonse) {
        try {
            bg = ImageIO.read(new File("images/login_bg.jpg"));
            logo = ImageIO.read(new File("images/logo_original.png"));
            user_icon = ImageIO.read(new File("images/user.png"));
            lock_icon = ImageIO.read(new File("images/lock.png"));
            show_icon = ImageIO.read(new File("images/show.png"));
            hidden_icon = ImageIO.read(new File("images/hidden.png"));
        } catch (IOException e) {
            e.getStackTrace();
        }
        SignIn.merriweather = merriweather;
        SignIn.boldonse = boldonse;
        SignIn.parent = parent;
    }

    public static void ShowPage() {
        background = new CustomComponents.ImagePanel(bg);

        JPanel outer_grid = background.getGridPanel();
        GridBagConstraints gbc = new GridBagConstraints();
        outer_grid.setBorder(BorderFactory.createEmptyBorder(30, 100, 30, 20));

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.fill = GridBagConstraints.BOTH;
        JLabel place_holder = new JLabel("", SwingConstants.CENTER);
        outer_grid.add(place_holder, gbc);

        gbc.gridy = 1;
        logo_cell = new CustomComponents.ImageCell(logo, 0.85 , 7);
        outer_grid.add(logo_cell, gbc);

        gbc.gridy = 2;
        gbc.weighty = 0.001;
        logo_text1 = new JLabel("<html><div style='color:#383546; padding-top: 14px;'>"
                + "<b>Omega Wholesale Sdn Bhd (OWSB)</b></div></html>");
        logo_text1.setFont(merriweather);
        outer_grid.add(logo_text1, gbc);

        gbc.gridy = 3;
        gbc.weighty = 0.7;
        logo_text2 = new JLabel("<html><div style='color:#383546;'>"
                + "Automated Purchase Order<br>Management System</div></html>");
        logo_text2.setFont(boldonse);
        outer_grid.add(logo_text2, gbc);

        gbc.gridy = 4;
        gbc.weighty = 1;
        place_holder = new JLabel("", SwingConstants.CENTER);
        outer_grid.add(place_holder, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridheight = 5;
        gbc.weightx = 5;
        gbc.fill = GridBagConstraints.BOTH;
        right_panel = new CustomComponents.RoundedPanel(
                30, 1, 0, Color.WHITE, Color.BLACK);
        right_panel.setBackground(Color.WHITE);
        right_panel.setLayout(new GridBagLayout());

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1;
        gbc.weighty = 1;
        right_grid = new JPanel(new GridBagLayout());
        right_grid.setOpaque(false);
        right_grid.setBorder(BorderFactory.createEmptyBorder(60, 100, 60, 100));
        right_panel.add(right_grid, gbc);

        gbc.gridy = 0;
        gbc.weightx = 10;
        gbc.weighty = 0.3;
        gbc.fill = GridBagConstraints.BOTH;
        right_title = new JLabel("<html><div style='color:#383546;'>"
                + "<b>Sign In</b></div></html>");
        right_grid.add(right_title, gbc);

        gbc.gridy = 1;
        gbc.weighty = 0.125;
        txt_grid = new CustomComponents.RoundedPanel(
                60, 0, 3,
                Color.WHITE, new Color(179, 181, 180));
        txt_grid.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10));
        txt_grid.setLayout(new GridBagLayout());
        right_grid.add(txt_grid, gbc);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 4;
        txt_icon1 = new CustomComponents.ImageCell(
                user_icon, 0.5, 5);
        txt_grid.add(txt_icon1, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 6;
        txt1 = new CustomComponents.EmptyTextField(
                10, "Username or email \r\r", new Color(178, 181, 180));
        txt_grid.add(txt1, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.weighty = 0.125;
        gbc.insets = new Insets(10, 0, 0, 0);
        txt_grid = new CustomComponents.RoundedPanel(60, 0, 3,
                Color.WHITE, new Color(179, 181, 180));
        txt_grid.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 0));
        txt_grid.setLayout(new GridBagLayout());
        right_grid.add(txt_grid, gbc);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 5.8;
        gbc.insets = new Insets(0, 0, 0, 0);
        txt_icon2 = new CustomComponents.ImageCell(
                lock_icon, 0.5, 5);
        txt_grid.add(txt_icon2, gbc);

        gbc.gridx = 1;
        gbc.weightx = 5.6;
        txt2 = new CustomComponents.EmptyPasswordField(
                7, "Password \r\r", new Color(178, 181, 180));
        txt2.setEchoChar((char) 0);
        txt_grid.add(txt2, gbc);

        gbc.gridx = 2;
        gbc.weightx = 4;
        hidden = new CustomComponents.CustomButton("", merriweather,
                transparent, transparent, transparent, transparent, transparent,
                30, 0, transparent, false, 5,
                true, hidden_icon, 0.4);
        hidden.addActionListener(_ -> {
            if (hidden.ReturnImageState()) {
                hidden.UpdateCustomButton(30, 0, show_icon, 0.35);
            } else {
                hidden.UpdateCustomButton(30, 0, hidden_icon, 0.4);
            }
            txt2.UpdateStatus(hidden.ReturnImageState());
            txt2.repaint();
        });
        txt_grid.add(hidden, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.weightx = 4;
        gbc.weighty = 0.05;
        gbc.insets = new Insets(6, 12, 15, 0);
        pick_grid = new CustomComponents.RoundedPanel(
                0, 0, 0, transparent, transparent);
        pick_grid.setLayout(new GridBagLayout());
        right_grid.add(pick_grid, gbc);

        gbc.gridy = 0;
        gbc.weightx = 2;
        check = new JCheckBox("<html><div style='color:#383546;'>"
                + "<pre><b> Remember me</b></pre></div></html>");
        check.setBorder(null);
        check.setFocusPainted(false);
        check.setOpaque(false);
        check.setVerticalAlignment(SwingConstants.TOP);
        pick_grid.add(check,gbc);

        gbc.gridx = 1;
        gbc.weightx = 8;
        JLabel placeholder1 = new JLabel("");
        pick_grid.add(placeholder1, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.weightx = 10;
        gbc.weighty = 0.125;
        gbc.insets = new Insets(0, 0, 0, 0);
        button = new CustomComponents.CustomButton(
                "Sign In", merriweather, Color.BLACK, Color.WHITE,
                new Color(244, 156, 187), new Color(56, 53, 70),
                new Color(161, 111, 136), 30, 14, Color.WHITE,
                true, 5, false, null, 0);
        button.addActionListener(e -> {
            if (txt1.getText().isEmpty() || txt1.getText().equals("Username or email \r\r") ||
                    new String(txt2.getPassword()).isEmpty() ||
                    new String(txt2.getPassword()).equals("Password \r\r")) {
                CustomComponents.CustomDialog error_empty = new CustomComponents.CustomDialog(parent,
                        merriweather, 0);
                error_empty.show_dialog("Error", "Details must not be empty!",
                        "Ok", null, null, null);
            } else if (txt1.getText().contains(" ") || new String(txt2.getPassword()).contains(" ")) {

            }
        });
        right_grid.add(button, gbc);

        outer_grid.add(right_panel, gbc);
        background.add(outer_grid);
        parent.add(background);

        SwingUtilities.invokeLater(logo_cell::requestFocusInWindow);
    }
    
    public static void UpdateComponentSize() {
        int parent_width = parent.getContentPane().getWidth();
        int parent_height = parent.getContentPane().getHeight();
        background.updateSize(parent_width, parent_height);
        logo_cell.repaint();
        logo_text1.setFont(merriweather.deriveFont((float) parent_height / 30));
        logo_text2.setFont(boldonse.deriveFont((float) parent_height  / 25));
        right_title.setFont(merriweather.deriveFont((float) parent_height / 14));
        txt_grid.ChangeRadius(parent_height / 16);
        txt1.setFont(merriweather.deriveFont((float) parent_height / 30));
        txt2.setFont(merriweather.deriveFont((float) parent_height / 30));
        check.setFont(merriweather.deriveFont((float) parent_height / 40));
        check.setIcon(new CustomComponents.CustomCheckBoxIcon(30, 3,2,false,
                new Color(145, 145, 145), Color.WHITE, new Color(97, 97, 97)));
        check.setSelectedIcon(new CustomComponents.CustomCheckBoxIcon(30, 3,1,true,
                new Color(145, 145, 145), Color.WHITE, new Color(97, 97, 97)));
        button.UpdateCustomButton(parent_height / 12, parent_height / 30, null, 0);
        txt_icon1.repaint();
        txt_icon2.repaint();
    }
}
