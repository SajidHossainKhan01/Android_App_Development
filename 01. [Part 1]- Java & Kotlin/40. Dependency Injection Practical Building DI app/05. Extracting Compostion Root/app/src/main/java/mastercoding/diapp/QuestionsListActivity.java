package mastercoding.diapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;

import java.util.List;
import java.util.Stack;

import mastercoding.diapp.common.DialogsManager;
import mastercoding.diapp.common.ServerErrorDialogFragment;
import mastercoding.diapp.detailsQuestion.QuestionDetialsActivity;
import mastercoding.diapp.networking.StackoverflowApi;
import mastercoding.diapp.questions.FetchQuestionsListUseCase;
import mastercoding.diapp.questions.Question;
import mastercoding.diapp.questionslist.QuestionsListViewMVCImpl;
import mastercoding.diapp.questionslist.QuestionsListViewMvc;
import retrofit2.Retrofit;

public class QuestionsListActivity extends AppCompatActivity implements
        QuestionsListViewMvc.Listener, FetchQuestionsListUseCase.Listener
{
    private static final int NUM_OF_QUESTIONS_TO_FETCH  = 20;
    private FetchQuestionsListUseCase fetchQuestionsListUseCase;
    private QuestionsListViewMvc mViewMVC;

    // Dialog Fragments
    private DialogsManager mDialogsManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mViewMVC = new QuestionsListViewMVCImpl(LayoutInflater.from(this), null);

        setContentView(mViewMVC.getRootView());

        // Networking

        fetchQuestionsListUseCase = ((MyApplication) getApplication()).getCompositionRoot().getfetchQuestionsListUseCase();



        // dialog mangaer
        mDialogsManager = new DialogsManager(getSupportFragmentManager());

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

        mDialogsManager.showRetainedDialogWithId(ServerErrorDialogFragment.newInstance(), "");

    }


    @Override
    public void onQuestionClicked(Question question) {
        QuestionDetialsActivity.start(QuestionsListActivity.this, question.getId());

    }
}