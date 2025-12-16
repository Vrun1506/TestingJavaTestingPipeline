package io.github.team10.escapefromuni;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.utils.viewport.FitViewport;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 * Tests for the GameOverScreen class.
 * We are setting up mock objects for the graphics components to test them out
 * 
 */
public class GameOverScreenTest extends HeadlessTestRunner {
    
    private GameOverScreen winScreen;
    private GameOverScreen loseScreen;
    private EscapeGame mockGame;
    private Timer mockTimer;
    private ScoreManager mockScoreManager;
    private BitmapFont mockFont;
    private FitViewport mockUIViewport;
    private OrthographicCamera mockUICamera;
    
    @Before
    public void setUp() {
        mockGame = mock(EscapeGame.class);
        mockTimer = mock(Timer.class);
        mockScoreManager = mock(ScoreManager.class);
        mockFont = mock(BitmapFont.class);
        mockUIViewport = mock(FitViewport.class);
        mockUICamera = mock(OrthographicCamera.class);
        
        when(mockUIViewport.getWorldWidth()).thenReturn(1920f);
        when(mockUIViewport.getWorldHeight()).thenReturn(1080f);
        
        mockGame.font = mockFont;
        mockGame.uiViewport = mockUIViewport;
        mockGame.uiCamera = mockUICamera;
        
        when(mockTimer.getTimeSeconds()).thenReturn(120);
        when(mockTimer.getTimeLeftSeconds()).thenReturn(180);
        when(mockScoreManager.CalculateFinalScore(anyInt())).thenReturn(1500);
        
        winScreen = new GameOverScreen(mockGame, true, mockTimer, mockScoreManager);
        loseScreen = new GameOverScreen(mockGame, false, mockTimer, mockScoreManager);
    }
    
    @After
    public void tearDown() {
        if (winScreen != null) {
            winScreen.dispose();
        }
        if (loseScreen != null) {
            loseScreen.dispose();
        }
    }
    
    @Test
    public void WinScreenInitialization() {
        // Test that the win screen is initialized correctly
        assertNotNull("Win screen should be initialized", winScreen);
    }
    
    @Test
    public void LoseScreenInitialization() {
        // Test that the win screen is initialized correctly
        assertNotNull("Lose screen should be initialized", loseScreen);
    }
    
    @Test
    public void ShowMethod() {
        // Test show method for both screens
        winScreen.show();
        loseScreen.show();
    }
    
    @Test
    public void ResizeMethod() {
        // Test resize method for both screens
        winScreen.resize(800, 600);
        loseScreen.resize(800, 600);
    }
    
    @Test
    public void PauseMethod() {
        // Test pause method for both screens
        winScreen.pause();
        loseScreen.pause();
    }
    
    @Test
    public void ResumeMethod() {
        // Test resume method for both screens
        winScreen.resume();
        loseScreen.resume();
    }
    
    @Test
    public void HideMethod() {
        // Test hide method for both screens
        winScreen.hide();
        loseScreen.hide();
    }
}