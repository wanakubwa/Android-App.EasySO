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
//                "przypisanych do jednej z dwóch klas decyzyjnych (atrybut class). Entropia\n" +
//                "warunkowa (ważona) tego zbioru przykładów ze względu na podział zakresu wartości\n" +
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

        Answer a57 = new Answer("calka K(x)dx = 1", true, question34);
        Answer a58 = new Answer("dla kazdego K(x) (-)", true, question34);
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

    private void createMCQuiz(Category category,CategoriesRepository categoriesRepo, ScoresRepository scoresRepo, QuizesRepository quizesRepo, QuestionsRepository questionsRepo, AnswersRepository anwersRepo) {

        Category MC = category;
        Quiz mc = new Quiz("MC", MC);

        //categoriesRepo.save(MC);
        quizesRepo.save(mc);

        /* Pytania 2 - 12 */

        Question mcQuestion0 = new Question("Oceń poprawność następujących stwierdzeń dla modelu M/M/1 zbudowanego z wykorzystaniem środowiska OMNeT++", mc);
        Answer mcQuestion0Answear0 = new Answer("Dla zbudowania poprawnego modelu wystarczające jest posłużenie się w obrębie całego modelu dwoma typami komunikatów sterujących, sygnalizującymi wystąpienie zdarzeń „wygenerowanie kolejnego zgłoszenia” i „zakończenie obsługi”", true, mcQuestion0);
        Answer mcQuestion0Answear1 = new Answer("Warunkiem rozpoczęcia obsługi danego zgłoszenia jest nadejście komunikatu informującego o przybyciu kolejnego zgłoszenia", false, mcQuestion0);
        Answer mcQuestion0Answear2 = new Answer("Warunkiem zakończenia obsługi danego zgłoszenia jest niepusta kolejka przed tym stanowiskiem", false, mcQuestion0);
        Answer mcQuestion0Answear3 = new Answer("Pusta kolejka przed stanowiskiem obsługi jest warunkiem wystarczającym wejścia zgłoszenia na to stanowisko", false, mcQuestion0);
        questionsRepo.save(mcQuestion0);
        anwersRepo.save(mcQuestion0Answear0);
        anwersRepo.save(mcQuestion0Answear1);
        anwersRepo.save(mcQuestion0Answear2);
        anwersRepo.save(mcQuestion0Answear3);

        Question mcQuestion1 = new Question("Oceń poprawność następujących stwierdzeń dotyczących modelu utworzonego w pakiecie OMNeT++", mc);
        Answer mcQuestion1Answear0 = new Answer("Sposób wyznaczania wartości parametrów poszczególnych modułów zapisany jest w pliku konfiguracyjnym ”omnetpp.ini”", true, mcQuestion1);
        Answer mcQuestion1Answear1 = new Answer("W kontekście określenia czasu przyszłego zdarzenia struktura FES pełni funkcję analogiczną do planu zdarzeń w pakiecie NewGASP\n", false, mcQuestion1);
        Answer mcQuestion1Answear2 = new Answer("Wywołanie metody par() o postaci par(“x”) zwraca aktualną wartość parametru o nazwie “x” modułu, w którym wywołano tę metodę", true, mcQuestion1);
        Answer mcQuestion1Answear3 = new Answer("Definicje połączeń między modułami zapisane są w pliku konfiguracyjnym omnetpp.ini", false, mcQuestion1);
        questionsRepo.save(mcQuestion1);
        anwersRepo.save(mcQuestion1Answear0);
        anwersRepo.save(mcQuestion1Answear1);
        anwersRepo.save(mcQuestion1Answear2);
        anwersRepo.save(mcQuestion1Answear3);

        Question mcQuestion2 = new Question("Oceń poprawność następujących stwierdzeń dla modelu systemu M/M/1 zbudowanego z wykorzystaniem środowiska OMNeT++", mc);
        Answer mcQuestion2Answear0 = new Answer("W celu zebrania danych dla przygotowania wykresu zmian aktualnej liczby zgłoszeń przebywających w systemie należy zastosować klasę cOutVector", true, mcQuestion2);
        Answer mcQuestion2Answear1 = new Answer("Warunkiem zakończenia obsługi danego zgłoszenia jest obecność w kolejce co najmniej jednego zgłoszenia czekającego na obsługę", false, mcQuestion2);
        Answer mcQuestion2Answear2 = new Answer("Dla wejścia zgłoszenia na stanowisko obsługi pusta kolejka przed stanowiskiem jest warunkiem koniecznym, ale niewystarczającym", false, mcQuestion2);
        Answer mcQuestion2Answear3 = new Answer("Dla zbudowania poprawnego modelu wystarczające jest posłużenie się w obrębie całego modelu jednym typem komunikatu sterującego – sygnalizującym wystąpienie zdarzenia „wygenerowanie kolejnego zgłoszenia”", false, mcQuestion2);
        questionsRepo.save(mcQuestion2);
        anwersRepo.save(mcQuestion2Answear0);
        anwersRepo.save(mcQuestion2Answear1);
        anwersRepo.save(mcQuestion2Answear2);
        anwersRepo.save(mcQuestion2Answear3);

        Question mcQuestion3 = new Question("Oceń poprawność następujących stwierdzeń dotyczących mechanizmów pakietu OMNeT++:", mc);
        Answer mcQuestion3Answear0 = new Answer("W dowolnej chwili czasu symulacyjnego wywołanie o postaci scheduleAt(simTime(), msg) powoduje natychmiastowe nadejście komunikatu sterującego", true, mcQuestion3);
        Answer mcQuestion3Answear1 = new Answer("Metoda par() zwraca aktualną wartość parametru modułu podanego jako argument metody", false, mcQuestion3);
        Answer mcQuestion3Answear2 = new Answer("Metoda send umieszcza komunikat sterujący w liście przyszłych zdarzeń (FES)", false, mcQuestion3);
        Answer mcQuestion3Answear3 = new Answer("Definicje połączeń między modułami zapisane są w pliku konfiguracyjnym omnetpp.ini", false, mcQuestion3);
        questionsRepo.save(mcQuestion3);
        anwersRepo.save(mcQuestion3Answear0);
        anwersRepo.save(mcQuestion3Answear1);
        anwersRepo.save(mcQuestion3Answear2);
        anwersRepo.save(mcQuestion3Answear3);


        Question mcQuestion5Missed = new Question("TODO  W modelu systemu M/M/1 zbudowanym z użyciem pakietu NewGASP za pomocą statystyki Timst można wyznaczyć:", mc);
        Answer mcQuestion5Answear0Missed = new Answer("Średni czas pobytu zgłoszenia w kolejce", true, mcQuestion5Missed);
        Answer mcQuestion5Answear1Missed = new Answer("Średnią długość kolejki", false, mcQuestion5Missed);
        Answer mcQuestion5Answear2Missed = new Answer("Średnią liczbę zgłoszeń przebywających w systemie", false, mcQuestion5Missed);
        Answer mcQuestion5Answear3Missed = new Answer("Średnie wykorzystanie (zajętość) stanowiska obsługi", true, mcQuestion5Missed);
        questionsRepo.save(mcQuestion5Missed);
        anwersRepo.save(mcQuestion5Answear0Missed);
        anwersRepo.save(mcQuestion5Answear1Missed);
        anwersRepo.save(mcQuestion5Answear2Missed);
        anwersRepo.save(mcQuestion5Answear3Missed);

        Question mcQuestion5 = new Question("W pakiecie SimEvents do budowy modelu wykorzystywane są:", mc);
        Answer mcQuestion5Answear0 = new Answer("Koncepcje wyboru działania”", false, mcQuestion5);
        Answer mcQuestion5Answear1 = new Answer("Ciągłe równania stanu", false, mcQuestion5);
        Answer mcQuestion5Answear2 = new Answer("Dyskretne równania stanu", false, mcQuestion5);
        Answer mcQuestion5Answear3 = new Answer("Koncepcja planowania zdarzeń", false, mcQuestion5);
                Answer mcQuestion5Answear4 = new Answer("koncepcja interakcji procesów", true, mcQuestion5);
        questionsRepo.save(mcQuestion5);
        anwersRepo.save(mcQuestion5Answear0);
        anwersRepo.save(mcQuestion5Answear1);
        anwersRepo.save(mcQuestion5Answear2);
        anwersRepo.save(mcQuestion5Answear3);
                anwersRepo.save(mcQuestion5Answear4);

        Question mcQuestion6 = new Question("Oceń, które z poniższych zdarzeń mogą wystąpić w zamkniętej sieci stanowisk obsługi typu M/M/1", mc);
        Answer mcQuestion6Answear0 = new Answer("Zakończenie obsługi zgłoszenia", true, mcQuestion6);
        Answer mcQuestion6Answear1 = new Answer("Rozpoczęcie obsługi zgłoszenia", true, mcQuestion6);
        Answer mcQuestion6Answear2 = new Answer("Opuszczenie z sieci przez zgłoszenie", false, mcQuestion6);
        Answer mcQuestion6Answear3 = new Answer("Przybycie nowego zgłoszenia do sieci", false, mcQuestion6);
        questionsRepo.save(mcQuestion6);
        anwersRepo.save(mcQuestion6Answear0);
        anwersRepo.save(mcQuestion6Answear1);
        anwersRepo.save(mcQuestion6Answear2);
        anwersRepo.save(mcQuestion6Answear3);

        Question mcQuestion7 = new Question("Ocen, które z poniższych zdarzeń mogą wystąpić w otwartej sieci stanowisk obsługi typu M/M/1", mc);
        Answer mcQuestion7Answear0 = new Answer("Rozpoczęcie obsługi zgłoszenia", true, mcQuestion7);
        Answer mcQuestion7Answear1 = new Answer("Przybycie nowego zgłoszenia do sieci", true, mcQuestion7);
        Answer mcQuestion7Answear2 = new Answer("Opuszczenie sieci przez zgłoszenie", true, mcQuestion7);
        Answer mcQuestion7Answear3 = new Answer("Zakończenie obsługi zgłoszenia", true, mcQuestion7);
        questionsRepo.save(mcQuestion7);
        anwersRepo.save(mcQuestion7Answear0);
        anwersRepo.save(mcQuestion7Answear1);
        anwersRepo.save(mcQuestion7Answear2);
        anwersRepo.save(mcQuestion7Answear3);

        Question mcQuestion8 = new Question("W pakiecie SimEvents bloki kolejek udostępniają statystyki prezentujące", mc);
        Answer mcQuestion8Answear0 = new Answer("Średnią liczbę obiektów w kolejce", true, mcQuestion8);
        Answer mcQuestion8Answear1 = new Answer("Maksymalną liczbę obiektów w kolejce", false, mcQuestion8);
        Answer mcQuestion8Answear2 = new Answer("Histogram czasu pobytu obiektu w kolejce", false, mcQuestion8);
        Answer mcQuestion8Answear3 = new Answer("Liczbę obiektów, które nie mogły wejść do bloku kolejki", false, mcQuestion8);
        questionsRepo.save(mcQuestion8);
        anwersRepo.save(mcQuestion8Answear0);
        anwersRepo.save(mcQuestion8Answear1);
        anwersRepo.save(mcQuestion8Answear2);
        anwersRepo.save(mcQuestion8Answear3);

        Question mcQuestion9 = new Question(" W pakiecie SimEvents bloki kolejek udostępniają statystyki prezentujące:", mc);
        Answer mcQuestion9Answear0 = new Answer("Aktualną liczbę obiektów w kolejce", true, mcQuestion9);
        Answer mcQuestion9Answear1 = new Answer("Średnią liczbę obiektów w kolejce", true, mcQuestion9);
        Answer mcQuestion9Answear2 = new Answer("Histogram czasu pobytu obiektu w kolejce", false, mcQuestion9);
        Answer mcQuestion9Answear3 = new Answer("Liczbę obiektów, które nie mogły wejść do bloku kolejki", false, mcQuestion9);
        questionsRepo.save(mcQuestion9);
        anwersRepo.save(mcQuestion9Answear0);
        anwersRepo.save(mcQuestion9Answear1);
        anwersRepo.save(mcQuestion9Answear2);
        anwersRepo.save(mcQuestion9Answear3);

        Question mcQuestion10 = new Question("Oceń poprawność następujących stwierdzeń dotyczących schematów różnicowych", mc);
        Answer mcQuestion10Answear0 = new Answer("Schemat Eulera jest przykładem schematu jednokrokowego", true, mcQuestion10);
        Answer mcQuestion10Answear1 = new Answer("W metodzie predyktor-korektor celem etapu predykcji jest znalezienie początkowego przybliżenia punktu Vj+1", true, mcQuestion10);
        Answer mcQuestion10Answear2 = new Answer("Schemat różnicowy wielokrokowy ma postać Vj+1 = F(Vj,Tj)", false, mcQuestion10);
        Answer mcQuestion10Answear3 = new Answer("Schemat różnicowy o postaci Vj+1= F(Vj+1, Vj, ...., Vj-p, Tj) jest schematem niejawnym", false, mcQuestion10);
        questionsRepo.save(mcQuestion10);
        anwersRepo.save(mcQuestion10Answear0);
        anwersRepo.save(mcQuestion10Answear1);
        anwersRepo.save(mcQuestion10Answear2);
        anwersRepo.save(mcQuestion10Answear3);

        /* Pytania 14 - 24 */

        Question mcQuestion11 = new Question("Oceń poprawność następujących stwierdzeń dotyczących schematów różnicowych", mc);
        Answer mcQuestion11Answear0 = new Answer("Schematy jednokrokowe dzielą się na schematy jawne i niejawne", false, mcQuestion11);
        Answer mcQuestion11Answear1 = new Answer("Funkcja f występująca we wzorach schematów różnicowych jest prawą stroną równania stanu", true, mcQuestion11);
        Answer mcQuestion11Answear2 = new Answer("Schemat różnicowy o postaci  Vj+1 = F(Vj,Vj-1,...,Vj-p,tj) jest schematem niejawnym", true, mcQuestion11);
        Answer mcQuestion11Answear3 = new Answer("Schemat różnicowy jednokrokowy ma postać  Vj+1=F(Vj,Tj)", true, mcQuestion11);
        questionsRepo.save(mcQuestion11);
        anwersRepo.save(mcQuestion11Answear0);
        anwersRepo.save(mcQuestion11Answear1);
        anwersRepo.save(mcQuestion11Answear2);
        anwersRepo.save(mcQuestion11Answear3);

        Question mcQuestion12 = new Question("Zmienne stanu w modelu przepływu cieczy opisującym sieć AQM, to:", mc);
        Answer mcQuestion12Answear0 = new Answer("Intensywność pakietów przychodzących i wychodzących", false, mcQuestion12);
        Answer mcQuestion12Answear1 = new Answer("Rozmiar okna w ruterze nadawcy i średnia zajętość bufora w ruterze odbiorcy", false, mcQuestion12);
        Answer mcQuestion12Answear2 = new Answer("Liczba aktywnych sesji TCP i średnia zajętość bufora w ruterze nadawcy", false, mcQuestion12);
        Answer mcQuestion12Answear3 = new Answer("Czas obiegu i prawdopodobieństwo wysłania negatywnego potwierdzenia", true, mcQuestion12);
        questionsRepo.save(mcQuestion12);
        anwersRepo.save(mcQuestion12Answear0);
        anwersRepo.save(mcQuestion12Answear1);
        anwersRepo.save(mcQuestion12Answear2);
        anwersRepo.save(mcQuestion12Answear3);

        Question mcQuestion13 = new Question("Zmienne stanu w modelu przepływu cieczy opisującym sieć AQM, to:", mc);
        Answer mcQuestion13Answear0 = new Answer("Średni rozmiar okna w routerze nadawcy i średnia zajętość bufora w routerze odbiorcy", true, mcQuestion13);
        Answer mcQuestion13Answear1 = new Answer("Czas obiegu i prawdopodobieństwo wysłania negatywnego potwierdzenia", true, mcQuestion13);
        Answer mcQuestion13Answear2 = new Answer("Średni rozmiar okna w routerze odbiorcy i średnia zajętość bufora w routerze nadawcy", false, mcQuestion13);
        Answer mcQuestion13Answear3 = new Answer("Liczba aktywnych sesji TCP i opóźnienie propagacji wysłania negatywnego potwierdzenia", true, mcQuestion13);
        questionsRepo.save(mcQuestion13);
        anwersRepo.save(mcQuestion13Answear0);
        anwersRepo.save(mcQuestion13Answear1);
        anwersRepo.save(mcQuestion13Answear2);
        anwersRepo.save(mcQuestion13Answear3);

        Question mcQuestion14 = new Question("Oceń poprawność następujących stwierdzeń dotyczących zagadnień związanych z obliczaniem wartości początkowych zmiennych stanu i zmiennych wyjścia", mc);
        Answer mcQuestion14Answear0 = new Answer("Przy zastosowaniu metody szeregowej wartości początkowe kolejnych zmiennych stanu są równe warunkom\n" +
                "początkowym dla zmiennej wyjścia i jej kolejnych pochodnych\n", false, mcQuestion14);
        Answer mcQuestion14Answear1 = new Answer("Gdy zmienna wejściowa w chwili t = 0 nie jest impulsem Diraca, to pomiędzy wartościami zmiennych stanu\n" +
                "zachodzi następująca relacja: x(0+) ≠ x(0-)" +
                "−)", false, mcQuestion14);
        Answer mcQuestion14Answear2 = new Answer("Przy zastosowaniu metody równoległej wartości początkowe kolejnych zmiennych stanu są równe warunkom\n" +
                "początkowym dla zmiennej wyjścia i jej kolejnych pochodnych", false, mcQuestion14);
        Answer mcQuestion14Answear3 = new Answer("Przy zastosowaniu metody ogólnej wartości początkowe kolejnych zmiennych stanu są równe warunkom\n" +
                "początkowym dla zmiennej wyjścia i jej kolejnych pochodnych", true, mcQuestion14);
        Answer mcQuestion14Answear4 = new Answer("gdy zmienna wejściowa nie zawiera impulsów Diracle’a, to granice lewo- i prawostronna warunku początkowego zmiennej stanu są sobie równe", true, mcQuestion14);
        Answer mcQuestion14Answear5 = new Answer("w metodzie kolejnych całkowań występuje jawna zależność zmiennej stanu od zmiennych: wejściowej i wyjściowej i ich pochodnych", false, mcQuestion14);
        questionsRepo.save(mcQuestion14);
        anwersRepo.save(mcQuestion14Answear0);
        anwersRepo.save(mcQuestion14Answear1);
        anwersRepo.save(mcQuestion14Answear2);
        anwersRepo.save(mcQuestion14Answear3);
        anwersRepo.save(mcQuestion14Answear4);
        anwersRepo.save(mcQuestion14Answear5);

        Question mcQuestion15 = new Question("Oceń poprawność następujących stwierdzeń dotyczących zagadnień związanych z obliczaniem\n" +
                "wartości początkowych zmiennych stanu i zmiennych wyjścia", mc);
        Answer mcQuestion15Answear0 = new Answer("Gdy zmienna wejściowa w chwili t = 0 nie jest impulsem Diraca, to pomiędzy wartościami zmiennych stanu zachodzi następująca relacja: x(0+) ≠ x(0-)", false, mcQuestion15);
        Answer mcQuestion15Answear1 = new Answer("W metodzie predyktor-korektor celem etapu predykcji jest znalezienie początkowego przybliżenia punktu Vj+1", true, mcQuestion15);
        Answer mcQuestion15Answear2 = new Answer("Przy zastosowaniu metody szeregowej wartości początkowe kolejnych zmiennych stanu są równe warunkom początkowym dla zmiennej wyjścia i jej kolejnych pochodnych\n", false, mcQuestion15);
        Answer mcQuestion15Answear3 = new Answer("Przy zastosowaniu metody ogólnej wartości początkowe kolejnych zmiennych stanu są równe warunkom\n" +
                "początkowym dla zmiennej wyjścia i jej kolejnych pochodnych", true, mcQuestion15);
        questionsRepo.save(mcQuestion15);
        anwersRepo.save(mcQuestion15Answear0);
        anwersRepo.save(mcQuestion15Answear1);
        anwersRepo.save(mcQuestion15Answear2);
        anwersRepo.save(mcQuestion15Answear3);

        Question mcQuestion16 = new Question("Formuła K(p) = k/(1+pT) opisuje operatorową funkcję przejścia", mc);
        Answer mcQuestion16Answear0 = new Answer("Elementu inercyjnego 1 rzęd", true, mcQuestion16);
        Answer mcQuestion16Answear1 = new Answer("Elementu różniczkującego z inercją", false, mcQuestion16);
        Answer mcQuestion16Answear2 = new Answer("Elementu opóźniającego", false, mcQuestion16);
        Answer mcQuestion16Answear3 = new Answer("Elementu całkującego z inercją", false, mcQuestion16);
        questionsRepo.save(mcQuestion16);
        anwersRepo.save(mcQuestion16Answear0);
        anwersRepo.save(mcQuestion16Answear1);
        anwersRepo.save(mcQuestion16Answear2);
        anwersRepo.save(mcQuestion16Answear3);

        Question mcQuestion17 = new Question("Które z poniższych formuł opisują funkcję dodatnio określoną?", mc);
        Answer mcQuestion17Answear0 = new Answer("V(x1,x2)= 2(x1)^2 - 2(x1x2) + 2(x2)^2", true, mcQuestion17);
        Answer mcQuestion17Answear1 = new Answer("V(x1,x2)= (x1)^2 - 3(x1x2) + 3(x2)^2", true, mcQuestion17);
        Answer mcQuestion17Answear2 = new Answer("V(x1,x2)= (x1)^2 - 3(x1x2) + 2(x2)^2", false, mcQuestion17);
        Answer mcQuestion17Answear3 = new Answer("V(x1,x2)= (x1)^2 - 4(x1x2) + 3(x2)^2", false, mcQuestion17);
        questionsRepo.save(mcQuestion17);
        anwersRepo.save(mcQuestion17Answear0);
        anwersRepo.save(mcQuestion17Answear1);
        anwersRepo.save(mcQuestion17Answear2);
        anwersRepo.save(mcQuestion17Answear3);

        Question mcQuestion18 = new Question("Które z poniższych formuł opisują funkcję dodatnio określoną?", mc);
        Answer mcQuestion18Answear0 = new Answer("V(x1,x2)= (x1)^2 - 4(x1x2) + 3(x2)^2", false, mcQuestion18);
        Answer mcQuestion18Answear1 = new Answer("V(x1,x2)= (x1)^2 - 3(x1x2) + 3(x2)^2", true, mcQuestion18);
        Answer mcQuestion18Answear2 = new Answer("V(x1,x2)= 1.01(x1)^2 - 2(x1x2) + (x2)^2", true, mcQuestion18);
        Answer mcQuestion18Answear3 = new Answer("V(x1,x2)= (x1)^2 - 6(x1x2) + 9(x2)^2", false, mcQuestion18);
        questionsRepo.save(mcQuestion18);
        anwersRepo.save(mcQuestion18Answear0);
        anwersRepo.save(mcQuestion18Answear1);
        anwersRepo.save(mcQuestion18Answear2);
        anwersRepo.save(mcQuestion18Answear3);

        Question mcQuestion19 = new Question("Które z poniższych formuł opisują funkcję dodatnio określoną?", mc);
        Answer mcQuestion19Answear0 = new Answer("V(x1,x2)= 2(x1)^2 - 2(x1x2) + 2(x2)^2", true, mcQuestion19);
        Answer mcQuestion19Answear1 = new Answer("V(x1,x2)= (x1)^2 - 4(x1x2) + (x2)^2", false, mcQuestion19);
        Answer mcQuestion19Answear2 = new Answer("V(x1,x2)= 9(x1)^2 - 6(x1x2) + (x2)^2", false, mcQuestion19);
        Answer mcQuestion19Answear3 = new Answer("V(x1,x2)= (x1)^2 - 3(x1x2) + 2(x2)^2", false, mcQuestion19);
        questionsRepo.save(mcQuestion19);
        anwersRepo.save(mcQuestion19Answear0);
        anwersRepo.save(mcQuestion19Answear1);
        anwersRepo.save(mcQuestion19Answear2);
        anwersRepo.save(mcQuestion19Answear3);

    }

    private void createMCQuizPart2(Category category,CategoriesRepository categoriesRepo, ScoresRepository scoresRepo, QuizesRepository quizesRepo, QuestionsRepository questionsRepo, AnswersRepository anwersRepo) {

        Category MC_2 = category;
        Quiz mc_2 = new Quiz("MC2", MC_2);

        //categoriesRepo.save(MC_2);
        quizesRepo.save(mc_2);

        Question mcQuestion20 = new Question("Zakładając warunek początkowy X0= [ 0;0 ] oraz e0 = 0 i en = 1 dla n > 0 ocenić poprawność wyliczenia wartości\n" +
                "wektora kolumnowego Xi", mc_2);
        Answer mcQuestion20Answear0 = new Answer("X2 = [0;1]", false, mcQuestion20);
        Answer mcQuestion20Answear1 = new Answer("X1=[0;0]", true, mcQuestion20);
        Answer mcQuestion20Answear2 = new Answer("X3=[-1;1]", false, mcQuestion20);
        Answer mcQuestion20Answear3 = new Answer("X4=[0;1]", true, mcQuestion20);
        questionsRepo.save(mcQuestion20);
        anwersRepo.save(mcQuestion20Answear0);
        anwersRepo.save(mcQuestion20Answear1);
        anwersRepo.save(mcQuestion20Answear2);
        anwersRepo.save(mcQuestion20Answear3);

        Question mcQuestion21 = new Question("Zakładając warunek początkowy X0= [ 0;0 ] oraz e0 = 0 i en = 1 dla n > 0 ocenić poprawność wyliczenia wartości\n" +
                "wektora kolumnowego Xi", mc_2);
        Answer mcQuestion21Answear0 = new Answer("X3=[-1;1]", true, mcQuestion21);
        Answer mcQuestion21Answear1 = new Answer("X4=[-2;0]", false, mcQuestion21);
        Answer mcQuestion21Answear2 = new Answer("X2[0;1]", true, mcQuestion21);
        Answer mcQuestion21Answear3 = new Answer("X1=[0;0]", true, mcQuestion21);
        questionsRepo.save(mcQuestion21);
        anwersRepo.save(mcQuestion21Answear0);
        anwersRepo.save(mcQuestion21Answear1);
        anwersRepo.save(mcQuestion21Answear2);
        anwersRepo.save(mcQuestion21Answear3);


        /* Pytania 25 - 34 */

        Question mcQuestion22 = new Question("Oceń poprawność następujących stwierdzeń dotyczących metod optymalizacji parametrycznej:", mc_2);
        Answer mcQuestion22Answear0 = new Answer("Metoda Gaussa-Seidela jest gradientową metodą kierunków poprawy", false, mcQuestion22);
        Answer mcQuestion22Answear1 = new Answer("Metoda kierunków sprzężonych Powella jest bezgradientową metodą kierunków poprawy", true, mcQuestion22);
        Answer mcQuestion22Answear2 = new Answer("Metoda simpleksu Neldera-Meada jest gradientową metodą poszukiwań prostych", false, mcQuestion22);
        Answer mcQuestion22Answear3 = new Answer("Metoda Hooka-Jeevesa jest bezgradientową metodą poszukiwań prostych", true, mcQuestion22);
        questionsRepo.save(mcQuestion22);
        anwersRepo.save(mcQuestion22Answear0);
        anwersRepo.save(mcQuestion22Answear1);
        anwersRepo.save(mcQuestion22Answear2);
        anwersRepo.save(mcQuestion22Answear3);

        Question mcQuestion23 = new Question("W modelu opartym na schemacie różnicowym Adamsa-Bashfortha 2 rzędu zamiast kroku\n" +
                "całkowania o wartości h przyjęto krok całkowania o wartości h/2. Które ze zdań jest najbardziej\n" +
                "prawdopodobne? W wyniku zmiany kroku całkowania lokalny błąd obcięcia będzie:", mc_2);
        Answer mcQuestion23Answear0 = new Answer("Sześć razy mniejszy", false, mcQuestion23);
        Answer mcQuestion23Answear1 = new Answer("Dwa razy mniejszy", false, mcQuestion23);
        Answer mcQuestion23Answear2 = new Answer("Osiem razy mniejszy", true, mcQuestion23);
        Answer mcQuestion23Answear3 = new Answer("Cztery razy mniejszy", false, mcQuestion23);
        questionsRepo.save(mcQuestion23);
        anwersRepo.save(mcQuestion23Answear0);
        anwersRepo.save(mcQuestion23Answear1);
        anwersRepo.save(mcQuestion23Answear2);
        anwersRepo.save(mcQuestion23Answear3    );

        Question mcQuestion24 = new Question("W prezentowanym na wykładzie modelu elementu inercyjnego pierwszego rzędu, zastosowano\n" +
                "procedurę CALKA wyznaczającą nowe wartości. Które ze sformułowań są prawdziwe:", mc_2);
        Answer mcQuestion24Answear0 = new Answer("Procedura CALKA wyznacza nowe, przybliżone wartości zmiennej wyjściowej yi oraz nową wartość zmiennej\n" +
                "niezależnej ti", true, mcQuestion24);
        Answer mcQuestion24Answear1 = new Answer("Procedura CALKA wyznacza nowe, przybliżone wartości zmiennych stanu xi i zmiennej wyjścia yi", false, mcQuestion24);
        Answer mcQuestion24Answear2 = new Answer("Procedura CALKA wyznacza nowe, przybliżone wartości zmiennej wyjściowej yi", false, mcQuestion24);
        Answer mcQuestion24Answear3 = new Answer("Procedura CALKA wyznacza nowe przybliżone wartości zmiennych stanu xi, ich pochodnych xi' oraz nową\n" +
                "wartość zmiennej niezależnej ti", false, mcQuestion24);
        questionsRepo.save(mcQuestion24);
        anwersRepo.save(mcQuestion24Answear0);
        anwersRepo.save(mcQuestion24Answear1);
        anwersRepo.save(mcQuestion24Answear2);
        anwersRepo.save(mcQuestion24Answear3);

        Question mcQuestion25 = new Question("Oceń poprawność następujących stwierdzeń dotyczących zagadnień związanych z obliczaniem wartości początkowych zmiennych stanu i zmiennych wyjścia", mc_2);
        Answer mcQuestion25Answear0 = new Answer("Przy zastosowaniu metody szeregowej wartości początkowe kolejnych zmiennych stanu są równe warunkom\n" +
                "początkowym dla zmiennej wyjścia i jej kolejnych pochodnych\n", false, mcQuestion25);
        Answer mcQuestion25Answear1 = new Answer("Gdy zmienna wejściowa w chwili t = 0 nie jest impulsem Diraca, to pomiędzy wartościami zmiennych stanu\n" +
                "zachodzi następująca relacja: x(0+) ≠ x(0-)" +
                "−)", false, mcQuestion25);
        Answer mcQuestion25Answear2 = new Answer("Przy zastosowaniu metody równoległej wartości początkowe kolejnych zmiennych stanu są równe warunkom\n" +
                "początkowym dla zmiennej wyjścia i jej kolejnych pochodnych\n", false, mcQuestion25);
        Answer mcQuestion25Answear3 = new Answer("Przy zastosowaniu metody ogólnej wartości początkowe kolejnych zmiennych stanu są równe warunkom\n" +
                "początkowym dla zmiennej wyjścia i jej kolejnych pochodnych", true, mcQuestion25);
        questionsRepo.save(mcQuestion25);
        anwersRepo.save(mcQuestion25Answear0);
        anwersRepo.save(mcQuestion25Answear1);
        anwersRepo.save(mcQuestion25Answear2);
        anwersRepo.save(mcQuestion25Answear3);

        Question mcQuestion26 = new Question("W środowisku Matlab:", mc_2);
        Answer mcQuestion26Answear0 = new Answer("Jednym z parametrów wejściowych funkcji ode45 jest nazwa funkcji wyznaczającej wartości pochodnych\n" +
                "wektora stanu", true, mcQuestion26);
        Answer mcQuestion26Answear1 = new Answer("Funkcja ode45 umożliwia rozwiązywanie zagadnienia początkowego", true, mcQuestion26);
        Answer mcQuestion26Answear2 = new Answer("Funkcja ode45 jest metodą całkowania numerycznego opartą na jednym ze schematów Adamsa-Bashfortha", false, mcQuestion26);
        Answer mcQuestion26Answear3 = new Answer("Jednym z parametrów wejściowych funkcji ode45 jest wektor początkowych wartości składowych wektora stanu", true, mcQuestion26);
        questionsRepo.save(mcQuestion26);
        anwersRepo.save(mcQuestion26Answear0);
        anwersRepo.save(mcQuestion26Answear1);
        anwersRepo.save(mcQuestion26Answear2);
        anwersRepo.save(mcQuestion26Answear3);

        Question mcQuestion27 = new Question("Oceń poprawność następujących stwierdzeń dotyczących metod generacji liczb pseudolosowych", mc_2);
        Answer mcQuestion27Answear0 = new Answer("Wygenerowanie kolejnej liczby za pomocą metody odwracania dystrybuanty wymaga jednokrotnego użycia\n" +
                "pomocniczego generatora liczb o rozkładzie równomiernym", true, mcQuestion27);
        Answer mcQuestion27Answear1 = new Answer("W ogólnym przypadku metoda eliminacji nie gwarantuje wylosowania wartości liczby pseudolosowej o\n" +
                "zadanym rozkładzie w pierwszej próbie losowania", true, mcQuestion27);
        Answer mcQuestion27Answear2 = new Answer("Metoda superpozycji może być przydatna w realizacji generatora zadanego funkcją gęstości rozkładu o\n" +
                "skomplikowanym wzorze", false, mcQuestion27);
        Answer mcQuestion27Answear3 = new Answer("Liczby o rozkładzie równomiernym na odcinku [0, 1) mogą być uzyskiwane przez zastosowanie metody\n" +
                "odwracania dystrybuanty (????????)", true, mcQuestion27);
        questionsRepo.save(mcQuestion27);
        anwersRepo.save(mcQuestion27Answear0);
        anwersRepo.save(mcQuestion27Answear1);
        anwersRepo.save(mcQuestion27Answear2);
        anwersRepo.save(mcQuestion27Answear3);

        Question mcQuestion28 = new Question("Oceń poprawność następujących stwierdzeń dotyczących metod generacji liczb pseudolosowych:?", mc_2);
        Answer mcQuestion28Answear0 = new Answer("Wygenerowanie kolejnej liczby pseudolosowej o rozkładzie normalnym N(0, 1) może zostać dokonane za\n" +
                "pomocą metody opartej na centralnym twierdzeniu granicznym (????????)", false, mcQuestion28);
        Answer mcQuestion28Answear1 = new Answer("Metoda superpozycji może być przydatna w realizacji generatora zadanego funkcją gęstości rozkładu, w opicie\n" +
                "której występują impulsy Diraca", true, mcQuestion28);
        Answer mcQuestion28Answear2 = new Answer("Wygenerowanie kolejnej liczby pseudolosowej o dowolnym nieobciętym rozkładzie normalnym może zostać\n" +
                "dokonane za pomocą metody eliminacji", false, mcQuestion28);
        Answer mcQuestion28Answear3 = new Answer("Wygenerowanie kolejnej liczby pseudolosowej o rozkładzie wykładniczym może zostać dokonane za pomocą\n" +
                "metody odwracania dystrybuanty", true, mcQuestion28);
        questionsRepo.save(mcQuestion28);
        anwersRepo.save(mcQuestion28Answear0);
        anwersRepo.save(mcQuestion28Answear1);
        anwersRepo.save(mcQuestion28Answear2);
        anwersRepo.save(mcQuestion28Answear3);

        Question mcQuestion29 = new Question("Oceń poprawność następujących stwierdzeń dotyczących funkcji ode45 środowiska Matlab:?", mc_2);
        Answer mcQuestion29Answear0 = new Answer("Umożliwia rozwiązanie zagadnienia początkowego", true, mcQuestion29);
        Answer mcQuestion29Answear1 = new Answer("Jednym z jej parametrów wejściowych jest nazwa funkcji wyznaczającej wartości pochodnych wektora stanu", true, mcQuestion29);
        Answer mcQuestion29Answear2 = new Answer("Jest metodą całkowania numerycznego opartą na jednym ze schematów Adamsa-Bashfortha", false, mcQuestion29);
        Answer mcQuestion29Answear3 = new Answer("Jednym z jej parametrów wejściowych jest wektor początkowych wartości składowych wektora st", true, mcQuestion29);
        questionsRepo.save(mcQuestion29);
        anwersRepo.save(mcQuestion29Answear0);
        anwersRepo.save(mcQuestion29Answear1);
        anwersRepo.save(mcQuestion29Answear2);
        anwersRepo.save(mcQuestion29Answear3);

        Question mcQuestion30 = new Question("Oceń poprawność następujących stwierdzeń dotyczących funkcji ode45 środowiska Matlab", mc_2);
        Answer mcQuestion30Answear0 = new Answer("Umożliwia rozwiązanie zagadnienia początkowego\n", true, mcQuestion30);
        Answer mcQuestion30Answear1 = new Answer("Jest metodą całkowania numerycznego opartą na schemacie Eulera Vk+1 = Vk + h * f(Vk,tk)", false, mcQuestion30);
        Answer mcQuestion30Answear2 = new Answer("Jednym z jej parametrów wejściowych jest nazwa funkcji wyznaczającej wartości pochodnych wektora stanu", true, mcQuestion30);
        Answer mcQuestion30Answear3 = new Answer("Jednym z jej parametrów wejściowych jest wektor początkowych wartości składowych wektora stanu", true, mcQuestion30);
        questionsRepo.save(mcQuestion30);
        anwersRepo.save(mcQuestion30Answear0);
        anwersRepo.save(mcQuestion30Answear1);
        anwersRepo.save(mcQuestion30Answear2);
        anwersRepo.save(mcQuestion30Answear3);

        Question mcQuestion31 = new Question("Oceń poprawność następujących stwierdzeń dotyczących szeregowej i równoległej metody\n" +
                "znajdowania równań stanu:", mc_2);
        Answer mcQuestion31Answear0 = new Answer("Uzyskana postać równań stanu nie musi być identyczna dla obu metod", true, mcQuestion31);
        Answer mcQuestion31Answear1 = new Answer("Metoda równoległa wymaga znajomości pierwiastków mianownika funkcji przejścia układu", true, mcQuestion31);
        Answer mcQuestion31Answear2 = new Answer("Przy zastosowaniu metody równoległej dla funkcji przejścia K(p) = (p+1)/(p^2-9) wartość współczynnika D wynosi 0", true, mcQuestion31);
        Answer mcQuestion31Answear3 = new Answer("W metodzie szeregowej sygnał wymuszenia jest zadawany na wejście każdego z połączonych ze sobą\n" +
                "szeregowo układów elementarnych", false, mcQuestion31);
        questionsRepo.save(mcQuestion31);
        anwersRepo.save(mcQuestion31Answear0);
        anwersRepo.save(mcQuestion31Answear1);
        anwersRepo.save(mcQuestion31Answear2);
        anwersRepo.save(mcQuestion31Answear3);

        Question mcQuestion32 = new Question("Koncepcja wyboru działania:\n", mc_2);
        Answer mcQuestion32Answear0 = new Answer("Umożliwia modelowanie systemów masowej obsługi", true, mcQuestion32);
        Answer mcQuestion32Answear1 = new Answer("Wymaga, aby w budowanym modelu cyfrowym przy każdym przesunięciu czasu zbadać możliwość\n" +
                "wystąpienia wszystkich zdarzeń czasowych i warunkowych", true, mcQuestion32);
        Answer mcQuestion32Answear2 = new Answer("Implementowana jest w programie Simnon", false, mcQuestion32);
        Answer mcQuestion32Answear3 = new Answer("Znajduje zastosowanie przy modelowaniu dowolnych układów ciągłych", false, mcQuestion32);
        questionsRepo.save(mcQuestion32);
        anwersRepo.save(mcQuestion32Answear0);
        anwersRepo.save(mcQuestion32Answear1);
        anwersRepo.save(mcQuestion32Answear2);
        anwersRepo.save(mcQuestion32Answear3);

        /* Pytania 35 - 38 */

        Question mcQuestion33 = new Question("Rozwiązaniem równań stanu o postaci x' = Ax + Bu z warunkami początkowymi x0 jest", mc_2);
        Answer mcQuestion33Answear0 = new Answer("e^A", true, mcQuestion33);
        Answer mcQuestion33Answear1 = new Answer("e^(-A)", false, mcQuestion33);
        Answer mcQuestion33Answear2 = new Answer("e^B", false, mcQuestion33);
        Answer mcQuestion33Answear3 = new Answer("e^(-B)", false, mcQuestion33);
        questionsRepo.save(mcQuestion33);
        anwersRepo.save(mcQuestion33Answear0);
        anwersRepo.save(mcQuestion33Answear1);
        anwersRepo.save(mcQuestion33Answear2);
        anwersRepo.save(mcQuestion33Answear3);

        Question mcQuestion34 = new Question("Oceń poprawność następujących stwierdzeń dotyczących układów i sygnałów dyskretnych:", mc_2);
        Answer mcQuestion34Answear0 = new Answer("Ciąg impulsów Diraca jest sygnałem o modulowanej amplitudzie", true, mcQuestion34);
        Answer mcQuestion34Answear1 = new Answer("Sygnał schodkowy jest sygnałem o modulowanej amplitudzie", true, mcQuestion34);
        Answer mcQuestion34Answear2 = new Answer("W układzie dyskretnym wszystkie sygnały mają charakter dyskretny", false, mcQuestion34);
        Answer mcQuestion34Answear3 = new Answer("Sygnał interpolacji liniowej u(t) = pojebanyWzor dla pojebanyPrzedzial jest sygnałem o modulowanej amplitudzie (??????)", false, mcQuestion34);
        questionsRepo.save(mcQuestion34);
        anwersRepo.save(mcQuestion34Answear0);
        anwersRepo.save(mcQuestion34Answear1);
        anwersRepo.save(mcQuestion34Answear2);
        anwersRepo.save(mcQuestion34Answear3);

        Question mcQuestion35 = new Question("Dany jest generator liczb losowych Xi o rozkładzie równomiernym w przedziale (-0.5, 0.5) oraz wyznaczane są liczby losowe Yi wg wzorów podanych poniżej. Wskaż, które z podanych wzorów mogą być zastosowane do generacji liczb losowych o rozkładzie normalnym N(0, 1):", mc_2);
        Answer mcQuestion35Answear0 = new Answer("Yi=E^12(Xi)", true, mcQuestion35);
        Answer mcQuestion35Answear1 = new Answer("Yi=E^18(Xi)", false, mcQuestion35);
        Answer mcQuestion35Answear2 = new Answer("Yi=E^6(Xi)", false, mcQuestion35);
        Answer mcQuestion35Answear3 = new Answer("Yi=E^24(Xi)", false, mcQuestion35);
        questionsRepo.save(mcQuestion35);
        anwersRepo.save(mcQuestion35Answear0);
        anwersRepo.save(mcQuestion35Answear1);
        anwersRepo.save(mcQuestion35Answear2);
        anwersRepo.save(mcQuestion35Answear3);

        Question mcQuestion36 = new Question("Oceń poprawność następujących stwierdzeń dotyczących stabilności układów liniowych ciągłych:\n", mc_2);
        Answer mcQuestion36Answear0 = new Answer("Kryterium Hurwitza pozwala na wyznaczenie wartości pierwiastków "
                + "równania charakterystycznego\n", false, mcQuestion36);
        Answer mcQuestion36Answear1 = new Answer("Jeśli pierwiastki równania charakterystycznego układu mają części "
                + "rzeczywiste mniejsze od zera, to układ jest stabilny asymptotycznie\n", true, mcQuestion36);
        Answer mcQuestion36Answear2 = new Answer("Dla układu dynamicznego opisanego równaniem 7y′′ + 2y′ + 3y = 0 "
                + "wyznacznik ∆2 z kryterium Hurwitza jest wyrażony następująco:|2 0 ; 7 3 |", true, mcQuestion36);
        Answer mcQuestion36Answear3 = new Answer("Dla układu dynamicznego opisanego równaniem 2y′′ + 3y′ + 4y = 0 "
                + "wyznacznik ∆2 z kryterium Hurwitza jest wyrażony następująco: | 0 3 ; 2 4|", false, mcQuestion36);
        questionsRepo.save(mcQuestion36);
        anwersRepo.save(mcQuestion36Answear0);
        anwersRepo.save(mcQuestion36Answear1);
        anwersRepo.save(mcQuestion36Answear2);
        anwersRepo.save(mcQuestion36Answear3);

        /* Ulciorek */
        Question mcQuestion37 = new Question("Oceń poprawność następujących stwierdzeń dla dowolnego modelu układu "
                + "zdarzeń dyskretnych zbudowanego według koncepcji planowania zdarzeń:", mc_2);
        Answer mcQuestion37Answear0 = new Answer("wykrycie przez procedurę kontroli symulacji pustego zbioru "
                + "zaplanowanych zdarzeń w trakcie realizacji eksperymentu oznacza, że aktualny stan układu jest ostateczny", true, mcQuestion37);
        Answer mcQuestion37Answear1 = new Answer("planowanie dotyczy zarówno tego, co będzie odbywać się w przyszłości, jak i przeszłości", false, mcQuestion37);
        Answer mcQuestion37Answear2 = new Answer("mechanizmem upływu czasu symulacyjnego steruje procedura kontroli symulacji", true, mcQuestion37);
        Answer mcQuestion37Answear3 = new Answer("zaplanowanie zdarzenia wymaga między innymi obliczenia chwili zajścia tego zdarzenia", true, mcQuestion37);
        questionsRepo.save(mcQuestion37);
        anwersRepo.save(mcQuestion37Answear0);
        anwersRepo.save(mcQuestion37Answear1);
        anwersRepo.save(mcQuestion37Answear2);
        anwersRepo.save(mcQuestion37Answear3);

        Question mcQuestion38 = new Question("Oceń poprawność następujących stwierdzeń dotyczących schematów różnicowych:", mc_2);
        Answer mcQuestion38Answear0 = new Answer("w schematach jednokrokowych kolejne przybliżenie rozwiązania tk+1, "
                + "vk+1 zależy od wartości vk i pochodnej f w otoczeniu tk, vk (????)", true, mcQuestion38);
        Answer mcQuestion38Answear1 = new Answer("funkcja f występująca we wzorach schematów różnicowych jest prawą stroną równania stanu", true, mcQuestion38);
        Answer mcQuestion38Answear2 = new Answer("schemat różnicowy o postaci vj+1 = F(vj+1, vj, … , vj-p, tj) jest "
                + "schematem jawnym", false, mcQuestion38);
        Answer mcQuestion38Answear3 = new Answer("metody Rungego-Kutty są przykładami metod jednokrokowych", true, mcQuestion38);
        questionsRepo.save(mcQuestion38);
        anwersRepo.save(mcQuestion38Answear0);
        anwersRepo.save(mcQuestion38Answear1);
        anwersRepo.save(mcQuestion38Answear2);
        anwersRepo.save(mcQuestion38Answear3);

        Question mcQuestion39 = new Question("W środowisku Matlab/Simulink funkcja sim umożliwia", mc_2);
        Answer mcQuestion39Answear0 = new Answer("rozwiązanie zagadnienia początkowego dla układów dyskretnych", true, mcQuestion39);
        Answer mcQuestion39Answear1 = new Answer("rozwiązanie zagadnienia optymalizacji parametrycznej", false, mcQuestion39);
        Answer mcQuestion39Answear2 = new Answer("rozwiązanie zagadnienia początkowego dla układów ciągłych", true, mcQuestion39);
        Answer mcQuestion39Answear3 = new Answer("wyznaczenie czasowej funkcji przejścia", false, mcQuestion39);
        questionsRepo.save(mcQuestion39);
        anwersRepo.save(mcQuestion39Answear0);
        anwersRepo.save(mcQuestion39Answear1);
        anwersRepo.save(mcQuestion39Answear2);
        anwersRepo.save(mcQuestion39Answear3);

    }

    private void createMCQuizPart3(Category category, CategoriesRepository categoriesRepo, ScoresRepository scoresRepo, QuizesRepository quizesRepo, QuestionsRepository questionsRepo, AnswersRepository anwersRepo)
    {
        Category MC_3 = category;
        Quiz mc_3 = new Quiz("MC3", MC_3);

        //categoriesRepo.save(MC_3);
        quizesRepo.save(mc_3);

        Question mcQuestion40 = new Question("Oceń poprawność następujących stwierdzeń dotyczących zadania optymalizacji parametrycznej", mc_3);
        Answer mcQuestion40Answear0 = new Answer("zadanie dwugraniczne jest przykładem zadania optymalizacji parametrycznej", true, mcQuestion40);
        Answer mcQuestion40Answear1 = new Answer("parametrami optymalizacji nie mogą być warunki początkowe zmiennych stanu", false, mcQuestion40);
        Answer mcQuestion40Answear2 = new Answer("w zadaniach optymalizacji parametrycznej szukamy takich optymalnych"
                + " wartości parametrów α, by wskaźnik jakości przyjął wartość minimalną", true, mcQuestion40);
        Answer mcQuestion40Answear3 = new Answer("szukanie maksymalnej wartości wskaźnika jakości można zastąpić "
                + "szukaniem minimalnej wartości wskaźnika pomnożonego przez -1", true, mcQuestion40);
        questionsRepo.save(mcQuestion40);
        anwersRepo.save(mcQuestion40Answear0);
        anwersRepo.save(mcQuestion40Answear1);
        anwersRepo.save(mcQuestion40Answear2);
        anwersRepo.save(mcQuestion40Answear3);

        Question mcQuestion41 = new Question("Oceń poprawność następujących stwierdzeń dla dowolnego modelu układu "
                + "zdarzeń dyskretnych zbudowanego według koncepcji planowania zdarzeń", mc_3);
        Answer mcQuestion41Answear0 = new Answer("można planować zdarzenia odbywające się w przeszłości", false, mcQuestion41);
        Answer mcQuestion41Answear1 = new Answer("zaplanowanie zdarzenia wymaga między innymi obliczenia chwili zajścia tego zdarzenia", true, mcQuestion41);
        Answer mcQuestion41Answear2 = new Answer("mechanizmem upływu czasu symulacyjnego steruje procedura kontroli symulacji", true, mcQuestion41);
        Answer mcQuestion41Answear3 = new Answer("obecność elementów w zbiorze zaplanowanych zdarzeń po zakończeniu "
                + "realizacji eksperymentu oznacza, że eksperyment zakończył się w sposób nieprawidłowy (błędny)", false, mcQuestion41);
        questionsRepo.save(mcQuestion41);
        anwersRepo.save(mcQuestion41Answear0);
        anwersRepo.save(mcQuestion41Answear1);
        anwersRepo.save(mcQuestion41Answear2);
        anwersRepo.save(mcQuestion41Answear3);

        Question mcQuestion42 = new Question("Oceń poprawność poniższych stwierdzeń związanych z opisem w postaci równań stanu", mc_3);
        Answer mcQuestion42Answear0 = new Answer("dla danego układu istnieje tylko jeden opis za pomocą równań stanu", false, mcQuestion42);
        Answer mcQuestion42Answear1 = new Answer("równania stanu można stosować zarówno do opisu układów liniowych, jak i nieliniowych", true, mcQuestion42);
        Answer mcQuestion42Answear2 = new Answer("w równaniu stanu nie występuje zależność od pochodnych sygnału wejściowego", true, mcQuestion42);
        Answer mcQuestion42Answear3 = new Answer("równania stanu są równaniami różniczkowymi", true, mcQuestion42);
        questionsRepo.save(mcQuestion42);
        anwersRepo.save(mcQuestion42Answear0);
        anwersRepo.save(mcQuestion42Answear1);
        anwersRepo.save(mcQuestion42Answear2);
        anwersRepo.save(mcQuestion42Answear3);

        /* */

        Question mcQuestion43 = new Question("Oceń poprawność następujących stwierdzeń dotyczących metody eliminacji:", mc_3);
        Answer mcQuestion43Answear0 = new Answer("nie może być wykorzystywana do generacji liczb o dowolnym nieobciętym rozkładzie\n" +
                "normalnym", true, mcQuestion43);
        Answer mcQuestion43Answear1 = new Answer("jest zawsze bardziej efektywna od metody odwracania dystrybuanty", false, mcQuestion43);
        Answer mcQuestion43Answear2 = new Answer("umożliwia wygenerowanie kolejnej liczby zawsze przy jednokrotnym użyciu pomocniczego generatora liczb o rozkładzie równomiernym", false, mcQuestion43);
        Answer mcQuestion43Answear3 = new Answer("znajduje zastosowanie w przypadku, gdy funkcja gęstości rozkładu nie jest ograniczona", false, mcQuestion43);
        questionsRepo.save(mcQuestion43);
        anwersRepo.save(mcQuestion43Answear0);
        anwersRepo.save(mcQuestion43Answear1);
        anwersRepo.save(mcQuestion43Answear2);
        anwersRepo.save(mcQuestion43Answear3);

        Question mcQuestion44 = new Question("Oceń poprawność następujących stwierdzeń dotyczących schematów różnicowych", mc_3);
        Answer mcQuestion44Answear0 = new Answer("w ramach metody predyktor-korektor najpierw wykonywana jest metoda zamknięta,potem otwarta", false, mcQuestion44);
        Answer mcQuestion44Answear1 = new Answer("metody zamknięte wymagają rozwiązywania równania algebraicznego w każdym kroku", false, mcQuestion44);
        Answer mcQuestion44Answear2 = new Answer("w metodzie predyktor-korektor celem etapu korekcji jest znalezienie początkowego\n" +
                "przybliżenia punktu vj+1", false, mcQuestion44);
        Answer mcQuestion44Answear3 = new Answer("metody otwarte charakteryzują się większą dokładnością od metod zamkniętych", false, mcQuestion44);
        questionsRepo.save(mcQuestion44);
        anwersRepo.save(mcQuestion44Answear0);
        anwersRepo.save(mcQuestion44Answear1);
        anwersRepo.save(mcQuestion44Answear2);
        anwersRepo.save(mcQuestion44Answear3);

        Question mcQuestion45 = new Question("Oceń poprawność następujących stwierdzeń dotyczących metody kolejnych całkowań", mc_3);
        Answer mcQuestion45Answear0 = new Answer("może być stosowana do wyznaczania równań stanu zarówno układów liniowych jak i nieliniowych", true, mcQuestion45);
        Answer mcQuestion45Answear1 = new Answer("wartości początkowe kolejnych zmiennych stanu są równe warunkiem początkowym dla zmiennej wyjścia i jej kolejnych pochodnych", false, mcQuestion45);
        Answer mcQuestion45Answear2 = new Answer("jest jedną z metod wchodzących w skład metody mieszanej", true, mcQuestion45);
        Answer mcQuestion45Answear3 = new Answer("znajduje zastosowanie w przypadku, gdy występuje pochodna zmiennej wejściowej", true, mcQuestion45);
        questionsRepo.save(mcQuestion45);
        anwersRepo.save(mcQuestion45Answear0);
        anwersRepo.save(mcQuestion45Answear1);
        anwersRepo.save(mcQuestion45Answear2);
        anwersRepo.save(mcQuestion45Answear3);

        Question mcQuestion46 = new Question("Oceń poprawność następujących stwierdzeń dotyczących metod badania stabilności układów liniowych", mc_3);
        Answer mcQuestion46Answear0 = new Answer("warunkiem stabilności asymptotycznej układu dyskretnego jest by pierwiastek równania charakterystycznego układu leżały na płaszczyźnie zespolonej we wnętrzu koła o środku w środku układu współrzędnych i o promieniu 1", true, mcQuestion46);
        Answer mcQuestion46Answear1 = new Answer("warunkiem stabilności asymptotycznej układu ciągłego jest by pierwiastek równania charakterystycznego układu posiadały części rzeczywiste mniejsze od jedności\n", false, mcQuestion46);
        Answer mcQuestion46Answear2 = new Answer("kryterium Hurwitza pozwala na określenie stabilności układu ciągłego bez konieczności wyznaczania dokładnych wartości pierwiastków równania charakterystycznego układu", true, mcQuestion46);
        Answer mcQuestion46Answear3 = new Answer("kryterium Hurwitza pozwala na obliczenie dokładnej wartości pierwiastków równania charakterystycznego układu ciągłego", false, mcQuestion46);
        Answer mcQuestion46Answear4 = new Answer("kryterium Hurwitza pozwala na obliczenie dokładnej wartości pierwiastków równania charakterystycznego układu dyskretnego", false, mcQuestion46);
        questionsRepo.save(mcQuestion46);
        anwersRepo.save(mcQuestion46Answear0);
        anwersRepo.save(mcQuestion46Answear1);
        anwersRepo.save(mcQuestion46Answear2);
        anwersRepo.save(mcQuestion46Answear3);
        anwersRepo.save(mcQuestion46Answear4);

        Question mcQuestion47 = new Question("Oceń poprawność następujących stwierdzeń dotyczących środowiska R", mc_3);
        Answer mcQuestion47Answear0 = new Answer("polecenie a[-5] utworzy wektor zawierający elementy wektora a z wyjątkiem elementu piątego", false, mcQuestion47);
        Answer mcQuestion47Answear1 = new Answer("dwa wektory można dodać do siebie tylko wtedy, kiedy oba mają identyczną długość", true, mcQuestion47);
        Answer mcQuestion47Answear2 = new Answer("jeśli funkcja ma zwrócić kilka różnych wartości, to należy z nich utworzyć listę", true, mcQuestion47);
        Answer mcQuestion47Answear3 = new Answer("funkcja lines tworzy nowe okno dla wykresu", false, mcQuestion47);
        questionsRepo.save(mcQuestion47);
        anwersRepo.save(mcQuestion47Answear0);
        anwersRepo.save(mcQuestion47Answear1);
        anwersRepo.save(mcQuestion47Answear2);
        anwersRepo.save(mcQuestion47Answear3);

        Question mcQuestion48 = new Question("Oceń poprawność poniższych stwierdzeń związanych z opisem w postaci równań stanu", mc_3);
        Answer mcQuestion48Answear0 = new Answer("układ autonomiczny to układ, w których nie występuje oddziaływanie środowiska w\n" +
                "postaci sygnału wejściowego", true, mcQuestion48);
        Answer mcQuestion48Answear1 = new Answer("w układzie zdarzeń dyskretnych zmiany stanu zachodzą w dyskretnych\n" +
                "równoodległych chwilach czasu", false, mcQuestion48);
        Answer mcQuestion48Answear2 = new Answer("w układzie nieliniowym obowiązuje zasada superpozycji", false, mcQuestion48);
        Answer mcQuestion48Answear3 = new Answer("w układzie dynamicznym sygnał wyjściowy zależy tylko od aktualnej wartości\n" +
                "sygnału wejściowego", false, mcQuestion48);
        questionsRepo.save(mcQuestion48);
        anwersRepo.save(mcQuestion48Answear0);
        anwersRepo.save(mcQuestion48Answear1);
        anwersRepo.save(mcQuestion48Answear2);
        anwersRepo.save(mcQuestion48Answear3);

        Question mcQuestion49 = new Question("Koncepcja planowania zdarzeń", mc_3);
        Answer mcQuestion49Answear0 = new Answer("pozwala na planowanie zdarzeń, które stanowią ingerencję w przeszłość układu", false, mcQuestion49);
        Answer mcQuestion49Answear1 = new Answer("dopuszcza możliwość wystąpienia kilku zdarzeń w tej samej chwili czasu\n" +
                "symulacyjnego", true, mcQuestion49);
        Answer mcQuestion49Answear2 = new Answer("pozwala na planowanie zdarzeń, które wystąpią w przyszłości", true, mcQuestion49);
        Answer mcQuestion49Answear3 = new Answer("pozwala na planowanie zdarzeń, które wystąpią dla aktualnej wartości czasu\n" +
                "symulacyjnego", true, mcQuestion49);
        questionsRepo.save(mcQuestion49);
        anwersRepo.save(mcQuestion49Answear0);
        anwersRepo.save(mcQuestion49Answear1);
        anwersRepo.save(mcQuestion49Answear2);
        anwersRepo.save(mcQuestion49Answear3);

        //

        Question mcQuestion50 = new Question("W pakiecie SimEvents port wejściowy obiektów w danym bloku może zostać chwilowo\n" +
                "zablokowany w trakcie symulacji. Sytuacja ta może wystąpić", mc_3);
        Answer mcQuestion50Answear0 = new Answer("w bloku Entity Server/Capacity=1 (1-kanałowe stanowisko obsługi)", true, mcQuestion50);
        Answer mcQuestion50Answear1 = new Answer("w bloku Entity Queue z kolejką o skończonej długości", true, mcQuestion50);
        Answer mcQuestion50Answear2 = new Answer("w bloku Entity Server/Capacity=Inf (nieskończenie wielokanałowe stanowisko\n" +
                "obslugi)", false, mcQuestion50);
        Answer mcQuestion50Answear3 = new Answer("w bloku Entity Queue z kolejką o nieograniczonej długości", false, mcQuestion50);
        questionsRepo.save(mcQuestion50);
        anwersRepo.save(mcQuestion50Answear0);
        anwersRepo.save(mcQuestion50Answear1);
        anwersRepo.save(mcQuestion50Answear2);
        anwersRepo.save(mcQuestion50Answear3);

        Question mcQuestion51 = new Question("Oceń poprawność następujących stwierdzeń dotyczących algorytmu Ziggurat", mc_3);
        Answer mcQuestion51Answear0 = new Answer("wykorzystuje metodę odwracania dystrybuanty", false, mcQuestion51);
        Answer mcQuestion51Answear1 = new Answer("wykorzystuje metodę superpozycji rozkładów", false, mcQuestion51);
        Answer mcQuestion51Answear2 = new Answer("wykorzystuje twierdzenie graniczne", false, mcQuestion51);
        Answer mcQuestion51Answear3 = new Answer("wykorzystuje metodę eliminacji", true, mcQuestion51);
        questionsRepo.save(mcQuestion51);
        anwersRepo.save(mcQuestion51Answear0);
        anwersRepo.save(mcQuestion51Answear1);
        anwersRepo.save(mcQuestion51Answear2);
        anwersRepo.save(mcQuestion51Answear3);

        Question mcQuestion52 = new Question("Oceń poprawność następujących stwierdzeń dotyczących warunków stabilności\n" +
                "układów liniowych dyskretnych", mc_3);
        Answer mcQuestion52Answear0 = new Answer("na płaszczyźnie zespolonej przekształcenie p =  η−1/η+1 odwzorowuje punkty półpłaszczyzny η w punkty koła p", false, mcQuestion52);
        Answer mcQuestion52Answear1 = new Answer("na płaszczyźnie zespolonej przekształcenie p =  η−1/η+1 odwzorowuje punkty półpłaszczyzny η w punkty półpłaszczyzny p", true, mcQuestion52);
        Answer mcQuestion52Answear2 = new Answer("jeśli równanie charakterystyczne ma pierwiastki mniejsze lub równe jeden, to układ\n" +
                "jest stabilny", false, mcQuestion52);
        Answer mcQuestion52Answear3 = new Answer("jeśli równanie charakterystyczne ma pierwiastki większe od zera, to układ jest\n" +
                "niestabilny", false, mcQuestion52);
        questionsRepo.save(mcQuestion52);
        anwersRepo.save(mcQuestion52Answear0);
        anwersRepo.save(mcQuestion52Answear1);
        anwersRepo.save(mcQuestion52Answear2);
        anwersRepo.save(mcQuestion52Answear3);

        Question mcQuestion53 = new Question("Oceń poprawność następujących stwierdzeń dotyczących metod generacji i liczb\n" +
                "pseudolosowych", mc_3);
        Answer mcQuestion53Answear0 = new Answer("metoda superpozycji może być przydatna w realizacji generatora zadanego funkcją\n" +
                "gęstości rozkładu o skomplikowanym kształcie", false, mcQuestion53);
        Answer mcQuestion53Answear1 = new Answer("metoda odwracania dystrybuanty znajduje zastosowanie dla generowania liczb o\n" +
                "rozkładzie równomiernym", true, mcQuestion53);
        Answer mcQuestion53Answear2 = new Answer("wygenerowanie kolejnej liczby za pomocą metody odwracania dystrybuanty wymaga\n" +
                "jednokrotnego użycia pomocniczego generatora liczb o rozkładzie równomiernym", true, mcQuestion53);
        Answer mcQuestion53Answear3 = new Answer("metoda eliminacji znajduje zastosowanie w przypadku, gdy funkcja gęstości rozkładu\n" +
                "nie jest ograniczona", false, mcQuestion53);
        questionsRepo.save(mcQuestion53);
        anwersRepo.save(mcQuestion53Answear0);
        anwersRepo.save(mcQuestion53Answear1);
        anwersRepo.save(mcQuestion53Answear2);
        anwersRepo.save(mcQuestion53Answear3);

        Question mcQuestion54 = new Question("Oceń poprawność następujących stwierdzeń dotyczących rozwiązywania zadań\n" +
                "optymalizacji parametrycznej w środowisku Matlab/Simulink", mc_3);
        Answer mcQuestion54Answear0 = new Answer("funkcja fminunc umożliwia rozwiązywanie zadań optymalizacji parametrycznej bez\n" +
                "ograniczeń", true, mcQuestion54);
        Answer mcQuestion54Answear1 = new Answer("musi być określona funkcja wyznaczania pochodnych wektora stanu", true, mcQuestion54);
        Answer mcQuestion54Answear2 = new Answer("funkcja fminsearch implementuje algorytm Gaussa-Seidela wyznaczania minimum\n" +
                "funkcji", false, mcQuestion54);
        Answer mcQuestion54Answear3 = new Answer("musi być określona funkcja wyznaczania wartości wskaźnika jakości dla aktualnych\n" +
                "wartości wektora parametrów optymalizacji; funkcja ta dodatkowo może wyznaczać\n" +
                "składowe gradientu", true, mcQuestion54);
        questionsRepo.save(mcQuestion54);
        anwersRepo.save(mcQuestion54Answear0);
        anwersRepo.save(mcQuestion54Answear1);
        anwersRepo.save(mcQuestion54Answear2);
        anwersRepo.save(mcQuestion54Answear3);

        Question mcQuestion55 = new Question(" Metoda Euler jest metodą całkowania numerycznego, która", mc_3);
        Answer mcQuestion55Answear0 = new Answer("w środowiskach MATLAB i R została zaimplementowana w funkcji ode45", false, mcQuestion55);
        Answer mcQuestion55Answear1 = new Answer("jest metodą wielokrokową", false, mcQuestion55);
        Answer mcQuestion55Answear2 = new Answer("jest opisana schematem różnicowym vk+1 = vk + h * f (vk,tk)", true, mcQuestion55);
        Answer mcQuestion55Answear3 = new Answer("nie wymaga znajomości wartości początkowych zmiennych stanu", false, mcQuestion55);
        questionsRepo.save(mcQuestion55);
        anwersRepo.save(mcQuestion55Answear0);
        anwersRepo.save(mcQuestion55Answear1);
        anwersRepo.save(mcQuestion55Answear2);
        anwersRepo.save(mcQuestion55Answear3);

        Question mcQuestion56 = new Question("Operacja wywłaszczania dostępna jest w następujących blokach pakietu SimEvents", mc_3);
        Answer mcQuestion56Answear0 = new Answer("Entity Server/Capacity=1", true, mcQuestion56);
        Answer mcQuestion56Answear1 = new Answer("Entity Queue", false, mcQuestion56);
        Answer mcQuestion56Answear2 = new Answer("Entity Output Switch", false, mcQuestion56);
        Answer mcQuestion56Answear3 = new Answer("Entity Input Switch", false, mcQuestion56);
        questionsRepo.save(mcQuestion56);
        anwersRepo.save(mcQuestion56Answear0);
        anwersRepo.save(mcQuestion56Answear1);
        anwersRepo.save(mcQuestion56Answear2);
        anwersRepo.save(mcQuestion56Answear3);

        Question mcQuestion57 = new Question("Wskaż, które z wymienionych zagadnień stanowią przykłady zadań optymalizacji\n" +
                "parametrycznej", mc_3);
        Answer mcQuestion57Answear0 = new Answer("generacja liczby pseudolosowej o zadanym rozkładzie (?????)", false, mcQuestion57);
        Answer mcQuestion57Answear1 = new Answer("zagadnienie początkowe (Cauchy’ego)", false, mcQuestion57);
        Answer mcQuestion57Answear2 = new Answer("zadanie dwugraniczne", true, mcQuestion57);
        Answer mcQuestion57Answear3 = new Answer("strojenie modelu", true, mcQuestion57);
        questionsRepo.save(mcQuestion57);
        anwersRepo.save(mcQuestion57Answear0);
        anwersRepo.save(mcQuestion57Answear1);
        anwersRepo.save(mcQuestion57Answear2);
        anwersRepo.save(mcQuestion57Answear3);

        Question mcQuestion58 = new Question("Koncepcja planowania zdarzeń", mc_3);
        Answer mcQuestion58Answear0 = new Answer("pozwala na planowanie zdarzeń, które stanowią ingerencję w przeszłość układu", false, mcQuestion58);
        Answer mcQuestion58Answear1 = new Answer("dopuszcza możliwość wystąpienia kilku zdarzeń w tej samej chwili czasu\n" +
                "symulacyjnego", true, mcQuestion58);
        Answer mcQuestion58Answear2 = new Answer("pozwala na planowanie zdarzeń, które wystąpią w przyszłości", true, mcQuestion58);
        Answer mcQuestion58Answear3 = new Answer("pozwala na planowanie zdarzeń, które wystąpią dla aktualnej wartości czasu\n" +
                "symulacyjnego", true, mcQuestion58);
        questionsRepo.save(mcQuestion58);
        anwersRepo.save(mcQuestion58Answear0);
        anwersRepo.save(mcQuestion58Answear1);
        anwersRepo.save(mcQuestion58Answear2);
        anwersRepo.save(mcQuestion58Answear3);

        Question mcQuestion59 = new Question("W pakiecie SimEvents do budowy modelu wykorzystywane są:", mc_3);
        Answer mcQuestion59Answear0 = new Answer("Koncepcje inreakcji procesów”", true, mcQuestion59);
        Answer mcQuestion59Answear1 = new Answer("Ciągłe równania stanu", false, mcQuestion59);
        Answer mcQuestion59Answear2 = new Answer("Dyskretne równania stanu", false, mcQuestion59);
        Answer mcQuestion59Answear3 = new Answer("Koncepcja planowania zdarzeń", false, mcQuestion59);
        questionsRepo.save(mcQuestion59);
        anwersRepo.save(mcQuestion59Answear0);
        anwersRepo.save(mcQuestion59Answear1);
        anwersRepo.save(mcQuestion59Answear2);
        anwersRepo.save(mcQuestion59Answear3);
    }

    private void createMCQuizPart4(Category category, CategoriesRepository categoriesRepo, ScoresRepository scoresRepo, QuizesRepository quizesRepo, QuestionsRepository questionsRepo, AnswersRepository anwersRepo){
        //Category MC_4 = new Category("MC4");
        Category MC_4 = category;
        Quiz mc_4 = new Quiz("MC4", MC_4);

        //categoriesRepo.save(MC_4);
        quizesRepo.save(mc_4);

        Question mcQuestion60 = new Question("Wskaż poprawnie dobrane pary (koncepcja modelowania - narzędzie modelowania)", mc_4);
        Answer mcQuestion60Answear0 = new Answer("koncepcja interakcji procesów - CSL++", false, mcQuestion60);
        Answer mcQuestion60Answear1 = new Answer("koncepcja wyboru działania - SimEvents", false, mcQuestion60);
        Answer mcQuestion60Answear2 = new Answer("koncepcja planowania zdarzeń - OMNeT++", true, mcQuestion60);
        Answer mcQuestion60Answear3 = new Answer("koncepcja wyboru działania - CSL++", true, mcQuestion60);
        questionsRepo.save(mcQuestion60);
        anwersRepo.save(mcQuestion60Answear0);
        anwersRepo.save(mcQuestion60Answear1);
        anwersRepo.save(mcQuestion60Answear2);
        anwersRepo.save(mcQuestion60Answear3);

        Question mcQuestion61 = new Question("Wartość zmiennej losowej Y o rozkładzie normalnym N(u,o) o średniej u i odchyleniu standardowym o uzyskiwana jest na podstawie wartości zmiennej losowej X1 o standardowym rozkładzie normalnym N(0,1) za pomocą przekształcenia (?)", mc_4);
        Answer mcQuestion61Answear0 = new Answer("Y = u*X+o", false, mcQuestion61);
        Answer mcQuestion61Answear1 = new Answer("Y = (u-o)*N+u", false, mcQuestion61);
        Answer mcQuestion61Answear2 = new Answer("Y = (u-o)*N+o", true, mcQuestion61);
        Answer mcQuestion61Answear3 = new Answer("Y = o*N+u", true, mcQuestion61);
        questionsRepo.save(mcQuestion61);
        anwersRepo.save(mcQuestion61Answear0);
        anwersRepo.save(mcQuestion61Answear1);
        anwersRepo.save(mcQuestion61Answear2);
        anwersRepo.save(mcQuestion61Answear3);

        Question mcQuestion62 = new Question("Wskaż poprawne stwierdzenia dotyczące charakterystyki metod związanych z obsługą komunikatów w środowisku OMNeT++ (?)", mc_4);
        Answer mcQuestion62Answear0 = new Answer("w dowolnej chwili czasu symulacyjnego wywołanie o postaci scheduleAt(0,msg) spowoduje natychmiastowe nadejście komunikatu sterującego msg", false, mcQuestion62);
        Answer mcQuestion62Answear1 = new Answer("metoda sendDelayed powoduje dotarcie wysłanego komunikatu z modułu docelowego z opóźnieniem będącym jednym z parametrów wywołania metody", true, mcQuestion62);
        Answer mcQuestion62Answear2 = new Answer("metoda handleMessage sygnalizuje nadejście zarówno komunikatów sterujących jak i nadesłanych przez inny moduł", true, mcQuestion62);
        Answer mcQuestion62Answear3 = new Answer("metoda cancelEvent służy do usunięcia komunikatu sterującego ze zbioru przyszłych zdarzeń (FES)", true, mcQuestion62);
        questionsRepo.save(mcQuestion62);
        anwersRepo.save(mcQuestion62Answear0);
        anwersRepo.save(mcQuestion62Answear1);
        anwersRepo.save(mcQuestion62Answear2);
        anwersRepo.save(mcQuestion62Answear3);

        Question mcQuestion63 = new Question("Wskaż sformułowania poprawnie określające operatorową funkcję przejścia", mc_4);
        Answer mcQuestion63Answear0 = new Answer("iloraz transformaty Laplace'a sygnału wyjściowego do transformaty Laplace'a sygnału wejściowego przy dowolnych warunkach początkowych", false, mcQuestion63);
        Answer mcQuestion63Answear1 = new Answer("iloraz transformaty Laplace'a-Carsona sygnału wyjściowego do transformaty Laplace'a-Carsona sygnału wejściowego przy dowolnych zerowych początkowych", true, mcQuestion63);
        Answer mcQuestion63Answear2 = new Answer("iloraz transformaty Laplace'a-Carsona sygnału wejściowego do transformaty Laplace'a-Carsona sygnału wejściowego przy dowolnych zerowych początkowych", false, mcQuestion63);
        Answer mcQuestion63Answear3 = new Answer("iloraz transformaty Laplace'a sygnału wyjściowego do transformaty Laplace'a sygnału wejściowego przy dowolnych zerowych początkowych", true, mcQuestion63);
        questionsRepo.save(mcQuestion63);
        anwersRepo.save(mcQuestion63Answear0);
        anwersRepo.save(mcQuestion63Answear1);
        anwersRepo.save(mcQuestion63Answear2);
        anwersRepo.save(mcQuestion63Answear3);

        Question mcQuestion64 = new Question("Wskaż poprawne stwierdzenia dotyczące charakterystyki układów dynamicznych (???)", mc_4);
        Answer mcQuestion64Answear0 = new Answer("w układzie zdarzeń dyskretnych odstęp czasowy między kolejnymi zdarzeniami jest stały", false, mcQuestion64);
        Answer mcQuestion64Answear1 = new Answer("w układzie autonomicznym występuje oddziaływanie środowiska w postaci sygnału wejściowego", false, mcQuestion64);
        Answer mcQuestion64Answear2 = new Answer("w układzie liniowym obowiązuje zasada superpozycji", true, mcQuestion64);
        Answer mcQuestion64Answear3 = new Answer("w układzie dyskretnycm co najmniej jeden z sygnałów opisujących działanie układu ma charakter dyskretny", true, mcQuestion64);
        questionsRepo.save(mcQuestion64);
        anwersRepo.save(mcQuestion64Answear0);
        anwersRepo.save(mcQuestion64Answear1);
        anwersRepo.save(mcQuestion64Answear2);
        anwersRepo.save(mcQuestion64Answear3);

        Question mcQuestion65 = new Question("Wskaż poprawne stwierdzenia dotyczące zadania optymalizacji parametrycznej (???)", mc_4);
        Answer mcQuestion65Answear0 = new Answer("metoda Hooke'a-Jevesa należy do metod bezgradientowych", true, mcQuestion65);
        Answer mcQuestion65Answear1 = new Answer("w zadaniu dwugranicznym i w zadaniu wartości własnych konstrukcja funkcji wskaźnika jakości opiera się na iloczynie skalarnym", false, mcQuestion65);
        Answer mcQuestion65Answear2 = new Answer("metoda współczynników wrażliwości służy do wyznaczania składowych gradientu wskaźnika jakości", true, mcQuestion65);
        Answer mcQuestion65Answear3 = new Answer("metoda Gaussa-Seidela należy do metod gradientowych", true, mcQuestion65);
        questionsRepo.save(mcQuestion65);
        anwersRepo.save(mcQuestion65Answear0);
        anwersRepo.save(mcQuestion65Answear1);
        anwersRepo.save(mcQuestion65Answear2);
        anwersRepo.save(mcQuestion65Answear3);

        Question mcQuestion66 = new Question("Wskaż poprawne stwierdzenia dotyczące biblioteki CSL++ (???)", mc_4);
        Answer mcQuestion66Answear0 = new Answer("dodatnia wartość (stan) zegara związanego z danym zdarzeniem oznacza, że to zdarzenie już miało miejsce i zarazem wskazuje, ile czasu upłynęło od jego zajścia", true, mcQuestion66);
        Answer mcQuestion66Answear1 = new Answer("za aktualizację zegarów odpowiada funkcja SimTime()", false, mcQuestion66);
        Answer mcQuestion66Answear2 = new Answer("stan zegarów związanych ze zdarzeniami są z upływam czasu zmniejszane", false, mcQuestion66);
        Answer mcQuestion66Answear3 = new Answer("jest implementacją koncepcji interakcji procesów", false, mcQuestion66);
        questionsRepo.save(mcQuestion66);
        anwersRepo.save(mcQuestion66Answear0);
        anwersRepo.save(mcQuestion66Answear1);
        anwersRepo.save(mcQuestion66Answear2);
        anwersRepo.save(mcQuestion66Answear3);

        Question mcQuestion67 = new Question("Wartość zmiennej losowej Y o rozkładzie równomiernym na przedizale [a,b) uzyskiwana jest na podstawie wartości zmiennej losowej X o rozkładzie równomiernym na przedziale [0,1) za pomocą przekształcenia (?)", mc_4);
        Answer mcQuestion67Answear0 = new Answer("Y = (b-a)*X+a", false, mcQuestion67);
        Answer mcQuestion67Answear1 = new Answer("Y = b*X+a", false, mcQuestion67);
        Answer mcQuestion67Answear2 = new Answer("Y = a*X+b", false, mcQuestion67);
        Answer mcQuestion67Answear3 = new Answer("Y = (b-a)*X+b", true, mcQuestion67);
        questionsRepo.save(mcQuestion67);
        anwersRepo.save(mcQuestion67Answear0);
        anwersRepo.save(mcQuestion67Answear1);
        anwersRepo.save(mcQuestion67Answear2);
        anwersRepo.save(mcQuestion67Answear3);

        Question mcQuestion68 = new Question("Które z poniższych formuł opisują funkcję dodatnio określoną (??????) ?", mc_4);
        Answer mcQuestion68Answear0 = new Answer("V(x1,x2)= (x1)^2 + (x2)^4", false, mcQuestion68);
        Answer mcQuestion68Answear1 = new Answer("V(x1,x2)= (x1+x2)^2", false, mcQuestion68);
        Answer mcQuestion68Answear2 = new Answer("V(x1,x2)= (x1x2)", false, mcQuestion68);
        Answer mcQuestion68Answear3 = new Answer("V(x1,x2)= (x1)^2 - (x2)^2", false, mcQuestion68);
        questionsRepo.save(mcQuestion68);
        anwersRepo.save(mcQuestion68Answear0);
        anwersRepo.save(mcQuestion68Answear1);
        anwersRepo.save(mcQuestion68Answear2);
        anwersRepo.save(mcQuestion68Answear3);

        Question mcQuestion69 = new Question("Wskaż poprawne stwierdzenia dotyczącej metody ogólnej wyznaczania równań stanu.", mc_4);
        Answer mcQuestion69Answear0 = new Answer("może zostać użyta do wyznaczania równań stanu dla elementu inercyjnego 2.rzędu", true, mcQuestion69);
        Answer mcQuestion69Answear1 = new Answer("wymaga wyznaczenia wartości pierwiastków funkcji przejścia układu", false, mcQuestion69);
        Answer mcQuestion69Answear2 = new Answer("wartości początkowe kolejnych zmiennych stanu są równe warunkom początkowym dla zmiennej wyjścia i jej pochodnych", true, mcQuestion69);
        Answer mcQuestion69Answear3 = new Answer("znajduje zastosowanie w przypadku, gdy w równaniu różniczkowym występuje pochodna zmiennej wejściowej (wymuszenia)", false, mcQuestion69);
        questionsRepo.save(mcQuestion69);
        anwersRepo.save(mcQuestion69Answear0);
        anwersRepo.save(mcQuestion69Answear1);
        anwersRepo.save(mcQuestion69Answear2);
        anwersRepo.save(mcQuestion69Answear3);

        Question mcQuestion70 = new Question("Czasowa funkcja przjeścia to czasowa odpowiedź układu na pobudzenie (??????) ?", mc_4);
        Answer mcQuestion70Answear0 = new Answer("impulsem Diraca", false, mcQuestion70);
        Answer mcQuestion70Answear1 = new Answer("skokiem jednostkowym", true, mcQuestion70);
        Answer mcQuestion80Answear2 = new Answer("sygnałem u(t) = cos(t)", false, mcQuestion70);
        Answer mcQuestion70Answear3 = new Answer("sygnałem u(t) = sin(t)", false, mcQuestion70);
        questionsRepo.save(mcQuestion70);
        anwersRepo.save(mcQuestion70Answear0);
        anwersRepo.save(mcQuestion70Answear1);
        anwersRepo.save(mcQuestion80Answear2);
        anwersRepo.save(mcQuestion70Answear3);

    }


    private void createMCQuizAll(Category category,CategoriesRepository categoriesRepo, ScoresRepository scoresRepo, QuizesRepository quizesRepo, QuestionsRepository questionsRepo, AnswersRepository anwersRepo) {

        Category MC_ALL = category;
        Quiz mc = new Quiz("MCALL", MC_ALL);

        //categoriesRepo.save(MC_2);
        quizesRepo.save(mc);

        Question mcQuestion0 = new Question("Oceń poprawność następujących stwierdzeń dla modelu M/M/1 zbudowanego z wykorzystaniem środowiska OMNeT++", mc);
        Answer mcQuestion0Answear0 = new Answer("Dla zbudowania poprawnego modelu wystarczające jest posłużenie się w obrębie całego modelu dwoma typami komunikatów sterujących, sygnalizującymi wystąpienie zdarzeń „wygenerowanie kolejnego zgłoszenia” i „zakończenie obsługi”", true, mcQuestion0);
        Answer mcQuestion0Answear1 = new Answer("Warunkiem rozpoczęcia obsługi danego zgłoszenia jest nadejście komunikatu informującego o przybyciu kolejnego zgłoszenia", false, mcQuestion0);
        Answer mcQuestion0Answear2 = new Answer("Warunkiem zakończenia obsługi danego zgłoszenia jest niepusta kolejka przed tym stanowiskiem", false, mcQuestion0);
        Answer mcQuestion0Answear3 = new Answer("Pusta kolejka przed stanowiskiem obsługi jest warunkiem wystarczającym wejścia zgłoszenia na to stanowisko", false, mcQuestion0);
        questionsRepo.save(mcQuestion0);
        anwersRepo.save(mcQuestion0Answear0);
        anwersRepo.save(mcQuestion0Answear1);
        anwersRepo.save(mcQuestion0Answear2);
        anwersRepo.save(mcQuestion0Answear3);

        Question mcQuestion1 = new Question("Oceń poprawność następujących stwierdzeń dotyczących modelu utworzonego w pakiecie OMNeT++", mc);
        Answer mcQuestion1Answear0 = new Answer("Sposób wyznaczania wartości parametrów poszczególnych modułów zapisany jest w pliku konfiguracyjnym ”omnetpp.ini”", true, mcQuestion1);
        Answer mcQuestion1Answear1 = new Answer("W kontekście określenia czasu przyszłego zdarzenia struktura FES pełni funkcję analogiczną do planu zdarzeń w pakiecie NewGASP\n", false, mcQuestion1);
        Answer mcQuestion1Answear2 = new Answer("Wywołanie metody par() o postaci par(“x”) zwraca aktualną wartość parametru o nazwie “x” modułu, w którym wywołano tę metodę", true, mcQuestion1);
        Answer mcQuestion1Answear3 = new Answer("Definicje połączeń między modułami zapisane są w pliku konfiguracyjnym omnetpp.ini", false, mcQuestion1);
        questionsRepo.save(mcQuestion1);
        anwersRepo.save(mcQuestion1Answear0);
        anwersRepo.save(mcQuestion1Answear1);
        anwersRepo.save(mcQuestion1Answear2);
        anwersRepo.save(mcQuestion1Answear3);

        Question mcQuestion2 = new Question("Oceń poprawność następujących stwierdzeń dla modelu systemu M/M/1 zbudowanego z wykorzystaniem środowiska OMNeT++", mc);
        Answer mcQuestion2Answear0 = new Answer("W celu zebrania danych dla przygotowania wykresu zmian aktualnej liczby zgłoszeń przebywających w systemie należy zastosować klasę cOutVector", true, mcQuestion2);
        Answer mcQuestion2Answear1 = new Answer("Warunkiem zakończenia obsługi danego zgłoszenia jest obecność w kolejce co najmniej jednego zgłoszenia czekającego na obsługę", false, mcQuestion2);
        Answer mcQuestion2Answear2 = new Answer("Dla wejścia zgłoszenia na stanowisko obsługi pusta kolejka przed stanowiskiem jest warunkiem koniecznym, ale niewystarczającym", false, mcQuestion2);
        Answer mcQuestion2Answear3 = new Answer("Dla zbudowania poprawnego modelu wystarczające jest posłużenie się w obrębie całego modelu jednym typem komunikatu sterującego – sygnalizującym wystąpienie zdarzenia „wygenerowanie kolejnego zgłoszenia”", false, mcQuestion2);
        questionsRepo.save(mcQuestion2);
        anwersRepo.save(mcQuestion2Answear0);
        anwersRepo.save(mcQuestion2Answear1);
        anwersRepo.save(mcQuestion2Answear2);
        anwersRepo.save(mcQuestion2Answear3);

        Question mcQuestion3 = new Question("Oceń poprawność następujących stwierdzeń dotyczących mechanizmów pakietu OMNeT++:", mc);
        Answer mcQuestion3Answear0 = new Answer("W dowolnej chwili czasu symulacyjnego wywołanie o postaci scheduleAt(simTime(), msg) powoduje natychmiastowe nadejście komunikatu sterującego", true, mcQuestion3);
        Answer mcQuestion3Answear1 = new Answer("Metoda par() zwraca aktualną wartość parametru modułu podanego jako argument metody", false, mcQuestion3);
        Answer mcQuestion3Answear2 = new Answer("Metoda send umieszcza komunikat sterujący w liście przyszłych zdarzeń (FES)", false, mcQuestion3);
        Answer mcQuestion3Answear3 = new Answer("Definicje połączeń między modułami zapisane są w pliku konfiguracyjnym omnetpp.ini", false, mcQuestion3);
        questionsRepo.save(mcQuestion3);
        anwersRepo.save(mcQuestion3Answear0);
        anwersRepo.save(mcQuestion3Answear1);
        anwersRepo.save(mcQuestion3Answear2);
        anwersRepo.save(mcQuestion3Answear3);


        Question mcQuestion5Missed = new Question(" W modelu systemu M/M/1 zbudowanym z użyciem pakietu NewGASP za pomocą statystyki Timst można wyznaczyć:", mc);
        Answer mcQuestion5Answear0Missed = new Answer("Średni czas pobytu zgłoszenia w kolejce", true, mcQuestion5Missed);
        Answer mcQuestion5Answear1Missed = new Answer("Średnią długość kolejki", false, mcQuestion5Missed);
        Answer mcQuestion5Answear2Missed = new Answer("Średnią liczbę zgłoszeń przebywających w systemie", false, mcQuestion5Missed);
        Answer mcQuestion5Answear3Missed = new Answer("Średnie wykorzystanie (zajętość) stanowiska obsługi", true, mcQuestion5Missed);
        questionsRepo.save(mcQuestion5Missed);
        anwersRepo.save(mcQuestion5Answear0Missed);
        anwersRepo.save(mcQuestion5Answear1Missed);
        anwersRepo.save(mcQuestion5Answear2Missed);
        anwersRepo.save(mcQuestion5Answear3Missed);

        Question mcQuestion5 = new Question("W pakiecie SimEvents do budowy modelu wykorzystywane są:", mc);
        Answer mcQuestion5Answear0 = new Answer("Koncepcje wyboru działania”", false, mcQuestion5);
        Answer mcQuestion5Answear1 = new Answer("Ciągłe równania stanu", false, mcQuestion5);
        Answer mcQuestion5Answear2 = new Answer("Dyskretne równania stanu", false, mcQuestion5);
        Answer mcQuestion5Answear3 = new Answer("Koncepcja planowania zdarzeń", false, mcQuestion5);
        Answer mcQuestion5Answear4 = new Answer("koncepcja interakcji procesów", true, mcQuestion5);
        questionsRepo.save(mcQuestion5);
        anwersRepo.save(mcQuestion5Answear0);
        anwersRepo.save(mcQuestion5Answear1);
        anwersRepo.save(mcQuestion5Answear2);
        anwersRepo.save(mcQuestion5Answear3);
        anwersRepo.save(mcQuestion5Answear4);

        Question mcQuestion6 = new Question("Oceń, które z poniższych zdarzeń mogą wystąpić w zamkniętej sieci stanowisk obsługi typu M/M/1", mc);
        Answer mcQuestion6Answear0 = new Answer("Zakończenie obsługi zgłoszenia", true, mcQuestion6);
        Answer mcQuestion6Answear1 = new Answer("Rozpoczęcie obsługi zgłoszenia", true, mcQuestion6);
        Answer mcQuestion6Answear2 = new Answer("Opuszczenie z sieci przez zgłoszenie", false, mcQuestion6);
        Answer mcQuestion6Answear3 = new Answer("Przybycie nowego zgłoszenia do sieci", false, mcQuestion6);
        questionsRepo.save(mcQuestion6);
        anwersRepo.save(mcQuestion6Answear0);
        anwersRepo.save(mcQuestion6Answear1);
        anwersRepo.save(mcQuestion6Answear2);
        anwersRepo.save(mcQuestion6Answear3);

        Question mcQuestion7 = new Question("Ocen, które z poniższych zdarzeń mogą wystąpić w otwartej sieci stanowisk obsługi typu M/M/1", mc);
        Answer mcQuestion7Answear0 = new Answer("Rozpoczęcie obsługi zgłoszenia", true, mcQuestion7);
        Answer mcQuestion7Answear1 = new Answer("Przybycie nowego zgłoszenia do sieci", true, mcQuestion7);
        Answer mcQuestion7Answear2 = new Answer("Opuszczenie sieci przez zgłoszenie", true, mcQuestion7);
        Answer mcQuestion7Answear3 = new Answer("Zakończenie obsługi zgłoszenia", true, mcQuestion7);
        questionsRepo.save(mcQuestion7);
        anwersRepo.save(mcQuestion7Answear0);
        anwersRepo.save(mcQuestion7Answear1);
        anwersRepo.save(mcQuestion7Answear2);
        anwersRepo.save(mcQuestion7Answear3);

        Question mcQuestion8 = new Question("W pakiecie SimEvents bloki kolejek udostępniają statystyki prezentujące", mc);
        Answer mcQuestion8Answear0 = new Answer("Średnią liczbę obiektów w kolejce", true, mcQuestion8);
        Answer mcQuestion8Answear1 = new Answer("Maksymalną liczbę obiektów w kolejce", false, mcQuestion8);
        Answer mcQuestion8Answear2 = new Answer("Histogram czasu pobytu obiektu w kolejce", false, mcQuestion8);
        Answer mcQuestion8Answear3 = new Answer("Liczbę obiektów, które nie mogły wejść do bloku kolejki", false, mcQuestion8);
        questionsRepo.save(mcQuestion8);
        anwersRepo.save(mcQuestion8Answear0);
        anwersRepo.save(mcQuestion8Answear1);
        anwersRepo.save(mcQuestion8Answear2);
        anwersRepo.save(mcQuestion8Answear3);

        Question mcQuestion9 = new Question(" W pakiecie SimEvents bloki kolejek udostępniają statystyki prezentujące:", mc);
        Answer mcQuestion9Answear0 = new Answer("Aktualną liczbę obiektów w kolejce", true, mcQuestion9);
        Answer mcQuestion9Answear1 = new Answer("Średnią liczbę obiektów w kolejce", true, mcQuestion9);
        Answer mcQuestion9Answear2 = new Answer("Histogram czasu pobytu obiektu w kolejce", false, mcQuestion9);
        Answer mcQuestion9Answear3 = new Answer("Liczbę obiektów, które nie mogły wejść do bloku kolejki", false, mcQuestion9);
        questionsRepo.save(mcQuestion9);
        anwersRepo.save(mcQuestion9Answear0);
        anwersRepo.save(mcQuestion9Answear1);
        anwersRepo.save(mcQuestion9Answear2);
        anwersRepo.save(mcQuestion9Answear3);

        Question mcQuestion10 = new Question("Oceń poprawność następujących stwierdzeń dotyczących schematów różnicowych", mc);
        Answer mcQuestion10Answear0 = new Answer("Schemat Eulera jest przykładem schematu jednokrokowego", true, mcQuestion10);
        Answer mcQuestion10Answear1 = new Answer("W metodzie predyktor-korektor celem etapu predykcji jest znalezienie początkowego przybliżenia punktu Vj+1", true, mcQuestion10);
        Answer mcQuestion10Answear2 = new Answer("Schemat różnicowy wielokrokowy ma postać Vj+1 = F(Vj,Tj)", false, mcQuestion10);
        Answer mcQuestion10Answear3 = new Answer("Schemat różnicowy o postaci Vj+1= F(Vj+1, Vj, ...., Vj-p, Tj) jest schematem niejawnym", false, mcQuestion10);
        questionsRepo.save(mcQuestion10);
        anwersRepo.save(mcQuestion10Answear0);
        anwersRepo.save(mcQuestion10Answear1);
        anwersRepo.save(mcQuestion10Answear2);
        anwersRepo.save(mcQuestion10Answear3);

        /* Pytania 14 - 24 */

        Question mcQuestion11 = new Question("Oceń poprawność następujących stwierdzeń dotyczących schematów różnicowych", mc);
        Answer mcQuestion11Answear0 = new Answer("Schematy jednokrokowe dzielą się na schematy jawne i niejawne", false, mcQuestion11);
        Answer mcQuestion11Answear1 = new Answer("Funkcja f występująca we wzorach schematów różnicowych jest prawą stroną równania stanu", true, mcQuestion11);
        Answer mcQuestion11Answear2 = new Answer("Schemat różnicowy o postaci  Vj+1 = F(Vj,Vj-1,...,Vj-p,tj) jest schematem niejawnym", true, mcQuestion11);
        Answer mcQuestion11Answear3 = new Answer("Schemat różnicowy jednokrokowy ma postać  Vj+1=F(Vj,Tj)", true, mcQuestion11);
        questionsRepo.save(mcQuestion11);
        anwersRepo.save(mcQuestion11Answear0);
        anwersRepo.save(mcQuestion11Answear1);
        anwersRepo.save(mcQuestion11Answear2);
        anwersRepo.save(mcQuestion11Answear3);

        Question mcQuestion12 = new Question("Zmienne stanu w modelu przepływu cieczy opisującym sieć AQM, to:", mc);
        Answer mcQuestion12Answear0 = new Answer("Intensywność pakietów przychodzących i wychodzących", false, mcQuestion12);
        Answer mcQuestion12Answear1 = new Answer("Rozmiar okna w ruterze nadawcy i średnia zajętość bufora w ruterze odbiorcy", false, mcQuestion12);
        Answer mcQuestion12Answear2 = new Answer("Liczba aktywnych sesji TCP i średnia zajętość bufora w ruterze nadawcy", false, mcQuestion12);
        Answer mcQuestion12Answear3 = new Answer("Czas obiegu i prawdopodobieństwo wysłania negatywnego potwierdzenia", true, mcQuestion12);
        questionsRepo.save(mcQuestion12);
        anwersRepo.save(mcQuestion12Answear0);
        anwersRepo.save(mcQuestion12Answear1);
        anwersRepo.save(mcQuestion12Answear2);
        anwersRepo.save(mcQuestion12Answear3);

        Question mcQuestion13 = new Question("Zmienne stanu w modelu przepływu cieczy opisującym sieć AQM, to:", mc);
        Answer mcQuestion13Answear0 = new Answer("Średni rozmiar okna w routerze nadawcy i średnia zajętość bufora w routerze odbiorcy", true, mcQuestion13);
        Answer mcQuestion13Answear1 = new Answer("Czas obiegu i prawdopodobieństwo wysłania negatywnego potwierdzenia", true, mcQuestion13);
        Answer mcQuestion13Answear2 = new Answer("Średni rozmiar okna w routerze odbiorcy i średnia zajętość bufora w routerze nadawcy", false, mcQuestion13);
        Answer mcQuestion13Answear3 = new Answer("Liczba aktywnych sesji TCP i opóźnienie propagacji wysłania negatywnego potwierdzenia", true, mcQuestion13);
        questionsRepo.save(mcQuestion13);
        anwersRepo.save(mcQuestion13Answear0);
        anwersRepo.save(mcQuestion13Answear1);
        anwersRepo.save(mcQuestion13Answear2);
        anwersRepo.save(mcQuestion13Answear3);

        Question mcQuestion14 = new Question("Oceń poprawność następujących stwierdzeń dotyczących zagadnień związanych z obliczaniem wartości początkowych zmiennych stanu i zmiennych wyjścia", mc);
        Answer mcQuestion14Answear0 = new Answer("Przy zastosowaniu metody szeregowej wartości początkowe kolejnych zmiennych stanu są równe warunkom\n" +
                "początkowym dla zmiennej wyjścia i jej kolejnych pochodnych\n", false, mcQuestion14);
        Answer mcQuestion14Answear1 = new Answer("Gdy zmienna wejściowa w chwili t = 0 nie jest impulsem Diraca, to pomiędzy wartościami zmiennych stanu\n" +
                "zachodzi następująca relacja: x(0+) ≠ x(0-)" +
                "−)", false, mcQuestion14);
        Answer mcQuestion14Answear2 = new Answer("Przy zastosowaniu metody równoległej wartości początkowe kolejnych zmiennych stanu są równe warunkom\n" +
                "początkowym dla zmiennej wyjścia i jej kolejnych pochodnych", false, mcQuestion14);
        Answer mcQuestion14Answear3 = new Answer("Przy zastosowaniu metody ogólnej wartości początkowe kolejnych zmiennych stanu są równe warunkom\n" +
                "początkowym dla zmiennej wyjścia i jej kolejnych pochodnych", true, mcQuestion14);
        Answer mcQuestion14Answear4 = new Answer("gdy zmienna wejściowa nie zawiera impulsów Diracle’a, to granice lewo- i prawostronna warunku początkowego zmiennej stanu są sobie równe", true, mcQuestion14);
        Answer mcQuestion14Answear5 = new Answer("w metodzie kolejnych całkowań występuje jawna zależność zmiennej stanu od zmiennych: wejściowej i wyjściowej i ich pochodnych", false, mcQuestion14);
        questionsRepo.save(mcQuestion14);
        anwersRepo.save(mcQuestion14Answear0);
        anwersRepo.save(mcQuestion14Answear1);
        anwersRepo.save(mcQuestion14Answear2);
        anwersRepo.save(mcQuestion14Answear3);
        anwersRepo.save(mcQuestion14Answear4);
        anwersRepo.save(mcQuestion14Answear5);

        Question mcQuestion15 = new Question("Oceń poprawność następujących stwierdzeń dotyczących zagadnień związanych z obliczaniem\n" +
                "wartości początkowych zmiennych stanu i zmiennych wyjścia", mc);
        Answer mcQuestion15Answear0 = new Answer("Gdy zmienna wejściowa w chwili t = 0 nie jest impulsem Diraca, to pomiędzy wartościami zmiennych stanu zachodzi następująca relacja: x(0+) ≠ x(0-)", false, mcQuestion15);
        Answer mcQuestion15Answear1 = new Answer("W metodzie predyktor-korektor celem etapu predykcji jest znalezienie początkowego przybliżenia punktu Vj+1", true, mcQuestion15);
        Answer mcQuestion15Answear2 = new Answer("Przy zastosowaniu metody szeregowej wartości początkowe kolejnych zmiennych stanu są równe warunkom początkowym dla zmiennej wyjścia i jej kolejnych pochodnych\n", false, mcQuestion15);
        Answer mcQuestion15Answear3 = new Answer("Przy zastosowaniu metody ogólnej wartości początkowe kolejnych zmiennych stanu są równe warunkom\n" +
                "początkowym dla zmiennej wyjścia i jej kolejnych pochodnych", true, mcQuestion15);
        questionsRepo.save(mcQuestion15);
        anwersRepo.save(mcQuestion15Answear0);
        anwersRepo.save(mcQuestion15Answear1);
        anwersRepo.save(mcQuestion15Answear2);
        anwersRepo.save(mcQuestion15Answear3);

        Question mcQuestion16 = new Question("Formuła K(p) = k/(1+pT) opisuje operatorową funkcję przejścia", mc);
        Answer mcQuestion16Answear0 = new Answer("Elementu inercyjnego 1 rzęd", true, mcQuestion16);
        Answer mcQuestion16Answear1 = new Answer("Elementu różniczkującego z inercją", false, mcQuestion16);
        Answer mcQuestion16Answear2 = new Answer("Elementu opóźniającego", false, mcQuestion16);
        Answer mcQuestion16Answear3 = new Answer("Elementu całkującego z inercją", false, mcQuestion16);
        questionsRepo.save(mcQuestion16);
        anwersRepo.save(mcQuestion16Answear0);
        anwersRepo.save(mcQuestion16Answear1);
        anwersRepo.save(mcQuestion16Answear2);
        anwersRepo.save(mcQuestion16Answear3);

        Question mcQuestion17 = new Question("Które z poniższych formuł opisują funkcję dodatnio określoną?", mc);
        Answer mcQuestion17Answear0 = new Answer("V(x1,x2)= 2(x1)^2 - 2(x1x2) + 2(x2)^2", true, mcQuestion17);
        Answer mcQuestion17Answear1 = new Answer("V(x1,x2)= (x1)^2 - 3(x1x2) + 3(x2)^2", true, mcQuestion17);
        Answer mcQuestion17Answear2 = new Answer("V(x1,x2)= (x1)^2 - 3(x1x2) + 2(x2)^2", false, mcQuestion17);
        Answer mcQuestion17Answear3 = new Answer("V(x1,x2)= (x1)^2 - 4(x1x2) + 3(x2)^2", false, mcQuestion17);
        questionsRepo.save(mcQuestion17);
        anwersRepo.save(mcQuestion17Answear0);
        anwersRepo.save(mcQuestion17Answear1);
        anwersRepo.save(mcQuestion17Answear2);
        anwersRepo.save(mcQuestion17Answear3);

        Question mcQuestion18 = new Question("Które z poniższych formuł opisują funkcję dodatnio określoną?", mc);
        Answer mcQuestion18Answear0 = new Answer("V(x1,x2)= (x1)^2 - 4(x1x2) + 3(x2)^2", false, mcQuestion18);
        Answer mcQuestion18Answear1 = new Answer("V(x1,x2)= (x1)^2 - 3(x1x2) + 3(x2)^2", true, mcQuestion18);
        Answer mcQuestion18Answear2 = new Answer("V(x1,x2)= 1.01(x1)^2 - 2(x1x2) + (x2)^2", true, mcQuestion18);
        Answer mcQuestion18Answear3 = new Answer("V(x1,x2)= (x1)^2 - 6(x1x2) + 9(x2)^2", false, mcQuestion18);
        questionsRepo.save(mcQuestion18);
        anwersRepo.save(mcQuestion18Answear0);
        anwersRepo.save(mcQuestion18Answear1);
        anwersRepo.save(mcQuestion18Answear2);
        anwersRepo.save(mcQuestion18Answear3);

        Question mcQuestion19 = new Question("Które z poniższych formuł opisują funkcję dodatnio określoną?", mc);
        Answer mcQuestion19Answear0 = new Answer("V(x1,x2)= 2(x1)^2 - 2(x1x2) + 2(x2)^2", true, mcQuestion19);
        Answer mcQuestion19Answear1 = new Answer("V(x1,x2)= (x1)^2 - 4(x1x2) + (x2)^2", false, mcQuestion19);
        Answer mcQuestion19Answear2 = new Answer("V(x1,x2)= 9(x1)^2 - 6(x1x2) + (x2)^2", false, mcQuestion19);
        Answer mcQuestion19Answear3 = new Answer("V(x1,x2)= (x1)^2 - 3(x1x2) + 2(x2)^2", false, mcQuestion19);
        questionsRepo.save(mcQuestion19);
        anwersRepo.save(mcQuestion19Answear0);
        anwersRepo.save(mcQuestion19Answear1);
        anwersRepo.save(mcQuestion19Answear2);
        anwersRepo.save(mcQuestion19Answear3);

        Question mcQuestion20 = new Question("Zakładając warunek początkowy X0= [ 0;0 ] oraz e0 = 0 i en = 1 dla n > 0 ocenić poprawność wyliczenia wartości\n" +
                "wektora kolumnowego Xi", mc);
        Answer mcQuestion20Answear0 = new Answer("X2 = [0;1]", false, mcQuestion20);
        Answer mcQuestion20Answear1 = new Answer("X1=[0;0]", true, mcQuestion20);
        Answer mcQuestion20Answear2 = new Answer("X3=[-1;1]", false, mcQuestion20);
        Answer mcQuestion20Answear3 = new Answer("X4=[0;1]", true, mcQuestion20);
        questionsRepo.save(mcQuestion20);
        anwersRepo.save(mcQuestion20Answear0);
        anwersRepo.save(mcQuestion20Answear1);
        anwersRepo.save(mcQuestion20Answear2);
        anwersRepo.save(mcQuestion20Answear3);

        Question mcQuestion21 = new Question("Zakładając warunek początkowy X0= [ 0;0 ] oraz e0 = 0 i en = 1 dla n > 0 ocenić poprawność wyliczenia wartości\n" +
                "wektora kolumnowego Xi", mc);
        Answer mcQuestion21Answear0 = new Answer("X3=[-1;1]", true, mcQuestion21);
        Answer mcQuestion21Answear1 = new Answer("X4=[-2;0]", false, mcQuestion21);
        Answer mcQuestion21Answear2 = new Answer("X2[0;1]", true, mcQuestion21);
        Answer mcQuestion21Answear3 = new Answer("X1=[0;0]", true, mcQuestion21);
        questionsRepo.save(mcQuestion21);
        anwersRepo.save(mcQuestion21Answear0);
        anwersRepo.save(mcQuestion21Answear1);
        anwersRepo.save(mcQuestion21Answear2);
        anwersRepo.save(mcQuestion21Answear3);


        /* Pytania 25 - 34 */

        Question mcQuestion22 = new Question("Oceń poprawność następujących stwierdzeń dotyczących metod optymalizacji parametrycznej:", mc);
        Answer mcQuestion22Answear0 = new Answer("Metoda Gaussa-Seidela jest gradientową metodą kierunków poprawy", false, mcQuestion22);
        Answer mcQuestion22Answear1 = new Answer("Metoda kierunków sprzężonych Powella jest bezgradientową metodą kierunków poprawy", true, mcQuestion22);
        Answer mcQuestion22Answear2 = new Answer("Metoda simpleksu Neldera-Meada jest gradientową metodą poszukiwań prostych", false, mcQuestion22);
        Answer mcQuestion22Answear3 = new Answer("Metoda Hooka-Jeevesa jest bezgradientową metodą poszukiwań prostych", true, mcQuestion22);
        questionsRepo.save(mcQuestion22);
        anwersRepo.save(mcQuestion22Answear0);
        anwersRepo.save(mcQuestion22Answear1);
        anwersRepo.save(mcQuestion22Answear2);
        anwersRepo.save(mcQuestion22Answear3);

        Question mcQuestion23 = new Question("W modelu opartym na schemacie różnicowym Adamsa-Bashfortha 2 rzędu zamiast kroku\n" +
                "całkowania o wartości h przyjęto krok całkowania o wartości h/2. Które ze zdań jest najbardziej\n" +
                "prawdopodobne? W wyniku zmiany kroku całkowania lokalny błąd obcięcia będzie:", mc);
        Answer mcQuestion23Answear0 = new Answer("Sześć razy mniejszy", false, mcQuestion23);
        Answer mcQuestion23Answear1 = new Answer("Dwa razy mniejszy", false, mcQuestion23);
        Answer mcQuestion23Answear2 = new Answer("Osiem razy mniejszy", true, mcQuestion23);
        Answer mcQuestion23Answear3 = new Answer("Cztery razy mniejszy", false, mcQuestion23);
        questionsRepo.save(mcQuestion23);
        anwersRepo.save(mcQuestion23Answear0);
        anwersRepo.save(mcQuestion23Answear1);
        anwersRepo.save(mcQuestion23Answear2);
        anwersRepo.save(mcQuestion23Answear3    );

        Question mcQuestion24 = new Question("W prezentowanym na wykładzie modelu elementu inercyjnego pierwszego rzędu, zastosowano\n" +
                "procedurę CALKA wyznaczającą nowe wartości. Które ze sformułowań są prawdziwe:", mc);
        Answer mcQuestion24Answear0 = new Answer("Procedura CALKA wyznacza nowe, przybliżone wartości zmiennej wyjściowej yi oraz nową wartość zmiennej\n" +
                "niezależnej ti", true, mcQuestion24);
        Answer mcQuestion24Answear1 = new Answer("Procedura CALKA wyznacza nowe, przybliżone wartości zmiennych stanu xi i zmiennej wyjścia yi", false, mcQuestion24);
        Answer mcQuestion24Answear2 = new Answer("Procedura CALKA wyznacza nowe, przybliżone wartości zmiennej wyjściowej yi", false, mcQuestion24);
        Answer mcQuestion24Answear3 = new Answer("Procedura CALKA wyznacza nowe przybliżone wartości zmiennych stanu xi, ich pochodnych xi' oraz nową\n" +
                "wartość zmiennej niezależnej ti", false, mcQuestion24);
        questionsRepo.save(mcQuestion24);
        anwersRepo.save(mcQuestion24Answear0);
        anwersRepo.save(mcQuestion24Answear1);
        anwersRepo.save(mcQuestion24Answear2);
        anwersRepo.save(mcQuestion24Answear3);

        Question mcQuestion25 = new Question("Oceń poprawność następujących stwierdzeń dotyczących zagadnień związanych z obliczaniem wartości początkowych zmiennych stanu i zmiennych wyjścia", mc);
        Answer mcQuestion25Answear0 = new Answer("Przy zastosowaniu metody szeregowej wartości początkowe kolejnych zmiennych stanu są równe warunkom\n" +
                "początkowym dla zmiennej wyjścia i jej kolejnych pochodnych\n", false, mcQuestion25);
        Answer mcQuestion25Answear1 = new Answer("Gdy zmienna wejściowa w chwili t = 0 nie jest impulsem Diraca, to pomiędzy wartościami zmiennych stanu\n" +
                "zachodzi następująca relacja: x(0+) ≠ x(0-)" +
                "−)", false, mcQuestion25);
        Answer mcQuestion25Answear2 = new Answer("Przy zastosowaniu metody równoległej wartości początkowe kolejnych zmiennych stanu są równe warunkom\n" +
                "początkowym dla zmiennej wyjścia i jej kolejnych pochodnych\n", false, mcQuestion25);
        Answer mcQuestion25Answear3 = new Answer("Przy zastosowaniu metody ogólnej wartości początkowe kolejnych zmiennych stanu są równe warunkom\n" +
                "początkowym dla zmiennej wyjścia i jej kolejnych pochodnych", true, mcQuestion25);
        questionsRepo.save(mcQuestion25);
        anwersRepo.save(mcQuestion25Answear0);
        anwersRepo.save(mcQuestion25Answear1);
        anwersRepo.save(mcQuestion25Answear2);
        anwersRepo.save(mcQuestion25Answear3);

        Question mcQuestion26 = new Question("W środowisku Matlab:", mc);
        Answer mcQuestion26Answear0 = new Answer("Jednym z parametrów wejściowych funkcji ode45 jest nazwa funkcji wyznaczającej wartości pochodnych\n" +
                "wektora stanu", true, mcQuestion26);
        Answer mcQuestion26Answear1 = new Answer("Funkcja ode45 umożliwia rozwiązywanie zagadnienia początkowego", true, mcQuestion26);
        Answer mcQuestion26Answear2 = new Answer("Funkcja ode45 jest metodą całkowania numerycznego opartą na jednym ze schematów Adamsa-Bashfortha", false, mcQuestion26);
        Answer mcQuestion26Answear3 = new Answer("Jednym z parametrów wejściowych funkcji ode45 jest wektor początkowych wartości składowych wektora stanu", true, mcQuestion26);
        questionsRepo.save(mcQuestion26);
        anwersRepo.save(mcQuestion26Answear0);
        anwersRepo.save(mcQuestion26Answear1);
        anwersRepo.save(mcQuestion26Answear2);
        anwersRepo.save(mcQuestion26Answear3);

        Question mcQuestion27 = new Question("Oceń poprawność następujących stwierdzeń dotyczących metod generacji liczb pseudolosowych", mc);
        Answer mcQuestion27Answear0 = new Answer("Wygenerowanie kolejnej liczby za pomocą metody odwracania dystrybuanty wymaga jednokrotnego użycia\n" +
                "pomocniczego generatora liczb o rozkładzie równomiernym", true, mcQuestion27);
        Answer mcQuestion27Answear1 = new Answer("W ogólnym przypadku metoda eliminacji nie gwarantuje wylosowania wartości liczby pseudolosowej o\n" +
                "zadanym rozkładzie w pierwszej próbie losowania", true, mcQuestion27);
        Answer mcQuestion27Answear2 = new Answer("Metoda superpozycji może być przydatna w realizacji generatora zadanego funkcją gęstości rozkładu o\n" +
                "skomplikowanym wzorze", false, mcQuestion27);
        Answer mcQuestion27Answear3 = new Answer("Liczby o rozkładzie równomiernym na odcinku [0, 1) mogą być uzyskiwane przez zastosowanie metody\n" +
                "odwracania dystrybuanty (????????)", true, mcQuestion27);
        questionsRepo.save(mcQuestion27);
        anwersRepo.save(mcQuestion27Answear0);
        anwersRepo.save(mcQuestion27Answear1);
        anwersRepo.save(mcQuestion27Answear2);
        anwersRepo.save(mcQuestion27Answear3);

        Question mcQuestion28 = new Question("Oceń poprawność następujących stwierdzeń dotyczących metod generacji liczb pseudolosowych:?", mc);
        Answer mcQuestion28Answear0 = new Answer("Wygenerowanie kolejnej liczby pseudolosowej o rozkładzie normalnym N(0, 1) może zostać dokonane za\n" +
                "pomocą metody opartej na centralnym twierdzeniu granicznym (????????)", true, mcQuestion28);
        Answer mcQuestion28Answear1 = new Answer("Metoda superpozycji może być przydatna w realizacji generatora zadanego funkcją gęstości rozkładu, w opicie\n" +
                "której występują impulsy Diraca", true, mcQuestion28);
        Answer mcQuestion28Answear2 = new Answer("Wygenerowanie kolejnej liczby pseudolosowej o dowolnym nieobciętym rozkładzie normalnym może zostać\n" +
                "dokonane za pomocą metody eliminacji", false, mcQuestion28);
        Answer mcQuestion28Answear3 = new Answer("Wygenerowanie kolejnej liczby pseudolosowej o rozkładzie wykładniczym może zostać dokonane za pomocą\n" +
                "metody odwracania dystrybuanty", true, mcQuestion28);
        questionsRepo.save(mcQuestion28);
        anwersRepo.save(mcQuestion28Answear0);
        anwersRepo.save(mcQuestion28Answear1);
        anwersRepo.save(mcQuestion28Answear2);
        anwersRepo.save(mcQuestion28Answear3);

        Question mcQuestion29 = new Question("Oceń poprawność następujących stwierdzeń dotyczących funkcji ode45 środowiska Matlab:?", mc);
        Answer mcQuestion29Answear0 = new Answer("Umożliwia rozwiązanie zagadnienia początkowego", true, mcQuestion29);
        Answer mcQuestion29Answear1 = new Answer("Jednym z jej parametrów wejściowych jest nazwa funkcji wyznaczającej wartości pochodnych wektora stanu", true, mcQuestion29);
        Answer mcQuestion29Answear2 = new Answer("Jest metodą całkowania numerycznego opartą na jednym ze schematów Adamsa-Bashfortha", false, mcQuestion29);
        Answer mcQuestion29Answear3 = new Answer("Jednym z jej parametrów wejściowych jest wektor początkowych wartości składowych wektora st", true, mcQuestion29);
        questionsRepo.save(mcQuestion29);
        anwersRepo.save(mcQuestion29Answear0);
        anwersRepo.save(mcQuestion29Answear1);
        anwersRepo.save(mcQuestion29Answear2);
        anwersRepo.save(mcQuestion29Answear3);

        Question mcQuestion30 = new Question("Oceń poprawność następujących stwierdzeń dotyczących funkcji ode45 środowiska Matlab", mc);
        Answer mcQuestion30Answear0 = new Answer("Umożliwia rozwiązanie zagadnienia początkowego\n", true, mcQuestion30);
        Answer mcQuestion30Answear1 = new Answer("Jest metodą całkowania numerycznego opartą na schemacie Eulera Vk+1 = Vk + h * f(Vk,tk)", false, mcQuestion30);
        Answer mcQuestion30Answear2 = new Answer("Jednym z jej parametrów wejściowych jest nazwa funkcji wyznaczającej wartości pochodnych wektora stanu", true, mcQuestion30);
        Answer mcQuestion30Answear3 = new Answer("Jednym z jej parametrów wejściowych jest wektor początkowych wartości składowych wektora stanu", true, mcQuestion30);
        questionsRepo.save(mcQuestion30);
        anwersRepo.save(mcQuestion30Answear0);
        anwersRepo.save(mcQuestion30Answear1);
        anwersRepo.save(mcQuestion30Answear2);
        anwersRepo.save(mcQuestion30Answear3);

        Question mcQuestion31 = new Question("Oceń poprawność następujących stwierdzeń dotyczących szeregowej i równoległej metody\n" +
                "znajdowania równań stanu:", mc);
        Answer mcQuestion31Answear0 = new Answer("Uzyskana postać równań stanu nie musi być identyczna dla obu metod", true, mcQuestion31);
        Answer mcQuestion31Answear1 = new Answer("Metoda równoległa wymaga znajomości pierwiastków mianownika funkcji przejścia układu", true, mcQuestion31);
        Answer mcQuestion31Answear2 = new Answer("Przy zastosowaniu metody równoległej dla funkcji przejścia K(p) = (p+1)/(p^2-9) wartość współczynnika D wynosi 0", true, mcQuestion31);
        Answer mcQuestion31Answear3 = new Answer("W metodzie szeregowej sygnał wymuszenia jest zadawany na wejście każdego z połączonych ze sobą\n" +
                "szeregowo układów elementarnych", false, mcQuestion31);
        questionsRepo.save(mcQuestion31);
        anwersRepo.save(mcQuestion31Answear0);
        anwersRepo.save(mcQuestion31Answear1);
        anwersRepo.save(mcQuestion31Answear2);
        anwersRepo.save(mcQuestion31Answear3);

        Question mcQuestion32 = new Question("Koncepcja wyboru działania:\n", mc);
        Answer mcQuestion32Answear0 = new Answer("Umożliwia modelowanie systemów masowej obsługi", true, mcQuestion32);
        Answer mcQuestion32Answear1 = new Answer("Wymaga, aby w budowanym modelu cyfrowym przy każdym przesunięciu czasu zbadać możliwość\n" +
                "wystąpienia wszystkich zdarzeń czasowych i warunkowych", true, mcQuestion32);
        Answer mcQuestion32Answear2 = new Answer("Implementowana jest w programie Simnon", false, mcQuestion32);
        Answer mcQuestion32Answear3 = new Answer("Znajduje zastosowanie przy modelowaniu dowolnych układów ciągłych", false, mcQuestion32);
        questionsRepo.save(mcQuestion32);
        anwersRepo.save(mcQuestion32Answear0);
        anwersRepo.save(mcQuestion32Answear1);
        anwersRepo.save(mcQuestion32Answear2);
        anwersRepo.save(mcQuestion32Answear3);

        /* Pytania 35 - 38 */

        Question mcQuestion33 = new Question("Rozwiązaniem równań stanu o postaci x' = Ax + Bu z warunkami początkowymi x0 jest", mc);
        Answer mcQuestion33Answear0 = new Answer("e^A", true, mcQuestion33);
        Answer mcQuestion33Answear1 = new Answer("e^(-A)", false, mcQuestion33);
        Answer mcQuestion33Answear2 = new Answer("e^B", false, mcQuestion33);
        Answer mcQuestion33Answear3 = new Answer("e^(-B)", false, mcQuestion33);
        questionsRepo.save(mcQuestion33);
        anwersRepo.save(mcQuestion33Answear0);
        anwersRepo.save(mcQuestion33Answear1);
        anwersRepo.save(mcQuestion33Answear2);
        anwersRepo.save(mcQuestion33Answear3);

        Question mcQuestion34 = new Question("Oceń poprawność następujących stwierdzeń dotyczących układów i sygnałów dyskretnych:", mc);
        Answer mcQuestion34Answear0 = new Answer("Ciąg impulsów Diraca jest sygnałem o modulowanej amplitudzie", true, mcQuestion34);
        Answer mcQuestion34Answear1 = new Answer("Sygnał schodkowy jest sygnałem o modulowanej amplitudzie", true, mcQuestion34);
        Answer mcQuestion34Answear2 = new Answer("W układzie dyskretnym wszystkie sygnały mają charakter dyskretny", false, mcQuestion34);
        Answer mcQuestion34Answear3 = new Answer("Sygnał interpolacji liniowej u(t) = pojebanyWzor dla pojebanyPrzedzial jest sygnałem o modulowanej amplitudzie (??????)", false, mcQuestion34);
        questionsRepo.save(mcQuestion34);
        anwersRepo.save(mcQuestion34Answear0);
        anwersRepo.save(mcQuestion34Answear1);
        anwersRepo.save(mcQuestion34Answear2);
        anwersRepo.save(mcQuestion34Answear3);

        Question mcQuestion35 = new Question("Dany jest generator liczb losowych Xi o rozkładzie równomiernym w przedziale (-0.5, 0.5) oraz wyznaczane są liczby losowe Yi wg wzorów podanych poniżej. Wskaż, które z podanych wzorów mogą być zastosowane do generacji liczb losowych o rozkładzie normalnym N(0, 1):", mc);
        Answer mcQuestion35Answear0 = new Answer("Yi=E^12(Xi)", true, mcQuestion35);
        Answer mcQuestion35Answear1 = new Answer("Yi=E^18(Xi)", false, mcQuestion35);
        Answer mcQuestion35Answear2 = new Answer("Yi=E^6(Xi)", false, mcQuestion35);
        Answer mcQuestion35Answear3 = new Answer("Yi=E^24(Xi)", false, mcQuestion35);
        questionsRepo.save(mcQuestion35);
        anwersRepo.save(mcQuestion35Answear0);
        anwersRepo.save(mcQuestion35Answear1);
        anwersRepo.save(mcQuestion35Answear2);
        anwersRepo.save(mcQuestion35Answear3);

        Question mcQuestion36 = new Question("Oceń poprawność następujących stwierdzeń dotyczących stabilności układów liniowych ciągłych:\n", mc);
        Answer mcQuestion36Answear0 = new Answer("Kryterium Hurwitza pozwala na wyznaczenie wartości pierwiastków "
                + "równania charakterystycznego\n", false, mcQuestion36);
        Answer mcQuestion36Answear1 = new Answer("Jeśli pierwiastki równania charakterystycznego układu mają części "
                + "rzeczywiste mniejsze od zera, to układ jest stabilny asymptotycznie\n", true, mcQuestion36);
        Answer mcQuestion36Answear2 = new Answer("Dla układu dynamicznego opisanego równaniem 7y′′ + 2y′ + 3y = 0 "
                + "wyznacznik ∆2 z kryterium Hurwitza jest wyrażony następująco:|2 0 ; 7 3 |", true, mcQuestion36);
        Answer mcQuestion36Answear3 = new Answer("Dla układu dynamicznego opisanego równaniem 2y′′ + 3y′ + 4y = 0 "
                + "wyznacznik ∆2 z kryterium Hurwitza jest wyrażony następująco: | 0 3 ; 2 4|", false, mcQuestion36);
        questionsRepo.save(mcQuestion36);
        anwersRepo.save(mcQuestion36Answear0);
        anwersRepo.save(mcQuestion36Answear1);
        anwersRepo.save(mcQuestion36Answear2);
        anwersRepo.save(mcQuestion36Answear3);

        /* Ulciorek */
        Question mcQuestion37 = new Question("Oceń poprawność następujących stwierdzeń dla dowolnego modelu układu "
                + "zdarzeń dyskretnych zbudowanego według koncepcji planowania zdarzeń:", mc);
        Answer mcQuestion37Answear0 = new Answer("wykrycie przez procedurę kontroli symulacji pustego zbioru "
                + "zaplanowanych zdarzeń w trakcie realizacji eksperymentu oznacza, że aktualny stan układu jest ostateczny", true, mcQuestion37);
        Answer mcQuestion37Answear1 = new Answer("planowanie dotyczy zarówno tego, co będzie odbywać się w przyszłości, jak i przeszłości", false, mcQuestion37);
        Answer mcQuestion37Answear2 = new Answer("mechanizmem upływu czasu symulacyjnego steruje procedura kontroli symulacji", true, mcQuestion37);
        Answer mcQuestion37Answear3 = new Answer("zaplanowanie zdarzenia wymaga między innymi obliczenia chwili zajścia tego zdarzenia", true, mcQuestion37);
        questionsRepo.save(mcQuestion37);
        anwersRepo.save(mcQuestion37Answear0);
        anwersRepo.save(mcQuestion37Answear1);
        anwersRepo.save(mcQuestion37Answear2);
        anwersRepo.save(mcQuestion37Answear3);

        Question mcQuestion38 = new Question("Oceń poprawność następujących stwierdzeń dotyczących schematów różnicowych:", mc);
        Answer mcQuestion38Answear0 = new Answer("w schematach jednokrokowych kolejne przybliżenie rozwiązania tk+1, "
                + "vk+1 zależy od wartości vk i pochodnej f w otoczeniu tk, vk (????)", true, mcQuestion38);
        Answer mcQuestion38Answear1 = new Answer("funkcja f występująca we wzorach schematów różnicowych jest prawą stroną równania stanu", true, mcQuestion38);
        Answer mcQuestion38Answear2 = new Answer("schemat różnicowy o postaci vj+1 = F(vj+1, vj, … , vj-p, tj) jest "
                + "schematem jawnym", false, mcQuestion38);
        Answer mcQuestion38Answear3 = new Answer("metody Rungego-Kutty są przykładami metod jednokrokowych", true, mcQuestion38);
        questionsRepo.save(mcQuestion38);
        anwersRepo.save(mcQuestion38Answear0);
        anwersRepo.save(mcQuestion38Answear1);
        anwersRepo.save(mcQuestion38Answear2);
        anwersRepo.save(mcQuestion38Answear3);

        Question mcQuestion39 = new Question("W środowisku Matlab/Simulink funkcja sim umożliwia", mc);
        Answer mcQuestion39Answear0 = new Answer("rozwiązanie zagadnienia początkowego dla układów dyskretnych", true, mcQuestion39);
        Answer mcQuestion39Answear1 = new Answer("rozwiązanie zagadnienia optymalizacji parametrycznej", false, mcQuestion39);
        Answer mcQuestion39Answear2 = new Answer("rozwiązanie zagadnienia początkowego dla układów ciągłych", true, mcQuestion39);
        Answer mcQuestion39Answear3 = new Answer("wyznaczenie czasowej funkcji przejścia", false, mcQuestion39);
        questionsRepo.save(mcQuestion39);
        anwersRepo.save(mcQuestion39Answear0);
        anwersRepo.save(mcQuestion39Answear1);
        anwersRepo.save(mcQuestion39Answear2);
        anwersRepo.save(mcQuestion39Answear3);

        Question mcQuestion40 = new Question("Oceń poprawność następujących stwierdzeń dotyczących zadania optymalizacji parametrycznej", mc);
        Answer mcQuestion40Answear0 = new Answer("zadanie dwugraniczne jest przykładem zadania optymalizacji parametrycznej", true, mcQuestion40);
        Answer mcQuestion40Answear1 = new Answer("parametrami optymalizacji nie mogą być warunki początkowe zmiennych stanu", false, mcQuestion40);
        Answer mcQuestion40Answear2 = new Answer("w zadaniach optymalizacji parametrycznej szukamy takich optymalnych"
                + " wartości parametrów α, by wskaźnik jakości przyjął wartość minimalną", true, mcQuestion40);
        Answer mcQuestion40Answear3 = new Answer("szukanie maksymalnej wartości wskaźnika jakości można zastąpić "
                + "szukaniem minimalnej wartości wskaźnika pomnożonego przez -1", true, mcQuestion40);
        questionsRepo.save(mcQuestion40);
        anwersRepo.save(mcQuestion40Answear0);
        anwersRepo.save(mcQuestion40Answear1);
        anwersRepo.save(mcQuestion40Answear2);
        anwersRepo.save(mcQuestion40Answear3);

        Question mcQuestion41 = new Question("Oceń poprawność następujących stwierdzeń dla dowolnego modelu układu "
                + "zdarzeń dyskretnych zbudowanego według koncepcji planowania zdarzeń", mc);
        Answer mcQuestion41Answear0 = new Answer("można planować zdarzenia odbywające się w przeszłości", false, mcQuestion41);
        Answer mcQuestion41Answear1 = new Answer("zaplanowanie zdarzenia wymaga między innymi obliczenia chwili zajścia tego zdarzenia", true, mcQuestion41);
        Answer mcQuestion41Answear2 = new Answer("mechanizmem upływu czasu symulacyjnego steruje procedura kontroli symulacji", true, mcQuestion41);
        Answer mcQuestion41Answear3 = new Answer("obecność elementów w zbiorze zaplanowanych zdarzeń po zakończeniu "
                + "realizacji eksperymentu oznacza, że eksperyment zakończył się w sposób nieprawidłowy (błędny)", false, mcQuestion41);
        questionsRepo.save(mcQuestion41);
        anwersRepo.save(mcQuestion41Answear0);
        anwersRepo.save(mcQuestion41Answear1);
        anwersRepo.save(mcQuestion41Answear2);
        anwersRepo.save(mcQuestion41Answear3);

        Question mcQuestion42 = new Question("Oceń poprawność poniższych stwierdzeń związanych z opisem w postaci równań stanu", mc);
        Answer mcQuestion42Answear0 = new Answer("dla danego układu istnieje tylko jeden opis za pomocą równań stanu", false, mcQuestion42);
        Answer mcQuestion42Answear1 = new Answer("równania stanu można stosować zarówno do opisu układów liniowych, jak i nieliniowych", true, mcQuestion42);
        Answer mcQuestion42Answear2 = new Answer("w równaniu stanu nie występuje zależność od pochodnych sygnału wejściowego", true, mcQuestion42);
        Answer mcQuestion42Answear3 = new Answer("równania stanu są równaniami różniczkowymi", true, mcQuestion42);
        questionsRepo.save(mcQuestion42);
        anwersRepo.save(mcQuestion42Answear0);
        anwersRepo.save(mcQuestion42Answear1);
        anwersRepo.save(mcQuestion42Answear2);
        anwersRepo.save(mcQuestion42Answear3);

        /* */

        Question mcQuestion43 = new Question("Oceń poprawność następujących stwierdzeń dotyczących metody eliminacji:", mc);
        Answer mcQuestion43Answear0 = new Answer("nie może być wykorzystywana do generacji liczb o dowolnym nieobciętym rozkładzie\n" +
                "normalnym", true, mcQuestion43);
        Answer mcQuestion43Answear1 = new Answer("jest zawsze bardziej efektywna od metody odwracania dystrybuanty", false, mcQuestion43);
        Answer mcQuestion43Answear2 = new Answer("umożliwia wygenerowanie kolejnej liczby zawsze przy jednokrotnym użyciu pomocniczego generatora liczb o rozkładzie równomiernym", false, mcQuestion43);
        Answer mcQuestion43Answear3 = new Answer("znajduje zastosowanie w przypadku, gdy funkcja gęstości rozkładu nie jest ograniczona", false, mcQuestion43);
        questionsRepo.save(mcQuestion43);
        anwersRepo.save(mcQuestion43Answear0);
        anwersRepo.save(mcQuestion43Answear1);
        anwersRepo.save(mcQuestion43Answear2);
        anwersRepo.save(mcQuestion43Answear3);

        Question mcQuestion44 = new Question("Oceń poprawność następujących stwierdzeń dotyczących schematów różnicowych", mc);
        Answer mcQuestion44Answear0 = new Answer("w ramach metody predyktor-korektor najpierw wykonywana jest metoda zamknięta,potem otwarta", false, mcQuestion44);
        Answer mcQuestion44Answear1 = new Answer("metody zamknięte wymagają rozwiązywania równania algebraicznego w każdym kroku", true, mcQuestion44);
        Answer mcQuestion44Answear2 = new Answer("w metodzie predyktor-korektor celem etapu korekcji jest znalezienie początkowego\n" +
                "przybliżenia punktu vj+1", true, mcQuestion44);
        Answer mcQuestion44Answear3 = new Answer("metody otwarte charakteryzują się większą dokładnością od metod zamkniętych", false, mcQuestion44);
        questionsRepo.save(mcQuestion44);
        anwersRepo.save(mcQuestion44Answear0);
        anwersRepo.save(mcQuestion44Answear1);
        anwersRepo.save(mcQuestion44Answear2);
        anwersRepo.save(mcQuestion44Answear3);

        Question mcQuestion45 = new Question("Oceń poprawność następujących stwierdzeń dotyczących metody kolejnych całkowań", mc);
        Answer mcQuestion45Answear0 = new Answer("może być stosowana do wyznaczania równań stanu zarówno układów liniowych jak i nieliniowych", true, mcQuestion45);
        Answer mcQuestion45Answear1 = new Answer("wartości początkowe kolejnych zmiennych stanu są równe warunkiem początkowym dla zmiennej wyjścia i jej kolejnych pochodnych", false, mcQuestion45);
        Answer mcQuestion45Answear2 = new Answer("jest jedną z metod wchodzących w skład metody mieszanej", true, mcQuestion45);
        Answer mcQuestion45Answear3 = new Answer("znajduje zastosowanie w przypadku, gdy występuje pochodna zmiennej wejściowej", true, mcQuestion45);
        questionsRepo.save(mcQuestion45);
        anwersRepo.save(mcQuestion45Answear0);
        anwersRepo.save(mcQuestion45Answear1);
        anwersRepo.save(mcQuestion45Answear2);
        anwersRepo.save(mcQuestion45Answear3);

        Question mcQuestion46 = new Question("Oceń poprawność następujących stwierdzeń dotyczących metod badania stabilności układów liniowych", mc);
        Answer mcQuestion46Answear0 = new Answer("warunkiem stabilności asymptotycznej układu dyskretnego jest by pierwiastek równania charakterystycznego układu leżały na płaszczyźnie zespolonej we wnętrzu koła o środku w środku układu współrzędnych i o promieniu 1", true, mcQuestion46);
        Answer mcQuestion46Answear1 = new Answer("warunkiem stabilności asymptotycznej układu ciągłego jest by pierwiastek równania charakterystycznego układu posiadały części rzeczywiste mniejsze od jedności\n", false, mcQuestion46);
        Answer mcQuestion46Answear2 = new Answer("kryterium Hurwitza pozwala na określenie stabilności układu ciągłego bez konieczności wyznaczania dokładnych wartości pierwiastków równania charakterystycznego układu", true, mcQuestion46);
        Answer mcQuestion46Answear3 = new Answer("kryterium Hurwitza pozwala na obliczenie dokładnej wartości pierwiastków równania charakterystycznego układu ciągłego", false, mcQuestion46);
        Answer mcQuestion46Answear4 = new Answer("kryterium Hurwitza pozwala na obliczenie dokładnej wartości pierwiastków równania charakterystycznego układu dyskretnego", false, mcQuestion46);
        questionsRepo.save(mcQuestion46);
        anwersRepo.save(mcQuestion46Answear0);
        anwersRepo.save(mcQuestion46Answear1);
        anwersRepo.save(mcQuestion46Answear2);
        anwersRepo.save(mcQuestion46Answear3);
        anwersRepo.save(mcQuestion46Answear4);

        Question mcQuestion47 = new Question("Oceń poprawność następujących stwierdzeń dotyczących środowiska R", mc);
        Answer mcQuestion47Answear0 = new Answer("polecenie a[-5] utworzy wektor zawierający elementy wektora a z wyjątkiem elementu piątego", false, mcQuestion47);
        Answer mcQuestion47Answear1 = new Answer("dwa wektory można dodać do siebie tylko wtedy, kiedy oba mają identyczną długość", true, mcQuestion47);
        Answer mcQuestion47Answear2 = new Answer("jeśli funkcja ma zwrócić kilka różnych wartości, to należy z nich utworzyć listę", true, mcQuestion47);
        Answer mcQuestion47Answear3 = new Answer("funkcja lines tworzy nowe okno dla wykresu", false, mcQuestion47);
        questionsRepo.save(mcQuestion47);
        anwersRepo.save(mcQuestion47Answear0);
        anwersRepo.save(mcQuestion47Answear1);
        anwersRepo.save(mcQuestion47Answear2);
        anwersRepo.save(mcQuestion47Answear3);

        Question mcQuestion48 = new Question("Oceń poprawność poniższych stwierdzeń związanych z opisem w postaci równań stanu", mc);
        Answer mcQuestion48Answear0 = new Answer("układ autonomiczny to układ, w których nie występuje oddziaływanie środowiska w\n" +
                "postaci sygnału wejściowego", true, mcQuestion48);
        Answer mcQuestion48Answear1 = new Answer("w układzie zdarzeń dyskretnych zmiany stanu zachodzą w dyskretnych\n" +
                "równoodległych chwilach czasu", false, mcQuestion48);
        Answer mcQuestion48Answear2 = new Answer("w układzie nieliniowym obowiązuje zasada superpozycji", false, mcQuestion48);
        Answer mcQuestion48Answear3 = new Answer("w układzie dynamicznym sygnał wyjściowy zależy tylko od aktualnej wartości\n" +
                "sygnału wejściowego", false, mcQuestion48);
        questionsRepo.save(mcQuestion48);
        anwersRepo.save(mcQuestion48Answear0);
        anwersRepo.save(mcQuestion48Answear1);
        anwersRepo.save(mcQuestion48Answear2);
        anwersRepo.save(mcQuestion48Answear3);

        Question mcQuestion49 = new Question("Koncepcja planowania zdarzeń", mc);
        Answer mcQuestion49Answear0 = new Answer("pozwala na planowanie zdarzeń, które stanowią ingerencję w przeszłość układu", false, mcQuestion49);
        Answer mcQuestion49Answear1 = new Answer("dopuszcza możliwość wystąpienia kilku zdarzeń w tej samej chwili czasu\n" +
                "symulacyjnego", true, mcQuestion49);
        Answer mcQuestion49Answear2 = new Answer("pozwala na planowanie zdarzeń, które wystąpią w przyszłości", true, mcQuestion49);
        Answer mcQuestion49Answear3 = new Answer("pozwala na planowanie zdarzeń, które wystąpią dla aktualnej wartości czasu\n" +
                "symulacyjnego", true, mcQuestion49);
        questionsRepo.save(mcQuestion49);
        anwersRepo.save(mcQuestion49Answear0);
        anwersRepo.save(mcQuestion49Answear1);
        anwersRepo.save(mcQuestion49Answear2);
        anwersRepo.save(mcQuestion49Answear3);

        //

        Question mcQuestion50 = new Question("W pakiecie SimEvents port wejściowy obiektów w danym bloku może zostać chwilowo\n" +
                "zablokowany w trakcie symulacji. Sytuacja ta może wystąpić", mc);
        Answer mcQuestion50Answear0 = new Answer("w bloku Entity Server/Capacity=1 (1-kanałowe stanowisko obsługi)", true, mcQuestion50);
        Answer mcQuestion50Answear1 = new Answer("w bloku Entity Queue z kolejką o skończonej długości", true, mcQuestion50);
        Answer mcQuestion50Answear2 = new Answer("w bloku Entity Server/Capacity=Inf (nieskończenie wielokanałowe stanowisko\n" +
                "obslugi)", false, mcQuestion50);
        Answer mcQuestion50Answear3 = new Answer("w bloku Entity Queue z kolejką o nieograniczonej długości", false, mcQuestion50);
        questionsRepo.save(mcQuestion50);
        anwersRepo.save(mcQuestion50Answear0);
        anwersRepo.save(mcQuestion50Answear1);
        anwersRepo.save(mcQuestion50Answear2);
        anwersRepo.save(mcQuestion50Answear3);

        Question mcQuestion51 = new Question("Oceń poprawność następujących stwierdzeń dotyczących algorytmu Ziggurat", mc);
        Answer mcQuestion51Answear0 = new Answer("wykorzystuje metodę odwracania dystrybuanty", false, mcQuestion51);
        Answer mcQuestion51Answear1 = new Answer("wykorzystuje metodę superpozycji rozkładów", false, mcQuestion51);
        Answer mcQuestion51Answear2 = new Answer("wykorzystuje twierdzenie graniczne", false, mcQuestion51);
        Answer mcQuestion51Answear3 = new Answer("wykorzystuje metodę eliminacji", true, mcQuestion51);
        questionsRepo.save(mcQuestion51);
        anwersRepo.save(mcQuestion51Answear0);
        anwersRepo.save(mcQuestion51Answear1);
        anwersRepo.save(mcQuestion51Answear2);
        anwersRepo.save(mcQuestion51Answear3);

        Question mcQuestion52 = new Question("Oceń poprawność następujących stwierdzeń dotyczących warunków stabilności\n" +
                "układów liniowych dyskretnych", mc);
        Answer mcQuestion52Answear0 = new Answer("na płaszczyźnie zespolonej przekształcenie p =  η−1/η+1 odwzorowuje punkty półpłaszczyzny η w punkty koła p", false, mcQuestion52);
        Answer mcQuestion52Answear1 = new Answer("na płaszczyźnie zespolonej przekształcenie p =  η−1/η+1 odwzorowuje punkty półpłaszczyzny η w punkty półpłaszczyzny p", true, mcQuestion52);
        Answer mcQuestion52Answear2 = new Answer("jeśli równanie charakterystyczne ma pierwiastki mniejsze lub równe jeden, to układ\n" +
                "jest stabilny", false, mcQuestion52);
        Answer mcQuestion52Answear3 = new Answer("jeśli równanie charakterystyczne ma pierwiastki większe od zera, to układ jest\n" +
                "niestabilny", false, mcQuestion52);
        questionsRepo.save(mcQuestion52);
        anwersRepo.save(mcQuestion52Answear0);
        anwersRepo.save(mcQuestion52Answear1);
        anwersRepo.save(mcQuestion52Answear2);
        anwersRepo.save(mcQuestion52Answear3);

        Question mcQuestion53 = new Question("Oceń poprawność następujących stwierdzeń dotyczących metod generacji i liczb\n" +
                "pseudolosowych", mc);
        Answer mcQuestion53Answear0 = new Answer("metoda superpozycji może być przydatna w realizacji generatora zadanego funkcją\n" +
                "gęstości rozkładu o skomplikowanym kształcie", false, mcQuestion53);
        Answer mcQuestion53Answear1 = new Answer("metoda odwracania dystrybuanty znajduje zastosowanie dla generowania liczb o\n" +
                "rozkładzie równomiernym", true, mcQuestion53);
        Answer mcQuestion53Answear2 = new Answer("wygenerowanie kolejnej liczby za pomocą metody odwracania dystrybuanty wymaga\n" +
                "jednokrotnego użycia pomocniczego generatora liczb o rozkładzie równomiernym", true, mcQuestion53);
        Answer mcQuestion53Answear3 = new Answer("metoda eliminacji znajduje zastosowanie w przypadku, gdy funkcja gęstości rozkładu\n" +
                "nie jest ograniczona", false, mcQuestion53);
        questionsRepo.save(mcQuestion53);
        anwersRepo.save(mcQuestion53Answear0);
        anwersRepo.save(mcQuestion53Answear1);
        anwersRepo.save(mcQuestion53Answear2);
        anwersRepo.save(mcQuestion53Answear3);

        Question mcQuestion54 = new Question("Oceń poprawność następujących stwierdzeń dotyczących rozwiązywania zadań\n" +
                "optymalizacji parametrycznej w środowisku Matlab/Simulink", mc);
        Answer mcQuestion54Answear0 = new Answer("funkcja fminunc umożliwia rozwiązywanie zadań optymalizacji parametrycznej bez\n" +
                "ograniczeń", true, mcQuestion54);
        Answer mcQuestion54Answear1 = new Answer("musi być określona funkcja wyznaczania pochodnych wektora stanu", true, mcQuestion54);
        Answer mcQuestion54Answear2 = new Answer("funkcja fminsearch implementuje algorytm Gaussa-Seidela wyznaczania minimum\n" +
                "funkcji", false, mcQuestion54);
        Answer mcQuestion54Answear3 = new Answer("musi być określona funkcja wyznaczania wartości wskaźnika jakości dla aktualnych\n" +
                "wartości wektora parametrów optymalizacji; funkcja ta dodatkowo może wyznaczać\n" +
                "składowe gradientu", true, mcQuestion54);
        questionsRepo.save(mcQuestion54);
        anwersRepo.save(mcQuestion54Answear0);
        anwersRepo.save(mcQuestion54Answear1);
        anwersRepo.save(mcQuestion54Answear2);
        anwersRepo.save(mcQuestion54Answear3);

        Question mcQuestion55 = new Question(" Metoda Euler jest metodą całkowania numerycznego, która", mc);
        Answer mcQuestion55Answear0 = new Answer("w środowiskach MATLAB i R została zaimplementowana w funkcji ode45", false, mcQuestion55);
        Answer mcQuestion55Answear1 = new Answer("jest metodą wielokrokową", false, mcQuestion55);
        Answer mcQuestion55Answear2 = new Answer("jest opisana schematem różnicowym vk+1 = vk + h * f (vk,tk)", true, mcQuestion55);
        Answer mcQuestion55Answear3 = new Answer("nie wymaga znajomości wartości początkowych zmiennych stanu", false, mcQuestion55);
        questionsRepo.save(mcQuestion55);
        anwersRepo.save(mcQuestion55Answear0);
        anwersRepo.save(mcQuestion55Answear1);
        anwersRepo.save(mcQuestion55Answear2);
        anwersRepo.save(mcQuestion55Answear3);

        Question mcQuestion56 = new Question("Operacja wywłaszczania dostępna jest w następujących blokach pakietu SimEvents", mc);
        Answer mcQuestion56Answear0 = new Answer("Entity Server/Capacity=1", true, mcQuestion56);
        Answer mcQuestion56Answear1 = new Answer("Entity Queue", false, mcQuestion56);
        Answer mcQuestion56Answear2 = new Answer("Entity Output Switch", false, mcQuestion56);
        Answer mcQuestion56Answear3 = new Answer("Entity Input Switch", false, mcQuestion56);
        questionsRepo.save(mcQuestion56);
        anwersRepo.save(mcQuestion56Answear0);
        anwersRepo.save(mcQuestion56Answear1);
        anwersRepo.save(mcQuestion56Answear2);
        anwersRepo.save(mcQuestion56Answear3);

        Question mcQuestion57 = new Question("Wskaż, które z wymienionych zagadnień stanowią przykłady zadań optymalizacji\n" +
                "parametrycznej", mc);
        Answer mcQuestion57Answear0 = new Answer("generacja liczby pseudolosowej o zadanym rozkładzie (?????)", false, mcQuestion57);
        Answer mcQuestion57Answear1 = new Answer("zagadnienie początkowe (Cauchy’ego)", false, mcQuestion57);
        Answer mcQuestion57Answear2 = new Answer("zadanie dwugraniczne", true, mcQuestion57);
        Answer mcQuestion57Answear3 = new Answer("strojenie modelu", true, mcQuestion57);
        questionsRepo.save(mcQuestion57);
        anwersRepo.save(mcQuestion57Answear0);
        anwersRepo.save(mcQuestion57Answear1);
        anwersRepo.save(mcQuestion57Answear2);
        anwersRepo.save(mcQuestion57Answear3);

        Question mcQuestion58 = new Question("Koncepcja planowania zdarzeń", mc);
        Answer mcQuestion58Answear0 = new Answer("pozwala na planowanie zdarzeń, które stanowią ingerencję w przeszłość układu", false, mcQuestion58);
        Answer mcQuestion58Answear1 = new Answer("dopuszcza możliwość wystąpienia kilku zdarzeń w tej samej chwili czasu\n" +
                "symulacyjnego", true, mcQuestion58);
        Answer mcQuestion58Answear2 = new Answer("pozwala na planowanie zdarzeń, które wystąpią w przyszłości", true, mcQuestion58);
        Answer mcQuestion58Answear3 = new Answer("pozwala na planowanie zdarzeń, które wystąpią dla aktualnej wartości czasu\n" +
                "symulacyjnego", true, mcQuestion58);
        questionsRepo.save(mcQuestion58);
        anwersRepo.save(mcQuestion58Answear0);
        anwersRepo.save(mcQuestion58Answear1);
        anwersRepo.save(mcQuestion58Answear2);
        anwersRepo.save(mcQuestion58Answear3);

        Question mcQuestion59 = new Question("W pakiecie SimEvents do budowy modelu wykorzystywane są:", mc);
        Answer mcQuestion59Answear0 = new Answer("Koncepcje inreakcji procesów”", true, mcQuestion59);
        Answer mcQuestion59Answear1 = new Answer("Ciągłe równania stanu", false, mcQuestion59);
        Answer mcQuestion59Answear2 = new Answer("Dyskretne równania stanu", false, mcQuestion59);
        Answer mcQuestion59Answear3 = new Answer("Koncepcja planowania zdarzeń", false, mcQuestion59);
        questionsRepo.save(mcQuestion59);
        anwersRepo.save(mcQuestion59Answear0);
        anwersRepo.save(mcQuestion59Answear1);
        anwersRepo.save(mcQuestion59Answear2);
        anwersRepo.save(mcQuestion59Answear3);

        Question mcQuestion60 = new Question("Wskaż poprawnie dobrane pary (koncepcja modelowania - narzędzie modelowania)", mc);
        Answer mcQuestion60Answear0 = new Answer("koncepcja interakcji procesów - CSL++", false, mcQuestion60);
        Answer mcQuestion60Answear1 = new Answer("koncepcja wyboru działania - SimEvents", false, mcQuestion60);
        Answer mcQuestion60Answear2 = new Answer("koncepcja planowania zdarzeń - OMNeT++", true, mcQuestion60);
        Answer mcQuestion60Answear3 = new Answer("koncepcja wyboru działania - CSL++", true, mcQuestion60);
        questionsRepo.save(mcQuestion60);
        anwersRepo.save(mcQuestion60Answear0);
        anwersRepo.save(mcQuestion60Answear1);
        anwersRepo.save(mcQuestion60Answear2);
        anwersRepo.save(mcQuestion60Answear3);

        Question mcQuestion61 = new Question("Wartość zmiennej losowej Y o rozkładzie normalnym N(u,o) o średniej u i odchyleniu standardowym o uzyskiwana jest na podstawie wartości zmiennej losowej X1 o standardowym rozkładzie normalnym N(0,1) za pomocą przekształcenia (odp wlasna)", mc);
        Answer mcQuestion61Answear0 = new Answer("Y = u*X+o", true, mcQuestion61);
        Answer mcQuestion61Answear1 = new Answer("Y = (u-o)*N+u", false, mcQuestion61);
        Answer mcQuestion61Answear2 = new Answer("Y = (u-o)*N+o", false, mcQuestion61);
        Answer mcQuestion61Answear3 = new Answer("Y = o*N+u", true, mcQuestion61);
        questionsRepo.save(mcQuestion61);
        anwersRepo.save(mcQuestion61Answear0);
        anwersRepo.save(mcQuestion61Answear1);
        anwersRepo.save(mcQuestion61Answear2);
        anwersRepo.save(mcQuestion61Answear3);

        Question mcQuestion62 = new Question("Wskaż poprawne stwierdzenia dotyczące charakterystyki metod związanych z obsługą komunikatów w środowisku OMNeT++ (odp wlasne)", mc);
        Answer mcQuestion62Answear0 = new Answer("w dowolnej chwili czasu symulacyjnego wywołanie o postaci scheduleAt(0,msg) spowoduje natychmiastowe nadejście komunikatu sterującego msg", false, mcQuestion62);
        Answer mcQuestion62Answear1 = new Answer("metoda sendDelayed powoduje dotarcie wysłanego komunikatu z modułu docelowego z opóźnieniem będącym jednym z parametrów wywołania metody", true, mcQuestion62);
        Answer mcQuestion62Answear2 = new Answer("metoda handleMessage sygnalizuje nadejście zarówno komunikatów sterujących jak i nadesłanych przez inny moduł", true, mcQuestion62);
        Answer mcQuestion62Answear3 = new Answer("metoda cancelEvent służy do usunięcia komunikatu sterującego ze zbioru przyszłych zdarzeń (FES)", true, mcQuestion62);
        questionsRepo.save(mcQuestion62);
        anwersRepo.save(mcQuestion62Answear0);
        anwersRepo.save(mcQuestion62Answear1);
        anwersRepo.save(mcQuestion62Answear2);
        anwersRepo.save(mcQuestion62Answear3);

        Question mcQuestion63 = new Question("Wskaż sformułowania poprawnie określające operatorową funkcję przejścia", mc);
        Answer mcQuestion63Answear0 = new Answer("iloraz transformaty Laplace'a sygnału wyjściowego do transformaty Laplace'a sygnału wejściowego przy dowolnych warunkach początkowych", false, mcQuestion63);
        Answer mcQuestion63Answear1 = new Answer("iloraz transformaty Laplace'a-Carsona sygnału wyjściowego do transformaty Laplace'a-Carsona sygnału wejściowego przy dowolnych zerowych początkowych", true, mcQuestion63);
        Answer mcQuestion63Answear2 = new Answer("iloraz transformaty Laplace'a-Carsona sygnału wejściowego do transformaty Laplace'a-Carsona sygnału wejściowego przy zerowych początkowych", false, mcQuestion63);
        Answer mcQuestion63Answear3 = new Answer("iloraz transformaty Laplace'a sygnału wyjściowego do transformaty Laplace'a sygnału wejściowego przy zerowych początkowych", true, mcQuestion63);
        questionsRepo.save(mcQuestion63);
        anwersRepo.save(mcQuestion63Answear0);
        anwersRepo.save(mcQuestion63Answear1);
        anwersRepo.save(mcQuestion63Answear2);
        anwersRepo.save(mcQuestion63Answear3);

        Question mcQuestion64 = new Question("Wskaż poprawne stwierdzenia dotyczące charakterystyki układów dynamicznych (odp wlasne)", mc);
        Answer mcQuestion64Answear0 = new Answer("w układzie zdarzeń dyskretnych odstęp czasowy między kolejnymi zdarzeniami jest stały", false, mcQuestion64);
        Answer mcQuestion64Answear1 = new Answer("w układzie autonomicznym występuje oddziaływanie środowiska w postaci sygnału wejściowego", false, mcQuestion64);
        Answer mcQuestion64Answear2 = new Answer("w układzie liniowym obowiązuje zasada superpozycji", true, mcQuestion64);
        Answer mcQuestion64Answear3 = new Answer("w układzie dyskretnycm co najmniej jeden z sygnałów opisujących działanie układu ma charakter dyskretny", true, mcQuestion64);
        questionsRepo.save(mcQuestion64);
        anwersRepo.save(mcQuestion64Answear0);
        anwersRepo.save(mcQuestion64Answear1);
        anwersRepo.save(mcQuestion64Answear2);
        anwersRepo.save(mcQuestion64Answear3);

        Question mcQuestion65 = new Question("Wskaż poprawne stwierdzenia dotyczące zadania optymalizacji parametrycznej (???)", mc);
        Answer mcQuestion65Answear0 = new Answer("metoda Hooke'a-Jevesa należy do metod bezgradientowych", true, mcQuestion65);
        Answer mcQuestion65Answear1 = new Answer("w zadaniu dwugranicznym i w zadaniu wartości własnych konstrukcja funkcji wskaźnika jakości opiera się na iloczynie skalarnym(?)", false, mcQuestion65);
        Answer mcQuestion65Answear2 = new Answer("metoda współczynników wrażliwości służy do wyznaczania składowych gradientu wskaźnika jakości(?)", true, mcQuestion65);
        Answer mcQuestion65Answear3 = new Answer("metoda Gaussa-Seidela należy do metod gradientowych", true, mcQuestion65);
        questionsRepo.save(mcQuestion65);
        anwersRepo.save(mcQuestion65Answear0);
        anwersRepo.save(mcQuestion65Answear1);
        anwersRepo.save(mcQuestion65Answear2);
        anwersRepo.save(mcQuestion65Answear3);

        Question mcQuestion66 = new Question("Wskaż poprawne stwierdzenia dotyczące biblioteki CSL++ (???)", mc);
        Answer mcQuestion66Answear0 = new Answer("dodatnia wartość (stan) zegara związanego z danym zdarzeniem oznacza, że to zdarzenie już miało miejsce i zarazem wskazuje, ile czasu upłynęło od jego zajścia", true, mcQuestion66);
        Answer mcQuestion66Answear1 = new Answer("za aktualizację zegarów odpowiada funkcja SimTime()", false, mcQuestion66);
        Answer mcQuestion66Answear2 = new Answer("stan zegarów związanych ze zdarzeniami są z upływam czasu zmniejszane", false, mcQuestion66);
        Answer mcQuestion66Answear3 = new Answer("jest implementacją koncepcji interakcji procesów", false, mcQuestion66);
        questionsRepo.save(mcQuestion66);
        anwersRepo.save(mcQuestion66Answear0);
        anwersRepo.save(mcQuestion66Answear1);
        anwersRepo.save(mcQuestion66Answear2);
        anwersRepo.save(mcQuestion66Answear3);

        Question mcQuestion67 = new Question("Wartość zmiennej losowej Y o rozkładzie równomiernym na przedziale [a,b) uzyskiwana jest na podstawie wartości zmiennej losowej X o rozkładzie równomiernym na przedziale [0,1) za pomocą przekształcenia (odp wlasna)", mc);
        Answer mcQuestion67Answear0 = new Answer("Y = (b-a)*X+a", true, mcQuestion67);
        Answer mcQuestion67Answear1 = new Answer("Y = b*X+a", false, mcQuestion67);
        Answer mcQuestion67Answear2 = new Answer("Y = a*X+b", true, mcQuestion67);
        Answer mcQuestion67Answear3 = new Answer("Y = (b-a)*X+b", false, mcQuestion67);
        questionsRepo.save(mcQuestion67);
        anwersRepo.save(mcQuestion67Answear0);
        anwersRepo.save(mcQuestion67Answear1);
        anwersRepo.save(mcQuestion67Answear2);
        anwersRepo.save(mcQuestion67Answear3);

        Question mcQuestion68 = new Question("Które z poniższych formuł opisują funkcję dodatnio określoną (odp wlasna)", mc);
        Answer mcQuestion68Answear0 = new Answer("V(x1,x2)= (x1)^2 + (x2)^4", true, mcQuestion68);
        Answer mcQuestion68Answear1 = new Answer("V(x1,x2)= (x1+x2)^2", false, mcQuestion68);
        Answer mcQuestion68Answear2 = new Answer("V(x1,x2)= (x1x2)", false, mcQuestion68);
        Answer mcQuestion68Answear3 = new Answer("V(x1,x2)= (x1)^2 - (x2)^2", false, mcQuestion68);
        questionsRepo.save(mcQuestion68);
        anwersRepo.save(mcQuestion68Answear0);
        anwersRepo.save(mcQuestion68Answear1);
        anwersRepo.save(mcQuestion68Answear2);
        anwersRepo.save(mcQuestion68Answear3);

        Question mcQuestion69 = new Question("Wskaż poprawne stwierdzenia dotyczącej metody ogólnej wyznaczania równań stanu (???????)", mc);
        Answer mcQuestion69Answear0 = new Answer("może zostać użyta do wyznaczania równań stanu dla elementu inercyjnego 2.rzędu", false, mcQuestion69);
        Answer mcQuestion69Answear1 = new Answer("wymaga wyznaczenia wartości pierwiastków funkcji przejścia układu", false, mcQuestion69);
        Answer mcQuestion69Answear2 = new Answer("wartości początkowe kolejnych zmiennych stanu są równe warunkom początkowym dla zmiennej wyjścia i jej pochodnych", true, mcQuestion69);
        Answer mcQuestion69Answear3 = new Answer("znajduje zastosowanie w przypadku, gdy w równaniu różniczkowym występuje pochodna zmiennej wejściowej (wymuszenia)", false, mcQuestion69);
        questionsRepo.save(mcQuestion69);
        anwersRepo.save(mcQuestion69Answear0);
        anwersRepo.save(mcQuestion69Answear1);
        anwersRepo.save(mcQuestion69Answear2);
        anwersRepo.save(mcQuestion69Answear3);

        Question mcQuestion70 = new Question("Czasowa funkcja przjeścia to czasowa odpowiedź układu na pobudzenie (odp wlasna):", mc);
        Answer mcQuestion70Answear0 = new Answer("impulsem Diraca", false, mcQuestion70);
        Answer mcQuestion70Answear1 = new Answer("skokiem jednostkowym", true, mcQuestion70);
        Answer mcQuestion80Answear2 = new Answer("sygnałem u(t) = cos(t)", false, mcQuestion70);
        Answer mcQuestion70Answear3 = new Answer("sygnałem u(t) = sin(t)", false, mcQuestion70);
        questionsRepo.save(mcQuestion70);
        anwersRepo.save(mcQuestion70Answear0);
        anwersRepo.save(mcQuestion70Answear1);
        anwersRepo.save(mcQuestion80Answear2);
        anwersRepo.save(mcQuestion70Answear3);


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
            
            Category MC_Category = new Category("MC");
            categoriesRepo.save(MC_Category);
            createMCQuiz(MC_Category, categoriesRepo, scoresRepo, quizesRepo, questionsRepo, anwersRepo);
                       
            createMCQuizPart2(MC_Category, categoriesRepo, scoresRepo, quizesRepo, questionsRepo, anwersRepo);
            createMCQuizPart3(MC_Category, categoriesRepo, scoresRepo, quizesRepo, questionsRepo, anwersRepo);
            createMCQuizPart4(MC_Category, categoriesRepo, scoresRepo, quizesRepo, questionsRepo, anwersRepo);
            createMCQuizAll(MC_Category, categoriesRepo, scoresRepo, quizesRepo, questionsRepo, anwersRepo);
        };
    }
}
