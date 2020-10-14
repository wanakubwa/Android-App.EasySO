package pl.io.quizapi;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import pl.io.quizapi.dao.AnswersRepository;
import pl.io.quizapi.dao.QuestionsRepository;
import pl.io.quizapi.dao.QuizesRepository;
import pl.io.quizapi.dao.entities.Answer;
import pl.io.quizapi.dao.entities.Question;
import pl.io.quizapi.dao.entities.Quiz;

@SpringBootApplication
public class QuizApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(QuizApiApplication.class, args);
    }

    @Bean
    public CommandLineRunner dbInit(QuizesRepository quizesRepo, QuestionsRepository questionsRepo, AnswersRepository anwersRepo) {
        return args -> {

            Quiz quiz = new Quiz("nauka");

            Question question0 = new Question("Kto zrzucił na Księżyc młot i pióro, aby pokazać, że bez powietrza spadają w tym samym tempie?", quiz);
            Question question1 = new Question("Gdyby Ziemia została przekształcona w czarną dziurę, jaka byłaby średnica jej horyzontu zdarzeń?", quiz);
            Question question2 = new Question("Gdybyś spadł na pozbawioną powietrza, pozbawioną tarcia dziurę, przechodząc przez Ziemię, ile czasu zajmie opadnięcie na drugą stronę? (Do najbliższej minuty.)", quiz);

            Answer a1 = new Answer("David R. Scott", true, question0);
            Answer a2 = new Answer("Andrzej Duda", false, question0);
            Answer a3 = new Answer("20mm", true, question1);
            Answer a4 = new Answer("Andrzej Duda", false, question1);
            Answer a5 = new Answer("42 minut", true, question2);
            Answer a6 = new Answer("Andrzej Duda", false, question2);


            quizesRepo.save(quiz);

            questionsRepo.save(question0);
            questionsRepo.save(question1);
            questionsRepo.save(question2);

            anwersRepo.save(a1);
            anwersRepo.save(a2);
            anwersRepo.save(a3);
            anwersRepo.save(a4);
            anwersRepo.save(a5);
            anwersRepo.save(a6);


        };
    }
}
