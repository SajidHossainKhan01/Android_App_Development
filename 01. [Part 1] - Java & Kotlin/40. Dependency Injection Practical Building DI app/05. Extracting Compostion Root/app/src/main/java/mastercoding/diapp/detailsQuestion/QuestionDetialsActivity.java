package mastercoding.diapp.detailsQuestion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;

import mastercoding.diapp.MyApplication;
import mastercoding.diapp.common.DialogsManager;
import mastercoding.diapp.common.ServerErrorDialogFragment;
import mastercoding.diapp.networking.StackoverflowApi;
import mastercoding.diapp.questions.FetchQuestionDetailsUseCase;
import mastercoding.diapp.questions.QuestionWithBody;
import retrofit2.Retrofit;

public class QuestionDetialsActivity extends AppCompatActivity implements
        QuestionDetailsViewMVC.Listener , FetchQuestionDetailsUseCase.Listener {

    public static final String EXTRA_QUESTION_ID = "EXTRA_QUESTION_ID";


    private DialogsManager mDialogsManager;


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
        fetchQuestionDetailsUseCase = ((MyApplication) getApplication()).getCompositionRoot().getfetchQuestionDetailsUseCase();





        mQuestionId = getIntent().getExtras().getString(EXTRA_QUESTION_ID);

        // Dialog error
        mDialogsManager = new DialogsManager(getSupportFragmentManager());

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

        mDialogsManager.showRetainedDialogWithId(ServerErrorDialogFragment.newInstance(), "");
    }
}


// We have done:

// 1- Decoupling UI Logic from Main Activity (QuestionsListActivity)
// 2- Decoupling Netwoking  Logic from Main Activity

// next Steps:
// Start Using Dagger for Dependency Injection!  !!!!!
