package com.example.U1M4SummativeLealAbraham.controller;

import com.example.U1M4SummativeLealAbraham.model.Answer;
import com.example.U1M4SummativeLealAbraham.model.Definition;
import com.example.U1M4SummativeLealAbraham.model.Quote;
import com.example.U1M4SummativeLealAbraham.model.QuoteCatalog;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


@RestController
public class U1M4SummativeController {

    @RequestMapping(value = "/quote", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public Quote getQuote() throws IOException {

        //Instantiate Quote catalog class
        QuoteCatalog quotes = new QuoteCatalog();

        //Set newly populated arrayList as QuoteCatalog attribute
        quotes.setQuotes(helperQuoteArrayListLoader());

        //Call on random quote from array - QuoteCatalog method
        return quotes.getRandomQuote();
    }


    @RequestMapping(value = "/word", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public Definition getWord() throws IOException {

        //Instantiate an arrayList for definition objects
        List<Definition> randomWords = new ArrayList<>();

        //Load arrayList using helper method
        randomWords = helperDefinitionListLoader();

        //Random generator for selecting a word
        Random random = new Random();

        //Returns a random word from the randomWords arrayList
        Definition definition = randomWords.get(random.nextInt(randomWords.size()));
        return definition;
    }

    @RequestMapping(value = "/magic", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.OK)
    public Answer magic8ball(@RequestBody Answer userQuestion) throws Exception {
        if (userQuestion.getQuestion() != null) {
            Answer answer = new Answer();
        List<Answer> eightBallAnswers = helper8BallAnswerLoader();

        //Returns question recieved to answer object to be returned
        answer.setQuestion(userQuestion.getQuestion());

        //Random generator instantiation
        Random random = new Random();

        //Returns a random answer from the eightBallAnswers arrayList
        answer.setAnswer(eightBallAnswers.get(random.nextInt(eightBallAnswers.size())).getAnswer());

        return answer;
    } else
            throw new Exception ("Must provide a valid question for the magic 8 ball!");

    }

    /*******************************************************************************************
     *
     * Below are helper methods to provide in memory data to this webservice. Also provided in
     * comments are examples of how this could be accomplished by importing data from a json file.
     *
     *******************************************************************************************/

    List<Answer> helper8BallAnswerLoader() {
        List<Answer> answers = new ArrayList<>();
        Answer answer = new Answer();
        answer.setQuestion("Will I be rich?");
        answer.setAnswer("It is certain.");
        answers.add(answer);

        Answer answer1 = new Answer();
        answer1.setQuestion("Will I find true love?");
        answer1.setAnswer("It is decidedly so.");
        answers.add(answer1);

        Answer answer2 = new Answer();
        answer2.setQuestion("Will I win the lottery?");
        answer2.setAnswer("Without a doubt.");
        answers.add(answer2);

        Answer answer3 = new Answer();
        answer3.setQuestion("Will I recieve a paid vacation soon?");
        answer3.setAnswer("Yes - definitely.");
        answers.add(answer3);

        Answer answer4 = new Answer();
        answer4.setQuestion("Will I die soon?");
        answer4.setAnswer("You may rely on it");
        answers.add(answer4);

        Answer answer5 = new Answer();
        answer5.setQuestion("Will I retire early?");
        answer5.setAnswer("As I see it, yes.");
        answers.add(answer5);

        Answer answer6 = new Answer();
        answer6.setQuestion("Will Cognizant hire me?");
        answer6.setAnswer("Reply hazy, try again.");
        answers.add(answer6);

        Answer answer7 = new Answer();
        answer7.setQuestion("Will this web server crash?");
        answer7.setAnswer("Ask again later.");
        answers.add(answer7);


        Answer answer8 = new Answer();
        answer8.setQuestion("Will my wife be a millionaire?");
        answer8.setAnswer("Don't count on it.");
        answers.add(answer8);

        Answer answer9 = new Answer();
        answer9.setQuestion("Will you go out with me?");
        answer9.setAnswer("My reply is no.");
        answers.add(answer9);

        Answer answer10 = new Answer();
        answer10.setQuestion("Will I win the World Cup?");
        answer10.setAnswer("Outlook not so good.");
        answers.add(answer10);

//        An easier approach to populating an arrayList for this program is shown below:

//        ----Create arrayList to feed into Quote catalog class
//        List<Answer> eightBallAnswers = new ArrayList<>();
//
//        ----Populate arrayList via json file
//        Scanner in = new Scanner(System.in);
//        ObjectMapper mapper = new ObjectMapper();
//        eightBallAnswers = mapper.readValue(new File("answers.json"), new TypeReference<List<Answer>>() {});

        return answers;
    }

    List<Definition> helperDefinitionListLoader() {
        List<Definition> randomWords = new ArrayList<>();

        Definition definition = new Definition();
        definition.setWord("punditocracy");
        definition.setDefinition("influential media pundits collectively");
        randomWords.add(definition);

        Definition definition1 = new Definition();
        definition1.setWord("hierarchy");
        definition1.setDefinition("any system of persons or things ranked one above another ");
        randomWords.add(definition1);

        Definition definition2 = new Definition();
        definition2.setWord("contingency");
        definition2.setDefinition("dependence on chance or on the fulfillment of a condition; uncertainty; " +
                "fortuitousness.  a chance, accident, or possibility conditional on something uncertain. " +
                "Something incidental to a thing.");
        randomWords.add(definition2);

        Definition definition3 = new Definition();
        definition3.setWord("quantitative");
        definition3.setDefinition("that is or may be estimated by quantity; of or relating to the describing " +
                "or measuring of quantity; of or relating to a metrical system, as that of classical verse, " +
                "based on the alternation of long and short, rather than accented and unaccented, syllables; " +
                "of or relating to the length of a spoken vowel or consonant.");
        randomWords.add(definition3);

        Definition definition4 = new Definition();
        definition4.setWord("normalization");
        definition4.setDefinition("to make normal; to establish or resume (relations) " +
                "in a normal manner, as between countries; Metallurgy. to heat (a steel alloy) to a suitable" +
                " temperature above the transformation range and then to cool in still air at ambient temperature.");
        randomWords.add(definition4);

        Definition definition5 = new Definition();
        definition5.setWord("iteration");
        definition5.setDefinition("the act of repeating; a repetition. Mathematics. Also called successive " +
                "approximation. a problem-solving or computational method in which a succession of approximations, " +
                "each building on the one preceding, is used to achieve a desired degree of accuracy; an instance " +
                "of the use of this method. Computers.a repetition of a statement or statements in a program: " +
                "a different version of an existing data set, software program, hardware device, etc. A new iteration " +
                "of the data will be released next month; a different form or version of something");
        randomWords.add(definition5);

        Definition definition6 = new Definition();
        definition6.setWord("orthodox");
        definition6.setDefinition("of, relating to, or conforming to the approved form of any doctrine, " +
                "philosophy, ideology, etc; of, relating to, or conforming to beliefs, attitudes, or modes of " +
                "conduct that are generally approved; customary or conventional, as a means or method; established; " +
                "sound or correct in opinion or doctrine, especially theological or religious doctrine; conforming " +
                "to the Christian faith as represented in the creeds of the early church; (initial capital letter) of, " +
                "relating to, or designating the Eastern Church, especially the Greek Orthodox Church.");
        randomWords.add(definition6);

        Definition definition7 = new Definition();
        definition7.setWord("corporation");
        definition7.setDefinition("an association of individuals, created by law or under authority of law, " +
                "having a continuous existence independent of the existences of its members, and powers and " +
                "liabilities distinct from those of its members.See also municipal corporation, public corporation; " +
                "(initial capital letter) the group of principal officials of a borough or other municipal division " +
                "in England; any group of persons united or regarded as united in one body; Informal. a paunch; potbelly.");
        randomWords.add(definition7);

        Definition definition8 = new Definition();
        definition8.setWord("diversity");
        definition8.setDefinition("the state or fact of being diverse; difference; unlikeness; diversity of opinion; " +
                "variety; multiformity; the inclusion of individuals representing more than one national origin," +
                " color, religion, socioeconomic stratum, sexual orientation, etc.; diversity in the workplace; a" +
                " point of difference.");
        randomWords.add(definition8);

        Definition definition9 = new Definition();
        definition9.setWord("disinformation");
        definition9.setDefinition("false information, as about a country's military strength or plans, " +
                "disseminated by a government or intelligence agency in a hostile act of tactical political subversion: " +
                "Soviet disinformation drove a wedge between the United States and its Indonesian allies; deliberately" +
                " misleading or biased information; manipulated narrative or facts; propaganda: Special interest " +
                "groups muddied the waters of the debate, spreading disinformation on social media.");
        randomWords.add(definition9);

        Definition definition10 = new Definition();
        definition10.setWord("gentrification");
        definition10.setDefinition("he buying and renovation of houses and stores in deteriorated urban " +
                "neighborhoods by upper- or middle-income families or individuals, raising property " +
                "values but often displacing low-income families and small businesses; the process " +
                "of conforming to an upper- or middle-class lifestyle, or of making a product, activity, etc., " +
                "appealing to those with more affluent tastes: the gentrification of fashion.");
        randomWords.add(definition10);

        return randomWords;

//       Easier way to load Definition arrayList shown below
//        -----Create arrayList of Definitions
//        List<Definition> randomWords = new ArrayList<>();
//
//        ----Populate arrayList via json file
//        Scanner in = new Scanner(System.in);
//        ObjectMapper mapper = new ObjectMapper();
//        randomWords = mapper.readValue(new File("words.json"), new TypeReference<List<Definition>>() {
//        });
    }


    List<Quote> helperQuoteArrayListLoader() {
        List<Quote> quotes = new ArrayList<>();

        Quote quote = new Quote();
        quote.setAuthor("Steve Jobs");
        quote.setQuote("Your work is going to fill a large part of your life, and the only way to be truly satisfied " +
                "is to do what you believe is great work. And the only way to do great work is to love what you do. " +
                "If you haven't found it yet, keep looking. Don't settle. As with all matters of the heart, you'll" +
                " know when you find it.");
        quotes.add(quote);

        Quote quote1 = new Quote();
        quote1.setAuthor("Henry David Thoreau");
        quote1.setQuote("If a man does not keep pace with his companions, perhaps it is because he hears a different " +
                "drummer. Let him step to the music which he hears, however measured or far away.");
        quotes.add(quote1);

        Quote quote2 = new Quote();
        quote2.setAuthor("Bruce Lee");
        quote2.setQuote("If you always put limit on everything you do, physical or anything else. It will spread into " +
                "your work and into your life. There are no limits. There are only plateaus, and you must not stay " +
                "there, you must go beyond them.");
        quotes.add(quote2);

        Quote quote3 = new Quote();
        quote3.setAuthor("Ralph Waldo Emerson");
        quote3.setQuote("What lies behind you and what lies in front of you, pales in comparison to what lies " +
                "inside of you.");
        quotes.add(quote3);

        Quote quote4 = new Quote();
        quote4.setAuthor("Warren Buffett");
        quote4.setQuote("Someone is sitting in the shade today because someone planted a tree a long time ago.");
        quotes.add(quote4);

        Quote quote5 = new Quote();
        quote5.setAuthor("e. e. cummings");
        quote5.setQuote("Once we believe in ourselves, we can risk curiosity, wonder, spontaneous delight, or any" +
                " experience that reveals the human spirit.");
        quotes.add(quote5);

        Quote quote6 = new Quote();
        quote6.setAuthor("Lao Tzu");
        quote6.setQuote("Health is the greatest possession. Contentment is the greatest treasure. Confidence " +
                "is the greatest friend. Non-being is the greatest joy.");
        quotes.add(quote6);

        Quote quote7 = new Quote();
        quote7.setAuthor("Isaac Newton");
        quote7.setQuote("If I have seen further than others, it is by standing upon the shoulders of giants.");
        quotes.add(quote7);

        Quote quote8 = new Quote();
        quote8.setAuthor("Johann Wolfgang von Goethe");
        quote8.setQuote("Every day we should hear at least one little song, read one good poem, see one exquisite " +
                "picture, and, if possible, speak a few sensible words.");
        quotes.add(quote8);

        Quote quote9 = new Quote();
        quote9.setAuthor("Democritus");
        quote9.setQuote("Happiness resides not in possessions, and not in gold, happiness dwells in the soul.");
        quotes.add(quote9);

//        -------Create arrayList to feed into Quote catalog class
//        List<Quote> randomQuotes = new ArrayList<>();
//
//        --------Populate arrayList via json file
//        Scanner in = new Scanner(System.in);
//        ObjectMapper mapper = new ObjectMapper();
//        randomQuotes = mapper.readValue(new File("quotes.json"), new TypeReference<List<Quote>>() {
//        });
        return quotes;
    }

}
