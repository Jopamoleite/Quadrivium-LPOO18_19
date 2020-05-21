import com.quadrivium.g13.controller.LevelManagerController;
import com.quadrivium.g13.model.CreateGame;
import com.quadrivium.g13.model.GameDimensions;
import com.quadrivium.g13.model.LevelManager;
import com.quadrivium.g13.view.LanternaLevelManagerView;
import com.quadrivium.g13.view.LevelManagerView;
import com.quadrivium.g13.view.SwingLevelManagerView;

import java.io.IOException;

public class Application {
    public static void main(String[] args) {

        if (args.length != 0) {
            if (args[0].equals("swing")) {
                GameDimensions.setSwing(true);
            }
        } else { //default
            GameDimensions.setSwing(false);
        }

        CreateGame game = new CreateGame();
        game.initGame();
        LevelManager levelManager = new LevelManager();
        LevelManagerView view;
        if (GameDimensions.isSwing()) {
            view = new SwingLevelManagerView();
        } else {
            view = new LanternaLevelManagerView();
        }
        LevelManagerController controller = new LevelManagerController(levelManager, view);

        try {
            controller.run();
            controller.closeScreen();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
