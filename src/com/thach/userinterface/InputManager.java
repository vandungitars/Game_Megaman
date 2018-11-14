/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thach.userinterface;

import com.thach.gameobject.GameWorld;
import java.awt.event.KeyEvent;

/**
 *
 * @author phamn
 */
public class InputManager {
    
    private GameWorld gameWorld;
    
    public InputManager(GameWorld gameWorld){
        this.gameWorld = gameWorld;
    }
    
    public void setPressedButton(int code){
        switch(code){
            
            case KeyEvent.VK_DOWN:
                gameWorld.megaMan.dick();
                break;
                
            case KeyEvent.VK_RIGHT:
                gameWorld.megaMan.setDirection(gameWorld.megaMan.RIGHT_DIR);
                gameWorld.megaMan.run();
                break;
                
            case KeyEvent.VK_LEFT:
                gameWorld.megaMan.setDirection(gameWorld.megaMan.LEFT_DIR);
                gameWorld.megaMan.run();
                break;
                
            case KeyEvent.VK_ENTER:
                if(gameWorld.state == GameWorld.PAUSEGAME){
                    if(gameWorld.previousState == GameWorld.GAMEPLAY)
                        gameWorld.switchState(GameWorld.GAMEPLAY);
                    else gameWorld.switchState(GameWorld.TUTORIAL);
                    
                    gameWorld.bgMusic.loop();
                    gameWorld.bgMusic.play();
                }
                if(gameWorld.state == GameWorld.TUTORIAL && gameWorld.storyTutorial >= 1){
                    if(gameWorld.storyTutorial<=3){
                        gameWorld.storyTutorial ++;
                        gameWorld.currentSize = 1;
                        gameWorld.textTutorial = gameWorld.texts1[gameWorld.storyTutorial-1];
                    }else{
                        gameWorld.switchState(GameWorld.GAMEPLAY);
                    }
                    
                    // for meeting boss tutorial
                    if(gameWorld.tutorialState == GameWorld.MEETFINALBOSS){
                        gameWorld.switchState(GameWorld.GAMEPLAY);
                    }
                }
                break;
                
            case KeyEvent.VK_SPACE:
                gameWorld.megaMan.jump();
                break;
                
            case KeyEvent.VK_A:
                gameWorld.megaMan.attack();
                break;
                
        }
    }
    
    public void setReleasedButton(int code){
        switch(code){
            
            case KeyEvent.VK_UP:
                
                break;
                
            case KeyEvent.VK_DOWN:
                gameWorld.megaMan.standUp();
                break;
                
            case KeyEvent.VK_RIGHT:
                if(gameWorld.megaMan.getSpeedX() > 0)
                    gameWorld.megaMan.stopRun();
                break;
                
            case KeyEvent.VK_LEFT:
                if(gameWorld.megaMan.getSpeedX() < 0)
                    gameWorld.megaMan.stopRun();
                break;
                
            case KeyEvent.VK_ENTER:
                
                break;
                
            case KeyEvent.VK_SPACE:
                
                break;
                
            case KeyEvent.VK_A:
                
                break;
                
        }
    }
    
}
