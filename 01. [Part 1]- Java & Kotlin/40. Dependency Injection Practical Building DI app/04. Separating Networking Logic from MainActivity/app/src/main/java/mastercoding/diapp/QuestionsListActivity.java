package mastercoding.diapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.LayoutInflater;

import java.util.List;

import mastercoding.diapp.detailsQuestion.QuestionDetailsViewMVC;
import mastercoding.diapp.detailsQuestion.QuestionDetialsActivity;
import mastercoding.diapp.networking.QuestionsListResponseSchema;
import mastercoding.diapp.networking.StackoverflowApi;
import mastercoding.diapp.questions.FetchQuestionDetailsUseCase;
import mastercoding.diapp.questions.FetchQuestionsListUseCase;
import mastercoding.diapp.questions.Question;
import mastercoding.diapp.questionslist.QuestionsListViewMVCImpl;
import mastercoding.diapp.questionslist.QuestionsListViewMvc;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class QuestionsListActivity extends AppCompatActivity implements
        QuestionsListViewMvc.Listener, FetchQuestionsListUseCase.Listener

{

    private static final int NUM_OF_QUESTIONS_TO_FETCH  = 20;


    private FetchQuestionsListUseCase fetchQuestionsListUseCase;

    private QuestionsListViewMvc mViewMVC;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mViewMVC = new QuestionsListViewMVCImpl(LayoutInflater.from(this), null);

        setContentView(mViewMVC.getRootView());

        // Networking
        fetchQuestionsListUseCase = new FetchQuestionsListUseCase();


    }

    @Override
    protected void onStart() {
        super.onStart();
        mViewMVC.registerListener(this);
        fetchQuestionsListUseCase.registerListener(this);

        fetchQuestionsListUseCase.fetchLastActiveQuestionsAndNotify(NUM_OF_QUESTIONS_TO_FETCH);


    }

    @Override
    protected void onStop() {
        super.onStop();
        mViewMVC.unregisterListener(this);

        fetchQuestionsListUseCase.unregisterListener(this);
    }


    @Override
    public void onFetchOfQuestionsSucceeded(List<Question> questions) {
        mViewMVC.bindQuestions(questions);


    }

    @Override
    public void onFetchOfQuestionsFailed() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .add(ServerErrorDialogFragment.newInstance(), null)
                .commitAllowingStateLoss();

    }


    @Override
    public void onQuestionClicked(Question question) {
        QuestionDetialsActivity.start(QuestionsListActivity.this, question.getId());

    }
}