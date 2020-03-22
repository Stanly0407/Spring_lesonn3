package springLes3;

import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
//@ComponentScan("springLes3")
@PropertySource("classpath:musicPlayer.properties")
public class SpringConfig {
    @Bean
    public ClassicalMusic classicalMusic(){
        return new ClassicalMusic();}

    @Bean
    public RockMusic rockMusic(){
        return new RockMusic();}

    @Bean
    public MusicPlayer musicPlayer() {
        return new MusicPlayer(rockMusic(), classicalMusic());} //внедрили зависимости жанров с песнями в наш плеер,
                                                                // а в плеере есть конструктор с указателями бинов

    @Bean
    public Computer computer() {
        return new Computer(musicPlayer());
    }
}
