package pl.io.quizapi;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import pl.io.quizapi.dao.*;
import pl.io.quizapi.dao.entities.*;

@SpringBootApplication
public class QuizApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(QuizApiApplication.class, args);
    }

    @Bean
    public CommandLineRunner dbInit(CategoriesRepository categoriesRepo, ScoresRepository scoresRepo, QuizesRepository quizesRepo, QuestionsRepository questionsRepo, AnswersRepository anwersRepo) {
        return args -> {


            Category windows = new Category("Windows");
            Category linux = new Category("Linux");
            Category inne = new Category("Inne");


            Quiz quiz = new Quiz("X Window System", windows);
            Quiz quiz1 = new Quiz("Linux Kernel", linux);
            Quiz quiz2 = new Quiz("Docker", inne);

            Question question0 = new Question("Wskaż wszystkie poprawne stwierdzenia odnoszące się do X Window System", quiz);
            Question question1 = new Question("Które z podanych komponentów NIE wchodzi w skład X Window System", quiz);
            Question question2 = new Question("Czym różnią się xdm/gdm/lightdm i startx?", quiz);
            Question question3 = new Question("Zaznacz wszystkie poprawne odpowiedzi:", quiz1);
            Question question4 = new Question("Zaznacz wszystkie poprawne odpowiedzi:", quiz1);
            Question question5 = new Question("Zaznacz wszystkie poprawne odpowiedzi:", quiz1);
            Question question6 = new Question("W jaki sposób można trwale przechowywać dane z kontenera?", quiz2);
            Question question7 = new Question("Które polecenie pozwala na wyświetlenie działających kontenerów?", quiz2);
            Question question8 = new Question("Obraz zbudowany na bazie innego obrazu:", quiz2);

            Answer a0 = new Answer("Został on zaprojektowany w architekturze klient-serwer.", true, question0);
            Answer a1 = new Answer("Jest to zbiór funkcji i protokołów wyświetlających informacje graficzne na ekranie.", true, question0);
            Answer a2 = new Answer(" Odpowiada za wygląd okien wyświetlanych w systemie.", false, question0);
            Answer a3 = new Answer(" Pozwala na zdalną pracę na odległym komputerze, wykorzystując komputer lokalny jako serwer X.", true, question0);

            Answer a4 = new Answer("Serwer Apache.", true, question1);
            Answer a5 = new Answer("Menadżer okien.", false, question1);
            Answer a6 = new Answer("Baza danych.", true, question1);
            Answer a7 = new Answer("X serwer.", false, question1);

            Answer a8 = new Answer("Gdy X zostanie opuszczony za pomocą polecenia zakończenia menadżera okna Xdm ponownie pokazuje ekran logowania.", true, question2);
            Answer a9 = new Answer("Xdm/Gdm/lightdm uruchamia ekran logowania.", false, question2);
            Answer a10 = new Answer("Startx uruchamia ekran logowania.", true, question2);
            Answer a11 = new Answer("Gdy X zostanie opuszczony za pomocą polecenia zakończenia menadżera okna startx ponownie pokazuje ekran logowania.", false, question2);

            // Linux Kernel
            Answer a12 = new Answer("Jądro Linuxa jest mikrojądrem (microkernel)", false, question3);
            Answer a13 = new Answer("Jądro Linuxa jest jądrem typu hybrydowego (hybrid)", false, question3);
            Answer a14 = new Answer("Jądro Linuxa jest jądrem typu monolitycznego (monolythic)", true, question3);
            Answer a15 = new Answer("Jądro Linuxa jest napisane w C++", false, question3);

            Answer a16 = new Answer("Jądro Linuxa wykorzystuje bibliotekę libc (dzięki temu można wykorzystywać np. funkcję printf()", false, question4);
            Answer a17 = new Answer("Jądro Linuxa jest napisane w C.", true, question4);
            Answer a18 = new Answer("Jądro Linuxa zarządza pamięcią operacyjną (przydziały/zwolnienia).", true, question4);

            Answer a19 = new Answer("Do sterowania parametrami pracy jądra można wykorzystać pliki znajdujące się w katalogu /var.", false, question5);
            Answer a20 = new Answer("Do sterowania pracą jądra Linuxa można wykorzystać polecenie /sysctl.", true, question5);
            Answer a21 = new Answer("Do jądra systemu operacyjnego Linux można, w czasie jego pracy, dołączać różnorodną funkcjonalność (np. sterowniki urządzenia).", true, question5);
            Answer a22 = new Answer("Do załadowania modułu w jądrze można wykorzystać polecenia rmmod oraz modprobe -r.", false, question5);

            //
            Answer a23 = new Answer("nie ma takiej możliwości", false, question6);
            Answer a24 = new Answer("woluminem nazwanym", true, question6);
            Answer a25 = new Answer("woluminem anonimowym", false, question6);
            Answer a26 = new Answer(" poleceniem cp", false, question6);

            Answer a27 = new Answer("docker processes", false, question7);
            Answer a28 = new Answer("docker ps -a", true, question7);
            Answer a29 = new Answer("docker ps", true, question7);
            Answer a30 = new Answer("docker list", false, question7);

            Answer a31 = new Answer(" niezależnie od dodanych instrukcji ma taki sam rozmiar jak obraz bazowy", false, question8);
            Answer a32 = new Answer(" tworzy się za pomocą Dockerfile", true, question8);
            Answer a33 = new Answer(" nie ma takiej możliwości", false, question8);
            Answer a34 = new Answer(" jest obrazem pochodnym", true, question8);


            Score score0 = new Score("Malik Montana", 20);
            Score score1 = new Score("Elon Musk", 29);


            categoriesRepo.save(windows);
            categoriesRepo.save(linux);
            categoriesRepo.save(inne);

            quizesRepo.save(quiz);
            quizesRepo.save(quiz1);
            quizesRepo.save(quiz2);

            questionsRepo.save(question0);
            questionsRepo.save(question1);
            questionsRepo.save(question2);
            questionsRepo.save(question3);
            questionsRepo.save(question4);
            questionsRepo.save(question5);
            questionsRepo.save(question6);
            questionsRepo.save(question7);
            questionsRepo.save(question8);


            scoresRepo.save(score0);
            scoresRepo.save(score1);

            anwersRepo.save(a0);
            anwersRepo.save(a1);
            anwersRepo.save(a2);
            anwersRepo.save(a3);
            anwersRepo.save(a4);
            anwersRepo.save(a5);
            anwersRepo.save(a6);
            anwersRepo.save(a7);
            anwersRepo.save(a8);
            anwersRepo.save(a9);
            anwersRepo.save(a10);
            anwersRepo.save(a11);
            anwersRepo.save(a12);
            anwersRepo.save(a13);
            anwersRepo.save(a14);
            anwersRepo.save(a15);
            anwersRepo.save(a16);
            anwersRepo.save(a17);
            anwersRepo.save(a18);
            anwersRepo.save(a19);
            anwersRepo.save(a20);
            anwersRepo.save(a21);
            anwersRepo.save(a22);
            anwersRepo.save(a23);
            anwersRepo.save(a24);
            anwersRepo.save(a25);
            anwersRepo.save(a26);
            anwersRepo.save(a27);
            anwersRepo.save(a28);
            anwersRepo.save(a29);
            anwersRepo.save(a30);
            anwersRepo.save(a31);
            anwersRepo.save(a32);
            anwersRepo.save(a33);
            anwersRepo.save(a34);
        };
    }
}
