import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import com.formdev.flatlaf.FlatIntelliJLaf;

public class Main {
    public static int indicator = 0;
    public static final Color transparent = new Color(0, 0, 0, 0);
    public static final String userdata_file = "datafile/user.txt";

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            BufferedImage icon;
            Font merriweather, boldonse;

            try {
                UIManager.setLookAndFeel(new FlatIntelliJLaf());
                icon = ImageIO.read(new File("images/icon.png"));
                merriweather = Font.createFont(Font.TRUETYPE_FONT,
                                new File("fonts_and_resources/static/Merriweather_24pt-Regular.ttf"))
                        .deriveFont(Font.PLAIN, 14);
                boldonse = Font.createFont(Font.TRUETYPE_FONT,
                                new File("fonts_and_resources/Boldonse-Regular.ttf"))
                        .deriveFont(Font.PLAIN, 14);
                GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
                ge.registerFont(merriweather);
                ge.registerFont(boldonse);
            } catch (IOException e) {
                e.getStackTrace();
                return;
            } catch (FontFormatException | UnsupportedLookAndFeelException e) {
                throw new RuntimeException(e);
            }

            JFrame main_frame = new JFrame();
            main_frame.setMinimumSize(new Dimension(1330, 780));
            main_frame.setTitle("OWSB Automated Purchase Order Management System");
            main_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            main_frame.setLocationRelativeTo(null);
            main_frame.setResizable(true);
            main_frame.setIconImage(icon);

            SignIn.SignInLoader(main_frame, merriweather, boldonse);
            PageChanger(main_frame, merriweather, boldonse);

            main_frame.addComponentListener(new ComponentAdapter() {
                @Override
                public void componentResized(ComponentEvent e) {
                    SignIn.UpdateComponentSize(
                    main_frame.getContentPane().getWidth(),
                    main_frame.getContentPane().getHeight());
                }
            });

            main_frame.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    Component clickedComponent = e.getComponent();
                    SwingUtilities.invokeLater(clickedComponent::requestFocusInWindow);
                }
            });
        });
    }

    public static void PageChanger(JFrame parent, Font merriweather, Font boldonse) {
        switch (indicator) {
//    Please indicate the relation of the indicator value and specific java class:
//    0 -> Sign In Page
//    1 -> Home Page
            case 0:
                parent.getContentPane().removeAll();
                SignIn.ShowPage();
                if (User.RememberedUser(userdata_file) != null) {
                    SignIn.LoginRemembered();
                    break;
                }
                parent.revalidate();
                parent.repaint();
                parent.setVisible(true);
                break;
            case 1:
                parent.getContentPane().removeAll();
                Home.ShowPage();
                parent.revalidate();
                parent.repaint();
                parent.setVisible(true);
                break;
        }
    }
}
