package io.github.team10.escapefromuni;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.utils.ScreenUtils;

public class GameOverScreen implements Screen {

    private final EscapeGame game;
    private BitmapFont font;
    private boolean isWon;
    private Texture winScreen;
    private Texture loseScreen;

    private final Timer timer;
    private final ScoreManager scoreManager;

    public GameOverScreen(final EscapeGame game, boolean isWon, Timer timer, ScoreManager scoreManager) {
        this.game = game;
        this.isWon = isWon;
        font = game.font;
        winScreen = new Texture("WinScreen.png");
        loseScreen = new Texture("LoseScreen.png");
        this.timer = timer;
        this.scoreManager = scoreManager;
    }

    @Override
    public void render(float delta) {
        if (Gdx.input.isKeyJustPressed(Input.Keys.ESCAPE)) {
            AudioManager.getInstance().playClickSound();
            game.setScreen(new MainMenu(game));
            dispose();
            return;
        }

        ScreenUtils.clear(Color.BLACK);
        game.uiViewport.apply();
        game.batch.setProjectionMatrix(game.uiCamera.combined);
        game.batch.begin();

        if(isWon){
            renderWinScreen();
        }
        else{
            renderLoseScreen();
        }



        game.batch.end();
    }

    private void renderWinScreen(){
        game.batch.draw(winScreen, 0, 0, game.uiViewport.getWorldWidth(), game.uiViewport.getWorldHeight());
        String timeText = "Time Elapsed: " + timer.getTimeSeconds();
        int finalScore = scoreManager.CalculateFinalScore(timer.getTimeLeftSeconds());
        String scoreText = "Score: " + finalScore;

        game.font.setColor(Color.BLACK);
        GlyphLayout layout = new GlyphLayout();

        float uiWidth = game.uiViewport.getWorldWidth();
        float uiHeight = game.uiViewport.getWorldHeight();

        // Draw time elapsed text
        layout.setText(game.font, timeText);
        float timeX = (uiWidth - layout.width) / 2f;
        float timeY = uiHeight * 0.35f;
        game.font.draw(game.batch, layout, timeX, timeY);

        // Draw score text
        layout.setText(game.font, scoreText);
        float scoreX = (uiWidth - layout.width) / 2f;
        float scoreY = uiHeight * 0.3f;
        font.draw(game.batch, scoreText, scoreX, scoreY);
    }

    private void renderLoseScreen(){
        game.batch.draw(loseScreen, 0, 0, game.uiViewport.getWorldWidth(), game.uiViewport.getWorldHeight());
    }

    @Override public void show() {}
    @Override public void resize(int width, int height) {}
    @Override public void pause() {}
    @Override public void resume() {}
    @Override public void hide() {}
    @Override public void dispose() { 
        winScreen.dispose();
        loseScreen.dispose();
    }
}
