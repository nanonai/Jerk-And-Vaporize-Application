package Common;
import javax.swing.*;
import java.awt.*;
import Admin.*;
import SalesMgr.*;
import PurchaseMgr.*;
import InventoryMgr.*;
import FinanceMgr.*;


public class Home {
    public static int indicator = -1;
    public static Buffer current_user;
    private static JFrame parent;
    private static Font merriweather, boldonse;
    private static CustomComponents.ColorPanel background;
    private static JPanel outer_grid, side_bar, top_bar, content;

    public static void Loader(JFrame parent, Font merriweather, Font boldonse) {
        Home.merriweather = merriweather;
        Home.boldonse = boldonse;
        Home.parent = parent;
    }

    public static void ShowPage() {
        background = new CustomComponents.ColorPanel(new Color(239, 239, 239), 16.0 / 9.0);
        outer_grid = background.getGridPanel();
        GridBagConstraints gbc_outer = new GridBagConstraints();

        gbc_outer.gridx = 0;
        gbc_outer.gridy = 0;
        gbc_outer.fill = GridBagConstraints.BOTH;
        gbc_outer.gridheight = 2;
        gbc_outer.weightx = 1;
        side_bar = new JPanel(new GridBagLayout());
        side_bar.setOpaque(true);
        side_bar.setBackground(new Color(56, 53, 70));
        outer_grid.add(side_bar, gbc_outer);

        gbc_outer.gridx = 1;
        gbc_outer.gridheight = 1;
        gbc_outer.weighty = 1;
        gbc_outer.weightx = 11;
        top_bar = new JPanel(new GridBagLayout());
        top_bar.setOpaque(true);
        top_bar.setBackground(Color.WHITE);
        outer_grid.add(top_bar, gbc_outer);

        gbc_outer.gridy = 1;
        gbc_outer.weighty = 14;
        content = new JPanel(new GridBagLayout());
        content.setOpaque(false);
        outer_grid.add(content, gbc_outer);

        AdmHome.Loader(parent, merriweather, boldonse, side_bar, top_bar, content);
        SalesHome.Loader(parent, merriweather, boldonse, side_bar, top_bar, content);
        PurchaseHome.Loader(parent, merriweather, boldonse, side_bar, top_bar, content);
        InventoryHome.Loader(parent, merriweather, boldonse, side_bar, top_bar, content);
        FinanceHome.Loader(parent, merriweather, boldonse, side_bar, top_bar, content);
        PageChanger();

        background.add(outer_grid, gbc_outer);
        parent.setContentPane(background);
        SwingUtilities.invokeLater(side_bar::requestFocusInWindow);
    }

    public static void PageChanger() {
        side_bar.removeAll();
        top_bar.removeAll();
        content.removeAll();
        side_bar.revalidate();
        side_bar.repaint();
        top_bar.revalidate();
        top_bar.repaint();
        content.revalidate();
        content.repaint();
        switch (indicator) {
//    Please indicate the relation of the indicator value and specific java class:
//    0 -> Administrator Home Page
//    1 -> Sales Manager Home Page
//    2 -> Purchase Manager Home Page
//    3 -> Inventory Manager Home Page
//    4 -> Finance Manager Home Page
            case 0:
                AdmHome.ShowPage();
                break;
            case 1:
                SalesHome.ShowPage();
                break;
            case 2:
                PurchaseHome.ShowPage();
                break;
            case 3:
                InventoryHome.ShowPage();
                break;
            case 4:
                FinanceHome.ShowPage();
                break;
        }
    }

    public static void UpdateComponentSize(int parent_width, int parent_height) {
        background.updateSize(parent_width, parent_height);
        outer_grid.revalidate();
        outer_grid.repaint();
        side_bar.revalidate();
        side_bar.repaint();
        top_bar.revalidate();
        top_bar.repaint();
        content.revalidate();
        content.repaint();
        switch (indicator) {
            case 0:
                AdmHome.UpdateComponentSize(parent_width, parent_height);
                SwingUtilities.invokeLater(() -> {
                    AdmHome.UpdateComponentSize(parent_width, parent_height);
                });
                break;
            case 1:
                SalesHome.UpdateComponentSize(parent_width, parent_height);
                SwingUtilities.invokeLater(() -> {
                    SalesHome.UpdateComponentSize(parent_width, parent_height);
                });
                break;
            case 2:
                PurchaseHome.UpdateComponentSize(parent_width, parent_height);
                SwingUtilities.invokeLater(() -> {
                    PurchaseHome.UpdateComponentSize(parent_width, parent_height);
                });
                break;
            case 3:
                InventoryHome.UpdateComponentSize(parent_width, parent_height);
                SwingUtilities.invokeLater(() -> {
                    InventoryHome.UpdateComponentSize(parent_width, parent_height);
                });
                break;
            case 4:
                FinanceHome.UpdateComponentSize(parent_width, parent_height);
                SwingUtilities.invokeLater(() -> {
                    FinanceHome.UpdateComponentSize(parent_width, parent_height);
                });
                break;
        }
    }
}
