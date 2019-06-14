package com.ivanbudos.kvizkolegija;

import android.support.annotation.Size;

import java.util.ArrayList;

public final class AllQuestions {

    private AllQuestions(){} //NE MOŽE SE INSTANCIRATI HEHE

    public static String[] questionsQuiz1 = {
            "HTML je kratica za...",
            "Odaberi string s najvećim fontom.",
            "HTML je...",
            "Dvije važne kategorije elemenata u HTMLu?"};

    public static String[] questionsQuiz2 = {
            "Što predstavlja URL kratica?",
            "Putanja može biti Apsolutna i ...",
            "Što omogućava povezivanje dokumenta i resursa?",
            "Kada postoji potreba da se neki sadžaj proteše kroz više redova/ stupaca, koristimo:"
    };

    public static String[] questionsQuiz3 = {
            "Koje je osnovna klasa za UI kontrolu android aplikacije?",
            "Za UI kontrolu tekstualnog sadržaja koristimo...",
            "Wrap content ili Match...",
            "ActivitiMain.class svoj izgled ima definira u..."
    };

    public static String[] questionsQuiz4 = {
            "Što koristimo za prikazivanje veće količine podataka u obliku liste koju je moguće pomicati gore/dolje?",
            "Prije dodavanja RecyclerViewa potrebno je komponentu u projekt dodati preko...",
            "RecyclerView komponentu koja se koristi za prikaz podataka potrebno je dodati u...",
            "Što je korišteno u ovom projektu?"
    };

    public static String[][] posibleAnswersQuiz1 = {
            {"Hyper Tuner Mama Ljama","Hyper Text Markup Language","Hype Toons Microsoftz Life","Hippo Tone Micro Loop"},
            {"<h3>String<h3>","<h3>Hello<h2>","<h1>Text<h1>","<h2>Title<h2>"},
            {"Programski jezik","Znakovni jezik","Nije jezik","Opisni jezik"},
            {"linijski i blok","blok i radni","linijski i kućanski","radni i sporedni"}
    };

    public static String[][] posibleAnswersQuiz2 = {
            {"Ultra Rapid Lube","Uniform Resource Locator","Ultron tock Line","Upper Resource Look"},
            {"Neapsolutna","Relatistična","Relativna","Direktna"},
            {"Autoputi","Dretve","Linkovi","Hiperveze"},
            {"rowspan i colspan","throughtrow i throughtcol","rowmerge i colmerge","row i collumn"}
    };

    public static String[][] posibleAnswersQuiz3 = {
            {"Layout","View","XML","Ekran"},
            {"TextEditor","NewText","TextView","Ništa od navedenog"},
            {"MatchScreen","MatchPrevious","Match1","MatchParent"},
            {"activity_main.xml fileu","activity_main.css fileu","u sebi","colors.xml"}
    };

   public static String[][] posibleAnswersQuiz4 = {
            {"ViewHolder","RecyclerView","Fragmente","To je nemoguće izvesti"},
            {"Skripte","Dodatnog programa","Gradle skripte","Linka"},
            {"fragment1.xml","Fragment1.class","MainActivity.class","activity_main.xml"},
            {"Fragmenti","Više activitya","RecyclerView","HTML"}
    };

    public static int[] rightAnswersQuiz1 = {2,3,4,1};
    public static int[] rightAnswersQuiz2 = {2,3,4,1};
    public static int[] rightAnswersQuiz3 = {2,3,4,1};
    public static int[] rightAnswersQuiz4 = {2,3,4,1};
}
