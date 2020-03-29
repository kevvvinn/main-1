package csdev.couponstash.ui;

import csdev.couponstash.logic.Logic;
import javafx.fxml.FXML;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;

/**
 * The ui for the Tabs on the left half.
 */
public class TabsPanel extends UiPart<Region> {
    private static final String FXML = "TabsPanel.fxml";

    // Independent Ui parts residing in this Ui container
    private CouponListPanel couponListPanel;
    private SummaryPane summaryPanel;
    private Logic logic;

    @FXML
    private Tab couponTab;

    @FXML
    private Tab summaryTab;

    @FXML
    private StackPane couponListPanelPlaceholder;

    @FXML
    private StackPane summaryPanelPlaceholder;

    @FXML
    private TabPane tabPane;

    public TabsPanel(Logic logic) {
        super(FXML);
        this.logic = logic;
    }

    /**
     * Fills up all the placeholders of this window.
     */
    public void fillInnerParts() {
        couponListPanel = new CouponListPanel(
                logic.getFilteredCouponList(), logic.getStashSettings().getMoneySymbol());
        couponListPanelPlaceholder.getChildren().add(couponListPanel.getRoot());

        summaryPanel = new SummaryPane(logic);
        summaryPanelPlaceholder.getChildren().add(summaryPanel.getRoot());
    }
}