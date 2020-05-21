package com.quadrivium.g13.controller;

import com.quadrivium.g13.model.*;
import com.quadrivium.g13.view.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MenuController implements GameController {
    private Menu model;
    private MenuView view;

    public MenuController(Menu model, MenuView view) {
        this.model = model;
        this.view = view;
        this.initSectors();
    }

    public PlayerController getPlayer() {
        return model.getPlayer();
    }

    public void setPlayer(PlayerController player) {
        model.setPlayer(player);
    }

    public List<Sector> createSector(int x, int y, String color) {
        List<Sector> sec = new ArrayList<>();
        for (int j = 0; j < 16; j++) {
            for (int i = 0; i < 15; i++) {
                if (i < j || i >= (15 - j))
                    continue;

                sec.add(new Sector(new Position(x + j * 2, y + i), color, "I"));
                sec.add(new Sector(new Position(x + j * 2 + 1, y + i), color, "I"));
                sec.add(new Sector(new Position(x - j * 2 - 1, y + i), color, "I"));


                if ((j == 0) && (i == 0)) {
                    sec.add(new Sector(new Position(x, y - 1), color, "I"));
                    sec.add(new Sector(new Position(x, y + 15), color, "I"));
                    continue;
                }

                sec.add(new Sector(new Position(x - j * 2, y + i), color, "I"));
            }
        }

        return sec;
    }

    public List<List<Sector>> createSectors() {
        List<List<Sector>> sectors = new ArrayList<>();

        sectors.add(createSector(GameDimensions.getWidth() / 2, GameDimensions.getHeight() / 2 - 17, "#FF0000"));
        sectors.add(createSector(GameDimensions.getWidth() / 2 - 18, GameDimensions.getHeight() / 2 - 7, "#FF5A00"));
        sectors.add(createSector(GameDimensions.getWidth() / 2 + 18, GameDimensions.getHeight() / 2 - 7, "#0000FF"));
        sectors.add(createSector(GameDimensions.getWidth() / 2, GameDimensions.getHeight() / 2 + 3, "#00FF00"));

        return sectors;
    }

    public void initSectors() {
        model.setSectors(createSectors());
    }

    @Override
    public void draw() {
        if (GameDimensions.isSwing())
            model.getPlayer().draw();
        view.draw(model.getSectors());
        if (!GameDimensions.isSwing())
            model.getPlayer().draw();
    }

    public boolean changeLevel(CurrentLevel level) {
        for (int i = 0; i < 4; i++) {
            for (Sector sector : model.getSectors().get(i)) {
                if (sector.getPosition().equals(model.getPlayer().getPosition())) {
                    switch (i) {
                        case 0:
                            if (GameDimensions.isSwing())
                                level.setActiveGame(new BattleTanksController(new BattleTanks(), new SwingBattleTanksView()));
                            else
                                level.setActiveGame(new BattleTanksController(new BattleTanks(), new LanternaBattleTanksView()));
                            return true;
                        case 1:
                            if (GameDimensions.isSwing())
                                level.setActiveGame(new LightCyclesController(new LightCycles(), new SwingLightCyclesView()));
                            else
                                level.setActiveGame(new LightCyclesController(new LightCycles(), new LanternaLightCyclesView()));
                            return true;
                        case 2:
                            if (GameDimensions.isSwing())
                                level.setActiveGame(new IOTowerController(new IOTower(), new SwingIOTowerView()));
                            else
                                level.setActiveGame(new IOTowerController(new IOTower(), new LanternaIOTowerView()));
                            return true;
                        case 3:
                            if (GameDimensions.isSwing())
                                level.setActiveGame(new MCPConeController(new MCPCone(), new SwingMCPConeView()));
                            else
                                level.setActiveGame(new MCPConeController(new MCPCone(), new LanternaMCPConeView()));
                            return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean canPlayerMove(Position position) {
        return !(position.getX() >= (GameDimensions.getWidth() - 1) || position.getX() <= 0 || position.getY() >= (GameDimensions.getHeight() - 1) || position.getY() <= 0);
    }

    public void movePlayer(Position position) {
        if (canPlayerMove(position)) {
            model.getPlayer().setPosition(position);
        }
        model.getPlayer().decreaseLives();
    }

    public void handleKey(KeyPress key) {
        switch (key) {
            case UP:
                movePlayer(model.getPlayer().moveUp());
                break;
            case RIGHT:
                movePlayer(model.getPlayer().moveRight());
                break;
            case DOWN:
                movePlayer(model.getPlayer().moveDown());
                break;
            case LEFT:
                movePlayer(model.getPlayer().moveLeft());
                break;
        }
    }

    @Override
    public boolean checkEnter(KeyPress key, CurrentLevel level) {
        if (key == KeyPress.ENTER) {
            return changeLevel(level);
        }

        return false;
    }

    @Override
    public void update() {
    }

    @Override
    public GameResult play(CurrentLevel level) throws IOException, InterruptedException {
        while (true) {
            view.clearScreen();
            draw();
            view.refreshScreen();

            KeyPress key;
            if (GameDimensions.isSwing()) {
                key = level.getKey();
            } else {
                key = view.processKey();
            }

            handleKey(key);

            if (checkEnter(key, level))
                break;

            if (key == KeyPress.EXIT) {
                return GameResult.EXIT;
            }
            Thread.sleep(1000 / 30);
        }
        return GameResult.PROCEED;
    }

}
