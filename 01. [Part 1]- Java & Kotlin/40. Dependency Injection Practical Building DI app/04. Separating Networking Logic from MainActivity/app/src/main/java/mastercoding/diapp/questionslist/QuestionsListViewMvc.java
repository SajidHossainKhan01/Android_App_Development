package mastercoding.diapp.questionslist;

import java.util.List;

import mastercoding.diapp.questions.Question;

public interface QuestionsListViewMvc extends ObservableViewMvc<QuestionsListViewMvc.Listener> {
    interface Listener {
        void onQuestionClicked(Question question);
    }
    void bindQuestions(List<Question> questions);
}
