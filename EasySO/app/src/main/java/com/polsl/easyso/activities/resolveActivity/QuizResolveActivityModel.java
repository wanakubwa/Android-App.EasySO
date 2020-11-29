package com.polsl.easyso.activities.resolveActivity;

import com.polsl.easyso.activities.resolveActivity.components.StatisticsComponent;
import com.polsl.easyso.activities.resolveActivity.fragments.QuizLearnFragment;
import com.polsl.easyso.activities.resolveActivity.fragments.QuizResolveFragmentBase;
import com.polsl.easyso.activities.resolveActivity.fragments.QuizTestFragement;
import com.polsl.easyso.activities.resolveActivity.listeners.OnModelCollectionChangedListener;
import com.polsl.easyso.activities.resolveActivity.listeners.OnModelInitializedListener;
import com.polsl.easyso.activities.resolveActivity.listeners.OnStatisticsChangedListener;
import com.polsl.easyso.adapters.spinners.items.QuizResolveSpinnerItem;
import com.polsl.easyso.services.QuizServices;
import com.polsl.easyso.services.RetrofitClientFacade;
import com.polsl.easyso.services.dto.QuestionTopicDTO;
import com.polsl.easyso.services.dto.question.AnswerDTO;
import com.polsl.easyso.services.dto.question.QuestionDTO;
import com.polsl.easyso.services.dto.question.QuizDTO;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class QuizResolveActivityModel {

    private QuestionTopicDTO currentTopic;
    private OnModelInitializedListener onModelInitializedHandler;
    private OnModelCollectionChangedListener onModelCollectionChanged;
    private OnStatisticsChangedListener onStatisticsChangedHandler;

    private List<QuestionDTO> allQuestionsCollection = new ArrayList<>();
    private List<QuestionDTO> currentVisibleQuestions = new ArrayList<>();
    private QuizResolveFragmentBase[] quizFragmentsCollection;

    private StatisticsComponent statistics;

    public QuizResolveActivityModel(QuestionTopicDTO currentTopic) {
        this.currentTopic = currentTopic;

        // Inicjalizacja kolekcji fragmentow.
        buildQuizFragmentsCollection();
    }

    public List<QuestionDTO> getAllQuestionsCollection() {
        return allQuestionsCollection;
    }

    public void setOnModelCollectionChanged(OnModelCollectionChangedListener onModelCollectionChanged) {
        this.onModelCollectionChanged = onModelCollectionChanged;
    }

    public void setOnStatisticsChanged(OnStatisticsChangedListener onStatisticsChangedListener) {
        this.onStatisticsChangedHandler = onStatisticsChangedListener;
    }

    public void setOnModelInitializedHandler(OnModelInitializedListener onModelInitializedHandler) {
        this.onModelInitializedHandler = onModelInitializedHandler;
    }

    public List<QuestionDTO> getCurrentVisibleQuestions() {
        return currentVisibleQuestions;
    }

    public void setCurrentVisibleQuestions(List<QuestionDTO> currentVisibleQuestions) {
        this.currentVisibleQuestions = currentVisibleQuestions;

    }

    public StatisticsComponent getStatistics() {
        return statistics;
    }

    public QuestionTopicDTO getCurrentTopic() {
        return currentTopic;
    }

    public QuizResolveFragmentBase[] getQuizFragmentsCollection(){
        return quizFragmentsCollection;
    }

    public QuizResolveSpinnerItem[] getQuizResolveSpinnerItems(){
        QuizResolveSpinnerItem[] output = new QuizResolveSpinnerItem[quizFragmentsCollection.length];

        for (int i =0; i < quizFragmentsCollection.length; i++){
            output[i] = new QuizResolveSpinnerItem(quizFragmentsCollection[i].getOptionName(), quizFragmentsCollection[i].getFragmentType());
        }

        return output;
    }

    public void setCurrentTopic(QuestionTopicDTO currentTopic) {
        this.currentTopic = currentTopic;
    }

    public QuizResolveFragmentBase getQuizFragmentByTypeLabel(QuizResolveFragmentBase.TypeLabel typeLabel) {
        QuizResolveFragmentBase output = null;
        for(QuizResolveFragmentBase fragmentBase : quizFragmentsCollection){
            if(fragmentBase.getFragmentType() == typeLabel){
                output = fragmentBase;
            }
        }

        return output;
    }

    public void initialize() {
        statistics = new StatisticsComponent();

        QuizServices retrofitClient = RetrofitClientFacade.getRetrofitInstance().create(QuizServices.class);
        final Call<QuizDTO> currentQuiz = retrofitClient.getQuizForTopic(currentTopic.getLabel());
        currentQuiz.enqueue(new Callback<QuizDTO>() {

            @Override
            public void onResponse(Call<QuizDTO> call, Response<QuizDTO> response) {
                allQuestionsCollection = response.body().getQuestionsCollection();
                onModelInitializedHandler.onInitializedSuccess();
            }

            @Override
            public void onFailure(Call<QuizDTO> call, Throwable throwable) {
            }
        });
    }

    // Ta metoda jest po prostu okropna.
    public List<QuestionDTO> getRandomQuestionsAmmount(int ammount) {
        currentVisibleQuestions.clear();
        currentVisibleQuestions = getRandomQuestions(ammount);
        return currentVisibleQuestions;
    }

    public void refreshCurrentQuestions(int ammount) {
        currentVisibleQuestions.clear();
        currentVisibleQuestions = getRandomQuestions(ammount);
        onModelCollectionChanged.onCollectionChanged();
    }

    // Definicje wszytskich fragmentow na widoku.
    private void buildQuizFragmentsCollection() {
        quizFragmentsCollection = new QuizResolveFragmentBase[]{
                new QuizTestFragement(),
                new QuizLearnFragment()
        };
    }

    private List<QuestionDTO> getRandomQuestions(int ammount){

        Random rand = new Random();
        List<QuestionDTO> randomQuestions = new ArrayList<>();

        List<Integer> avaibleIndexes = new ArrayList<>();
        for(int i =0; i< allQuestionsCollection.size(); i++){
            avaibleIndexes.add(i);
        }

        for(int i = 0; i < ammount; i++) {
            if(avaibleIndexes.size() < 1){
                break;
            }

            int ranodmIndex = rand.nextInt(avaibleIndexes.size());

            // Glebokie kopiowanie oryginalnych elementow.
            randomQuestions.add(new QuestionDTO(allQuestionsCollection.get(avaibleIndexes.get(ranodmIndex))));
            randomQuestions.get(i).shuffleAnswers();
            avaibleIndexes.remove(ranodmIndex);
        }

        return randomQuestions;
    }

    public void updateQuestionAnswerStatus(int questionId, int answerId) {
        QuestionDTO currentVisibleQuestion = getDisplayedQuestionById(questionId);
        if(currentVisibleQuestion == null){
            throw new InvalidParameterException();
        }

        AnswerDTO selectedAnswer = currentVisibleQuestion.getAnswerById(answerId);
        if(selectedAnswer == null){
            throw new InvalidParameterException();
        }

        selectedAnswer.setIsUserSelect(!selectedAnswer.getIsUserSelect());
    }

    public QuestionDTO getDisplayedQuestionById(int questionId) {

        QuestionDTO output = null;

        for(QuestionDTO question : currentVisibleQuestions){
            if(question.getId() == questionId){
                output = question;
                break;
            }
        }

        return output;
    }

    public void validateDisplayedQuestions(){
        boolean canCheckStatistics = true;

        for(QuestionDTO question : currentVisibleQuestions){
            for(AnswerDTO answer : question.getAnswers()) {
                if(answer.getCurrentStatus() != AnswerDTO.Status.NONE){
                    canCheckStatistics = false;
                }

                if(answer.isUserCheckCorrect() == true){
                    answer.setCurrentStatus(AnswerDTO.Status.CORRECT);
                }
                else{
                    answer.setCurrentStatus(AnswerDTO.Status.INCORRECT);
                }
            }
        }

        if(canCheckStatistics == true){
            tryUpdateStatisticsData();
        }

        onModelCollectionChanged.onCollectionChanged();
    }

    private void tryUpdateStatisticsData() {
        for(QuestionDTO question : currentVisibleQuestions){
            for(AnswerDTO answer : question.getAnswers()) {
                if(answer.getCurrentStatus() == AnswerDTO.Status.CORRECT){
                    statistics.increaseCorrectAnswer();
                }
                else{
                    statistics.increaseInCorrectAnswers();
                }
            }

            statistics.increaseQuestions();
        }

        onStatisticsChangedHandler.onStatisticsChanged();
    }
}
