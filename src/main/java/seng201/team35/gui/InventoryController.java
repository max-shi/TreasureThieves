package seng201.team35.gui;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.stage.Stage;
import seng201.team35.GameManager;
import seng201.team35.models.Tower;
import seng201.team35.models.Upgrade;
import seng201.team35.services.CounterService;
import javafx.scene.control.TextArea;

/**
 * Controller for the Inventory.fxml window
 * @author nsr36, msh254
 */
public class InventoryController {
    @FXML
    private Label moneyLabel;
    @FXML
    private Label towerName;
    @FXML
    private Label speed;
    @FXML
    private Label level;
    @FXML
    private Label cost;
    @FXML
    private Label resourceAmount;
    @FXML
    private Label towerNamelabel;
    @FXML
    private Label speedLabel;
    @FXML
    private Label levelLabel;
    @FXML
    private Label costLabel;
    @FXML
    private Label resourceAmountLabel;
    @FXML
    private Label resourceType;
    @FXML
    private ComboBox mainTowersComboBox;
    @FXML
    private ComboBox reserveTowersComboBox;
    @FXML
    private ComboBox upgradesComboBox;
    @FXML
    private Button returnToMainMenuButton;
    @FXML
    private Label resourceTypeLabel;
    @FXML
    private Button swapReserveButton;
    @FXML
    private Button swapMainButton;
    @FXML
    private Button toggleUpgradeButton;
    private GameManager gameManager;

    public InventoryController(GameManager x) {
        gameManager = x;
    }

    private Tower currentTower;
    private Upgrade currentUpgrade;
    private Boolean isMainTower;
    private Boolean isUpgrade;

    public void initialize() {
        moneyLabel.setText(String.valueOf(gameManager.getMoneyAmount()));
        updateComboBox();
    }
    @FXML
    private void goToMainMenu() {
        gameManager.closeInventoryScreen();
    }
    public void updateComboBox() {
        mainTowersComboBox.setValue("");
        reserveTowersComboBox.setValue("");
        upgradesComboBox.setValue("");
        mainTowersComboBox.getItems().setAll(Tower.getTowerNames(gameManager.getMainTowerList()));
        reserveTowersComboBox.getItems().setAll(Tower.getTowerNames(gameManager.getReserveTowerList()));
        upgradesComboBox.getItems().setAll(Upgrade.getUpgradeNames(gameManager.getUpgradesList()));
        towerNamelabel.setText("");
        speedLabel.setText("");
        levelLabel.setText("");
        costLabel.setText("");
        resourceAmountLabel.setText("");
        resourceTypeLabel.setText("");}
    public void updateComboBoxUpgrade() {}
    @FXML
    private void selectedMainTower() {
            isUpgrade = false;
            isMainTower = true;
            towerName.setText("Tower name");
            speed.setText("Speed");
            level.setText("Level");
            resourceAmount.setText("Resource Amount");
            resourceType.setText("Resource Type");
            currentTower = gameManager.getTowerClass(mainTowersComboBox.getValue().toString());
            towerNamelabel.setText(currentTower.getName());
            speedLabel.setText(String.valueOf(currentTower.getReloadSpeed()));
            levelLabel.setText(String.valueOf(currentTower.getLevel()));
            costLabel.setText(String.valueOf(currentTower.getCost()));
            resourceAmountLabel.setText(String.valueOf(currentTower.getMaxAmount()));
            resourceTypeLabel.setText(String.valueOf(currentTower.getResourceType()));
        }

    @FXML
    private void selectedReserveTower() {
        isUpgrade = false;
        isMainTower = false;
        towerName.setText("Tower name");
        speed.setText("Speed");
        level.setText("Level");
        resourceAmount.setText("Resource Amount");
        resourceType.setText("Resource Type");
        currentTower = gameManager.getTowerClass(reserveTowersComboBox.getValue().toString());
        towerNamelabel.setText(currentTower.getName());
        speedLabel.setText(String.valueOf(currentTower.getReloadSpeed()));
        levelLabel.setText(String.valueOf(currentTower.getLevel()));
        costLabel.setText(String.valueOf(currentTower.getCost()));
        resourceAmountLabel.setText(String.valueOf(currentTower.getMaxAmount()));
        resourceTypeLabel.setText(String.valueOf(currentTower.getResourceType()));
    }
    @FXML
    private void selectedMyUpgrade() {
        isUpgrade = true;
        isMainTower = false;
        towerName.setText("Upgrade type");
        speed.setText("Resource Boost");
        level.setText("Reload Speed Boost");
        resourceAmount.setText("Status");
        resourceAmountLabel.setText("");
        resourceTypeLabel.setText("");
        resourceType.setText("");
        currentUpgrade = gameManager.getUpgradeClass(upgradesComboBox.getValue().toString());
        towerNamelabel.setText(currentUpgrade.getResourceType());
        speedLabel.setText(String.valueOf(currentUpgrade.getBoostResourceAmount()));
        levelLabel.setText(String.valueOf(currentUpgrade.getReduceReloadSpeed()));
        resourceAmountLabel.setText(currentUpgrade.getStatus());
        costLabel.setText(String.valueOf(currentUpgrade.getCost()));}
    @FXML
    private void swapReserve() {
        if (isUpgrade == false) {
            if (isMainTower == true) {
                if (mainTowersComboBox.getValue() != "") {
                    gameManager.removeMainTower(currentTower);
                    gameManager.addReserveTower(currentTower);
                    updateComboBox();
                }
            }
        }
    }
    @FXML
    private void swapMain() {
        if (isUpgrade == false) {
            if (isMainTower == false) {
                if (reserveTowersComboBox.getValue() != "") {
                    gameManager.removeReserveTower(currentTower);
                    gameManager.addMainTower(currentTower);
                    updateComboBox();
                }
            }
        }
    }
    @FXML
    private void toggleUpgrade() {
        if (isUpgrade == true) {
            if (upgradesComboBox.getValue() != "") {
                currentUpgrade.toggleStatus();
                updateComboBox();
            }
        }
    }
}

