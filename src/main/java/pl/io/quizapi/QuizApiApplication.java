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

    private void createDSQuiz(CategoriesRepository categoriesRepo, ScoresRepository scoresRepo, QuizesRepository quizesRepo, QuestionsRepository questionsRepo, AnswersRepository anwersRepo) {
        Category DS = new Category("DS");
        Quiz ds = new Quiz("DS", DS);

        Question question0 = new Question("Wskaż wszystkie poprawne stwierdzenia odnoszące się do X Window System", ds);
        Question question1 = new Question("Proszę wskazać poprawne zdania dotyczące sieci społecznych", ds);
        Question question2 = new Question(".Liczbę sąsiadów węzła w sieci społecznej (węzłów, z którymi dany węzeł jest powiązany) określa: ODP DO SPRAWDZENIA", ds);
        Question question3 = new Question("Dla poniższej tablicy decyzyjnej zdefiniowano regułę decyzyjną IF aura=deszczowa and temperatura=umiarkowana THEN c=1", ds);
        Question question4 = new Question("Poniżej przedstawiono dwuwymiarowy zbiór danych podzielony na grupy (każda grupa wyróżniona jest innym znakiem graficznym)", ds);
        Question question5 = new Question("Przyjmując następujące oznaczenia: TP - wyniki prawdziwie pozytywne (true\n" +
                "positive), TN - wyniki prawdziwie negatywne (true negative), FP - wyniki fałszywie\n" +
                "pozytywne (false positive), FN - wyniki fałszywie negatywne (false positive)", ds);
        Question question6 = new Question(".Czyszczenie danych to ogólna nazwa na jeden z etapów przetwarzania wstępnego.\n" +
                "Które z poniższych metod można wykorzystać na tym etapie? ODP DO SPRAWDZENIA", ds);
        Question question7 = new Question("Wybierz poprawne pary - algorytm indukcji drzewa decyzyjnego - metoda wyboru\n" +
                "najlepszego atrybutu\n", ds);
        Question question8 = new Question("9.Dany jest zbiór atrybutów (a1, a2, a3) oraz zbiory wartości tych atrybutów:\n" +
                "a1 = (czarny, niebieski, brązowy, zielony),\n" +
                "a2 = (niski, średni, wysoki)\n" +
                "a3 = (156, 160, 190, 120)", ds);
        Question question9 = new Question("Proszę wskazać jakie parametry z wymienionych poniżej należy podać dla\n" +
                "algorytmu grupowania DBSCAN:", ds);
        Question question10 = new Question(". Dana jest tablica decyzyjna zawierająca 40 obiektów, w której wyróżniono dwie\n" +
                "klasy decyzyjne. Liczność pierwszej z nich wynosi 20 obiektów, a liczność drugiej z\n" +
                "nich wynosi 20 obiektów. Ile wynosi entropia całego zbioru ?\n", ds);
        Question question11 = new Question("Która z poniższych metod wizualizacji pozwala na wyróżnienie społeczności w\n" +
                "sieci społecznej ?", ds);
        Question question12 = new Question("Zdania prawdziwe odnośnie dwumodalnej sieci:", ds);
        Question question13 = new Question("Dwie tablice decyzyjne T1 z decyzjami 40%/60% i T2 z decyzjami 10%/90%", ds);
        Question question14 = new Question("Co to jest degree ?", ds);
        Question question15 = new Question("Zdania dotyczące strumieniowej analizy danych", ds);
        Question question16 = new Question("Metoda wizualizacji sieci społecznych o nazwie Fruchterman-Reingold:", ds);
        Question question17 = new Question("8.Dane są wektory:\n" +
                "A = [1 3 4 5 7]\n" +
                "B = [0.2 0.1 0.05 0.02 0.01]\n" +
                "C = [10 5 18 12 20]", ds);
        Question question19 = new Question("Wartość miary entropii dla rzutu monetą wynosi?", ds);
        Question question20 = new Question("Algorytm identyfikacji społeczności w sieci społecznej zaproponowany przez Givan-Newman ( algorytm hierarchiczny dzielący)", ds);
        Question question21 = new Question("Pytanie o betweenness", ds);
        Question question22 = new Question("Dobór preferencyjna w sieciach społecznych polega na tym, że:", ds);
        Question question23 = new Question("Zaznacz poprawne odpowiedzi dotyczące różnych metod testowania jakości klasyfikatorów", ds);
        Question question24 = new Question("Dany jest system informacyjny SU=(U,A). Zaznacz poprawne odpowiedzi:", ds);
        Question question25 = new Question("Przetwarzanie strumieni danych charakteryzuje:", ds);
        Question question26 = new Question("Centralność closeness węzła sieci społecznej:", ds);
        Question question27 = new Question("podejście typu prequential do oceny jakości modelu wyznaczonego dla danych strumieniowych polega m.in. na:", ds);
        Question question28 = new Question("Dany jest zbiór wartości pewnego atrybutu a. Wartość minimalna w tym zbiorze wynosi 300, a maksymalna 2700. Jaki będzie wynik normalizacji min-max do zakresu 0-1 dla konkretnej wartości tego atrybutu równej 900.", ds);
        Question question29 = new Question("Proszę wskazać jakie parametry z wymienionych poniżej należy podać dla algorytmu grupowania k-średnich", ds);
        Question question30 = new Question("Proszę wskazać co jest efektem działania algorytmu grupowania hierarchicznego scalającego", ds);
        Question question31 = new Question("Liczbę sąsiadów węzła w sieci społecznej (węzłów, z którymi dany węzeł jest powiązany) określa:", ds);
        Question question32 = new Question("Społeczność w sieci społecznej to:", ds);
        Question question33 = new Question("Regresja liniowa y=ax+b to przykład regresji:", ds);
        Question question34 = new Question("Warunkiem koniecznym funkcji jądra jest:", ds);
        Question question35 = new Question("Zbiór danych składa się z 4 obiektów {o , , , } opisanych atrybutem a i 1 o2 o3 o4\n" +
                "przypisanych do jednej z dwóch klas decyzyjnych (atrybut class). Entropia\n" +
                "warunkowa (ważona) tego zbioru przykładów ze względu na podział zakresu wartości\n" +
                "atrybutu a za pomocą wartości progowej równej 2.5:", ds);
        Question question36 = new Question("Metoda dyskretyzacji według równej częstości:", ds);

        Answer a0 = new Answer("parametr definiujący maksymalną liczbę iteracji wykonania algorytmu", true, question0);
        Answer a1 = new Answer("parametr definiujący liczbę grup", true, question0);

        Answer a2 = new Answer("rozkład stopni węzłów sieci społecznej jest rozkładem potęgowym", true, question1);
        Answer a3 = new Answer("w sieciach społecznych występuje zjawisko małego świata (ang. small world phenomenon)", true, question1);

        Answer a4 = new Answer("centralność degree", true, question2);
        Answer a5 = new Answer("betweenes)", false, question2);
        Answer a6 = new Answer("closens", false, question2);

        Answer a7 = new Answer("reguła wspiera 2 obiekty\n", true, question3);
        Answer a8 = new Answer("reguła rozpoznaje 3 obiekty)", true, question3);

        Answer a9 = new Answer("DBSCAN", true, question4);

        Answer a10 = new Answer("dokładność klasyfikacji obliczamy za pomocą wzoru (TP)/(TP+FP)", false, question5);
        Answer a11 = new Answer("dokładność klasyfikacji obliczamy za pomocą wzoru: (TP+TN)/(TP+TN+FP+FN)", true, question5);
        Answer a12 = new Answer("czułość obliczamy za pomocą wzoru: (TP)/(TP+FN)", true, question5);
        Answer a13 = new Answer("czułość obliczamy za pomocą wzoru: (FP)/(FP+TP)", false, question5);

        Answer a14 = new Answer("analiza brakujących wartości\n", true, question6);
        Answer a15 = new Answer("kubełkowanie", false, question6);

        Answer a16 = new Answer("ID3 - information gain", true, question7);
        Answer a17 = new Answer("C4.5 - gain ratio", true, question7);

        Answer a18 = new Answer("atrybut a1 jest atrybutem nominalnym", true, question8);
        Answer a19 = new Answer("atrybut a2 jest atrybutem porządkowym", true, question8);
        Answer a20 = new Answer("atrybut a3 jest atrybutem ilościowym", true, question8);

        Answer a21 = new Answer("Parametr definiujący promień analizowanego sąsiedztwa każdego obiektu danych\n", true, question9);
        Answer a22 = new Answer("parametr definiujący liczbę sąsiadów stanowiących o gęstości analizowanego\n" +
                "sąsiedztwa", true, question9);

        Answer a23 = new Answer("1", true, question10);
        Answer a24 = new Answer("2", false, question10);
        Answer a25 = new Answer("0.242", false, question10);

        Answer a26 = new Answer("spring-embedder", true, question11);
        Answer a27 = new Answer("multidimensional scaling", true, question11);

        Answer a28 = new Answer("ma dwa rodzaje węzłów", true, question12);
        Answer a29 = new Answer("węzły jednego rodzaju nie są ze sobą połączone", true, question12);
        Answer a30 = new Answer("posiada tylko połączenia pomiędzy węzłami różnego rodzaju", true, question12);

        Answer a31 = new Answer("entropia T1 jest większa od T2", true, question13);
        Answer a32 = new Answer("entropia T1 jest zbliżona do 1", true, question13);
        Answer a33 = new Answer("entropia T1 jest zbliżona do 0", false, question13);

        Answer a34 = new Answer("Określa liczbę powiązań danego węzła", true, question14);
        Answer a35 = new Answer("Miara lokalna węzła", true, question14);

        Answer a36 = new Answer("ograniczony czas na analizę\n", true, question15);
        Answer a37 = new Answer("ograniczona pojemność bufora danych", true, question15);
        Answer a38 = new Answer("dane nadchodzą szybko", true, question15);
        Answer a39 = new Answer("danych się nie przechowuje, tylko ich agregacje", true, question15);
        Answer a40 = new Answer("coś z ograniczonym dostępem, brak możliwości przeglądania starych danych\n", true, question15);

        Answer a41 = new Answer("ułatwia analizę społeczności", true, question16);
        Answer a42 = new Answer("wykorzystuje fizyczny model oddziaływań (sprężyny-powiązania i ładunki-węzły) w\n" +
                "celu przedstawienia sieci\n", true, question16);
        Answer a43 = new Answer("układa węzły hierarchicznie zgodnie z wartościami wybranej centralności", true, question16);
        Answer a44 = new Answer("układa węzły na okręgu, wewnątrz którego narysowane są powiązania", true, question16);

        Answer a45 = new Answer("Wektory A i B są skorelowane ujemnie", true, question17);
        Answer a46 = new Answer("Współczynnik korelacji pozwala na obliczenie odległości pomiędzy dwoma wektorami ??? chuj wi???", false, question17);
        Answer a47 = new Answer("Wektory A i C są ze sobą skorelowane ujemnie", false, question17);
        Answer a48 = new Answer("Wektory A i B są ze sobą skorelowane dodatnio", false, question17);

        Answer a57 = new Answer("∫ K(x)dx\n" +
                "R\n" +
                "= 1", true, question34);
        Answer a58 = new Answer("∀ K(x) (− )", true, question34);
        Answer a59 = new Answer("K(0) = 1", false, question34);

        Answer a49 = new Answer("przyjmuje wartość ujemną\n", false, question35);
        Answer a50 = new Answer("przyjmuje wartość równą 0,5", false, question35);
        Answer a51 = new Answer("jest liczbą z przedziału obustronnie domkniętego [0;1]", true, question35);
        Answer a52 = new Answer(" jest taka sama jak dla wartości progowej równej 2,75", true, question35);

        Answer a53 = new Answer("wymaga znajomości klas decyzyjnych przykładów", false, question36);
        Answer a54 = new Answer("zamienia wartości atrybutu numerycznego na wartości binarne", false, question36);
        Answer a55 = new Answer("wymaga podania parametru określającego liczbę wynikowych przedziałów", true, question36);
        Answer a56 = new Answer("jest bardziej oporna na wartości odstające niż metoda dyskretyzacji według równej\n" +
                "szerokości przedziałów", true, question36);
        Answer bq19 = new Answer("0.5", false, question19);
        Answer bq191 = new Answer("0", false, question19);
        Answer bq192 = new Answer("-0.5", false, question19);
        Answer bq193 = new Answer("1", true, question19);

        Answer bq20 = new Answer("ma złożoność zbyt dużą do analizy dużych sieci (np. 1000000 węzłów)", true, question20);
        Answer bq201 = new Answer("bazuje na centralności betweeness dla krawędzi", true, question20);
        Answer bq202 = new Answer("bazuje na centralności betweeness dla węzłów", false, question20);
        Answer bq203 = new Answer("w kolejnych iteracjach dzieli sieć na społeczności usuwając kolejne krawędzie", true, question20);

        Answer bq21 = new Answer("określa liczbę najkrótszych ścieżek przechodzących przez dany węzeł", true, question21);
        Answer bq211 = new Answer("jest wysoka dla węzła łączącego dwie społeczności", true, question21);
        Answer bq212 = new Answer("Wskazuje które węzły są najważniejsze", true, question21);
        Answer bq213 = new Answer("Węzły u dużym pośrednictwie mogą być punktami podtrzymania spójności sieci", false, question21);

        Answer bq22 = new Answer("bardziej prawdopodobne jest połączenie się nowego węzła w sieci z węzłami mającymi względnie dużo powiązań", true, question22);
        Answer bq221 = new Answer("bardziej prawdopodobne jest połączenie się nowego węzłą w sieci z węzłami mającmi względnie mało powiązań", false, question22);
        Answer bq222 = new Answer("prawdopodobieństwa połączenia się nowego węzła z każdym z pozostałych węzłów jest jednakowe", false, question22);

        Answer bq23 = new Answer("W przypadku jeśli zbiór danych jest nieliczny, dobrą taktyką jest wykorzystanie całego zbioru danych zarówno na etapie uczenia klasyfikatora jak i testowania jego jakości gdyż dzięki temu klasyfikator dostanie więcej informacji o obiektach na etapie uczenia", true, question23);
        Answer bq231 = new Answer("10-krotna stratyfikowana walidacja krzyżowa to metoda oceny jakości klasyfikatora, która dzieli zbiór danych w taki sposób, że losowo 70% obiektów stanowi zbiór treningowy a 30% zbiór testowy, Procedura ta powtarzana jest 10 razy, a jakość klasyfikatora jest średnią z jakości klasyfikacji 10-ciu powtórzeń", false, question23);
        Answer bq232 = new Answer("W przypadku jeśli zbiór danych jest nieliczny, lepiej będzie zastosować metodą leave-one-out niż 10-krotną walidację krzyżową", true, question23);

        Answer bq24 = new Answer("chuj wie", false, question24);

        Answer bq25 = new Answer("wyznaczanie podziału danych na treningowe i testowe", true, question23);
        Answer bq251 = new Answer("szybki napływ danych", true, question25);
        Answer bq252 = new Answer("przechowywanie jedynie zagregowanych charakterystyk zamiast danych", true, question25);
        Answer bq253 = new Answer("stosowanie liniowych lub sub-liniowych metod analizy", true, question25);

        Answer bq26 = new Answer("jest największa dla węzłów mających jedno powiązanie", false, question26);
        Answer bq261 = new Answer("zależy od liczby najkrótszych ścieżek w sieci wychodzących z danego węzła", false, question26);
        Answer bq262 = new Answer("zależy od długości najkrótszych ścieżek w sieci wychodzących z danego węzła", true, question26);
        Answer bq263 = new Answer("zależy od liczby powiązań węzła", true, question26);

        Answer bq27 = new Answer("jtestowaniu modelu na specjalnie wydzielonych danych testowych", false, question27);
        Answer bq271 = new Answer("testowaniu modelu na nadchodzących danych, które w kolejnym kroku posłużą do uczenia tego modelu", true, question27);
        Answer bq272 = new Answer("wyznaczaniu błędu modelu jako skumulowanej sumy wartości funkcji straty, której wartość wyznaczana jest dla kolejnych przykładów", true, question27);


        Answer bq28 = new Answer("0.75", false, question28);
        Answer bq281 = new Answer("0.25", true, question28);
        Answer bq282 = new Answer("0.6", false, question28);
        Answer bq283 = new Answer("0.6", false, question28);

        Answer bq29 = new Answer("parametr definiujący promień analizowanego sąsiedztwa każdego obiektu danych", false, question29);
        Answer bq291 = new Answer("parametr definiujący liczbę iteracji", true, question29);
        Answer bq292 = new Answer("parametr definiujący liczbę grup", true, question29);
        Answer bq293 = new Answer("parametr definiujący liczbę sąsiadów stanowiących o gęstości analizowanego sąsiedztwa", false, question29);

        Answer bq30 = new Answer("dendrogram", true, question30);
        Answer bq301 = new Answer("rozmyta macierz podziału", false, question30);
        Answer bq302 = new Answer("ostra macierz podziału", false, question30);

        Answer bq31 = new Answer("stopień węzła", true, question31);
        Answer bq311 = new Answer("centralność closeness", false, question31);
        Answer bq312 = new Answer("współczynnik grupowania", false, question31);

        Answer bq32 = new Answer("grupa węzłów o podobnym stopniu", false, question32);
        Answer bq321 = new Answer("grupa węzłów o podobnej wartości współczynnika grupowania", false, question32);
        Answer bq322 = new Answer("grupa węzłów o większej liczbie powiązań między sobą niż z resztą sieci", true, question32);

        Answer bq33 = new Answer("półparametrycznej", false, question33);
        Answer bq331 = new Answer("nieparametrycznej", false, question33);
        Answer bq332 = new Answer("parametrycznej", true, question33);


        categoriesRepo.save(DS);
        quizesRepo.save(ds);

        questionsRepo.save(question0);
        questionsRepo.save(question1);
        questionsRepo.save(question2);
        questionsRepo.save(question3);
        questionsRepo.save(question4);
        questionsRepo.save(question5);
        questionsRepo.save(question6);
        questionsRepo.save(question7);
        questionsRepo.save(question8);
        questionsRepo.save(question9);
        questionsRepo.save(question10);
        questionsRepo.save(question11);
        questionsRepo.save(question12);
        questionsRepo.save(question13);
        questionsRepo.save(question14);
        questionsRepo.save(question15);
        questionsRepo.save(question16);
        questionsRepo.save(question17);
        questionsRepo.save(question19);
        questionsRepo.save(question20);
        questionsRepo.save(question21);
        questionsRepo.save(question22);
        questionsRepo.save(question23);
        questionsRepo.save(question24);
        questionsRepo.save(question25);
        questionsRepo.save(question26);
        questionsRepo.save(question27);
        questionsRepo.save(question28);
        questionsRepo.save(question29);
        questionsRepo.save(question30);
        questionsRepo.save(question31);
        questionsRepo.save(question32);
        questionsRepo.save(question33);
        questionsRepo.save(question34);
        questionsRepo.save(question35);
        questionsRepo.save(question36);

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
        anwersRepo.save(a35);
        anwersRepo.save(a36);
        anwersRepo.save(a37);
        anwersRepo.save(a38);
        anwersRepo.save(a39);
        anwersRepo.save(a40);
        anwersRepo.save(a41);
        anwersRepo.save(a42);
        anwersRepo.save(a43);
        anwersRepo.save(a44);
        anwersRepo.save(a45);
        anwersRepo.save(a46);
        anwersRepo.save(a47);
        anwersRepo.save(a48);
        anwersRepo.save(a49);
        anwersRepo.save(a50);
        anwersRepo.save(a51);
        anwersRepo.save(a52);
        anwersRepo.save(a53);
        anwersRepo.save(a54);
        anwersRepo.save(a55);
        anwersRepo.save(a56);
        anwersRepo.save(a57);
        anwersRepo.save(a58);
        anwersRepo.save(a59);
        anwersRepo.save(bq19);
        anwersRepo.save(bq191);
        anwersRepo.save(bq192);
        anwersRepo.save(bq193);
        anwersRepo.save(bq20);
        anwersRepo.save(bq201);
        anwersRepo.save(bq202);
        anwersRepo.save(bq203);
        anwersRepo.save(bq21);
        anwersRepo.save(bq211);
        anwersRepo.save(bq212);
        anwersRepo.save(bq213);
        anwersRepo.save(bq22);
        anwersRepo.save(bq221);
        anwersRepo.save(bq222);
        anwersRepo.save(bq23);
        anwersRepo.save(bq231);
        anwersRepo.save(bq232);
        anwersRepo.save(bq24);
        anwersRepo.save(bq25);
        anwersRepo.save(bq251);
        anwersRepo.save(bq252);
        anwersRepo.save(bq253);
        anwersRepo.save(bq26);
        anwersRepo.save(bq261);
        anwersRepo.save(bq262);
        anwersRepo.save(bq263);
        anwersRepo.save(bq27);
        anwersRepo.save(bq271);
        anwersRepo.save(bq272);
        anwersRepo.save(bq28);
        anwersRepo.save(bq281);
        anwersRepo.save(bq282);
        anwersRepo.save(bq283);
        anwersRepo.save(bq29);
        anwersRepo.save(bq291);
        anwersRepo.save(bq292);
        anwersRepo.save(bq293);
        anwersRepo.save(bq30);
        anwersRepo.save(bq301);
        anwersRepo.save(bq302);
        anwersRepo.save(bq31);
        anwersRepo.save(bq311);
        anwersRepo.save(bq312);
        anwersRepo.save(bq32);
        anwersRepo.save(bq321);
        anwersRepo.save(bq322);
        anwersRepo.save(bq33);
        anwersRepo.save(bq331);
        anwersRepo.save(bq332);
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

            Question question0 = new Question("Proszę wskazać jakie parametry z wymienionych poniżej należy podać dla algorytmu grupowania k-średnich:", quiz);
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

            createDSQuiz(categoriesRepo, scoresRepo, quizesRepo, questionsRepo, anwersRepo);
        };
    }
}
