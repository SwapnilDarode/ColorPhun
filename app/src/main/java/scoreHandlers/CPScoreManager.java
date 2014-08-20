package scoreHandlers;


import android.content.Context;

import java.util.ArrayList;

import scoreHandlers.ScoreModels.CPScore;

/**
 * Created by ekhamees on 8/20/14.
 */
public class CPScoreManager {

    boolean TOPSCORES = false;
    boolean HIGHSCORE = true;


    Context mContext;

    DBHandler dbHandler;

    /**
     * Constructor for Scrore Manager
     * @param context
     */
    public CPScoreManager(Context context) {

        this.mContext = context;
        this.dbHandler = new DBHandler(this.mContext);
    }

    /**
     * Get Top Scores
     * @return Array of Top scores
     */

    public ArrayList<CPScore> getTopScores()
    {
        return  dbHandler.getScoreCards(TOPSCORES);
    }

    /**
     * Get High Score
     * @return High score
     */

    public CPScore getHighScore()
    {
        ArrayList<CPScore> highScorer = dbHandler.getScoreCards(HIGHSCORE);

        if(highScorer!=null)
            return highScorer.get(0);

        return null;
    }

    public void updateScores(ArrayList<CPScore> scores)
    {
        this.dbHandler.tuncateScores();

        if(scores!=null && scores.size()>0)
        {
            for (CPScore score : scores)
            {
                this.dbHandler.addScrore(score);
            }
        }
    }

}
