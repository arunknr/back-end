package shareForcast.model.reqResModels;

import shareForcast.model.ShareKeyword;

import java.util.ArrayList;
import java.util.List;

public class KeywordsResponse {
    List<ShareKeyword> shareKeywordList = new ArrayList<>();

    public KeywordsResponse(List<ShareKeyword> shareKeywordList) {
        this.shareKeywordList = shareKeywordList;
    }

    public List<ShareKeyword> getShareKeywordList() {
        return shareKeywordList;
    }

    public void setShareKeywordList(List<ShareKeyword> shareKeywordList) {
        this.shareKeywordList = shareKeywordList;
    }

    @Override
    public String toString() {
        return "KeywordsResponse{" +
                "shareKeywordList=" + shareKeywordList +
                '}';
    }
}
