//package game;
//
//import org.springframework.context.annotation.Bean;
//
//public class GameConfiguration {
//    @Bean
//    public GameConsole diabloGame() {
//        return new DiabloGame();
//    }
//
//    @Bean
//    public GameEngine gameEngine(GameConsole game) {
//        return new GameEngine(game);
//    }
//
//    @Bean
//    public GameConsole lolGame() {
//        return new LoLGame();
//    }
//}