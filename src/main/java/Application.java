import com.quadrivium.g13.controller.LevelManagerController;
import com.quadrivium.g13.exceptions.InvalidGameException;
import com.quadrivium.g13.exceptions.OutOfBoundsException;
import com.quadrivium.g13.model.*;
import com.quadrivium.g13.view.LanternaLevelManagerView;
import com.quadrivium.g13.view.LevelManagerView;
import com.quadrivium.g13.view.SwingLevelManagerView;

import java.io.IOException;

public class Application {
    public static void main(String[] args) {

        if(args.length != 0){
            if(args[0].equals("swing")){
                GameDimensions.setSwing(true);
            }
        }else{ //default
            GameDimensions.setSwing(false);
        }

        CreateGame game = new CreateGame();
        game.initGame();
        LevelManager levelManager;
        try {
            levelManager = new LevelManager();
        } catch (OutOfBoundsException e) {
            e.printStackTrace();
            return;
        }
        LevelManagerView view;
        if(GameDimensions.isSwing()){
            view = new SwingLevelManagerView();
        }else{
            view = new LanternaLevelManagerView();
        }
        LevelManagerController controller;
        try {
            controller = new LevelManagerController(levelManager, view);
        } catch(OutOfBoundsException e){
            e.printStackTrace();
            return;
        }

        try {
            controller.run();
            controller.closeScreen();
        } catch (IOException | InterruptedException | OutOfBoundsException | InvalidGameException e){
            e.printStackTrace();
        }
    }
}
