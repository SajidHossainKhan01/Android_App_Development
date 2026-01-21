package mastercoding.diapp.networking;

import com.google.gson.annotations.SerializedName;

import java.util.Collections;
import java.util.List;

import mastercoding.diapp.questions.QuestionWithBody;

public class SingleQuestionResponseSchema {
    @SerializedName("items")
    private final List<QuestionWithBody> mQuestions;

    public SingleQuestionResponseSchema(QuestionWithBody questions) {
        mQuestions = Collections.singletonList(questions);
    }

    public QuestionWithBody getQuestions() {
        return mQuestions.get(0);
    }
}
