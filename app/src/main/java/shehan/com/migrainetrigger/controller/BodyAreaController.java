package shehan.com.migrainetrigger.controller;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import shehan.com.migrainetrigger.data.dao.DBBodyAreaDAO;
import shehan.com.migrainetrigger.data.model.BodyArea;
import shehan.com.migrainetrigger.view.model.AnswerSectionViewData;

/**
 * Created by Shehan on 4/13/2016.
 */
public class BodyAreaController {

    public static long addBodyAreaRecord(int bodyAreaId, int recordId) {
        Log.d("BodyAreaController", " addBodyAreaRecord ");
        return DBBodyAreaDAO.addBodyAreaRecord(bodyAreaId, recordId);
    }

    public static long addBodyAreas(ArrayList<BodyArea> lst) {
        for (BodyArea itm : lst) {
            long result = addBodyArea(itm);
            if (result < 1) {
                return 0;
            }
        }
        return lst.size();
    }

    public static long addBodyArea(BodyArea bodyArea) {
        return DBBodyAreaDAO.addBodyArea(bodyArea);
    }

    public static long deleteBodyArea(int id) {
        return DBBodyAreaDAO.deleteBodyArea(id);
    }

    public static List<AnswerSectionViewData> getAnswerSectionViewData() {
        ArrayList<BodyArea> lst = getAllBodyAreas();
        List<AnswerSectionViewData> answerSectionViewDataLst = new ArrayList<>();
        for (int i = 0; i < lst.size(); i++) {
            BodyArea bodyArea = lst.get(i);

            answerSectionViewDataLst.add(new AnswerSectionViewData(bodyArea.getBodyAreaId(), bodyArea.getBodyAreaName()));
        }
        return answerSectionViewDataLst;
    }

    public static ArrayList<BodyArea> getAllBodyAreas() {
        Log.d("BodyAreaController", " getAllBodyAreas ");
        return DBBodyAreaDAO.getAllBodyAreas();
    }

    public static BodyArea getBodyAreaById(int id) {
        return DBBodyAreaDAO.getBodyArea(id);
    }

    public static ArrayList<BodyArea> getBodyAreasForRecord(int recordId) {
        return DBBodyAreaDAO.getBodyAreasForRecord(recordId);
    }

    public static int getLastRecordId() {
        return DBBodyAreaDAO.getLastRecordId();
    }

    public static long updateBodyAreaRecord(BodyArea bodyArea) {
        return DBBodyAreaDAO.updateBodyAreaRecord(bodyArea);
    }
}
