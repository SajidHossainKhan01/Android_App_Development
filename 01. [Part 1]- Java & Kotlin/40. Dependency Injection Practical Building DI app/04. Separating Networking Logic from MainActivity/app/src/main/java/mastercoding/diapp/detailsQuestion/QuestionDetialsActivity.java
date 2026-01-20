package mastercoding.diapp.detailsQuestion;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;

import mastercoding.diapp.Constants;
import mastercoding.diapp.ServerErrorDialogFragment;
import mastercoding.diapp.networking.SingleQuestionResponseSchema;
import mastercoding.diapp.networking.StackoverflowApi;
import mastercoding.diapp.questions.FetchQuestionDetailsUseCase;
import mastercoding.diapp.questions.FetchQuestionsListUseCase;
import mastercoding.diapp.questions.QuestionWithBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class QuestionDetialsActivity extends AppCompatActivity implements
        QuestionDetailsViewMVC.Listener , FetchQuestionDetailsUseCase.Listener {

    public static final String EXTRA_QUESTION_ID = "EXTRA_QUESTION_ID";

    public static void start(Context context, String questionId) {
        Intent i = new Intent(context, QuestionDetialsActivity.class);
        i.putExtra(EXTRA_QUESTION_ID, questionId);
        context.startActivity(i);
    }


    private String mQuestionId;
    private QuestionDetailsViewMVC mViewMvc;

    private FetchQuestionDetailsUseCase fetchQuestionDetailsUseCase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mViewMvc = new QuestionDetailsViewMvcImpl(LayoutInflater.from(this), null);
        setContentView(mViewMvc.getRootView());



        // Networking
        fetchQuestionDetailsUseCase = new FetchQuestionDetailsUseCase();

        mQuestionId = getIntent().getExtras().getString(EXTRA_QUESTION_ID);

    }


    @Override
    protected void onStart() {
        super.onStart();
        mViewMvc.registerListener(this);

        fetchQuestionDetailsUseCase.registerListener(this);
        fetchQuestionDetailsUseCase.fetchQuestionDetailsAndNotify(mQuestionId);
    }

    @Override
    protected void onStop() {
        super.onStop();
        mViewMvc.unregisterListener(this);

        fetchQuestionDetailsUseCase.unregisterListener(this);
    }


    @Override
    public void onFetchOfQuestionDetailsSucceeded(QuestionWithBody question) {

        mViewMvc.bindQuestion(question);
    }

    @Override
    public void onFetchOfQuestionDetailsFailed() {

        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .add(ServerErrorDialogFragment.newInstance(), null)
                .commitAllowingStateLoss();
    }
}


// We have done:

// 1- Decoupling UI Logic from Main Activity (QuestionsListActivity)
// 2- Decoupling Netwoking  Logic from Main Activity

// next Steps:
// Start Using Dagger for Dependency Injection!  !!!!!
