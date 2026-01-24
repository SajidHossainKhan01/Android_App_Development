package mastercoding.diapp.networking;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import mastercoding.diapp.questions.Question;

public class QuestionsListResponseSchema {
    @SerializedName("items")
    private final List<Question> mQuestions;

    public QuestionsListResponseSchema(List<Question> questions){
        mQuestions = questions;
    }

    public List<Question> getQuestions() {
        return mQuestions;
    }
}
