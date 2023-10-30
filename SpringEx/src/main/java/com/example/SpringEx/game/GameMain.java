package com.example.SpringEx.game;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.example.SpringEx.game")
public class GameMain {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(GameMain.class);

        // 결합도 : 어떤것을 변경할 때 얼마나 많은 작업이 관련되어 있는지에 대한 측정
//        DiabloGame game = new DiabloGame();
//        GameEngine engine = new GameEngine(game);
//        engine.run();
//
//        LoLGame game2 = new LoLGame();
//        GameEngine engine2 = new GameEngine(game2);
//        engine2.run();

        context.getBean(GameConsole.class).up();
        context.getBean(GameEngine.class).run();
    }
}